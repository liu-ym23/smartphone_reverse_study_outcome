package com.alibaba.gaiax.model;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/alibaba/gaiax/model/GXScroll;", "", "()V", "dx", "", "getDx", "()I", "setDx", "(I)V", "dy", "getDy", "setDy", "state", "getState", "setState", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "toString", "Companion", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXScroll {
    public static final Companion Companion = null;
    public static final String TYPE_ON_SCROLLED = "onScrolled";
    public static final String TYPE_ON_SCROLL_STATE_CHANGED = "onScrollStateChanged";

    /* JADX INFO: renamed from: dx, reason: collision with root package name */
    private int f24952dx;

    /* JADX INFO: renamed from: dy, reason: collision with root package name */
    private int f24953dy;
    private int state;
    private String type;
    private View view;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/model/GXScroll$Companion;", "", "()V", "TYPE_ON_SCROLLED", "", "TYPE_ON_SCROLL_STATE_CHANGED", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public String toString() {
        return "GXScroll(view=" + this.view + ", dx=" + this.f24952dx + ", dy=" + this.f24953dy + ", state=" + this.state + ')';
    }

    public GXScroll() {
        this.type = "";
    }

    public final int getDx() {
        return this.f24952dx;
    }

    public final int getDy() {
        return this.f24953dy;
    }

    public final int getState() {
        return this.state;
    }

    public final String getType() {
        return this.type;
    }

    public final View getView() {
        return this.view;
    }

    public final void setDx(int r100) {
        this.f24952dx = r100;
    }

    public final void setDy(int r100) {
        this.f24953dy = r100;
    }

    public final void setState(int r100) {
        this.state = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public final void setView(View r100) {
        this.view = r100;
    }
}
