package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.CollisionBehavior;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.baidu.platform.comapi.bmsdk.xmlui.BmXmlParse;
import com.baidu.platform.comapi.bmsdk.xmlui.a;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: classes39.dex */
public class RichView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BmRichView f31580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BmBaseUI f31581b;

    public RichView() {
        this.f31580a = new BmRichView();
    }

    public BmRichView getBmRichView() {
        return this.f31580a;
    }

    public BmBaseUI getView() {
        return this.f31581b;
    }

    public void setAnimation(Animation r100) {
        if (r100 == null) goto L8;
        BmAnimation r101 = r100.bmAnimation;
        if (r101 == null) goto L9;
        this.f31580a.a(r101);
        return;
    L9:
        return;
    }

    public void setCollisionBehavior(CollisionBehavior r100) {
        this.f31580a.a(r100.getNumber());
    }

    public void setCollisionPriority(short r100) {
        BmRichView r101 = this.f31580a;
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        r101.a(r100);
    }

    public void setLocated(Located r100) {
        this.f31580a.b(r100.getNumber());
    }

    public void setScale(float r100) {
        this.f31580a.a(r100);
    }

    public void setScaleX(float r100) {
        this.f31580a.b(r100);
    }

    public void setScaleY(float r100) {
        this.f31580a.c(r100);
    }

    public void setView(BaseUI r100) {
        this.f31580a.a(r100.getBmBaseUI());
    }

    public void setVisibility(int r100) {
        this.f31580a.c(r100);
    }

    public void setXmlView(String r100) {
        Document r101 = BmXmlParse.a(r100.getBytes());
        if (r101 == null) goto L6;
        this.f31580a = new a().a(r101);
        return;
    }

    public void setShowLevel(int r100, int r101) {
        this.f31580a.a(r100, r101);
    }
}
