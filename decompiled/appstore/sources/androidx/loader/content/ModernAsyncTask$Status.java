package androidx.loader.content;

/* JADX INFO: loaded from: classes.dex */
public final enum ModernAsyncTask$Status extends Enum<ModernAsyncTask$Status> {
    private static final /* synthetic */ ModernAsyncTask$Status[] $VALUES = null;
    public static final ModernAsyncTask$Status FINISHED = null;
    public static final ModernAsyncTask$Status PENDING = null;
    public static final ModernAsyncTask$Status RUNNING = null;

    static {
        ModernAsyncTask$Status r10 = new ModernAsyncTask$Status("PENDING", 0);
        PENDING = r10;
        ModernAsyncTask$Status r11 = new ModernAsyncTask$Status("RUNNING", 1);
        RUNNING = r11;
        ModernAsyncTask$Status r12 = new ModernAsyncTask$Status("FINISHED", 2);
        FINISHED = r12;
        $VALUES = new ModernAsyncTask$Status[]{r10, r11, r12};
    }

    private ModernAsyncTask$Status(String r10, int r11) {
        super(r10, r11);
    }

    public static ModernAsyncTask$Status valueOf(String r10) {
        return (ModernAsyncTask$Status) Enum.valueOf(ModernAsyncTask$Status.class, r10);
    }

    public static ModernAsyncTask$Status[] values() {
        return (ModernAsyncTask$Status[]) $VALUES.clone();
    }
}
