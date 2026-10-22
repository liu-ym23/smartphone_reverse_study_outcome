package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: Key.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f878a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f882e;
    HashMap<String, androidx.constraintlayout.widget.a> f;

    static {
    }

    public abstract d a();

    abstract void a(Context r1, AttributeSet r2);

    public abstract void a(HashMap<String, androidx.constraintlayout.motion.utils.c> r1);

    abstract void a(HashSet<String> r1);

    public void b(HashMap<String, Integer> r1) {
    }

    public d() {
        int r0 = f878a;
        this.f879b = r0;
        this.f880c = r0;
        this.f881d = null;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    boolean a(String r1) {
        String r0 = this.f881d;
        if (r0 == null) goto L8;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.matches(r0);
    L8:
        return false;
    }

    float a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == false) goto L6;
        return ((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.aiagent.plugin")).floatValue();
    L6:
        return Float.parseFloat(r2.toString());
    }

    int b(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L6;
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin")).intValue();
    L6:
        return Integer.parseInt(r2.toString());
    }

    boolean c(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L6;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        return Boolean.parseBoolean(r2.toString());
    }

    public d a(d r2) {
        this.f879b = r2.f879b;
        this.f880c = r2.f880c;
        this.f881d = r2.f881d;
        this.f882e = r2.f882e;
        this.f = r2.f;
        return this;
    }

    public d a(int r1) {
        this.f880c = r1;
        return this;
    }

    public void b(int r1) {
        this.f879b = r1;
    }
}
