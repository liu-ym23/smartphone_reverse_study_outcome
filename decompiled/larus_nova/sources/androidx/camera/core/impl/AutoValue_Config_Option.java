package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_Config_Option<T> extends Config.Option<T> {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f5177id;
    private final Object token;
    private final Class<T> valueClass;

    public int hashCode() {
        int r100 = (((this.f5177id.hashCode() ^ 1000003) * 1000003) ^ this.valueClass.hashCode()) * 1000003;
        Object r101 = this.token;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 ^ r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "Option{id=" + this.f5177id + ", valueClass=" + this.valueClass + ", token=" + this.token + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.Config.Option
    public String getId() {
        return this.f5177id;
    }

    @Override // androidx.camera.core.impl.Config.Option
    public Object getToken() {
        return this.token;
    }

    @Override // androidx.camera.core.impl.Config.Option
    public Class<T> getValueClass() {
        return this.valueClass;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Config.Option) == false) goto L21;
        Config.Option r101 = (Config.Option) r100;
        if (this.f5177id.equals(r101.getId()) == true) goto L10;
    L19:
        return false;
    L10:
        if (this.valueClass.equals(r101.getValueClass()) == false) goto L19;
        Object r102 = this.token;
        if (r102 != null) goto L17;
        if (r101.getToken() != null) goto L19;
        return true;
    L17:
        if (r102.equals(r101.getToken()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    public AutoValue_Config_Option(String r100, Class<T> r101, Object r102) {
        if (r100 == null) goto L11;
        this.f5177id = r100;
        if (r101 == null) goto L9;
        this.valueClass = r101;
        this.token = r102;
        return;
    L9:
        throw new NullPointerException("Null valueClass");
    L11:
        throw new NullPointerException("Null id");
    }
}
