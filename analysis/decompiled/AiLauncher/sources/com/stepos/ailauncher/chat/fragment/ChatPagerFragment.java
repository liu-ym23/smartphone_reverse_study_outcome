package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
import V0.CreationExtras;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.C1398p;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import android.view.U;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.view.ArtifactsView;
import com.stepos.ailauncher.chat.view.C2804e4;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.chat.view.FloatInputView;
import com.stepos.ailauncher.chat.view.GlassAttachment;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.container.glass.SheetGlassStyle;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.sheet.SheetSettleState;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t0.C5502d;
import v9.C5685n;

@Metadata(d1 = {"\u0000Á\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0003{\u0095\u0001\u0018\u0000 º\u00012\u00020\u0001:\u0004»\u0001¼\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u001b\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u00020\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00102\b\b\u0002\u0010#\u001a\u00020\u0010H\u0002¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0010¢\u0006\u0004\b&\u0010'J!\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0010¢\u0006\u0004\b/\u0010\u0013J\r\u00100\u001a\u00020\u0010¢\u0006\u0004\b0\u0010'J\u0015\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0004¢\u0006\u0004\b5\u0010\u0003J\u0015\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0010¢\u0006\u0004\b7\u0010\u0013J\u0015\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0010¢\u0006\u0004\b9\u0010\u0013J\u0015\u0010:\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0010¢\u0006\u0004\b:\u0010\u0013J\r\u0010;\u001a\u00020\u0010¢\u0006\u0004\b;\u0010'J\u0015\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0010¢\u0006\u0004\b=\u0010\u0013J\u000f\u0010>\u001a\u00020\u0004H\u0016¢\u0006\u0004\b>\u0010\u0003J\u0017\u0010?\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b?\u0010\u0013J\u0017\u0010@\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b@\u0010\u0013J)\u0010F\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010A2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\u00102\b\b\u0002\u0010H\u001a\u00020\u0010¢\u0006\u0004\bI\u0010JJ!\u0010N\u001a\u00020\u00042\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00040K¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020\u0004¢\u0006\u0004\bP\u0010\u0003J\u0017\u0010Q\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\bQ\u0010!J\u0017\u0010S\u001a\u00020\u00042\u0006\u0010R\u001a\u000201H\u0016¢\u0006\u0004\bS\u00104J\u0017\u0010U\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u0010H\u0016¢\u0006\u0004\bU\u0010\u0013J\u0017\u0010W\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0010H\u0016¢\u0006\u0004\bW\u0010\u0013J\u001d\u0010Z\u001a\u00020\u00042\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0010¢\u0006\u0004\bZ\u0010\u0019J\u0015\u0010[\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u0010¢\u0006\u0004\b[\u0010\u0013J\u000f\u0010\\\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\\\u0010\u0003R\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010\nR\u0016\u0010l\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010p\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020u8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0014\u0010|\u001a\u00020{8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\nR\u0016\u0010\u007f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010\nR\u0018\u0010\u0080\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\nR\u0018\u0010\u0081\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\nR\u0018\u0010\u0082\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\nR\u0018\u0010\u0083\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010\nR\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u0088\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00040K0\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008d\u0001R(\u0010\u0090\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u008d\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\nR\u0017\u0010\u009a\u0001\u001a\u00020\u00068BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009d\u0001\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0019\u0010\u009f\u0001\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009c\u0001R\u0019\u0010¡\u0001\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010\u009c\u0001R\u0019\u0010£\u0001\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u009c\u0001R\u0019\u0010¥\u0001\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010\u009c\u0001R\u001a\u0010©\u0001\u001a\u0005\u0018\u00010¦\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R!\u0010¬\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002010\u008f\u00018F¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0016\u0010®\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010'R\u0016\u0010°\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010'R\u0016\u0010²\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b±\u0001\u0010'R\u0016\u0010´\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b³\u0001\u0010'R\u0016\u0010·\u0001\u001a\u0004\u0018\u00010L8F¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0013\u0010¹\u0001\u001a\u00020\u00108F¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010'¨\u0006½\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/ChatPagerFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", "i0", "", "scrollState", "h0", "(I)V", "Z", SdCardDbCreator.FIELD_LASTLOC_ID, "N0", "w0", "f0", "M0", "", "shown", "C0", "(Z)V", "g0", "Y", "page", "smooth", "Z0", "(IZ)V", "x0", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "S0", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "d0", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "rebind", "force", "b0", "(ZZ)V", "A0", "()Z", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", com.stepos.ailauncher.chat.util.g.REASON_RECORDING, "E0", "K0", "", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "a0", "(F)V", "J0", "suspended", "O0", "held", "P0", "Q0", "z0", "hidden", "R0", "onResume", "b1", "X0", "", "sessionId", "", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifacts", "T0", "(Ljava/lang/String;Ljava/util/List;)V", "animate", "j0", "(Z)Z", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/fragment/ChatFragment;", "action", "d1", "(Lp9/l;)V", "L0", "k", "progress", "f", "visible", Const.INTENT_KEY_BACKGROUND_COMMAND, "keyboardVisible", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "imeBottomPx", "showing", "D0", "B0", "onDestroyView", "Landroidx/viewpager2/widget/ViewPager2;", "pager", "Landroidx/viewpager2/widget/ViewPager2;", "Lcom/stepos/ailauncher/chat/view/e4;", "pagerSpring", "Lcom/stepos/ailauncher/chat/view/e4;", "Lcom/stepos/ailauncher/chat/view/ArtifactsView;", "artifactsView", "Lcom/stepos/ailauncher/chat/view/ArtifactsView;", "Lcom/stepos/ailauncher/chat/view/GlassAttachment;", "pagerGlass", "Lcom/stepos/ailauncher/chat/view/GlassAttachment;", "pagerGlassHost", "Landroid/view/View;", "retainingGlassForExit", "pagerGlassStyle", "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "pagerGlassTint", "I", "pagerGlassBlurPx", "F", "Lcom/stepos/ailauncher/container/glass/j;", "pagerGlassCommit", "Lcom/stepos/ailauncher/container/glass/j;", "Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel$delegate", "LY8/h;", "n0", "()Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel", "com/stepos/ailauncher/chat/fragment/ChatPagerFragment$d", "pageScrollCallback", "Lcom/stepos/ailauncher/chat/fragment/ChatPagerFragment$d;", "neighborWarmedUp", "sessionCenterGlassSuspended", "crossWindowGlassSuspended", "stackCoverPagesHidden", "panelBackplateShown", "panelBackplateHeld", "Ljava/lang/Runnable;", "panelBackplateRemoval", "Ljava/lang/Runnable;", "", "pendingChatActions", "Ljava/util/List;", "pendingInitialPage", "Ljava/lang/Integer;", "lastPagerVisible", "Ljava/lang/Boolean;", "lastImeKeyboardVisible", "Lkotlin/Pair;", "lastImeFrame", "Lkotlin/Pair;", "lastImeAnimationEndVisible", "lastSheetSettleState", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", "com/stepos/ailauncher/chat/fragment/ChatPagerFragment$c", "childCallbacks", "Lcom/stepos/ailauncher/chat/fragment/ChatPagerFragment$c;", "p0", "()I", "initialPage", "u0", "()Ljava/lang/String;", "launchSessionId", "t0", "launchInitialPrompt", "r0", "launchAgentId", "s0", "launchDeviceId", "q0", "launchAgentDisplayName", "Lcom/stepos/ailauncher/chat/fragment/SessionCenterFragment;", "v0", "()Lcom/stepos/ailauncher/chat/fragment/SessionCenterFragment;", "sessionCenterFragment", "o0", "()Lkotlin/Pair;", "exitPanelGlassLook", "e", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "c", "supportsSheetHalfSettle", "m", "hidesResidentInput", "m0", "()Lcom/stepos/ailauncher/chat/fragment/ChatFragment;", "chatFragment", "y0", "isChatPageCurrent", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatPagerFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_AGENT_DISPLAY_NAME = "agent_display_name";
    private static final String ARG_AGENT_ID = "agent_id";
    private static final String ARG_DEVICE_ID = "device_id";
    private static final String ARG_INITIAL_PAGE = "initial_page";
    private static final String ARG_INITIAL_PROMPT = "initial_prompt";
    private static final String ARG_SESSION_ID = "session_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float PAGER_GLASS_CORNER_DP = 28.0f;
    private static final float PAGER_GLASS_MATERIAL_CORNER_DP = 0.0f;
    public static final int PAGE_CHAT = 1;
    private static final int PAGE_COUNT = 2;
    public static final int PAGE_SESSION_CENTER = 0;
    private static final long PANEL_BACKPLATE_HOLD_MS = 150;
    private static final String TAG = "ChatPagerFragment";
    private ArtifactsView artifactsView;
    private final c childCallbacks;

    /* renamed from: coreViewModel$delegate, reason: from kotlin metadata */
    private final Y8.h coreViewModel;
    private boolean crossWindowGlassSuspended;
    private Boolean lastImeAnimationEndVisible;
    private Pair<Integer, Boolean> lastImeFrame;
    private Boolean lastImeKeyboardVisible;
    private Boolean lastPagerVisible;
    private SheetSettleState lastSheetSettleState;
    private boolean neighborWarmedUp;
    private final d pageScrollCallback;
    private ViewPager2 pager;
    private GlassAttachment pagerGlass;
    private float pagerGlassBlurPx;
    private final com.stepos.ailauncher.container.glass.j pagerGlassCommit;
    private View pagerGlassHost;
    private SheetGlassStyle pagerGlassStyle;
    private int pagerGlassTint;
    private C2804e4 pagerSpring;
    private boolean panelBackplateHeld;
    private final Runnable panelBackplateRemoval;
    private boolean panelBackplateShown;
    private final List<InterfaceC5074l<ChatFragment, Y8.t>> pendingChatActions;
    private Integer pendingInitialPage;
    private boolean recording;
    private boolean retainingGlassForExit;
    private boolean sessionCenterGlassSuspended;
    private boolean stackCoverPagesHidden;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0015R\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0015R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0015¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/ChatPagerFragment$a;", "", "<init>", "()V", "", "initialPage", "", "sessionId", "initialPrompt", "agentId", "deviceId", "agentDisplayName", "Lcom/stepos/ailauncher/chat/fragment/ChatPagerFragment;", "c", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/chat/fragment/ChatPagerFragment;", "", "cornerDp", "Landroid/view/ViewOutlineProvider;", Const.INTENT_KEY_PKGNAME, "(F)Landroid/view/ViewOutlineProvider;", "TAG", "Ljava/lang/String;", "PAGE_SESSION_CENTER", "I", "PAGE_CHAT", "PAGE_COUNT", "PAGER_GLASS_CORNER_DP", "F", "PAGER_GLASS_MATERIAL_CORNER_DP", "", "PANEL_BACKPLATE_HOLD_MS", "J", "ARG_INITIAL_PAGE", "ARG_SESSION_ID", "ARG_INITIAL_PROMPT", "ARG_AGENT_ID", "ARG_DEVICE_ID", "ARG_AGENT_DISPLAY_NAME", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/fragment/ChatPagerFragment$a$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$a$a, reason: collision with other inner class name */
        public static final class C0283a extends ViewOutlineProvider {
            final /* synthetic */ float $cornerDp;

            public C0283a(float f10) {
                this.$cornerDp = f10;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight() + view.getResources().getDisplayMetrics().heightPixels, this.$cornerDp * view.getResources().getDisplayMetrics().density);
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ ChatPagerFragment d(Companion companion, int i10, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str = null;
            }
            if ((i11 & 4) != 0) {
                str2 = null;
            }
            if ((i11 & 8) != 0) {
                str3 = null;
            }
            if ((i11 & 16) != 0) {
                str4 = null;
            }
            if ((i11 & 32) != 0) {
                str5 = null;
            }
            return companion.c(i10, str, str2, str3, str4, str5);
        }

        public final ViewOutlineProvider b(float cornerDp) {
            return new C0283a(cornerDp);
        }

        public final ChatPagerFragment c(int initialPage, String sessionId, String initialPrompt, String agentId, String deviceId, String agentDisplayName) {
            ChatPagerFragment chatPagerFragment = new ChatPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ChatPagerFragment.ARG_INITIAL_PAGE, initialPage);
            if (sessionId != null && sessionId.length() != 0) {
                bundle.putString("session_id", sessionId);
            }
            if (initialPrompt != null && !La.H.x0(initialPrompt)) {
                bundle.putString(ChatPagerFragment.ARG_INITIAL_PROMPT, initialPrompt);
            }
            if (agentId != null && !La.H.x0(agentId)) {
                bundle.putString(ChatPagerFragment.ARG_AGENT_ID, agentId);
            }
            if (deviceId != null && !La.H.x0(deviceId)) {
                bundle.putString("device_id", deviceId);
            }
            if (agentDisplayName != null && !La.H.x0(agentDisplayName)) {
                bundle.putString(ChatPagerFragment.ARG_AGENT_DISPLAY_NAME, agentDisplayName);
            }
            chatPagerFragment.setArguments(bundle);
            return chatPagerFragment;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/ChatPagerFragment$b;", "Landroidx/viewpager2/adapter/a;", "<init>", "(Lcom/stepos/ailauncher/chat/fragment/ChatPagerFragment;)V", "", "getItemCount", "()I", "position", "Landroidx/fragment/app/Fragment;", "e", "(I)Landroidx/fragment/app/Fragment;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends androidx.viewpager2.adapter.a {
        public b() {
            super(ChatPagerFragment.this.getChildFragmentManager(), ChatPagerFragment.this.getViewLifecycleOwner().getLifecycle());
        }

        @Override // androidx.viewpager2.adapter.a
        public Fragment e(int position) {
            if (position == 0) {
                return SessionCenterFragment.INSTANCE.a();
            }
            if (position == 1) {
                return ChatFragment.INSTANCE.a(ChatPagerFragment.this.u0(), ChatPagerFragment.this.t0(), ChatPagerFragment.this.r0(), ChatPagerFragment.this.s0(), ChatPagerFragment.this.q0());
            }
            throw new IllegalStateException(("Unexpected page position: " + position).toString());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 2;
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/fragment/ChatPagerFragment$c", "Landroidx/fragment/app/FragmentManager$k;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "f", "Landroid/view/View;", "v", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "m", "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;Landroid/view/View;Landroid/os/Bundle;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends FragmentManager.k {
        public c() {
        }

        @Override // androidx.fragment.app.FragmentManager.k
        public void m(FragmentManager fm, Fragment f10, View v10, Bundle savedInstanceState) {
            kotlin.jvm.internal.p.i(fm, "fm");
            kotlin.jvm.internal.p.i(f10, "f");
            kotlin.jvm.internal.p.i(v10, "v");
            if (f10 instanceof ChatFragment) {
                Boolean bool = ChatPagerFragment.this.lastImeKeyboardVisible;
                if (bool != null) {
                    ((ChatFragment) f10).h(bool.booleanValue());
                }
                Pair pair = ChatPagerFragment.this.lastImeFrame;
                if (pair != null) {
                    ChatPagerFragment chatPagerFragment = ChatPagerFragment.this;
                    int iIntValue = ((Number) pair.a()).intValue();
                    Boolean bool2 = (Boolean) pair.b();
                    boolean zBooleanValue = bool2.booleanValue();
                    if (kotlin.jvm.internal.p.d(bool2, chatPagerFragment.lastImeKeyboardVisible)) {
                        ((ChatFragment) f10).i0(iIntValue, zBooleanValue);
                    }
                }
                Boolean bool3 = ChatPagerFragment.this.lastImeAnimationEndVisible;
                if (bool3 != null) {
                    ((ChatFragment) f10).h0(bool3.booleanValue());
                }
                SheetSettleState sheetSettleState = ChatPagerFragment.this.lastSheetSettleState;
                if (sheetSettleState != null) {
                    ((ChatFragment) f10).k(sheetSettleState);
                }
                if (ChatPagerFragment.this.pendingChatActions.isEmpty()) {
                    return;
                }
                List listM1 = Z8.F.m1(ChatPagerFragment.this.pendingChatActions);
                ChatPagerFragment.this.pendingChatActions.clear();
                Iterator it = listM1.iterator();
                while (it.hasNext()) {
                    ((InterfaceC5074l) it.next()).invoke(f10);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/fragment/ChatPagerFragment$d", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "", "positionOffset", "positionOffsetPixels", "LY8/t;", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "onPageScrollStateChanged", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ViewPager2.i {
        public d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int state) {
            ChatPagerFragment.this.h0(state);
            if (state == 1) {
                ChatPagerFragment.this.x0();
            }
            if (state == 0) {
                ChatPagerFragment.this.M0();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            ChatPagerFragment.this.n0().J(C5685n.m(position + positionOffset, 0.0f, 1.0f));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            ChatFragment chatFragmentM0;
            androidx.fragment.app.r activity = ChatPagerFragment.this.getActivity();
            ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
            if (chatActivity != null) {
                ChatActivity.fa(chatActivity, null, 1, null);
            }
            if (position == 1 && (chatFragmentM0 = ChatPagerFragment.this.m0()) != null) {
                chatFragmentM0.g0();
            }
            ChatPagerFragment.this.M0();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$8", f = "ChatPagerFragment.kt", l = {457}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$8, reason: invalid class name */
    public static final class AnonymousClass8 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$8$1", f = "ChatPagerFragment.kt", l = {458}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$8$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            int label;
            final /* synthetic */ ChatPagerFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$8$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ ChatPagerFragment this$0;

                public a(ChatPagerFragment chatPagerFragment) {
                    this.this$0 = chatPagerFragment;
                }

                public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    this.this$0.i0();
                    return Y8.t.f7040a;
                }

                @Override // Xa.c
                public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                    return b(((Boolean) obj).booleanValue(), interfaceC4014c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ChatPagerFragment chatPagerFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = chatPagerFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.this$0, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.t<Boolean> tVarQ = this.this$0.n0().q();
                    a aVar = new a(this.this$0);
                    this.label = 1;
                    if (tVarQ.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        public AnonymousClass8(InterfaceC4014c<? super AnonymousClass8> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ChatPagerFragment.this.new AnonymousClass8(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass8) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                LifecycleOwner viewLifecycleOwner = ChatPagerFragment.this.getViewLifecycleOwner();
                kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ChatPagerFragment.this, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(viewLifecycleOwner, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$9", f = "ChatPagerFragment.kt", l = {466}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$9, reason: invalid class name */
    public static final class AnonymousClass9 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ View $view;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$9$1", f = "ChatPagerFragment.kt", l = {467}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$9$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ View $view;
            int label;
            final /* synthetic */ ChatPagerFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$onViewCreated$9$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ View $view;
                final /* synthetic */ ChatPagerFragment this$0;

                public a(View view, ChatPagerFragment chatPagerFragment) {
                    this.$view = view;
                    this.this$0 = chatPagerFragment;
                }

                public final Object b(float f10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    this.$view.setAlpha(f10);
                    this.$view.setTranslationY(r4.getHeight() * (1.0f - f10));
                    this.this$0.f0();
                    return Y8.t.f7040a;
                }

                @Override // Xa.c
                public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                    return b(((Number) obj).floatValue(), interfaceC4014c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ChatPagerFragment chatPagerFragment, View view, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = chatPagerFragment;
                this.$view = view;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass1(this.this$0, this.$view, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.t<Float> tVarN = this.this$0.n0().n();
                    a aVar = new a(this.$view, this.this$0);
                    this.label = 1;
                    if (tVarN.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(View view, InterfaceC4014c<? super AnonymousClass9> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$view = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ChatPagerFragment.this.new AnonymousClass9(this.$view, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass9) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                LifecycleOwner viewLifecycleOwner = ChatPagerFragment.this.getViewLifecycleOwner();
                kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                Lifecycle.State state = Lifecycle.State.STARTED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ChatPagerFragment.this, this.$view, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.b(viewLifecycleOwner, state, anonymousClass1, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    public ChatPagerFragment() {
        super(R$layout.fragment_chat_pager);
        SheetGlassStyle sheetGlassStyle = SheetGlassStyle.HALF;
        this.pagerGlassStyle = sheetGlassStyle;
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        this.pagerGlassTint = c2851i7.l(sheetGlassStyle);
        this.pagerGlassBlurPx = c2851i7.j(sheetGlassStyle);
        final InterfaceC5063a interfaceC5063a = null;
        this.pagerGlassCommit = new com.stepos.ailauncher.container.glass.j(0L, 1, null);
        this.coreViewModel = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.t.b(I0.class), new InterfaceC5063a<android.view.V>() { // from class: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final android.view.V invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new InterfaceC5063a<CreationExtras>() { // from class: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                InterfaceC5063a interfaceC5063a2 = interfaceC5063a;
                return (interfaceC5063a2 == null || (creationExtras = (CreationExtras) interfaceC5063a2.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new InterfaceC5063a<U.c>() { // from class: com.stepos.ailauncher.chat.fragment.ChatPagerFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final U.c invoke() {
                return this.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.pageScrollCallback = new d();
        this.panelBackplateRemoval = new Runnable() { // from class: com.stepos.ailauncher.chat.fragment.H1
            @Override // java.lang.Runnable
            public final void run() {
                ChatPagerFragment.I0(this.f25177a);
            }
        };
        this.pendingChatActions = new ArrayList();
        this.childCallbacks = new c();
    }

    public static final float F0(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        return 0.0f;
    }

    public static final Y8.t G0(View view, ViewOutlineProvider viewOutlineProvider) {
        view.setClipToOutline(true);
        view.setOutlineProvider(viewOutlineProvider);
        view.invalidateOutline();
        return Y8.t.f7040a;
    }

    public static final y7.E H0(ChatPagerFragment chatPagerFragment, View v10, boolean z10, Float f10, y7.o oVar) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(oVar, "<unused var>");
        return C2851i7.INSTANCE.g(v10, chatPagerFragment.pagerGlassTint, chatPagerFragment.pagerGlassBlurPx, z10, f10);
    }

    public static final void I0(ChatPagerFragment chatPagerFragment) {
        chatPagerFragment.w0();
    }

    public static final Y8.t U0(ChatPagerFragment chatPagerFragment) {
        k0(chatPagerFragment, false, 1, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t V0(ChatPagerFragment chatPagerFragment, String str, SessionArtifact artifact) {
        kotlin.jvm.internal.p.i(artifact, "artifact");
        Context contextRequireContext = chatPagerFragment.requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        if (str == null) {
            ChatFragment chatFragmentM0 = chatPagerFragment.m0();
            str = chatFragmentM0 != null ? chatFragmentM0.X() : null;
        }
        com.stepos.ailauncher.foundation.task.a.a(contextRequireContext, artifact, M5.c.SOURCE_ARTIFACT_SHEET, str);
        return Y8.t.f7040a;
    }

    public static final Y8.t W0(ChatPagerFragment chatPagerFragment, ViewPager2 viewPager2) {
        if (chatPagerFragment.artifactsView != null) {
            viewPager2.setVisibility(4);
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void Y0(ChatPagerFragment chatPagerFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        chatPagerFragment.X0(z10);
    }

    public static /* synthetic */ void c0(ChatPagerFragment chatPagerFragment, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        chatPagerFragment.b0(z10, z11);
    }

    public static /* synthetic */ void c1(ChatPagerFragment chatPagerFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        chatPagerFragment.b1(z10);
    }

    public static /* synthetic */ void e0(ChatPagerFragment chatPagerFragment, SheetSettleState sheetSettleState, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sheetSettleState = chatPagerFragment.s();
        }
        chatPagerFragment.d0(sheetSettleState);
    }

    public static /* synthetic */ boolean k0(ChatPagerFragment chatPagerFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return chatPagerFragment.j0(z10);
    }

    public static final Y8.t l0(ArtifactsView artifactsView, ViewGroup viewGroup) {
        com.stepos.ailauncher.chat.view.K.INSTANCE.l(artifactsView);
        viewGroup.removeView(artifactsView);
        artifactsView.o();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final I0 n0() {
        return (I0) this.coreViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String q0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_AGENT_DISPLAY_NAME)) == null || La.H.x0(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String r0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_AGENT_ID)) == null || La.H.x0(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String s0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("device_id")) == null || La.H.x0(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_INITIAL_PROMPT)) == null || La.H.x0(string)) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u0() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("session_id")) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public final boolean A0() {
        ViewPager2 viewPager2 = this.pager;
        if (viewPager2 == null || viewPager2.getVisibility() != 0 || viewPager2.getScrollState() != 0) {
            return false;
        }
        C2804e4 c2804e4 = this.pagerSpring;
        return (c2804e4 != null ? c2804e4.z() : viewPager2.getCurrentItem()) == 0;
    }

    public final void B0(boolean showing) {
        this.lastImeKeyboardVisible = Boolean.valueOf(showing);
        this.lastImeAnimationEndVisible = Boolean.valueOf(showing);
        ChatFragment chatFragmentM0 = m0();
        if (chatFragmentM0 != null) {
            chatFragmentM0.h0(showing);
        }
    }

    public final void C0(boolean shown) {
        C2804e4 c2804e4 = this.pagerSpring;
        if (c2804e4 == null) {
            return;
        }
        Boolean bool = this.lastPagerVisible;
        this.lastPagerVisible = Boolean.valueOf(shown);
        if (bool == null || kotlin.jvm.internal.p.d(Boolean.valueOf(shown), bool) || c2804e4.z() != 0) {
            return;
        }
        if (shown) {
            SessionCenterFragment sessionCenterFragmentV0 = v0();
            if (sessionCenterFragmentV0 != null) {
                sessionCenterFragmentV0.P();
                return;
            }
            return;
        }
        SessionCenterFragment sessionCenterFragmentV02 = v0();
        if (sessionCenterFragmentV02 != null) {
            sessionCenterFragmentV02.O();
        }
    }

    public final void D0(int imeBottomPx, boolean showing) {
        if (!kotlin.jvm.internal.p.d(this.lastImeKeyboardVisible, Boolean.valueOf(showing))) {
            this.lastImeAnimationEndVisible = null;
            this.lastImeFrame = null;
        }
        this.lastImeKeyboardVisible = Boolean.valueOf(showing);
        this.lastImeFrame = Y8.j.a(Integer.valueOf(imeBottomPx), Boolean.valueOf(showing));
        ChatFragment chatFragmentM0 = m0();
        if (chatFragmentM0 != null) {
            chatFragmentM0.i0(imeBottomPx, showing);
        }
    }

    public final void E0(boolean recording) {
        if (this.recording == recording) {
            return;
        }
        this.recording = recording;
        i0();
    }

    public final void J0() {
        GlassAttachment glassAttachment = this.pagerGlass;
        if (glassAttachment != null) {
            glassAttachment.n();
        }
        this.pagerGlass = null;
        w0();
    }

    public final boolean K0() {
        View view;
        GlassAttachment glassAttachment = this.pagerGlass;
        if (glassAttachment == null || !glassAttachment.o() || (view = this.pagerGlassHost) == null || !view.isShown()) {
            return false;
        }
        this.retainingGlassForExit = true;
        return true;
    }

    public final void L0() {
        e0(this, null, 1, null);
        f0();
    }

    public final void M0() {
        ViewPager2 viewPager2 = this.pager;
        if (viewPager2 != null && viewPager2.getScrollState() == 0) {
            C2804e4 c2804e4 = this.pagerSpring;
            if ((c2804e4 != null ? c2804e4.z() : viewPager2.getCurrentItem()) == 0 && viewPager2.getVisibility() == 0) {
                SessionCenterFragment sessionCenterFragmentV0 = v0();
                if (sessionCenterFragmentV0 != null) {
                    sessionCenterFragmentV0.P();
                    return;
                }
                return;
            }
            SessionCenterFragment sessionCenterFragmentV02 = v0();
            if (sessionCenterFragmentV02 != null) {
                sessionCenterFragmentV02.O();
            }
        }
    }

    public final void N0() {
        View view = getView();
        if (view != null && this.panelBackplateShown) {
            view.removeCallbacks(this.panelBackplateRemoval);
            if (this.crossWindowGlassSuspended || this.panelBackplateHeld) {
                return;
            }
            view.postDelayed(this.panelBackplateRemoval, 150L);
        }
    }

    public final void O0(boolean suspended) {
        this.crossWindowGlassSuspended = suspended;
        Z();
    }

    public final void P0(boolean held) {
        if (this.panelBackplateHeld == held) {
            return;
        }
        this.panelBackplateHeld = held;
        if (!held) {
            N0();
            return;
        }
        View view = getView();
        if (view != null) {
            view.removeCallbacks(this.panelBackplateRemoval);
        }
    }

    public final void Q0(boolean suspended) {
        this.sessionCenterGlassSuspended = suspended;
        SessionCenterFragment sessionCenterFragmentV0 = v0();
        if (sessionCenterFragmentV0 != null) {
            sessionCenterFragmentV0.Q(suspended);
        }
    }

    public final void R0(boolean hidden) {
        if (this.stackCoverPagesHidden == hidden) {
            return;
        }
        this.stackCoverPagesHidden = hidden;
        f0();
    }

    public final SheetGlassStyle S0(SheetSettleState state) {
        return state == SheetSettleState.FULL ? SheetGlassStyle.FULL : SheetGlassStyle.HALF;
    }

    public final void T0(final String sessionId, List<SessionArtifact> artifacts) {
        final ViewPager2 viewPager2;
        View view = getView();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null || (viewPager2 = this.pager) == null) {
            return;
        }
        if (this.artifactsView != null) {
            j0(false);
        }
        Context contextRequireContext = requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        ArtifactsView artifactsView = new ArtifactsView(contextRequireContext, null, 0, 6, null);
        artifactsView.setOnExit(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.M1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatPagerFragment.U0(this.f25193a);
            }
        });
        artifactsView.setOnArtifactClick(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.N1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatPagerFragment.V0(this.f25195a, sessionId, (SessionArtifact) obj);
            }
        });
        viewGroup.addView(artifactsView, new FrameLayout.LayoutParams(-1, -1));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        artifactsView.j(viewLifecycleOwner, sessionId, artifacts);
        this.artifactsView = artifactsView;
        i0();
        Y();
        n0().J(0.0f);
        com.stepos.ailauncher.chat.view.K.INSTANCE.j(artifactsView, viewPager2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.O1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatPagerFragment.W0(this.f25200a, viewPager2);
            }
        });
    }

    public final void X0(boolean smooth) {
        Z0(1, smooth);
    }

    public final void Y() {
        androidx.fragment.app.r activity = getActivity();
        com.stepos.ailauncher.sheet.S s10 = activity instanceof com.stepos.ailauncher.sheet.S ? (com.stepos.ailauncher.sheet.S) activity : null;
        if (s10 == null) {
            return;
        }
        s10.M3(j());
        s10.O3(c());
        s10.u4();
    }

    public final void Z() {
        if (this.pagerGlassHost == null) {
            return;
        }
        if (!this.crossWindowGlassSuspended) {
            GlassAttachment glassAttachment = this.pagerGlass;
            if (glassAttachment != null) {
                glassAttachment.s(false);
            }
            N0();
            return;
        }
        a1();
        GlassAttachment glassAttachment2 = this.pagerGlass;
        if (glassAttachment2 != null) {
            glassAttachment2.s(true);
        }
    }

    public final void Z0(int page, boolean smooth) {
        C2804e4 c2804e4 = this.pagerSpring;
        if (c2804e4 == null || c2804e4.z() == page) {
            return;
        }
        x0();
        c2804e4.H(page, smooth);
    }

    public final void a0(float alpha) {
        View view = getView();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != this.pagerGlassHost) {
                childAt.setAlpha(alpha);
            }
        }
    }

    public final void a1() {
        View view = getView();
        if (view == null) {
            return;
        }
        view.removeCallbacks(this.panelBackplateRemoval);
        float f10 = view.getResources().getDisplayMetrics().density * 28.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{f10, f10, f10, f10, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(C5502d.k(this.pagerGlassTint, 255));
        view.setBackground(gradientDrawable);
        this.panelBackplateShown = true;
    }

    public final void b0(boolean rebind, boolean force) {
        GlassAttachment glassAttachment;
        if (this.retainingGlassForExit) {
            return;
        }
        com.stepos.ailauncher.sheet.S sT = t();
        Float fValueOf = sT != null ? Float.valueOf(sT.W1()) : null;
        SheetSettleState sheetSettleStateS1 = sT != null ? sT.S1() : null;
        SheetSettleState sheetSettleState = SheetSettleState.FULL;
        float fFloatValue = 1.0f;
        if (sheetSettleStateS1 != sheetSettleState || sT.N1() == sheetSettleState || sT.N1() == SheetSettleState.HALF) {
            if (fValueOf != null) {
                fFloatValue = fValueOf.floatValue();
            } else if (this.pagerGlassStyle != SheetGlassStyle.FULL) {
                fFloatValue = 0.0f;
            }
        }
        Pair<Integer, Float> pairK = C2851i7.INSTANCE.k(fFloatValue);
        int iIntValue = pairK.a().intValue();
        float fFloatValue2 = pairK.b().floatValue();
        if (iIntValue != this.pagerGlassTint || Math.abs(fFloatValue2 - this.pagerGlassBlurPx) >= 0.5f) {
            if (!rebind || this.pagerGlassCommit.a(force)) {
                this.pagerGlassTint = iIntValue;
                this.pagerGlassBlurPx = fFloatValue2;
                if (!rebind || (glassAttachment = this.pagerGlass) == null) {
                    return;
                }
                glassAttachment.p();
            }
        }
    }

    public final void b1(boolean smooth) {
        Z0(0, smooth);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean c() {
        return this.artifactsView == null;
    }

    public final void d0(SheetSettleState state) {
        this.pagerGlassStyle = S0(state);
        c0(this, false, true, 1, null);
    }

    public final void d1(InterfaceC5074l<? super ChatFragment, Y8.t> action) {
        kotlin.jvm.internal.p.i(action, "action");
        Y0(this, false, 1, null);
        ChatFragment chatFragmentM0 = m0();
        if (chatFragmentM0 != null) {
            action.invoke(chatFragmentM0);
        } else {
            this.pendingChatActions.add(action);
            C4148a.d(TAG, "Chat page not created yet, action deferred", false, 4, null);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void f(float progress) {
        c0(this, false, false, 3, null);
        List<Fragment> listZ0 = getChildFragmentManager().z0();
        kotlin.jvm.internal.p.h(listZ0, "getFragments(...)");
        for (android.view.W w10 : listZ0) {
            com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
            if (dVar != null) {
                dVar.f(progress);
            }
        }
    }

    public final void f0() {
        int i10 = 0;
        boolean z10 = ((v() == SheetSettleState.MINIFY) || ((n0().n().getValue().floatValue() > 0.0f ? 1 : (n0().n().getValue().floatValue() == 0.0f ? 0 : -1)) <= 0) || this.artifactsView != null || this.stackCoverPagesHidden) ? false : true;
        ViewPager2 viewPager2 = this.pager;
        if (viewPager2 != null) {
            viewPager2.setVisibility(z10 ? 0 : 4);
        }
        View view = getView();
        if (view != null) {
            if (!this.stackCoverPagesHidden && !z10 && this.artifactsView == null) {
                i10 = 4;
            }
            view.setVisibility(i10);
        }
        g0();
        C0(z10);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void g(boolean visible) {
        List<Fragment> listZ0 = getChildFragmentManager().z0();
        kotlin.jvm.internal.p.h(listZ0, "getFragments(...)");
        for (android.view.W w10 : listZ0) {
            com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
            if (dVar != null) {
                dVar.g(visible);
            }
        }
    }

    public final void g0() {
        C2804e4 c2804e4;
        Integer num = this.pendingInitialPage;
        if (num != null) {
            int iIntValue = num.intValue();
            ViewPager2 viewPager2 = this.pager;
            if (viewPager2 == null || (c2804e4 = this.pagerSpring) == null) {
                return;
            }
            if (c2804e4.z() != iIntValue) {
                c2804e4.H(iIntValue, false);
            }
            if (viewPager2.getVisibility() == 0) {
                this.pendingInitialPage = null;
            }
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void h(boolean keyboardVisible) {
        if (!kotlin.jvm.internal.p.d(this.lastImeKeyboardVisible, Boolean.valueOf(keyboardVisible))) {
            this.lastImeAnimationEndVisible = null;
            this.lastImeFrame = null;
        }
        this.lastImeKeyboardVisible = Boolean.valueOf(keyboardVisible);
        ChatFragment chatFragmentM0 = m0();
        if (chatFragmentM0 != null) {
            chatFragmentM0.h(keyboardVisible);
        }
    }

    public final void h0(int scrollState) {
        boolean z10 = scrollState != 0;
        ViewPager2 viewPager2 = this.pager;
        if (viewPager2 != null && viewPager2.getClipToOutline() != z10) {
            viewPager2.setClipToOutline(z10);
        }
        View childAt = viewPager2 != null ? viewPager2.getChildAt(0) : null;
        if (childAt != null && childAt.getClipToOutline() != z10) {
            childAt.setClipToOutline(z10);
        }
        View view = getView();
        if (view == null || view.getClipToOutline() == z10) {
            return;
        }
        view.setClipToOutline(z10);
    }

    public final void i0() {
        SheetSettleState sheetSettleStateV = v();
        boolean z10 = false;
        boolean z11 = sheetSettleStateV != null && com.stepos.ailauncher.chat.util.u.a(sheetSettleStateV);
        boolean zBooleanValue = n0().q().getValue().booleanValue();
        ViewPager2 viewPager2 = this.pager;
        if (viewPager2 != null) {
            if (!z11 && !zBooleanValue && !this.recording && this.artifactsView == null) {
                z10 = true;
            }
            viewPager2.setUserInputEnabled(z10);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return this.artifactsView == null;
    }

    public final boolean j0(boolean animate) {
        final ArtifactsView artifactsView = this.artifactsView;
        if (artifactsView == null) {
            return false;
        }
        View view = getView();
        final ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return false;
        }
        ViewPager2 viewPager2 = this.pager;
        this.artifactsView = null;
        i0();
        Y();
        if (viewPager2 != null) {
            viewPager2.setVisibility(0);
            f0();
        }
        n0().J(y0() ? 1.0f : 0.0f);
        if (animate && viewPager2 != null) {
            com.stepos.ailauncher.chat.view.K.INSTANCE.h(artifactsView, viewPager2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.I1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return ChatPagerFragment.l0(artifactsView, viewGroup);
                }
            });
            return true;
        }
        if (viewPager2 != null) {
            com.stepos.ailauncher.chat.view.K.INSTANCE.l(artifactsView, viewPager2);
        } else {
            com.stepos.ailauncher.chat.view.K.INSTANCE.l(artifactsView);
        }
        viewGroup.removeView(artifactsView);
        artifactsView.o();
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void k(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        i0();
        f0();
        d0(state);
        this.lastSheetSettleState = state;
        List<Fragment> listZ0 = getChildFragmentManager().z0();
        kotlin.jvm.internal.p.h(listZ0, "getFragments(...)");
        for (android.view.W w10 : listZ0) {
            com.stepos.ailauncher.sheet.nav.d dVar = w10 instanceof com.stepos.ailauncher.sheet.nav.d ? (com.stepos.ailauncher.sheet.nav.d) w10 : null;
            if (dVar != null) {
                dVar.k(state);
            }
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean m() {
        return this.artifactsView != null;
    }

    public final ChatFragment m0() {
        List<Fragment> listZ0 = getChildFragmentManager().z0();
        kotlin.jvm.internal.p.h(listZ0, "getFragments(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZ0) {
            if (obj instanceof ChatFragment) {
                arrayList.add(obj);
            }
        }
        return (ChatFragment) Z8.F.s0(arrayList);
    }

    public final Pair<Integer, Float> o0() {
        return Y8.j.a(Integer.valueOf(this.pagerGlassTint), Float.valueOf(this.pagerGlassBlurPx));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        j0(false);
        getChildFragmentManager().C1(this.childCallbacks);
        C2804e4 c2804e4 = this.pagerSpring;
        if (c2804e4 != null) {
            c2804e4.E();
        }
        this.pagerSpring = null;
        ViewPager2 viewPager2 = this.pager;
        if (viewPager2 != null) {
            viewPager2.setAdapter(null);
        }
        this.pager = null;
        GlassAttachment glassAttachment = this.pagerGlass;
        if (glassAttachment != null) {
            glassAttachment.n();
        }
        this.pagerGlass = null;
        this.pagerGlassHost = null;
        this.retainingGlassForExit = false;
        View view = getView();
        if (view != null) {
            view.removeCallbacks(this.panelBackplateRemoval);
        }
        this.panelBackplateShown = false;
        this.panelBackplateHeld = false;
        this.pendingChatActions.clear();
        this.pendingInitialPage = null;
        this.neighborWarmedUp = false;
        this.lastPagerVisible = null;
        this.lastImeKeyboardVisible = null;
        this.lastImeFrame = null;
        this.lastImeAnimationEndVisible = null;
        this.lastSheetSettleState = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.neighborWarmedUp) {
            return;
        }
        this.neighborWarmedUp = true;
        ViewPager2 viewPager2 = this.pager;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ChatFragment chatFragmentM0;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getChildFragmentManager().l1(this.childCallbacks, false);
        l5.i iVarA = l5.i.a(view);
        kotlin.jvm.internal.p.h(iVarA, "bind(...)");
        ViewPager2 chatPager = iVarA.chatPager;
        kotlin.jvm.internal.p.h(chatPager, "chatPager");
        this.pager = chatPager;
        chatPager.setAdapter(new b());
        this.pagerSpring = new C2804e4(chatPager, this.pageScrollCallback);
        chatPager.setOverScrollMode(2);
        View childAt = chatPager.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.setOverScrollMode(2);
        }
        i0();
        f0();
        if (savedInstanceState == null) {
            this.pendingInitialPage = Integer.valueOf(p0());
            g0();
        }
        Boolean bool = this.lastImeKeyboardVisible;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            ChatFragment chatFragmentM02 = m0();
            if (chatFragmentM02 != null) {
                chatFragmentM02.h(zBooleanValue);
            }
        }
        Pair<Integer, Boolean> pair = this.lastImeFrame;
        if (pair != null) {
            int iIntValue = pair.a().intValue();
            Boolean boolB = pair.b();
            boolean zBooleanValue2 = boolB.booleanValue();
            if (kotlin.jvm.internal.p.d(boolB, this.lastImeKeyboardVisible) && (chatFragmentM0 = m0()) != null) {
                chatFragmentM0.i0(iIntValue, zBooleanValue2);
            }
        }
        Boolean bool2 = this.lastImeAnimationEndVisible;
        if (bool2 != null) {
            boolean zBooleanValue3 = bool2.booleanValue();
            ChatFragment chatFragmentM03 = m0();
            if (chatFragmentM03 != null) {
                chatFragmentM03.h0(zBooleanValue3);
            }
        }
        final View chatPagerGlass = iVarA.chatPagerGlass;
        kotlin.jvm.internal.p.h(chatPagerGlass, "chatPagerGlass");
        this.pagerGlassHost = chatPagerGlass;
        final ViewOutlineProvider viewOutlineProviderB = INSTANCE.b(28.0f);
        com.stepos.ailauncher.sheet.S sT = t();
        this.pagerGlassStyle = S0(sT != null ? sT.S1() : null);
        c0(this, false, false, 2, null);
        SheetGlassStyle sheetGlassStyle = this.pagerGlassStyle;
        SheetSettleState sheetSettleStateV = v();
        com.stepos.ailauncher.sheet.S sT2 = t();
        SheetSettleState sheetSettleStateU1 = sT2 != null ? sT2.u1() : null;
        com.stepos.ailauncher.sheet.S sT3 = t();
        C4148a.k(TAG, "pagerGlass attach style=" + sheetGlassStyle + " current=" + sheetSettleStateV + " enter=" + sheetSettleStateU1 + " presentation=" + (sT3 != null ? sT3.S1() : null), false, 4, null);
        this.pagerGlass = new GlassAttachment(chatPagerGlass, true, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.J1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Float.valueOf(ChatPagerFragment.F0((View) obj));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.K1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatPagerFragment.G0(chatPagerGlass, viewOutlineProviderB);
            }
        }, null, new p9.r() { // from class: com.stepos.ailauncher.chat.fragment.L1
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ChatPagerFragment.H0(this.f25191a, (View) obj, ((Boolean) obj2).booleanValue(), (Float) obj3, (y7.o) obj4);
            }
        }, 16, null).t();
        androidx.fragment.app.r activity = getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity != null) {
            chatActivity.e9();
        }
        if (this.crossWindowGlassSuspended) {
            Z();
        }
        chatPagerGlass.setClipToOutline(true);
        chatPagerGlass.setOutlineProvider(viewOutlineProviderB);
        chatPagerGlass.invalidateOutline();
        view.setOutlineProvider(viewOutlineProviderB);
        view.setClipToOutline(false);
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
        chatPager.setOutlineProvider(viewOutlineProviderB);
        chatPager.setClipToOutline(false);
        View childAt2 = chatPager.getChildAt(0);
        RecyclerView recyclerView2 = childAt2 instanceof RecyclerView ? (RecyclerView) childAt2 : null;
        if (recyclerView2 != null) {
            recyclerView2.setOutlineProvider(viewOutlineProviderB);
            recyclerView2.setClipToOutline(false);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AnonymousClass8(null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner2), null, null, new AnonymousClass9(view, null), 3, null);
    }

    public final int p0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(ARG_INITIAL_PAGE, 0);
        }
        return 0;
    }

    public final SessionCenterFragment v0() {
        List<Fragment> listZ0 = getChildFragmentManager().z0();
        kotlin.jvm.internal.p.h(listZ0, "getFragments(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : listZ0) {
            if (obj instanceof SessionCenterFragment) {
                arrayList.add(obj);
            }
        }
        return (SessionCenterFragment) Z8.F.s0(arrayList);
    }

    public final void w0() {
        View view = getView();
        if (view == null) {
            return;
        }
        view.removeCallbacks(this.panelBackplateRemoval);
        if (this.panelBackplateShown) {
            this.panelBackplateShown = false;
            view.setBackground(null);
        }
    }

    public final void x0() {
        ChatInputFragment residentInput;
        FloatInputView floatInputViewY0;
        C2804e4 c2804e4 = this.pagerSpring;
        if (c2804e4 == null || c2804e4.z() != 1) {
            return;
        }
        androidx.fragment.app.r activity = getActivity();
        ChatActivity chatActivity = activity instanceof ChatActivity ? (ChatActivity) activity : null;
        if (chatActivity == null || (residentInput = chatActivity.getResidentInput()) == null || (floatInputViewY0 = residentInput.getInputView()) == null) {
            return;
        }
        floatInputViewY0.n6();
    }

    public final boolean y0() {
        C2804e4 c2804e4 = this.pagerSpring;
        return c2804e4 != null && c2804e4.z() == 1;
    }

    /* renamed from: z0, reason: from getter */
    public final boolean getSessionCenterGlassSuspended() {
        return this.sessionCenterGlassSuspended;
    }
}
