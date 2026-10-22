package g8;

import w7.e0;

/* loaded from: classes.dex */
public enum e {
    FIELD(null),
    FILE(null),
    PROPERTY(null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");


    /* renamed from: f, reason: collision with root package name */
    public final String f3882f;

    e(String str) {
        this.f3882f = str == null ? e0.O(name()) : str;
    }
}
