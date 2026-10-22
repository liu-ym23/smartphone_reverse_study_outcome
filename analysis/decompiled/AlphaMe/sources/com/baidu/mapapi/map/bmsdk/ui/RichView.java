package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.CollisionBehavior;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.baidu.platform.comapi.bmsdk.xmlui.BmXmlParse;
import com.baidu.platform.comapi.bmsdk.xmlui.a;
import java.io.IOException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;

/* loaded from: classes.dex */
public class RichView {

    /* renamed from: a, reason: collision with root package name */
    private BmRichView f7145a = new BmRichView();

    /* renamed from: b, reason: collision with root package name */
    private BmBaseUI f7146b;

    public BmRichView getBmRichView() {
        return this.f7145a;
    }

    public BmBaseUI getView() {
        return this.f7146b;
    }

    public void setAnimation(Animation animation) {
        BmAnimation bmAnimation;
        if (animation == null || (bmAnimation = animation.bmAnimation) == null) {
            return;
        }
        this.f7145a.a(bmAnimation);
    }

    public void setCollisionBehavior(CollisionBehavior collisionBehavior) {
        this.f7145a.a(collisionBehavior.getNumber());
    }

    public void setCollisionPriority(short s4) {
        BmRichView bmRichView = this.f7145a;
        if (s4 < 0) {
            s4 = 0;
        }
        bmRichView.a(s4);
    }

    public void setLocated(Located located) {
        this.f7145a.b(located.getNumber());
    }

    public void setScale(float f4) {
        this.f7145a.a(f4);
    }

    public void setScaleX(float f4) {
        this.f7145a.b(f4);
    }

    public void setScaleY(float f4) {
        this.f7145a.c(f4);
    }

    public void setShowLevel(int i4, int i5) {
        this.f7145a.a(i4, i5);
    }

    public void setView(BaseUI baseUI) {
        this.f7145a.a(baseUI.getBmBaseUI());
    }

    public void setVisibility(int i4) {
        this.f7145a.c(i4);
    }

    public void setXmlView(String str) throws DOMException, IOException {
        Document documentA = BmXmlParse.a(str.getBytes());
        if (documentA != null) {
            this.f7145a = new a().a(documentA);
        }
    }
}
