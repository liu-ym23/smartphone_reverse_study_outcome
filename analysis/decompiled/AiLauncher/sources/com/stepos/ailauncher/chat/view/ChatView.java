package com.stepos.ailauncher.chat.view;

import O6.ExternalDeviceInfo;
import Ua.C1060i;
import Ua.InterfaceC1066l;
import Z8.C1173v;
import Z8.C1174w;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.a0;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import b6.InterfaceC1452a;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.ChatMessageAdapter;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.T1;
import com.stepos.agentframework.chatui.view.ChatRecycleView;
import com.stepos.agentframework.uikit.MarkwonHelper;
import com.stepos.agentframework.util.C2154c;
import com.stepos.ailauncher.chat.R$anim;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.activity.ChatMainActivity;
import com.stepos.ailauncher.chat.input.ChatStopActions;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2689c0;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.manager.Q0;
import com.stepos.ailauncher.chat.media.TtsMediaFocusController;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.E7;
import com.stepos.ailauncher.chat.view.sla.SlaChatController;
import com.stepos.ailauncher.chat.wake.WakeDialogImpl;
import com.stepos.ailauncher.chat.wake.effect.SpectrumBorderConfig;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.foundation.task.TaskModule;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import com.stepos.ailauncher.sla.SlaVoiceBridge;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.C0919o;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import w4.ChatMessage;
import y4.InterfaceC5940b;
import y4.InterfaceC5941c;

