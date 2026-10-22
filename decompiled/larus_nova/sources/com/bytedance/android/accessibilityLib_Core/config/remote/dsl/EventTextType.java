package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/remote/dsl/EventTextType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NUMBER", "DEFAULT", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum EventTextType extends Enum<EventTextType> {
    public static final EventTextType DEFAULT = null;
    public static final EventTextType NUMBER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventTextType[] f38175a = null;
    private final String value;

    static {
        EventTextType r100 = new EventTextType("NUMBER", 0, "number");
        NUMBER = r100;
        EventTextType r101 = new EventTextType("DEFAULT", 1, "string");
        DEFAULT = r101;
        f38175a = new EventTextType[]{r100, r101};
    }

    public static EventTextType valueOf(String r100) {
        return (EventTextType) r27.a.a(EventTextType.class, r100);
    }

    public static EventTextType[] values() {
        return (EventTextType[]) f38175a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public EventTextType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
