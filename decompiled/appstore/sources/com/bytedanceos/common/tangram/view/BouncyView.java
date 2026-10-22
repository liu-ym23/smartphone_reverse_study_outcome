package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.bytedanceos.common.tangram.Bind;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;

/* JADX INFO: loaded from: classes2.dex */
public class BouncyView extends RelativeLayout implements Bind<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9941b;

    public BouncyView(Context r10) {
        super(r10);
        this.f9940a = 1;
    }

    public void a(Integer r10, BaseCell r11) {
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(Integer r10, BaseCell r11) {
        a(r10, r11);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void bindStyle(Style r10, BaseCell r11) {
        this.f9941b = r10.height;
        setLayoutParams(new RelativeLayout.LayoutParams(this.f9940a, this.f9941b));
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void unBind() {
    }

    public BouncyView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f9940a = 1;
    }

    public BouncyView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f9940a = 1;
    }
}
