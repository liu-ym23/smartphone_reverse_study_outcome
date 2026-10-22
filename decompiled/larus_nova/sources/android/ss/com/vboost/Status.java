package android.ss.com.vboost;

import com.alibaba.gaiax.model.GXAnimation;

/* JADX INFO: loaded from: classes2.dex */
public final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status BEGIN = null;
    public static final Status END = null;
    private int status;

    static {
        Status r100 = new Status("BEGIN", 0, 1);
        BEGIN = r100;
        Status r101 = new Status(GXAnimation.STATE_END, 1, 2);
        END = r101;
        $VALUES = new Status[]{r100, r101};
    }

    private Status(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }

    public static Status valueOf(String r100) {
        return (Status) r27.a.a(Status.class, r100);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    public int getStatus() {
        return this.status;
    }
}
