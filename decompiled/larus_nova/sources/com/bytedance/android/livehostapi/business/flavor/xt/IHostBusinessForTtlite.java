package com.bytedance.android.livehostapi.business.flavor.xt;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.base.IBaseHostBusiness;
import com.bytedance.android.livehostapi.business.depend.DialogListener;
import com.bytedance.android.livehostapi.business.depend.IShowDialogParam;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostBusinessForTtlite extends IService, IBaseHostBusiness {
    boolean checkLynxPlugin();

    void openTaobaoApp(Context r100, String r101, IMiddlewareHostBusiness.OnActionCallback r102);

    void requestForShoppingAccess(Context r100, String r101);

    Dialog showDialog(Context r100, CharSequence r101, CharSequence r102, CharSequence r103, DialogListener r104, CharSequence r105, DialogListener r106, IShowDialogParam r107);

    boolean tryOpenAdByOpenUrl(Context r100, long r101, String r102, String r103);
}
