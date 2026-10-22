package com.baidu.mapsdkplatform.comapi.map.z;

import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.f;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class a extends InnerOverlay {

    /* renamed from: d, reason: collision with root package name */
    private boolean f8142d;

    /* renamed from: e, reason: collision with root package name */
    private int f8143e;

    /* renamed from: f, reason: collision with root package name */
    private int f8144f;

    /* renamed from: g, reason: collision with root package name */
    private int f8145g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8146h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8147i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8148j;

    /* renamed from: k, reason: collision with root package name */
    public final List<f> f8149k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8150l;

    public a() {
        super(36);
        this.f8142d = false;
        this.f8143e = 0;
        this.f8144f = 0;
        this.f8145g = 0;
        this.f8146h = true;
        this.f8147i = false;
        this.f8148j = false;
        this.f8149k = new ArrayList();
        this.f8150l = true;
    }

    public boolean a(f fVar) {
        synchronized (this.f8149k) {
            try {
                if (this.f8149k.contains(fVar)) {
                    return false;
                }
                boolean zAdd = this.f8149k.add(fVar);
                this.f8150l = zAdd;
                return zAdd;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(boolean z4) {
        this.f8146h = z4;
    }

    public boolean c() {
        return this.f8148j;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void clear() {
        this.f8147i = false;
        this.f8148j = false;
        synchronized (this.f8149k) {
            this.f8149k.clear();
        }
        super.clear();
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getData() {
        if (this.f8150l) {
            synchronized (this.f8149k) {
                try {
                    if (this.f8149k.size() == 0) {
                        return "";
                    }
                    JsonBuilder jsonBuilder = new JsonBuilder();
                    jsonBuilder.object();
                    if (this.f8148j) {
                        jsonBuilder.key("statuschange").value(1);
                        jsonBuilder.key("onpause").value(this.f8147i ? 1 : 0);
                        jsonBuilder.endObject();
                        setData(jsonBuilder.getJson());
                        this.f8150l = false;
                        return super.getData();
                    }
                    jsonBuilder.key("dataset").arrayValue();
                    Iterator<f> it = this.f8149k.iterator();
                    while (it.hasNext()) {
                        jsonBuilder.objectValue(it.next().a());
                    }
                    jsonBuilder.endArrayValue();
                    jsonBuilder.key("startValue").value(0);
                    jsonBuilder.key("endValue").value(1);
                    if (this.f8142d) {
                        jsonBuilder.key("isNeedRouteAnimate").value(1);
                        jsonBuilder.key("durationTime").value(this.f8143e);
                        jsonBuilder.key("delayTime").value(this.f8144f);
                        jsonBuilder.key("easingCurve").value(this.f8145g);
                        this.f8142d = false;
                    } else {
                        jsonBuilder.key("isNeedRouteAnimate").value(0);
                        jsonBuilder.key("durationTime").value(0);
                        jsonBuilder.key("delayTime").value(0);
                        jsonBuilder.key("easingCurve").value(0);
                    }
                    if (this.f8146h) {
                        jsonBuilder.key("isRotateWhenTrack").value(1);
                    } else {
                        jsonBuilder.key("isRotateWhenTrack").value(0);
                    }
                    jsonBuilder.endObject();
                    setData(jsonBuilder.getJson());
                    this.f8150l = false;
                } finally {
                }
            }
        }
        return super.getData();
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void setData(String str) {
        super.setData(str);
        this.f8150l = true;
    }

    public boolean b() {
        return this.f8147i;
    }

    public void c(boolean z4) {
        this.f8148j = z4;
    }

    public void a() {
        this.f8150l = true;
        UpdateOverlay();
    }

    public void a(boolean z4, int i4, int i5, int i6) {
        this.f8142d = z4;
        this.f8143e = i4;
        this.f8144f = i5;
        this.f8145g = i6;
    }

    public void a(boolean z4) {
        this.f8147i = z4;
    }
}
