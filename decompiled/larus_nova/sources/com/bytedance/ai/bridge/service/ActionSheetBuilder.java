package com.bytedance.ai.bridge.service;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/ai/bridge/service/ActionSheetBuilder;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "title", "", "subtitle", "itemColor", "", SlcCommonAction.KEY_ACTIONS, "", "Lcom/bytedance/ai/bridge/service/ActionSheetBuilderAction;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getTitle", "()Ljava/lang/String;", "getSubtitle", "getItemColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/bytedance/ai/bridge/service/ActionSheetBuilder;", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionSheetBuilder {
    private final List<ActionSheetBuilderAction> actions;
    private final Context context;
    private final Integer itemColor;
    private final String subtitle;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionSheetBuilder copy$default(ActionSheetBuilder r100, Context r101, String r102, String r103, Integer r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.context;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.title;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.subtitle;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.itemColor;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.actions;
    L17:
        Context r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Context component1() {
        return this.context;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final Integer component4() {
        return this.itemColor;
    }

    public final List<ActionSheetBuilderAction> component5() {
        return this.actions;
    }

    public final ActionSheetBuilder copy(Context r100, String r101, String r110, Integer r111, List<ActionSheetBuilderAction> r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, SlcCommonAction.KEY_ACTIONS);
        return new ActionSheetBuilder(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ActionSheetBuilder) == true) goto L8;
        return false;
    L8:
        ActionSheetBuilder r101 = (ActionSheetBuilder) r100;
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemColor, r101.itemColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.context.hashCode() * 31;
        String r101 = this.title;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.subtitle;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.itemColor;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((r107 + r102) * 31) + this.actions.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionSheetBuilder(context=" + this.context + ", title=" + this.title + ", subtitle=" + this.subtitle + ", itemColor=" + this.itemColor + ", actions=" + this.actions + ')';
    }

    public final List<ActionSheetBuilderAction> getActions() {
        return this.actions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Integer getItemColor() {
        return this.itemColor;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public ActionSheetBuilder(Context r100, String r101, String r102, Integer r103, List<ActionSheetBuilderAction> r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, SlcCommonAction.KEY_ACTIONS);
        this.context = r100;
        this.title = r101;
        this.subtitle = r102;
        this.itemColor = r103;
        this.actions = r104;
    }

    public /* synthetic */ ActionSheetBuilder(Context r100, String r101, String r110, Integer r111, List r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        String r102 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        Integer r104 = null;
    L14:
        this(r100, r102, r103, r104, r112);
        return;
    L13:
        r104 = r111;
        goto L14
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
