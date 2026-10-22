package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    private final char[] mEmojiCharArray;
    private final MetadataList mMetadataList;
    private final Node mRootNode;
    private final Typeface mTypeface;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Node {
        private final SparseArray<Node> mChildren;
        private TypefaceEmojiRasterizer mData;

        private Node() {
            this(1);
        }

        public final TypefaceEmojiRasterizer getData() {
            return this.mData;
        }

        public Node(int r100) {
            this.mChildren = new SparseArray(r100);
        }

        public Node get(int r100) {
            SparseArray<Node> r101 = this.mChildren;
            if (r101 != null) goto L6;
            return null;
        L6:
            return r101.get(r100);
        }

        public void put(TypefaceEmojiRasterizer r100, int r101, int r102) {
            Node r103 = get(r100.getCodepointAt(r101));
            if (r103 != null) goto L5;
            r103 = new Node();
            this.mChildren.put(r100.getCodepointAt(r101), r103);
        L5:
            if (r102 <= r101) goto L7;
            r103.put(r100, r101 + 1, r102);
            return;
        L7:
            r103.mData = r100;
        }
    }

    public int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    public Node getRootNode() {
        return this.mRootNode;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    private void constructIndex(MetadataList r100) {
        int r101 = r100.listLength();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        TypefaceEmojiRasterizer r103 = new TypefaceEmojiRasterizer(this, r102);
        Character.toChars(r103.getId(), this.mEmojiCharArray, r102 * 2);
        put(r103);
        r102 = r102 + 1;
        goto L3
    }

    public static MetadataRepo create(Typeface r100) {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r101 = new MetadataRepo(r100, new MetadataList());     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r101;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public void put(TypefaceEmojiRasterizer r100) {
        Preconditions.checkNotNull(r100, "emoji metadata cannot be null");
        if (r100.getCodepointsLength() <= 0) goto L5;
        boolean r101 = true;
    L6:
        Preconditions.checkArgument(r101, "invalid metadata codepoint length");
        this.mRootNode.put(r100, 0, r100.getCodepointsLength() - 1);
        return;
    L5:
        r101 = false;
        goto L6
    }

    private MetadataRepo(Typeface r100, MetadataList r101) {
        this.mTypeface = r100;
        this.mMetadataList = r101;
        this.mRootNode = new Node(1024);
        this.mEmojiCharArray = new char[r101.listLength() * 2];
        constructIndex(r101);
    }

    public static MetadataRepo create(AssetManager r100, String r101) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r102 = new MetadataRepo(Typeface.createFromAsset(r100, r101), MetadataListReader.read(r100, r101));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r102;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public static MetadataRepo create(Typeface r100, InputStream r101) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r102 = new MetadataRepo(r100, MetadataListReader.read(r101));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r102;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public static MetadataRepo create(Typeface r100, ByteBuffer r101) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r102 = new MetadataRepo(r100, MetadataListReader.read(r101));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r102;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }
}
