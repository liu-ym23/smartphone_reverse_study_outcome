package com.tonyodev.fetch2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EnqueueAction {

    /* renamed from: b, reason: collision with root package name */
    public static final a f8147b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnqueueAction f8148c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnqueueAction f8149d;

    /* renamed from: e, reason: collision with root package name */
    public static final EnqueueAction f8150e;
    public static final EnqueueAction h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ EnqueueAction[] f8151j;

    /* renamed from: a, reason: collision with root package name */
    public final int f8152a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static EnqueueAction a(int i10) {
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? EnqueueAction.f8148c : EnqueueAction.h : EnqueueAction.f8150e : EnqueueAction.f8149d;
        }
    }

    static {
        EnqueueAction enqueueAction = new EnqueueAction("REPLACE_EXISTING", 0, 0);
        f8148c = enqueueAction;
        EnqueueAction enqueueAction2 = new EnqueueAction("INCREMENT_FILE_NAME", 1, 1);
        f8149d = enqueueAction2;
        EnqueueAction enqueueAction3 = new EnqueueAction("DO_NOT_ENQUEUE_IF_EXISTING", 2, 2);
        f8150e = enqueueAction3;
        EnqueueAction enqueueAction4 = new EnqueueAction("UPDATE_ACCORDINGLY", 3, 3);
        h = enqueueAction4;
        EnqueueAction[] enqueueActionArr = {enqueueAction, enqueueAction2, enqueueAction3, enqueueAction4};
        f8151j = enqueueActionArr;
        kotlin.enums.a.a(enqueueActionArr);
        f8147b = new a();
    }

    public EnqueueAction(String str, int i10, int i11) {
        this.f8152a = i11;
    }

    public static EnqueueAction valueOf(String str) {
        return (EnqueueAction) Enum.valueOf(EnqueueAction.class, str);
    }

    public static EnqueueAction[] values() {
        return (EnqueueAction[]) f8151j.clone();
    }
}
