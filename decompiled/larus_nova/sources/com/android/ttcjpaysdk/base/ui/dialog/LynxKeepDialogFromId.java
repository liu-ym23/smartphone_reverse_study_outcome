package com.android.ttcjpaysdk.base.ui.dialog;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogFromId;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "O_PROJECT", "C_PROJECT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum LynxKeepDialogFromId extends Enum<LynxKeepDialogFromId> {
    private static final /* synthetic */ LynxKeepDialogFromId[] $VALUES = null;
    public static final LynxKeepDialogFromId C_PROJECT = null;
    public static final LynxKeepDialogFromId O_PROJECT = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f29370id;

    private static final /* synthetic */ LynxKeepDialogFromId[] $values() {
        return new LynxKeepDialogFromId[]{O_PROJECT, C_PROJECT};
    }

    public static LynxKeepDialogFromId valueOf(String r100) {
        return (LynxKeepDialogFromId) a.a(LynxKeepDialogFromId.class, r100);
    }

    public static LynxKeepDialogFromId[] values() {
        return (LynxKeepDialogFromId[]) $VALUES.clone();
    }

    static {
        O_PROJECT = new LynxKeepDialogFromId("O_PROJECT", 0, "o_project");
        C_PROJECT = new LynxKeepDialogFromId("C_PROJECT", 1, "c_project");
        $VALUES = $values();
    }

    public final String getId() {
        return this.f29370id;
    }

    private LynxKeepDialogFromId(String r100, int r101, String r102) {
        super(r100, r101);
        this.f29370id = r102;
    }
}
