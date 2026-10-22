package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.response.anchorv3.GroupAvatarTimeStruct;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public final class l {
    public static final SimpleDraweeView a(Context r100, GroupAvatarTimeStruct r101) {
        SimpleDraweeView r102 = new SimpleDraweeView(r100);
        RoundingParams r103 = RoundingParams.asCircle();
        boolean r104 = true;
        r103.setBorderWidth(vf4.a.b(1));
        r103.setBorderColor(-1);
        r102.getHierarchy().setRoundingParams(r103);
        GenericDraweeHierarchy r105 = r102.getHierarchy();
        ScalingUtils.ScaleType r106 = ScalingUtils.ScaleType.CENTER_CROP;
        r105.setActualImageScaleType(r106);
        r102.getHierarchy().setPlaceholderImage(R.drawable.ec_ic_img_signin_defaultavatar, r106);
        r102.setLayoutParams(new LinearLayout.LayoutParams(vf4.a.b(24), vf4.a.b(24)));
        String r107 = r101.getUrl();
        if (r107 != null) goto L5;
    L8:
        if (r104 == false) goto L10;
        r107 = "fail";
    L10:
        y.d(r102, r107);
        return r102;
    L5:
        if (r107.length() == 0) goto L8;
        r104 = false;
        goto L8
    }
}
