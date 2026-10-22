package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    public static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory mDelegateFactory;

        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + com.alipay.sdk.m.u.i.f25855d;
        }

        public Factory2Wrapper(LayoutInflaterFactory r100) {
            this.mDelegateFactory = r100;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String r100, Context r101, AttributeSet r102) {
            return this.mDelegateFactory.onCreateView(null, r100, r101, r102);
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View r100, String r101, Context r102, AttributeSet r103) {
            return this.mDelegateFactory.onCreateView(r100, r101, r102, r103);
        }
    }

    private LayoutInflaterCompat() {
    }

    public static LayoutInflaterFactory getFactory(LayoutInflater r100) {
        LayoutInflater.Factory r101 = r100.getFactory();
        if ((r101 instanceof Factory2Wrapper) == true) goto L5;
        return null;
    L5:
        return ((Factory2Wrapper) r101).mDelegateFactory;
    }

    private static void forceSetFactory2(LayoutInflater r100, LayoutInflater.Factory2 r101) {
        if (sCheckedField == false) goto L17;
    L9:
        Field r102 = sLayoutInflaterFactory2Field;
        if (r102 == null) goto L19;
        r102.set(r100, r101);     // Catch: IllegalAccessException -> L13
        return;
    L13:
        Objects.toString(r100);
        return;
    L19:
        return;
    L17:
        Field r103 = LayoutInflater.class.getDeclaredField("mFactory2");     // Catch: NoSuchFieldException -> L7
        sLayoutInflaterFactory2Field = r103;     // Catch: NoSuchFieldException -> L7
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        sCheckedField = true;
        goto L9
    }

    public static void setFactory(LayoutInflater r100, LayoutInflaterFactory r101) {
        r100.setFactory2(new Factory2Wrapper(r101));
    }

    public static void setFactory2(LayoutInflater r100, LayoutInflater.Factory2 r101) {
        r100.setFactory2(r101);
    }
}
