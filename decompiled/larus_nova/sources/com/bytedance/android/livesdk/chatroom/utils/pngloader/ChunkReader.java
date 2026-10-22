package com.bytedance.android.livesdk.chatroom.utils.pngloader;

/* JADX INFO: loaded from: classes8.dex */
public abstract class ChunkReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChunkReaderMode f114584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final po1.b f114585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f114586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f114587d;

    public static final enum ChunkReaderMode extends Enum<ChunkReaderMode> {
        public static final ChunkReaderMode BUFFER = null;
        public static final ChunkReaderMode PROCESS = null;
        public static final ChunkReaderMode SKIP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChunkReaderMode[] f114588a = null;

        static {
            ChunkReaderMode r100 = new ChunkReaderMode("BUFFER", 0);
            BUFFER = r100;
            ChunkReaderMode r101 = new ChunkReaderMode("PROCESS", 1);
            PROCESS = r101;
            ChunkReaderMode r102 = new ChunkReaderMode("SKIP", 2);
            SKIP = r102;
            f114588a = new ChunkReaderMode[]{r100, r101, r102};
        }

        public static ChunkReaderMode[] values() {
            return (ChunkReaderMode[]) f114588a.clone();
        }

        public static ChunkReaderMode valueOf(String r100) {
            return (ChunkReaderMode) r27.a.a(ChunkReaderMode.class, r100);
        }

        public ChunkReaderMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ChunkReader(int r100, String r101, ChunkReaderMode r102) {
        boolean r103 = false;
        this.f114586c = 0;
        this.f114587d = 0;
        if (r102 == null) goto L13;
        if (r101.length() != 4) goto L13;
        if (r100 < 0) goto L13;
        this.f114584a = r102;
        if (r102 != ChunkReaderMode.BUFFER) goto L10;
        r103 = true;
    L10:
        this.f114585b = new po1.b(r100, r101, r103);
        return;
    L13:
        throw new RuntimeException();
    }
}
