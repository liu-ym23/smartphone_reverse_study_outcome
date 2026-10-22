package androidx.appcompat.b;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: Compatibility.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: androidx.appcompat.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Compatibility.java */
    public static class C0009a {
        public static void a(Resources r0, int r1, int r2, TypedValue r3, boolean r4) {
            r0.getValueForDensity(r1, r2, r3, r4);
        }
    }

    /* JADX INFO: compiled from: Compatibility.java */
    public static class b {
        public static void a(ObjectAnimator r0, boolean r1) {
            r0.setAutoCancel(r1);
        }
    }

    /* JADX INFO: compiled from: Compatibility.java */
    public static class c {
        public static void a(Drawable r2, Resources r3, XmlPullParser r4, AttributeSet r5, Resources.Theme r6) {
            r2.inflate(r3, (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), r6);
        }

        public static int a(TypedArray r0) {
            return r0.getChangingConfigurations();
        }

        public static Drawable a(Resources r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
            return Drawable.createFromXmlInner(r2, (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        }
    }
}
