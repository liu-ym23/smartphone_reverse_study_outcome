package bq;

import com.bytedance.android.ecom.arch.expr.error.SlcExprException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20008c;

    /* JADX INFO: renamed from: bq.a$a, reason: collision with other inner class name */
    public static final class C0337a {
    }

    static {
    }

    public final char a() {
        if (this.f20007b < this.f20008c.length()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return CharCompanionObject.MAX_VALUE;
    L9:
        String r101 = this.f20008c;
        int r102 = this.f20007b;
        this.f20007b = r102 + 1;
        return r101.charAt(r102);
    L5:
        r100 = false;
        goto L6
    }

    public final char d() {
        if (this.f20007b < this.f20008c.length()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        return CharCompanionObject.MAX_VALUE;
    L10:
        return this.f20008c.charAt(this.f20007b);
    L5:
        r100 = false;
        goto L6
    }

    public a(String r100) {
        this.f20008c = r100;
    }

    public final boolean b(char r100) {
        if (d() != r100) goto L6;
        a();
        return true;
    L6:
        return false;
    }

    public final b c(boolean r100) {
        boolean r101 = !r100;
    L3:
        char r102 = d();
        boolean r103 = false;
        if ('0' > r102) goto L8;
        if ('9' < r102) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        a();
        goto L3
    L11:
        char r105 = d();
        if (r100 == true) goto L27;
        if (r105 != '.') goto L25;
        a();
    L16:
        char r106 = d();
        if ('0' > r106) goto L21;
        if ('9' < r106) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
        a();
        goto L16
    L24:
        r101 = false;
    L21:
        r107 = false;
    L25:
        r105 = d();
    L27:
        if (r105 != 'e') goto L29;
    L32:
        a();
        char r108 = d();
        if (r108 != '+') goto L35;
    L36:
        a();
    L37:
        char r109 = d();
        if ('0' > r109) goto L42;
        if ('9' < r109) goto L42;
        boolean r110 = true;
    L43:
        if (r110 == false) goto L62;
    L44:
        char r111 = d();
        if ('0' > r111) goto L49;
        if ('9' < r111) goto L49;
        boolean r112 = true;
    L50:
        if (r112 == false) goto L52;
        a();
    L52:
        if (r103 == false) goto L54;
        int r113 = 31;
    L55:
        String r114 = this.f20008c;
        int r115 = this.f20006a;
        int r116 = this.f20007b;
        if (r114 == null) goto L60;
        return new b(r113, r114.substring(r115, r116));
    L60:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L54:
        r113 = 2;
    L49:
        r112 = false;
        goto L50
    L62:
        throw new SlcExprException("lexer_invalid_number", "科学计数法e后续必须跟随一个数字");
    L42:
        r110 = false;
        goto L43
    L35:
        if (r108 != '-') goto L37;
    L29:
        if (r105 == 'E') goto L32;
        r103 = r101;
    L8:
        r104 = false;
        goto L9
    }
}