@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0004Ø\u0002\u0083\u0003\u0018\u0000 §\u00032\u00020\u00012\u00020\u0002:\u0004·\u0001¨\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\rJ\u0019\u0010\u001c\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\rJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010\rJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\rJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\"\u0010\u0017J\u000f\u0010#\u001a\u00020\u0014H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\rJ\u0017\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0014H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0014H\u0002¢\u0006\u0004\b-\u0010$J\u000f\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010\rJ\u000f\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u0010\rJ\u0011\u00100\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\b0\u00101J!\u00104\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u00010\u000f2\u0006\u00103\u001a\u00020\u000fH\u0002¢\u0006\u0004\b4\u0010\u0013J\u0017\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u0010\rJ\u000f\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u0010\rJ\u001f\u0010=\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u0007H\u0002¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u000fH\u0002¢\u0006\u0004\b@\u0010AJ\u001b\u0010B\u001a\u00020\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0004\bB\u0010,J\u001d\u0010F\u001a\u00020\u000b2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u000bH\u0002¢\u0006\u0004\bH\u0010\rJ\u000f\u0010I\u001a\u00020\u000bH\u0002¢\u0006\u0004\bI\u0010\rJ\u000f\u0010J\u001a\u00020\u000bH\u0002¢\u0006\u0004\bJ\u0010\rJ\u000f\u0010K\u001a\u00020\u000bH\u0002¢\u0006\u0004\bK\u0010\rJ\u0017\u0010M\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u000bH\u0002¢\u0006\u0004\bO\u0010\rJ\u0017\u0010Q\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u0014H\u0002¢\u0006\u0004\bQ\u0010\u0017J'\u0010W\u001a\u00020\u00142\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020R2\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bW\u0010XJ\u0011\u0010Y\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\bY\u0010ZJ\u001c\u0010\\\u001a\u00020\u000b*\u00020\u001a2\u0006\u0010[\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u000bH\u0002¢\u0006\u0004\b^\u0010\rJ\u0017\u0010`\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u0007H\u0002¢\u0006\u0004\b`\u0010NJ\u000f\u0010a\u001a\u00020\u000bH\u0002¢\u0006\u0004\ba\u0010\rJ\u000f\u0010b\u001a\u00020\u000bH\u0002¢\u0006\u0004\bb\u0010\rJ\u000f\u0010c\u001a\u00020\u0014H\u0002¢\u0006\u0004\bc\u0010$J\u000f\u0010d\u001a\u00020\u000bH\u0002¢\u0006\u0004\bd\u0010\rJ\u000f\u0010e\u001a\u00020\u000bH\u0002¢\u0006\u0004\be\u0010\rJ\u0011\u0010f\u001a\u0004\u0018\u00010UH\u0002¢\u0006\u0004\bf\u0010gJ\u0017\u0010i\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020UH\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u0007H\u0002¢\u0006\u0004\bk\u0010NJ\u001f\u0010n\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020U2\u0006\u0010m\u001a\u00020\u0007H\u0002¢\u0006\u0004\bn\u0010oJ\u001f\u0010p\u001a\u00020\u000b2\u0006\u0010l\u001a\u00020U2\u0006\u0010m\u001a\u00020\u0007H\u0002¢\u0006\u0004\bp\u0010oJ\u0017\u0010s\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020qH\u0002¢\u0006\u0004\bs\u0010tJ\u0011\u0010u\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\bu\u0010vJ\u0017\u0010w\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0004\bw\u00107J\u0019\u0010y\u001a\u00020\u000b2\b\u0010x\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\by\u00107J\u0017\u0010|\u001a\u00020\u000b2\u0006\u0010{\u001a\u00020zH\u0002¢\u0006\u0004\b|\u0010}J\u0017\u0010~\u001a\u00020\u000b2\u0006\u0010{\u001a\u00020zH\u0002¢\u0006\u0004\b~\u0010}J\u0019\u0010\u0080\u0001\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020UH\u0002¢\u0006\u0005\b\u0080\u0001\u0010jJ\u001a\u0010\u0081\u0001\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001a\u0010\u0083\u0001\u001a\u00020\u00142\u0006\u0010{\u001a\u00020zH\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0011\u0010\u0085\u0001\u001a\u00020\u000bH\u0002¢\u0006\u0005\b\u0085\u0001\u0010\rJ\u0013\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0005\b\u0086\u0001\u0010vJ\u0011\u0010\u0087\u0001\u001a\u00020\u000bH\u0002¢\u0006\u0005\b\u0087\u0001\u0010\rJ\u0011\u0010\u0088\u0001\u001a\u00020\u000bH\u0002¢\u0006\u0005\b\u0088\u0001\u0010\rJ\u000f\u0010\u0089\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u0089\u0001\u0010$J\u000f\u0010\u008a\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u008a\u0001\u0010\rJ2\u0010\u008f\u0001\u001a\u00020\u000b2\u0007\u0010\u008b\u0001\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u00020\u000f2\u000e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0\u008d\u0001¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u000f\u0010\u0091\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0091\u0001\u0010\rJ\u0018\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0092\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u0093\u0001\u0010\u0017J\u000f\u0010\u0094\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0094\u0001\u0010\rJ\u000f\u0010\u0095\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0095\u0001\u0010\rJ'\u0010\u0099\u0001\u001a\u00020\u000b2\u0015\u0010\u0098\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0004\u0012\u00020\u000b0\u0096\u0001¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J'\u0010\u009b\u0001\u001a\u00020\u000b2\u0015\u0010\u0098\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0004\u0012\u00020\u000b0\u0096\u0001¢\u0006\u0006\b\u009b\u0001\u0010\u009a\u0001J\u000f\u0010\u009c\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u009c\u0001\u0010\rJ\u000f\u0010\u009d\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u009d\u0001\u0010\rJ3\u0010\u009f\u0001\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\u0014¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0005\b¡\u0001\u0010vJ\u0011\u0010¢\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0005\b¢\u0001\u0010vJ&\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010£\u0001\u001a\u00020\u00142\t\b\u0002\u0010¤\u0001\u001a\u00020\u0014H\u0007¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u000f\u0010§\u0001\u001a\u00020\u000b¢\u0006\u0005\b§\u0001\u0010\rJ\u0018\u0010©\u0001\u001a\u00020\u000b2\u0007\u0010¨\u0001\u001a\u00020\u000f¢\u0006\u0005\b©\u0001\u00107J\u001c\u0010¬\u0001\u001a\u00020\u00142\b\u0010«\u0001\u001a\u00030ª\u0001H\u0016¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\u000f\u0010®\u0001\u001a\u00020\u000b¢\u0006\u0005\b®\u0001\u0010\rJ\u001a\u0010±\u0001\u001a\u00020\u000b2\b\u0010°\u0001\u001a\u00030¯\u0001¢\u0006\u0006\b±\u0001\u0010²\u0001J\u001a\u0010µ\u0001\u001a\u00020\u000b2\b\u0010´\u0001\u001a\u00030³\u0001¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u0015\u0010·\u0001\u001a\u0005\u0018\u00010³\u0001H\u0016¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u000f\u0010¹\u0001\u001a\u00020\u000b¢\u0006\u0005\b¹\u0001\u0010\rJ\u001a\u0010»\u0001\u001a\u00020\u000b2\b\u0010\u0098\u0001\u001a\u00030º\u0001¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u0011\u0010½\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\b½\u0001\u0010\rJ\u000f\u0010¾\u0001\u001a\u00020\u000b¢\u0006\u0005\b¾\u0001\u0010\rJ\u0011\u0010¿\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0005\b¿\u0001\u0010\rJ&\u0010Â\u0001\u001a\u00020\u000b2\t\b\u0002\u0010À\u0001\u001a\u00020\u00142\t\b\u0002\u0010Á\u0001\u001a\u00020\u0014¢\u0006\u0006\bÂ\u0001\u0010¦\u0001J\u001a\u0010Å\u0001\u001a\u00020\u000b2\b\u0010Ä\u0001\u001a\u00030Ã\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u001a\u0010É\u0001\u001a\u00020\u000b2\b\u0010È\u0001\u001a\u00030Ç\u0001¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u0011\u0010Ë\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0005\bË\u0001\u0010vJ\u0012\u0010Ì\u0001\u001a\u0004\u0018\u00010q¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0016\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0C¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J.\u0010Ð\u0001\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000f2\u0014\u0010Ä\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u0096\u0001¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u0017\u0010Ò\u0001\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000f¢\u0006\u0005\bÒ\u0001\u00107J \u0010Ô\u0001\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000f2\u0007\u0010Ó\u0001\u001a\u00020\u000f¢\u0006\u0005\bÔ\u0001\u0010\u0013J\u0017\u0010Õ\u0001\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000f¢\u0006\u0005\bÕ\u0001\u00107J&\u0010Ø\u0001\u001a\u00020\u000b2\t\b\u0002\u0010Ö\u0001\u001a\u00020\u00142\t\b\u0002\u0010×\u0001\u001a\u00020\u0014¢\u0006\u0006\bØ\u0001\u0010¦\u0001J\u0018\u0010Ú\u0001\u001a\u00020\u000b2\u0007\u0010Ù\u0001\u001a\u00020\u0007¢\u0006\u0005\bÚ\u0001\u0010NR\u001a\u0010Ü\u0001\u001a\u00030Û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u001b\u0010Þ\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u0019\u0010à\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u001b\u0010â\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0019\u0010ä\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u001b\u0010æ\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ã\u0001R\u0019\u0010ç\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010å\u0001R\u0019\u0010è\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010á\u0001R\u0019\u0010é\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010å\u0001R\u001c\u0010ë\u0001\u001a\u0005\u0018\u00010ê\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R8\u0010í\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001\"\u0006\bñ\u0001\u0010\u009a\u0001RE\u0010ô\u0001\u001a0\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0004\u0012\u00020\u000b0\u0096\u00010ò\u0001j\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0004\u0012\u00020\u000b0\u0096\u0001`ó\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R\u0019\u0010ö\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010á\u0001R\u0019\u0010÷\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010á\u0001R\u001c\u0010ù\u0001\u001a\u0005\u0018\u00010ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u001b\u0010û\u0001\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u0019\u0010ý\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010å\u0001R\u001c\u0010ÿ\u0001\u001a\u0005\u0018\u00010þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0080\u0002R\u0017\u0010\u0081\u0002\u001a\u00020\u00078\u0002X\u0082D¢\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0017\u0010\u0083\u0002\u001a\u00020\u00078\u0002X\u0082D¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0082\u0002R\u0017\u0010\u0084\u0002\u001a\u00020\u00078\u0002X\u0082D¢\u0006\b\n\u0006\b\u0084\u0002\u0010\u0082\u0002R0\u0010\u0086\u0002\u001a\u00020\u00142\u0007\u0010\u0085\u0002\u001a\u00020\u00148\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u0086\u0002\u0010á\u0001\u001a\u0005\b\u0087\u0002\u0010$\"\u0005\b\u0088\u0002\u0010\u0017R\u0019\u0010\u0089\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010á\u0001R\u001c\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u008a\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010\u008c\u0002R\u001c\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R'\u0010\u0090\u0002\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0090\u0002\u0010á\u0001\u001a\u0005\b\u0091\u0002\u0010$\"\u0005\b\u0092\u0002\u0010\u0017R!\u0010\u0096\u0002\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b\u0093\u0002\u0010\u0094\u0002\u001a\u0005\b\u0095\u0002\u0010gR!\u0010\u0099\u0002\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b\u0097\u0002\u0010\u0094\u0002\u001a\u0005\b\u0098\u0002\u0010gR\u0019\u0010\u009a\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0002\u0010\u0082\u0002R\u0019\u0010\u009b\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u0082\u0002R\u0019\u0010\u009c\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u0082\u0002R\u0019\u0010\u009d\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u0082\u0002R\u0017\u0010\u009e\u0002\u001a\u00020R8\u0002X\u0082D¢\u0006\b\n\u0006\b\u009e\u0002\u0010\u009f\u0002R\u0017\u0010 \u0002\u001a\u00020R8\u0002X\u0082D¢\u0006\b\n\u0006\b \u0002\u0010\u009f\u0002R\u0019\u0010¡\u0002\u001a\u00020R8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010\u009f\u0002R\u0019\u0010¢\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0002\u0010\u0082\u0002R\u0019\u0010£\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0002\u0010á\u0001R'\u0010¤\u0002\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¤\u0002\u0010á\u0001\u001a\u0005\b¤\u0002\u0010$\"\u0005\b¥\u0002\u0010\u0017R\u0019\u0010¦\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010\u0082\u0002R\u0019\u0010§\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0002\u0010á\u0001R\u001c\u0010¨\u0002\u001a\u0005\u0018\u00010\u008d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0002\u0010\u008f\u0002R\u001c\u0010°\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010©\u0002R\u001c\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010ª\u0002R>\u0010«\u0002\u001a\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b«\u0002\u0010î\u0001\u001a\u0006\b¬\u0002\u0010ð\u0001\"\u0006\b\u00ad\u0002\u0010\u009a\u0001R8\u0010®\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b®\u0002\u0010î\u0001\u001a\u0006\b¯\u0002\u0010ð\u0001\"\u0006\b°\u0002\u0010\u009a\u0001R8\u0010±\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b±\u0002\u0010î\u0001\u001a\u0006\b²\u0002\u0010ð\u0001\"\u0006\b³\u0002\u0010\u009a\u0001R2\u0010´\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u008d\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b´\u0002\u0010µ\u0002\u001a\u0006\b¶\u0002\u0010·\u0002\"\u0006\b¸\u0002\u0010¹\u0002R:\u0010º\u0002\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bº\u0002\u0010î\u0001\u001a\u0006\b»\u0002\u0010ð\u0001\"\u0006\b¼\u0002\u0010\u009a\u0001R'\u0010½\u0002\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b½\u0002\u0010á\u0001\u001a\u0005\b¾\u0002\u0010$\"\u0005\b¿\u0002\u0010\u0017R\u001c\u0010Á\u0002\u001a\u0005\u0018\u00010À\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R\u001f\u0010Å\u0002\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bÃ\u0002\u0010\u0094\u0002\u001a\u0005\bÄ\u0002\u0010gR\u001f\u0010È\u0002\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bÆ\u0002\u0010\u0094\u0002\u001a\u0005\bÇ\u0002\u0010gR\u0019\u0010É\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010á\u0001R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010ê\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0002\u0010ì\u0001R!\u0010Ï\u0002\u001a\u00030Ë\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÌ\u0002\u0010\u0094\u0002\u001a\u0006\bÍ\u0002\u0010Î\u0002R2\u0010Ð\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u008d\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÐ\u0002\u0010µ\u0002\u001a\u0006\bÑ\u0002\u0010·\u0002\"\u0006\bÒ\u0002\u0010¹\u0002R!\u0010×\u0002\u001a\u00030Ó\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÔ\u0002\u0010\u0094\u0002\u001a\u0006\bÕ\u0002\u0010Ö\u0002R\u0018\u0010Ù\u0002\u001a\u00030Ø\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0002\u0010Ú\u0002R\u0019\u0010Û\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0002\u0010á\u0001R#\u0010à\u0002\u001a\u0005\u0018\u00010Ü\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÝ\u0002\u0010\u0094\u0002\u001a\u0006\bÞ\u0002\u0010ß\u0002R!\u0010ã\u0002\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bá\u0002\u0010\u0094\u0002\u001a\u0005\bâ\u0002\u0010gR8\u0010ä\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0096\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bä\u0002\u0010î\u0001\u001a\u0006\bå\u0002\u0010ð\u0001\"\u0006\bæ\u0002\u0010\u009a\u0001R!\u0010ë\u0002\u001a\u00030ç\u00028FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bè\u0002\u0010\u0094\u0002\u001a\u0006\bé\u0002\u0010ê\u0002R\u001f\u0010î\u0002\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bì\u0002\u0010\u0094\u0002\u001a\u0005\bí\u0002\u0010gR!\u0010ñ\u0002\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bï\u0002\u0010\u0094\u0002\u001a\u0005\bð\u0002\u0010gR!\u0010ô\u0002\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bò\u0002\u0010\u0094\u0002\u001a\u0005\bó\u0002\u0010gR!\u0010ù\u0002\u001a\u00030õ\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bö\u0002\u0010\u0094\u0002\u001a\u0006\b÷\u0002\u0010ø\u0002R!\u0010þ\u0002\u001a\u00030ú\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bû\u0002\u0010\u0094\u0002\u001a\u0006\bü\u0002\u0010ý\u0002R \u0010\u0080\u0003\u001a\t\u0012\u0005\u0012\u00030ÿ\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0003\u0010\u0081\u0003R\u0019\u0010\u0082\u0003\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0003\u0010á\u0001R\u0018\u0010\u0084\u0003\u001a\u00030\u0083\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0003\u0010\u0085\u0003R\u0019\u0010\u0086\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0003\u0010\u0082\u0002R'\u0010\u0089\u0003\u001a\t\u0012\u0004\u0012\u00020\u000b0\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0003\u0010\u0094\u0002\u001a\u0006\b\u0088\u0003\u0010·\u0002R!\u0010\u008e\u0003\u001a\u00030\u008a\u00038BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008b\u0003\u0010\u0094\u0002\u001a\u0006\b\u008c\u0003\u0010\u008d\u0003R'\u0010\u008f\u0003\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u008f\u0003\u0010á\u0001\u001a\u0005\b\u008f\u0003\u0010$\"\u0005\b\u0090\u0003\u0010\u0017R\u001b\u0010\u0091\u0003\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0003\u0010\u0092\u0003R\u001b\u0010\u0093\u0003\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0003\u0010\u0092\u0003R\u0019\u0010\u0094\u0003\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0003\u0010á\u0001R\u0019\u0010\u0095\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0003\u0010\u0082\u0002R\u001b\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0003\u0010\u0092\u0003R\u0019\u0010\u0097\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0003\u0010\u0082\u0002R\u0019\u0010\u0098\u0003\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0003\u0010á\u0001R\u0019\u0010\u0099\u0003\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0003\u0010á\u0001R\u0018\u0010\u009b\u0003\u001a\u00030\u009a\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0003\u0010\u009c\u0003R\u0019\u0010\u009d\u0003\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0003\u0010å\u0001R\u0019\u0010\u009e\u0003\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0003\u0010á\u0001R\u001b\u0010\u009f\u0003\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0003\u0010ã\u0001R\u001b\u0010 \u0003\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0003\u0010ã\u0001R\u0019\u0010¡\u0003\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0003\u0010á\u0001R\u0019\u0010¢\u0003\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0003\u0010á\u0001R\u0017\u0010¦\u0003\u001a\u0005\u0018\u00010£\u00038F¢\u0006\b\u001a\u0006\b¤\u0003\u0010¥\u0003¨\u0006©\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ChatView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/stepos/ailauncher/common/utils/z;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "i3", "()V", "T3", "", "agentId", "deviceId", "b3", "(Ljava/lang/String;Ljava/lang/String;)V", "", "finalizing", "d1", "(Z)V", "T1", "H1", "Landroidx/drawerlayout/widget/DrawerLayout;", "drawer", "B2", "(Landroidx/drawerlayout/widget/DrawerLayout;)Z", "Y3", "h2", "c1", "hasExecutingTask", "g1", "t1", "()Z", "h3", "receive", "q3", "(Z)I", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "k1", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "F2", "Q2", "W1", "U1", "()Lcom/stepos/agentframework/chatcore/SessionHandler;", "expectedSessionId", "reason", "d3", "sessionId", "z3", "(Ljava/lang/String;)V", "V1", "t3", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "attempt", "m3", "(JI)V", "isEmpty", SdCardDbCreator.FIELD_LASTLOC_INFO, "(ZLjava/lang/String;)V", "F1", "", "Lw4/c;", "messages", "U3", "(Ljava/util/List;)V", "I2", "I1", "c2", "O3", "uiMode", "c4", "(I)V", "X0", "show", "X1", "", "rawX", "rawY", "Landroid/view/View;", "target", "E2", "(FFLandroid/view/View;)Z", "Z1", "()Landroidx/drawerlayout/widget/DrawerLayout;", "gravity", "h1", "(Landroidx/drawerlayout/widget/DrawerLayout;ILe9/c;)Ljava/lang/Object;", "H3", "keyboardHeight", "f1", "w3", "r1", "D2", "D3", "F3", "getActivityRootView", "()Landroid/view/View;", "rootView", "S1", "(Landroid/view/View;)V", SdCardDbCreator.FIELD_LASTLOC_NB, "bottomSheet", "newHeight", "V3", "(Landroid/view/View;I)V", "W3", "Lcom/stepos/agentframework/chatui/N1;", "m", "l3", "(Lcom/stepos/agentframework/chatui/N1;)V", "M1", "()Ljava/lang/String;", "v1", "loadedSessionId", "r3", "Lcom/stepos/ailauncher/chat/view/ChatView$b;", "request", "s3", "(Lcom/stepos/ailauncher/chat/view/ChatView$b;)V", "B3", "view", "Y2", "A2", "(Ljava/lang/String;)Z", "G2", "(Lcom/stepos/ailauncher/chat/view/ChatView$b;)Z", "s1", "X2", "j3", "u3", "C2", "M2", "hint", "action", "Lkotlin/Function0;", "onClick", "M3", "(Ljava/lang/String;Ljava/lang/String;Lp9/a;)V", "g2", "offline", "P3", "L2", "j1", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "listener", "f4", "(Lp9/l;)V", "k3", "u1", SdCardDbCreator.FIELD_LASTLOC_TIME, "showAlreadyNewChatToast", "K1", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Q1", "R1", com.stepos.ailauncher.chat.trace.h.APP_FOREGROUND, "catchUp", "T2", "(ZZ)V", "b4", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "E3", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "p3", "Landroid/view/WindowManager;", "windowManager", "setWindowManager", "(Landroid/view/WindowManager;)V", "Landroid/app/Activity;", "activity", "setActivity", "(Landroid/app/Activity;)V", Const.INTENT_KEY_APIKEY, "()Landroid/app/Activity;", "N3", "Lcom/stepos/agentframework/chatui/AgentChatLayout$b;", "setKeyboardListener", "(Lcom/stepos/agentframework/chatui/AgentChatLayout$b;)V", "onAttachedToWindow", "v3", "onDetachedFromWindow", "fullTeardown", "preserveSharedSessionHandler", "e3", "Lcom/stepos/agentframework/chatcore/session/AgentSession$b;", "callback", "f2", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$b;)V", "Lcom/stepos/agentframework/chatcore/session/Z;", "changeCallback", "setActiveConversationsChangedListener", "(Lcom/stepos/agentframework/chatcore/session/Z;)V", "getCurrentSessionId", "P2", "()Lcom/stepos/agentframework/chatui/N1;", "P1", "()Ljava/util/List;", "J1", "(Ljava/lang/String;Lp9/l;)V", "w1", "taskId", "O2", "N2", "skipReload", "syncRemoteHistory", "V2", "level", "Q3", "LUa/M;", "scope", "LUa/M;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionBindingReleased", "Z", "pendingSessionSwitchId", "Ljava/lang/String;", "pendingSessionSwitchAt", "J", "activeSessionSwitchId", "sessionSwitchRecoverGeneration", "handoffReloadPending", "handoffReloadGeneration", "Ljava/lang/Runnable;", "handoffReloadRetryRunnable", "Ljava/lang/Runnable;", "onHandoffReloadFinished", "Lp9/l;", "getOnHandoffReloadFinished", "()Lp9/l;", "setOnHandoffReloadFinished", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "sessionReadyListeners", "Ljava/util/LinkedHashSet;", "sessionHandlerAcquired", "preserveSharedSessionHandlerOnDetach", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter;", "chatMessageAdapter", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter;", "pendingTaskNavigation", "Lcom/stepos/ailauncher/chat/view/ChatView$b;", "taskNavigationGeneration", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "slaController", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "UI_MODE_NORMAL", "I", "UI_MODE_LITE", "UI_MODE_WAKE", UxipConstants.f30680s, "fullScreenModel", "getFullScreenModel", "setFullScreenModel", "scrollBtnFloated", "Lcom/stepos/ailauncher/chat/view/E7$a;", "scrollBtnFloatHandle", "Lcom/stepos/ailauncher/chat/view/E7$a;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "appsPillOverlayListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "suppressPillOverlaySync", "getSuppressPillOverlaySync", "setSuppressPillOverlaySync", "btnAppsHotArea$delegate", "LY8/h;", "getBtnAppsHotArea", "btnAppsHotArea", "btnAppsPill$delegate", "getBtnAppsPill", "btnAppsPill", "inputUIModel", "maxDialogHeightAuto", "maxDialogHeight", "minDialogHeight", "topMarginDpAuto", "F", "topMarginDp", "initialY", "initialBottomSheetHeight", "isDragging", "isInMain", "setInMain", "currentKeyboardHeight", "keyboardVisible", "keyboardLayoutListener", "Landroid/view/WindowManager;", "Landroid/app/Activity;", "onSessionMessageListLoaded", "getOnSessionMessageListLoaded", "setOnSessionMessageListLoaded", "onMessageListChanged", "getOnMessageListChanged", "setOnMessageListChanged", "onConversationSwitchStarted", "getOnConversationSwitchStarted", "setOnConversationSwitchStarted", "onSessionSuccess", "Lp9/a;", "getOnSessionSuccess", "()Lp9/a;", "setOnSessionSuccess", "(Lp9/a;)V", "onMsgSent", "getOnMsgSent", "setOnMsgSent", "mark", "getMark", "setMark", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "spectrumController", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "aiKeyWaitingBar$delegate", "getAiKeyWaitingBar", "aiKeyWaitingBar", "aiKeyWaitingStop$delegate", "getAiKeyWaitingStop", "aiKeyWaitingStop", "aiKeyFinalizing", "pendingAiKeyFinalizingUiRunnable", "Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController;", "ttsMediaFocusController$delegate", "getTtsMediaFocusController", "()Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController;", "ttsMediaFocusController", "onAudioFocusLost", "getOnAudioFocusLost", "setOnAudioFocusLost", "Lcom/stepos/ailauncher/chat/util/g;", "keepScreenOnController$delegate", "getKeepScreenOnController", "()Lcom/stepos/ailauncher/chat/util/g;", "keepScreenOnController", "com/stepos/ailauncher/chat/view/ChatView$n", "screenOffReceiver", "Lcom/stepos/ailauncher/chat/view/ChatView$n;", "screenOffReceiverRegistered", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", "chatLayout$delegate", "getChatLayout", "()Lcom/stepos/agentframework/chatui/AgentChatLayout;", "chatLayout", "bgSpeech$delegate", "getBgSpeech", "bgSpeech", "onRecordingTouchBlockHost", "getOnRecordingTouchBlockHost", "setOnRecordingTouchBlockHost", "Lcom/stepos/ailauncher/chat/view/MainInputView;", "inputView$delegate", "getInputView", "()Lcom/stepos/ailauncher/chat/view/MainInputView;", "inputView", "vChatBg$delegate", "getVChatBg", "vChatBg", "vChatBottomBg$delegate", "getVChatBottomBg", "vChatBottomBg", "bottomFadeMask$delegate", "getBottomFadeMask", "bottomFadeMask", "Landroid/widget/TextView;", "aiDeclare$delegate", "getAiDeclare", "()Landroid/widget/TextView;", "aiDeclare", "Landroid/widget/ImageView;", "ivDragBar$delegate", "getIvDragBar", "()Landroid/widget/ImageView;", "ivDragBar", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "activeTaskSnapshot", "Ljava/util/List;", "taskDrivenReplying", "com/stepos/ailauncher/chat/view/ChatView$taskCardCallback$1", "taskCardCallback", "Lcom/stepos/ailauncher/chat/view/ChatView$taskCardCallback$1;", "latestChatContentHeight", "chatLayoutExitFloatModeListener$delegate", "getChatLayoutExitFloatModeListener", "chatLayoutExitFloatModeListener", "Landroid/view/View$OnLayoutChangeListener;", "inputBottomOptionChangeListener$delegate", "getInputBottomOptionChangeListener", "()Landroid/view/View$OnLayoutChangeListener;", "inputBottomOptionChangeListener", "isDismiss", "setDismiss", "lastKeyboardHeightForInsets", "Ljava/lang/Integer;", "lastBottomMargin", "imeHideAnimating", "hideOffsetResetGeneration", "originChatPaddingBottom", "aiDeclareVisibilityBeforeKeyboard", "pinMessageListToBottomForIme", "isResumed", "Lcom/stepos/ailauncher/chat/manager/Q0$a;", "onSessionExternallyMarked", "Lcom/stepos/ailauncher/chat/manager/Q0$a;", "chatSessionStartElapsed", "chatExitReported", "lastReceiveReportedMsgId", "lastReceiveReportedStatus", "markdownThemeClearedByTrim", "messageListCacheTrimmed", "Lcom/stepos/agentframework/chatui/view/ChatRecycleView;", "getMessageList", "()Lcom/stepos/agentframework/chatui/view/ChatRecycleView;", "messageList", "Companion", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatView extends ConstraintLayout implements com.stepos.ailauncher.common.utils.z {
    private static final long AI_KEY_FINALIZING_HIDE_DELAY_MS = 33;
    private static final int DEFAULT_MESSAGE_LIST_CACHE_SIZE = 2;
    private static final int HANDOFF_RELOAD_MAX_ATTEMPTS = 8;
    private static final long HANDOFF_RELOAD_RETRY_MS = 120;
    private static final long PENDING_SESSION_SWITCH_TTL_MS = 3000;
    private static final long SESSION_SWITCH_FAST_RECOVER_MS = 400;
    private static final long TASK_ANCHOR_FADE_IN_MS = 220;
    private static final long TASK_ANCHOR_FADE_OUT_MS = 140;
    private final int UI_MODE_LITE;
    private final int UI_MODE_NORMAL;
    private final int UI_MODE_WAKE;
    private String activeSessionSwitchId;
    private List<UiTask> activeTaskSnapshot;
    private Activity activity;

    /* renamed from: aiDeclare$delegate, reason: from kotlin metadata */
    private final Y8.h aiDeclare;
    private int aiDeclareVisibilityBeforeKeyboard;
    private boolean aiKeyFinalizing;

    /* renamed from: aiKeyWaitingBar$delegate, reason: from kotlin metadata */
    private final Y8.h aiKeyWaitingBar;

    /* renamed from: aiKeyWaitingStop$delegate, reason: from kotlin metadata */
    private final Y8.h aiKeyWaitingStop;
    private ViewTreeObserver.OnGlobalLayoutListener appsPillOverlayListener;

    /* renamed from: bgSpeech$delegate, reason: from kotlin metadata */
    private final Y8.h bgSpeech;

    /* renamed from: bottomFadeMask$delegate, reason: from kotlin metadata */
    private final Y8.h bottomFadeMask;

    /* renamed from: btnAppsHotArea$delegate, reason: from kotlin metadata */
    private final Y8.h btnAppsHotArea;

    /* renamed from: btnAppsPill$delegate, reason: from kotlin metadata */
    private final Y8.h btnAppsPill;
    private boolean chatExitReported;

    /* renamed from: chatLayout$delegate, reason: from kotlin metadata */
    private final Y8.h chatLayout;

    /* renamed from: chatLayoutExitFloatModeListener$delegate, reason: from kotlin metadata */
    private final Y8.h chatLayoutExitFloatModeListener;
    private ChatMessageAdapter chatMessageAdapter;
    private long chatSessionStartElapsed;
    private int currentKeyboardHeight;
    private boolean fullScreenModel;
    private long handoffReloadGeneration;
    private volatile boolean handoffReloadPending;
    private Runnable handoffReloadRetryRunnable;
    private int hideOffsetResetGeneration;
    private boolean imeHideAnimating;
    private int initialBottomSheetHeight;
    private float initialY;

    /* renamed from: inputBottomOptionChangeListener$delegate, reason: from kotlin metadata */
    private final Y8.h inputBottomOptionChangeListener;
    private int inputUIModel;

    /* renamed from: inputView$delegate, reason: from kotlin metadata */
    private final Y8.h inputView;
    private boolean isDismiss;
    private boolean isDragging;
    private boolean isInMain;
    private boolean isResumed;

    /* renamed from: ivDragBar$delegate, reason: from kotlin metadata */
    private final Y8.h ivDragBar;

    /* renamed from: keepScreenOnController$delegate, reason: from kotlin metadata */
    private final Y8.h keepScreenOnController;
    private ViewTreeObserver.OnGlobalLayoutListener keyboardLayoutListener;
    private boolean keyboardVisible;
    private Integer lastBottomMargin;
    private Integer lastKeyboardHeightForInsets;
    private String lastReceiveReportedMsgId;
    private String lastReceiveReportedStatus;
    private int latestChatContentHeight;
    private boolean mark;
    private boolean markdownThemeClearedByTrim;
    private int maxDialogHeight;
    private int maxDialogHeightAuto;
    private boolean messageListCacheTrimmed;
    private int minDialogHeight;
    private InterfaceC5063a<Y8.t> onAudioFocusLost;
    private InterfaceC5074l<? super String, Y8.t> onConversationSwitchStarted;
    private InterfaceC5074l<? super Boolean, Y8.t> onHandoffReloadFinished;
    private InterfaceC5074l<? super Boolean, Y8.t> onMessageListChanged;
    private InterfaceC5074l<? super String, Y8.t> onMsgSent;
    private InterfaceC5074l<? super Boolean, Y8.t> onRecordingTouchBlockHost;
    private final Q0.a onSessionExternallyMarked;
    private InterfaceC5074l<? super List<ChatMessage>, Y8.t> onSessionMessageListLoaded;
    private InterfaceC5063a<Y8.t> onSessionSuccess;
    private Integer originChatPaddingBottom;
    private Runnable pendingAiKeyFinalizingUiRunnable;
    private long pendingSessionSwitchAt;
    private String pendingSessionSwitchId;
    private TaskNavigationRequest pendingTaskNavigation;
    private boolean pinMessageListToBottomForIme;
    private boolean preserveSharedSessionHandlerOnDetach;
    private Ua.M scope;
    private final n screenOffReceiver;
    private boolean screenOffReceiverRegistered;
    private E7.a scrollBtnFloatHandle;
    private boolean scrollBtnFloated;
    private boolean sessionBindingReleased;
    private SessionHandler sessionHandler;
    private boolean sessionHandlerAcquired;
    private final LinkedHashSet<InterfaceC5074l<BaseInputView, Y8.t>> sessionReadyListeners;
    private long sessionSwitchRecoverGeneration;
    private SlaChatController slaController;
    private com.stepos.ailauncher.chat.wake.effect.c spectrumController;
    private boolean suppressPillOverlaySync;
    private final ChatView$taskCardCallback$1 taskCardCallback;
    private boolean taskDrivenReplying;
    private long taskNavigationGeneration;
    private final float topMarginDp;
    private final float topMarginDpAuto;

    /* renamed from: ttsMediaFocusController$delegate, reason: from kotlin metadata */
    private final Y8.h ttsMediaFocusController;

    /* renamed from: vChatBg$delegate, reason: from kotlin metadata */
    private final Y8.h vChatBg;

    /* renamed from: vChatBottomBg$delegate, reason: from kotlin metadata */
    private final Y8.h vChatBottomBg;
    private WindowManager windowManager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SpectrumBorderConfig LONG_PRESS_SPECTRUM_CONFIG = SpectrumBorderConfig.INSTANCE.a();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ChatView$a;", "", "<init>", "()V", "", "sessionId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "LONG_PRESS_SPECTRUM_CONFIG", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "", "DEFAULT_MESSAGE_LIST_CACHE_SIZE", "I", "", "PENDING_SESSION_SWITCH_TTL_MS", "J", "SESSION_SWITCH_FAST_RECOVER_MS", "TASK_ANCHOR_FADE_OUT_MS", "TASK_ANCHOR_FADE_IN_MS", "HANDOFF_RELOAD_RETRY_MS", "HANDOFF_RELOAD_MAX_ATTEMPTS", "AI_KEY_FINALIZING_HIDE_DELAY_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.ChatView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(String sessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            com.stepos.ailauncher.chat.manager.Q0.j(sessionId);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ChatView$b;", "", "", "sessionId", "taskId", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "J", Const.INTENT_KEY_APIKEY, "()J", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.ChatView$b, reason: from toString */
    public static final /* data */ class TaskNavigationRequest {
        private final long generation;
        private final String sessionId;
        private final String taskId;

        public TaskNavigationRequest(String sessionId, String taskId, long j10) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(taskId, "taskId");
            this.sessionId = sessionId;
            this.taskId = taskId;
            this.generation = j10;
        }

        /* renamed from: a, reason: from getter */
        public final long getGeneration() {
            return this.generation;
        }

        /* renamed from: b, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: c, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskNavigationRequest)) {
                return false;
            }
            TaskNavigationRequest taskNavigationRequest = (TaskNavigationRequest) other;
            return kotlin.jvm.internal.p.d(this.sessionId, taskNavigationRequest.sessionId) && kotlin.jvm.internal.p.d(this.taskId, taskNavigationRequest.taskId) && this.generation == taskNavigationRequest.generation;
        }

        public int hashCode() {
            return (((this.sessionId.hashCode() * 31) + this.taskId.hashCode()) * 31) + Long.hashCode(this.generation);
        }

        public String toString() {
            return "TaskNavigationRequest(sessionId=" + this.sessionId + ", taskId=" + this.taskId + ", generation=" + this.generation + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EReplyStatus.values().length];
            try {
                iArr[EReplyStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EReplyStatus.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EReplyStatus.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/ChatView$d", "Lcom/stepos/agentframework/chatui/AgentChatLayout$b;", "", "show", "", "insetBottom", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ZI)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements AgentChatLayout.InterfaceC1970b {
        final /* synthetic */ Integer $originPaddingBottom;

        public d(Integer num) {
            this.$originPaddingBottom = num;
        }

        @Override // com.stepos.agentframework.chatui.AgentChatLayout.InterfaceC1970b
        public void a(boolean show, int insetBottom) {
            O6.b bVar = O6.b.INSTANCE;
            Context context = ChatView.this.getContext();
            kotlin.jvm.internal.p.f(context);
            bVar.a(context);
            ChatView.this.getChatLayout();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class e implements InterfaceC5074l<Throwable, Y8.t> {
        final /* synthetic */ f $listener;
        final /* synthetic */ DrawerLayout $this_awaitCloseDrawer;

        public e(DrawerLayout drawerLayout, f fVar) {
            this.$this_awaitCloseDrawer = drawerLayout;
            this.$listener = fVar;
        }

        public final void a(Throwable th) {
            this.$this_awaitCloseDrawer.O(this.$listener);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(Throwable th) {
            a(th);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/view/ChatView$f", "Landroidx/drawerlayout/widget/DrawerLayout$g;", "Landroid/view/View;", "drawerView", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends DrawerLayout.g {
        final /* synthetic */ InterfaceC1066l<Y8.t> $cont;
        final /* synthetic */ DrawerLayout $this_awaitCloseDrawer;

        /* JADX WARN: Multi-variable type inference failed */
        public f(DrawerLayout drawerLayout, InterfaceC1066l<? super Y8.t> interfaceC1066l) {
            this.$this_awaitCloseDrawer = drawerLayout;
            this.$cont = interfaceC1066l;
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View drawerView) {
            kotlin.jvm.internal.p.i(drawerView, "drawerView");
            this.$this_awaitCloseDrawer.O(this);
            if (this.$cont.b()) {
                InterfaceC1066l<Y8.t> interfaceC1066l = this.$cont;
                Result.Companion companion = Result.INSTANCE;
                interfaceC1066l.resumeWith(Result.b(Y8.t.f7040a));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/view/ChatView$g", "Lcom/stepos/agentframework/chatui/T1$a;", "LY8/t;", "onPlayStarted", "()V", "onPlayStopped", "", "code", "message", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements T1.a {
        public g() {
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void a(String code, String message) {
            kotlin.jvm.internal.p.i(code, "code");
            kotlin.jvm.internal.p.i(message, "message");
            C4148a.u("ChatView", "TTS Play Error code=" + code + " msg=" + message + " -> release screen+focus", false, 4, null);
            ChatView.this.I1();
            ChatView.this.getTtsMediaFocusController().c0();
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public /* bridge */ void b(String str) {
            super.b(str);
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void onPlayStarted() {
            ChatView.this.I2();
            ChatView.this.getTtsMediaFocusController().t();
            C4148a.k("ChatView", "TTS Play Started", false, 4, null);
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void onPlayStopped() {
            ChatView.this.I1();
            ChatView.this.getTtsMediaFocusController().c0();
            C4148a.k("ChatView", "TTS Play Stopped", false, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/ChatView$h", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/view/animation/Animation;)V", "onAnimationRepeat", "onAnimationStart", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/view/ChatView$i", "Lcom/stepos/agentframework/chatcore/session/AgentSession$e;", "", "Lw4/e;", "titles", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i implements AgentSession.e {
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $callback;
        final /* synthetic */ String $sessionId;

        /* JADX WARN: Multi-variable type inference failed */
        public i(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, String str) {
            this.$callback = interfaceC5074l;
            this.$sessionId = str;
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.e
        public void a(List<w4.e> titles) {
            InterfaceC5074l<Boolean, Y8.t> interfaceC5074l = this.$callback;
            boolean z10 = false;
            if (titles != null) {
                List<w4.e> list = titles;
                String str = this.$sessionId;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        w4.e eVar = (w4.e) it.next();
                        if (kotlin.jvm.internal.p.d(eVar.getSessionId(), str) && !eVar.p()) {
                            z10 = true;
                            break;
                        }
                    }
                }
            }
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class j implements InterfaceC5074l<Object, Boolean> {
        public static final j INSTANCE = new j();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj instanceof DisplayMessage);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class k implements InterfaceC5074l<Object, Boolean> {
        public static final k INSTANCE = new k();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj instanceof DisplayMessage);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class l implements Runnable {
        final /* synthetic */ ChatRecycleView $messageList;
        final /* synthetic */ TaskNavigationRequest $request;

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a implements View.OnLayoutChangeListener {
            final /* synthetic */ ChatRecycleView $messageList$inlined;
            final /* synthetic */ int $position$inlined;
            final /* synthetic */ TaskNavigationRequest $request$inlined;
            final /* synthetic */ ChatView this$0;

            public a(ChatView chatView, TaskNavigationRequest taskNavigationRequest, ChatRecycleView chatRecycleView, int i10) {
                this.this$0 = chatView;
                this.$request$inlined = taskNavigationRequest;
                this.$messageList$inlined = chatRecycleView;
                this.$position$inlined = i10;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
                View view2;
                view.removeOnLayoutChangeListener(this);
                if (!this.this$0.G2(this.$request$inlined) || (viewHolderFindViewHolderForAdapterPosition = this.$messageList$inlined.findViewHolderForAdapterPosition(this.$position$inlined)) == null || (view2 = viewHolderFindViewHolderForAdapterPosition.itemView) == null) {
                    return;
                }
                this.this$0.Y2(view2);
            }
        }

        public l(TaskNavigationRequest taskNavigationRequest, ChatRecycleView chatRecycleView) {
            this.$request = taskNavigationRequest;
            this.$messageList = chatRecycleView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
            View view;
            if (ChatView.this.G2(this.$request)) {
                ChatMessageAdapter chatMessageAdapter = ChatView.this.chatMessageAdapter;
                List<com.stepos.agentframework.chatui.S1> listG = chatMessageAdapter != null ? chatMessageAdapter.G() : null;
                if (listG == null) {
                    listG = C1173v.m();
                }
                int iA = C2776b9.a(listG, this.$request.getTaskId());
                if (iA < 0) {
                    C4148a.u("ChatView", "navigateToTask failed: taskId=" + this.$request.getTaskId() + " sessionId=" + this.$request.getSessionId() + " is absent from loaded messages", false, 4, null);
                    Toast.makeText(ChatView.this.getContext(), R$string.task_anchor_not_found, 0).show();
                    return;
                }
                this.$messageList.stopScroll();
                this.$messageList.scrollToPosition(iA);
                ChatRecycleView chatRecycleView = this.$messageList;
                ChatView chatView = ChatView.this;
                TaskNavigationRequest taskNavigationRequest = this.$request;
                if (!chatRecycleView.isLaidOut() || chatRecycleView.isLayoutRequested()) {
                    chatRecycleView.addOnLayoutChangeListener(new a(chatView, taskNavigationRequest, chatRecycleView, iA));
                } else {
                    if (!chatView.G2(taskNavigationRequest) || (viewHolderFindViewHolderForAdapterPosition = chatRecycleView.findViewHolderForAdapterPosition(iA)) == null || (view = viewHolderFindViewHolderForAdapterPosition.itemView) == null) {
                        return;
                    }
                    chatView.Y2(view);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class m implements View.OnLayoutChangeListener {
        final /* synthetic */ ChatRecycleView $messageList$inlined;
        final /* synthetic */ TaskNavigationRequest $request$inlined;
        final /* synthetic */ ChatView this$0;

        public m(ChatRecycleView chatRecycleView, ChatView chatView, TaskNavigationRequest taskNavigationRequest) {
            this.$messageList$inlined = chatRecycleView;
            this.this$0 = chatView;
            this.$request$inlined = taskNavigationRequest;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            ChatRecycleView chatRecycleView = this.$messageList$inlined;
            chatRecycleView.post(this.this$0.new l(this.$request$inlined, chatRecycleView));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/view/ChatView$n", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class n extends BroadcastReceiver {
        public n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.SCREEN_OFF")) {
                C4148a.d("ChatView", "screenOffReceiver: stopAllVoiceForPageLeave", false, 4, null);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    InputViewManager.INSTANCE.e1("screen_lock");
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
                com.stepos.ailauncher.chat.wake.effect.c cVar = ChatView.this.spectrumController;
                if (cVar != null) {
                    cVar.l(false);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/view/ChatView$o", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class o extends AnimatorListenerAdapter {
        final /* synthetic */ View $bottomSheet;
        final /* synthetic */ int $newHeight;
        final /* synthetic */ int $oldHeight;

        public o(View view, int i10, int i11) {
            this.$bottomSheet = view;
            this.$oldHeight = i10;
            this.$newHeight = i11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            View view = this.$bottomSheet;
            int i10 = this.$newHeight;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = i10;
            bVar.f12607H = 1.0f;
            view.setLayoutParams(bVar);
            C4148a.d("ChatView", "update dialog height: old height: " + this.$oldHeight + ", new height: " + this.$newHeight + " (animation completed)", false, 4, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void A0(ChatView chatView) {
        C1060i.d(chatView.scope, null, null, new ChatView$3$1(chatView, null), 3, null);
    }

    public static final Y8.t A1(ChatView chatView, String agentId, String deviceId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        chatView.b3(agentId, deviceId);
        return Y8.t.f7040a;
    }

    public static final void A3(long j10, ChatView chatView, String str) {
        if (j10 != chatView.sessionSwitchRecoverGeneration) {
            return;
        }
        AgentChatLayout chatLayout = chatView.getChatLayout();
        LauncherChatLayout launcherChatLayout = chatLayout instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout : null;
        if (launcherChatLayout != null && launcherChatLayout.w8() && chatView.A2(str)) {
            chatView.d3(str, "fast_probe");
        }
    }

    public static final Y8.t B1(Context context, ChatView chatView, DisplayMessage m10) {
        kotlin.jvm.internal.p.i(m10, "m");
        if (m10.getErrorCode() == 10106) {
            ChatMainActivity chatMainActivity = context instanceof ChatMainActivity ? (ChatMainActivity) context : null;
            if (chatMainActivity != null) {
                chatMainActivity.e0();
            }
        }
        if (m10.getRole() == AgentRole.USER) {
            C0919o.k("App·真实用户消息就绪");
        }
        if (m10.getRole() == AgentRole.ASSISTANT) {
            chatView.Y3();
            chatView.l3(m10);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t C1(DisplayMessage m10) {
        kotlin.jvm.internal.p.i(m10, "m");
        if (m10.getRole() == AgentRole.USER) {
            C0919o.k("App·用户消息真实上屏");
            E5.b.INSTANCE.a(m10.getTraceId(), "text_display_input.start", "用户输入回显开始(全屏)");
        }
        return Y8.t.f7040a;
    }

    public static final void C3(ChatView chatView, TaskNavigationRequest taskNavigationRequest, ChatRecycleView chatRecycleView) {
        if (chatView.G2(taskNavigationRequest)) {
            if (!chatRecycleView.isLaidOut() || chatRecycleView.isLayoutRequested()) {
                chatRecycleView.addOnLayoutChangeListener(new m(chatRecycleView, chatView, taskNavigationRequest));
            } else {
                chatRecycleView.post(chatView.new l(taskNavigationRequest, chatRecycleView));
            }
        }
    }

    public static final Y8.t D1(boolean z10, DisplayMessage firstMessage) {
        kotlin.jvm.internal.p.i(firstMessage, "firstMessage");
        E5.b.INSTANCE.a(firstMessage.getTraceId(), "text_display_response.first", "agent首回复回显开始(全屏)");
        return Y8.t.f7040a;
    }

    public static final Y8.t E1(Context context, ChatView chatView, View it) {
        kotlin.jvm.internal.p.i(it, "it");
        com.stepos.agentframework.util.A.INSTANCE.a(context, chatView.getInputView());
        return Y8.t.f7040a;
    }

    private final boolean E2(float rawX, float rawY, View target) {
        int[] iArr = new int[2];
        target.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        return rawX >= ((float) i10) && rawX <= ((float) (i10 + target.getWidth())) && rawY >= ((float) i11) && rawY <= ((float) (i11 + target.getHeight()));
    }

    public static /* synthetic */ void G1(ChatView chatView, SessionHandler sessionHandler, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sessionHandler = chatView.sessionHandler;
        }
        chatView.F1(sessionHandler);
    }

    public static final void G3(ChatView chatView, View view) {
        chatView.S1(view);
    }

    public static final ImageView H2(ChatView chatView) throws Throwable {
        ImageView imageView = (ImageView) chatView.findViewById(R$id.iv_drag_bar);
        if (imageView != null) {
            return imageView;
        }
        throw new Throwable("页面未完成初始化");
    }

    public static final Y8.t I3(ChatView chatView, int i10, boolean z10) {
        t0.e eVarF;
        if (chatView.isInMain) {
            androidx.core.view.a0 a0VarB = androidx.core.view.N.B(chatView);
            chatView.f1(C5685n.f(i10 - ((a0VarB == null || (eVarF = a0VarB.f(a0.o.g())) == null) ? 0 : eVarF.f41980d), 0));
            if (chatView.pinMessageListToBottomForIme) {
                chatView.D3();
            }
        }
        return Y8.t.f7040a;
    }

    public static final com.stepos.ailauncher.chat.util.g J2(final ChatView chatView) {
        return new com.stepos.ailauncher.chat.util.g("ChatView", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.b5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.K2(this.f26075a);
            }
        }, null, 4, null);
    }

    public static final Y8.t J3(ChatView chatView, boolean z10, int i10) {
        if (z10) {
            chatView.imeHideAnimating = false;
            chatView.r1();
        } else {
            chatView.imeHideAnimating = true;
            chatView.r1();
            C4148a.d("ChatView", "ime hide animation start, skip snap-to-zero", false, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static final View K2(ChatView chatView) {
        return chatView;
    }

    public static final Y8.t K3(ChatView chatView, boolean z10, int i10) {
        if (!z10) {
            chatView.imeHideAnimating = false;
            chatView.r1();
            chatView.f1(0);
            AgentChatLayout chatLayout = chatView.getChatLayout();
            if (chatLayout != null) {
                Integer num = chatView.originChatPaddingBottom;
                int iIntValue = num != null ? num.intValue() : chatLayout.getPaddingBottom();
                if (chatLayout.getPaddingBottom() != iIntValue) {
                    chatLayout.setPadding(chatLayout.getPaddingLeft(), chatLayout.getPaddingTop(), chatLayout.getPaddingRight(), iIntValue);
                }
            }
            if (chatView.pinMessageListToBottomForIme) {
                chatView.D3();
                chatView.pinMessageListToBottomForIme = false;
            }
        } else if (chatView.pinMessageListToBottomForIme) {
            chatView.D3();
        }
        chatView.O3();
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void L1(ChatView chatView, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        chatView.K1(str, str2, z10);
    }

    public static final androidx.core.view.a0 L3(ChatView chatView, View view, androidx.core.view.a0 insets) {
        AgentChatLayout chatLayout;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.b());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        t0.e eVarF2 = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF2, "getInsets(...)");
        int i10 = eVarF.f41980d;
        int i11 = eVarF2.f41980d;
        int i12 = i10 > i11 ? i10 - i11 : 0;
        chatView.keyboardVisible = i12 > 0;
        if (chatView.isInMain || i12 <= 0) {
            if (i12 == 0) {
                Integer num = chatView.lastBottomMargin;
                if ((num != null ? num.intValue() : 0) > 0) {
                    chatView.w3();
                }
            }
            Integer num2 = chatView.lastKeyboardHeightForInsets;
            if (num2 == null || i12 != num2.intValue()) {
                Integer num3 = chatView.lastKeyboardHeightForInsets;
                int iIntValue = num3 != null ? num3.intValue() : 0;
                chatView.lastKeyboardHeightForInsets = Integer.valueOf(i12);
                chatView.X1(i12 > 0);
                if (i12 > 0 && iIntValue == 0) {
                    boolean zD2 = chatView.D2();
                    chatView.pinMessageListToBottomForIme = zD2;
                    if (!zD2 && (chatLayout = chatView.getChatLayout()) != null && chatLayout.getPaddingBottom() != 0) {
                        chatView.originChatPaddingBottom = Integer.valueOf(chatLayout.getPaddingBottom());
                        chatLayout.setPadding(chatLayout.getPaddingLeft(), chatLayout.getPaddingTop(), chatLayout.getPaddingRight(), 0);
                    }
                    View bottomFadeMask = chatView.getBottomFadeMask();
                    if (bottomFadeMask != null) {
                        bottomFadeMask.setVisibility(8);
                    }
                    chatView.aiDeclareVisibilityBeforeKeyboard = chatView.getAiDeclare().getVisibility();
                    if (chatView.getAiDeclare().getVisibility() != 8) {
                        chatView.getAiDeclare().setVisibility(8);
                    }
                } else if (i12 == 0 && iIntValue > 0) {
                    chatView.getAiDeclare().getVisibility();
                }
                C4148a.d("ChatView", "setupWindowInsetsForFullScreen: keyboardHeight=" + i12 + ", imeInsets.bottom=" + eVarF.f41980d + ", systemBarsInsets.bottom=" + eVarF2.f41980d, false, 4, null);
            }
        }
        return insets;
    }

    public static final boolean N1(DisplayMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getRole() == AgentRole.ASSISTANT;
    }

    public static final boolean O1(DisplayMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getMessageId().length() > 0;
    }

    public static final void R2(ChatView chatView) {
        chatView.O3();
    }

    public static final TtsMediaFocusController R3(Context context, final ChatView chatView) {
        TtsMediaFocusController ttsMediaFocusController = new TtsMediaFocusController(context);
        ttsMediaFocusController.g0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.c5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.S3(this.f26094a);
            }
        });
        return ttsMediaFocusController;
    }

    public static final void S2(ChatView chatView) {
        chatView.O3();
    }

    public static final Y8.t S3(ChatView chatView) {
        chatView.N3();
        if (chatView.getInputView().a8()) {
            C4148a.k("ChatView", "AudioFocus lost -> stopTTS (recording active, skip dismiss)", false, 4, null);
        } else {
            C4148a.k("ChatView", "AudioFocus lost -> stopTTS + dismiss wake dialog", false, 4, null);
            InterfaceC5063a<Y8.t> interfaceC5063a = chatView.onAudioFocusLost;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void U2(ChatView chatView, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        chatView.T2(z10, z11);
    }

    public static final void W2(ChatView chatView, Set it) {
        kotlin.jvm.internal.p.i(it, "it");
        chatView.j3();
    }

    public static final void X3(View view, ValueAnimator animation) {
        kotlin.jvm.internal.p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = iIntValue;
        bVar.f12607H = 1.0f;
        view.setLayoutParams(bVar);
        C4148a.d("ChatView", "::animation value: " + iIntValue, false, 4, null);
    }

    public static final void Y0(ChatView chatView) {
        chatView.getLayoutParams();
        chatView.H3();
    }

    public static final void Y1(View view) {
        view.setVisibility(4);
    }

    public static final TextView Z0(ChatView chatView) throws Throwable {
        TextView textView = (TextView) chatView.findViewById(R$id.ai_declare);
        if (textView != null) {
            return textView;
        }
        throw new Throwable("页面未完成初始化");
    }

    public static final void Z2(View view) {
        view.animate().alpha(1.0f).setDuration(220L).start();
    }

    public static final void Z3(ChatView chatView) {
        int height = chatView.getAiDeclare().getHeight();
        if (height <= 0) {
            chatView.getInputView().setExtBottomHeight(0);
            return;
        }
        MainInputView inputView = chatView.getInputView();
        O6.d dVar = O6.d.INSTANCE;
        Context context = chatView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        inputView.setExtBottomHeight(height + dVar.a(context, 11.0f));
    }

    public static final View a1(ChatView chatView) {
        return chatView.findViewById(R$id.chat_ai_key_waiting_bar);
    }

    public static final View b1(ChatView chatView) {
        return chatView.findViewById(R$id.chat_ai_key_waiting_stop);
    }

    public static final void b2(ChatView chatView) {
        AgentChatLayout chatLayout = chatView.getChatLayout();
        LauncherChatLayout launcherChatLayout = chatLayout instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout : null;
        if (launcherChatLayout != null) {
            launcherChatLayout.setIgnoreEmptySetMessages(false);
        }
    }

    public static final Y8.t c3(String str, ChatMainActivity chatMainActivity, String str2, String str3, ChatView chatView, Result result) {
        Object value = result.getValue();
        if (Result.h(value)) {
            SidebarDataSource.INSTANCE.e(str2, str3, ((Boolean) value).booleanValue());
        }
        Object value2 = result.getValue();
        Boolean bool = Boolean.FALSE;
        if (Result.g(value2)) {
            value2 = bool;
        }
        boolean zBooleanValue = ((Boolean) value2).booleanValue();
        if (str != null && !La.H.x0(str) && chatMainActivity != null) {
            chatMainActivity.M(str2, str3, str, zBooleanValue);
        }
        if (zBooleanValue) {
            AgentChatLayout chatLayout = chatView.getChatLayout();
            if (chatLayout != null) {
                chatLayout.O3();
            }
        } else {
            Toast.makeText(chatView.getContext(), R$string.chat_agent_offline_toast, 0).show();
        }
        return Y8.t.f7040a;
    }

    public static final View d2(ChatView chatView) {
        View viewFindViewById = chatView.findViewById(R$id.iVInput);
        if (viewFindViewById != null) {
            return viewFindViewById.findViewById(R$id.llInputMain);
        }
        return null;
    }

    public static final View d4(ChatView chatView) throws Throwable {
        View viewFindViewById = chatView.findViewById(R$id.v_chat_bg);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new Throwable("页面未完成初始化");
    }

    public static final void e1(ChatView chatView) {
        chatView.pendingAiKeyFinalizingUiRunnable = null;
        chatView.T1();
    }

    public static final View e2(ChatView chatView) {
        return chatView.findViewById(R$id.btn_apps_pill);
    }

    public static final View e4(ChatView chatView) {
        return chatView.findViewById(R$id.vChatBottomBg);
    }

    public static /* synthetic */ void f3(ChatView chatView, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        chatView.e3(z10, z11);
    }

    public static final void g3() {
        BaseInputView baseInputViewR0 = InputViewManager.INSTANCE.r0();
        HomeInputView homeInputView = baseInputViewR0 instanceof HomeInputView ? (HomeInputView) baseInputViewR0 : null;
        if (homeInputView != null) {
            homeInputView.td();
        }
    }

    private final View getActivityRootView() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity.getWindow().getDecorView();
        }
        try {
            Activity activityX0 = InputViewManager.INSTANCE.x0();
            if (activityX0 != null) {
                this.activity = activityX0;
                return activityX0.getWindow().getDecorView();
            }
        } catch (Exception e10) {
            C4148a.t("ChatView", "Failed to get activity from InputViewManager", e10, false, 8, null);
        }
        try {
            for (Context context = this.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    this.activity = (Activity) context;
                    return ((Activity) context).getWindow().getDecorView();
                }
            }
            return null;
        } catch (Exception e11) {
            C4148a.t("ChatView", "Failed to get activity root view", e11, false, 8, null);
            return null;
        }
    }

    private final TextView getAiDeclare() {
        return (TextView) this.aiDeclare.getValue();
    }

    private final View getAiKeyWaitingBar() {
        Object value = this.aiKeyWaitingBar.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (View) value;
    }

    private final View getAiKeyWaitingStop() {
        Object value = this.aiKeyWaitingStop.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (View) value;
    }

    private final View getBgSpeech() {
        return (View) this.bgSpeech.getValue();
    }

    private final View getBottomFadeMask() {
        return (View) this.bottomFadeMask.getValue();
    }

    private final View getBtnAppsHotArea() {
        return (View) this.btnAppsHotArea.getValue();
    }

    private final View getBtnAppsPill() {
        return (View) this.btnAppsPill.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AgentChatLayout getChatLayout() {
        return (AgentChatLayout) this.chatLayout.getValue();
    }

    private final InterfaceC5063a<Y8.t> getChatLayoutExitFloatModeListener() {
        return (InterfaceC5063a) this.chatLayoutExitFloatModeListener.getValue();
    }

    private final View.OnLayoutChangeListener getInputBottomOptionChangeListener() {
        return (View.OnLayoutChangeListener) this.inputBottomOptionChangeListener.getValue();
    }

    private final ImageView getIvDragBar() {
        return (ImageView) this.ivDragBar.getValue();
    }

    private final com.stepos.ailauncher.chat.util.g getKeepScreenOnController() {
        return (com.stepos.ailauncher.chat.util.g) this.keepScreenOnController.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TtsMediaFocusController getTtsMediaFocusController() {
        return (TtsMediaFocusController) this.ttsMediaFocusController.getValue();
    }

    private final View getVChatBg() {
        return (View) this.vChatBg.getValue();
    }

    private final View getVChatBottomBg() {
        return (View) this.vChatBottomBg.getValue();
    }

    public static final View i1(ChatView chatView) {
        return chatView.findViewById(R$id.v_speech_bg);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t i2(com.stepos.ailauncher.chat.view.ChatView r5, w4.e r6, java.util.List r7) {
        /*
            java.lang.String r0 = "msgList"
            kotlin.jvm.internal.p.i(r7, r0)
            long r0 = r5.sessionSwitchRecoverGeneration
            r2 = 1
            long r0 = r0 + r2
            r5.sessionSwitchRecoverGeneration = r0
            r0 = 0
            r5.activeSessionSwitchId = r0
            com.stepos.ailauncher.chat.view.MainInputView r1 = r5.getInputView()
            if (r6 == 0) goto L1a
            java.lang.String r2 = r6.getSessionId()
            goto L1b
        L1a:
            r2 = r0
        L1b:
            r1.m6(r2)
            boolean r1 = r5.isResumed
            if (r1 == 0) goto L33
            com.stepos.ailauncher.common.utils.v r1 = com.stepos.ailauncher.common.utils.v.INSTANCE
            java.lang.String r2 = r5.getCurrentSessionId()
            java.util.List r3 = r5.P1()
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.String r4 = "AgentSpace"
            r1.s(r2, r3, r4)
        L33:
            p9.l<? super java.lang.Boolean, Y8.t> r1 = r5.onMessageListChanged
            if (r1 == 0) goto L57
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L4f
            com.stepos.agentframework.chatui.ChatMessageAdapter r2 = r5.chatMessageAdapter
            if (r2 == 0) goto L4f
            java.util.List r2 = r2.G()
            if (r2 == 0) goto L4f
            boolean r2 = r2.isEmpty()
            r3 = 1
            if (r2 != r3) goto L4f
            goto L50
        L4f:
            r3 = 0
        L50:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            r1.invoke(r2)
        L57:
            r5.U3(r7)
            r5.c1()
            if (r6 == 0) goto L63
            java.lang.String r0 = r6.getSessionId()
        L63:
            r5.r3(r0)
            com.stepos.ailauncher.chat.view.sla.SlaChatController r5 = r5.slaController
            if (r5 == 0) goto L6d
            r5.F0()
        L6d:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatView.i2(com.stepos.ailauncher.chat.view.ChatView, w4.e, java.util.List):Y8.t");
    }

    public static final boolean j2(ChatView chatView, String sid, String inqId, List inquiries, String askUserMessageId) {
        kotlin.jvm.internal.p.i(sid, "sid");
        kotlin.jvm.internal.p.i(inqId, "inqId");
        kotlin.jvm.internal.p.i(inquiries, "inquiries");
        kotlin.jvm.internal.p.i(askUserMessageId, "askUserMessageId");
        return chatView.getInputView().Zb(sid, inqId, inquiries, "chatview", new ChatView$initEvents$1$2$1(chatView, sid, inqId, askUserMessageId, null));
    }

    public static final boolean k2(ChatView chatView, final LauncherChatLayout launcherChatLayout, final String sid, final String requestId, final String messageId, String title, String str) {
        kotlin.jvm.internal.p.i(sid, "sid");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(title, "title");
        return chatView.getInputView().Gb(sid, requestId, title, str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.o5
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.l2(launcherChatLayout, sid, requestId, messageId, (String) obj);
            }
        });
    }

    public static final boolean l1(ChatView chatView) {
        boolean zA8 = chatView.getInputView().a8();
        boolean z10 = chatView.isResumed;
        boolean z11 = z10 && !zA8;
        C4148a.d("ChatView", "canplayTTS:" + z11 + " resumed=" + z10 + " recording=" + zA8, false, 4, null);
        return z11;
    }

    public static final Y8.t l2(LauncherChatLayout launcherChatLayout, String str, String str2, String str3, String action) {
        kotlin.jvm.internal.p.i(action, "action");
        launcherChatLayout.q7(str, str2, str3, action);
        return Y8.t.f7040a;
    }

    public static final Y8.t m1(ChatView chatView) {
        BaseInputView.k6(chatView.getInputView(), false, false, 3, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t m2(ChatView chatView, String sid) {
        kotlin.jvm.internal.p.i(sid, "sid");
        if (chatView.isResumed) {
            com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
            String currentSessionId = chatView.getCurrentSessionId();
            if (currentSessionId == null) {
                currentSessionId = sid;
            }
            vVar.s(currentSessionId, Z8.F.T0(chatView.P1(), sid), com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t n1(ChatView chatView) {
        chatView.N3();
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t n2(com.stepos.ailauncher.chat.view.ChatView r4, java.util.List r5) {
        /*
            java.lang.String r0 = "msgList"
            kotlin.jvm.internal.p.i(r5, r0)
            boolean r0 = r5.isEmpty()
            r1 = 0
            if (r0 == 0) goto L1e
            com.stepos.agentframework.chatui.ChatMessageAdapter r0 = r4.chatMessageAdapter
            if (r0 == 0) goto L1e
            java.util.List r0 = r0.G()
            if (r0 == 0) goto L1e
            boolean r0 = r0.isEmpty()
            r2 = 1
            if (r0 != r2) goto L1e
            goto L1f
        L1e:
            r2 = r1
        L1f:
            p9.l<? super java.lang.Boolean, Y8.t> r0 = r4.onMessageListChanged
            if (r0 == 0) goto L2a
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r0.invoke(r3)
        L2a:
            r4.U3(r5)
            boolean r5 = r4.handoffReloadPending
            if (r5 == 0) goto L39
            if (r2 != 0) goto L39
            java.lang.String r5 = "setMessages"
            r4.a2(r1, r5)
        L39:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatView.n2(com.stepos.ailauncher.chat.view.ChatView, java.util.List):Y8.t");
    }

    public static final void n3(long j10, ChatView chatView, int i10) {
        if (j10 == chatView.handoffReloadGeneration && chatView.handoffReloadPending) {
            chatView.m3(j10, i10 + 1);
        }
    }

    public static final View o1(ChatView chatView) {
        return chatView.findViewById(R$id.bottom_fade_mask);
    }

    public static final Y8.t o2(ChatView chatView, String str) {
        chatView.d3(str, "guard_timeout");
        return Y8.t.f7040a;
    }

    public static final void o3(long j10, ChatView chatView, int i10) {
        List<com.stepos.agentframework.chatui.S1> listG;
        if (j10 == chatView.handoffReloadGeneration && chatView.handoffReloadPending) {
            ChatMessageAdapter chatMessageAdapter = chatView.chatMessageAdapter;
            if (chatMessageAdapter != null && (listG = chatMessageAdapter.G()) != null && (!listG.isEmpty())) {
                chatView.a2(false, "adapter_ready_delayed");
                return;
            }
            int i11 = i10 + 1;
            if (i11 < 8) {
                chatView.m3(j10, i11);
                return;
            }
            ChatMessageAdapter chatMessageAdapter2 = chatView.chatMessageAdapter;
            List<com.stepos.agentframework.chatui.S1> listG2 = chatMessageAdapter2 != null ? chatMessageAdapter2.G() : null;
            chatView.a2(listG2 == null || listG2.isEmpty(), "retry_exhausted");
        }
    }

    public static final View p1(ChatView chatView) {
        return chatView.findViewById(R$id.btn_apps);
    }

    public static final View.OnLayoutChangeListener p2(final ChatView chatView) {
        return new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.view.U4
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                ChatView.q2(this.f25987a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
    }

    public static final View q1(ChatView chatView) {
        return chatView.findViewById(R$id.btn_apps_pill);
    }

    public static final void q2(ChatView chatView, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        InterfaceC5940b inputLayout;
        View viewA;
        AgentChatLayout chatLayout = chatView.getChatLayout();
        if (chatLayout == null || (inputLayout = chatLayout.getInputLayout()) == null || (viewA = inputLayout.a(com.stepos.agentframework.R$id.ll_bottom_options)) == null) {
            return;
        }
        if (viewA.getVisibility() != 0) {
            viewA = null;
        }
        if (viewA != null) {
            View view2 = chatView.inputUIModel == chatView.UI_MODE_LITE ? viewA : null;
            if (view2 != null) {
                chatView.b4();
                chatView.V3(chatView, chatView.getHeight() + view2.getHeight());
            }
        }
    }

    public static final MainInputView r2(final ChatView chatView, final Context context) {
        final MainInputView mainInputView = (MainInputView) chatView.findViewById(R$id.iVInput);
        mainInputView.setOnSendInitiated(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.y4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.s2(context, chatView);
            }
        });
        mainInputView.setOnMessageSentCallback(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.z4
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.t2(this.f26433a, (String) obj);
            }
        });
        mainInputView.setOnAiKeyFinalizingChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.A4
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.u2(this.f25709a, ((Boolean) obj).booleanValue());
            }
        });
        mainInputView.setOnStopClicked(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.C4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ChatView.v2(this.f25732a, mainInputView));
            }
        });
        mainInputView.setOnSpeechPopupShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.D4
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.w2(this.f25749a, ((Boolean) obj).booleanValue());
            }
        });
        mainInputView.setOnVoiceLongPressVisualChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.E4
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.x2(this.f25766a, ((Boolean) obj).booleanValue());
            }
        });
        mainInputView.setOnRecordingTouchBlockNeeded(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.F4
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.y2(this.f25773a, ((Boolean) obj).booleanValue());
            }
        });
        mainInputView.setOnWaked(new ChatView$inputView$2$1$8(chatView, null));
        mainInputView.setWait(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.G4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(ChatView.z2(this.f25786a));
            }
        });
        return mainInputView;
    }

    public static final Y8.t s2(Context context, ChatView chatView) {
        com.stepos.ailauncher.chat.manager.U0 u02 = com.stepos.ailauncher.chat.manager.U0.INSTANCE;
        u02.d(context);
        C4148a.d("ChatView", "AIEngine TTSConfig(pre-send): voice=" + u02.j() + ", volume=" + u02.i(context), false, 4, null);
        G1(chatView, null, 1, null);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupKeyboardListener$lambda$0(final ChatView chatView) {
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = chatView.keyboardLayoutListener;
        if (onGlobalLayoutListener != null) {
            try {
                Activity activity = chatView.activity;
                if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                    Y8.t tVar = Y8.t.f7040a;
                }
            } catch (Exception unused) {
                Y8.t tVar2 = Y8.t.f7040a;
            }
        }
        final View activityRootView = chatView.getActivityRootView();
        if (activityRootView == null) {
            C4148a.u("ChatView", "setupKeyboardListener: 无法获取 Activity root view，键盘检测可能无法工作", false, 4, null);
            return;
        }
        chatView.keyboardLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.chat.view.M4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ChatView.G3(this.f25875a, activityRootView);
            }
        };
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(chatView.keyboardLayoutListener);
        C4148a.d("ChatView", "setupKeyboardListener: 键盘监听器已设置，rootView=" + activityRootView.getClass().getSimpleName(), false, 4, null);
    }

    public static final Y8.t t2(ChatView chatView, String str) {
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = chatView.onMsgSent;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(str);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t u2(ChatView chatView, boolean z10) {
        chatView.d1(z10);
        return Y8.t.f7040a;
    }

    public static final boolean v2(ChatView chatView, MainInputView mainInputView) {
        chatView.N3();
        ChatTracker.INSTANCE.a(chatView.getCurrentSessionId(), chatView.getCurrentSessionId(), chatView.M1(), ChatTracker.INTERRUPT_GENERATING_RESPONSE, ChatTracker.AFTER_INTERRUPT_CLEAR_INPUT);
        String currentSessionId = chatView.getCurrentSessionId();
        SessionHandler sessionHandler = mainInputView.getSessionHandler();
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        String sessionId = agentConversationR1 != null ? agentConversationR1.getSessionId() : null;
        if (sessionId == null) {
            sessionId = "";
        }
        String tempSessionId = agentConversationR1 != null ? agentConversationR1.getTempSessionId() : null;
        String str = tempSessionId != null ? tempSessionId : "";
        List<UiTask> list = chatView.activeTaskSnapshot;
        ArrayList<UiTask> arrayList = new ArrayList();
        for (Object obj : list) {
            UiTask uiTask = (UiTask) obj;
            if (kotlin.jvm.internal.p.d(uiTask.getRequestedSessionKey(), sessionId) || kotlin.jvm.internal.p.d(uiTask.getRequestedSessionKey(), str)) {
                arrayList.add(obj);
            }
        }
        for (UiTask uiTask2 : arrayList) {
            M5.c cVar = M5.c.INSTANCE;
            cVar.u(uiTask2.getTaskId(), currentSessionId, cVar.v(uiTask2.getStatus()), "user_cancel");
        }
        kotlin.jvm.internal.p.f(mainInputView);
        BaseInputView.k6(mainInputView, false, false, 3, null);
        boolean zT1 = chatView.t1();
        ChatStopActions chatStopActions = ChatStopActions.INSTANCE;
        return chatStopActions.m(zT1, chatStopActions.j(mainInputView.getSessionHandler()));
    }

    public static final Y8.t w2(ChatView chatView, boolean z10) {
        if (!z10 || chatView.getInputView().b8()) {
            View bgSpeech = chatView.getBgSpeech();
            if (bgSpeech != null) {
                bgSpeech.setVisibility(4);
            }
        } else {
            View bgSpeech2 = chatView.getBgSpeech();
            if (bgSpeech2 != null) {
                bgSpeech2.setVisibility(0);
            }
        }
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = chatView.onRecordingTouchBlockHost;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        C4148a.d("ChatViewSpeech", "onSpeechPopupShown: " + z10, false, 4, null);
        return Y8.t.f7040a;
    }

    public static final InterfaceC5063a x1(final ChatView chatView, final Context context) {
        return new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.d5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.y1(this.f26103a, context);
            }
        };
    }

    public static final Y8.t x2(ChatView chatView, boolean z10) {
        if (!z10 || chatView.getInputView().b8()) {
            View bgSpeech = chatView.getBgSpeech();
            if (bgSpeech != null) {
                bgSpeech.setVisibility(4);
            }
        } else {
            View bgSpeech2 = chatView.getBgSpeech();
            if (bgSpeech2 != null) {
                bgSpeech2.setVisibility(0);
            }
        }
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = chatView.onRecordingTouchBlockHost;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        return Y8.t.f7040a;
    }

    public static final void x3(final int i10, final ChatView chatView) {
        if (i10 != chatView.hideOffsetResetGeneration) {
            return;
        }
        chatView.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.view.x5
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.y3(i10, chatView);
            }
        });
    }

    public static final void y0(ChatView chatView, View view) {
        chatView.getInputView().t5();
    }

    public static final Y8.t y1(ChatView chatView, Context context) throws Resources.NotFoundException {
        View viewFindViewById = chatView.findViewById(R$id.v_chat_bg);
        Integer numValueOf = viewFindViewById != null ? Integer.valueOf(viewFindViewById.getHeight()) : null;
        AgentChatLayout chatLayout = chatView.getChatLayout();
        C4148a.d("CallOutFragment", "chat layout exit-- bg heigth: " + numValueOf + "-- chat layout height: " + (chatLayout != null ? Integer.valueOf(chatLayout.getHeight()) : null), false, 4, null);
        if (context != null) {
            View vChatBg = chatView.getVChatBg();
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R$anim.slide_up);
            animationLoadAnimation.setAnimationListener(new h());
            vChatBg.startAnimation(animationLoadAnimation);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t y2(ChatView chatView, boolean z10) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = chatView.onRecordingTouchBlockHost;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
        return Y8.t.f7040a;
    }

    public static final void y3(int i10, ChatView chatView) {
        if (i10 != chatView.hideOffsetResetGeneration || chatView.imeHideAnimating || chatView.keyboardVisible) {
            return;
        }
        Integer num = chatView.lastBottomMargin;
        if ((num != null ? num.intValue() : 0) <= 0) {
            return;
        }
        C4148a.d("ChatView", "hide offset reset applied (no ime animation)", false, 4, null);
        chatView.f1(0);
    }

    public static final Y8.t z0(ChatView chatView, boolean z10) {
        if (z10) {
            InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = chatView.onMessageListChanged;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.TRUE);
            }
        } else {
            InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l2 = chatView.onMessageListChanged;
            if (interfaceC5074l2 != null) {
                interfaceC5074l2.invoke(Boolean.FALSE);
            }
        }
        return Y8.t.f7040a;
    }

    public static final AgentChatLayout z1(final ChatView chatView, final Context context) {
        AgentChatLayout agentChatLayout = (AgentChatLayout) chatView.findViewById(R$id.aclChat);
        if (agentChatLayout == null) {
            return null;
        }
        com.stepos.ailauncher.chat.tts.a.INSTANCE.n(agentChatLayout);
        ExtKt.m(agentChatLayout.getEmptyShow());
        agentChatLayout.setAgentOfflineReconnectListener(new p9.p() { // from class: com.stepos.ailauncher.chat.view.V4
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatView.A1(this.f26005a, (String) obj, (String) obj2);
            }
        });
        agentChatLayout.setOnReceiveMessage(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.W4
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.B1(context, chatView, (DisplayMessage) obj);
            }
        });
        agentChatLayout.setOnUserBubbleShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.Y4
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.C1((DisplayMessage) obj);
            }
        });
        agentChatLayout.setOnFirstAssistantResponse(new p9.p() { // from class: com.stepos.ailauncher.chat.view.Z4
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatView.D1(((Boolean) obj).booleanValue(), (DisplayMessage) obj2);
            }
        });
        C2154c.b(agentChatLayout, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.a5
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.E1(context, chatView, (View) obj);
            }
        });
        agentChatLayout.setTtsPlayerListener(chatView.new g());
        return agentChatLayout;
    }

    public static final boolean z2(ChatView chatView) {
        C4148a.d("ChatViewSpeech", "isWait", false, 4, null);
        DrawerLayout drawerLayoutZ1 = chatView.Z1();
        boolean zB2 = chatView.B2(drawerLayoutZ1);
        if (zB2 && drawerLayoutZ1 != null) {
            drawerLayoutZ1.d(8388611);
        }
        return zB2;
    }

    public final boolean A2(String sessionId) {
        AgentSession.AgentConversation agentConversationR1;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(sessionId, agentConversationR1.getSessionId()) || kotlin.jvm.internal.p.d(sessionId, agentConversationR1.getTempSessionId());
    }

    public final boolean B2(DrawerLayout drawer) {
        return (this.isInMain || drawer == null || !drawer.C(8388611)) ? false : true;
    }

    public final void B3(final TaskNavigationRequest request) {
        final ChatRecycleView messageList;
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout == null || (messageList = chatLayout.getMessageList()) == null) {
            return;
        }
        messageList.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.n5
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.C3(this.f26264a, request, messageList);
            }
        });
    }

    /* renamed from: C2, reason: from getter */
    public final boolean getHandoffReloadPending() {
        return this.handoffReloadPending;
    }

    public final boolean D2() {
        if (getMessageList() == null) {
            return false;
        }
        return !r1.canScrollVertically(1);
    }

    public final void D3() {
        ChatRecycleView messageList = getMessageList();
        if (messageList == null) {
            return;
        }
        RecyclerView.Adapter adapter = messageList.getAdapter();
        if ((adapter != null ? adapter.getItemCount() : 0) > 0) {
            messageList.scrollToPosition(0);
        }
    }

    public final void E3(String content) {
        kotlin.jvm.internal.p.i(content, "content");
        getInputView().Va(content);
    }

    public final void F1(SessionHandler handler) {
        if (this.handoffReloadPending) {
            return;
        }
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout == null) {
            chatLayout = null;
        }
        if (chatLayout == null || handler == null) {
            return;
        }
        handler.V0(chatLayout);
        handler.b3(chatLayout);
        handler.x1();
    }

    public final boolean F2() {
        return (this.sessionBindingReleased || !getInputView().X7() || getInputView().getSessionHandler() == null) ? false : true;
    }

    public final void F3() {
        if ((getLayoutParams() instanceof WindowManager.LayoutParams) && this.activity == null) {
            C4148a.d("ChatView", "setupKeyboardListener: 悬浮窗模式，等待 Activity 设置", false, 4, null);
            return;
        }
        Object systemService = getContext().getSystemService("window");
        this.windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.X4
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.setupKeyboardListener$lambda$0(this.f26026a);
            }
        });
    }

    public final boolean G2(TaskNavigationRequest request) {
        return request.getGeneration() == this.taskNavigationGeneration && A2(request.getSessionId());
    }

    public final void H1() {
        this.aiKeyFinalizing = false;
        Runnable runnable = this.pendingAiKeyFinalizingUiRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.pendingAiKeyFinalizingUiRunnable = null;
        getAiKeyWaitingBar().setVisibility(8);
        getInputView().setVisibility(0);
    }

    public final void H3() {
        getInputView().setOnImeInsetsFrame(new p9.p() { // from class: com.stepos.ailauncher.chat.view.p5
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatView.I3(this.f26291a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        });
        getInputView().setOnImeAnimationStart(new p9.p() { // from class: com.stepos.ailauncher.chat.view.q5
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatView.J3(this.f26302a, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
            }
        });
        getInputView().setOnImeAnimationEnd(new p9.p() { // from class: com.stepos.ailauncher.chat.view.r5
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatView.K3(this.f26316a, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
            }
        });
        androidx.core.view.N.u0(this, new androidx.core.view.A() { // from class: com.stepos.ailauncher.chat.view.s5
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return ChatView.L3(this.f26328a, view, a0Var);
            }
        });
        androidx.core.view.N.e0(this);
    }

    public final void I1() {
        getKeepScreenOnController().l("tts");
    }

    public final void I2() {
        getKeepScreenOnController().f("tts", 300000L);
    }

    public final void J1(String sessionId, InterfaceC5074l<? super Boolean, Y8.t> callback) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(callback, "callback");
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || sessionId.length() == 0) {
            callback.invoke(Boolean.FALSE);
        } else if (sessionHandler.E1(sessionId) != null) {
            callback.invoke(Boolean.TRUE);
        } else {
            sessionHandler.n2(new i(callback, sessionId));
        }
    }

    public final void K1(String agentId, String deviceId, boolean showAlreadyNewChatToast) {
        s1();
        this.pendingSessionSwitchId = null;
        this.activeSessionSwitchId = null;
        this.sessionSwitchRecoverGeneration++;
        AgentChatLayout chatLayout = getChatLayout();
        LauncherChatLayout launcherChatLayout = chatLayout instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout : null;
        if (launcherChatLayout != null) {
            launcherChatLayout.d8();
        }
        AgentChatLayout chatLayout2 = getChatLayout();
        LauncherChatLayout launcherChatLayout2 = chatLayout2 instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout2 : null;
        if (launcherChatLayout2 != null) {
            launcherChatLayout2.setIgnoreEmptySetMessages(false);
        }
        if (this.isResumed) {
            com.stepos.ailauncher.common.utils.v.INSTANCE.o(getCurrentSessionId(), P1());
        }
        AgentChatLayout chatLayout3 = getChatLayout();
        if (chatLayout3 != null) {
            chatLayout3.J3(showAlreadyNewChatToast, agentId, deviceId);
        }
        AgentChatLayout chatLayout4 = getChatLayout();
        if (chatLayout4 != null) {
            chatLayout4.setScrollToBottomButtonVisible(false);
        }
        getInputView().M5();
        Y3();
        c1();
    }

    public final void L2() {
        Z3 z32 = Z3.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        z32.c(context);
    }

    public final String M1() {
        List<com.stepos.agentframework.chatui.S1> listG;
        Ka.j jVarD0;
        Ka.j jVarF;
        Ka.j jVarF2;
        Object next;
        String messageId;
        ChatMessage chatMessageM;
        String messageId2;
        SessionHandler sessionHandler = this.sessionHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        if (agentConversationR1 != null && (chatMessageM = agentConversationR1.M()) != null && (messageId2 = chatMessageM.getMessageId()) != null) {
            if (messageId2.length() <= 0) {
                messageId2 = null;
            }
            if (messageId2 != null) {
                return messageId2;
            }
        }
        ChatMessageAdapter chatMessageAdapter = this.chatMessageAdapter;
        if (chatMessageAdapter != null && (listG = chatMessageAdapter.G()) != null && (jVarD0 = Z8.F.d0(listG)) != null) {
            Ka.j jVarF3 = SequencesKt___SequencesKt.F(jVarD0, j.INSTANCE);
            kotlin.jvm.internal.p.g(jVarF3, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            if (jVarF3 != null && (jVarF = SequencesKt___SequencesKt.F(jVarF3, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.e5
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ChatView.N1((DisplayMessage) obj));
                }
            })) != null && (jVarF2 = SequencesKt___SequencesKt.F(jVarF, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.f5
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ChatView.O1((DisplayMessage) obj));
                }
            })) != null) {
                Iterator it = jVarF2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (!((DisplayMessage) next).getStatus().isTerminal()) {
                        break;
                    }
                }
                DisplayMessage displayMessage = (DisplayMessage) next;
                if (displayMessage != null && (messageId = displayMessage.getMessageId()) != null) {
                    return messageId;
                }
                DisplayMessage displayMessage2 = (DisplayMessage) SequencesKt___SequencesKt.K(jVarF2);
                if (displayMessage2 != null) {
                    return displayMessage2.getMessageId();
                }
            }
        }
        return null;
    }

    public final void M2() {
        this.handoffReloadPending = true;
    }

    public final void M3(String hint, String action, InterfaceC5063a<Y8.t> onClick) {
        kotlin.jvm.internal.p.i(hint, "hint");
        kotlin.jvm.internal.p.i(action, "action");
        kotlin.jvm.internal.p.i(onClick, "onClick");
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout != null) {
            chatLayout.setTopNoticeActionListener(onClick);
        }
        AgentChatLayout chatLayout2 = getChatLayout();
        if (chatLayout2 != null) {
            chatLayout2.l7(hint, action);
        }
    }

    public final void N2(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        this.pendingSessionSwitchId = sessionId;
        this.pendingSessionSwitchAt = SystemClock.elapsedRealtime();
    }

    public final void N3() {
        if (WakeDialogImpl.INSTANCE.e()) {
            return;
        }
        com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout != null) {
            chatLayout.p7();
        }
    }

    public final void O2(String sessionId, String taskId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (La.H.x0(sessionId) || La.H.x0(taskId)) {
            return;
        }
        s1();
        if (this.sessionHandler == null) {
            C4148a.u("ChatView", "navigateToTask ignored: SessionHandler is not ready", false, 4, null);
            return;
        }
        TaskNavigationRequest taskNavigationRequest = new TaskNavigationRequest(sessionId, taskId, this.taskNavigationGeneration);
        this.pendingTaskNavigation = taskNavigationRequest;
        if (A2(sessionId)) {
            s3(taskNavigationRequest);
        } else {
            v1(sessionId);
        }
    }

    public final void O3() {
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout == null || this.suppressPillOverlaySync) {
            return;
        }
        View btnAppsHotArea = getBtnAppsHotArea();
        View btnAppsPill = getBtnAppsPill();
        if (btnAppsHotArea == null || btnAppsPill == null || !btnAppsPill.isShown() || btnAppsHotArea.getAlpha() <= 0.0f || btnAppsPill.getHeight() == 0 || chatLayout.getHeight() == 0) {
            chatLayout.setBottomFloatingOverlayHeight(0);
            return;
        }
        int[] iArr = new int[2];
        chatLayout.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        btnAppsPill.getLocationInWindow(iArr2);
        int height = (iArr[1] + chatLayout.getHeight()) - iArr2[1];
        if (height > btnAppsPill.getHeight() * 3) {
            chatLayout.setBottomFloatingOverlayHeight(0);
        } else {
            chatLayout.setBottomFloatingOverlayHeight(height);
        }
    }

    public final List<String> P1() {
        AgentSession.AgentConversation agentConversationR1;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return C1173v.m();
        }
        List listR = C1173v.r(agentConversationR1.B(), agentConversationR1.getSessionId(), agentConversationR1.getTempSessionId());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return Z8.F.g0(arrayList);
    }

    public final DisplayMessage P2() {
        List<com.stepos.agentframework.chatui.S1> listG;
        Ka.j jVarD0;
        ChatMessageAdapter chatMessageAdapter = this.chatMessageAdapter;
        Object obj = null;
        if (chatMessageAdapter == null || (listG = chatMessageAdapter.G()) == null || (jVarD0 = Z8.F.d0(listG)) == null) {
            return null;
        }
        Ka.j jVarF = SequencesKt___SequencesKt.F(jVarD0, k.INSTANCE);
        kotlin.jvm.internal.p.g(jVarF, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        if (jVarF == null) {
            return null;
        }
        Iterator it = jVarF.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((DisplayMessage) next).getMessageId().length() > 0) {
                obj = next;
                break;
            }
        }
        return (DisplayMessage) obj;
    }

    public final void P3(boolean offline) {
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout != null) {
            chatLayout.s7(offline);
        }
    }

    public final String Q1() {
        AgentSession.AgentConversation agentConversationR1;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return null;
        }
        return agentConversationR1.getAgentId();
    }

    public final void Q2() {
        if (!F2() || this.sessionReadyListeners.isEmpty()) {
            return;
        }
        List listM1 = Z8.F.m1(this.sessionReadyListeners);
        this.sessionReadyListeners.clear();
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((InterfaceC5074l) it.next()).invoke(getInputView());
        }
    }

    public final void Q3(int level) {
        if (level < 20) {
            return;
        }
        C4148a.d("ChatView", "trimMemory level=" + level, false, 4, null);
        com.stepos.ailauncher.common.imageloader.g gVar = com.stepos.ailauncher.common.imageloader.g.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        gVar.F(context, level);
        ChatRecycleView messageList = getMessageList();
        if (messageList != null && !this.messageListCacheTrimmed) {
            messageList.setItemViewCacheSize(0);
            this.messageListCacheTrimmed = true;
        }
        if (level >= 40) {
            Z3.INSTANCE.b();
            this.markdownThemeClearedByTrim = true;
        }
    }

    public final String R1() {
        AgentSession.AgentConversation agentConversationR1;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null) {
            return null;
        }
        return agentConversationR1.getDeviceId();
    }

    public final void S1(View rootView) {
        Rect rect = new Rect();
        rootView.getWindowVisibleDisplayFrame(rect);
        int height = rootView.getHeight();
        int i10 = rect.bottom - rect.top;
        int i11 = height - i10;
        int i12 = i11 > ((int) (((double) height) * 0.15d)) ? i11 : 0;
        O6.d dVar = O6.d.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (Math.abs(i12 - this.currentKeyboardHeight) > dVar.a(context, 10.0f) || (i12 == 0 && this.currentKeyboardHeight > 0)) {
            int i13 = this.currentKeyboardHeight;
            this.currentKeyboardHeight = i12;
            a4(i12);
            C4148a.d("ChatView", "Keyboard height changed: " + i13 + " -> " + i12 + ", screenHeight=" + height + ", visibleHeight=" + i10 + ", heightDifference=" + i11, false, 4, null);
        }
    }

    public final void T1() {
        boolean z10 = this.aiKeyFinalizing;
        getAiKeyWaitingBar().setVisibility(z10 ? 0 : 8);
        getInputView().setVisibility(z10 ? 4 : 0);
    }

    public final void T2(boolean foreground, boolean catchUp) {
        SessionHandler sessionHandlerN;
        if (foreground) {
            sessionHandlerN = this.sessionHandler;
            if (sessionHandlerN == null) {
                sessionHandlerN = AgentConfig.INSTANCE.a().n();
                this.sessionHandler = sessionHandlerN;
            }
        } else {
            sessionHandlerN = this.sessionHandler;
        }
        if (foreground) {
            F1(sessionHandlerN);
        } else {
            AgentChatLayout chatLayout = getChatLayout();
            if (chatLayout == null) {
                chatLayout = null;
            }
            if (sessionHandlerN != null && (chatLayout == null || !sessionHandlerN.d2(chatLayout))) {
                C4148a.k("ChatView", "onHostForeground false skipped: session view claimed by another host", false, 4, null);
                return;
            }
        }
        if (sessionHandlerN != null) {
            sessionHandlerN.F2(foreground, catchUp);
        }
    }

    public final void T3() {
        if (this.screenOffReceiverRegistered) {
            this.screenOffReceiverRegistered = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                getContext().getApplicationContext().unregisterReceiver(this.screenOffReceiver);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final SessionHandler U1() {
        V1();
        SessionHandler sessionHandlerN = this.sessionHandler;
        if (sessionHandlerN == null) {
            sessionHandlerN = AgentConfig.INSTANCE.a().n();
            this.sessionHandler = sessionHandlerN;
        }
        k1(sessionHandlerN);
        return sessionHandlerN;
    }

    public final void U3(List<ChatMessage> messages) {
        List<ChatMessage> list = messages;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext() && ((ChatMessage) it.next()).getRole() != AgentRole.ASSISTANT) {
            }
        }
        Y3();
    }

    public final void V1() {
        if (kotlinx.coroutines.d.h(this.scope)) {
            return;
        }
        this.scope = kotlinx.coroutines.d.a(Ua.Y.c().plus(Ua.L0.b(null, 1, null)));
        t3();
    }

    public final void V2(boolean skipReload, boolean syncRemoteHistory) {
        Y8.t tVar;
        Object objB;
        Y8.t tVar2;
        SessionHandler sessionHandler;
        C4148a.d("ChatView", "onResume isResumed=" + this.isResumed + " skipReload=" + skipReload + " syncRemote=" + syncRemoteHistory + " handoff=" + this.handoffReloadPending, false, 4, null);
        boolean z10 = this.isResumed;
        u3();
        if (!z10) {
            L2();
        }
        getInputView().Q8();
        v3();
        if (!this.handoffReloadPending) {
            W1();
            G1(this, null, 1, null);
        }
        h3();
        String strX2 = X2();
        boolean z11 = (strX2 == null || kotlin.jvm.internal.p.d(strX2, getCurrentSessionId()) || P1().contains(strX2)) ? false : true;
        boolean zH = com.stepos.ailauncher.chat.manager.Q0.INSTANCE.h(Z8.F.S0(P1(), C1173v.q(getCurrentSessionId())));
        if ((!z10 || zH) && this.sessionHandler != null) {
            if (this.handoffReloadPending) {
                C4148a.d("ChatView", "onResume skip reload: handoff pending", false, 4, null);
            } else if (!skipReload && !z11) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AgentChatLayout chatLayout = getChatLayout();
                    if (chatLayout != null) {
                        chatLayout.Y5(false);
                        tVar2 = Y8.t.f7040a;
                    } else {
                        tVar2 = null;
                    }
                    objB = Result.b(tVar2);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Result.a(objB);
            } else if (!z10) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    AgentChatLayout chatLayout2 = getChatLayout();
                    if (chatLayout2 != null) {
                        chatLayout2.setMessages(C1173v.m());
                        tVar = Y8.t.f7040a;
                    } else {
                        tVar = null;
                    }
                    Result.b(tVar);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    Result.b(C4849c.a(th2));
                }
            }
            if (syncRemoteHistory && !this.handoffReloadPending && !skipReload && !z11 && (sessionHandler = this.sessionHandler) != null) {
                sessionHandler.e4("screenOn");
            }
        }
        if (this.handoffReloadPending || skipReload || z11) {
            return;
        }
        AgentChatLayout chatLayout3 = getChatLayout();
        LauncherChatLayout launcherChatLayout = chatLayout3 instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout3 : null;
        if (launcherChatLayout != null) {
            launcherChatLayout.X8(getInputView());
        }
    }

    public final void V3(View bottomSheet, int newHeight) {
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        bottomSheet.setLayoutParams(layoutParams);
        C4148a.d("ChatView", "update dialog height: " + newHeight, false, 4, null);
    }

    public final void W1() {
        if (this.sessionBindingReleased) {
            U1();
            C4148a.d("ChatView", "ensureSessionHandlerBound: rebind session handler", false, 4, null);
        }
    }

    public final void W3(final View bottomSheet, int newHeight) {
        int iF;
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar == null || (iF = C5685n.f(((ViewGroup.MarginLayoutParams) bVar).height, this.minDialogHeight)) == newHeight) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iF, newHeight);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.view.j5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ChatView.X3(bottomSheet, valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new o(bottomSheet, iF, newHeight));
        valueAnimatorOfInt.start();
    }

    public final void X0() {
        AgentChatLayout chatLayout = getChatLayout();
        Integer numValueOf = chatLayout != null ? Integer.valueOf(chatLayout.getPaddingBottom()) : null;
        AgentChatLayout chatLayout2 = getChatLayout();
        if (chatLayout2 != null) {
            chatLayout2.setInsetsListener(new d(numValueOf));
        }
        post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.P4
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.Y0(this.f25922a);
            }
        });
    }

    public final void X1(boolean show) {
        final View vChatBottomBg = getVChatBottomBg();
        if (vChatBottomBg == null) {
            return;
        }
        vChatBottomBg.animate().cancel();
        if (!show) {
            vChatBottomBg.animate().alpha(0.0f).setDuration(180L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.w5
                @Override // java.lang.Runnable
                public final void run() {
                    ChatView.Y1(vChatBottomBg);
                }
            }).start();
            return;
        }
        if (vChatBottomBg.getVisibility() != 0) {
            vChatBottomBg.setAlpha(0.0f);
            vChatBottomBg.setVisibility(0);
        }
        vChatBottomBg.animate().alpha(1.0f).setDuration(220L).start();
    }

    public final String X2() {
        String str = this.pendingSessionSwitchId;
        if (str == null) {
            return null;
        }
        if (SystemClock.elapsedRealtime() - this.pendingSessionSwitchAt <= 3000) {
            return str;
        }
        this.pendingSessionSwitchId = null;
        return null;
    }

    public final void Y2(final View view) {
        view.animate().cancel();
        view.setAlpha(1.0f);
        view.animate().alpha(0.45f).setDuration(TASK_ANCHOR_FADE_OUT_MS).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.u5
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.Z2(view);
            }
        }).start();
    }

    public final void Y3() {
        getAiDeclare().post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.O4
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.Z3(this.f25910a);
            }
        });
    }

    public final DrawerLayout Z1() {
        Object parent = getParent();
        while (parent != null) {
            if (parent instanceof DrawerLayout) {
                return (DrawerLayout) parent;
            }
            View view = parent instanceof View ? (View) parent : null;
            parent = view != null ? view.getParent() : null;
        }
        return null;
    }

    @Override // com.stepos.ailauncher.common.utils.z
    public Activity a() {
        Activity activity = this.activity;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        return activity;
    }

    public final void a2(boolean isEmpty, String reason) {
        AgentChatLayout chatLayout;
        if (this.handoffReloadPending) {
            this.handoffReloadPending = false;
            this.handoffReloadGeneration++;
            Runnable runnable = this.handoffReloadRetryRunnable;
            if (runnable != null && (chatLayout = getChatLayout()) != null) {
                chatLayout.removeCallbacks(runnable);
            }
            this.handoffReloadRetryRunnable = null;
            C4148a.k("ChatView", "rebindSessionFromHandoff done empty=" + isEmpty + " reason=" + reason, false, 4, null);
            AgentChatLayout chatLayout2 = getChatLayout();
            LauncherChatLayout launcherChatLayout = chatLayout2 instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout2 : null;
            if (!isEmpty) {
                if (launcherChatLayout != null) {
                    launcherChatLayout.setIgnoreEmptySetMessages(true);
                }
                postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.view.m5
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatView.b2(this.f26248a);
                    }
                }, 2000L);
            } else if (launcherChatLayout != null) {
                launcherChatLayout.setIgnoreEmptySetMessages(false);
            }
            if (this.isResumed) {
                G1(this, null, 1, null);
                SessionHandler sessionHandler = this.sessionHandler;
                if (sessionHandler != null) {
                    sessionHandler.F2(true, true);
                }
            }
            InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = this.onHandoffReloadFinished;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(Boolean.valueOf(isEmpty));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a3() {
        /*
            r10 = this;
            r0 = 1
            r10.handoffReloadPending = r0
            com.stepos.agentframework.chatui.AgentChatLayout r1 = r10.getChatLayout()
            boolean r2 = r1 instanceof com.stepos.ailauncher.chat.view.LauncherChatLayout
            r3 = 0
            if (r2 == 0) goto Lf
            com.stepos.ailauncher.chat.view.LauncherChatLayout r1 = (com.stepos.ailauncher.chat.view.LauncherChatLayout) r1
            goto L10
        Lf:
            r1 = r3
        L10:
            if (r1 == 0) goto L15
            r1.d8()
        L15:
            long r1 = r10.sessionSwitchRecoverGeneration
            r4 = 1
            long r1 = r1 + r4
            r10.sessionSwitchRecoverGeneration = r1
            r10.activeSessionSwitchId = r3
            r10.V1()
            com.stepos.ailauncher.chat.manager.AgentConfig$a r1 = com.stepos.ailauncher.chat.manager.AgentConfig.INSTANCE
            com.stepos.ailauncher.chat.manager.AgentConfig r1 = r1.a()
            com.stepos.agentframework.chatcore.SessionHandler r1 = r1.n()
            r10.sessionHandler = r1
            com.stepos.agentframework.chatcore.c r2 = r1.getChatView()
            boolean r6 = r2 instanceof com.stepos.agentframework.chatui.AgentChatLayout
            if (r6 == 0) goto L38
            com.stepos.agentframework.chatui.AgentChatLayout r2 = (com.stepos.agentframework.chatui.AgentChatLayout) r2
            goto L39
        L38:
            r2 = r3
        L39:
            if (r2 == 0) goto L7e
            com.stepos.agentframework.chatui.AgentChatLayout r6 = r10.getChatLayout()
            if (r2 == r6) goto L42
            goto L43
        L42:
            r2 = r3
        L43:
            if (r2 == 0) goto L7e
            com.stepos.agentframework.chatui.ChatMessageAdapter r2 = r2.getAdapter()
            if (r2 == 0) goto L7e
            java.util.List r2 = r2.G()
            if (r2 == 0) goto L7e
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r2 = r2.iterator()
        L5c:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L6e
            java.lang.Object r7 = r2.next()
            boolean r8 = r7 instanceof com.stepos.agentframework.chatui.DisplayMessage
            if (r8 == 0) goto L5c
            r6.add(r7)
            goto L5c
        L6e:
            java.util.List r2 = Z8.F.p1(r6)
            if (r2 == 0) goto L7e
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L7e
            goto L7f
        L7e:
            r2 = r3
        L7f:
            r10.k1(r1)
            if (r2 == 0) goto Lca
            com.stepos.agentframework.chatui.AgentChatLayout r1 = r10.getChatLayout()
            boolean r6 = r1 instanceof com.stepos.ailauncher.chat.view.LauncherChatLayout
            if (r6 == 0) goto L8f
            com.stepos.ailauncher.chat.view.LauncherChatLayout r1 = (com.stepos.ailauncher.chat.view.LauncherChatLayout) r1
            goto L90
        L8f:
            r1 = r3
        L90:
            if (r1 == 0) goto L95
            r1.setIgnoreEmptySetMessages(r0)
        L95:
            com.stepos.agentframework.chatui.AgentChatLayout r0 = r10.getChatLayout()
            if (r0 == 0) goto La4
            com.stepos.agentframework.chatui.ChatMessageAdapter r0 = r0.getAdapter()
            if (r0 == 0) goto La4
            r0.H0(r2)
        La4:
            p9.l<? super java.lang.Boolean, Y8.t> r0 = r10.onMessageListChanged
            if (r0 == 0) goto Lad
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.invoke(r1)
        Lad:
            int r0 = r2.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "rebindSessionFromHandoff snapshot="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            r2 = 4
            java.lang.String r6 = "ChatView"
            h8.C4148a.k(r6, r0, r1, r2, r3)
        Lca:
            long r0 = r10.handoffReloadGeneration
            long r0 = r0 + r4
            r10.handoffReloadGeneration = r0
            Ua.M r4 = r10.scope
            com.stepos.ailauncher.chat.view.ChatView$rebindSessionFromHandoff$1 r7 = new com.stepos.ailauncher.chat.view.ChatView$rebindSessionFromHandoff$1
            r7.<init>(r10, r0, r3)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            Ua.C1056g.d(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatView.a3():void");
    }

    public final void a4(int keyboardHeight) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        WindowManager windowManager = this.windowManager;
        if (windowManager == null) {
            Object systemService = getContext().getSystemService("window");
            windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager == null) {
                return;
            }
        }
        O6.d dVar = O6.d.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        int iA = keyboardHeight > 0 ? dVar.a(context, 8.0f) + keyboardHeight : 0;
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        if (Math.abs(layoutParams2.y - iA) > dVar.a(context2, 5.0f)) {
            layoutParams2.y = iA;
            try {
                windowManager.updateViewLayout(this, layoutParams2);
                C4148a.d("ChatView", "Updated ChatView position: y=" + iA + ", keyboardHeight=" + keyboardHeight, false, 4, null);
            } catch (Exception e10) {
                C4148a.g("ChatView", "Failed to update ChatView position", e10, false, 8, null);
            }
        }
    }

    public final void b3(final String agentId, final String deviceId) {
        List<ExternalDeviceInfo> listA;
        Object next;
        IExternalAgentBindService iExternalAgentBindService = (IExternalAgentBindService) D5.a.INSTANCE.a(IExternalAgentBindService.class);
        if (iExternalAgentBindService == null) {
            Toast.makeText(getContext(), R$string.chat_agent_offline_toast, 0).show();
            return;
        }
        Context context = getContext();
        String deviceName = null;
        final ChatMainActivity chatMainActivity = context instanceof ChatMainActivity ? (ChatMainActivity) context : null;
        O6.i iVarC = O6.a.INSTANCE.c();
        if (iVarC != null && (listA = iVarC.a()) != null) {
            Iterator<T> it = listA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ExternalDeviceInfo externalDeviceInfo = (ExternalDeviceInfo) next;
                if (kotlin.jvm.internal.p.d(externalDeviceInfo.getDeviceId(), deviceId) && kotlin.jvm.internal.p.d(externalDeviceInfo.getAgent(), agentId)) {
                    break;
                }
            }
            ExternalDeviceInfo externalDeviceInfo2 = (ExternalDeviceInfo) next;
            if (externalDeviceInfo2 != null) {
                deviceName = externalDeviceInfo2.getDeviceName();
            }
        }
        final String str = deviceName;
        if (chatMainActivity != null) {
            chatMainActivity.p0();
        }
        iExternalAgentBindService.queryDeviceAgentOnline(deviceId, agentId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.k5
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatView.c3(str, chatMainActivity, deviceId, agentId, this, (Result) obj);
            }
        });
    }

    public final void b4() {
        ChatRecycleView messageList;
        this.isDismiss = false;
        if (this.UI_MODE_NORMAL == this.inputUIModel) {
            return;
        }
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout != null && (messageList = chatLayout.getMessageList()) != null) {
            ExtKt.C(messageList);
        }
        getChatLayoutExitFloatModeListener().invoke();
        if (this.latestChatContentHeight > getHeight()) {
            W3(this, this.latestChatContentHeight);
        }
    }

    public final void c1() {
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout == null) {
            return;
        }
        SessionHandler sessionHandler = this.sessionHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        String sessionId = agentConversationR1 != null ? agentConversationR1.getSessionId() : null;
        if (sessionId == null) {
            sessionId = "";
        }
        String tempSessionId = agentConversationR1 != null ? agentConversationR1.getTempSessionId() : null;
        String str = tempSessionId != null ? tempSessionId : "";
        boolean zI = ChatStopActions.INSTANCE.i(this.activeTaskSnapshot, sessionId, str);
        List<UiTask> list = this.activeTaskSnapshot;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((UiTask) it.next()).getTaskId());
        }
        C4148a.d("ChatView", "suppressForTask: sid=" + sessionId + " tempSid=" + str + " suppress=" + zI + " active=" + arrayList, false, 4, null);
        g1(zI);
        ChatMessageAdapter chatMessageAdapter = this.chatMessageAdapter;
        if (chatMessageAdapter != null) {
            chatMessageAdapter.L0(zI);
        }
        chatLayout.setActionBarSuppressedForTask(zI);
    }

    public final void c2() {
        AgentChatLayout chatLayout;
        ViewGroup viewGroup;
        if (this.scrollBtnFloated || (chatLayout = getChatLayout()) == null || (viewGroup = (ViewGroup) findViewById(R$id.clMain)) == null) {
            return;
        }
        this.scrollBtnFloatHandle = E7.e(E7.INSTANCE, viewGroup, chatLayout.getBtnScrollToBottom(), 0.0f, 0.0f, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.q4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.d2(this.f26301a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.B4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.e2(this.f25720a);
            }
        }, 12, null);
        this.scrollBtnFloated = true;
        LauncherChatLayout launcherChatLayout = chatLayout instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout : null;
        if (launcherChatLayout != null) {
            launcherChatLayout.J8();
        }
    }

    public final void c4(int uiMode) {
        AgentChatLayout chatLayout;
        InterfaceC5940b inputLayout;
        ChatRecycleView messageList;
        ChatRecycleView messageList2;
        InterfaceC5941c toolBar;
        View view;
        Context context = getContext();
        if (context == null || (chatLayout = getChatLayout()) == null || (inputLayout = chatLayout.getInputLayout()) == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) inputLayout.a(com.stepos.agentframework.R$id.ll_think);
        LinearLayout linearLayout2 = (LinearLayout) inputLayout.a(com.stepos.agentframework.R$id.rootInput);
        this.inputUIModel = uiMode;
        AgentChatLayout chatLayout2 = getChatLayout();
        if (chatLayout2 != null) {
            ExtKt.C(chatLayout2);
        }
        AgentChatLayout chatLayout3 = getChatLayout();
        if (chatLayout3 != null && (toolBar = chatLayout3.getToolBar()) != null && (view = toolBar.getView()) != null) {
            ExtKt.m(view);
        }
        if (uiMode == this.UI_MODE_NORMAL) {
            AgentChatLayout chatLayout4 = getChatLayout();
            if (chatLayout4 != null && (messageList2 = chatLayout4.getMessageList()) != null) {
                ExtKt.C(messageList2);
            }
        } else if (uiMode == this.UI_MODE_LITE) {
            AgentChatLayout chatLayout5 = getChatLayout();
            if (chatLayout5 != null && (messageList = chatLayout5.getMessageList()) != null) {
                ExtKt.p(messageList);
            }
            ActionView actionView = getInputView().getActionView();
            if (actionView != null) {
                ExtKt.p(actionView);
            }
            if (linearLayout != null) {
                ExtKt.m(linearLayout);
            }
            if (linearLayout2 != null) {
                linearLayout2.setBackgroundResource(R$color.transparent);
                linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop() + O6.d.INSTANCE.a(context, 8.0f), linearLayout2.getPaddingRight(), linearLayout2.getPaddingBottom());
            }
        }
        C4148a.d("ChatView", "updateUIbyMode: " + uiMode, false, 4, null);
    }

    public final void d1(boolean finalizing) {
        this.aiKeyFinalizing = finalizing;
        Runnable runnable = this.pendingAiKeyFinalizingUiRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.pendingAiKeyFinalizingUiRunnable = null;
        if (finalizing) {
            T1();
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.chat.view.l5
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.e1(this.f26236a);
            }
        };
        this.pendingAiKeyFinalizingUiRunnable = runnable2;
        postDelayed(runnable2, 33L);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d3(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto Ld
            int r1 = r7.length()
            if (r1 <= 0) goto La
            goto Lb
        La:
            r7 = r0
        Lb:
            if (r7 != 0) goto Lf
        Ld:
            java.lang.String r7 = r6.activeSessionSwitchId
        Lf:
            if (r7 == 0) goto L8c
            int r1 = r7.length()
            if (r1 != 0) goto L18
            goto L8c
        L18:
            boolean r1 = r6.A2(r7)
            r2 = 4
            java.lang.String r3 = "ChatView"
            r4 = 0
            if (r1 != 0) goto L40
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "session switch recover skip ("
            r6.append(r1)
            r6.append(r8)
            java.lang.String r8 = "): top!=expected expected="
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            h8.C4148a.u(r3, r6, r4, r2, r0)
            return
        L40:
            r6.U1()
            com.stepos.agentframework.chatui.AgentChatLayout r1 = r6.getChatLayout()
            boolean r5 = r1 instanceof com.stepos.ailauncher.chat.view.LauncherChatLayout
            if (r5 == 0) goto L4e
            com.stepos.ailauncher.chat.view.LauncherChatLayout r1 = (com.stepos.ailauncher.chat.view.LauncherChatLayout) r1
            goto L4f
        L4e:
            r1 = r0
        L4f:
            if (r1 == 0) goto L54
            r1.d8()
        L54:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "session switch recover ("
            r1.append(r5)
            r1.append(r8)
            java.lang.String r8 = "): reloadMessages expected="
            r1.append(r8)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            h8.C4148a.u(r3, r7, r4, r2, r0)
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L82
            com.stepos.agentframework.chatui.AgentChatLayout r6 = r6.getChatLayout()     // Catch: java.lang.Throwable -> L82
            if (r6 == 0) goto L7e
            r6.Y5(r4)     // Catch: java.lang.Throwable -> L82
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L82
        L7e:
            kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L82
            return
        L82:
            r6 = move-exception
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            kotlin.Result.b(r6)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatView.d3(java.lang.String, java.lang.String):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (!this.isInMain && ev.getActionMasked() == 0) {
            return false;
        }
        if (ev.getActionMasked() != 0 || !this.keyboardVisible || getInputView().a8() || getInputView().R7() || E2(ev.getRawX(), ev.getRawY(), getInputView())) {
            return super.dispatchTouchEvent(ev);
        }
        getInputView().n6();
        return true;
    }

    public final void e3(boolean fullTeardown, boolean preserveSharedSessionHandler) {
        AgentChatLayout chatLayout;
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        if (preserveSharedSessionHandler) {
            this.preserveSharedSessionHandlerOnDetach = true;
        }
        Activity activity = this.activity;
        boolean z10 = activity != null && activity.isChangingConfigurations();
        this.isResumed = false;
        com.stepos.ailauncher.chat.manager.Q0.r(this.onSessionExternallyMarked);
        H1();
        if (!z10) {
            N3();
        }
        if (!z10 && !this.chatExitReported) {
            this.chatExitReported = true;
            ChatTracker.INSTANCE.m(getCurrentSessionId(), getCurrentSessionId(), null, this.chatSessionStartElapsed > 0 ? Long.valueOf((SystemClock.elapsedRealtime() - this.chatSessionStartElapsed) / 1000) : null);
            this.chatSessionStartElapsed = 0L;
        }
        if (fullTeardown) {
            this.sessionReadyListeners.clear();
            s1();
            T3();
            TaskModule.INSTANCE.l(this.taskCardCallback);
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.keyboardLayoutListener;
            if (onGlobalLayoutListener != null) {
                try {
                    Activity activity2 = this.activity;
                    if (activity2 != null && (window = activity2.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        Y8.t tVar = Y8.t.f7040a;
                    }
                } catch (Exception e10) {
                    C4148a.t("ChatView", "onDetachedFromWindow: 移除键盘监听器失败", e10, false, 8, null);
                }
            }
            this.keyboardLayoutListener = null;
            this.activity = null;
            kotlinx.coroutines.d.e(this.scope, null, 1, null);
            this.latestChatContentHeight = 0;
            SessionHandler sessionHandler = this.sessionHandler;
            if (sessionHandler != null) {
                sessionHandler.J3(null);
            }
            SessionHandler sessionHandler2 = this.sessionHandler;
            if (sessionHandler2 != null) {
                sessionHandler2.G3(null);
            }
            ChatStopActions.INSTANCE.g(this, this.sessionHandler);
            if (!this.preserveSharedSessionHandlerOnDetach) {
                AgentConfig.INSTANCE.a().v();
            }
            this.sessionHandler = null;
            com.stepos.ailauncher.chat.wake.effect.c cVar = this.spectrumController;
            if (cVar != null) {
                cVar.h();
            }
            this.spectrumController = null;
            MarkwonHelper.y0(null);
        }
        getTtsMediaFocusController().c0();
        getKeepScreenOnController().n();
        AgentChatLayout chatLayout2 = getChatLayout();
        LauncherChatLayout launcherChatLayout = chatLayout2 instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout2 : null;
        if (launcherChatLayout != null) {
            launcherChatLayout.d8();
        }
        if (!WakeDialogImpl.INSTANCE.e() && !com.stepos.ailauncher.chat.lockscreen.B.INSTANCE.f()) {
            AgentChatLayout chatLayout3 = getChatLayout();
            LauncherChatLayout launcherChatLayout2 = chatLayout3 instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout3 : null;
            if (launcherChatLayout2 != null) {
                launcherChatLayout2.w7();
            }
        }
        AgentChatLayout chatLayout4 = getChatLayout();
        LauncherChatLayout launcherChatLayout3 = chatLayout4 instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout4 : null;
        if (launcherChatLayout3 != null) {
            launcherChatLayout3.T8();
        }
        AgentChatLayout chatLayout5 = getChatLayout();
        LauncherChatLayout launcherChatLayout4 = chatLayout5 instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout5 : null;
        if (launcherChatLayout4 != null) {
            launcherChatLayout4.S8();
        }
        this.sessionSwitchRecoverGeneration++;
        this.activeSessionSwitchId = null;
        Runnable runnable = this.handoffReloadRetryRunnable;
        if (runnable != null && (chatLayout = getChatLayout()) != null) {
            chatLayout.removeCallbacks(runnable);
        }
        this.handoffReloadRetryRunnable = null;
        this.handoffReloadGeneration++;
        this.handoffReloadPending = false;
        SlaChatController slaChatController = this.slaController;
        if (slaChatController != null) {
            slaChatController.e0();
        }
        this.sessionBindingReleased = true;
        if (fullTeardown) {
            Z3.INSTANCE.b();
        }
        SlaChatController slaChatController2 = this.slaController;
        if ((slaChatController2 == null || !slaChatController2.Q0()) && SlaVoiceBridge.INSTANCE.p() != null) {
            return;
        }
        post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.f4
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.g3();
            }
        });
    }

    public final void f1(int keyboardHeight) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            if (((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).bottomMargin != keyboardHeight) {
                ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams2;
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = keyboardHeight;
                setLayoutParams(bVar);
                this.lastBottomMargin = Integer.valueOf(keyboardHeight);
                return;
            }
            return;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            float f10 = -keyboardHeight;
            if (getTranslationY() == f10) {
                return;
            }
            setTranslationY(f10);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.bottomMargin != keyboardHeight) {
            marginLayoutParams.bottomMargin = keyboardHeight;
            setLayoutParams(layoutParams);
            this.lastBottomMargin = Integer.valueOf(keyboardHeight);
        }
    }

    public final void f2(AgentSession.b callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler != null) {
            sessionHandler.T2(callback);
        }
    }

    public final void f4(InterfaceC5074l<? super BaseInputView, Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        if (F2()) {
            listener.invoke(getInputView());
        } else {
            this.sessionReadyListeners.add(listener);
        }
    }

    public final void g1(boolean hasExecutingTask) {
        if (hasExecutingTask) {
            this.taskDrivenReplying = true;
            getInputView().setReplyingStatus(true);
        } else if (this.taskDrivenReplying) {
            this.taskDrivenReplying = false;
            if (ChatStopActions.INSTANCE.j(this.sessionHandler)) {
                return;
            }
            getInputView().setReplyingStatus(false);
        }
    }

    public final void g2() {
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout != null) {
            chatLayout.z4();
        }
    }

    public final String getCurrentSessionId() {
        AgentSession.AgentConversation agentConversationR1;
        String strB;
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler == null || (agentConversationR1 = sessionHandler.R1()) == null || (strB = agentConversationR1.B()) == null || strB.length() <= 0) {
            return null;
        }
        return strB;
    }

    public final boolean getFullScreenModel() {
        return this.fullScreenModel;
    }

    public final MainInputView getInputView() {
        Object value = this.inputView.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return (MainInputView) value;
    }

    public final boolean getMark() {
        return this.mark;
    }

    public final ChatRecycleView getMessageList() {
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout != null) {
            return chatLayout.getMessageList();
        }
        return null;
    }

    public final InterfaceC5063a<Y8.t> getOnAudioFocusLost() {
        return this.onAudioFocusLost;
    }

    public final InterfaceC5074l<String, Y8.t> getOnConversationSwitchStarted() {
        return this.onConversationSwitchStarted;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnHandoffReloadFinished() {
        return this.onHandoffReloadFinished;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnMessageListChanged() {
        return this.onMessageListChanged;
    }

    public final InterfaceC5074l<String, Y8.t> getOnMsgSent() {
        return this.onMsgSent;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnRecordingTouchBlockHost() {
        return this.onRecordingTouchBlockHost;
    }

    public final InterfaceC5074l<List<ChatMessage>, Y8.t> getOnSessionMessageListLoaded() {
        return this.onSessionMessageListLoaded;
    }

    public final InterfaceC5063a<Y8.t> getOnSessionSuccess() {
        return this.onSessionSuccess;
    }

    public final boolean getSuppressPillOverlaySync() {
        return this.suppressPillOverlaySync;
    }

    public final Object h1(DrawerLayout drawerLayout, int i10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        f fVar = new f(drawerLayout, cVar);
        drawerLayout.a(fVar);
        cVar.q(new e(drawerLayout, fVar));
        drawerLayout.d(i10);
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC == C4063a.g() ? objC : Y8.t.f7040a;
    }

    public final void h2() {
        t3();
        AgentChatLayout chatLayout = getChatLayout();
        final LauncherChatLayout launcherChatLayout = chatLayout instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout : null;
        if (launcherChatLayout != null) {
            launcherChatLayout.setOnCurrentConversationChanged(new p9.p() { // from class: com.stepos.ailauncher.chat.view.H4
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return ChatView.i2(this.f25798a, (w4.e) obj, (List) obj2);
                }
            });
            launcherChatLayout.setOnAskUserInquiry(new p9.r() { // from class: com.stepos.ailauncher.chat.view.I4
                @Override // p9.r
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return Boolean.valueOf(ChatView.j2(this.f25808a, (String) obj, (String) obj2, (List) obj3, (String) obj4));
                }
            });
            launcherChatLayout.setOnToolApproval(new p9.s() { // from class: com.stepos.ailauncher.chat.view.J4
                @Override // p9.s
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    return Boolean.valueOf(ChatView.k2(this.f25835a, launcherChatLayout, (String) obj, (String) obj2, (String) obj3, (String) obj4, (String) obj5));
                }
            });
            launcherChatLayout.setOnSessionKeyVisible(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.K4
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatView.m2(this.f25851a, (String) obj);
                }
            });
            launcherChatLayout.setOnMessagesApplied(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.L4
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatView.n2(this.f25866a, (List) obj);
                }
            });
            launcherChatLayout.setOnSessionSwitchGuardTimeout(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.N4
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatView.o2(this.f25894a, (String) obj);
                }
            });
        }
    }

    public final void h3() {
        if (getChatLayout() == null) {
            return;
        }
        Function2.a(new ChatView$refreshActionBarSuppressForTask$1(this, null));
    }

    public final void i3() {
        Object objB;
        if (this.screenOffReceiverRegistered) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().getApplicationContext().registerReceiver(this.screenOffReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"), 2);
            this.screenOffReceiverRegistered = true;
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("ChatView", "registerScreenOffReceiver failed", thE, false, 8, null);
        }
    }

    public final void j1() {
        AgentUIConfig.a aVarH = AgentUIConfig.INSTANCE.a().f(R$drawable.chat_receive_bg).g(R$drawable.chat_sent_bg).c(true).i(true).h(false);
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        LifecycleOwner lifecycleOwnerA = A.a(context);
        kotlin.jvm.internal.p.f(lifecycleOwnerA);
        C1060i.d(this.scope, null, null, new ChatView$bindChatResource$1(this, aVarH.d(new C3026z(lifecycleOwnerA)).e(new AgentUIConfig.MessageTextStyle(new AgentUIConfig.TextStyle(q3(true), 16.0f, 1.28f), new AgentUIConfig.TextStyle(q3(false), 16.0f, 1.28f))).a(), null), 3, null);
        getInputView();
    }

    public final void j3() {
        if (!this.isResumed || this.handoffReloadPending || this.sessionHandler == null || !com.stepos.ailauncher.chat.manager.Q0.INSTANCE.h(Z8.F.S0(P1(), C1173v.q(getCurrentSessionId())))) {
            return;
        }
        Y8.t tVar = null;
        C4148a.k("ChatView", "external edit marked while resumed -> reload messages", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            AgentChatLayout chatLayout = getChatLayout();
            if (chatLayout != null) {
                chatLayout.Y5(false);
                tVar = Y8.t.f7040a;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k1(com.stepos.agentframework.chatcore.SessionHandler r6) {
        /*
            r5 = this;
            r0 = 0
            r5.sessionBindingReleased = r0
            com.stepos.agentframework.chatui.AgentChatLayout r0 = r5.getChatLayout()
            if (r0 == 0) goto Lc
            r0.k3(r6)
        Lc:
            com.stepos.ailauncher.chat.view.MainInputView r0 = r5.getInputView()
            r0.b(r6)
            com.stepos.ailauncher.chat.input.ChatStopActions r0 = com.stepos.ailauncher.chat.input.ChatStopActions.INSTANCE
            r0.l(r5, r6)
            r5.Q2()
            com.stepos.agentframework.chatui.AgentChatLayout r0 = r5.getChatLayout()
            r1 = 0
            if (r0 == 0) goto L44
            com.stepos.ailauncher.chat.view.sla.SlaChatController r2 = r5.slaController
            if (r2 == 0) goto L30
            boolean r3 = r2.B0(r6)
            if (r3 == 0) goto L2d
            goto L2e
        L2d:
            r2 = r1
        L2e:
            if (r2 != 0) goto L40
        L30:
            com.stepos.ailauncher.chat.view.sla.SlaChatController r2 = new com.stepos.ailauncher.chat.view.sla.SlaChatController
            android.content.Context r3 = r5.getContext()
            java.lang.String r4 = "getContext(...)"
            kotlin.jvm.internal.p.h(r3, r4)
            r2.<init>(r3, r6)
            r5.slaController = r2
        L40:
            r6 = 2
            com.stepos.ailauncher.chat.view.sla.SlaChatController.w0(r2, r0, r1, r6, r1)
        L44:
            com.stepos.agentframework.chatui.AgentChatLayout r6 = r5.getChatLayout()
            if (r6 == 0) goto L52
            com.stepos.ailauncher.chat.view.Q4 r0 = new com.stepos.ailauncher.chat.view.Q4
            r0.<init>()
            r6.setCanPlayTTS(r0)
        L52:
            com.stepos.agentframework.chatui.AgentChatLayout r6 = r5.getChatLayout()
            if (r6 == 0) goto L60
            com.stepos.ailauncher.chat.view.R4 r0 = new com.stepos.ailauncher.chat.view.R4
            r0.<init>()
            r6.setOnRoundUnsuccessfulListener(r0)
        L60:
            com.stepos.ailauncher.chat.view.MainInputView r6 = r5.getInputView()
            com.stepos.ailauncher.chat.view.S4 r0 = new com.stepos.ailauncher.chat.view.S4
            r0.<init>()
            r6.setCallStopTTS(r0)
            com.stepos.agentframework.chatui.AgentChatLayout r6 = r5.getChatLayout()
            boolean r0 = r6 instanceof com.stepos.ailauncher.chat.view.LauncherChatLayout
            if (r0 == 0) goto L77
            com.stepos.ailauncher.chat.view.LauncherChatLayout r6 = (com.stepos.ailauncher.chat.view.LauncherChatLayout) r6
            goto L78
        L77:
            r6 = r1
        L78:
            if (r6 == 0) goto L7d
            r6.M8()
        L7d:
            com.stepos.agentframework.chatui.AgentChatLayout r5 = r5.getChatLayout()
            boolean r6 = r5 instanceof com.stepos.ailauncher.chat.view.LauncherChatLayout
            if (r6 == 0) goto L88
            r1 = r5
            com.stepos.ailauncher.chat.view.LauncherChatLayout r1 = (com.stepos.ailauncher.chat.view.LauncherChatLayout) r1
        L88:
            if (r1 == 0) goto L8d
            r1.L8()
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatView.k1(com.stepos.agentframework.chatcore.SessionHandler):void");
    }

    public final void k3(InterfaceC5074l<? super BaseInputView, Y8.t> listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.sessionReadyListeners.remove(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l3(com.stepos.agentframework.chatui.DisplayMessage r11) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatView.l3(com.stepos.agentframework.chatui.N1):void");
    }

    public final void m3(final long generation, final int attempt) {
        List<com.stepos.agentframework.chatui.S1> listG;
        if (generation == this.handoffReloadGeneration && this.handoffReloadPending) {
            AgentChatLayout chatLayout = getChatLayout();
            if (chatLayout == null) {
                Runnable runnable = this.handoffReloadRetryRunnable;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.chat.view.g5
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatView.n3(generation, this, attempt);
                    }
                };
                this.handoffReloadRetryRunnable = runnable2;
                postDelayed(runnable2, 120L);
                return;
            }
            SessionHandler sessionHandlerN = AgentConfig.INSTANCE.a().n();
            this.sessionHandler = sessionHandlerN;
            k1(sessionHandlerN);
            C4148a.d("ChatView", "handoff reload attempt=" + attempt, false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                chatLayout.Y5(false);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            h3();
            ChatMessageAdapter chatMessageAdapter = this.chatMessageAdapter;
            if (chatMessageAdapter != null && (listG = chatMessageAdapter.G()) != null && (!listG.isEmpty())) {
                a2(false, "adapter_ready");
                return;
            }
            Runnable runnable3 = this.handoffReloadRetryRunnable;
            if (runnable3 != null) {
                chatLayout.removeCallbacks(runnable3);
            }
            Runnable runnable4 = new Runnable() { // from class: com.stepos.ailauncher.chat.view.h5
                @Override // java.lang.Runnable
                public final void run() {
                    ChatView.o3(generation, this, attempt);
                }
            };
            this.handoffReloadRetryRunnable = runnable4;
            chatLayout.postDelayed(runnable4, 120L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        ViewParent parent2;
        ViewParent parent3;
        super.onAttachedToWindow();
        ViewParent parent4 = getParent();
        Class<?> cls = parent4 != null ? parent4.getClass() : null;
        ViewParent parent5 = getParent();
        Class<?> cls2 = (parent5 == null || (parent3 = parent5.getParent()) == null) ? null : parent3.getClass();
        ViewParent parent6 = getParent();
        C4148a.d("ChatView", "onAttachedToWindow, " + cls + ", " + cls2 + ", " + ((parent6 == null || (parent = parent6.getParent()) == null || (parent2 = parent.getParent()) == null) ? null : parent2.getClass()), false, 4, null);
        i3();
        TaskModule.INSTANCE.h(this.taskCardCallback);
        v3();
        SessionHandler sessionHandlerN = this.sessionHandler;
        if (sessionHandlerN == null) {
            sessionHandlerN = AgentConfig.INSTANCE.a().n();
            this.sessionHandler = sessionHandlerN;
        }
        AgentChatLayout chatLayout = getChatLayout();
        LauncherChatLayout launcherChatLayout = chatLayout instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout : null;
        if (sessionHandlerN != null && launcherChatLayout != null && sessionHandlerN.getChatView() != launcherChatLayout) {
            k1(sessionHandlerN);
        }
        W1();
        if (this.appsPillOverlayListener == null) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.chat.view.w4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    ChatView.R2(this.f26403a);
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
            this.appsPillOverlayListener = onGlobalLayoutListener;
            post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.x4
                @Override // java.lang.Runnable
                public final void run() {
                    ChatView.S2(this.f26414a);
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        r1();
        this.imeHideAnimating = false;
        super.onDetachedFromWindow();
        E7.a aVar = this.scrollBtnFloatHandle;
        if (aVar != null) {
            aVar.a();
        }
        this.scrollBtnFloatHandle = null;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.appsPillOverlayListener;
        if (onGlobalLayoutListener != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            this.appsPillOverlayListener = null;
        }
        f3(this, false, false, 3, null);
    }

    public final void p3() {
        if (this.keyboardVisible || this.imeHideAnimating) {
            return;
        }
        r1();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((layoutParams instanceof ConstraintLayout.b ? ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).bottomMargin : layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : getTranslationY() == 0.0f ? 0 : 1) > 0) {
            f1(0);
        }
    }

    public final int q3(boolean receive) {
        C2760a4 c2760a4 = C2760a4.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return c2760a4.b(context, receive);
    }

    public final void r1() {
        this.hideOffsetResetGeneration++;
    }

    public final void r3(String loadedSessionId) {
        TaskNavigationRequest taskNavigationRequest = this.pendingTaskNavigation;
        if (taskNavigationRequest == null) {
            return;
        }
        if (kotlin.jvm.internal.p.d(loadedSessionId, taskNavigationRequest.getSessionId()) ? true : (loadedSessionId == null || loadedSessionId.length() == 0) ? A2(taskNavigationRequest.getSessionId()) : false) {
            s3(taskNavigationRequest);
        }
    }

    public final void s1() {
        this.taskNavigationGeneration++;
        this.pendingTaskNavigation = null;
    }

    public final void s3(TaskNavigationRequest request) {
        if (request.getGeneration() == this.taskNavigationGeneration && kotlin.jvm.internal.p.d(this.pendingTaskNavigation, request)) {
            this.pendingTaskNavigation = null;
            B3(request);
        }
    }

    public final void setActiveConversationsChangedListener(com.stepos.agentframework.chatcore.session.Z changeCallback) {
        kotlin.jvm.internal.p.i(changeCallback, "changeCallback");
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler != null) {
            sessionHandler.G3(changeCallback);
        }
    }

    public final void setActivity(Activity activity) {
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        kotlin.jvm.internal.p.i(activity, "activity");
        if (kotlin.jvm.internal.p.d(this.activity, activity)) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.keyboardLayoutListener;
        if (onGlobalLayoutListener != null) {
            try {
                Activity activity2 = this.activity;
                if (activity2 != null && (window = activity2.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                    Y8.t tVar = Y8.t.f7040a;
                }
            } catch (Exception e10) {
                C4148a.t("ChatView", "Failed to remove old keyboard listener", e10, false, 8, null);
            }
        }
        this.activity = activity;
        F3();
        C4148a.d("ChatView", "setActivity: Activity 已设置，重新设置键盘监听器", false, 4, null);
    }

    public final void setDismiss(boolean z10) {
        this.isDismiss = z10;
    }

    public final void setFullScreenModel(boolean z10) {
        this.fullScreenModel = z10;
        if (z10) {
            c2();
        }
    }

    public final void setInMain(boolean z10) {
        this.isInMain = z10;
    }

    public final void setKeyboardListener(AgentChatLayout.InterfaceC1970b listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        getInputView().setInsetsListener(listener);
    }

    public final void setMark(boolean z10) {
        this.mark = z10;
    }

    public final void setOnAudioFocusLost(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onAudioFocusLost = interfaceC5063a;
    }

    public final void setOnConversationSwitchStarted(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onConversationSwitchStarted = interfaceC5074l;
    }

    public final void setOnHandoffReloadFinished(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onHandoffReloadFinished = interfaceC5074l;
    }

    public final void setOnMessageListChanged(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onMessageListChanged = interfaceC5074l;
    }

    public final void setOnMsgSent(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onMsgSent = interfaceC5074l;
    }

    public final void setOnRecordingTouchBlockHost(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onRecordingTouchBlockHost = interfaceC5074l;
    }

    public final void setOnSessionMessageListLoaded(InterfaceC5074l<? super List<ChatMessage>, Y8.t> interfaceC5074l) {
        this.onSessionMessageListLoaded = interfaceC5074l;
    }

    public final void setOnSessionSuccess(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onSessionSuccess = interfaceC5063a;
    }

    public final void setSuppressPillOverlaySync(boolean z10) {
        this.suppressPillOverlaySync = z10;
    }

    public final void setWindowManager(WindowManager windowManager) {
        kotlin.jvm.internal.p.i(windowManager, "windowManager");
        this.windowManager = windowManager;
    }

    public final boolean t1() {
        SessionHandler sessionHandler = this.sessionHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        String sessionId = agentConversationR1 != null ? agentConversationR1.getSessionId() : null;
        if (sessionId == null) {
            sessionId = "";
        }
        String tempSessionId = agentConversationR1 != null ? agentConversationR1.getTempSessionId() : null;
        String str = tempSessionId != null ? tempSessionId : "";
        if (sessionId.length() == 0 && str.length() == 0) {
            return false;
        }
        List<UiTask> list = this.activeTaskSnapshot;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            UiTask uiTask = (UiTask) obj;
            if (kotlin.jvm.internal.p.d(uiTask.getRequestedSessionKey(), sessionId) || kotlin.jvm.internal.p.d(uiTask.getRequestedSessionKey(), str)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((UiTask) it.next()).getTaskId());
        }
        if (arrayList2.isEmpty()) {
            return false;
        }
        C4148a.k("ChatView", "onStopClicked cancel tasks=" + arrayList2 + " sid=" + sessionId + " tempSid=" + str, false, 4, null);
        Function2.a(new ChatView$cancelUnfinishedTasksOfTopSession$1(arrayList2, null));
        return true;
    }

    public final void t3() {
        C1060i.d(this.scope, null, null, new ChatView$restartSessionEventCollector$1(this, null), 3, null);
    }

    public final void u1() {
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler != null) {
            AgentConfig.INSTANCE.a().w(sessionHandler);
        }
        C2689c0.INSTANCE.b(getInputView());
    }

    public final void u3() {
        if (this.markdownThemeClearedByTrim) {
            L2();
            this.markdownThemeClearedByTrim = false;
        }
        if (this.messageListCacheTrimmed) {
            ChatRecycleView messageList = getMessageList();
            if (messageList != null) {
                messageList.setItemViewCacheSize(2);
            }
            this.messageListCacheTrimmed = false;
        }
    }

    public final void v1(String sessionId) {
        if (sessionId.length() == 0) {
            return;
        }
        Y8.t tVar = null;
        if (kotlin.jvm.internal.p.d(this.pendingSessionSwitchId, sessionId)) {
            this.pendingSessionSwitchId = null;
        }
        SessionHandler sessionHandlerU1 = U1();
        if (sessionHandlerU1 == null) {
            return;
        }
        if (A2(sessionId)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AgentChatLayout chatLayout = getChatLayout();
                if (chatLayout != null) {
                    chatLayout.Y5(false);
                    tVar = Y8.t.f7040a;
                }
                Result.b(tVar);
                return;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
                return;
            }
        }
        Y3();
        getInputView().setReplyingStatus(false);
        getInputView().setInputTxt("");
        getInputView().M5();
        this.activeSessionSwitchId = sessionId;
        AgentChatLayout chatLayout2 = getChatLayout();
        LauncherChatLayout launcherChatLayout = chatLayout2 instanceof LauncherChatLayout ? (LauncherChatLayout) chatLayout2 : null;
        if (launcherChatLayout != null) {
            launcherChatLayout.Z7(sessionId);
        }
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = this.onConversationSwitchStarted;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(sessionId);
        }
        sessionHandlerU1.N0(sessionId);
        z3(sessionId);
    }

    public final void v3() {
        this.isResumed = true;
        com.stepos.ailauncher.chat.manager.Q0.d(this.onSessionExternallyMarked);
        if (this.chatSessionStartElapsed == 0) {
            this.chatSessionStartElapsed = SystemClock.elapsedRealtime();
            this.chatExitReported = false;
        }
        com.stepos.ailauncher.chat.wake.effect.c cVar = this.spectrumController;
        if (cVar != null) {
            cVar.h();
        }
        View rootView = getRootView();
        if (rootView == null) {
            rootView = this;
        }
        com.stepos.ailauncher.chat.wake.effect.c cVar2 = new com.stepos.ailauncher.chat.wake.effect.c(rootView, LONG_PRESS_SPECTRUM_CONFIG);
        cVar2.d(getInputView());
        this.spectrumController = cVar2;
    }

    public final void w1(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        s1();
        v1(sessionId);
    }

    public final void w3() {
        if (this.imeHideAnimating) {
            return;
        }
        Integer num = this.lastBottomMargin;
        if ((num != null ? num.intValue() : 0) <= 0) {
            return;
        }
        final int i10 = this.hideOffsetResetGeneration + 1;
        this.hideOffsetResetGeneration = i10;
        C4148a.d("ChatView", "schedule hide offset reset gen=" + i10 + " lastBottomMargin=" + this.lastBottomMargin, false, 4, null);
        postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.view.v5
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.x3(i10, this);
            }
        });
    }

    public final void z3(final String sessionId) {
        final long j10 = this.sessionSwitchRecoverGeneration + 1;
        this.sessionSwitchRecoverGeneration = j10;
        AgentChatLayout chatLayout = getChatLayout();
        if (chatLayout == null) {
            return;
        }
        chatLayout.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.view.T4
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.A3(j10, this, sessionId);
            }
        }, 400L);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v44, types: [com.stepos.ailauncher.chat.view.ChatView$taskCardCallback$1] */
    public ChatView(final Context context, AttributeSet attributeSet, int i10) {
        ChatRecycleView messageList;
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.scope = kotlinx.coroutines.d.a(Ua.Y.c().plus(Ua.L0.b(null, 1, null)));
        this.sessionReadyListeners = new LinkedHashSet<>();
        this.UI_MODE_NORMAL = 1;
        this.UI_MODE_LITE = 2;
        this.UI_MODE_WAKE = 3;
        this.btnAppsHotArea = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.i5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.p1(this.f26173a);
            }
        });
        this.btnAppsPill = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.m4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.q1(this.f26247a);
            }
        });
        this.inputUIModel = 1;
        this.topMarginDpAuto = 200.0f;
        this.topMarginDp = 200.0f;
        this.isInMain = true;
        this.aiKeyWaitingBar = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.n4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.a1(this.f26263a);
            }
        });
        this.aiKeyWaitingStop = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.o4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.b1(this.f26277a);
            }
        });
        this.ttsMediaFocusController = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.p4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.R3(context, this);
            }
        });
        this.keepScreenOnController = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.r4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.J2(this.f26315a);
            }
        });
        this.screenOffReceiver = new n();
        this.chatLayout = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.s4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.z1(this.f26326a, context);
            }
        });
        this.bgSpeech = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.t4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.i1(this.f26366a);
            }
        });
        this.inputView = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.u4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.r2(this.f26378a, context);
            }
        });
        this.vChatBg = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.v4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.d4(this.f26392a);
            }
        });
        this.vChatBottomBg = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.t5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.e4(this.f26367a);
            }
        });
        this.bottomFadeMask = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.y5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.o1(this.f26427a);
            }
        });
        this.aiDeclare = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.z5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.Z0(this.f26434a);
            }
        });
        this.ivDragBar = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.A5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.H2(this.f25710a);
            }
        });
        View.inflate(context, R$layout.layout_chat_view, this);
        getAiKeyWaitingStop().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.g4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatView.y0(this.f26140a, view);
            }
        });
        L2();
        j1();
        X0();
        AgentChatLayout chatLayout = getChatLayout();
        this.chatMessageAdapter = chatLayout != null ? chatLayout.getAdapter() : null;
        AgentChatLayout chatLayout2 = getChatLayout();
        if (chatLayout2 != null && (messageList = chatLayout2.getMessageList()) != null) {
            messageList.setVerticalFadingEdgeEnabled(false);
        }
        ChatMessageAdapter chatMessageAdapter = this.chatMessageAdapter;
        if (chatMessageAdapter != null) {
            chatMessageAdapter.I0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.h4
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ChatView.z0(this.f26156a, ((Boolean) obj).booleanValue());
                }
            });
        }
        h2();
        post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.i4
            @Override // java.lang.Runnable
            public final void run() {
                ChatView.A0(this.f26172a);
            }
        });
        this.activeTaskSnapshot = C1173v.m();
        this.taskCardCallback = new InterfaceC1452a() { // from class: com.stepos.ailauncher.chat.view.ChatView$taskCardCallback$1
            @Override // b6.InterfaceC1452a
            public void a(UiTask taskCard, List<UiTask> activeTasks) {
                kotlin.jvm.internal.p.i(taskCard, "taskCard");
                kotlin.jvm.internal.p.i(activeTasks, "activeTasks");
                Function2.b(new ChatView$taskCardCallback$1$onTaskUpdate$1(this.this$0, activeTasks, null));
            }

            @Override // b6.InterfaceC1452a
            public void b(UiTask taskCard) {
                kotlin.jvm.internal.p.i(taskCard, "taskCard");
            }
        };
        this.chatLayoutExitFloatModeListener = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.j4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.x1(this.f26201a, context);
            }
        });
        this.inputBottomOptionChangeListener = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.k4
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ChatView.p2(this.f26214a);
            }
        });
        this.isDismiss = true;
        this.aiDeclareVisibilityBeforeKeyboard = 8;
        this.onSessionExternallyMarked = new Q0.a() { // from class: com.stepos.ailauncher.chat.view.l4
            @Override // com.stepos.ailauncher.chat.manager.Q0.a
            public final void a(Set set) {
                ChatView.W2(this.f26235a, set);
            }
        };
    }

    public /* synthetic */ ChatView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
