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

/* JADX INFO: loaded from: classes.dex */
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    private final char[] mEmojiCharArray;
    private final MetadataList mMetadataList;
    private final Node mRootNode;
    private final Typeface mTypeface;

    static class Node {
        private final SparseArray<Node> mChildren;
        private EmojiMetadata mData;

        private Node() {
            this(1);
        }

        Node(int r2) {
            this.mChildren = new SparseArray(r2);
        }

        Node get(int r1) {
            SparseArray<Node> r0 = this.mChildren;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.get(r1);
        }

        final EmojiMetadata getData() {
            return this.mData;
        }

        void put(EmojiMetadata r3, int r4, int r5) {
            Node r0 = get(r3.getCodepointAt(r4));
            if (r0 != null) goto L5;
            r0 = new Node();
            this.mChildren.put(r3.getCodepointAt(r4), r0);
        L5:
            if (r5 <= r4) goto L7;
            r0.put(r3, r4 + 1, r5);
            return;
        L7:
            r0.mData = r3;
        }
    }

    private MetadataRepo(Typeface r2, MetadataList r3) {
        this.mTypeface = r2;
        this.mMetadataList = r3;
        this.mRootNode = new Node(1024);
        this.mEmojiCharArray = new char[r3.listLength() * 2];
        constructIndex(r3);
    }

    public static MetadataRepo create(Typeface r2) {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r0 = new MetadataRepo(r2, new MetadataList());     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r0;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public static MetadataRepo create(Typeface r1, InputStream r2) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r0 = new MetadataRepo(r1, MetadataListReader.read(r2));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r0;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public static MetadataRepo create(Typeface r1, ByteBuffer r2) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r0 = new MetadataRepo(r1, MetadataListReader.read(r2));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r0;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public static MetadataRepo create(AssetManager r2, String r3) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r1 = new MetadataRepo(Typeface.createFromAsset(r2, r3), MetadataListReader.read(r2, r3));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r1;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    private void constructIndex(MetadataList r6) {
        int r7 = r6.listLength();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        EmojiMetadata r1 = new EmojiMetadata(this, r0);
        Character.toChars(r1.getId(), this.mEmojiCharArray, r0 * 2);
        put(r1);
        r0 = r0 + 1;
        goto L3
    }

    Typeface getTypeface() {
        return this.mTypeface;
    }

    int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    Node getRootNode() {
        return this.mRootNode;
    }

    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    void put(EmojiMetadata r5) {
        Preconditions.checkNotNull(r5, "emoji metadata cannot be null");
        if (r5.getCodepointsLength() <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "invalid metadata codepoint length");
        this.mRootNode.put(r5, 0, r5.getCodepointsLength() - 1);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
