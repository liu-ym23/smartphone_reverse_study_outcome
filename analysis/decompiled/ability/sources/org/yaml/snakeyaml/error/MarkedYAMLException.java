package org.yaml.snakeyaml.error;

/* loaded from: classes4.dex */
public abstract class MarkedYAMLException extends YAMLException {

    /* renamed from: a, reason: collision with root package name */
    public final String f5524a;
    public final Mark b;
    public final String c;
    public final Mark d;

    public MarkedYAMLException(String str, Mark mark, String str2, Mark mark2) {
        super(str + "; " + str2 + "; " + mark2, null);
        this.f5524a = str;
        this.b = mark;
        this.c = str2;
        this.d = mark2;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return toString();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f5524a;
        if (str != null) {
            sb.append(str);
            sb.append("\n");
        }
        Mark mark = this.b;
        if (mark != null) {
            sb.append(mark);
            sb.append("\n");
        }
        String str2 = this.c;
        if (str2 != null) {
            sb.append(str2);
            sb.append("\n");
        }
        Mark mark2 = this.d;
        if (mark2 != null) {
            sb.append(mark2);
            sb.append("\n");
        }
        return sb.toString();
    }
}
