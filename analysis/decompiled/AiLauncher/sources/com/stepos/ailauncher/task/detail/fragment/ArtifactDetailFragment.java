package com.stepos.ailauncher.task.detail.fragment;

import Ua.C1060i;
import V0.CreationExtras;
import android.animation.ValueAnimator;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.U;
import android.view.V;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.core.view.b0;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.fragment.I0;
import com.stepos.ailauncher.chat.manager.C2700i;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.ImeDismissFrameLayout;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.chat.view.Z3;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.widget.SweepTextView;
import com.stepos.ailauncher.contract.model.ArtifactDetailIntent;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.SessionArtifactKt;
import com.stepos.ailauncher.sheet.S;
import com.stepos.ailauncher.sheet.SheetSettleState;
import com.stepos.ailauncher.task.R$dimen;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.detail.ArtifactDetailActivity;
import com.stepos.ailauncher.task.detail.RenderLoadingMode;
import com.stepos.ailauncher.task.detail.chip.TaskChipController;
import com.stepos.ailauncher.task.detail.chrome.ArtifactDetailTopBar;
import com.stepos.ailauncher.task.detail.download.ArtifactDownloadController;
import com.stepos.ailauncher.task.detail.render.ArtifactContentView;
import com.stepos.ailauncher.task.detail.render.ArtifactRenderKind;
import com.stepos.ailauncher.task.detail.version.ArtifactVersions;
import com.stepos.ame.sdk.SkillStoreKt;
import h8.C4148a;
import java.io.File;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 «\u00012\u00020\u0001:\u0004¬\u0001\u00ad\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u001b\u0010\u001f\u001a\u00020\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020#2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J!\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020&2\b\b\u0002\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020&H\u0002¢\u0006\u0004\b0\u00101J\u0011\u00103\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u0010\u0003J\u001f\u0010:\u001a\u00020\b2\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b<\u00101J\u000f\u0010=\u001a\u00020\bH\u0002¢\u0006\u0004\b=\u0010\u0003J\u0017\u0010>\u001a\u00020\b2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\b2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b@\u0010?J\u000f\u0010A\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010D\u001a\u00020CH\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\bH\u0002¢\u0006\u0004\bF\u0010\u0003J\u000f\u0010G\u001a\u00020#H\u0002¢\u0006\u0004\bG\u0010%J\u0017\u0010J\u001a\u00020\b2\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\bH\u0002¢\u0006\u0004\bL\u0010\u0003R\u0016\u0010M\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010NR\u0016\u0010S\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010NR\u0018\u0010T\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010NR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010`\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010_R\u0018\u0010e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010_R\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010_R\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010lR\u0018\u0010o\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010r\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010u\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001a\u00020w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001e\u0010\u0082\u0001\u001a\u00020}8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010NR\u0018\u0010\u0087\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010NR\u0018\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001e\u0010\u0090\u0001\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010\u007f\u001a\u0005\b\u008f\u0001\u0010ER\u001e\u0010\u0093\u0001\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0091\u0001\u0010\u007f\u001a\u0005\b\u0092\u0001\u0010ER\u001e\u0010\u0096\u0001\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u007f\u001a\u0005\b\u0095\u0001\u0010ER\u001e\u0010\u0099\u0001\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010\u007f\u001a\u0005\b\u0098\u0001\u0010ER\u001e\u0010\u009c\u0001\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u007f\u001a\u0005\b\u009b\u0001\u0010ER\u0017\u0010\u009f\u0001\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0017\u0010¡\u0001\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010\u009e\u0001R\u0017\u0010£\u0001\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u009e\u0001R\u0017\u0010¥\u0001\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010\u009e\u0001R\u0019\u0010¨\u0001\u001a\u0004\u0018\u00010&8BX\u0082\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u0016\u0010ª\u0001\u001a\u00020#8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b©\u0001\u0010%¨\u0006®\u0001"}, d2 = {"Lcom/stepos/ailauncher/task/detail/fragment/ArtifactDetailFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "keyboardVisible", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "k", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "", "fraction", Const.INTENT_KEY_UMID, "(F)V", "onResume", "onPause", "visible", Const.INTENT_KEY_BACKGROUND_COMMAND, "onStop", "onDestroyView", "C0", "targetImmersive", "t0", "(Ljava/lang/Boolean;)V", "y1", "D1", "", "E1", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", ArtifactDetailFragment.ARG_ARTIFACT, "p1", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Ljava/lang/String;", "art", "Lcom/stepos/ailauncher/task/detail/RenderLoadingMode;", "loadingMode", "q1", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Lcom/stepos/ailauncher/task/detail/RenderLoadingMode;)V", "folder", "O0", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)V", "Landroid/content/ClipboardManager;", "A0", "()Landroid/content/ClipboardManager;", "F1", "Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView$HtmlView;", "mode", "Q0", "(Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView;Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView$HtmlView;)V", "r1", "z0", "A1", "(Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView;)V", "C1", "o1", "B1", "", "P0", "()I", "s1", "B0", "Ljava/io/File;", "saved", "u1", "(Ljava/io/File;)V", "M0", "contentBlocksInput", "Z", "topBarImmersive", "bottomScrimTarget", "Ljava/lang/Float;", "lastPreviewMode", "previewTransitioning", "previewTargetImmersive", "Ljava/lang/Boolean;", "topBarFadeInStarted", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "topBarFadeInterpolator", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "Lcom/stepos/ailauncher/task/detail/render/ArtifactContentView;", "Lcom/stepos/ailauncher/task/detail/chrome/ArtifactDetailTopBar;", "topBar", "Lcom/stepos/ailauncher/task/detail/chrome/ArtifactDetailTopBar;", "topScrim", "Landroid/view/View;", "bottomScrim", "Landroid/widget/FrameLayout;", "bottomChromeHost", "Landroid/widget/FrameLayout;", "downloadOverlay", "savedSnackbar", "Lcom/stepos/ailauncher/common/widget/SweepTextView;", "chipStatus", "Lcom/stepos/ailauncher/common/widget/SweepTextView;", "residentInputSlot", "Landroid/view/View$OnLayoutChangeListener;", "slotLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "chipLayoutListener", "Lcom/stepos/ailauncher/task/detail/version/ArtifactVersions;", "versions", "Lcom/stepos/ailauncher/task/detail/version/ArtifactVersions;", "Lcom/stepos/ailauncher/task/detail/download/ArtifactDownloadController;", com.stepos.ailauncher.chat.trace.a.BUTTON_DOWNLOAD, "Lcom/stepos/ailauncher/task/detail/download/ArtifactDownloadController;", "Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;", "clipListener", "Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;", "", "lastContentCopyAtMs", "J", "Lcom/stepos/ailauncher/task/detail/chip/TaskChipController;", "chip", "Lcom/stepos/ailauncher/task/detail/chip/TaskChipController;", "Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel$delegate", "LY8/h;", "I0", "()Lcom/stepos/ailauncher/chat/fragment/I0;", "coreViewModel", "Lcom/stepos/ailauncher/chat/fragment/I0$a;", "coreHandle", "Lcom/stepos/ailauncher/chat/fragment/I0$a;", "roundActive", "imeKeyboardVisible", "Ljava/lang/Runnable;", "dismissSavedSnackbar", "Ljava/lang/Runnable;", "Lcom/stepos/ailauncher/task/detail/fragment/ArtifactDetailFragment$a;", "lastBottomChrome", "Lcom/stepos/ailauncher/task/detail/fragment/ArtifactDetailFragment$a;", "bottomReservePx$delegate", "E0", "bottomReservePx", "bottomScrimHeightPx$delegate", "G0", "bottomScrimHeightPx", "bottomScrimChipExtraPx$delegate", "F0", "bottomScrimChipExtraPx", "snackbarMarginBottomPx$delegate", "L0", "snackbarMarginBottomPx", "chipMarginBottomPx$delegate", "H0", "chipMarginBottomPx", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "c", "supportsSheetHalfSettle", "e", "extendsContentToBottomEdge", "m", "hidesResidentInput", "K0", "()Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "seed", "J0", "exposeSource", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArtifactDetailFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_ARTIFACT = "artifact";
    private static final long CONTENT_COPY_DEBOUNCE_MS = 300;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean MOCK_NEXT_VERSION_AFTER_ROUND = false;
    private static final long SNACKBAR_DURATION_MS = 4000;
    private static final long SNACKBAR_FADE_IN_MS = 180;
    private static final long SNACKBAR_FADE_OUT_MS = 160;
    private static final String TAG = "ArtifactDetailFragment";
    private static final long TITLE_DONE_AUTO_HIDE_MS = 3000;
    private static final long TOP_BAR_FADE_IN_MS = 200;
    private static final long TOP_BAR_FADE_OUT_MS = 200;
    private FrameLayout bottomChromeHost;

    /* renamed from: bottomReservePx$delegate, reason: from kotlin metadata */
    private final Y8.h bottomReservePx;
    private View bottomScrim;

    /* renamed from: bottomScrimChipExtraPx$delegate, reason: from kotlin metadata */
    private final Y8.h bottomScrimChipExtraPx;

    /* renamed from: bottomScrimHeightPx$delegate, reason: from kotlin metadata */
    private final Y8.h bottomScrimHeightPx;
    private Float bottomScrimTarget;
    private TaskChipController chip;
    private final View.OnLayoutChangeListener chipLayoutListener;

    /* renamed from: chipMarginBottomPx$delegate, reason: from kotlin metadata */
    private final Y8.h chipMarginBottomPx;
    private SweepTextView chipStatus;
    private ClipboardManager.OnPrimaryClipChangedListener clipListener;
    private ArtifactContentView content;
    private boolean contentBlocksInput;
    private I0.ChatCoreHandle coreHandle;

    /* renamed from: coreViewModel$delegate, reason: from kotlin metadata */
    private final Y8.h coreViewModel;
    private final Runnable dismissSavedSnackbar;
    private ArtifactDownloadController download;
    private View downloadOverlay;
    private boolean imeKeyboardVisible;
    private BottomChromeSnapshot lastBottomChrome;
    private long lastContentCopyAtMs;
    private boolean lastPreviewMode;
    private Boolean previewTargetImmersive;
    private boolean previewTransitioning;
    private View residentInputSlot;
    private boolean roundActive;
    private View savedSnackbar;
    private final View.OnLayoutChangeListener slotLayoutListener;

    /* renamed from: snackbarMarginBottomPx$delegate, reason: from kotlin metadata */
    private final Y8.h snackbarMarginBottomPx;
    private ArtifactDetailTopBar topBar;
    private boolean topBarFadeInStarted;
    private final AccelerateDecelerateInterpolator topBarFadeInterpolator;
    private boolean topBarImmersive;
    private View topScrim;
    private ArtifactVersions versions;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/task/detail/fragment/ArtifactDetailFragment$a;", "", "", "nav", "", "immersive", "chipVisible", "canScrollUp", "canScrollDown", "scrimHeight", "<init>", "(IZZZZI)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getNav", "Z", "getImmersive", "()Z", "getChipVisible", "getCanScrollUp", "getCanScrollDown", "getScrimHeight", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$a, reason: from toString */
    public static final /* data */ class BottomChromeSnapshot {
        private final boolean canScrollDown;
        private final boolean canScrollUp;
        private final boolean chipVisible;
        private final boolean immersive;
        private final int nav;
        private final int scrimHeight;

        public BottomChromeSnapshot(int i10, boolean z10, boolean z11, boolean z12, boolean z13, int i11) {
            this.nav = i10;
            this.immersive = z10;
            this.chipVisible = z11;
            this.canScrollUp = z12;
            this.canScrollDown = z13;
            this.scrimHeight = i11;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BottomChromeSnapshot)) {
                return false;
            }
            BottomChromeSnapshot bottomChromeSnapshot = (BottomChromeSnapshot) other;
            return this.nav == bottomChromeSnapshot.nav && this.immersive == bottomChromeSnapshot.immersive && this.chipVisible == bottomChromeSnapshot.chipVisible && this.canScrollUp == bottomChromeSnapshot.canScrollUp && this.canScrollDown == bottomChromeSnapshot.canScrollDown && this.scrimHeight == bottomChromeSnapshot.scrimHeight;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.nav) * 31) + Boolean.hashCode(this.immersive)) * 31) + Boolean.hashCode(this.chipVisible)) * 31) + Boolean.hashCode(this.canScrollUp)) * 31) + Boolean.hashCode(this.canScrollDown)) * 31) + Integer.hashCode(this.scrimHeight);
        }

        public String toString() {
            return "BottomChromeSnapshot(nav=" + this.nav + ", immersive=" + this.immersive + ", chipVisible=" + this.chipVisible + ", canScrollUp=" + this.canScrollUp + ", canScrollDown=" + this.canScrollDown + ", scrimHeight=" + this.scrimHeight + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/task/detail/fragment/ArtifactDetailFragment$b;", "", "<init>", "()V", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", ArtifactDetailFragment.ARG_ARTIFACT, "Lcom/stepos/ailauncher/task/detail/fragment/ArtifactDetailFragment;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)Lcom/stepos/ailauncher/task/detail/fragment/ArtifactDetailFragment;", "", "TOP_BAR_FADE_OUT_MS", "J", "TOP_BAR_FADE_IN_MS", "", "TAG", "Ljava/lang/String;", "ARG_ARTIFACT", "SNACKBAR_FADE_IN_MS", "SNACKBAR_FADE_OUT_MS", "SNACKBAR_DURATION_MS", "TITLE_DONE_AUTO_HIDE_MS", "CONTENT_COPY_DEBOUNCE_MS", "", "MOCK_NEXT_VERSION_AFTER_ROUND", "Z", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ArtifactDetailFragment a(SessionArtifact artifact) {
            kotlin.jvm.internal.p.i(artifact, "artifact");
            ArtifactDetailFragment artifactDetailFragment = new ArtifactDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ArtifactDetailFragment.ARG_ARTIFACT, artifact);
            artifactDetailFragment.setArguments(bundle);
            return artifactDetailFragment;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArtifactRenderKind.Kind.values().length];
            try {
                iArr[ArtifactRenderKind.Kind.CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArtifactRenderKind.Kind.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ArtifactDetailFragment.this.o1();
        }
    }

    public ArtifactDetailFragment() {
        super(R$layout.fragment_artifact_detail);
        this.contentBlocksInput = true;
        this.topBarFadeInterpolator = new AccelerateDecelerateInterpolator();
        this.slotLayoutListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.task.detail.fragment.o
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ArtifactDetailFragment.w1(this.f28624a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.chipLayoutListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.task.detail.fragment.p
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ArtifactDetailFragment.x0(this.f28625a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        final InterfaceC5063a interfaceC5063a = null;
        this.coreViewModel = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.t.b(I0.class), new InterfaceC5063a<V>() { // from class: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final V invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new InterfaceC5063a<CreationExtras>() { // from class: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$special$$inlined$activityViewModels$default$2
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
        }, new InterfaceC5063a<U.c>() { // from class: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final U.c invoke() {
                return this.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.dismissSavedSnackbar = new Runnable() { // from class: com.stepos.ailauncher.task.detail.fragment.q
            @Override // java.lang.Runnable
            public final void run() {
                ArtifactDetailFragment.D0(this.f28626a);
            }
        };
        this.bottomReservePx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(ArtifactDetailFragment.u0(this.f28627a));
            }
        });
        this.bottomScrimHeightPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.s
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(ArtifactDetailFragment.w0(this.f28628a));
            }
        });
        this.bottomScrimChipExtraPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(ArtifactDetailFragment.v0(this.f28629a));
            }
        });
        this.snackbarMarginBottomPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(ArtifactDetailFragment.x1(this.f28630a));
            }
        });
        this.chipMarginBottomPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(ArtifactDetailFragment.y0(this.f28631a));
            }
        });
    }

    public static final void D0(ArtifactDetailFragment artifactDetailFragment) {
        artifactDetailFragment.M0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final I0 I0() {
        return (I0) this.coreViewModel.getValue();
    }

    public static final void N0(View view) {
        view.setVisibility(8);
    }

    public static final void R0(ArtifactDetailFragment artifactDetailFragment) {
        SessionArtifact sessionArtifactE;
        if (artifactDetailFragment.isResumed()) {
            androidx.fragment.app.r activity = artifactDetailFragment.getActivity();
            if ((activity != null ? activity.getCurrentFocus() : null) instanceof EditText) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - artifactDetailFragment.lastContentCopyAtMs < 300) {
                return;
            }
            artifactDetailFragment.lastContentCopyAtMs = jElapsedRealtime;
            ArtifactVersions artifactVersions = artifactDetailFragment.versions;
            if (artifactVersions == null || (sessionArtifactE = artifactVersions.e()) == null) {
                return;
            }
            M5.c.INSTANCE.i(sessionArtifactE, artifactDetailFragment.E1());
        }
    }

    public static final boolean S0(ArtifactDetailFragment artifactDetailFragment, MotionEvent it) {
        kotlin.jvm.internal.p.i(it, "it");
        return artifactDetailFragment.imeKeyboardVisible;
    }

    public static final Y8.t T0(ArtifactDetailFragment artifactDetailFragment) {
        artifactDetailFragment.C0();
        return Y8.t.f7040a;
    }

    public static final Y8.t U0(ArtifactDetailTopBar artifactDetailTopBar, ArtifactDetailFragment artifactDetailFragment, boolean z10) {
        artifactDetailTopBar.setDownloading(z10);
        View view = artifactDetailFragment.downloadOverlay;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
        S sT = artifactDetailFragment.t();
        if (sT != null) {
            sT.u4();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t V0(ArtifactDetailFragment artifactDetailFragment, File it) {
        kotlin.jvm.internal.p.i(it, "it");
        artifactDetailFragment.u1(it);
        return Y8.t.f7040a;
    }

    public static final Y8.t W0(ArtifactDetailFragment artifactDetailFragment, SessionArtifact art, RenderLoadingMode loadingMode) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(art, "art");
        kotlin.jvm.internal.p.i(loadingMode, "loadingMode");
        artifactDetailFragment.q1(art, loadingMode);
        artifactDetailFragment.D1();
        artifactDetailFragment.r1(art);
        return Y8.t.f7040a;
    }

    public static final Y8.t X0(ArtifactDetailFragment artifactDetailFragment) throws Resources.NotFoundException {
        artifactDetailFragment.D1();
        return Y8.t.f7040a;
    }

    public static final Y8.t Y0(ArtifactVersions artifactVersions, ArtifactDetailFragment artifactDetailFragment, int i10, int i11) {
        SessionArtifact sessionArtifact = (SessionArtifact) Z8.F.t0(artifactVersions.i(), i11);
        if (sessionArtifact != null) {
            M5.c.INSTANCE.D(sessionArtifact, artifactDetailFragment.E1(), String.valueOf(i10 + 1), String.valueOf(i11 + 1));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t Z0(ArtifactContentView artifactContentView, ArtifactDetailFragment artifactDetailFragment) {
        if (!artifactContentView.w0()) {
            if (artifactDetailFragment.w()) {
                com.stepos.ailauncher.sheet.nav.a.r(artifactDetailFragment, false, 1, null);
            } else {
                com.stepos.ailauncher.sheet.nav.h hVarU = artifactDetailFragment.u();
                if (hVarU == null || !hVarU.p()) {
                    artifactDetailFragment.o();
                } else {
                    artifactDetailFragment.x();
                }
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t a1(ArtifactVersions artifactVersions) {
        artifactVersions.j(-1);
        return Y8.t.f7040a;
    }

    public static final Y8.t b1(ArtifactVersions artifactVersions) {
        artifactVersions.j(1);
        return Y8.t.f7040a;
    }

    public static final Y8.t c1(ArtifactDetailFragment artifactDetailFragment, ArtifactVersions artifactVersions) {
        boolean zW = artifactDetailFragment.w();
        boolean z10 = !zW;
        SessionArtifact sessionArtifactE = artifactVersions.e();
        if (sessionArtifactE != null) {
            M5.c.INSTANCE.r(sessionArtifactE, artifactDetailFragment.E1(), z10);
        }
        artifactDetailFragment.t0(Boolean.valueOf(z10));
        if (zW) {
            com.stepos.ailauncher.sheet.nav.a.r(artifactDetailFragment, false, 1, null);
        } else {
            artifactDetailFragment.p(true);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t d1(ArtifactContentView artifactContentView, ArtifactDetailFragment artifactDetailFragment, boolean z10) {
        boolean z11 = z10 && !artifactContentView.X0();
        if (artifactDetailFragment.contentBlocksInput != z11) {
            artifactDetailFragment.contentBlocksInput = z11;
            S sT = artifactDetailFragment.t();
            if (sT != null) {
                sT.u4();
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t e1(ArtifactDetailFragment artifactDetailFragment, ArtifactContentView artifactContentView) {
        kotlin.jvm.internal.p.f(artifactContentView);
        artifactDetailFragment.Q0(artifactContentView, ArtifactContentView.HtmlView.PREVIEW);
        return Y8.t.f7040a;
    }

    public static final Y8.t f1(ArtifactDetailFragment artifactDetailFragment, ArtifactContentView artifactContentView) {
        kotlin.jvm.internal.p.f(artifactContentView);
        artifactDetailFragment.Q0(artifactContentView, ArtifactContentView.HtmlView.CODE);
        return Y8.t.f7040a;
    }

    public static final Y8.t g1(ArtifactVersions artifactVersions, ArtifactDownloadController artifactDownloadController, ArtifactDetailFragment artifactDetailFragment) {
        SessionArtifact sessionArtifactE = artifactVersions.e();
        if (sessionArtifactE != null) {
            M5.c.m(M5.c.INSTANCE, sessionArtifactE, artifactDetailFragment.E1(), M5.c.PAGE_PRODUCT_DETAIL, null, 8, null);
        }
        artifactDownloadController.l0(artifactVersions.e());
        return Y8.t.f7040a;
    }

    public static final boolean h1(ArtifactContentView artifactContentView) {
        return artifactContentView.getHtmlView() == ArtifactContentView.HtmlView.CODE;
    }

    public static final void i1(int i10, ArtifactContentView artifactContentView, ArtifactDetailFragment artifactDetailFragment, View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int bottom = view.getBottom() + i10;
        if (artifactContentView.getTopInsetPx() != bottom) {
            artifactContentView.setTopInsetPx(bottom);
        }
        kotlin.jvm.internal.p.f(artifactContentView);
        artifactDetailFragment.C1(artifactContentView);
    }

    public static final Y8.t j1(ArtifactDetailFragment artifactDetailFragment, ArtifactContentView artifactContentView) {
        kotlin.jvm.internal.p.f(artifactContentView);
        artifactDetailFragment.A1(artifactContentView);
        artifactDetailFragment.C1(artifactContentView);
        return Y8.t.f7040a;
    }

    public static final Y8.t k1(ArtifactDetailFragment artifactDetailFragment, ArtifactContentView artifactContentView) {
        kotlin.jvm.internal.p.f(artifactContentView);
        artifactDetailFragment.A1(artifactContentView);
        artifactDetailFragment.C0();
        return Y8.t.f7040a;
    }

    public static final Y8.t l1(ArtifactDetailFragment artifactDetailFragment) {
        artifactDetailFragment.C0();
        return Y8.t.f7040a;
    }

    public static final a0 m1(ArtifactDetailFragment artifactDetailFragment, ArtifactContentView artifactContentView, View view, a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        kotlin.jvm.internal.p.f(artifactContentView);
        artifactDetailFragment.A1(artifactContentView);
        return insets;
    }

    public static final Y8.t n1(ArtifactDetailFragment artifactDetailFragment, SessionArtifact sessionArtifact, SessionArtifact child, int i10) {
        String sessionId;
        List<String> listT4;
        kotlin.jvm.internal.p.i(child, "child");
        M5.c.INSTANCE.q(child, artifactDetailFragment.E1(), i10);
        Context contextRequireContext = artifactDetailFragment.requireContext();
        kotlin.jvm.internal.p.h(contextRequireContext, "requireContext(...)");
        if (sessionArtifact == null || (sessionId = sessionArtifact.getSessionId()) == null) {
            androidx.fragment.app.r activity = artifactDetailFragment.getActivity();
            ArtifactDetailActivity artifactDetailActivity = activity instanceof ArtifactDetailActivity ? (ArtifactDetailActivity) activity : null;
            sessionId = (artifactDetailActivity == null || (listT4 = artifactDetailActivity.T4()) == null) ? null : (String) Z8.F.s0(listT4);
        }
        com.stepos.ailauncher.foundation.task.a.a(contextRequireContext, child, "folder", sessionId);
        return Y8.t.f7040a;
    }

    public static final Y8.t t1(ArtifactDetailFragment artifactDetailFragment, boolean z10) {
        ArtifactContentView artifactContentView = artifactDetailFragment.content;
        if (artifactContentView != null) {
            artifactDetailFragment.A1(artifactContentView);
        }
        return Y8.t.f7040a;
    }

    public static final int u0(ArtifactDetailFragment artifactDetailFragment) {
        return artifactDetailFragment.getResources().getDimensionPixelSize(R$dimen.artifact_detail_bottom_reserve);
    }

    public static final int v0(ArtifactDetailFragment artifactDetailFragment) {
        return artifactDetailFragment.getResources().getDimensionPixelSize(R$dimen.artifact_detail_bottom_scrim_chip_extra);
    }

    public static final void v1(ArtifactDetailFragment artifactDetailFragment, File file, View view) {
        artifactDetailFragment.M0();
        ArtifactDownloadController artifactDownloadController = artifactDetailFragment.download;
        if (artifactDownloadController != null) {
            artifactDownloadController.p0(file);
        }
    }

    public static final int w0(ArtifactDetailFragment artifactDetailFragment) {
        return artifactDetailFragment.getResources().getDimensionPixelSize(R$dimen.artifact_detail_bottom_scrim_height);
    }

    public static final void w1(ArtifactDetailFragment artifactDetailFragment, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        artifactDetailFragment.o1();
    }

    public static final void x0(ArtifactDetailFragment artifactDetailFragment, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        ArtifactContentView artifactContentView = artifactDetailFragment.content;
        if (artifactContentView != null) {
            artifactDetailFragment.A1(artifactContentView);
        }
    }

    public static final int x1(ArtifactDetailFragment artifactDetailFragment) {
        return artifactDetailFragment.getResources().getDimensionPixelSize(R$dimen.artifact_detail_snackbar_margin_bottom);
    }

    public static final int y0(ArtifactDetailFragment artifactDetailFragment) {
        return artifactDetailFragment.getResources().getDimensionPixelSize(R$dimen.artifact_detail_chip_margin_bottom);
    }

    public static final Y8.t z1(ArtifactDetailFragment artifactDetailFragment) {
        if (!artifactDetailFragment.topBarFadeInStarted) {
            return Y8.t.f7040a;
        }
        artifactDetailFragment.topBarFadeInStarted = false;
        artifactDetailFragment.previewTransitioning = false;
        artifactDetailFragment.previewTargetImmersive = null;
        return Y8.t.f7040a;
    }

    public final ClipboardManager A0() {
        Context applicationContext;
        Context context = getContext();
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return null;
        }
        return (ClipboardManager) applicationContext.getSystemService(ClipboardManager.class);
    }

    public final void A1(ArtifactContentView content) {
        int iG0;
        int iP0 = P0();
        boolean zW = w();
        boolean z10 = !zW && content.canScrollVertically(-1);
        boolean z11 = !zW && content.canScrollVertically(1);
        SweepTextView sweepTextView = this.chipStatus;
        boolean z12 = sweepTextView != null && sweepTextView.getVisibility() == 0;
        if (z12) {
            SweepTextView sweepTextView2 = this.chipStatus;
            ViewGroup.LayoutParams layoutParams = sweepTextView2 != null ? sweepTextView2.getLayoutParams() : null;
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            iG0 = C5685n.f((marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0) + (sweepTextView2 != null ? sweepTextView2.getHeight() : 0) + F0(), G0());
        } else {
            iG0 = G0();
        }
        int i10 = iG0;
        BottomChromeSnapshot bottomChromeSnapshot = new BottomChromeSnapshot(iP0, zW, z12, z10, z11, i10);
        View view = this.topScrim;
        if (view != null) {
            view.setAlpha((this.topBarImmersive || !content.canScrollVertically(-1)) ? 0.0f : 1.0f);
        }
        if (kotlin.jvm.internal.p.d(bottomChromeSnapshot, this.lastBottomChrome)) {
            return;
        }
        this.lastBottomChrome = bottomChromeSnapshot;
        content.setBottomInsetPx(E0() + iP0);
        View view2 = this.topScrim;
        if (view2 != null) {
            view2.setAlpha(z10 ? 1.0f : 0.0f);
        }
        View view3 = this.bottomScrim;
        if (view3 != null) {
            float f10 = (z11 || (!zW && z12)) ? 1.0f : 0.0f;
            if (!kotlin.jvm.internal.p.b(this.bottomScrimTarget, f10)) {
                boolean z13 = this.bottomScrimTarget == null;
                this.bottomScrimTarget = Float.valueOf(f10);
                view3.animate().cancel();
                if (z13 || !ValueAnimator.areAnimatorsEnabled()) {
                    view3.setAlpha(f10);
                } else {
                    view3.animate().alpha(f10).setDuration(300L).setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.1f, 1.0f)).start();
                }
            }
            if (view3.getLayoutParams().height != i10) {
                ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams2.height = i10;
                view3.setLayoutParams(layoutParams2);
            }
        }
        int iL0 = L0() + iP0;
        View view4 = this.savedSnackbar;
        if (view4 != null) {
            ViewGroup.LayoutParams layoutParams3 = view4.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            if (marginLayoutParams2 == null || marginLayoutParams2.bottomMargin == iL0) {
                return;
            }
            marginLayoutParams2.bottomMargin = iL0;
            view4.setLayoutParams(marginLayoutParams2);
        }
    }

    public final String B0() {
        SessionArtifact sessionArtifactE;
        String productKey;
        ArtifactVersions artifactVersions = this.versions;
        if (artifactVersions != null && (sessionArtifactE = artifactVersions.e()) != null && (productKey = SessionArtifactKt.getProductKey(sessionArtifactE)) != null) {
            return productKey;
        }
        SessionArtifact sessionArtifactK0 = K0();
        String productKey2 = sessionArtifactK0 != null ? SessionArtifactKt.getProductKey(sessionArtifactK0) : null;
        return productKey2 == null ? "" : productKey2;
    }

    public final void B1() {
        int iH0;
        SweepTextView sweepTextView = this.chipStatus;
        if (sweepTextView == null) {
            return;
        }
        Object parent = sweepTextView.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        View view2 = this.residentInputSlot;
        if (view2 == null || view2.getVisibility() != 0 || view2.getHeight() <= 0) {
            iH0 = H0();
        } else {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            view2.getLocationInWindow(iArr);
            view.getLocationInWindow(iArr2);
            iH0 = C5685n.f(view.getHeight() - (iArr[1] - iArr2[1]), 0);
        }
        ViewGroup.LayoutParams layoutParams = sweepTextView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.bottomMargin == iH0) {
            return;
        }
        marginLayoutParams.bottomMargin = iH0;
        sweepTextView.setLayoutParams(marginLayoutParams);
    }

    public final void C0() {
        View view;
        View currentFocus;
        if (this.imeKeyboardVisible && (view = getView()) != null) {
            androidx.fragment.app.r activity = getActivity();
            if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
                currentFocus.clearFocus();
            }
            b0 b0VarG = N.G(view);
            if (b0VarG != null) {
                b0VarG.a(a0.o.b());
            }
        }
    }

    public final void C1(ArtifactContentView content) {
        if (this.topBarImmersive) {
            S sT = t();
            if (sT != null) {
                sT.setSheetDragGestureHandleView(null);
            }
            S sT2 = t();
            if (sT2 != null) {
                sT2.setSheetDragPriorityView(null);
                return;
            }
            return;
        }
        ArtifactDetailTopBar artifactDetailTopBar = this.topBar;
        if (artifactDetailTopBar == null) {
            return;
        }
        boolean zZ1 = content.Z1();
        S sT3 = t();
        if (sT3 != null) {
            sT3.setSheetDragGestureHandleView(zZ1 ? artifactDetailTopBar : null);
        }
        S sT4 = t();
        if (sT4 != null) {
            sT4.setSheetDragPriorityView(zZ1 ? null : artifactDetailTopBar);
        }
    }

    public final void D1() throws Resources.NotFoundException {
        ArtifactVersions artifactVersions;
        ArtifactDetailTopBar artifactDetailTopBar = this.topBar;
        if (artifactDetailTopBar == null || (artifactVersions = this.versions) == null) {
            return;
        }
        artifactDetailTopBar.P(artifactVersions.e(), artifactVersions.getCurrentIndex(), artifactVersions.i().size(), this.topBarImmersive);
        TaskChipController taskChipController = this.chip;
        if (taskChipController != null) {
            taskChipController.F(this.topBarImmersive);
        }
    }

    public final int E0() {
        return ((Number) this.bottomReservePx.getValue()).intValue();
    }

    public final String E1() {
        SessionArtifact sessionArtifactE;
        String sessionId;
        ArtifactVersions artifactVersions = this.versions;
        if (artifactVersions == null || (sessionArtifactE = artifactVersions.e()) == null || (sessionId = sessionArtifactE.getSessionId()) == null || sessionId.length() <= 0) {
            return null;
        }
        return sessionId;
    }

    public final int F0() {
        return ((Number) this.bottomScrimChipExtraPx.getValue()).intValue();
    }

    public final void F1() {
        ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener = this.clipListener;
        if (onPrimaryClipChangedListener == null) {
            return;
        }
        this.clipListener = null;
        ClipboardManager clipboardManagerA0 = A0();
        if (clipboardManagerA0 != null) {
            clipboardManagerA0.removePrimaryClipChangedListener(onPrimaryClipChangedListener);
        }
    }

    public final int G0() {
        return ((Number) this.bottomScrimHeightPx.getValue()).intValue();
    }

    public final int H0() {
        return ((Number) this.chipMarginBottomPx.getValue()).intValue();
    }

    public final String J0() {
        Intent intent;
        String strSourceOf;
        androidx.fragment.app.r activity = getActivity();
        return (activity == null || (intent = activity.getIntent()) == null || (strSourceOf = ArtifactDetailIntent.INSTANCE.sourceOf(intent)) == null) ? "chatview" : strSourceOf;
    }

    public final SessionArtifact K0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (SessionArtifact) arguments.getParcelable(ARG_ARTIFACT, SessionArtifact.class);
        }
        return null;
    }

    public final int L0() {
        return ((Number) this.snackbarMarginBottomPx.getValue()).intValue();
    }

    public final void M0() {
        final View view = this.savedSnackbar;
        if (view == null) {
            return;
        }
        view.removeCallbacks(this.dismissSavedSnackbar);
        if (view.getVisibility() == 0) {
            view.animate().alpha(0.0f).setDuration(SNACKBAR_FADE_OUT_MS).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.task.detail.fragment.B
                @Override // java.lang.Runnable
                public final void run() {
                    ArtifactDetailFragment.N0(view);
                }
            }).start();
        }
    }

    public final void O0(SessionArtifact folder) {
        ArtifactContentView artifactContentView = this.content;
        if (artifactContentView == null) {
            return;
        }
        String sessionId = folder.getSessionId();
        String str = (sessionId == null || La.H.x0(sessionId)) ? null : sessionId;
        if (str == null) {
            artifactContentView.o1(folder);
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ArtifactDetailFragment$loadFolderChildren$1(this, artifactContentView, folder, str, null), 3, null);
    }

    public final int P0() {
        a0 a0VarB;
        t0.e eVarF;
        View view = getView();
        if (view == null || (a0VarB = N.B(view)) == null || (eVarF = a0VarB.f(a0.o.e())) == null) {
            return 0;
        }
        return eVarF.f41980d;
    }

    public final void Q0(ArtifactContentView content, ArtifactContentView.HtmlView mode) {
        SessionArtifact sessionArtifactE;
        if (content.getHtmlView() == mode) {
            return;
        }
        ArtifactVersions artifactVersions = this.versions;
        if (artifactVersions != null && (sessionArtifactE = artifactVersions.e()) != null) {
            M5.c.INSTANCE.s(sessionArtifactE, E1(), mode == ArtifactContentView.HtmlView.CODE ? "code" : "preview");
        }
        content.f0(mode);
        C1(content);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean c() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(float r5) throws android.content.res.Resources.NotFoundException {
        /*
            r4 = this;
            com.stepos.ailauncher.task.detail.render.ArtifactContentView r0 = r4.content
            if (r0 == 0) goto L7
            r0.setImmersiveFraction(r5)
        L7:
            boolean r0 = r4.w()
            boolean r1 = r4.lastPreviewMode
            if (r1 == r0) goto L1f
            r4.lastPreviewMode = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r4.t0(r0)
            com.stepos.ailauncher.task.detail.render.ArtifactContentView r0 = r4.content
            if (r0 == 0) goto L1f
            r4.A1(r0)
        L1f:
            java.lang.Boolean r0 = r4.previewTargetImmersive
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.p.d(r0, r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L35
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 < 0) goto L33
        L31:
            r0 = r2
            goto L46
        L33:
            r0 = r3
            goto L46
        L35:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r1 = kotlin.jvm.internal.p.d(r0, r1)
            if (r1 == 0) goto L43
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 > 0) goto L33
            goto L31
        L43:
            if (r0 != 0) goto L7f
            goto L33
        L46:
            r1 = 1056964608(0x3f000000, float:0.5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 <= 0) goto L4d
            goto L4e
        L4d:
            r2 = r3
        L4e:
            boolean r5 = r4.topBarImmersive
            if (r2 == r5) goto L57
            r4.topBarImmersive = r2
            r4.D1()
        L57:
            boolean r5 = r4.previewTransitioning
            if (r5 == 0) goto L70
            boolean r5 = r4.topBarFadeInStarted
            if (r5 != 0) goto L70
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            java.lang.Boolean r1 = r4.previewTargetImmersive
            boolean r5 = kotlin.jvm.internal.p.d(r5, r1)
            if (r5 != 0) goto L6d
            if (r0 == 0) goto L70
        L6d:
            r4.y1()
        L70:
            com.stepos.ailauncher.task.detail.render.ArtifactContentView r5 = r4.content
            if (r5 == 0) goto L77
            r4.A1(r5)
        L77:
            com.stepos.ailauncher.task.detail.render.ArtifactContentView r5 = r4.content
            if (r5 == 0) goto L7e
            r4.C1(r5)
        L7e:
            return
        L7f:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment.d(float):void");
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void g(boolean visible) {
        if (!visible) {
            z0();
        } else {
            ArtifactVersions artifactVersions = this.versions;
            r1(artifactVersions != null ? artifactVersions.e() : null);
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void h(boolean keyboardVisible) {
        this.imeKeyboardVisible = keyboardVisible;
        ArtifactContentView artifactContentView = this.content;
        if (artifactContentView == null) {
            return;
        }
        if (keyboardVisible) {
            artifactContentView.Q0();
        } else {
            artifactContentView.Y1();
        }
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public void k(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        ArtifactContentView artifactContentView = this.content;
        if (artifactContentView == null) {
            return;
        }
        A1(artifactContentView);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean m() {
        if (this.contentBlocksInput) {
            return true;
        }
        View view = this.downloadOverlay;
        return view != null && view.getVisibility() == 0;
    }

    public final void o1() {
        B1();
        ArtifactContentView artifactContentView = this.content;
        if (artifactContentView != null) {
            A1(artifactContentView);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        LauncherChatLayout chatLayout;
        F1();
        ArtifactContentView artifactContentView = this.content;
        if (artifactContentView != null) {
            artifactContentView.setOnFolderChildClick(null);
        }
        z0();
        S sT = t();
        if (sT != null) {
            sT.setSheetDragGestureHandleView(null);
        }
        S sT2 = t();
        if (sT2 != null) {
            sT2.setSheetDragPriorityView(null);
        }
        View view = this.savedSnackbar;
        if (view != null) {
            view.removeCallbacks(this.dismissSavedSnackbar);
        }
        this.savedSnackbar = null;
        TaskChipController taskChipController = this.chip;
        if (taskChipController != null) {
            taskChipController.C();
        }
        this.chip = null;
        this.lastBottomChrome = null;
        View view2 = this.residentInputSlot;
        if (view2 != null) {
            view2.removeOnLayoutChangeListener(this.slotLayoutListener);
        }
        this.residentInputSlot = null;
        I0.ChatCoreHandle chatCoreHandle = this.coreHandle;
        if (chatCoreHandle != null && (chatLayout = chatCoreHandle.getChatLayout()) != null) {
            chatLayout.setOnReceiveMessage(null);
        }
        this.coreHandle = null;
        this.roundActive = false;
        SweepTextView sweepTextView = this.chipStatus;
        if (sweepTextView != null) {
            sweepTextView.removeOnLayoutChangeListener(this.chipLayoutListener);
        }
        this.chipStatus = null;
        ArtifactContentView artifactContentView2 = this.content;
        if (artifactContentView2 != null) {
            artifactContentView2.m1();
        }
        ArtifactDetailTopBar artifactDetailTopBar = this.topBar;
        if (artifactDetailTopBar != null) {
            artifactDetailTopBar.O();
        }
        ArtifactDownloadController artifactDownloadController = this.download;
        if (artifactDownloadController != null) {
            artifactDownloadController.V();
        }
        this.content = null;
        this.topBar = null;
        this.topScrim = null;
        View view3 = this.bottomScrim;
        if (view3 != null && (viewPropertyAnimatorAnimate = view3.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        FrameLayout frameLayout = this.bottomChromeHost;
        if (frameLayout != null) {
            androidx.fragment.app.r activity = getActivity();
            ArtifactDetailActivity artifactDetailActivity = activity instanceof ArtifactDetailActivity ? (ArtifactDetailActivity) activity : null;
            if (artifactDetailActivity != null) {
                artifactDetailActivity.S4(frameLayout);
            }
        }
        this.bottomChromeHost = null;
        this.bottomScrimTarget = null;
        this.bottomScrim = null;
        this.downloadOverlay = null;
        this.versions = null;
        this.download = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        F1();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        F1();
        ClipboardManager clipboardManagerA0 = A0();
        if (clipboardManagerA0 == null) {
            return;
        }
        ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: com.stepos.ailauncher.task.detail.fragment.y
            @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
            public final void onPrimaryClipChanged() {
                ArtifactDetailFragment.R0(this.f28635a);
            }
        };
        this.clipListener = onPrimaryClipChangedListener;
        clipboardManagerA0.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        View view = this.bottomScrim;
        if (view != null) {
            view.animate().cancel();
            Float f10 = this.bottomScrimTarget;
            if (f10 != null) {
                view.setAlpha(f10.floatValue());
            }
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        FrameLayout frameLayoutM4;
        View viewFindViewById;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Z3 z32 = Z3.INSTANCE;
        androidx.fragment.app.r rVarRequireActivity = requireActivity();
        kotlin.jvm.internal.p.h(rVarRequireActivity, "requireActivity(...)");
        z32.c(rVarRequireActivity);
        ImeDismissFrameLayout imeDismissFrameLayout = (ImeDismissFrameLayout) view;
        imeDismissFrameLayout.setShouldSwallow(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.fragment.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ArtifactDetailFragment.S0(this.f28604a, (MotionEvent) obj));
            }
        });
        imeDismissFrameLayout.setOnSwallowed(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.T0(this.f28606a);
            }
        });
        final ArtifactContentView artifactContentView = (ArtifactContentView) view.findViewById(R$id.artifact_content);
        this.content = artifactContentView;
        artifactContentView.setOnChromeBlockingChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.fragment.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDetailFragment.d1(artifactContentView, this, ((Boolean) obj).booleanValue());
            }
        });
        this.contentBlocksInput = true;
        S sT = t();
        if (sT != null) {
            sT.u4();
        }
        final ArtifactDetailTopBar artifactDetailTopBar = (ArtifactDetailTopBar) view.findViewById(R$id.artifact_topbar);
        this.topBar = artifactDetailTopBar;
        View viewFindViewById2 = view.findViewById(R$id.topScrim);
        this.topScrim = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R$id.bottomScrim);
        this.bottomScrim = viewFindViewById3;
        float dimension = getResources().getDimension(R$dimen.artifact_detail_panel_corner) / getResources().getDisplayMetrics().density;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, null);
        kotlin.jvm.internal.p.f(viewFindViewById2);
        View[] viewArr = {viewFindViewById2};
        G.a aVar = G.a.f43886a;
        C2773b6.j(c2773b6, viewArr, aVar.g(), Float.valueOf(dimension), null, 8, null);
        kotlin.jvm.internal.p.f(viewFindViewById3);
        C2773b6.j(c2773b6, new View[]{viewFindViewById3}, aVar.f(), null, null, 12, null);
        this.downloadOverlay = view.findViewById(R$id.downloadOverlay);
        this.savedSnackbar = view.findViewById(R$id.savedSnackbar);
        this.chipStatus = (SweepTextView) view.findViewById(R$id.tv_chip_status);
        androidx.fragment.app.r activity = getActivity();
        ArtifactDetailActivity artifactDetailActivity = activity instanceof ArtifactDetailActivity ? (ArtifactDetailActivity) activity : null;
        if (artifactDetailActivity != null) {
            View view2 = this.savedSnackbar;
            if (view2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            SweepTextView sweepTextView = this.chipStatus;
            if (sweepTextView == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            frameLayoutM4 = artifactDetailActivity.M4(viewFindViewById3, view2, sweepTextView);
        } else {
            frameLayoutM4 = null;
        }
        this.bottomChromeHost = frameLayoutM4;
        SweepTextView sweepTextView2 = this.chipStatus;
        if (sweepTextView2 != null) {
            sweepTextView2.addOnLayoutChangeListener(this.chipLayoutListener);
        }
        androidx.fragment.app.r activity2 = getActivity();
        if (activity2 != null && (viewFindViewById = activity2.findViewById(com.stepos.ailauncher.sheet.R$id.ail_resident_bottom_slot)) != null) {
            this.residentInputSlot = viewFindViewById;
            viewFindViewById.addOnLayoutChangeListener(this.slotLayoutListener);
        }
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new d());
        } else {
            o1();
        }
        this.topBarImmersive = w();
        this.lastPreviewMode = w();
        artifactContentView.setImmersiveFraction(this.topBarImmersive ? 1.0f : 0.0f);
        kotlin.jvm.internal.p.f(artifactContentView);
        C1(artifactContentView);
        final SessionArtifact sessionArtifactK0 = K0();
        if (sessionArtifactK0 == null) {
            C4148a.u(TAG, "onViewCreated: no artifact arg", false, 4, null);
            return;
        }
        final ArtifactVersions artifactVersions = new ArtifactVersions(C1398p.a(this));
        this.versions = artifactVersions;
        final ArtifactDownloadController artifactDownloadController = new ArtifactDownloadController(this, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.fragment.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDetailFragment.U0(artifactDetailTopBar, this, ((Boolean) obj).booleanValue());
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.fragment.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDetailFragment.V0(this.f28615a, (File) obj);
            }
        });
        this.download = artifactDownloadController;
        artifactVersions.n(new p9.p() { // from class: com.stepos.ailauncher.task.detail.fragment.i
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ArtifactDetailFragment.W0(this.f28616a, (SessionArtifact) obj, (RenderLoadingMode) obj2);
            }
        });
        artifactVersions.p(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.X0(this.f28617a);
            }
        });
        artifactVersions.o(new p9.p() { // from class: com.stepos.ailauncher.task.detail.fragment.k
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ArtifactDetailFragment.Y0(artifactVersions, this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
        s1();
        artifactDetailTopBar.setOnBack(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.Z0(artifactContentView, this);
            }
        });
        artifactDetailTopBar.setOnPrev(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.a1(artifactVersions);
            }
        });
        artifactDetailTopBar.setOnNext(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.b1(artifactVersions);
            }
        });
        artifactDetailTopBar.setOnFullscreen(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.c1(this.f28632a, artifactVersions);
            }
        });
        artifactDetailTopBar.setOnPreview(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.e1(this.f28580a, artifactContentView);
            }
        });
        artifactDetailTopBar.setOnCode(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.f1(this.f28582a, artifactContentView);
            }
        });
        artifactDetailTopBar.setOnDownload(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.g1(artifactVersions, artifactDownloadController, this);
            }
        });
        artifactDetailTopBar.setCodeSelected(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.F
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ArtifactDetailFragment.h1(artifactContentView));
            }
        });
        final int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.artifact_detail_content_top_gap);
        artifactDetailTopBar.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.task.detail.fragment.G
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ArtifactDetailFragment.i1(dimensionPixelSize, artifactContentView, this, view3, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
        artifactDetailTopBar.requestLayout();
        A1(artifactContentView);
        artifactContentView.setOnContentMetricsChanged(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.H
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.j1(this.f28591a, artifactContentView);
            }
        });
        artifactContentView.setOnContentScrollChanged(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.I
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.k1(this.f28593a, artifactContentView);
            }
        });
        artifactContentView.setOnUserDragContent(new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.l1(this.f28605a);
            }
        });
        N.u0(view, new androidx.core.view.A() { // from class: com.stepos.ailauncher.task.detail.fragment.d
            @Override // androidx.core.view.A
            public final a0 a(View view3, a0 a0Var) {
                return ArtifactDetailFragment.m1(this.f28607a, artifactContentView, view3, a0Var);
            }
        });
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            viewGroup.setClipChildren(true);
        }
        artifactVersions.q(sessionArtifactK0);
        artifactVersions.m(sessionArtifactK0.getFileId());
        M5.c cVar = M5.c.INSTANCE;
        String sessionId = sessionArtifactK0.getSessionId();
        M5.c.k(cVar, sessionArtifactK0, (sessionId == null || sessionId.length() <= 0) ? null : sessionId, J0(), null, p1(sessionArtifactK0), 8, null);
        artifactContentView.setOnFolderChildClick(new p9.p() { // from class: com.stepos.ailauncher.task.detail.fragment.e
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ArtifactDetailFragment.n1(this.f28609a, sessionArtifactK0, (SessionArtifact) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public final String p1(SessionArtifact artifact) {
        if (M5.c.INSTANCE.y(artifact.getFileName(), artifact.getMimeType())) {
            return "folder";
        }
        int i10 = c.$EnumSwitchMapping$0[ArtifactRenderKind.INSTANCE.g(artifact).ordinal()];
        return i10 != 1 ? i10 != 2 ? "document" : "html" : "code";
    }

    public final void q1(SessionArtifact art, RenderLoadingMode loadingMode) {
        ArtifactContentView artifactContentView = this.content;
        if (artifactContentView == null) {
            return;
        }
        String fileId = art.getFileId();
        String str = (fileId == null || La.H.x0(fileId)) ? null : fileId;
        if (str != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ArtifactDetailFragment$renderArtifact$1(this, str, artifactContentView, art, null), 3, null);
        } else if (M5.c.INSTANCE.y(art.getFileName(), art.getMimeType())) {
            O0(art);
        } else {
            artifactContentView.o1(art);
        }
    }

    public final void r1(SessionArtifact artifact) {
        String taskId;
        String str = null;
        C4148a.k(TAG, "activeArtifact set fileId=" + (artifact != null ? artifact.getFileId() : null) + " path=" + (artifact != null ? artifact.getCloudPath() : null), false, 4, null);
        I0().E(artifact);
        if (artifact != null && (taskId = artifact.getTaskId()) != null && !La.H.x0(taskId)) {
            str = taskId;
        }
        if (str != null) {
            C2700i.INSTANCE.a("task_id", str);
        } else {
            C2700i.INSTANCE.b("task_id");
        }
    }

    public final void s1() {
        SweepTextView sweepTextView = this.chipStatus;
        if (sweepTextView == null) {
            return;
        }
        TaskChipController taskChipController = new TaskChipController(sweepTextView, 3000L);
        this.chip = taskChipController;
        taskChipController.G(new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.fragment.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ArtifactDetailFragment.t1(this.f28636a, ((Boolean) obj).booleanValue());
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new ArtifactDetailFragment$setupChip$2(this, taskChipController, null), 3, null);
    }

    public final void t0(Boolean targetImmersive) {
        if (targetImmersive != null) {
            this.previewTargetImmersive = targetImmersive;
        }
        if (this.previewTransitioning) {
            return;
        }
        this.previewTransitioning = true;
        this.topBarFadeInStarted = false;
        ArtifactDetailTopBar artifactDetailTopBar = this.topBar;
        if (artifactDetailTopBar != null) {
            artifactDetailTopBar.I();
            artifactDetailTopBar.setChromeAlpha(1.0f);
            ArtifactDetailTopBar.C(artifactDetailTopBar, 0.0f, 200L, this.topBarFadeInterpolator, null, 8, null);
        }
    }

    public final void u1(final File saved) {
        View view = this.savedSnackbar;
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.savedSnackbarAction);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.fragment.A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ArtifactDetailFragment.v1(this.f28577a, saved, view2);
                }
            });
        }
        view.removeCallbacks(this.dismissSavedSnackbar);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
            view.animate().alpha(1.0f).setDuration(180L).start();
        }
        view.postDelayed(this.dismissSavedSnackbar, 4000L);
    }

    public final void y1() {
        ArtifactDetailTopBar artifactDetailTopBar = this.topBar;
        if (artifactDetailTopBar == null || !this.previewTransitioning || this.topBarFadeInStarted) {
            return;
        }
        this.topBarFadeInStarted = true;
        artifactDetailTopBar.I();
        artifactDetailTopBar.setChromeAlpha(0.0f);
        artifactDetailTopBar.B(1.0f, 200L, this.topBarFadeInterpolator, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.detail.fragment.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ArtifactDetailFragment.z1(this.f28634a);
            }
        });
    }

    public final void z0() {
        C4148a.k(TAG, "activeArtifact cleared", false, 4, null);
        I0().E(null);
        C2700i.INSTANCE.b("task_id");
    }
}
