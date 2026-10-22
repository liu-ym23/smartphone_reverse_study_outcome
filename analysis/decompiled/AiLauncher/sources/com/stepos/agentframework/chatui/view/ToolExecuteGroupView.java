package com.stepos.agentframework.chatui.view;

import Z8.C1172u;
import Z8.C1173v;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.r2;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0085\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u000bJ\u000f\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u000bJ\u001f\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010\u000bJ!\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000f0$0#H\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0#¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b+\u0010,J7\u00101\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00162\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u00100\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\t¢\u0006\u0004\b3\u0010\u000bJ!\u00106\u001a\u00020\t2\b\b\u0002\u00104\u001a\u00020\u00062\b\b\u0002\u00105\u001a\u00020\u0006¢\u0006\u0004\b6\u0010 J\u0017\u00107\u001a\u00020\t2\b\b\u0002\u00104\u001a\u00020\u0006¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\tH\u0014¢\u0006\u0004\b9\u0010\u000bJ\u000f\u0010:\u001a\u00020\tH\u0014¢\u0006\u0004\b:\u0010\u000bJ\u001f\u0010>\u001a\u00020\t2\u0006\u0010;\u001a\u00020%2\u0006\u0010=\u001a\u00020<H\u0014¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\t2\u0006\u0010=\u001a\u00020<H\u0014¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\bB\u00108R\u0014\u0010C\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010GR\u0014\u0010I\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010GR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010DR\u0014\u0010N\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010DR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR$\u0010S\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\bR*\u0010W\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R0\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR0\u0010f\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0dj\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f`e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010h\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\"\u0010j\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010T\u001a\u0004\bk\u0010\b\"\u0004\bl\u00108R\"\u0010m\u001a\u00020<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010\u001b\u001a\u0004\bn\u0010o\"\u0004\bp\u0010AR6\u0010r\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\t\u0018\u00010q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010iR\u0018\u0010y\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010{\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010zR\u0018\u0010|\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010zR\u0016\u0010}\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010TR\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010TR\u0017\u0010\u007f\u001a\u00020~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00168@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\u0018R\u0016\u0010\u0084\u0001\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\b¨\u0006\u0086\u0001"}, d2 = {"Lcom/stepos/agentframework/chatui/view/ToolExecuteGroupView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "p", "()Z", "LY8/t;", "K", "()V", "H", "r", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcom/stepos/agentframework/chatui/P1;", "tool", "Lcom/stepos/agentframework/chatui/view/G0;", "u", "(Lcom/stepos/agentframework/chatui/P1;)Lcom/stepos/agentframework/chatui/view/G0;", "x", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "F", "()Ljava/lang/String;", "y", "t", "I", "G", "expanded", "animate", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(ZZ)V", "m", "k", "", "Lkotlin/Pair;", "Landroid/view/View;", "J", "()Ljava/util/List;", "tools", "setTools", "(Ljava/util/List;)V", "L", "(Lcom/stepos/agentframework/chatui/P1;)V", "toolName", "parameter", "displayName", "processingStarted", "B", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "w", "collapse", "finalizeGroupTitle", "C", ExifInterface.LONGITUDE_EAST, "(Z)V", "onAttachedToWindow", "onDetachedFromWindow", "changedView", "", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "(I)V", "z", "headerLayout", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "titleText", "Landroid/widget/TextView;", "separatorText", "subtitleText", "Landroid/widget/ImageView;", "expandIcon", "Landroid/widget/ImageView;", "cardLayout", "container", "Lcom/stepos/agentframework/chatui/view/u0;", "titleShimmer", "Lcom/stepos/agentframework/chatui/view/u0;", UxipConstants.f30680s, "isExpand", "Z", "q", "Lkotlin/Function0;", "onHeaderClick", "Lp9/a;", "getOnHeaderClick", "()Lp9/a;", "setOnHeaderClick", "(Lp9/a;)V", "Lkotlin/Function1;", "onToolExpansionClick", "Lp9/l;", "getOnToolExpansionClick", "()Lp9/l;", "setOnToolExpansionClick", "(Lp9/l;)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "toolModel", "Ljava/util/LinkedHashMap;", "finishedOverrideAll", "Ljava/lang/Boolean;", "withToolActionLayout", "getWithToolActionLayout", "setWithToolActionLayout", "receiveTextColor", "getReceiveTextColor", "()I", "setReceiveTextColor", "Lkotlin/Function2;", "onLikeClickedListener", "Lp9/p;", "getOnLikeClickedListener", "()Lp9/p;", "setOnLikeClickedListener", "(Lp9/p;)V", "lockedSingleMode", "currentToolName", "Ljava/lang/String;", "currentToolParameter", "currentToolDisplayName", "messageProcessingStarted", "Lcom/stepos/agentframework/chatui/view/ToolExecuteGroupView$GroupState;", "groupState", "Lcom/stepos/agentframework/chatui/view/ToolExecuteGroupView$GroupState;", "getExpansionKey$agentcore_release", "expansionKey", "s", "isTitleShimmerRequested", "GroupState", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public final class ToolExecuteGroupView extends LinearLayout {
    private final LinearLayout cardLayout;
    private final LinearLayout container;
    private String currentToolDisplayName;
    private String currentToolName;
    private String currentToolParameter;
    private final ImageView expandIcon;
    private boolean finalizeGroupTitle;
    private Boolean finishedOverrideAll;
    private GroupState groupState;
    private final LinearLayout headerLayout;
    private boolean isExpand;
    private Boolean lockedSingleMode;
    private boolean messageProcessingStarted;
    private InterfaceC5063a<Y8.t> onHeaderClick;
    private p9.p<? super String, ? super Integer, Y8.t> onLikeClickedListener;
    private InterfaceC5074l<? super Boolean, Y8.t> onToolExpansionClick;
    private int receiveTextColor;
    private final TextView separatorText;
    private final TextView subtitleText;
    private u0 titleShimmer;
    private final TextView titleText;
    private final LinkedHashMap<String, DisplayTool> toolModel;
    private boolean withToolActionLayout;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatui/view/ToolExecuteGroupView$GroupState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CALLING", "COMPLETED", "TERMINATED", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GroupState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ GroupState[] $VALUES;
        public static final GroupState IDLE = new GroupState("IDLE", 0);
        public static final GroupState CALLING = new GroupState("CALLING", 1);
        public static final GroupState COMPLETED = new GroupState("COMPLETED", 2);
        public static final GroupState TERMINATED = new GroupState("TERMINATED", 3);

        private static final /* synthetic */ GroupState[] $values() {
            return new GroupState[]{IDLE, CALLING, COMPLETED, TERMINATED};
        }

        static {
            GroupState[] groupStateArr$values = $values();
            $VALUES = groupStateArr$values;
            $ENTRIES = kotlin.enums.a.a(groupStateArr$values);
        }

        private GroupState(String str, int i10) {
        }

        public static InterfaceC4149a<GroupState> getEntries() {
            return $ENTRIES;
        }

        public static GroupState valueOf(String str) {
            return (GroupState) Enum.valueOf(GroupState.class, str);
        }

        public static GroupState[] values() {
            return (GroupState[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/view/ToolExecuteGroupView$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) throws Exception {
            kotlin.jvm.internal.p.i(animation, "animation");
            ToolExecuteGroupView.this.cardLayout.setVisibility(8);
            ToolExecuteGroupView.this.cardLayout.getLayoutParams().height = -2;
            ToolExecuteGroupView.this.cardLayout.setAlpha(1.0f);
            ToolExecuteGroupView.this.cardLayout.requestLayout();
            if (ToolExecuteGroupView.this.getIsExpand()) {
                return;
            }
            ToolExecuteGroupView.this.H();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/view/ToolExecuteGroupView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            ToolExecuteGroupView.this.cardLayout.getLayoutParams().height = -2;
            ToolExecuteGroupView.this.cardLayout.requestLayout();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolExecuteGroupView(Context context) {
        super(context, null);
        kotlin.jvm.internal.p.i(context, "context");
        this.toolModel = new LinkedHashMap<>();
        this.receiveTextColor = -1;
        setOrientation(1);
        B4.b bVarB = B4.b.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(bVarB, "inflate(...)");
        LinearLayout llToolGroupHeader = bVarB.llToolGroupHeader;
        kotlin.jvm.internal.p.h(llToolGroupHeader, "llToolGroupHeader");
        this.headerLayout = llToolGroupHeader;
        TextView tvToolGroupTitle = bVarB.tvToolGroupTitle;
        kotlin.jvm.internal.p.h(tvToolGroupTitle, "tvToolGroupTitle");
        this.titleText = tvToolGroupTitle;
        TextView tvToolGroupSeparator = bVarB.tvToolGroupSeparator;
        kotlin.jvm.internal.p.h(tvToolGroupSeparator, "tvToolGroupSeparator");
        this.separatorText = tvToolGroupSeparator;
        TextView tvToolGroupSubtitle = bVarB.tvToolGroupSubtitle;
        kotlin.jvm.internal.p.h(tvToolGroupSubtitle, "tvToolGroupSubtitle");
        this.subtitleText = tvToolGroupSubtitle;
        ImageView ivToolGroupExpand = bVarB.ivToolGroupExpand;
        kotlin.jvm.internal.p.h(ivToolGroupExpand, "ivToolGroupExpand");
        this.expandIcon = ivToolGroupExpand;
        LinearLayout llToolGroupCard = bVarB.llToolGroupCard;
        kotlin.jvm.internal.p.h(llToolGroupCard, "llToolGroupCard");
        this.cardLayout = llToolGroupCard;
        LinearLayout llToolGroupContainer = bVarB.llToolGroupContainer;
        kotlin.jvm.internal.p.h(llToolGroupContainer, "llToolGroupContainer");
        this.container = llToolGroupContainer;
        this.titleShimmer = new u0(C1173v.p(tvToolGroupTitle, tvToolGroupSeparator, tvToolGroupSubtitle));
        llToolGroupHeader.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToolExecuteGroupView.f(this.f23152a, view);
            }
        });
        A(false, false);
        K();
        this.finalizeGroupTitle = true;
        this.groupState = GroupState.IDLE;
    }

    public static /* synthetic */ void D(ToolExecuteGroupView toolExecuteGroupView, boolean z10, boolean z11, int i10, Object obj) throws Exception {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        toolExecuteGroupView.C(z10, z11);
    }

    public static final void f(ToolExecuteGroupView toolExecuteGroupView, View view) {
        if (toolExecuteGroupView.p()) {
            InterfaceC5063a<Y8.t> interfaceC5063a = toolExecuteGroupView.onHeaderClick;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            toolExecuteGroupView.A(!toolExecuteGroupView.isExpand, true);
        }
    }

    public static final void l(ToolExecuteGroupView toolExecuteGroupView, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.p.i(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        toolExecuteGroupView.cardLayout.getLayoutParams().height = ((Integer) animatedValue).intValue();
        toolExecuteGroupView.cardLayout.requestLayout();
    }

    public static final void n(final ToolExecuteGroupView toolExecuteGroupView) {
        toolExecuteGroupView.cardLayout.measure(View.MeasureSpec.makeMeasureSpec(toolExecuteGroupView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        ValueAnimator duration = ValueAnimator.ofInt(0, toolExecuteGroupView.cardLayout.getMeasuredHeight()).setDuration(250L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.chatui.view.z0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ToolExecuteGroupView.o(this.f23155a, valueAnimator);
            }
        });
        duration.addListener(toolExecuteGroupView.new b());
        toolExecuteGroupView.cardLayout.setAlpha(0.0f);
        toolExecuteGroupView.cardLayout.animate().alpha(1.0f).setDuration(250L).start();
        duration.start();
    }

    public static final void o(ToolExecuteGroupView toolExecuteGroupView, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.p.i(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        toolExecuteGroupView.cardLayout.getLayoutParams().height = ((Integer) animatedValue).intValue();
        toolExecuteGroupView.cardLayout.requestLayout();
    }

    public static final Y8.t v(ToolExecuteGroupView toolExecuteGroupView, boolean z10) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = toolExecuteGroupView.onToolExpansionClick;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        return Y8.t.f7040a;
    }

    public final void A(boolean expanded, boolean animate) {
        boolean z10 = this.isExpand;
        this.isExpand = expanded;
        if (expanded) {
            this.expandIcon.setRotation(90.0f);
            H();
            if (animate) {
                m();
                return;
            } else {
                this.cardLayout.setVisibility(0);
                return;
            }
        }
        this.expandIcon.setRotation(0.0f);
        if (animate && z10) {
            k();
        } else {
            this.cardLayout.setVisibility(8);
            H();
        }
    }

    public final void B(String toolName, String parameter, String displayName, boolean processingStarted) throws Exception {
        kotlin.jvm.internal.p.i(toolName, "toolName");
        this.groupState = GroupState.CALLING;
        this.currentToolName = toolName;
        this.currentToolParameter = parameter;
        this.currentToolDisplayName = displayName;
        this.messageProcessingStarted = processingStarted;
        this.finishedOverrideAll = null;
        x();
        I();
    }

    public final void C(boolean collapse, boolean finalizeGroupTitle) throws Exception {
        this.groupState = GroupState.COMPLETED;
        this.finalizeGroupTitle = finalizeGroupTitle;
        y();
        I();
        if (collapse) {
            A(false, false);
        }
        t();
    }

    public final void E(boolean collapse) throws Exception {
        this.groupState = GroupState.TERMINATED;
        G();
        this.titleText.setText(getContext().getString(R$string.chat_thinking_terminated));
        this.separatorText.setVisibility(8);
        this.subtitleText.setVisibility(8);
        if (collapse) {
            A(false, false);
        }
        t();
    }

    public final String F() {
        if (!r()) {
            return null;
        }
        Collection<DisplayTool> collectionValues = this.toolModel.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        DisplayTool displayTool = (DisplayTool) Z8.F.r0(collectionValues);
        if (displayTool == null) {
            return null;
        }
        String strC = r2.INSTANCE.c(displayTool.getName(), displayTool.getDisplayName(), displayTool.getParameter());
        if (strC != null) {
            return strC;
        }
        String string = getContext().getString(R$string.chat_tool_unknown);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        return string;
    }

    public final void G() throws Exception {
        u0 u0Var = this.titleShimmer;
        if (u0Var != null) {
            u0Var.g();
        }
    }

    public final void H() throws Exception {
        DisplayTool tool;
        String toolCallId;
        if (!this.isExpand) {
            if (this.container.getChildCount() > 0) {
                this.container.removeAllViews();
            }
            i();
            return;
        }
        HashMap map = new HashMap(this.container.getChildCount());
        int childCount = this.container.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.container.getChildAt(i10);
            G0 g02 = childAt instanceof G0 ? (G0) childAt : null;
            if (g02 != null && (tool = g02.getTool()) != null && (toolCallId = tool.getToolCallId()) != null) {
                map.put(toolCallId, g02);
            }
        }
        for (Map.Entry<String, DisplayTool> entry : this.toolModel.entrySet()) {
            String key = entry.getKey();
            DisplayTool value = entry.getValue();
            G0 g03 = (G0) map.get(key);
            if (g03 != null) {
                g03.setWithToolActionLayout(this.withToolActionLayout);
                g03.setOnLikeClickedListener(this.onLikeClickedListener);
                g03.v(value);
            } else {
                this.container.addView(u(value));
            }
        }
        i();
    }

    public final void I() throws Exception {
        if (s() && isAttachedToWindow() && isShown() && getWindowVisibility() == 0) {
            u0 u0Var = this.titleShimmer;
            if (u0Var != null) {
                u0Var.e();
                return;
            }
            return;
        }
        u0 u0Var2 = this.titleShimmer;
        if (u0Var2 != null) {
            u0Var2.g();
        }
    }

    public final List<Pair<View, DisplayTool>> J() {
        DisplayTool tool;
        if (r()) {
            if (this.groupState == GroupState.TERMINATED) {
                return C1173v.m();
            }
            Collection<DisplayTool> collectionValues = this.toolModel.values();
            kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
            DisplayTool displayTool = (DisplayTool) Z8.F.r0(collectionValues);
            List<Pair<View, DisplayTool>> listE = displayTool != null ? C1172u.e(Y8.j.a(this.titleText, displayTool)) : null;
            return listE == null ? C1173v.m() : listE;
        }
        C5680i c5680iS = C5685n.s(0, this.container.getChildCount());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            View childAt = this.container.getChildAt(((Z8.M) it).nextInt());
            G0 g02 = childAt instanceof G0 ? (G0) childAt : null;
            Pair pairA = (g02 == null || (tool = g02.getTool()) == null) ? null : Y8.j.a(g02.getTvMcpTitle(), tool);
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return arrayList;
    }

    public final void K() {
        boolean zP = p();
        this.expandIcon.setVisibility(zP ? 0 : 8);
        if (zP || !this.isExpand) {
            return;
        }
        A(false, false);
    }

    public final void L(DisplayTool tool) throws Exception {
        kotlin.jvm.internal.p.i(tool, "tool");
        if (tool.k()) {
            return;
        }
        this.toolModel.put(tool.getToolCallId(), tool);
        H();
    }

    public final String getExpansionKey$agentcore_release() {
        Set<String> setKeySet = this.toolModel.keySet();
        kotlin.jvm.internal.p.h(setKeySet, "<get-keys>(...)");
        String str = (String) Z8.F.r0(setKeySet);
        if (str == null || La.H.x0(str)) {
            return null;
        }
        return str;
    }

    public final InterfaceC5063a<Y8.t> getOnHeaderClick() {
        return this.onHeaderClick;
    }

    public final p9.p<String, Integer, Y8.t> getOnLikeClickedListener() {
        return this.onLikeClickedListener;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnToolExpansionClick() {
        return this.onToolExpansionClick;
    }

    public final int getReceiveTextColor() {
        return this.receiveTextColor;
    }

    public final boolean getWithToolActionLayout() {
        return this.withToolActionLayout;
    }

    public final void i() throws Exception {
        boolean zR = r();
        int childCount = this.container.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.container.getChildAt(i10);
            G0 g02 = childAt instanceof G0 ? (G0) childAt : null;
            if (g02 != null) {
                g02.setFlatMode(zR);
            }
        }
        K();
        if (this.groupState == GroupState.CALLING) {
            x();
        }
    }

    public final void j() {
        String str = this.currentToolName;
        if (str == null) {
            return;
        }
        String strC = r2.INSTANCE.c(str, this.currentToolDisplayName, this.currentToolParameter);
        if (strC == null) {
            this.separatorText.setVisibility(8);
            this.subtitleText.setVisibility(8);
        } else {
            this.subtitleText.setText(H0.INSTANCE.c(strC));
            this.separatorText.setVisibility(0);
            this.subtitleText.setVisibility(0);
        }
    }

    public final void k() {
        if (this.cardLayout.getVisibility() != 0) {
            H();
            return;
        }
        ValueAnimator duration = ValueAnimator.ofInt(this.cardLayout.getMeasuredHeight(), 0).setDuration(250L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.chatui.view.w0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ToolExecuteGroupView.l(this.f23148a, valueAnimator);
            }
        });
        this.cardLayout.animate().alpha(0.0f).setDuration(250L).start();
        duration.addListener(new a());
        duration.start();
    }

    public final void m() {
        if (this.cardLayout.getVisibility() == 8) {
            this.cardLayout.setVisibility(0);
            this.cardLayout.getLayoutParams().height = 0;
            this.cardLayout.requestLayout();
            post(new Runnable() { // from class: com.stepos.agentframework.chatui.view.v0
                @Override // java.lang.Runnable
                public final void run() {
                    ToolExecuteGroupView.n(this.f23147a);
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Exception {
        super.onAttachedToWindow();
        I();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() throws Exception {
        super.onDetachedFromWindow();
        G();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) throws Exception {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        I();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) throws Exception {
        super.onWindowVisibilityChanged(visibility);
        I();
    }

    public final boolean p() {
        return (this.toolModel.isEmpty() || r()) ? false : true;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsExpand() {
        return this.isExpand;
    }

    public final boolean r() {
        if (this.toolModel.size() > 1) {
            this.lockedSingleMode = Boolean.FALSE;
        }
        return kotlin.jvm.internal.p.d(this.lockedSingleMode, Boolean.TRUE);
    }

    public final boolean s() {
        GroupState groupState = this.groupState;
        if (groupState != GroupState.CALLING) {
            return groupState == GroupState.COMPLETED && !this.finalizeGroupTitle && F() == null;
        }
        return true;
    }

    public final void setOnHeaderClick(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onHeaderClick = interfaceC5063a;
    }

    public final void setOnLikeClickedListener(p9.p<? super String, ? super Integer, Y8.t> pVar) {
        this.onLikeClickedListener = pVar;
    }

    public final void setOnToolExpansionClick(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onToolExpansionClick = interfaceC5074l;
    }

    public final void setReceiveTextColor(int i10) {
        this.receiveTextColor = i10;
    }

    public final void setTools(List<DisplayTool> tools) throws Exception {
        kotlin.jvm.internal.p.i(tools, "tools");
        ArrayList<DisplayTool> arrayList = new ArrayList();
        for (Object obj : tools) {
            if (!((DisplayTool) obj).k()) {
                arrayList.add(obj);
            }
        }
        if (this.lockedSingleMode == null && !arrayList.isEmpty()) {
            this.lockedSingleMode = Boolean.valueOf(arrayList.size() == 1);
        }
        for (DisplayTool displayTool : arrayList) {
            this.toolModel.put(displayTool.getToolCallId(), displayTool);
        }
        H();
    }

    public final void setWithToolActionLayout(boolean z10) {
        this.withToolActionLayout = z10;
    }

    public final void t() throws Exception {
        this.finishedOverrideAll = Boolean.TRUE;
        int childCount = this.container.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.container.getChildAt(i10);
            G0 g02 = childAt instanceof G0 ? (G0) childAt : null;
            if (g02 != null) {
                g02.setFinishedOverride(Boolean.TRUE);
            }
        }
    }

    public final G0 u(DisplayTool tool) throws Exception {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        G0 g02 = new G0(context);
        g02.setWithToolActionLayout(this.withToolActionLayout);
        g02.setReceiveTextColor(this.receiveTextColor);
        g02.setOnLikeClickedListener(this.onLikeClickedListener);
        g02.setOnExpansionClick(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.view.x0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ToolExecuteGroupView.v(this.f23150a, ((Boolean) obj).booleanValue());
            }
        });
        g02.v(tool);
        Boolean bool = this.finishedOverrideAll;
        if (bool != null) {
            g02.setFinishedOverride(bool);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        g02.setLayoutParams(layoutParams);
        return g02;
    }

    public final void w() throws Exception {
        String strF = F();
        GroupState groupState = this.groupState;
        if (groupState == GroupState.CALLING) {
            x();
        } else if (groupState == GroupState.COMPLETED) {
            y();
        } else if (strF == null && this.subtitleText.getVisibility() == 0 && this.currentToolName != null) {
            j();
        }
        I();
        int childCount = this.container.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.container.getChildAt(i10);
            if (childAt instanceof G0) {
                ((G0) childAt).s();
            }
        }
    }

    public final void x() {
        String strF = F();
        if (strF == null && !this.toolModel.isEmpty()) {
            this.titleText.setText(getContext().getString(R$string.chat_tool_steps_running, Integer.valueOf(this.toolModel.size())));
            this.separatorText.setVisibility(8);
            this.subtitleText.setVisibility(8);
            return;
        }
        if (strF == null && !this.messageProcessingStarted) {
            this.titleText.setText(getContext().getString(R$string.chat_loading_thinking));
            j();
            return;
        }
        if (strF == null) {
            r2 r2Var = r2.INSTANCE;
            String str = this.currentToolName;
            if (str == null) {
                str = "";
            }
            strF = r2Var.c(str, this.currentToolDisplayName, this.currentToolParameter);
            if (strF == null) {
                strF = getContext().getString(R$string.chat_tool_unknown);
                kotlin.jvm.internal.p.h(strF, "getString(...)");
            }
        }
        this.titleText.setText(H0.INSTANCE.c(strF));
        this.separatorText.setVisibility(8);
        this.subtitleText.setVisibility(8);
    }

    public final void y() {
        String string;
        String strF = F();
        TextView textView = this.titleText;
        if (strF != null) {
            string = H0.INSTANCE.a(strF);
        } else {
            string = getContext().getString(this.finalizeGroupTitle ? R$string.chat_tool_steps_completed : R$string.chat_tool_steps_running, Integer.valueOf(this.toolModel.size()));
            kotlin.jvm.internal.p.f(string);
        }
        textView.setText(string);
        this.separatorText.setVisibility(8);
        this.subtitleText.setVisibility(8);
    }

    public final void z(boolean expanded) {
        A(expanded && p(), false);
    }
}
