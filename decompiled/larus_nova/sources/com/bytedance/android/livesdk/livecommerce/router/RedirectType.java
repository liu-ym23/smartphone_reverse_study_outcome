package com.bytedance.android.livesdk.livecommerce.router;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/router/RedirectType;", "", "", "value", "I", "getValue", "()I", "SEARCH", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RedirectType extends Enum<RedirectType> {
    public static final RedirectType SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedirectType[] f152826a = null;
    private final int value;

    static {
        RedirectType r100 = new RedirectType();
        SEARCH = r100;
        f152826a = new RedirectType[]{r100};
    }

    public static RedirectType valueOf(String r100) {
        return (RedirectType) r27.a.a(RedirectType.class, r100);
    }

    public static RedirectType[] values() {
        return (RedirectType[]) f152826a.clone();
    }

    public RedirectType() {
        super("SEARCH", 0);
        this.value = 1;
    }

    public final int getValue() {
        return this.value;
    }
}
