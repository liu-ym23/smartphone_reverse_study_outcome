package com.bytedance.als;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/als/AttachOption;", "", "IMMEDIATE", "LAZY", "FORCE_LAZY", "als_release"}, k = 1, mv = {1, 4, 1})
public final enum AttachOption extends Enum<AttachOption> {
    public static final AttachOption FORCE_LAZY = null;
    public static final AttachOption IMMEDIATE = null;
    public static final AttachOption LAZY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttachOption[] f38079a = null;

    static {
        AttachOption r100 = new AttachOption("IMMEDIATE", 0);
        IMMEDIATE = r100;
        AttachOption r101 = new AttachOption("LAZY", 1);
        LAZY = r101;
        AttachOption r102 = new AttachOption("FORCE_LAZY", 2);
        FORCE_LAZY = r102;
        f38079a = new AttachOption[]{r100, r101, r102};
    }

    public static AttachOption valueOf(String r100) {
        return (AttachOption) r27.a.a(AttachOption.class, r100);
    }

    public static AttachOption[] values() {
        return (AttachOption[]) f38079a.clone();
    }

    public AttachOption(String r100, int r101) {
        super(r100, r101);
    }
}
