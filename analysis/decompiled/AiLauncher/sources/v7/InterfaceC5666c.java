package v7;

import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lv7/c;", "Lv7/i;", "Landroid/view/View;", Const.INTENT_KEY_PKGNAME, "()Landroid/view/View;", "Landroid/view/ViewGroup;", "parent", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;)V", "", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "setRenderScale", "(F)V", "Lkotlin/Function0;", "callback", "setOnReady", "(Lp9/a;)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: v7.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5666c extends i {
    void a(ViewGroup parent);

    View b();

    void setOnReady(InterfaceC5063a<Y8.t> callback);

    void setRenderScale(float scale);
}
