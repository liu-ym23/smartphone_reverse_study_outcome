package com.bytedanceos.appstore.buss.utilities;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CommonUtil f8830a = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedanceos/appstore/buss/utilities/CommonUtil$PrivacyPolicyURLSpan;", "Landroid/text/style/URLSpan;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "url", "", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;)V", BusSupport.EVENT_ON_CLICK, "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PrivacyPolicyURLSpan extends URLSpan {

        @NotNull
        private final AppCompatActivity activity;

        public PrivacyPolicyURLSpan(@NotNull AppCompatActivity r10, @Nullable String r11) {
            kotlin.jvm.internal.q.g(r10, "activity");
            super(r11);
            this.activity = r10;
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(@NotNull View r10) {
            kotlin.jvm.internal.q.g(r10, "widget");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint r10) {
            kotlin.jvm.internal.q.g(r10, "ds");
            super.updateDrawState(r10);
            r10.setColor(-16776961);
            r10.setUnderlineText(false);
        }
    }

    static {
        f8830a = new CommonUtil();
    }

    public CommonUtil() {
    }

    public final Object a(List r10, Continuation r11) {
        return kotlinx.coroutines.h.g(l0.b(), new CommonUtil$canStartDownload$2(r10, null), r11);
    }

    public final boolean b(int r10) {
        if (r10 != 1000004) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        AccountDataCache.b().a();
    L8:
        return r11;
    L5:
        r11 = false;
        goto L6
    }

    public final boolean c(int r10, Activity r11) {
        kotlin.jvm.internal.q.g(r11, "activity");
        if (r10 != 1000004) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        AccountDataCache.b().a();
        com.bytedanceos.common.toolbox.e.J0(r11, "", true);
    L8:
        return r12;
    L5:
        r12 = false;
        goto L6
    }

    public final void d(List r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L18;
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L19;
        CommonAppEntity r12 = (CommonAppEntity) r11.next();
        if (BaseApplication.c().b().b0(r12.getPkg()) == false) goto L8;
        r11.remove();
        goto L8
    L19:
        return;
    }

    public final Class e(Object r10) {
        kotlin.jvm.internal.q.g(r10, "any");
        Type r11 = r10.getClass().getGenericSuperclass();     // Catch: Exception -> L5
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");     // Catch: Exception -> L5
        Type r12 = ((ParameterizedType) r11).getActualTypeArguments()[0];     // Catch: Exception -> L5
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type java.lang.Class<T of com.bytedanceos.appstore.buss.utilities.CommonUtil.getGenerics>");     // Catch: Exception -> L5
        return (Class) r12;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final List f(List r10) {
        ArrayList r11 = new ArrayList();
        if (r10 != null) goto L5;
    L13:
        return r11;
    L5:
        if (r10.isEmpty() == true) goto L13;
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        CommonAppEntity r13 = (CommonAppEntity) r12.next();
        if (BaseApplication.c().b().b0(r13.getPkg()) == true) goto L9;
        r11.add(r13);
        goto L9
    }

    public final boolean g(AppInfo r10) {
        kotlin.jvm.internal.q.g(r10, "appInfo");
        int r11 = BaseApplication.c().b().B(r10.appPackageName);
        if (r11 != 1) goto L5;
        return false;
    L5:
        if (r11 != 2) goto L7;
        return false;
    L7:
        if (r11 != 8) goto L9;
        return false;
    L9:
        if (r11 == 32) goto L21;
        if (r11 == 64) goto L21;
        if (r11 == 128) goto L18;
        if (r11 != 512) goto L26;
        return false;
    L26:
        return true;
    L18:
        if (com.bytedanceos.common.utils.r.b(r10.appPackageName) == false) goto L26;
        return false;
    L21:
        return com.bytedanceos.common.utils.r.c(r10.appPackageName);
    }

    public final void h(Activity r10, String r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r11, "pageSource");
        com.bytedanceos.common.toolbox.e.J0(r10, r11, r12);
        i(r11);
    }

    public final void i(String r10) {
        kotlin.jvm.internal.q.g(r10, "pageSource");
        Bundle r11 = new Bundle();
        r11.putString(NetKey.PAGE_SOURCE, r10);
        f9.b.b("login_request", r11);
    }
}
