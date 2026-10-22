package com.bytedance.android.live.liveinteract.interact.audience.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes46.dex */
public class AudienceInteractWaitingView extends FrameLayout {
    public AudienceInteractWaitingView(Context r100) {
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_audience_interact_wait, this);
    }

    public AudienceInteractWaitingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_audience_interact_wait, this);
    }

    public final void a(List<k> r100, IBaseUser r101) {
        ArrayList r102 = new ArrayList();
        py.k r103 = r101.getAvatarThumbKt();
        if (r100 == null) goto L20;
        Iterator<k> r104 = r100.iterator();
    L6:
        if (r104.hasNext() == false) goto L20;
        k r105 = r104.next();
        if (r105.getUser() == null) goto L13;
        if (Objects.equals(r105.getUser().getIdString(), r101.getIdString()) == true) goto L13;
        r102.add(r105);
    L13:
        if (r105.getUser() == null) goto L6;
        if (Objects.equals(r105.getUser().getIdString(), r101.getIdString()) == false) goto L6;
        if (r105.getUser().isAnonymous() == false) goto L6;
        r103 = r105.getUser().getAvatarThumbKt();
    L20:
        if (Lists.isEmpty(r102) == false) goto L23;
        HSImageView r106 = (HSImageView) findViewById(R.id.one);
        r106.setVisibility(0);
        ImageUtil.loadRoundImage(r106, r103);
        return;
    L23:
        if (r102.size() != 1) goto L25;
        findViewById(R.id.two).setVisibility(0);
        ImageUtil.loadRoundImage((HSImageView) findViewById(R.id.two_my), r103);
        ImageUtil.loadRoundImage((HSImageView) findViewById(R.id.two_other), ((k) ListProtector.get(r102, 0)).getUser().getAvatarThumbKt());
        return;
    L25:
        findViewById(R.id.three).setVisibility(0);
        ImageUtil.loadRoundImage((HSImageView) findViewById(R.id.three_my), r103);
        ImageUtil.loadRoundImage((HSImageView) findViewById(R.id.three_other), ((k) ListProtector.get(r102, 0)).getUser().getAvatarThumbKt());
    }

    public AudienceInteractWaitingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_audience_interact_wait, this);
    }
}
