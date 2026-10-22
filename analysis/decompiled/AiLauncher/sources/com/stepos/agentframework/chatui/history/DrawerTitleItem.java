package com.stepos.agentframework.chatui.history;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001b\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R+\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/chatui/history/g;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "type", "", "title", "sessionKind", "data", "", "isSelected", "Lkotlin/Function2;", "LY8/t;", "clickListener", "<init>", "(ILjava/lang/String;ILjava/lang/Object;ZLp9/p;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "e", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", "Z", "f", "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)V", "Lp9/p;", Const.INTENT_KEY_APIKEY, "()Lp9/p;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.history.g, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class DrawerTitleItem<T> {
    private final p<String, T, t> clickListener;
    private final T data;
    private boolean isSelected;
    private final int sessionKind;
    private final String title;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public DrawerTitleItem(int i10, String title, int i11, T t10, boolean z10, p<? super String, ? super T, t> pVar) {
        kotlin.jvm.internal.p.i(title, "title");
        this.type = i10;
        this.title = title;
        this.sessionKind = i11;
        this.data = t10;
        this.isSelected = z10;
        this.clickListener = pVar;
    }

    public final p<String, T, t> a() {
        return this.clickListener;
    }

    public final T b() {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final int getSessionKind() {
        return this.sessionKind;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: e, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DrawerTitleItem)) {
            return false;
        }
        DrawerTitleItem drawerTitleItem = (DrawerTitleItem) other;
        return this.type == drawerTitleItem.type && kotlin.jvm.internal.p.d(this.title, drawerTitleItem.title) && this.sessionKind == drawerTitleItem.sessionKind && kotlin.jvm.internal.p.d(this.data, drawerTitleItem.data) && this.isSelected == drawerTitleItem.isSelected && kotlin.jvm.internal.p.d(this.clickListener, drawerTitleItem.clickListener);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void g(boolean z10) {
        this.isSelected = z10;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.type) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.sessionKind)) * 31;
        T t10 = this.data;
        int iHashCode2 = (((iHashCode + (t10 == null ? 0 : t10.hashCode())) * 31) + Boolean.hashCode(this.isSelected)) * 31;
        p<String, T, t> pVar = this.clickListener;
        return iHashCode2 + (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "DrawerTitleItem(type=" + this.type + ", title=" + this.title + ", sessionKind=" + this.sessionKind + ", data=" + this.data + ", isSelected=" + this.isSelected + ", clickListener=" + this.clickListener + ")";
    }

    public /* synthetic */ DrawerTitleItem(int i10, String str, int i11, Object obj, boolean z10, p pVar, int i12, kotlin.jvm.internal.i iVar) {
        this(i10, str, i11, obj, (i12 & 16) != 0 ? false : z10, (i12 & 32) != 0 ? null : pVar);
    }
}
