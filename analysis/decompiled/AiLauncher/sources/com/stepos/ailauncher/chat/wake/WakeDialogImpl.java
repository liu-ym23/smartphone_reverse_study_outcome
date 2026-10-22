package com.stepos.ailauncher.chat.wake;

import E4.FloatCardContent;
import E4.FloatCardOption;
import E4.FloatCardOptions;
import E4.FloatCardPage;
import E4.FloatCardRequest;
import E4.g;
import La.C0951a;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import b6.InterfaceC1452a;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.google.android.material.R$attr;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.ESessionStatus;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.ChatMessageAdapter;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.T1;
import com.stepos.agentframework.chatui.view.ChatRecycleView;
import com.stepos.agentframework.floatcard.api.FloatCardOptionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.agentframework.floatcard.api.FloatCardStatus;
import com.stepos.agentframework.floatcard.api.SelectionMode;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import com.stepos.agentframework.uikit.MarkwonHelper;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.activity.ChatMainActivity;
import com.stepos.ailauncher.chat.input.ChatStopActions;
import com.stepos.ailauncher.chat.lockscreen.C2682o;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.chat.manager.C2689c0;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.media.TtsMediaFocusController;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.ActionView;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.chat.view.sla.SlaChatController;
import com.stepos.ailauncher.chat.view.sla.a;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.J;
import com.stepos.ailauncher.chat.wake.WakeService;
import com.stepos.ailauncher.chat.wake.circle.CircleSelectController;
import com.stepos.ailauncher.chat.wake.effect.SpectrumBorderConfig;
import com.stepos.ailauncher.common.permission.PermScene;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import com.stepos.ailauncher.floatcard.api.IFloatCardService;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.task.TaskModule;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import com.stepos.common.animator.SurroundShaderLayout;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k5.C4814a;
import kotlin.C0919o;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v8.C5671a;
import v9.C5685n;
import w4.ChatMessage;
import y4.InterfaceC5940b;

@Metadata(d1 = {"\u0000¬\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\nÝ\u0002è\u0002ì\u0002õ\u0002\u0099\u0003\b\u0007\u0018\u0000 »\u00032\u00020\u0001:\u0002¼\u0003B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u0016J\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0016J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0016J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\u0016J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\u0016J\u000f\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010\u0016J\u000f\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010\u0016J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0016J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0016J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0016J\u000f\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010\u0016J\u000f\u0010+\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010\u0016J\u000f\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b,\u0010\u0016J\u000f\u0010-\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010\u0016J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010\u000eJ\u000f\u0010/\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u0010\u0016J\u000f\u00100\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u0019\u00107\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b7\u0010\u000eJ\u000f\u00108\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u0010\u0016J\u000f\u00109\u001a\u00020\u0007H\u0002¢\u0006\u0004\b9\u00101J\u000f\u0010:\u001a\u00020\u0005H\u0002¢\u0006\u0004\b:\u0010\u0016J\u0017\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0007H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0005H\u0002¢\u0006\u0004\b>\u0010\u0016J\u000f\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\b?\u0010\u0016J'\u0010C\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0011H\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0005H\u0002¢\u0006\u0004\bE\u0010\u0016J\u000f\u0010F\u001a\u00020\u0005H\u0002¢\u0006\u0004\bF\u0010\u0016J\u001f\u0010H\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u0011H\u0002¢\u0006\u0004\bH\u0010IJ\u001f\u0010K\u001a\u00020J2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u0011H\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0005H\u0002¢\u0006\u0004\bM\u0010\u0016J\u000f\u0010N\u001a\u00020\u0005H\u0002¢\u0006\u0004\bN\u0010\u0016J\u000f\u0010O\u001a\u00020\u0005H\u0002¢\u0006\u0004\bO\u0010\u0016J\u0017\u0010R\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0007H\u0002¢\u0006\u0004\bT\u00101J\u0017\u0010V\u001a\u00020\u00072\u0006\u0010U\u001a\u00020PH\u0002¢\u0006\u0004\bV\u0010WJ'\u0010\\\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020J2\u0006\u0010[\u001a\u00020JH\u0002¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\b^\u0010SJ\u000f\u0010_\u001a\u00020\u0005H\u0002¢\u0006\u0004\b_\u0010\u0016J\u0019\u0010b\u001a\u0004\u0018\u00010a2\u0006\u0010`\u001a\u00020\u0011H\u0002¢\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u00020\u00072\u0006\u0010U\u001a\u00020PH\u0002¢\u0006\u0004\bd\u0010WJ\u0017\u0010e\u001a\u00020\u00072\u0006\u0010U\u001a\u00020PH\u0002¢\u0006\u0004\be\u0010WJ\u0017\u0010g\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u0011H\u0002¢\u0006\u0004\bg\u0010\u0014J\u000f\u0010h\u001a\u00020\u0011H\u0002¢\u0006\u0004\bh\u0010iJ\u0017\u0010j\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020\u0011H\u0002¢\u0006\u0004\bl\u0010iJ\u0017\u0010n\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020\u0011H\u0002¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\u0007H\u0002¢\u0006\u0004\bp\u00101J\u000f\u0010q\u001a\u00020\u0011H\u0002¢\u0006\u0004\bq\u0010iJ\u0017\u0010s\u001a\u00020\u00112\u0006\u0010r\u001a\u00020\u0011H\u0002¢\u0006\u0004\bs\u0010tJ\u0017\u0010u\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\bu\u0010\u001eJ\u000f\u0010v\u001a\u00020\u0005H\u0002¢\u0006\u0004\bv\u0010\u0016J!\u0010y\u001a\u00020\u00052\u0006\u0010w\u001a\u00020J2\b\b\u0002\u0010x\u001a\u00020JH\u0002¢\u0006\u0004\by\u0010zJ\u0017\u0010|\u001a\u00020\u00052\u0006\u0010{\u001a\u00020JH\u0002¢\u0006\u0004\b|\u0010}J\u001b\u0010\u007f\u001a\u00020\u00052\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u007f\u0010\u000eJ\u0011\u0010\u0080\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u0016J\u0019\u0010\u0081\u0001\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u0081\u0001\u0010\u001eJ\u001a\u0010\u0083\u0001\u001a\u00020\u00052\u0007\u0010\u0082\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0083\u0001\u0010=J\u0011\u0010\u0084\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u0084\u0001\u0010\u0016J\u0011\u0010\u0085\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u0016J\u001a\u0010\u0087\u0001\u001a\u00020\u00112\u0007\u0010\u0086\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u0087\u0001\u0010tJ\u0011\u0010\u0088\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u0088\u0001\u0010\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u0089\u0001\u0010\u0016J\u0011\u0010\u008a\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u008a\u0001\u0010\u0016J\u0011\u0010\u008b\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0016J\u0011\u0010\u008c\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u0016J\u001a\u0010\u008e\u0001\u001a\u00020\u00052\u0007\u0010\u008d\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u008e\u0001\u0010=J\u0019\u0010\u008f\u0001\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0005\b\u008f\u0001\u0010\u001eJ\u0011\u0010\u0090\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u0090\u0001\u0010\u0016J\u001a\u0010\u0092\u0001\u001a\u00020\u00052\u0007\u0010\u0091\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0092\u0001\u0010=J\u001c\u0010\u0095\u0001\u001a\u00020\u00052\b\u0010\u0094\u0001\u001a\u00030\u0093\u0001H\u0002¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0011\u0010\u0097\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u0097\u0001\u0010\u0016J!\u0010\u0099\u0001\u001a\u00020\u00052\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0011\u0010\u009b\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u009b\u0001\u0010\u0016J\u0011\u0010\u009c\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0005\b\u009c\u0001\u0010\u0016J\u0011\u0010\u009d\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u009d\u0001\u00101J\u000f\u0010\u009e\u0001\u001a\u00020\u0007¢\u0006\u0005\b\u009e\u0001\u00101J\u0011\u0010\u009f\u0001\u001a\u00020\u0007H\u0014¢\u0006\u0005\b\u009f\u0001\u00101J\u001c\u0010¡\u0001\u001a\u00020\u00052\t\u0010 \u0001\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0005\b¡\u0001\u0010\u000eJ\u0012\u0010¢\u0001\u001a\u00020\u000bH\u0014¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001a\u0010¥\u0001\u001a\u00020\u00052\u0007\u0010¤\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¥\u0001\u0010=J\u000f\u0010¦\u0001\u001a\u00020\u0005¢\u0006\u0005\b¦\u0001\u0010\u0016J\u000f\u0010§\u0001\u001a\u00020\u0005¢\u0006\u0005\b§\u0001\u0010\u0016J\u000f\u0010¨\u0001\u001a\u00020\u0005¢\u0006\u0005\b¨\u0001\u0010\u0016J\u000f\u0010©\u0001\u001a\u00020\u0005¢\u0006\u0005\b©\u0001\u0010\u0016J\u0011\u0010ª\u0001\u001a\u00020\u0005H\u0016¢\u0006\u0005\bª\u0001\u0010\u0016J\u0011\u0010«\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0005\b«\u0001\u0010\u0016J\u0011\u0010¬\u0001\u001a\u00020\u0005H\u0016¢\u0006\u0005\b¬\u0001\u0010\u0016J\u0011\u0010\u00ad\u0001\u001a\u00020\u0005H\u0016¢\u0006\u0005\b\u00ad\u0001\u0010\u0016J\u0019\u0010®\u0001\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020PH\u0016¢\u0006\u0005\b®\u0001\u0010WJ#\u0010°\u0001\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u001b2\t\b\u0002\u0010¯\u0001\u001a\u00020\u0007¢\u0006\u0006\b°\u0001\u0010±\u0001J!\u0010³\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0007\u0010²\u0001\u001a\u00020\u0011¢\u0006\u0006\b³\u0001\u0010´\u0001J\u0018\u0010¶\u0001\u001a\u00020\u00052\u0007\u0010µ\u0001\u001a\u00020\u000b¢\u0006\u0005\b¶\u0001\u0010\u000eJ\u000f\u0010·\u0001\u001a\u00020\u0005¢\u0006\u0005\b·\u0001\u0010\u0016J\u001b\u0010¸\u0001\u001a\u00020\u00052\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u000b¢\u0006\u0005\b¸\u0001\u0010\u000eJ\u000f\u0010¹\u0001\u001a\u00020\u0005¢\u0006\u0005\b¹\u0001\u0010\u0016J\u000f\u0010º\u0001\u001a\u00020\u0005¢\u0006\u0005\bº\u0001\u0010\u0016J\u000f\u0010»\u0001\u001a\u00020\u0005¢\u0006\u0005\b»\u0001\u0010\u0016J,\u0010¿\u0001\u001a\u00020\u00052\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u000b2\u000f\u0010¾\u0001\u001a\n\u0012\u0005\u0012\u00030½\u00010¼\u0001¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u000f\u0010Á\u0001\u001a\u00020\u0005¢\u0006\u0005\bÁ\u0001\u0010\u0016J$\u0010Å\u0001\u001a\u00020\u00052\b\u0010Â\u0001\u001a\u00030½\u00012\b\u0010Ä\u0001\u001a\u00030Ã\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u000f\u0010Ç\u0001\u001a\u00020\u0005¢\u0006\u0005\bÇ\u0001\u0010\u0016J9\u0010Ì\u0001\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020\u000b2\u0013\b\u0002\u0010Ê\u0001\u001a\f\u0012\u0005\u0012\u00030É\u0001\u0018\u00010¼\u00012\t\b\u0002\u0010Ë\u0001\u001a\u00020\u0007¢\u0006\u0006\bÌ\u0001\u0010Í\u0001JD\u0010Ï\u0001\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020\u000b2\u0013\b\u0002\u0010Ê\u0001\u001a\f\u0012\u0005\u0012\u00030É\u0001\u0018\u00010¼\u00012\t\b\u0002\u0010Ë\u0001\u001a\u00020\u00072\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u0018\u0010Ò\u0001\u001a\u00020\u00052\u0007\u0010Ñ\u0001\u001a\u00020\u000b¢\u0006\u0005\bÒ\u0001\u0010\u000eJ\u001a\u0010Ó\u0001\u001a\u00020\u00052\b\u0010\u0094\u0001\u001a\u00030\u0093\u0001¢\u0006\u0006\bÓ\u0001\u0010\u0096\u0001J\u001a\u0010Õ\u0001\u001a\u00020\u00052\t\u0010Ô\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0005\bÕ\u0001\u0010\u000eR\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010Ö\u0001R\u0015\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\b\u0010×\u0001R\u001a\u0010Ø\u0001\u001a\u00030Ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u0019\u0010Ú\u0001\u001a\u00020X8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u0019\u0010Ü\u0001\u001a\u00020X8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÜ\u0001\u0010Û\u0001R\u0019\u0010Ý\u0001\u001a\u00020X8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÝ\u0001\u0010Û\u0001R\u001a\u0010ß\u0001\u001a\u00030Þ\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001c\u0010â\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001b\u0010ä\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010Û\u0001R\u001a\u0010æ\u0001\u001a\u00030å\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u0019\u0010è\u0001\u001a\u00020X8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bè\u0001\u0010Û\u0001R\u0019\u0010é\u0001\u001a\u00020X8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bé\u0001\u0010Û\u0001R\u001c\u0010ë\u0001\u001a\u0005\u0018\u00010ê\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R!\u0010ò\u0001\u001a\u00030í\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bî\u0001\u0010ï\u0001\u001a\u0006\bð\u0001\u0010ñ\u0001R!\u0010÷\u0001\u001a\u00030ó\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bô\u0001\u0010ï\u0001\u001a\u0006\bõ\u0001\u0010ö\u0001R\u001c\u0010ù\u0001\u001a\u0005\u0018\u00010ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u001c\u0010ü\u0001\u001a\u0005\u0018\u00010û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u001b\u0010þ\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010Û\u0001R\u001b\u0010ÿ\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010Û\u0001R\u001c\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0080\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0019\u0010\u0083\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0002\u0010×\u0001R\u0019\u0010\u0084\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0002\u0010×\u0001R\u001c\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0085\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0018\u0010\u0089\u0002\u001a\u00030\u0088\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R\u001c\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008b\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002R\u001b\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R)\u0010\u0091\u0002\u001a\u00020\u001b2\u0007\u0010\u0090\u0002\u001a\u00020\u001b8\u0002@BX\u0082\u000e¢\u0006\u000f\n\u0006\b\u0091\u0002\u0010\u0092\u0002\"\u0005\b\u0093\u0002\u0010\u001eR\u0019\u0010\u0094\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u0095\u0002R\u0019\u0010\u0096\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0095\u0002R\u001c\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010\u0099\u0002R\u001c\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0002\u0010\u0099\u0002R\u0019\u0010\u009b\u0002\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R\u0019\u0010\u009d\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u0095\u0002R\u0019\u0010\u009e\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010×\u0001R\u001c\u0010 \u0002\u001a\u0005\u0018\u00010\u009f\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0002\u0010¡\u0002R\u0019\u0010¢\u0002\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0002\u0010\u009c\u0002R\u0019\u0010£\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0002\u0010\u0095\u0002R\u0019\u0010¤\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010×\u0001R\u001c\u0010¥\u0002\u001a\u0005\u0018\u00010\u009f\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0002\u0010¡\u0002R!\u0010ª\u0002\u001a\u00030¦\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b§\u0002\u0010ï\u0001\u001a\u0006\b¨\u0002\u0010©\u0002R\u0019\u0010«\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010×\u0001R\u0019\u0010¬\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010×\u0001R\u0019\u0010\u00ad\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010×\u0001R\u0018\u0010®\u0002\u001a\u00030Ã\u00018\u0002X\u0082D¢\u0006\b\n\u0006\b®\u0002\u0010Ù\u0001R\u0018\u0010¯\u0002\u001a\u00030\u0085\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0002\u0010\u0087\u0002R\u0019\u0010°\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010×\u0001R\u001c\u0010²\u0002\u001a\u0005\u0018\u00010±\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010³\u0002R\u001c\u0010µ\u0002\u001a\u0005\u0018\u00010´\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R\u001c\u0010¸\u0002\u001a\u0005\u0018\u00010·\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010¹\u0002R\u001c\u0010»\u0002\u001a\u0005\u0018\u00010º\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010¼\u0002R\u001c\u0010¾\u0002\u001a\u0005\u0018\u00010½\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0002\u0010¿\u0002R\u0019\u0010À\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0002\u0010\u0095\u0002R\u001c\u0010Â\u0002\u001a\u0005\u0018\u00010Á\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0002\u0010Ã\u0002R\u001b\u0010Ä\u0002\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0002\u0010Û\u0001R1\u0010Å\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÅ\u0002\u0010Ö\u0001\u001a\u0006\bÆ\u0002\u0010Ç\u0002\"\u0006\bÈ\u0002\u0010\u009a\u0001R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010É\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0002\u0010Ë\u0002R/\u0010Ì\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÌ\u0002\u0010Ö\u0001\u001a\u0006\bÍ\u0002\u0010Ç\u0002\"\u0006\bÎ\u0002\u0010\u009a\u0001R\u001b\u0010Ï\u0002\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0002\u0010Û\u0001R#\u0010Ô\u0002\u001a\u0005\u0018\u00010Ð\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÑ\u0002\u0010ï\u0001\u001a\u0006\bÒ\u0002\u0010Ó\u0002R\u0019\u0010Õ\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0002\u0010×\u0001R\u001b\u0010Ö\u0002\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0002\u0010×\u0002R\u0019\u0010Ø\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0002\u0010×\u0001R\u0019\u0010Ù\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0002\u0010×\u0001R\u0019\u0010Ú\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0002\u0010×\u0001R\u001b\u0010Û\u0002\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0002\u0010\u008f\u0002R\u001a\u0010Ü\u0002\u001a\u00030Ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0002\u0010Ù\u0001R\u0018\u0010Þ\u0002\u001a\u00030Ý\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0002\u0010ß\u0002R\u0019\u0010à\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0002\u0010×\u0001R\u0019\u0010á\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0002\u0010×\u0001R\u0019\u0010â\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0002\u0010×\u0001R!\u0010ç\u0002\u001a\u00030ã\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bä\u0002\u0010ï\u0001\u001a\u0006\bå\u0002\u0010æ\u0002R\u0018\u0010é\u0002\u001a\u00030è\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bé\u0002\u0010ê\u0002R\u001b\u0010ë\u0002\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0002\u0010×\u0002R\u0018\u0010í\u0002\u001a\u00030ì\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bí\u0002\u0010î\u0002R\u0019\u0010ï\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0002\u0010×\u0001R\u0018\u0010ñ\u0002\u001a\u00030ð\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bñ\u0002\u0010ò\u0002R\u0017\u0010ô\u0002\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\b\n\u0006\bó\u0002\u0010\u008f\u0002R\u0018\u0010ö\u0002\u001a\u00030õ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bö\u0002\u0010÷\u0002R\u001f\u0010ú\u0002\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bø\u0002\u0010ï\u0001\u001a\u0005\bù\u0002\u0010iR\u001f\u0010ý\u0002\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bû\u0002\u0010ï\u0001\u001a\u0005\bü\u0002\u0010iR\u001c\u0010ÿ\u0002\u001a\u0005\u0018\u00010þ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0002\u0010\u0080\u0003R\u001c\u0010\u0082\u0003\u001a\u0005\u0018\u00010\u0081\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0003\u0010\u0083\u0003R\u001b\u0010\u0084\u0003\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0003\u0010Û\u0001R\u001c\u0010\u0086\u0003\u001a\u0005\u0018\u00010\u0085\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0003\u0010\u0087\u0003R\u001c\u0010\u0089\u0003\u001a\u0005\u0018\u00010\u0088\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0003\u0010\u008a\u0003R\u001c\u0010\u008b\u0003\u001a\u0005\u0018\u00010\u0085\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0003\u0010\u0087\u0003R\u001b\u0010\u008c\u0003\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0003\u0010Û\u0001R\u001c\u0010\u008d\u0003\u001a\u0005\u0018\u00010\u0088\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0003\u0010\u008a\u0003R\u0019\u0010\u008e\u0003\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0003\u0010\u0095\u0002R\u0019\u0010\u008f\u0003\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0003\u0010\u0095\u0002R\u0019\u0010\u0090\u0003\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0003\u0010\u0095\u0002R\u0017\u0010\u0091\u0003\u001a\u00020\u00118\u0002X\u0082D¢\u0006\b\n\u0006\b\u0091\u0003\u0010\u0095\u0002R\u0017\u0010\u0092\u0003\u001a\u00020\u00118\u0002X\u0082D¢\u0006\b\n\u0006\b\u0092\u0003\u0010\u0095\u0002R\u001c\u0010\u0094\u0003\u001a\u0005\u0018\u00010\u0093\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0003\u0010\u0095\u0003R!\u0010\u0097\u0003\u001a\n\u0012\u0005\u0012\u00030\u0096\u00030¼\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0003\u0010\u0098\u0003R\u0018\u0010\u009a\u0003\u001a\u00030\u0099\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0003\u0010\u009b\u0003R\u0018\u0010\u009c\u0003\u001a\u00030\u0085\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0003\u0010\u0087\u0002R\u001b\u0010\u009d\u0003\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0003\u0010×\u0002R\u0019\u0010\u009e\u0003\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0003\u0010\u0095\u0002R\u0019\u0010\u009f\u0003\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0003\u0010\u0095\u0002R\u0019\u0010 \u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0003\u0010×\u0001R\u0019\u0010¡\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0003\u0010×\u0001R\u0019\u0010¢\u0003\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0003\u0010\u009c\u0002R\u0019\u0010£\u0003\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0003\u0010\u009c\u0002R\u0019\u0010¤\u0003\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0003\u0010\u009c\u0002R\u0019\u0010¥\u0003\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0003\u0010\u009c\u0002R\u0019\u0010¦\u0003\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0003\u0010\u0095\u0002R\u0019\u0010§\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0003\u0010×\u0001R\u0019\u0010¨\u0003\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0003\u0010\u009c\u0002R\u0019\u0010©\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0003\u0010×\u0001R\u001c\u0010ª\u0003\u001a\u0005\u0018\u00010\u0085\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0003\u0010\u0087\u0002R\u0019\u0010«\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0003\u0010×\u0001R\u0019\u0010¬\u0003\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0003\u0010\u009c\u0002R\u0019\u0010\u00ad\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0003\u0010×\u0001R\u0018\u0010®\u0003\u001a\u00030\u0085\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0003\u0010\u0087\u0002R\u001c\u0010°\u0003\u001a\u0005\u0018\u00010¯\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0003\u0010±\u0003R\u001b\u0010²\u0003\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0003\u0010\u008f\u0002R\u001b\u0010³\u0003\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0003\u0010\u008f\u0002R\u0017\u0010¶\u0003\u001a\u00020J8BX\u0082\u0004¢\u0006\b\u001a\u0006\b´\u0003\u0010µ\u0003R\u0018\u0010º\u0003\u001a\u00030·\u00038BX\u0082\u0004¢\u0006\b\u001a\u0006\b¸\u0003\u0010¹\u0003¨\u0006½\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl;", "Lcom/stepos/ailauncher/chat/wake/e0;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "LY8/t;", "onDismissed", "", "enableCircleSelect", "<init>", "(Landroid/content/Context;Lp9/a;Z)V", "", "stage", "q6", "(Ljava/lang/String;)V", "reason", "K4", "", "heightPx", "z6", "(I)V", "z5", "()V", "chatLayoutHeight", "k6", "o6", "P5", "Lcom/stepos/ailauncher/chat/wake/J;", VoiceWakeupReceiver.EXTRA_STATE, "B6", "(Lcom/stepos/ailauncher/chat/wake/J;)V", "T2", "p6", "i3", "N3", "k3", "E3", "q4", "t5", "u6", "x6", "E5", "w5", "w6", "Q2", "r5", "G3", AMapLocationStaticsEntity.IPV6, "a6", "()Z", "Lcom/stepos/ailauncher/chat/view/sla/a;", "resolution", "S2", "(Lcom/stepos/ailauncher/chat/view/sla/a;)V", DidiCardProvider.KEY_TRACE_ID, "k5", "r4", "Z5", "E2", "show", "X3", "(Z)V", "W5", "M5", "keyboardHeight", "effectiveKeyboardHeight", "effectiveStatusBarTop", "F5", "(III)V", "t3", "N5", "statusBarTop", "D2", "(II)V", "", "y3", "(II)F", "C5", "W4", "R5", "Landroid/view/MotionEvent;", "ev", "C6", "(Landroid/view/MotionEvent;)V", "N4", "event", "o4", "(Landroid/view/MotionEvent;)Z", "Landroid/view/View;", "view", "rawX", "rawY", "p4", "(Landroid/view/View;FF)Z", "V4", "n4", "extensionHeightPx", "Landroid/graphics/Rect;", "A3", "(I)Landroid/graphics/Rect;", "l4", "m4", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "J5", "Z4", "()I", "v3", "(Lcom/stepos/ailauncher/chat/wake/J;)I", "T4", "currentChatH", "z3", "(I)Lcom/stepos/ailauncher/chat/wake/J;", "L4", "B3", "dragStartChatHeightPx", "U4", "(I)I", "V2", "m5", "target", "stiffness", "K2", "(FF)V", "endTransY", "g6", "(F)V", "pressToTalkCancelReason", "o5", "F3", "A6", "onScrim", "R2", "Y3", "X4", "dp", "M3", "U2", "x3", "x5", "y6", "f6", "triggerCancel", "j6", "m6", "L3", "waitingShown", "l6", "Lcom/stepos/ailauncher/chat/wake/WakeService$b;", "payload", "b6", "(Lcom/stepos/ailauncher/chat/wake/WakeService$b;)V", "V3", "start", "e6", "(Lp9/a;)V", "I4", "y5", "s3", "M4", "N", "stopReason", ExifInterface.LONGITUDE_EAST, "t", "()Ljava/lang/String;", "isKeyguardLocked", "r", "C2", "C3", "d6", "B5", "onAttachedToWindow", "v5", "B", "O", "dispatchTouchEvent", "useFlingSpec", "M2", "(Lcom/stepos/ailauncher/chat/wake/J;Z)V", "attrResId", "b4", "(Landroid/content/Context;I)I", "text", "I5", "J3", "H3", "W3", "m3", "R4", "", "Landroid/net/Uri;", "uris", "b3", "(Ljava/lang/String;Ljava/util/List;)V", "i6", "uri", "", "screenshotRound", "i5", "(Landroid/net/Uri;J)V", "g5", "message", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "files", "defaultSend", "W2", "(Ljava/lang/String;Ljava/util/List;Z)V", "msgSource", "X2", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;)V", "sessionId", SdCardDbCreator.FIELD_LASTLOC_TIME, "g3", "source", "d3", "Lp9/a;", "Z", "showStartMs", "J", "rootView", "Landroid/view/View;", "scrimView", "panelView", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "inputView", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "chatLayout", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "chatPanelWrapper", "Landroidx/constraintlayout/widget/ConstraintLayout;", "dragHandleArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "dragBar", "sBottomSpace", "Lcom/stepos/ailauncher/chat/wake/effect/g;", "spectrumBorder", "Lcom/stepos/ailauncher/chat/wake/effect/g;", "Lcom/stepos/ailauncher/chat/wake/effect/c;", "recordingSpectrumController$delegate", "LY8/h;", "h4", "()Lcom/stepos/ailauncher/chat/wake/effect/c;", "recordingSpectrumController", "Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController;", "ttsMediaFocusController$delegate", "k4", "()Lcom/stepos/ailauncher/chat/media/TtsMediaFocusController;", "ttsMediaFocusController", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "floatCardContainer", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "LG4/h;", "floatCardHost", "LG4/h;", "aiWaitingBar", "aiWaitingStop", "Landroid/widget/TextView;", "aiWaitingText", "Landroid/widget/TextView;", "aiWakeWaiting", "asrFinalizing", "Ljava/lang/Runnable;", "pendingSyncRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/ailauncher/chat/wake/q;", "halfPopupSendCoordinator", "Lcom/stepos/ailauncher/chat/wake/q;", "Lcom/stepos/ailauncher/chat/view/sla/a$b;", "pendingUserMessageExpand", "Lcom/stepos/ailauncher/chat/view/sla/a$b;", "readyUserMessageTraceId", "Ljava/lang/String;", UxipConstants.f30680s, "currentState", "Lcom/stepos/ailauncher/chat/wake/J;", "K5", "screenHeightPx", "I", "screenWidthPx", "Landroidx/dynamicanimation/animation/i;", "chatHeightAnim", "Landroidx/dynamicanimation/animation/i;", "translationYAnim", "dragStartY", "F", "dragStartChatHeight", "isDragging", "Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/view/VelocityTracker;", "inputDragStartY", "inputDragStartChatH", "inputDragging", "inputDragVelocityTracker", "Landroid/view/GestureDetector;", "flingDetector$delegate", "f4", "()Landroid/view/GestureDetector;", "flingDetector", "navigatingToChat", "skipSessionReset", "deferredNavigatePending", "deferredNavigateTimeoutMs", "deferredNavigateTimeout", "hasPendingSend", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter;", "chatMessageAdapter", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter;", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "slaController", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "keyboardLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "navigationHeight", "Lcom/stepos/common/animator/SurroundShaderLayout;", "surroundShaderLayout", "Lcom/stepos/common/animator/SurroundShaderLayout;", "vBottomView", "onViewInitialized", "getOnViewInitialized", "()Lp9/a;", "setOnViewInitialized", "Lcom/stepos/ailauncher/chat/wake/circle/CircleSelectController;", "circleSelectController", "Lcom/stepos/ailauncher/chat/wake/circle/CircleSelectController;", "onCancelSilentCapture", "getOnCancelSilentCapture", "L5", "touchBlockerView", "Landroid/view/WindowManager;", "touchBlockerWindowManager$delegate", "j4", "()Landroid/view/WindowManager;", "touchBlockerWindowManager", "windowShrunkToPanel", "flagsBeforeShrink", "Ljava/lang/Integer;", "dismissingWithAnim", "voiceGloballyStoppedForDismiss", "skipEntranceAnim", "currentStartSource", "aiKeyLongClickGeneration", "com/stepos/ailauncher/chat/wake/WakeDialogImpl$j", "screenOffReceiver", "Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl$j;", "screenOffReceiverRegistered", "lockscreenKeepScreenOnApplied", "userPresentReceiverRegistered", "Lcom/stepos/ailauncher/chat/util/g;", "keepScreenOnController$delegate", "g4", "()Lcom/stepos/ailauncher/chat/util/g;", "keepScreenOnController", "com/stepos/ailauncher/chat/wake/WakeDialogImpl$o", "userPresentReceiver", "Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl$o;", "lastPhoneCallState", "com/stepos/ailauncher/chat/wake/WakeDialogImpl$h", "phoneStateCallback", "Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl$h;", "phoneStateCallbackRegistered", "Lcom/stepos/ailauncher/chat/wake/l;", "answeredCallWatcher", "Lcom/stepos/ailauncher/chat/wake/l;", "TAG$1", "TAG", "com/stepos/ailauncher/chat/wake/WakeDialogImpl$e", "chatHeightProperty", "Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl$e;", "chatBgFadeThresholdPx$delegate", "c4", "chatBgFadeThresholdPx", "chatStrokeFadeThresholdPx$delegate", "d4", "chatStrokeFadeThresholdPx", "Lcom/stepos/ailauncher/chat/wake/Z;", "blurController", "Lcom/stepos/ailauncher/chat/wake/Z;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "blurSyncListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "llInputMain", "Ly7/E;", "chatPanelBlurHandle", "Ly7/E;", "Landroid/graphics/drawable/Drawable;", "chatPanelOriginalForeground", "Landroid/graphics/drawable/Drawable;", "aiWaitingBarGlassHandle", "inputBarStrokeTarget", "inputBarStrokeOriginalForeground", "blurAnchorTopY", "blurAnchorBottomY", "lastChatHeightForBlur", "CHAT_PANEL_CORNER_DP", "INPUT_BAR_CORNER_DP", "Lcom/stepos/agentframework/AgentUIConfig;", "savedAgentUiConfig", "Lcom/stepos/agentframework/AgentUIConfig;", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "activeTaskSnapshot", "Ljava/util/List;", "com/stepos/ailauncher/chat/wake/WakeDialogImpl$taskCardCallback$1", "taskCardCallback", "Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl$taskCardCallback$1;", "refreshTask", "latestKeyboardHeightForInsets", "latestEffectiveKeyboardHeight", "latestStatusBarTop", "keyboardShowing", "imeAnimationRunning", "panelTranslationYAtImeStart", "panelTranslationYImeTarget", "vBottomTranslationAtImeStart", "vBottomTranslationImeTarget", "noAnimImeSettleGeneration", "pendingImeSyncedDismiss", "panelDismissTravelTarget", "dismissImeHideEngaged", "imeSyncFallbackRunnable", "swipeOriginInDragArea", "swipeMinY", "swipeHasDownwardReversal", "restoreDragBarTintRunnable", "Lcom/stepos/ailauncher/chat/wake/U;", "suggestCardEventHandler", "Lcom/stepos/ailauncher/chat/wake/U;", "currentSuggestCardId", "pendingFileIdForMapping", "e4", "()F", "density", "LUa/M;", "i4", "()LUa/M;", "scope", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes3.dex */
public final class WakeDialogImpl extends DialogC3116e0 {
    private static final int DIRECTION_REVERSAL_SLOP_DP = 8;
    private static final int DRAG_SLOP_DP = 4;
    private static final boolean ENABLE_SPECTRUM_BORDER = false;
    public static final String EXTRA_EXTERNAL_AGENT_TYPE = "wake_external_agent_type";
    public static final String EXTRA_EXTERNAL_DEVICE_ID = "wake_external_device_id";
    public static final String EXTRA_EXTERNAL_DEVICE_NAME = "wake_external_device_name";
    public static final String EXTRA_EXTERNAL_DEVICE_ONLINE = "wake_external_device_online";
    public static final String EXTRA_EXTERNAL_SESSION_ID = "wake_external_session_id";
    public static final String EXTRA_REBIND_SESSION = "wake_rebind_session";
    private static final float FAST_SWIPE_VELOCITY_PX_PER_SEC = 650.0f;
    private static final int FULL_TOP_PADDING_DP = 49;
    private static final int FULL_TRIGGER_GAP_DP = 8;
    private static final int GLASS_MEDIUM_CORNER_DP = 24;
    private static final int HALF_CHAT_HEIGHT_DP = 424;
    private static final int HALF_KEYBOARD_STATUS_BAR_GAP_DP = 30;
    private static final long IME_SYNC_FALLBACK_MS = 50;
    private static final int INPUT_KEYBOARD_GAP_PX = 18;
    private static final long LOCKSCREEN_KEEP_SCREEN_ON_TIMEOUT_MS = 120000;
    public static final String MSG_SOURCE_AI_WAKE = "ai_wake";
    private static final long SCRIM_FADE_IN_DURATION_MS = 333;
    private static final long SCRIM_FADE_OUT_DURATION_MS = 250;
    private static final float SCRIM_TARGET_ALPHA = 0.7f;
    private static final long SPECTRUM_BORDER_DURATION_MS = 3500;
    private static final long SPECTRUM_BORDER_FADE_OUT_MS = 1500;
    private static final float SPRING_DAMPING_NORMAL = 0.88f;
    private static final float SPRING_STIFFNESS_KEYBOARD = 1500.0f;
    private static final float SPRING_STIFFNESS_NORMAL = 340.0f;
    private static final String TAG = "WakeDialogImpl";
    private static final long TTS_HANDOFF_TIMEOUT_MS = 1500;
    private static final int WINDOW_BLUR_BEHIND_RADIUS_DP = 30;
    private static volatile boolean aiWaitingBarShowing;
    private static volatile long ttsHandoffUntil;
    private final int CHAT_PANEL_CORNER_DP;
    private final int INPUT_BAR_CORNER_DP;

    /* renamed from: TAG$1, reason: from kotlin metadata */
    private final String TAG;
    private List<UiTask> activeTaskSnapshot;
    private Activity activity;
    private long aiKeyLongClickGeneration;
    private View aiWaitingBar;
    private y7.E aiWaitingBarGlassHandle;
    private View aiWaitingStop;
    private TextView aiWaitingText;
    private boolean aiWakeWaiting;
    private final C3140l answeredCallWatcher;
    private boolean asrFinalizing;
    private int blurAnchorBottomY;
    private int blurAnchorTopY;
    private Z blurController;
    private ViewTreeObserver.OnPreDrawListener blurSyncListener;

    /* renamed from: chatBgFadeThresholdPx$delegate, reason: from kotlin metadata */
    private final Y8.h chatBgFadeThresholdPx;
    private androidx.dynamicanimation.animation.i chatHeightAnim;
    private final e chatHeightProperty;
    private LauncherChatLayout chatLayout;
    private ChatMessageAdapter chatMessageAdapter;
    private y7.E chatPanelBlurHandle;
    private Drawable chatPanelOriginalForeground;
    private View chatPanelWrapper;

    /* renamed from: chatStrokeFadeThresholdPx$delegate, reason: from kotlin metadata */
    private final Y8.h chatStrokeFadeThresholdPx;
    private CircleSelectController circleSelectController;
    private String currentStartSource;
    private J currentState;
    private String currentSuggestCardId;
    private boolean deferredNavigatePending;
    private final Runnable deferredNavigateTimeout;
    private final long deferredNavigateTimeoutMs;
    private boolean dismissImeHideEngaged;
    private boolean dismissingWithAnim;
    private View dragBar;
    private ConstraintLayout dragHandleArea;
    private int dragStartChatHeight;
    private float dragStartY;
    private final boolean enableCircleSelect;
    private Integer flagsBeforeShrink;

    /* renamed from: flingDetector$delegate, reason: from kotlin metadata */
    private final Y8.h flingDetector;
    private FloatCardContainerView floatCardContainer;
    private G4.h floatCardHost;
    private final C3155q halfPopupSendCoordinator;
    private boolean hasPendingSend;
    private boolean imeAnimationRunning;
    private Runnable imeSyncFallbackRunnable;
    private Drawable inputBarStrokeOriginalForeground;
    private View inputBarStrokeTarget;
    private int inputDragStartChatH;
    private float inputDragStartY;
    private VelocityTracker inputDragVelocityTracker;
    private boolean inputDragging;
    private BaseInputView inputView;
    private boolean isDragging;

    /* renamed from: keepScreenOnController$delegate, reason: from kotlin metadata */
    private final Y8.h keepScreenOnController;
    private ViewTreeObserver.OnGlobalLayoutListener keyboardLayoutListener;
    private boolean keyboardShowing;
    private int lastChatHeightForBlur;
    private Integer lastPhoneCallState;
    private int latestEffectiveKeyboardHeight;
    private Integer latestKeyboardHeightForInsets;
    private int latestStatusBarTop;
    private View llInputMain;
    private boolean lockscreenKeepScreenOnApplied;
    private boolean navigatingToChat;
    private int navigationHeight;
    private int noAnimImeSettleGeneration;
    private InterfaceC5063a<Y8.t> onCancelSilentCapture;
    private final InterfaceC5063a<Y8.t> onDismissed;
    private InterfaceC5063a<Y8.t> onViewInitialized;
    private float panelDismissTravelTarget;
    private float panelTranslationYAtImeStart;
    private float panelTranslationYImeTarget;
    private View panelView;
    private String pendingFileIdForMapping;
    private boolean pendingImeSyncedDismiss;
    private Runnable pendingSyncRunnable;
    private a.Expand pendingUserMessageExpand;
    private final h phoneStateCallback;
    private boolean phoneStateCallbackRegistered;
    private String readyUserMessageTraceId;

    /* renamed from: recordingSpectrumController$delegate, reason: from kotlin metadata */
    private final Y8.h recordingSpectrumController;
    private final Runnable refreshTask;
    private final Runnable restoreDragBarTintRunnable;
    private View rootView;
    private View sBottomSpace;
    private AgentUIConfig savedAgentUiConfig;
    private int screenHeightPx;
    private final j screenOffReceiver;
    private boolean screenOffReceiverRegistered;
    private int screenWidthPx;
    private View scrimView;
    private SessionHandler sessionHandler;
    private long showStartMs;
    private boolean skipEntranceAnim;
    private boolean skipSessionReset;
    private SlaChatController slaController;
    private com.stepos.ailauncher.chat.wake.effect.g spectrumBorder;
    private U suggestCardEventHandler;
    private SurroundShaderLayout surroundShaderLayout;
    private boolean swipeHasDownwardReversal;
    private float swipeMinY;
    private boolean swipeOriginInDragArea;
    private final WakeDialogImpl$taskCardCallback$1 taskCardCallback;
    private View touchBlockerView;

    /* renamed from: touchBlockerWindowManager$delegate, reason: from kotlin metadata */
    private final Y8.h touchBlockerWindowManager;
    private androidx.dynamicanimation.animation.i translationYAnim;

    /* renamed from: ttsMediaFocusController$delegate, reason: from kotlin metadata */
    private final Y8.h ttsMediaFocusController;
    private final o userPresentReceiver;
    private boolean userPresentReceiverRegistered;
    private float vBottomTranslationAtImeStart;
    private float vBottomTranslationImeTarget;
    private View vBottomView;
    private VelocityTracker velocityTracker;
    private boolean voiceGloballyStoppedForDismiss;
    private boolean windowShrunkToPanel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> MSG_SOURCE_AI_WAKE_WHITELIST = Z8.Y.j("ai_key_click", C4814a.AI_KEY_CLICK2, C4814a.AI_KEY_LONG_CLICK_START, C4814a.AI_KEY_LONG_CLICK_END, C4814a.HOME_KEY_LONG_CLICK, C4814a.BOTTOM_BAR_KEY_LONG_CLICK, "voice_wakeup", C4814a.HEADSET_WAKEUP, "home");
    private static final Set<String> START_RECORD_SOURCES = Z8.Y.j(C4814a.AI_KEY_LONG_CLICK_START, C4814a.AI_KEY_LONG_CLICK_END, "voice_wakeup", C4814a.HEADSET_WAKEUP);
    private static final int[] INPUT_BAR_STROKE_GRADIENT = {-2130730912, 866169087, -2130730912};
    private static final int INPUT_BAR_STROKE_SOLID_COLOR = 872415231;
    private static final Set<String> SPECTRUM_BORDER_ENTRANCE_SOURCES = Z8.Y.j("ai_key_click", C4814a.AI_KEY_CLICK2, C4814a.AI_KEY_LONG_CLICK_START, "voice_wakeup", C4814a.HEADSET_WAKEUP, C4814a.HOME_KEY_LONG_CLICK, C4814a.BOTTOM_BAR_KEY_LONG_CLICK);
    private static final SpectrumBorderConfig SPECTRUM_BORDER_CONFIG = SpectrumBorderConfig.INSTANCE.a();
    private static final PathInterpolator SCRIM_INTERPOLATOR = new PathInterpolator(0.3f, 0.0f, 0.7f, 1.0f);
    private static final int DRAG_BAR_COLOR_DEFAULT = -2139720064;
    private static final int DRAG_BAR_COLOR_ON_SCRIM = -2139720064;

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0015R\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0015R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0011R\u0014\u0010&\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010+\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010,R\u0014\u00100\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010,R\u0014\u00101\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010,R\u0014\u00102\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010'R\u0014\u00103\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010,R\u0014\u00104\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010,R\u0014\u00105\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010,R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020*8\u0002X\u0082D¢\u0006\u0006\n\u0004\b9\u0010,R\u0014\u0010:\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010\"R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0011R\u0014\u0010<\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010\u0019R\u0014\u0010=\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010\u0019R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010'R\u0014\u0010B\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010\u0019R\u0014\u0010C\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010\u0019R\u0014\u0010D\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010\u0019R\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020*8\u0002X\u0082D¢\u0006\u0006\n\u0004\bH\u0010,R\u0014\u0010I\u001a\u00020*8\u0002X\u0082D¢\u0006\u0006\n\u0004\bI\u0010,¨\u0006J"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/WakeDialogImpl$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "", "e", "()Z", Const.INTENT_KEY_UMID, "", "source", "f", "(Ljava/lang/String;)Z", "", "MSG_SOURCE_AI_WAKE_WHITELIST", "Ljava/util/Set;", "c", "()Ljava/util/Set;", "TAG", "Ljava/lang/String;", "EXTRA_REBIND_SESSION", "", "ttsHandoffUntil", "J", "TTS_HANDOFF_TIMEOUT_MS", "LOCKSCREEN_KEEP_SCREEN_ON_TIMEOUT_MS", "EXTRA_EXTERNAL_DEVICE_ID", "EXTRA_EXTERNAL_AGENT_TYPE", "EXTRA_EXTERNAL_SESSION_ID", "EXTRA_EXTERNAL_DEVICE_NAME", "EXTRA_EXTERNAL_DEVICE_ONLINE", "aiWaitingBarShowing", "Z", "MSG_SOURCE_AI_WAKE", "START_RECORD_SOURCES", "", "SPRING_DAMPING_NORMAL", "F", "SPRING_STIFFNESS_NORMAL", "SPRING_STIFFNESS_KEYBOARD", "", "HALF_CHAT_HEIGHT_DP", "I", "FULL_TOP_PADDING_DP", "HALF_KEYBOARD_STATUS_BAR_GAP_DP", "INPUT_KEYBOARD_GAP_PX", "FULL_TRIGGER_GAP_DP", "DRAG_SLOP_DP", "FAST_SWIPE_VELOCITY_PX_PER_SEC", "DIRECTION_REVERSAL_SLOP_DP", "WINDOW_BLUR_BEHIND_RADIUS_DP", "GLASS_MEDIUM_CORNER_DP", "", "INPUT_BAR_STROKE_GRADIENT", "[I", "INPUT_BAR_STROKE_SOLID_COLOR", "ENABLE_SPECTRUM_BORDER", "SPECTRUM_BORDER_ENTRANCE_SOURCES", "SPECTRUM_BORDER_DURATION_MS", "SPECTRUM_BORDER_FADE_OUT_MS", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "SPECTRUM_BORDER_CONFIG", "Lcom/stepos/ailauncher/chat/wake/effect/d;", "SCRIM_TARGET_ALPHA", "SCRIM_FADE_IN_DURATION_MS", "SCRIM_FADE_OUT_DURATION_MS", "IME_SYNC_FALLBACK_MS", "Landroid/view/animation/PathInterpolator;", "SCRIM_INTERPOLATOR", "Landroid/view/animation/PathInterpolator;", "DRAG_BAR_COLOR_DEFAULT", "DRAG_BAR_COLOR_ON_SCRIM", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.WakeDialogImpl$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a() {
            WakeDialogImpl.ttsHandoffUntil = SystemClock.elapsedRealtime() + 1500;
        }

        public final void b() {
            WakeDialogImpl.ttsHandoffUntil = 0L;
        }

        public final Set<String> c() {
            return WakeDialogImpl.MSG_SOURCE_AI_WAKE_WHITELIST;
        }

        public final boolean d() {
            return WakeDialogImpl.aiWaitingBarShowing;
        }

        public final boolean e() {
            return SystemClock.elapsedRealtime() < WakeDialogImpl.ttsHandoffUntil;
        }

        public final boolean f(String source) {
            return (source == null || source.length() == 0 || !c().contains(source)) ? false : true;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$b", "Lcom/stepos/agentframework/chatui/AgentChatLayout$b;", "", "show", "", "insetBottom", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ZI)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements AgentChatLayout.InterfaceC1970b {
        final /* synthetic */ Integer $originPaddingBottom;

        public b(Integer num) {
            this.$originPaddingBottom = num;
        }

        @Override // com.stepos.agentframework.chatui.AgentChatLayout.InterfaceC1970b
        public void a(boolean show, int insetBottom) {
            O6.b bVar = O6.b.INSTANCE;
            Context context = WakeDialogImpl.this.getContext();
            kotlin.jvm.internal.p.f(context);
            bVar.a(context);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Runnable {
        final /* synthetic */ View $this_doOnPreDraw;
        final /* synthetic */ WakeDialogImpl this$0;

        public c(View view, WakeDialogImpl wakeDialogImpl) {
            this.$this_doOnPreDraw = view;
            this.this$0 = wakeDialogImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.this$0.q6("doOnPreDraw fired -> playEntranceAnim");
            this.this$0.m5();
            this.this$0.i3();
            this.this$0.q6("attachAiWaitingBarGlass done -> end of doOnPreDraw");
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$d", "Lcom/stepos/agentframework/chatcore/session/AgentSession$f;", "Lcom/stepos/agentframework/chatcore/session/ESessionStatus;", "status", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/ESessionStatus;)V", "", "sessionId", "", "Lw4/c;", "messages", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements AgentSession.f {
        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        public void a(ESessionStatus status) {
            kotlin.jvm.internal.p.i(status, "status");
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        public void b(String sessionId, List<ChatMessage> messages) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(messages, "messages");
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.f
        public void i(AgentError e10) {
            kotlin.jvm.internal.p.i(e10, "e");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$e", "Landroidx/dynamicanimation/animation/f;", "Landroid/view/View;", "view", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)F", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends androidx.dynamicanimation.animation.f<View> {
        public e() {
            super("chatHeight");
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            return view.getLayoutParams().height;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View view, float value) {
            kotlin.jvm.internal.p.i(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            int iF = C5685n.f((int) value, 0);
            if (layoutParams.height != iF) {
                layoutParams.height = iF;
                view.setLayoutParams(layoutParams);
            }
            WakeDialogImpl.this.z6(iF);
            WakeDialogImpl.this.k6(iF);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$f", "Lcom/stepos/agentframework/chatui/T1$a;", "LY8/t;", "onPlayStarted", "()V", "onPlayStopped", "", "code", "message", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements T1.a {
        public f() {
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void a(String code, String message) {
            kotlin.jvm.internal.p.i(code, "code");
            kotlin.jvm.internal.p.i(message, "message");
            WakeDialogImpl.this.k4().c0();
            WakeDialogImpl.this.g4().l("tts");
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public /* bridge */ void b(String str) {
            super.b(str);
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void onPlayStarted() {
            WakeDialogImpl.this.k4().t();
            WakeDialogImpl.this.g4().f("tts", 300000L);
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void onPlayStopped() {
            WakeDialogImpl.this.k4().c0();
            WakeDialogImpl.this.g4().l("tts");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$g", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "(Landroid/view/MotionEvent;)Z", "e1", "e2", "", "velocityX", "velocityY", "onFling", "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends GestureDetector.SimpleOnGestureListener {
        public g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e10) {
            kotlin.jvm.internal.p.i(e10, "e");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e12, MotionEvent e22, float velocityX, float velocityY) {
            kotlin.jvm.internal.p.i(e22, "e2");
            Float fValueOf = e12 != null ? Float.valueOf(e12.getRawY()) : null;
            float rawY = e22.getRawY();
            if (WakeDialogImpl.this.navigatingToChat || fValueOf == null) {
                return false;
            }
            boolean z10 = velocityY < 0.0f;
            boolean z11 = rawY < fValueOf.floatValue();
            boolean z12 = Math.abs(velocityY) >= WakeDialogImpl.FAST_SWIPE_VELOCITY_PX_PER_SEC;
            boolean z13 = Math.abs(velocityY) > Math.abs(velocityX);
            boolean zN4 = WakeDialogImpl.this.N4();
            boolean z14 = z10 && z11 && z12 && z13 && zN4;
            C4148a.d(WakeDialogImpl.this.TAG, "flingDetector.onFling: isSwipeUp=" + z14 + " [upV=" + z10 + " upD=" + z11 + " fast=" + z12 + " vert=" + z13 + " strictUp=" + zN4 + "] vY=" + velocityY + " vX=" + velocityX + " startY=" + fValueOf + " endY=" + rawY, false, 4, null);
            if (!z14) {
                return false;
            }
            WakeDialogImpl.this.Y3();
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$h", "Landroid/telephony/TelephonyCallback;", "Landroid/telephony/TelephonyCallback$CallStateListener;", "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onCallStateChanged", "(I)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        public h() {
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int state) {
            Integer num = WakeDialogImpl.this.lastPhoneCallState;
            WakeDialogImpl.this.lastPhoneCallState = Integer.valueOf(state);
            boolean z10 = (num == null || state != 2 || num.intValue() == 2) ? false : true;
            C4148a.k(MicOccupancyMonitor.CALL_LISTEN, "wakeDialog telephony prev=" + num + " state=" + state + " becameOffHook=" + z10 + " showing=" + WakeDialogImpl.this.isShowing(), false, 4, null);
            MicOccupancyMonitor micOccupancyMonitor = MicOccupancyMonitor.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("wakeDialog telephony state=");
            sb2.append(state);
            micOccupancyMonitor.w(sb2.toString());
            if (z10) {
                C4148a.k(WakeDialogImpl.this.TAG, "phoneStateCallback: prev=" + num + " state=" + state + " showing=" + WakeDialogImpl.this.isShowing() + " -> dismiss (AIOSBUG-15752)", false, 4, null);
                WakeDialogImpl.this.G3("telephony");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$i", "Lcom/stepos/agentframework/chatui/T1$a;", "LY8/t;", "onPlayStopped", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i implements T1.a {
        final /* synthetic */ TtsMediaFocusController $focusCtrl;
        final /* synthetic */ LauncherChatLayout $layout;

        public i(TtsMediaFocusController ttsMediaFocusController, LauncherChatLayout launcherChatLayout) {
            this.$focusCtrl = ttsMediaFocusController;
            this.$layout = launcherChatLayout;
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public /* bridge */ void a(String str, String str2) {
            super.a(str, str2);
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public /* bridge */ void b(String str) {
            super.b(str);
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public /* bridge */ void onPlayStarted() {
            super.onPlayStarted();
        }

        @Override // com.stepos.agentframework.chatui.T1.a
        public void onPlayStopped() {
            this.$focusCtrl.c0();
            if (this.$layout.getTtsPlayerListener() == this) {
                this.$layout.setTtsPlayerListener(null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$j", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class j extends BroadcastReceiver {
        public j() {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(android.content.Context r6, android.content.Intent r7) {
            /*
                r5 = this;
                r6 = 0
                if (r7 == 0) goto L8
                java.lang.String r7 = r7.getAction()
                goto L9
            L8:
                r7 = r6
            L9:
                java.lang.String r0 = "android.intent.action.SCREEN_OFF"
                boolean r7 = kotlin.jvm.internal.p.d(r7, r0)
                if (r7 != 0) goto L12
                goto L1a
            L12:
                com.stepos.ailauncher.chat.wake.WakeDialogImpl r7 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.this
                boolean r7 = r7.isShowing()
                if (r7 != 0) goto L1b
            L1a:
                return
            L1b:
                com.stepos.ailauncher.chat.wake.WakeDialogImpl r7 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.this
                com.stepos.ailauncher.chat.view.BaseInputView r7 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.O1(r7)
                r0 = 0
                if (r7 == 0) goto L3a
                com.stepos.ailauncher.chat.wake.WakeDialogImpl r7 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.this
                com.stepos.ailauncher.chat.view.BaseInputView r7 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.O1(r7)
                if (r7 != 0) goto L32
                java.lang.String r7 = "inputView"
                kotlin.jvm.internal.p.A(r7)
                r7 = r6
            L32:
                boolean r7 = r7.a8()
                if (r7 == 0) goto L3a
                r7 = 1
                goto L3b
            L3a:
                r7 = r0
            L3b:
                com.stepos.ailauncher.chat.wake.WakeDialogImpl r1 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.this
                java.lang.String r1 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.d2(r1)
                com.stepos.ailauncher.chat.wake.WakeDialogImpl r2 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.this
                com.stepos.ailauncher.chat.wake.J r2 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.J1(r2)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "screenOffReceiver: state="
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = " recording="
                r3.append(r2)
                r3.append(r7)
                java.lang.String r7 = " -> dismissNoAnim"
                r3.append(r7)
                java.lang.String r7 = r3.toString()
                r2 = 4
                h8.C4148a.d(r1, r7, r0, r2, r6)
                com.stepos.ailauncher.chat.wake.WakeDialogImpl r5 = com.stepos.ailauncher.chat.wake.WakeDialogImpl.this
                java.lang.String r6 = "screen_lock"
                r5.H3(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeDialogImpl.j.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$k", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "LY8/t;", "c", "(Landroidx/core/view/Z;)V", "Landroidx/core/view/Z$a;", "bounds", "e", "(Landroidx/core/view/Z;Landroidx/core/view/Z$a;)Landroidx/core/view/Z$a;", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class k extends Z.b {
        public k() {
            super(1);
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) != 0 && WakeDialogImpl.this.imeAnimationRunning) {
                WakeDialogImpl.this.imeAnimationRunning = false;
                View view = WakeDialogImpl.this.panelView;
                if (view == null) {
                    kotlin.jvm.internal.p.A("panelView");
                    view = null;
                }
                view.setTranslationY(WakeDialogImpl.this.panelTranslationYImeTarget);
                View view2 = WakeDialogImpl.this.vBottomView;
                if (view2 != null) {
                    view2.setTranslationY(WakeDialogImpl.this.vBottomTranslationImeTarget);
                }
                if (WakeDialogImpl.this.dismissImeHideEngaged) {
                    WakeDialogImpl.this.dismissImeHideEngaged = false;
                    WakeDialogImpl.p5(WakeDialogImpl.this, null, 1, null);
                }
            }
        }

        @Override // androidx.core.view.Z.b
        public void c(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) == 0) {
                return;
            }
            boolean z10 = WakeDialogImpl.this.dismissingWithAnim && WakeDialogImpl.this.pendingImeSyncedDismiss;
            if (!WakeDialogImpl.this.dismissingWithAnim || z10) {
                View view = null;
                if (z10) {
                    Runnable runnable = WakeDialogImpl.this.imeSyncFallbackRunnable;
                    if (runnable != null) {
                        View view2 = WakeDialogImpl.this.rootView;
                        if (view2 == null) {
                            kotlin.jvm.internal.p.A("rootView");
                            view2 = null;
                        }
                        view2.removeCallbacks(runnable);
                    }
                    WakeDialogImpl.this.imeSyncFallbackRunnable = null;
                    WakeDialogImpl.this.dismissImeHideEngaged = true;
                }
                androidx.dynamicanimation.animation.i iVar = WakeDialogImpl.this.translationYAnim;
                if (iVar != null) {
                    iVar.d();
                }
                WakeDialogImpl.this.translationYAnim = null;
                WakeDialogImpl.this.imeAnimationRunning = true;
                WakeDialogImpl.this.t3();
                WakeDialogImpl wakeDialogImpl = WakeDialogImpl.this;
                View view3 = wakeDialogImpl.panelView;
                if (view3 == null) {
                    kotlin.jvm.internal.p.A("panelView");
                } else {
                    view = view3;
                }
                wakeDialogImpl.panelTranslationYAtImeStart = view.getTranslationY();
                WakeDialogImpl wakeDialogImpl2 = WakeDialogImpl.this;
                View view4 = wakeDialogImpl2.vBottomView;
                wakeDialogImpl2.vBottomTranslationAtImeStart = view4 != null ? view4.getTranslationY() : 0.0f;
            }
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) {
            View view;
            Object next;
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            if (WakeDialogImpl.this.imeAnimationRunning) {
                Iterator<T> it = runningAnimations.iterator();
                while (true) {
                    view = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if ((((androidx.core.view.Z) next).d() & a0.o.b()) != 0) {
                        break;
                    }
                }
                androidx.core.view.Z z10 = (androidx.core.view.Z) next;
                if (z10 != null) {
                    float fC = z10.c();
                    View view2 = WakeDialogImpl.this.panelView;
                    if (view2 == null) {
                        kotlin.jvm.internal.p.A("panelView");
                    } else {
                        view = view2;
                    }
                    view.setTranslationY(WakeDialogImpl.this.panelTranslationYAtImeStart + ((WakeDialogImpl.this.panelTranslationYImeTarget - WakeDialogImpl.this.panelTranslationYAtImeStart) * fC));
                    View view3 = WakeDialogImpl.this.vBottomView;
                    if (view3 != null) {
                        view3.setTranslationY(WakeDialogImpl.this.vBottomTranslationAtImeStart + ((WakeDialogImpl.this.vBottomTranslationImeTarget - WakeDialogImpl.this.vBottomTranslationAtImeStart) * fC));
                    }
                }
            }
            return insets;
        }

        @Override // androidx.core.view.Z.b
        public Z.a e(androidx.core.view.Z animation, Z.a bounds) {
            kotlin.jvm.internal.p.i(animation, "animation");
            kotlin.jvm.internal.p.i(bounds, "bounds");
            if ((animation.d() & a0.o.b()) != 0) {
                boolean z10 = WakeDialogImpl.this.dismissingWithAnim && WakeDialogImpl.this.pendingImeSyncedDismiss;
                if (!WakeDialogImpl.this.dismissingWithAnim || z10) {
                    if (!z10) {
                        WakeDialogImpl wakeDialogImpl = WakeDialogImpl.this;
                        wakeDialogImpl.panelTranslationYImeTarget = wakeDialogImpl.y3(wakeDialogImpl.latestEffectiveKeyboardHeight, WakeDialogImpl.this.latestStatusBarTop);
                        WakeDialogImpl.this.vBottomTranslationImeTarget = -(WakeDialogImpl.this.latestKeyboardHeightForInsets != null ? r4.intValue() : 0);
                        return bounds;
                    }
                    WakeDialogImpl wakeDialogImpl2 = WakeDialogImpl.this;
                    wakeDialogImpl2.panelTranslationYImeTarget = wakeDialogImpl2.panelDismissTravelTarget;
                    WakeDialogImpl wakeDialogImpl3 = WakeDialogImpl.this;
                    wakeDialogImpl3.vBottomTranslationImeTarget = wakeDialogImpl3.panelDismissTravelTarget;
                    WakeDialogImpl.this.pendingImeSyncedDismiss = false;
                    return bounds;
                }
            }
            return bounds;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class l implements Runnable {
        final /* synthetic */ InterfaceC5063a $start$inlined;
        final /* synthetic */ View $this_doOnPreDraw;
        final /* synthetic */ WakeDialogImpl this$0;

        public l(View view, WakeDialogImpl wakeDialogImpl, InterfaceC5063a interfaceC5063a) {
            this.$this_doOnPreDraw = view;
            this.this$0 = wakeDialogImpl;
            this.$start$inlined = interfaceC5063a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.this$0.e6(this.$start$inlined);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class m implements Runnable {
        final /* synthetic */ InterfaceC5063a $start$inlined;
        final /* synthetic */ View $this_doOnPreDraw;
        final /* synthetic */ WakeDialogImpl this$0;

        public m(View view, WakeDialogImpl wakeDialogImpl, InterfaceC5063a interfaceC5063a) {
            this.$this_doOnPreDraw = view;
            this.this$0 = wakeDialogImpl;
            this.$start$inlined = interfaceC5063a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.this$0.e6(this.$start$inlined);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$n", "Landroidx/dynamicanimation/animation/e$q;", "Landroidx/dynamicanimation/animation/e;", "animation", "", "canceled", "", UxipConstants.f30680s, "velocity", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/dynamicanimation/animation/e;ZFF)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class n implements e.q {
        final /* synthetic */ InterfaceC5063a<Y8.t> $start;

        public n(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$start = interfaceC5063a;
        }

        @Override // androidx.dynamicanimation.animation.e.q
        public void a(androidx.dynamicanimation.animation.e<?> animation, boolean canceled, float value, float velocity) {
            kotlin.jvm.internal.p.i(animation, "animation");
            animation.j(this);
            WakeDialogImpl.this.e6(this.$start);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/wake/WakeDialogImpl$o", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class o extends BroadcastReceiver {
        public o() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.USER_PRESENT") && WakeDialogImpl.this.lockscreenKeepScreenOnApplied) {
                C4148a.k(WakeDialogImpl.this.TAG, "userPresentReceiver: user unlocked, clear lockscreen keepScreenOn", false, 4, null);
                WakeDialogImpl.this.x3();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.stepos.ailauncher.chat.wake.WakeDialogImpl$taskCardCallback$1] */
    public WakeDialogImpl(final Context context, InterfaceC5063a<Y8.t> onDismissed, boolean z10) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onDismissed, "onDismissed");
        this.onDismissed = onDismissed;
        this.enableCircleSelect = z10;
        this.recordingSpectrumController = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.h1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.q5(this.f26776a);
            }
        });
        this.ttsMediaFocusController = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.l1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.s6(context, this);
            }
        });
        this.halfPopupSendCoordinator = new C3155q();
        this.currentState = J.e.INSTANCE;
        this.flingDetector = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.m1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.a4(context, this);
            }
        });
        this.deferredNavigateTimeoutMs = 500L;
        this.deferredNavigateTimeout = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.n1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.D3(this.f26845a);
            }
        };
        this.onCancelSilentCapture = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.o1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.a5();
            }
        };
        this.touchBlockerWindowManager = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.p1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.r6(context);
            }
        });
        this.screenOffReceiver = new j();
        this.keepScreenOnController = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.q1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.O4(this.f26855a);
            }
        });
        this.userPresentReceiver = new o();
        this.phoneStateCallback = new h();
        this.answeredCallWatcher = new C3140l(context, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.r1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.P2(this.f26860a, ((Boolean) obj).booleanValue());
            }
        });
        this.TAG = TAG;
        this.chatHeightProperty = new e();
        this.chatBgFadeThresholdPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.s1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(WakeDialogImpl.u3(this.f26864a));
            }
        });
        this.chatStrokeFadeThresholdPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.u1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(WakeDialogImpl.w3(this.f26870a));
            }
        });
        this.lastChatHeightForBlur = -1;
        this.CHAT_PANEL_CORNER_DP = 16;
        this.INPUT_BAR_CORNER_DP = 32;
        this.activeTaskSnapshot = C1173v.m();
        this.taskCardCallback = new InterfaceC1452a() { // from class: com.stepos.ailauncher.chat.wake.WakeDialogImpl$taskCardCallback$1
            @Override // b6.InterfaceC1452a
            public void a(UiTask taskCard, List<UiTask> activeTasks) {
                kotlin.jvm.internal.p.i(taskCard, "taskCard");
                kotlin.jvm.internal.p.i(activeTasks, "activeTasks");
                Function2.b(new WakeDialogImpl$taskCardCallback$1$onTaskUpdate$1(this.this$0, activeTasks, null));
            }

            @Override // b6.InterfaceC1452a
            public void b(UiTask taskCard) {
                kotlin.jvm.internal.p.i(taskCard, "taskCard");
            }
        };
        this.refreshTask = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.j1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.s5(this.f26822a);
            }
        };
        this.swipeMinY = Float.MAX_VALUE;
        this.restoreDragBarTintRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.k1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.A5(this.f26829a);
            }
        };
    }

    public static final Y8.t A4(WakeDialogImpl wakeDialogImpl, boolean z10) {
        wakeDialogImpl.asrFinalizing = z10;
        wakeDialogImpl.m6(wakeDialogImpl.currentState);
        return Y8.t.f7040a;
    }

    public static final void A5(WakeDialogImpl wakeDialogImpl) {
        View view = wakeDialogImpl.scrimView;
        if (view == null) {
            kotlin.jvm.internal.p.A("scrimView");
            view = null;
        }
        if (view.getAlpha() <= 0.0f) {
            wakeDialogImpl.R2(false);
        }
    }

    public static final Y8.t B4(WakeDialogImpl wakeDialogImpl, String traceId, boolean z10) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        wakeDialogImpl.pendingUserMessageExpand = null;
        wakeDialogImpl.readyUserMessageTraceId = null;
        C4148a.d(wakeDialogImpl.TAG, "onSendRoundStarted traceId=" + traceId + " deferHalfExpansion=" + z10, false, 4, null);
        C0919o.b("INPUT_BAR", "半屏展开门禁(defer=" + z10 + ",state=" + wakeDialogImpl.currentState + ")");
        wakeDialogImpl.halfPopupSendCoordinator.c(traceId, z10);
        return Y8.t.f7040a;
    }

    public static final Y8.t C4(WakeDialogImpl wakeDialogImpl, boolean z10) {
        if (z10) {
            wakeDialogImpl.I4();
        } else {
            wakeDialogImpl.y5();
        }
        if (z10) {
            com.stepos.ailauncher.chat.wake.effect.g gVar = wakeDialogImpl.spectrumBorder;
            if (gVar != null) {
                gVar.o();
            }
            wakeDialogImpl.spectrumBorder = null;
        }
        wakeDialogImpl.h4().l(z10);
        return Y8.t.f7040a;
    }

    public static final void D3(WakeDialogImpl wakeDialogImpl) {
        if (wakeDialogImpl.deferredNavigatePending) {
            C4148a.u(wakeDialogImpl.TAG, "navigateToChatMainActivity: deferred timeout fired, proceeding", false, 4, null);
            wakeDialogImpl.deferredNavigatePending = false;
            wakeDialogImpl.X4();
        }
    }

    public static final Y8.t D4(WakeDialogImpl wakeDialogImpl, boolean z10) {
        if (z10) {
            wakeDialogImpl.I4();
        } else {
            wakeDialogImpl.y5();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t D5(WakeDialogImpl wakeDialogImpl, LauncherChatLayout launcherChatLayout) {
        C4148a.k(wakeDialogImpl.TAG, "AudioFocus lost after handoff -> stop TTS (bypass navigatingToChat)", false, 4, null);
        com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
        launcherChatLayout.p7();
        return Y8.t.f7040a;
    }

    private final void E2() {
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        BaseInputView baseInputView = null;
        Integer numValueOf = launcherChatLayout != null ? Integer.valueOf(launcherChatLayout.getPaddingBottom()) : null;
        LauncherChatLayout launcherChatLayout2 = this.chatLayout;
        if (launcherChatLayout2 != null) {
            launcherChatLayout2.setInsetsListener(new b(numValueOf));
        }
        BaseInputView baseInputView2 = this.inputView;
        if (baseInputView2 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView = baseInputView2;
        }
        baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.X0
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.F2(this.f26683a);
            }
        });
    }

    public static final Y8.t E4(WakeDialogImpl wakeDialogImpl, boolean z10) {
        wakeDialogImpl.h4().k(z10);
        return Y8.t.f7040a;
    }

    private final void E5() {
        String str = this.pendingFileIdForMapping;
        if (str == null || str.length() == 0) {
            C4148a.d(this.TAG, "saveFileIdSessionMapping: skip, fileId is null/empty", false, 4, null);
            return;
        }
        SessionHandler sessionHandler = this.sessionHandler;
        AgentSession.AgentConversation agentConversationR1 = sessionHandler != null ? sessionHandler.R1() : null;
        String strB = agentConversationR1 != null ? agentConversationR1.B() : null;
        C4148a.d(this.TAG, "saveFileIdSessionMapping: fileId=" + str + ", sessionHandler=" + (this.sessionHandler != null) + ", conversation=" + (agentConversationR1 != null) + ", sessionId=" + strB, false, 4, null);
        if (strB == null || strB.length() == 0) {
            return;
        }
        T.INSTANCE.b(str, strB);
        C4148a.d(this.TAG, "saveFileIdSessionMapping: saved fileId=" + str + " -> sessionId=" + strB, false, 4, null);
    }

    public static final void F2(WakeDialogImpl wakeDialogImpl) {
        wakeDialogImpl.W5();
    }

    public static final Y8.t F4(BaseInputView baseInputView, WakeDialogImpl wakeDialogImpl, String str) {
        com.stepos.ailauncher.chat.manager.U0 u02 = com.stepos.ailauncher.chat.manager.U0.INSTANCE;
        Context context = baseInputView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        u02.d(context);
        String strJ = u02.j();
        Context context2 = baseInputView.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        C4148a.d("WakeupDialog", "AIEngine TTSConfig: voice=" + strJ + ", volume=" + u02.i(context2), false, 4, null);
        CircleSelectController circleSelectController = wakeDialogImpl.circleSelectController;
        if (circleSelectController != null) {
            circleSelectController.B0();
        }
        boolean zB = wakeDialogImpl.halfPopupSendCoordinator.b();
        C0919o.d("INPUT_BAR", "消息已派发(立即展开=" + zB + ",state=" + wakeDialogImpl.currentState + ")", false, 4, null);
        if (zB && kotlin.jvm.internal.p.d(wakeDialogImpl.currentState, J.e.INSTANCE) && !wakeDialogImpl.aiWakeWaiting) {
            wakeDialogImpl.W3();
        }
        wakeDialogImpl.hasPendingSend = false;
        if (wakeDialogImpl.deferredNavigatePending) {
            C4148a.k(wakeDialogImpl.TAG, "onMessageSentCallback: resume deferred navigate", false, 4, null);
            wakeDialogImpl.deferredNavigatePending = false;
            baseInputView.getRootView().removeCallbacks(wakeDialogImpl.deferredNavigateTimeout);
            wakeDialogImpl.X4();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t G2(WakeDialogImpl wakeDialogImpl) {
        wakeDialogImpl.W3();
        return Y8.t.f7040a;
    }

    public static final Y8.t G4(WakeDialogImpl wakeDialogImpl, BaseInputView baseInputView) {
        wakeDialogImpl.N3();
        com.stepos.ailauncher.chat.manager.U0 u02 = com.stepos.ailauncher.chat.manager.U0.INSTANCE;
        Context context = baseInputView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        u02.d(context);
        String strJ = u02.j();
        Context context2 = baseInputView.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        C4148a.d("WakeupDialog", "AIEngine TTSConfig(pre-send): voice=" + strJ + ", volume=" + u02.i(context2), false, 4, null);
        wakeDialogImpl.hasPendingSend = true;
        return Y8.t.f7040a;
    }

    public static final void G5(final int i10, final WakeDialogImpl wakeDialogImpl, final int i11, final int i12, final int i13) {
        if (i10 != wakeDialogImpl.noAnimImeSettleGeneration) {
            return;
        }
        View view = wakeDialogImpl.rootView;
        if (view == null) {
            kotlin.jvm.internal.p.A("rootView");
            view = null;
        }
        view.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.J1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.H5(i10, wakeDialogImpl, i11, i12, i13);
            }
        });
    }

    public static final Y8.t H2(WakeDialogImpl wakeDialogImpl) {
        wakeDialogImpl.J3();
        return Y8.t.f7040a;
    }

    public static final boolean H4(WakeDialogImpl wakeDialogImpl) {
        wakeDialogImpl.O();
        return false;
    }

    public static final void H5(int i10, WakeDialogImpl wakeDialogImpl, int i11, int i12, int i13) {
        if (i10 == wakeDialogImpl.noAnimImeSettleGeneration && !wakeDialogImpl.imeAnimationRunning) {
            C4148a.d(wakeDialogImpl.TAG, "no-anim ime settle applied keyboardHeight=" + i11, false, 4, null);
            View view = wakeDialogImpl.vBottomView;
            if (view != null) {
                view.setTranslationY(-i11);
            }
            wakeDialogImpl.K2(wakeDialogImpl.y3(i12, i13), SPRING_STIFFNESS_KEYBOARD);
        }
    }

    public static final void I2(WakeDialogImpl wakeDialogImpl) {
        t0.e eVarG;
        wakeDialogImpl.q6("inputView.post fired");
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        View view = null;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        BaseInputView.id(baseInputView, null, 1, null);
        wakeDialogImpl.q6("inputView.wake() done");
        View view2 = wakeDialogImpl.rootView;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("rootView");
            view2 = null;
        }
        androidx.core.view.a0 a0VarB = androidx.core.view.N.B(view2);
        wakeDialogImpl.navigationHeight = (a0VarB == null || (eVarG = a0VarB.g(a0.o.e())) == null) ? 0 : eVarG.f41980d;
        View view3 = wakeDialogImpl.sBottomSpace;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("sBottomSpace");
            view3 = null;
        }
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = wakeDialogImpl.navigationHeight;
        view3.setLayoutParams(layoutParams);
        wakeDialogImpl.K5(J.e.INSTANCE);
        wakeDialogImpl.A6(wakeDialogImpl.currentState);
        wakeDialogImpl.q6("post: currentState=Minify + scrim animator started");
        View view4 = wakeDialogImpl.panelView;
        if (view4 == null) {
            kotlin.jvm.internal.p.A("panelView");
        } else {
            view = view4;
        }
        androidx.core.view.D.a(view, new c(view, wakeDialogImpl));
    }

    public static /* synthetic */ void I3(WakeDialogImpl wakeDialogImpl, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        wakeDialogImpl.H3(str);
    }

    public static final Y8.t J2(WakeDialogImpl wakeDialogImpl, boolean z10) {
        View view = wakeDialogImpl.scrimView;
        if (view == null) {
            kotlin.jvm.internal.p.A("scrimView");
            view = null;
        }
        view.setClickable(!z10);
        if (z10) {
            wakeDialogImpl.d6();
            View view2 = wakeDialogImpl.panelView;
            if (view2 == null) {
                kotlin.jvm.internal.p.A("panelView");
                view2 = null;
            }
            view2.setVisibility(4);
        } else {
            wakeDialogImpl.B5();
            View view3 = wakeDialogImpl.panelView;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("panelView");
                view3 = null;
            }
            view3.setVisibility(0);
        }
        C4148a.d(wakeDialogImpl.TAG, " sub dialog shown " + z10, false, 4, null);
        return Y8.t.f7040a;
    }

    public static final boolean J4(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final void K3(WakeDialogImpl wakeDialogImpl, float f10) {
        wakeDialogImpl.imeSyncFallbackRunnable = null;
        if (wakeDialogImpl.pendingImeSyncedDismiss) {
            wakeDialogImpl.pendingImeSyncedDismiss = false;
            C4148a.u(BaseInputView.WAKE_RECORD_LOG_TAG, "dismissWithAnim: IME-sync fallback fired", false, 4, null);
            wakeDialogImpl.g6(f10);
        }
    }

    public static /* synthetic */ void L2(WakeDialogImpl wakeDialogImpl, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = SPRING_STIFFNESS_NORMAL;
        }
        wakeDialogImpl.K2(f10, f11);
    }

    public static /* synthetic */ void N2(WakeDialogImpl wakeDialogImpl, J j10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        wakeDialogImpl.M2(j10, z10);
    }

    public static final void O2(WakeDialogImpl wakeDialogImpl, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10) {
            return;
        }
        wakeDialogImpl.A6(J.e.INSTANCE);
    }

    public static final boolean O3(WakeDialogImpl wakeDialogImpl) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        boolean zA8 = baseInputView.a8();
        boolean z10 = wakeDialogImpl.isShowing() && !zA8;
        C4148a.d(wakeDialogImpl.TAG, "can play TTS: " + z10 + " showing=" + wakeDialogImpl.isShowing() + " recording=" + zA8, false, 4, null);
        return z10;
    }

    public static final com.stepos.ailauncher.chat.util.g O4(final WakeDialogImpl wakeDialogImpl) {
        return new com.stepos.ailauncher.chat.util.g("WakeDialog", new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.A1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.P4(this.f26587a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.B1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.Q4(this.f26592a);
            }
        });
    }

    public static final void O5(WakeDialogImpl wakeDialogImpl, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        Integer num;
        int iIntValue;
        if (i13 - i11 != i17 - i15 && wakeDialogImpl.keyboardShowing && kotlin.jvm.internal.p.d(wakeDialogImpl.currentState, J.d.INSTANCE) && (num = wakeDialogImpl.latestKeyboardHeightForInsets) != null && (iIntValue = num.intValue()) > 0) {
            Integer numValueOf = Integer.valueOf(wakeDialogImpl.latestEffectiveKeyboardHeight);
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            }
            wakeDialogImpl.D2(iIntValue, wakeDialogImpl.latestStatusBarTop);
            if (wakeDialogImpl.imeAnimationRunning) {
                return;
            }
            wakeDialogImpl.K2(wakeDialogImpl.y3(iIntValue, wakeDialogImpl.latestStatusBarTop), SPRING_STIFFNESS_KEYBOARD);
        }
    }

    public static final Y8.t P2(WakeDialogImpl wakeDialogImpl, boolean z10) {
        wakeDialogImpl.G3(z10 ? "system-mode" : "voip-mode");
        return Y8.t.f7040a;
    }

    public static final Y8.t P3(WakeDialogImpl wakeDialogImpl) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        BaseInputView.k6(baseInputView, false, false, 3, null);
        return Y8.t.f7040a;
    }

    public static final View P4(WakeDialogImpl wakeDialogImpl) {
        View view = wakeDialogImpl.rootView;
        if (view == null) {
            return null;
        }
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.p.A("rootView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q2() {
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout == null) {
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
        String str2 = this.TAG;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        Boolean boolValueOf = Boolean.valueOf(zI);
        List<UiTask> list = this.activeTaskSnapshot;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((UiTask) it.next()).getTaskId());
        }
        String str3 = String.format("suppressForTask(half): sid=%s tempSid=%s suppress=%s active=%s", Arrays.copyOf(new Object[]{sessionId, str, boolValueOf, arrayList}, 4));
        kotlin.jvm.internal.p.h(str3, "format(...)");
        C4148a.d(str2, str3, false, 4, null);
        ChatMessageAdapter chatMessageAdapter = this.chatMessageAdapter;
        if (chatMessageAdapter != null) {
            chatMessageAdapter.L0(zI);
        }
        launcherChatLayout.setActionBarSuppressedForTask(zI);
    }

    public static final Y8.t Q3(WakeDialogImpl wakeDialogImpl, DisplayMessage m10) {
        kotlin.jvm.internal.p.i(m10, "m");
        if (m10.getRole() == AgentRole.USER) {
            C0919o.k("App·真实用户消息就绪(半屏)");
            wakeDialogImpl.k5(m10.getTraceId());
        }
        return Y8.t.f7040a;
    }

    public static final Window Q4(WakeDialogImpl wakeDialogImpl) {
        return wakeDialogImpl.getWindow();
    }

    public static final Y8.t Q5(WakeDialogImpl wakeDialogImpl, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        wakeDialogImpl.chatPanelBlurHandle = null;
        return Y8.t.f7040a;
    }

    public static final Y8.t R3(WakeDialogImpl wakeDialogImpl, DisplayMessage m10) {
        kotlin.jvm.internal.p.i(m10, "m");
        if (m10.getRole() == AgentRole.USER) {
            C0919o.k("App·用户消息真实上屏(半屏)");
            E5.b.INSTANCE.a(m10.getTraceId(), "text_display_input.start", "用户输入回显开始(半屏)");
            wakeDialogImpl.k5(m10.getTraceId());
        }
        return Y8.t.f7040a;
    }

    public static final boolean S3(WakeDialogImpl wakeDialogImpl, LauncherChatLayout launcherChatLayout) {
        ChatMessageAdapter adapter = wakeDialogImpl.chatMessageAdapter;
        if (adapter == null) {
            adapter = launcherChatLayout.getAdapter();
        }
        return adapter.G().isEmpty();
    }

    public static final void S4(int i10, WakeDialogImpl wakeDialogImpl, int i11, C5671a.C0540a builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        C5671a.C0540a c0540aP = builder.Q(i10).P(true);
        O6.d dVar = O6.d.INSTANCE;
        Context context = wakeDialogImpl.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        c0540aP.x(dVar.a(context, 16.0f)).y(Color.parseColor("#26FFFFFF")).R(i10).D(Color.parseColor("#26FFFFFF")).L(0).M(0).N(new float[]{1.25f, 1.125f, 1.0625f, 1.0f, 1.0f, 1.0f}).S(i11).T(1);
    }

    public static final boolean S5(WakeDialogImpl wakeDialogImpl, View view, MotionEvent motionEvent) {
        CircleSelectController circleSelectController;
        CircleSelectController circleSelectController2;
        if (motionEvent.getActionMasked() == 0 && (circleSelectController = wakeDialogImpl.circleSelectController) != null && circleSelectController.H0() && (circleSelectController2 = wakeDialogImpl.circleSelectController) != null) {
            circleSelectController2.B0();
        }
        wakeDialogImpl.f4().onTouchEvent(motionEvent);
        kotlin.jvm.internal.p.f(motionEvent);
        return wakeDialogImpl.l4(motionEvent);
    }

    public static final Y8.t T3(final WakeDialogImpl wakeDialogImpl, final com.stepos.ailauncher.chat.view.sla.a resolution) {
        kotlin.jvm.internal.p.i(resolution, "resolution");
        View view = null;
        if (resolution instanceof a.Expand) {
            a.Expand expand = (a.Expand) resolution;
            if (expand.getWaitForUserMessage()) {
                String str = wakeDialogImpl.readyUserMessageTraceId;
                if (str != null && (str.length() == 0 || kotlin.jvm.internal.p.d(str, expand.getTraceId()))) {
                    View view2 = wakeDialogImpl.rootView;
                    if (view2 == null) {
                        kotlin.jvm.internal.p.A("rootView");
                    } else {
                        view = view2;
                    }
                    view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.v1
                        @Override // java.lang.Runnable
                        public final void run() {
                            WakeDialogImpl.U3(this.f26874a, resolution);
                        }
                    });
                    return Y8.t.f7040a;
                }
                wakeDialogImpl.pendingUserMessageExpand = expand;
                C4148a.d(wakeDialogImpl.TAG, "onHalfPopupResolved wait user message resolution=" + resolution, false, 4, null);
                C0919o.d("INPUT_BAR", "云端回退已放行,等待真实用户消息后展开(reason=" + expand.getReason() + ")", false, 4, null);
                return Y8.t.f7040a;
            }
        }
        wakeDialogImpl.pendingUserMessageExpand = null;
        wakeDialogImpl.S2(resolution);
        return Y8.t.f7040a;
    }

    public static final Y8.t T5(View view, Ref$IntRef ref$IntRef, int i10, WakeDialogImpl wakeDialogImpl) {
        int width = view.getWidth();
        if (width > 0 && width != ref$IntRef.f34818a) {
            ref$IntRef.f34818a = width;
            Rect rect = new Rect(0, 0, width, i10);
            ConstraintLayout constraintLayout = wakeDialogImpl.dragHandleArea;
            if (constraintLayout == null) {
                kotlin.jvm.internal.p.A("dragHandleArea");
                constraintLayout = null;
            }
            view.setTouchDelegate(new TouchDelegate(rect, constraintLayout));
        }
        return Y8.t.f7040a;
    }

    public static final void U3(WakeDialogImpl wakeDialogImpl, com.stepos.ailauncher.chat.view.sla.a aVar) {
        wakeDialogImpl.S2(aVar);
    }

    public static final void U5(InterfaceC5063a interfaceC5063a, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        interfaceC5063a.invoke();
    }

    public static final boolean V5(WakeDialogImpl wakeDialogImpl, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.p.f(motionEvent);
        return wakeDialogImpl.m4(motionEvent);
    }

    private final void W5() {
        BaseInputView baseInputView = this.inputView;
        View view = null;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.setOnImeInsetsFrame(new p9.p() { // from class: com.stepos.ailauncher.chat.wake.W0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return WakeDialogImpl.X5(this.f26679a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        });
        View view2 = this.rootView;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("rootView");
            view2 = null;
        }
        androidx.core.view.N.u0(view2, new androidx.core.view.A() { // from class: com.stepos.ailauncher.chat.wake.Y0
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view3, androidx.core.view.a0 a0Var) {
                return WakeDialogImpl.Y5(this.f26684a, view3, a0Var);
            }
        });
        View view3 = this.rootView;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("rootView");
        } else {
            view = view3;
        }
        androidx.core.view.N.e0(view);
        N5();
        M5();
    }

    private final void X3(boolean show) {
    }

    public static final Y8.t X5(WakeDialogImpl wakeDialogImpl, int i10, boolean z10) {
        t0.e eVarF;
        View view = wakeDialogImpl.rootView;
        View view2 = null;
        if (view == null) {
            kotlin.jvm.internal.p.A("rootView");
            view = null;
        }
        androidx.core.view.a0 a0VarB = androidx.core.view.N.B(view);
        int iF = C5685n.f(i10 - ((a0VarB == null || (eVarF = a0VarB.f(a0.o.g())) == null) ? 0 : eVarF.f41980d), 0);
        int i11 = iF > 0 ? iF - 18 : 0;
        View view3 = wakeDialogImpl.vBottomView;
        if (view3 != null) {
            view3.setTranslationY(-iF);
        }
        androidx.dynamicanimation.animation.i iVar = wakeDialogImpl.translationYAnim;
        if (iVar == null || !iVar.i()) {
            View view4 = wakeDialogImpl.panelView;
            if (view4 == null) {
                kotlin.jvm.internal.p.A("panelView");
            } else {
                view2 = view4;
            }
            view2.setTranslationY(wakeDialogImpl.y3(i11, wakeDialogImpl.latestStatusBarTop));
        }
        return Y8.t.f7040a;
    }

    public static final void Y2(final WakeDialogImpl wakeDialogImpl, final String str, final List list, final boolean z10, final String str2) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        BaseInputView baseInputView2 = null;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        BaseInputView.id(baseInputView, null, 1, null);
        BaseInputView baseInputView3 = wakeDialogImpl.inputView;
        if (baseInputView3 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView2 = baseInputView3;
        }
        baseInputView2.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.z1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.Z2(this.f26896a, str, list, z10, str2);
            }
        }, 200L);
    }

    public static final void Y4(WakeDialogImpl wakeDialogImpl) {
        p5(wakeDialogImpl, null, 1, null);
    }

    public static final androidx.core.view.a0 Y5(WakeDialogImpl wakeDialogImpl, View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.b());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        t0.e eVarF2 = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF2, "getInsets(...)");
        int i10 = eVarF.f41980d;
        int i11 = eVarF2.f41980d;
        int i12 = i10 > i11 ? i10 - i11 : 0;
        Integer num = wakeDialogImpl.latestKeyboardHeightForInsets;
        if (num == null || i12 != num.intValue()) {
            wakeDialogImpl.latestKeyboardHeightForInsets = Integer.valueOf(i12);
            int iM3 = eVarF2.f41978b + wakeDialogImpl.M3(30);
            wakeDialogImpl.latestStatusBarTop = iM3;
            int i13 = i12 > 0 ? i12 - 18 : 0;
            wakeDialogImpl.latestEffectiveKeyboardHeight = i13;
            wakeDialogImpl.keyboardShowing = i12 > 0;
            wakeDialogImpl.T2();
            C4148a.d(wakeDialogImpl.TAG, "ime change: keyboardHeight=" + i12 + " currentState=" + wakeDialogImpl.currentState, false, 4, null);
            if (kotlin.jvm.internal.p.d(wakeDialogImpl.currentState, J.e.INSTANCE)) {
                if (i12 > 0) {
                    wakeDialogImpl.X3(true);
                } else {
                    wakeDialogImpl.X3(false);
                }
            } else if (kotlin.jvm.internal.p.d(wakeDialogImpl.currentState, J.d.INSTANCE)) {
                if (i12 > 0) {
                    wakeDialogImpl.X3(true);
                } else {
                    wakeDialogImpl.X3(false);
                }
            }
            wakeDialogImpl.D2(i13, iM3);
            wakeDialogImpl.F5(i12, i13, iM3);
        }
        return insets;
    }

    public static final void Z2(WakeDialogImpl wakeDialogImpl, String str, List list, boolean z10, String str2) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.eb(str, list, z10, str2);
    }

    public static final void Z3(WakeDialogImpl wakeDialogImpl, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        wakeDialogImpl.J5(((Integer) animatedValue).intValue());
    }

    public static final GestureDetector a4(Context context, WakeDialogImpl wakeDialogImpl) {
        return new GestureDetector(context, wakeDialogImpl.new g());
    }

    public static final Y8.t a5() {
        return Y8.t.f7040a;
    }

    public static final void b5(WakeDialogImpl wakeDialogImpl) {
        wakeDialogImpl.O();
    }

    public static final void c3(WakeDialogImpl wakeDialogImpl, String str, List list) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.G4(str, list);
    }

    public static final boolean c5() {
        return true;
    }

    public static final Y8.t c6(WakeDialogImpl wakeDialogImpl, String selectedText) {
        Editable text;
        String string;
        kotlin.jvm.internal.p.i(selectedText, "selectedText");
        if (wakeDialogImpl.inputView != null) {
            String str = wakeDialogImpl.currentSuggestCardId;
            BaseInputView baseInputView = null;
            if (str != null) {
                IFloatCardService iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
                if (iFloatCardService != null) {
                    IFloatCardService.dismiss$default(iFloatCardService, str, false, 2, null);
                }
                wakeDialogImpl.currentSuggestCardId = null;
            }
            BaseInputView baseInputView2 = wakeDialogImpl.inputView;
            if (baseInputView2 == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView2 = null;
            }
            EditText editText = (EditText) baseInputView2.findViewById(R$id.et_input_bar);
            String string2 = (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null) ? null : La.H.D1(string).toString();
            if (string2 == null) {
                string2 = "";
            }
            if (string2.length() > 0) {
                selectedText = string2 + " " + selectedText;
            }
            BaseInputView baseInputView3 = wakeDialogImpl.inputView;
            if (baseInputView3 == null) {
                kotlin.jvm.internal.p.A("inputView");
            } else {
                baseInputView = baseInputView3;
            }
            baseInputView.Va(selectedText);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t d5(DisplayMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Y8.t.f7040a;
    }

    public static final void e3(String str, String str2, final WakeDialogImpl wakeDialogImpl, Long l10) {
        BaseInputView baseInputView = null;
        if (str != null && !START_RECORD_SOURCES.contains(str2)) {
            BaseInputView baseInputView2 = wakeDialogImpl.inputView;
            if (baseInputView2 == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView2 = null;
            }
            baseInputView2.setPendingMsgSource(str);
        }
        switch (str2.hashCode()) {
            case -1418033720:
                if (!str2.equals(C4814a.AI_KEY_CLICK2)) {
                    return;
                }
                break;
            case -1350521956:
                if (str2.equals(C4814a.HEADSET_WAKEUP)) {
                    BaseInputView baseInputView3 = wakeDialogImpl.inputView;
                    if (baseInputView3 == null) {
                        kotlin.jvm.internal.p.A("inputView");
                    } else {
                        baseInputView = baseInputView3;
                    }
                    baseInputView.nc(str, "headset_control");
                    return;
                }
                return;
            case -951070683:
                if (!str2.equals(C4814a.BOTTOM_BAR_KEY_LONG_CLICK)) {
                    return;
                }
                break;
            case -926107835:
                if (!str2.equals(C4814a.HOME_KEY_LONG_CLICK)) {
                    return;
                }
                break;
            case 293766892:
                if (str2.equals("voice_wakeup")) {
                    BaseInputView baseInputView4 = wakeDialogImpl.inputView;
                    if (baseInputView4 == null) {
                        kotlin.jvm.internal.p.A("inputView");
                    } else {
                        baseInputView = baseInputView4;
                    }
                    baseInputView.nc(str, "voice_wakeup");
                    return;
                }
                return;
            case 643045183:
                if (str2.equals(C4814a.AI_KEY_LONG_CLICK_START)) {
                    wakeDialogImpl.I4();
                    if (l10 != null) {
                        final long jLongValue = l10.longValue();
                        wakeDialogImpl.e6(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.S0
                            @Override // p9.InterfaceC5063a
                            public final Object invoke() {
                                return WakeDialogImpl.f3(jLongValue, wakeDialogImpl);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            case 684453624:
                if (str2.equals(C4814a.AI_KEY_LONG_CLICK_END)) {
                    wakeDialogImpl.y5();
                    BaseInputView baseInputView5 = wakeDialogImpl.inputView;
                    if (baseInputView5 == null) {
                        kotlin.jvm.internal.p.A("inputView");
                    } else {
                        baseInputView = baseInputView5;
                    }
                    baseInputView.s4();
                    return;
                }
                return;
            case 1080244305:
                if (!str2.equals("ai_key_click")) {
                    return;
                }
                break;
            default:
                return;
        }
        BaseInputView baseInputView6 = wakeDialogImpl.inputView;
        if (baseInputView6 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView = baseInputView6;
        }
        baseInputView.J6();
    }

    private final float e4() {
        return getContext().getResources().getDisplayMetrics().density;
    }

    public static final Y8.t e5(DisplayMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Y8.t.f7040a;
    }

    public static final Y8.t f3(long j10, WakeDialogImpl wakeDialogImpl) {
        BaseInputView baseInputView = null;
        if (j10 == wakeDialogImpl.aiKeyLongClickGeneration && !wakeDialogImpl.dismissingWithAnim && wakeDialogImpl.isShowing()) {
            C4148a.d(wakeDialogImpl.TAG, "aiKeyLongClick START execute generation=" + j10, false, 4, null);
            BaseInputView baseInputView2 = wakeDialogImpl.inputView;
            if (baseInputView2 == null) {
                kotlin.jvm.internal.p.A("inputView");
            } else {
                baseInputView = baseInputView2;
            }
            baseInputView.t4();
            return Y8.t.f7040a;
        }
        C4148a.d(wakeDialogImpl.TAG, "aiKeyLongClick START skipped generation=" + j10 + " current=" + wakeDialogImpl.aiKeyLongClickGeneration + " dismissing=" + wakeDialogImpl.dismissingWithAnim + " showing=" + wakeDialogImpl.isShowing(), false, 4, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t f5() {
        return Y8.t.f7040a;
    }

    public static final void h3(WakeDialogImpl wakeDialogImpl, WakeService.SuggestPayload suggestPayload) {
        wakeDialogImpl.b6(suggestPayload);
    }

    public static final void h5(WakeDialogImpl wakeDialogImpl) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        BaseInputView.wc(baseInputView, null, 1, null);
    }

    public static final void h6(WakeDialogImpl wakeDialogImpl, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        p5(wakeDialogImpl, null, 1, null);
    }

    public static final Y8.t j3(WakeDialogImpl wakeDialogImpl, y7.E it) {
        kotlin.jvm.internal.p.i(it, "it");
        wakeDialogImpl.aiWaitingBarGlassHandle = null;
        return Y8.t.f7040a;
    }

    public static final void j5(WakeDialogImpl wakeDialogImpl, Uri uri, long j10) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.g9(uri, j10);
    }

    public static final Y8.t l3(WakeDialogImpl wakeDialogImpl, boolean z10, DisplayMessage firstMessage) {
        kotlin.jvm.internal.p.i(firstMessage, "firstMessage");
        boolean zA = SlaChatController.INSTANCE.a(firstMessage.getMessageId());
        C4148a.d(wakeDialogImpl.TAG, "onFirstAssistantResponse isTaskRobot=" + z10 + " isLocalSlaResponse=" + zA + " messageId=" + firstMessage.getMessageId(), false, 4, null);
        E5.b.INSTANCE.a(firstMessage.getTraceId(), "text_display_response.first", "agent首回复回显开始(半屏)");
        if (zA) {
            wakeDialogImpl.E5();
            return Y8.t.f7040a;
        }
        if (wakeDialogImpl.aiWakeWaiting) {
            wakeDialogImpl.j6(false);
        }
        wakeDialogImpl.E5();
        if (kotlin.jvm.internal.p.d(wakeDialogImpl.currentState, J.e.INSTANCE)) {
            if (wakeDialogImpl.a6()) {
                C4148a.d(wakeDialogImpl.TAG, "onFirstAssistantResponse suppress fallback half expand: AgentSpace overlay foreground, keep Minify, messageId=" + firstMessage.getMessageId(), false, 4, null);
            } else {
                wakeDialogImpl.W3();
            }
        }
        return Y8.t.f7040a;
    }

    public static final void l5(WakeDialogImpl wakeDialogImpl, a.Expand expand) {
        wakeDialogImpl.S2(expand);
    }

    public static final boolean n3(WakeDialogImpl wakeDialogImpl, LauncherChatLayout launcherChatLayout) {
        ChatMessageAdapter adapter = wakeDialogImpl.chatMessageAdapter;
        if (adapter == null) {
            adapter = launcherChatLayout.getAdapter();
        }
        return adapter.G().isEmpty();
    }

    private final void n4() {
        Window window;
        View decorView;
        IBinder windowToken;
        Object systemService = getContext().getSystemService("input_method");
        BaseInputView baseInputView = null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager == null || (window = getWindow()) == null || (decorView = window.getDecorView()) == null || (windowToken = decorView.getWindowToken()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        BaseInputView baseInputView2 = this.inputView;
        if (baseInputView2 != null) {
            if (baseInputView2 == null) {
                kotlin.jvm.internal.p.A("inputView");
            } else {
                baseInputView = baseInputView2;
            }
            View viewFindViewById = baseInputView.findViewById(R$id.et_input_bar);
            if (viewFindViewById != null) {
                viewFindViewById.clearFocus();
            }
        }
    }

    public static final void n5(WakeDialogImpl wakeDialogImpl, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        wakeDialogImpl.q6("entrance SpringAnimation end -> ensureChatPanelInflated");
        wakeDialogImpl.N3();
    }

    public static final void n6(WakeDialogImpl wakeDialogImpl) {
        wakeDialogImpl.pendingSyncRunnable = null;
        wakeDialogImpl.L3();
    }

    public static final Y8.t o3(final WakeDialogImpl wakeDialogImpl, final com.stepos.ailauncher.chat.view.sla.a resolution) {
        kotlin.jvm.internal.p.i(resolution, "resolution");
        View view = null;
        if (resolution instanceof a.Expand) {
            a.Expand expand = (a.Expand) resolution;
            if (expand.getWaitForUserMessage()) {
                String str = wakeDialogImpl.readyUserMessageTraceId;
                if (str != null && (str.length() == 0 || kotlin.jvm.internal.p.d(str, expand.getTraceId()))) {
                    View view2 = wakeDialogImpl.rootView;
                    if (view2 == null) {
                        kotlin.jvm.internal.p.A("rootView");
                    } else {
                        view = view2;
                    }
                    view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.I0
                        @Override // java.lang.Runnable
                        public final void run() {
                            WakeDialogImpl.p3(this.f26633a, resolution);
                        }
                    });
                    return Y8.t.f7040a;
                }
                wakeDialogImpl.pendingUserMessageExpand = expand;
                C4148a.d(wakeDialogImpl.TAG, "onHalfPopupResolved wait user message resolution=" + resolution, false, 4, null);
                C0919o.d("INPUT_BAR", "云端回退已放行,等待真实用户消息后展开(reason=" + expand.getReason() + ")", false, 4, null);
                return Y8.t.f7040a;
            }
        }
        wakeDialogImpl.pendingUserMessageExpand = null;
        wakeDialogImpl.S2(resolution);
        return Y8.t.f7040a;
    }

    public static final void p3(WakeDialogImpl wakeDialogImpl, com.stepos.ailauncher.chat.view.sla.a aVar) {
        wakeDialogImpl.S2(aVar);
    }

    public static /* synthetic */ void p5(WakeDialogImpl wakeDialogImpl, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        wakeDialogImpl.o5(str);
    }

    public static final boolean q3(WakeDialogImpl wakeDialogImpl) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        boolean zA8 = baseInputView.a8();
        boolean z10 = wakeDialogImpl.isShowing() && !zA8;
        C4148a.d(wakeDialogImpl.TAG, "can play TTS: " + z10 + " showing=" + wakeDialogImpl.isShowing() + " recording=" + zA8, false, 4, null);
        return z10;
    }

    public static final com.stepos.ailauncher.chat.wake.effect.c q5(WakeDialogImpl wakeDialogImpl) {
        View view = wakeDialogImpl.rootView;
        if (view == null) {
            kotlin.jvm.internal.p.A("rootView");
            view = null;
        }
        return new com.stepos.ailauncher.chat.wake.effect.c(view, SPECTRUM_BORDER_CONFIG);
    }

    public static final Y8.t r3(WakeDialogImpl wakeDialogImpl) {
        wakeDialogImpl.O();
        return Y8.t.f7040a;
    }

    private final void r5() {
        if (this.chatLayout == null) {
            return;
        }
        Function2.a(new WakeDialogImpl$refreshActionBarSuppressForTask$1(this, null));
    }

    public static final WindowManager r6(Context context) {
        Object systemService = context.getApplicationContext().getSystemService("window");
        if (systemService instanceof WindowManager) {
            return (WindowManager) systemService;
        }
        return null;
    }

    public static final void s4(WakeDialogImpl wakeDialogImpl, View view) {
        if (!wakeDialogImpl.asrFinalizing) {
            wakeDialogImpl.j6(true);
            return;
        }
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.t5();
    }

    public static final void s5(WakeDialogImpl wakeDialogImpl) {
        BaseInputView baseInputView = wakeDialogImpl.inputView;
        BaseInputView baseInputView2 = null;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        ActionView actionView = baseInputView.getActionView();
        if (actionView != null) {
            actionView.removeCallbacks(wakeDialogImpl.refreshTask);
        }
        BaseInputView baseInputView3 = wakeDialogImpl.inputView;
        if (baseInputView3 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView2 = baseInputView3;
        }
        ActionView actionView2 = baseInputView2.getActionView();
        if (actionView2 != null) {
            actionView2.c();
        }
    }

    public static final TtsMediaFocusController s6(Context context, final WakeDialogImpl wakeDialogImpl) {
        TtsMediaFocusController ttsMediaFocusController = new TtsMediaFocusController(context);
        ttsMediaFocusController.g0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.y1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.t6(this.f26892a);
            }
        });
        return ttsMediaFocusController;
    }

    public static final Y8.t t4(WakeDialogImpl wakeDialogImpl) {
        wakeDialogImpl.onCancelSilentCapture.invoke();
        return Y8.t.f7040a;
    }

    private final void t5() {
        FloatCardContainerView floatCardContainerView = this.floatCardContainer;
        if (floatCardContainerView != null && this.floatCardHost == null) {
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            G4.h hVar = new G4.h("wake_dialog_float_card", 100, context, floatCardContainerView, Z8.Y.j(FloatCardScene.Any, FloatCardScene.Chat, FloatCardScene.WakeDialog), new p9.p() { // from class: com.stepos.ailauncher.chat.wake.V0
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return WakeDialogImpl.u5(this.f26667a, ((Boolean) obj).booleanValue(), (FloatCardOptions) obj2);
                }
            }, null, null, 192, null);
            this.floatCardHost = hVar;
            IFloatCardService iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
            if (iFloatCardService != null) {
                iFloatCardService.registerHost(hVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final Y8.t t6(com.stepos.ailauncher.chat.wake.WakeDialogImpl r5) {
        /*
            r5.O()
            com.stepos.ailauncher.chat.view.BaseInputView r0 = r5.inputView
            r1 = 4
            r2 = 0
            java.lang.String r3 = "WakeDialogImpl"
            r4 = 0
            if (r0 == 0) goto L20
            if (r0 != 0) goto L14
            java.lang.String r0 = "inputView"
            kotlin.jvm.internal.p.A(r0)
            r0 = r4
        L14:
            boolean r0 = r0.a8()
            if (r0 == 0) goto L20
            java.lang.String r5 = "AudioFocus lost -> stopTTS (recording active, skip dismiss)"
            h8.C4148a.k(r3, r5, r2, r1, r4)
            goto L2e
        L20:
            java.lang.String r0 = "AudioFocus lost -> stopTTS + dismissWithAnim"
            h8.C4148a.k(r3, r0, r2, r1, r4)
            boolean r0 = r5.getDismissingWithAnim()
            if (r0 != 0) goto L2e
            r5.J3()
        L2e:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeDialogImpl.t6(com.stepos.ailauncher.chat.wake.WakeDialogImpl):Y8.t");
    }

    public static final int u3(WakeDialogImpl wakeDialogImpl) {
        return wakeDialogImpl.M3(32);
    }

    public static final void u4(View view) {
        C4148a.d("WakeupDialog", "click panel view", false, 4, null);
    }

    public static final Y8.t u5(WakeDialogImpl wakeDialogImpl, boolean z10, FloatCardOptions options) {
        kotlin.jvm.internal.p.i(options, "options");
        if (options.getHideChatViewOnShow()) {
            View view = wakeDialogImpl.panelView;
            if (view == null) {
                kotlin.jvm.internal.p.A("panelView");
                view = null;
            }
            view.setVisibility(z10 ? 8 : 0);
        }
        return Y8.t.f7040a;
    }

    public static final void v4(WakeDialogImpl wakeDialogImpl, View view) {
        CircleSelectController circleSelectController = wakeDialogImpl.circleSelectController;
        if ((circleSelectController != null && circleSelectController.H0()) || com.stepos.ailauncher.screenshot.f.INSTANCE.a() == 3 || wakeDialogImpl.getScreenshotPassthrough()) {
            return;
        }
        if (wakeDialogImpl.Z5()) {
            C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "scrim click ignored: press-to-talk", false, 4, null);
        } else {
            C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "scrim click -> dismissWithAnim", false, 4, null);
            wakeDialogImpl.J3();
        }
    }

    public static final int w3(WakeDialogImpl wakeDialogImpl) {
        return wakeDialogImpl.M3(64);
    }

    public static final boolean w4(WakeDialogImpl wakeDialogImpl, Ref$BooleanRef ref$BooleanRef, int i10, View view, MotionEvent motionEvent) {
        CircleSelectController circleSelectController;
        if (wakeDialogImpl.Z5()) {
            ref$BooleanRef.f34815a = false;
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!ref$BooleanRef.f34815a) {
                        return false;
                    }
                    wakeDialogImpl.f4().onTouchEvent(motionEvent);
                    kotlin.jvm.internal.p.f(motionEvent);
                    wakeDialogImpl.l4(motionEvent);
                    return true;
                }
                if (actionMasked != 3) {
                    return false;
                }
            }
            if (!ref$BooleanRef.f34815a) {
                return false;
            }
            wakeDialogImpl.f4().onTouchEvent(motionEvent);
            kotlin.jvm.internal.p.f(motionEvent);
            wakeDialogImpl.l4(motionEvent);
            ref$BooleanRef.f34815a = false;
            return true;
        }
        if (!view.isClickable() || (((circleSelectController = wakeDialogImpl.circleSelectController) != null && circleSelectController.H0()) || com.stepos.ailauncher.screenshot.f.INSTANCE.a() == 3 || wakeDialogImpl.getScreenshotPassthrough())) {
            ref$BooleanRef.f34815a = false;
            return false;
        }
        Rect rectA3 = wakeDialogImpl.A3(i10);
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (rectA3 == null || rawX < rectA3.left || rawX >= rectA3.right || rawY < rectA3.top || rawY >= rectA3.bottom) {
            ref$BooleanRef.f34815a = false;
            return false;
        }
        ref$BooleanRef.f34815a = true;
        wakeDialogImpl.f4().onTouchEvent(motionEvent);
        kotlin.jvm.internal.p.f(motionEvent);
        wakeDialogImpl.l4(motionEvent);
        return true;
    }

    private final void w5() {
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
            C4148a.g(this.TAG, "registerScreenOffReceiver failed", thE, false, 8, null);
        }
    }

    private final void w6() {
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

    public static final Y8.t x4(WakeDialogImpl wakeDialogImpl, List it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (kotlin.jvm.internal.p.d(wakeDialogImpl.currentState, J.e.INSTANCE)) {
            BaseInputView baseInputView = wakeDialogImpl.inputView;
            BaseInputView baseInputView2 = null;
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            ActionView actionView = baseInputView.getActionView();
            if (actionView != null && actionView.getHeight() == 0) {
                BaseInputView baseInputView3 = wakeDialogImpl.inputView;
                if (baseInputView3 == null) {
                    kotlin.jvm.internal.p.A("inputView");
                } else {
                    baseInputView2 = baseInputView3;
                }
                ActionView actionView2 = baseInputView2.getActionView();
                if (actionView2 != null) {
                    actionView2.postDelayed(wakeDialogImpl.refreshTask, 100L);
                }
            }
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t y4(boolean z10) {
        return Y8.t.f7040a;
    }

    public static final Y8.t z4(WakeDialogImpl wakeDialogImpl) {
        if (kotlin.jvm.internal.p.d(wakeDialogImpl.currentState, J.e.INSTANCE)) {
            wakeDialogImpl.f6();
        }
        return Y8.t.f7040a;
    }

    public final Rect A3(int extensionHeightPx) {
        View view;
        View view2 = null;
        if (this.panelView == null || (view = this.chatPanelWrapper) == null || view.getWidth() <= 0 || extensionHeightPx <= 0) {
            return null;
        }
        int[] iArr = new int[2];
        View view3 = this.panelView;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("panelView");
        } else {
            view2 = view3;
        }
        view2.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i10 = iArr2[0];
        return new Rect(i10, iArr[1] - extensionHeightPx, view.getWidth() + i10, iArr[1]);
    }

    public final void A6(J state) {
        float f10 = 0.0f;
        View view = null;
        if (!WakeService.INSTANCE.s0()) {
            View view2 = this.scrimView;
            if (view2 != null) {
                if (view2 == null) {
                    kotlin.jvm.internal.p.A("scrimView");
                    view2 = null;
                }
                view2.animate().cancel();
                View view3 = this.scrimView;
                if (view3 == null) {
                    kotlin.jvm.internal.p.A("scrimView");
                    view3 = null;
                }
                if (view3.getAlpha() != 0.0f) {
                    View view4 = this.scrimView;
                    if (view4 == null) {
                        kotlin.jvm.internal.p.A("scrimView");
                        view4 = null;
                    }
                    view4.setAlpha(0.0f);
                }
            }
            View view5 = this.dragBar;
            if (view5 != null) {
                if (view5 == null) {
                    kotlin.jvm.internal.p.A("dragBar");
                } else {
                    view = view5;
                }
                view.removeCallbacks(this.restoreDragBarTintRunnable);
                R2(false);
                return;
            }
            return;
        }
        if (!kotlin.jvm.internal.p.d(state, J.b.INSTANCE)) {
            if (!kotlin.jvm.internal.p.d(state, J.e.INSTANCE) && !kotlin.jvm.internal.p.d(state, J.d.INSTANCE) && !kotlin.jvm.internal.p.d(state, J.c.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            f10 = 0.7f;
        }
        View view6 = this.scrimView;
        if (view6 == null) {
            kotlin.jvm.internal.p.A("scrimView");
            view6 = null;
        }
        boolean z10 = f10 > view6.getAlpha();
        long j10 = z10 ? SCRIM_FADE_IN_DURATION_MS : 250L;
        View view7 = this.scrimView;
        if (view7 == null) {
            kotlin.jvm.internal.p.A("scrimView");
            view7 = null;
        }
        view7.animate().alpha(f10).setDuration(j10).setInterpolator(SCRIM_INTERPOLATOR).start();
        if (z10) {
            R2(true);
            return;
        }
        View view8 = this.dragBar;
        if (view8 == null) {
            kotlin.jvm.internal.p.A("dragBar");
            view8 = null;
        }
        view8.removeCallbacks(this.restoreDragBarTintRunnable);
        View view9 = this.dragBar;
        if (view9 == null) {
            kotlin.jvm.internal.p.A("dragBar");
        } else {
            view = view9;
        }
        view.postDelayed(this.restoreDragBarTintRunnable, j10);
    }

    @Override // com.stepos.ailauncher.chat.wake.DialogC3116e0
    public void B() {
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        ISpeechService iSpeechService;
        LauncherChatLayout launcherChatLayout;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        Context context;
        K4("onDismiss");
        x3();
        g4().n();
        super.B();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.D1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.b5(this.f26611a);
            }
        }, 100L);
        w6();
        v6();
        this.answeredCallWatcher.f();
        TaskModule.INSTANCE.l(this.taskCardCallback);
        try {
            Result.Companion companion = Result.INSTANCE;
            com.stepos.agentframework.chatui.appui.c cVarA = com.stepos.agentframework.chatui.appui.c.INSTANCE.a();
            LauncherChatLayout launcherChatLayout2 = this.chatLayout;
            if (launcherChatLayout2 == null || (context = launcherChatLayout2.getContext()) == null) {
                context = getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
            }
            cVarA.e(context);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        o6();
        p6();
        y5();
        CircleSelectController circleSelectController = this.circleSelectController;
        if (circleSelectController != null) {
            circleSelectController.N0();
        }
        ConstraintLayout constraintLayout = null;
        this.circleSelectController = null;
        if (this.inputView != null) {
            if (this.voiceGloballyStoppedForDismiss) {
                C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "onDismiss: skip global voice sweep (already stopped)", false, 4, null);
            } else {
                C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "onDismiss: stopAllVoiceForPageLeave (fallback)", false, 4, null);
                InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
            }
            BaseInputView baseInputView = this.inputView;
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            baseInputView.setOnRecordingStateChanged(null);
        }
        this.voiceGloballyStoppedForDismiss = false;
        u6();
        x6();
        com.stepos.ailauncher.chat.wake.effect.g gVar = this.spectrumBorder;
        if (gVar != null) {
            gVar.o();
        }
        this.spectrumBorder = null;
        h4().h();
        androidx.dynamicanimation.animation.i iVar = this.chatHeightAnim;
        if (iVar != null) {
            iVar.d();
        }
        this.chatHeightAnim = null;
        androidx.dynamicanimation.animation.i iVar2 = this.translationYAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        this.translationYAnim = null;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
        VelocityTracker velocityTracker2 = this.inputDragVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
        }
        this.inputDragVelocityTracker = null;
        this.inputDragging = false;
        View view = this.scrimView;
        if (view != null) {
            if (view == null) {
                kotlin.jvm.internal.p.A("scrimView");
                view = null;
            }
            view.animate().cancel();
        }
        View view2 = this.vBottomView;
        if (view2 != null && (viewPropertyAnimatorAnimate = view2.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        View view3 = this.dragBar;
        if (view3 != null) {
            if (view3 == null) {
                kotlin.jvm.internal.p.A("dragBar");
                view3 = null;
            }
            view3.removeCallbacks(this.restoreDragBarTintRunnable);
        }
        if (this.deferredNavigatePending) {
            this.deferredNavigatePending = false;
            View view4 = this.rootView;
            if (view4 != null) {
                if (view4 == null) {
                    kotlin.jvm.internal.p.A("rootView");
                    view4 = null;
                }
                view4.removeCallbacks(this.deferredNavigateTimeout);
            }
        }
        this.hasPendingSend = false;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.keyboardLayoutListener;
        if (onGlobalLayoutListener != null) {
            try {
                Activity activity = this.activity;
                if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
                    Y8.t tVar = Y8.t.f7040a;
                }
            } catch (Exception e10) {
                C4148a.t(this.TAG, "onDismiss: 移除键盘监听器失败", e10, false, 8, null);
            }
        }
        this.keyboardLayoutListener = null;
        this.activity = null;
        O();
        boolean z10 = (this.navigatingToChat || INSTANCE.e()) && (iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class)) != null && iSpeechService.isSpeaking();
        if (z10) {
            C5();
        } else {
            k4().c0();
        }
        SlaChatController slaChatController = this.slaController;
        if (slaChatController != null) {
            slaChatController.e0();
        }
        SlaChatController slaChatController2 = this.slaController;
        if (slaChatController2 != null) {
            slaChatController2.Q0();
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            kotlinx.coroutines.d.e(i4(), null, 1, null);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        MarkwonHelper.y0(null);
        LauncherChatLayout launcherChatLayout3 = this.chatLayout;
        if (launcherChatLayout3 != null) {
            launcherChatLayout3.setCanPlayTTS(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.F1
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(WakeDialogImpl.c5());
                }
            });
        }
        LauncherChatLayout launcherChatLayout4 = this.chatLayout;
        if (launcherChatLayout4 != null) {
            launcherChatLayout4.setOnReceiveMessage(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.G1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WakeDialogImpl.d5((DisplayMessage) obj);
                }
            });
        }
        LauncherChatLayout launcherChatLayout5 = this.chatLayout;
        if (launcherChatLayout5 != null) {
            launcherChatLayout5.setOnUserBubbleShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.H1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WakeDialogImpl.e5((DisplayMessage) obj);
                }
            });
        }
        if (!z10 && (launcherChatLayout = this.chatLayout) != null) {
            launcherChatLayout.setTtsPlayerListener(null);
        }
        this.onCancelSilentCapture = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.I1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.f5();
            }
        };
        if (!this.skipSessionReset && !INSTANCE.e()) {
            ChatStopActions.INSTANCE.g(this, this.sessionHandler);
            LauncherChatLayout launcherChatLayout6 = this.chatLayout;
            if (launcherChatLayout6 != null) {
                launcherChatLayout6.w7();
            }
            ChatTracker.INSTANCE.j();
            Q.INSTANCE.h("WakeDialog.onDismiss");
        }
        try {
            this.onDismissed.invoke();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion5 = Result.INSTANCE;
            Result.b(C4849c.a(th3));
        }
        E3();
        this.aiWakeWaiting = false;
        this.asrFinalizing = false;
        this.pendingUserMessageExpand = null;
        this.readyUserMessageTraceId = null;
        this.halfPopupSendCoordinator.d();
        Runnable runnable = this.pendingSyncRunnable;
        if (runnable != null) {
            View view5 = this.inputView;
            if (view5 == null) {
                view5 = this.aiWaitingBar;
            } else if (view5 == null) {
                kotlin.jvm.internal.p.A("inputView");
                view5 = null;
            }
            if (view5 != null) {
                view5.removeCallbacks(runnable);
            }
        }
        this.pendingSyncRunnable = null;
        View view6 = this.aiWaitingBar;
        if (view6 != null) {
            view6.setVisibility(8);
        }
        aiWaitingBarShowing = false;
        ConstraintLayout constraintLayout2 = this.dragHandleArea;
        if (constraintLayout2 != null) {
            if (constraintLayout2 == null) {
                kotlin.jvm.internal.p.A("dragHandleArea");
            } else {
                constraintLayout = constraintLayout2;
            }
            constraintLayout.setTranslationY(0.0f);
        }
    }

    public final int B3() {
        ViewGroup.LayoutParams layoutParams;
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout == null || (layoutParams = launcherChatLayout.getLayoutParams()) == null) {
            return 0;
        }
        return C5685n.f(layoutParams.height, 0);
    }

    public final void B5() {
        WindowManager.LayoutParams attributes;
        if (this.dismissingWithAnim) {
            C4148a.d(this.TAG, "restoreFullScreenWindow: skip while dismissing", false, 4, null);
            return;
        }
        Window window = getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.gravity = 0;
        attributes.width = -1;
        attributes.height = -1;
        Integer num = this.flagsBeforeShrink;
        attributes.flags = num != null ? num.intValue() : attributes.flags & (-33);
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(attributes);
        }
        this.windowShrunkToPanel = false;
        this.flagsBeforeShrink = null;
        String str = this.TAG;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        Integer numValueOf = Integer.valueOf(attributes.height);
        String string = Integer.toString(attributes.flags, C0951a.a(16));
        kotlin.jvm.internal.p.h(string, "toString(...)");
        String str2 = String.format("restoreFullScreenWindow: height=%d flags=0x%s", Arrays.copyOf(new Object[]{numValueOf, string}, 2));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(str, str2, false, 4, null);
    }

    public final void B6(J state) {
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout == null) {
            return;
        }
        launcherChatLayout.O8();
        launcherChatLayout.getBtnScrollToBottom().setBackgroundResource(kotlin.jvm.internal.p.d(state, J.d.INSTANCE) ? R$drawable.bg_btn_to_bottom_wake_half : R$drawable.bg_btn_to_bottom);
        launcherChatLayout.J8();
    }

    public final void C2() {
        if (this.enableCircleSelect) {
            Object systemService = getContext().getSystemService("keyguard");
            KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
            if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                C4148a.k(this.TAG, "activeCircleSelector: keyguard locked, skip circle select", false, 4, null);
                return;
            }
            CircleSelectController circleSelectController = this.circleSelectController;
            if (circleSelectController != null) {
                circleSelectController.Y();
            }
            CircleSelectController circleSelectController2 = this.circleSelectController;
            if (circleSelectController2 == null || !circleSelectController2.H0()) {
                return;
            }
            y5();
        }
    }

    public final void C3() {
        CircleSelectController circleSelectController = this.circleSelectController;
        if (circleSelectController != null) {
            circleSelectController.N0();
        }
        BaseInputView baseInputView = this.inputView;
        if (baseInputView != null) {
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            if (baseInputView.vb()) {
                I4();
            }
        }
    }

    public final void C5() {
        TtsMediaFocusController ttsMediaFocusControllerK4 = k4();
        final LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout == null) {
            return;
        }
        ttsMediaFocusControllerK4.g0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.K1
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.D5(this.f26641a, launcherChatLayout);
            }
        });
        launcherChatLayout.setTtsPlayerListener(new i(ttsMediaFocusControllerK4, launcherChatLayout));
    }

    public final void C6(MotionEvent ev) {
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            this.swipeMinY = ev.getRawY();
            this.swipeHasDownwardReversal = false;
        } else {
            if (actionMasked != 2) {
                return;
            }
            float rawY = ev.getRawY();
            if (rawY < this.swipeMinY) {
                this.swipeMinY = rawY;
            }
            if (this.swipeHasDownwardReversal || rawY <= this.swipeMinY + M3(8)) {
                return;
            }
            this.swipeHasDownwardReversal = true;
        }
    }

    public final void D2(int keyboardHeight, int statusBarTop) {
        LauncherChatLayout launcherChatLayout;
        if (kotlin.jvm.internal.p.d(this.currentState, J.d.INSTANCE) && (launcherChatLayout = this.chatLayout) != null) {
            View view = this.rootView;
            if (view == null) {
                kotlin.jvm.internal.p.A("rootView");
                view = null;
            }
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            int height = viewGroup != null ? viewGroup.getHeight() : this.screenHeightPx;
            int iM3 = M3(HALF_CHAT_HEIGHT_DP);
            if (keyboardHeight <= 0) {
                if (launcherChatLayout.getLayoutParams().height != iM3) {
                    J5(iM3);
                }
            } else {
                int iJ = C5685n.j(iM3, C5685n.f(((height - statusBarTop) - keyboardHeight) - Z4(), 0));
                if (launcherChatLayout.getLayoutParams().height != iJ) {
                    J5(iJ);
                }
            }
        }
    }

    @Override // com.stepos.ailauncher.chat.wake.DialogC3116e0
    public void E(String stopReason) {
        C4148a.d(this.TAG, "performBroadcastDismiss: route to dismissNoAnim reason=" + stopReason, false, 4, null);
        H3(stopReason);
    }

    public final void E3() {
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.setOnFirstAssistantResponse(null);
        }
    }

    public final void F3() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        int i10 = attributes.flags;
        if ((i10 & 16) != 0) {
            return;
        }
        attributes.flags = i10 | 16;
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(attributes);
        }
        String str = this.TAG;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String string = Integer.toString(attributes.flags, C0951a.a(16));
        kotlin.jvm.internal.p.h(string, "toString(...)");
        String str2 = String.format("disableWindowTouchForDismiss: flags=0x%s", Arrays.copyOf(new Object[]{string}, 1));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(str, str2, false, 4, null);
    }

    public final void F5(final int keyboardHeight, final int effectiveKeyboardHeight, final int effectiveStatusBarTop) {
        if (this.imeAnimationRunning || this.rootView == null) {
            return;
        }
        final int i10 = this.noAnimImeSettleGeneration + 1;
        this.noAnimImeSettleGeneration = i10;
        C4148a.d(this.TAG, "schedule no-anim ime settle gen=" + i10 + " keyboardHeight=" + keyboardHeight, false, 4, null);
        View view = this.rootView;
        if (view == null) {
            kotlin.jvm.internal.p.A("rootView");
            view = null;
        }
        view.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.C1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.G5(i10, this, keyboardHeight, effectiveKeyboardHeight, effectiveStatusBarTop);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G3(java.lang.String r11) {
        /*
            r10 = this;
            com.stepos.ailauncher.chat.view.BaseInputView r0 = r10.inputView
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L39
            com.stepos.ailauncher.chat.wake.j r3 = com.stepos.ailauncher.chat.wake.C3134j.INSTANCE
            java.lang.String r4 = "inputView"
            if (r0 != 0) goto L10
            kotlin.jvm.internal.p.A(r4)
            r0 = r2
        L10:
            boolean r0 = r0.a8()
            com.stepos.ailauncher.chat.view.BaseInputView r5 = r10.inputView
            if (r5 != 0) goto L1c
            kotlin.jvm.internal.p.A(r4)
            r5 = r2
        L1c:
            boolean r5 = r5.getListenModeActive()
            com.stepos.ailauncher.chat.view.BaseInputView r6 = r10.inputView
            if (r6 != 0) goto L28
            kotlin.jvm.internal.p.A(r4)
            r6 = r2
        L28:
            boolean r6 = r6.S7()
            r8 = 8
            r9 = 0
            r7 = 0
            r4 = r0
            boolean r0 = com.stepos.ailauncher.chat.wake.C3134j.c(r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L39
            r0 = 1
            goto L3a
        L39:
            r0 = r1
        L3a:
            java.lang.String r3 = r10.TAG
            boolean r4 = r10.isShowing()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "answered call ("
            r5.append(r6)
            r5.append(r11)
            java.lang.String r11 = "): showing="
            r5.append(r11)
            r5.append(r4)
            java.lang.String r11 = " voiceSession="
            r5.append(r11)
            r5.append(r0)
            java.lang.String r11 = " -> dismiss (AIOSBUG-15913/15752/17863)"
            r5.append(r11)
            java.lang.String r11 = r5.toString()
            r0 = 4
            h8.C4148a.k(r3, r11, r1, r0, r2)
            com.stepos.ailauncher.chat.manager.InputViewManager r11 = com.stepos.ailauncher.chat.manager.InputViewManager.INSTANCE
            java.lang.String r0 = "call_incoming"
            r11.X(r0)
            r10.O()
            boolean r11 = r10.isShowing()
            if (r11 == 0) goto L7d
            r10.H3(r0)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeDialogImpl.G3(java.lang.String):void");
    }

    public final void H3(String pressToTalkCancelReason) {
        if (this.dismissingWithAnim) {
            return;
        }
        K4("dismissNoAnim");
        this.dismissingWithAnim = true;
        F3();
        o5(pressToTalkCancelReason);
    }

    public final void I4() {
        CircleSelectController circleSelectController = this.circleSelectController;
        if (circleSelectController != null && circleSelectController.H0()) {
            y5();
            return;
        }
        if (this.touchBlockerView != null) {
            return;
        }
        WindowManager windowManagerJ4 = j4();
        if (windowManagerJ4 == null) {
            C4148a.u(this.TAG, "installTouchBlockerOverlay: no WindowManager", false, 4, null);
            return;
        }
        if (!s3()) {
            C4148a.u(this.TAG, "installTouchBlockerOverlay: SYSTEM_ALERT_WINDOW 权限缺失，跳过", false, 4, null);
            return;
        }
        View view = new View(getContext().getApplicationContext());
        view.setBackgroundColor(0);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.wake.J0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return WakeDialogImpl.J4(view2, motionEvent);
            }
        });
        view.setClickable(true);
        view.setFocusable(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2038;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.gravity = 0;
        layoutParams.flags = 66312;
        try {
            windowManagerJ4.addView(view, layoutParams);
            this.touchBlockerView = view;
            C4148a.d(this.TAG, "installTouchBlockerOverlay: blocker attached", false, 4, null);
        } catch (Throwable th) {
            C4148a.g(this.TAG, "installTouchBlockerOverlay: addView failed", th, false, 8, null);
        }
    }

    public final void I5(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (La.H.x0(text)) {
            return;
        }
        BaseInputView baseInputView = this.inputView;
        if (baseInputView == null) {
            C4148a.u(this.TAG, "sendUserText: inputView not ready, drop", false, 4, null);
            return;
        }
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.Va(text);
    }

    public final void J3() {
        if (this.dismissingWithAnim) {
            return;
        }
        K4("dismissWithAnim");
        this.dismissingWithAnim = true;
        O();
        View view = null;
        if (this.inputView != null) {
            C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "dismissWithAnim: stopAllVoiceForPageLeave", false, 4, null);
            this.voiceGloballyStoppedForDismiss = true;
            InputViewManager.INSTANCE.e1("user_cancel");
        }
        androidx.dynamicanimation.animation.i iVar = this.chatHeightAnim;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = this.translationYAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        View view2 = this.panelView;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view2 = null;
        }
        final float fE = C5685n.e(view2.getHeight(), M3(com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME)) + M3(20);
        Integer num = this.latestKeyboardHeightForInsets;
        int iIntValue = num != null ? num.intValue() : 0;
        if (!this.keyboardShowing || iIntValue <= 0) {
            F3();
            g6(fE);
        } else {
            C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "dismissWithAnim: IME-synced branch (kb=" + iIntValue + ")", false, 4, null);
            this.panelDismissTravelTarget = fE;
            this.pendingImeSyncedDismiss = true;
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.j0
                @Override // java.lang.Runnable
                public final void run() {
                    WakeDialogImpl.K3(this.f26820a, fE);
                }
            };
            this.imeSyncFallbackRunnable = runnable;
            View view3 = this.rootView;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("rootView");
                view3 = null;
            }
            view3.postDelayed(runnable, 50L);
            n4();
            F3();
        }
        View view4 = this.scrimView;
        if (view4 == null) {
            kotlin.jvm.internal.p.A("scrimView");
            view4 = null;
        }
        ViewPropertyAnimator duration = view4.animate().alpha(0.0f).setDuration(250L);
        PathInterpolator pathInterpolator = SCRIM_INTERPOLATOR;
        duration.setInterpolator(pathInterpolator).start();
        View view5 = this.vBottomView;
        if (view5 != null) {
            view5.animate().cancel();
            view5.animate().alpha(0.0f).setDuration(250L).setInterpolator(pathInterpolator).start();
        }
        View view6 = this.dragBar;
        if (view6 != null) {
            if (view6 == null) {
                kotlin.jvm.internal.p.A("dragBar");
                view6 = null;
            }
            view6.removeCallbacks(this.restoreDragBarTintRunnable);
            View view7 = this.dragBar;
            if (view7 == null) {
                kotlin.jvm.internal.p.A("dragBar");
            } else {
                view = view7;
            }
            view.postDelayed(this.restoreDragBarTintRunnable, 250L);
        }
    }

    public final void J5(int h10) {
        ViewGroup.LayoutParams layoutParams;
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout == null || (layoutParams = launcherChatLayout.getLayoutParams()) == null) {
            return;
        }
        if (layoutParams.height != h10) {
            layoutParams.height = h10;
            launcherChatLayout.setLayoutParams(layoutParams);
        }
        z6(h10);
        J j10 = this.currentState;
        J j11 = J.e.INSTANCE;
        if (h10 > 0) {
            j11 = kotlin.jvm.internal.p.d(j10, j11) ? J.d.INSTANCE : this.currentState;
        }
        K5(j11);
        J.e eVar = J.e.INSTANCE;
        if (kotlin.jvm.internal.p.d(j10, eVar) != kotlin.jvm.internal.p.d(this.currentState, eVar)) {
            V2(this.currentState);
            A6(this.currentState);
        }
        k6(h10);
    }

    public final void K2(float target, float stiffness) {
        androidx.dynamicanimation.animation.i iVar = this.translationYAnim;
        if (iVar != null) {
            iVar.d();
        }
        View view = this.panelView;
        if (view == null) {
            kotlin.jvm.internal.p.A("panelView");
            view = null;
        }
        androidx.dynamicanimation.animation.i iVar2 = new androidx.dynamicanimation.animation.i(view, androidx.dynamicanimation.animation.e.f13691o, target);
        iVar2.y().f(SPRING_DAMPING_NORMAL);
        iVar2.y().h(stiffness);
        iVar2.y().g(target);
        iVar2.t();
        this.translationYAnim = iVar2;
        V2(this.currentState);
    }

    public final void K4(String reason) {
        long j10 = this.aiKeyLongClickGeneration + 1;
        this.aiKeyLongClickGeneration = j10;
        C4148a.d(this.TAG, "aiKeyLongClick START invalidated generation=" + j10 + " reason=" + reason, false, 4, null);
    }

    public final void K5(J j10) {
        boolean zD = kotlin.jvm.internal.p.d(this.currentState, j10);
        this.currentState = j10;
        if (zD) {
            return;
        }
        m6(j10);
        B6(j10);
        T2();
    }

    public final void L3() {
        TextView textView;
        boolean z10 = kotlin.jvm.internal.p.d(this.currentState, J.e.INSTANCE) && (this.asrFinalizing || this.aiWakeWaiting);
        if (z10 && (textView = this.aiWaitingText) != null) {
            textView.setText(this.asrFinalizing ? R$string.wake_asr_finalizing : R$string.wake_scanning_info);
        }
        View view = this.aiWaitingBar;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
        aiWaitingBarShowing = z10;
        BaseInputView baseInputView = this.inputView;
        if (baseInputView != null) {
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            baseInputView.setVisibility(z10 ? 4 : 0);
        }
        l6(z10);
    }

    public final boolean L4() {
        ChatMessageAdapter chatMessageAdapter = this.chatMessageAdapter;
        return chatMessageAdapter == null || chatMessageAdapter.getItemCount() == 0;
    }

    public final void L5(InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(interfaceC5063a, "<set-?>");
        this.onCancelSilentCapture = interfaceC5063a;
    }

    public final void M2(J target, boolean useFlingSpec) {
        kotlin.jvm.internal.p.i(target, "target");
        if (this.navigatingToChat || this.panelView == null || this.chatLayout == null) {
            return;
        }
        if (kotlin.jvm.internal.p.d(target, J.c.INSTANCE)) {
            X4();
            return;
        }
        float fV3 = v3(target);
        C4148a.d(this.TAG, "animateToState: " + this.currentState + " → " + target + ", chatH=" + fV3, false, 4, null);
        boolean zD = kotlin.jvm.internal.p.d(target, J.e.INSTANCE);
        K5(target);
        if (!zD) {
            A6(target);
        }
        V2(target);
        z5();
        androidx.dynamicanimation.animation.i iVar = this.chatHeightAnim;
        if (iVar != null) {
            iVar.d();
        }
        androidx.dynamicanimation.animation.i iVar2 = new androidx.dynamicanimation.animation.i(this.chatLayout, this.chatHeightProperty, fV3);
        iVar2.y().f(zD ? 1.0f : SPRING_DAMPING_NORMAL);
        iVar2.y().h(SPRING_STIFFNESS_NORMAL);
        iVar2.y().g(fV3);
        if (zD) {
            iVar2.b(new e.q() { // from class: com.stepos.ailauncher.chat.wake.i1
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    WakeDialogImpl.O2(this.f26815a, eVar, z10, f10, f11);
                }
            });
        }
        iVar2.t();
        this.chatHeightAnim = iVar2;
    }

    public final int M3(int dp) {
        return (int) ((dp * e4()) + 0.5f);
    }

    /* renamed from: M4, reason: from getter */
    public final boolean getDismissingWithAnim() {
        return this.dismissingWithAnim;
    }

    public final void M5() {
        View view = this.rootView;
        if (view == null) {
            return;
        }
        if (view == null) {
            kotlin.jvm.internal.p.A("rootView");
            view = null;
        }
        androidx.core.view.N.E0(view, new k());
    }

    @Override // com.stepos.ailauncher.chat.wake.DialogC3116e0
    public boolean N() {
        return this.dismissingWithAnim || this.navigatingToChat || WakeService.INSTANCE.t0();
    }

    public final void N3() {
        if (this.chatPanelWrapper != null) {
            return;
        }
        SlaChatController slaChatController = null;
        if (this.dismissingWithAnim) {
            C4148a.d(this.TAG, "ensureChatPanelInflated: dismissing, skip inflate", false, 4, null);
            return;
        }
        ViewStub viewStub = (ViewStub) findViewById(R$id.vs_chat_panel_wrapper);
        if (viewStub == null) {
            return;
        }
        q6("ensureChatPanelInflated: begin inflate");
        View viewInflate = viewStub.inflate();
        ViewGroup viewGroup = viewInflate instanceof ViewGroup ? (ViewGroup) viewInflate : null;
        if (viewGroup == null) {
            C4148a.u(this.TAG, "ensureChatPanelInflated: inflate returned non-ViewGroup, abort", false, 4, null);
            return;
        }
        this.chatPanelWrapper = viewGroup;
        final LauncherChatLayout launcherChatLayout = (LauncherChatLayout) viewGroup.findViewById(R$id.aclChat);
        if (launcherChatLayout == null) {
            C4148a.u(this.TAG, "ensureChatPanelInflated: aclChat not found in inflated view, abort", false, 4, null);
            return;
        }
        this.chatLayout = launcherChatLayout;
        q6("ensureChatPanelInflated: stub inflated + refs assigned");
        ViewGroup.LayoutParams layoutParams = launcherChatLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = 0;
        launcherChatLayout.setLayoutParams(layoutParams);
        z6(0);
        com.stepos.ailauncher.chat.tts.a.INSTANCE.n(launcherChatLayout);
        launcherChatLayout.setOnReceiveMessage(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.L0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.Q3(this.f26643a, (DisplayMessage) obj);
            }
        });
        launcherChatLayout.setOnUserBubbleShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.N0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.R3(this.f26648a, (DisplayMessage) obj);
            }
        });
        k3();
        this.chatMessageAdapter = launcherChatLayout.getAdapter();
        launcherChatLayout.setTtsPlayerListener(new f());
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler != null) {
            launcherChatLayout.k3(sessionHandler);
            AgentUIConfig agentUIConfig = this.savedAgentUiConfig;
            if (agentUIConfig != null) {
                launcherChatLayout.setAgentUiConfig(agentUIConfig);
            }
            BaseInputView baseInputView = this.inputView;
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            launcherChatLayout.m3(baseInputView);
            launcherChatLayout.setEmptyShowEnable(false);
            SlaChatController slaChatController2 = this.slaController;
            if (slaChatController2 != null && slaChatController2.B0(sessionHandler)) {
                slaChatController = slaChatController2;
            }
            if (slaChatController == null) {
                Context context = getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                slaChatController = new SlaChatController(context, sessionHandler);
                this.slaController = slaChatController;
            }
            slaChatController.v0(launcherChatLayout, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.O0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(WakeDialogImpl.S3(this.f26649a, launcherChatLayout));
                }
            });
            slaChatController.V0(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.P0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WakeDialogImpl.T3(this.f26653a, (com.stepos.ailauncher.chat.view.sla.a) obj);
                }
            });
        }
        launcherChatLayout.setCanPlayTTS(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.Q0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(WakeDialogImpl.O3(this.f26654a));
            }
        });
        launcherChatLayout.setOnRoundUnsuccessfulListener(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.R0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.P3(this.f26655a);
            }
        });
        P5();
        q6("ensureChatPanelInflated: done (all bindings + glass ready)");
    }

    public final boolean N4() {
        return !this.swipeHasDownwardReversal;
    }

    public final void N5() {
        BaseInputView baseInputView = this.inputView;
        if (baseInputView == null) {
            return;
        }
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.wake.a1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                WakeDialogImpl.O5(this.f26692a, view, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        });
    }

    @Override // com.stepos.ailauncher.chat.wake.DialogC3116e0
    public void O() {
        if (this.navigatingToChat) {
            return;
        }
        com.stepos.ailauncher.chat.tts.a.INSTANCE.x();
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.p7();
        }
    }

    public final void P5() {
        C2851i7 c2851i7;
        y7.E eD;
        View view = this.chatPanelWrapper;
        if (view != null && (eD = C2851i7.d((c2851i7 = C2851i7.INSTANCE), view, true, Float.valueOf(20.0f), null, 8, null)) != null) {
            this.chatPanelBlurHandle = eD;
            this.chatPanelOriginalForeground = view.getForeground();
            view.setForeground(androidx.core.content.a.e(getContext(), R$drawable.bg_wake_panel_blur_stroke));
            c2851i7.i(view, eD, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.c1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WakeDialogImpl.Q5(this.f26699a, (y7.E) obj);
                }
            });
        }
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.setScrollToBottomBlurCrossWindow(true);
            B6(this.currentState);
        }
    }

    public final void R2(boolean onScrim) {
        View view = this.dragBar;
        if (view == null) {
            return;
        }
        int i10 = onScrim ? DRAG_BAR_COLOR_ON_SCRIM : DRAG_BAR_COLOR_DEFAULT;
        if (view == null) {
            kotlin.jvm.internal.p.A("dragBar");
            view = null;
        }
        view.setBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public final void R4() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        final int iB4 = b4(context, R$attr.colorOnSurface);
        MarkwonHelper.n(iB4);
        final int i10 = MarkwonHelper.DEFAULT_THEMATIC_BREAK_COLOR;
        MarkwonHelper.u0(MarkwonHelper.DEFAULT_THEMATIC_BREAK_COLOR);
        MarkwonHelper.t0(iB4);
        MarkwonHelper.y0(new MarkwonHelper.q() { // from class: com.stepos.ailauncher.chat.wake.i0
            @Override // com.stepos.agentframework.uikit.MarkwonHelper.q
            public final void a(C5671a.C0540a c0540a) {
                WakeDialogImpl.S4(iB4, this, i10, c0540a);
            }
        });
    }

    public final void R5() {
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.wake.l0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return WakeDialogImpl.S5(this.f26831a, view, motionEvent);
            }
        };
        ConstraintLayout constraintLayout = this.dragHandleArea;
        BaseInputView baseInputView = null;
        if (constraintLayout == null) {
            kotlin.jvm.internal.p.A("dragHandleArea");
            constraintLayout = null;
        }
        constraintLayout.setOnTouchListener(onTouchListener);
        ConstraintLayout constraintLayout2 = this.dragHandleArea;
        if (constraintLayout2 == null) {
            kotlin.jvm.internal.p.A("dragHandleArea");
            constraintLayout2 = null;
        }
        constraintLayout2.setClickable(true);
        final View viewFindViewById = findViewById(R$id.wake_chat_drag_wrapper);
        if (viewFindViewById != null) {
            final int iM3 = M3(42);
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.f34818a = -1;
            final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.m0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return WakeDialogImpl.T5(viewFindViewById, ref$IntRef, iM3, this);
                }
            };
            viewFindViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.wake.n0
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    WakeDialogImpl.U5(interfaceC5063a, view, i10, i11, i12, i13, i14, i15, i16, i17);
                }
            });
            if (viewFindViewById.getWidth() > 0) {
                interfaceC5063a.invoke();
            }
        }
        BaseInputView baseInputView2 = this.inputView;
        if (baseInputView2 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView = baseInputView2;
        }
        baseInputView.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.wake.o0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return WakeDialogImpl.V5(this.f26846a, view, motionEvent);
            }
        });
    }

    public final void S2(com.stepos.ailauncher.chat.view.sla.a resolution) {
        if (!this.halfPopupSendCoordinator.e(resolution.getTraceId())) {
            C4148a.d(this.TAG, "applyHalfPopupResolution ignore stale/duplicate resolution=" + resolution, false, 4, null);
            return;
        }
        C4148a.d(this.TAG, "applyHalfPopupResolution resolution=" + resolution, false, 4, null);
        C0919o.c("INPUT_BAR", "执行半屏决议(state=" + this.currentState + ")", true);
        if (!(resolution instanceof a.Expand)) {
            if (resolution instanceof a.Close) {
                if (isShowing()) {
                    J3();
                    return;
                }
                return;
            } else {
                if (!(resolution instanceof a.RestoreInput)) {
                    throw new NoWhenBranchMatchedException();
                }
                j6(false);
                m6(this.currentState);
                return;
            }
        }
        j6(false);
        if (isShowing() && kotlin.jvm.internal.p.d(this.currentState, J.e.INSTANCE)) {
            if (!a6()) {
                W3();
                return;
            }
            C4148a.d(this.TAG, "applyHalfPopupResolution suppress half expand: AgentSpace overlay foreground, keep Minify, resolution=" + resolution, false, 4, null);
            C0919o.c("INPUT_BAR", "AgentSpace 前台,抑制半屏展开", true);
        }
    }

    public final void T2() {
        Drawable dVar;
        View view = this.inputBarStrokeTarget;
        if (view == null) {
            return;
        }
        float fM3 = M3(24);
        int iM3 = M3(1);
        if (this.keyboardShowing) {
            dVar = new com.stepos.ailauncher.chat.wake.blur.d(fM3, iM3, INPUT_BAR_STROKE_GRADIENT, null, false, 24, null);
        } else {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(fM3);
            gradientDrawable.setStroke(iM3, INPUT_BAR_STROKE_SOLID_COLOR);
            gradientDrawable.setColor(0);
            dVar = gradientDrawable;
        }
        view.setForeground(dVar);
    }

    public final int T4() {
        return v3(J.c.INSTANCE);
    }

    public final void U2() {
        if (this.lockscreenKeepScreenOnApplied) {
            return;
        }
        this.lockscreenKeepScreenOnApplied = true;
        g4().f(com.stepos.ailauncher.chat.util.g.REASON_LOCKSCREEN, LOCKSCREEN_KEEP_SCREEN_ON_TIMEOUT_MS);
    }

    public final int U4(int dragStartChatHeightPx) {
        return L4() ? dragStartChatHeightPx : T4();
    }

    public final void V2(J state) {
        View view = this.panelView;
        if (view == null) {
            kotlin.jvm.internal.p.A("panelView");
            view = null;
        }
        view.setBackgroundColor(0);
    }

    public final void V3() {
        BaseInputView baseInputView;
        FloatCardContainerView floatCardContainerView;
        FloatCardContainerView floatCardContainerView2 = this.floatCardContainer;
        if ((floatCardContainerView2 == null || this.floatCardHost == null) && (baseInputView = this.inputView) != null) {
            if (floatCardContainerView2 == null) {
                FloatCardContainerView floatCardContainerView3 = null;
                if (baseInputView == null) {
                    kotlin.jvm.internal.p.A("inputView");
                    baseInputView = null;
                }
                ViewStub viewStub = (ViewStub) baseInputView.findViewById(R$id.vsInfoCard);
                if (viewStub != null) {
                    View viewInflate = viewStub.inflate();
                    ViewGroup viewGroup = viewInflate instanceof ViewGroup ? (ViewGroup) viewInflate : null;
                    if (viewGroup != null && (floatCardContainerView = (FloatCardContainerView) viewGroup.findViewById(R$id.float_card_container)) != null) {
                        floatCardContainerView3 = floatCardContainerView;
                    } else if (viewInflate instanceof FloatCardContainerView) {
                        floatCardContainerView3 = (FloatCardContainerView) viewInflate;
                    }
                    this.floatCardContainer = floatCardContainerView3;
                }
            }
            if (this.floatCardContainer == null || this.floatCardHost != null) {
                return;
            }
            t5();
        }
    }

    public final void V4(MotionEvent ev) {
        View view;
        if (kotlin.jvm.internal.p.d(this.currentState, J.d.INSTANCE) && this.keyboardShowing && (view = this.chatPanelWrapper) != null && p4(view, ev.getRawX(), ev.getRawY())) {
            n4();
        }
    }

    public final void W2(String message, List<FileInfo> files, boolean defaultSend) {
        kotlin.jvm.internal.p.i(message, "message");
        X2(message, files, defaultSend, null);
    }

    public final void W3() {
        N2(this, J.d.INSTANCE, false, 2, null);
    }

    public final void W4() {
        Y8.t tVar;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Result.Companion companion = Result.INSTANCE;
            Display display = getContext().getDisplay();
            if (display != null) {
                display.getRealMetrics(displayMetrics);
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        Integer numValueOf = Integer.valueOf(displayMetrics.heightPixels);
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        this.screenHeightPx = numValueOf != null ? numValueOf.intValue() : getContext().getResources().getDisplayMetrics().heightPixels;
        Integer numValueOf2 = Integer.valueOf(displayMetrics.widthPixels);
        Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
        this.screenWidthPx = num != null ? num.intValue() : getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public final void X2(final String message, final List<FileInfo> files, final boolean defaultSend, String msgSource) {
        List<FileInfo> list;
        kotlin.jvm.internal.p.i(message, "message");
        if ((message.length() == 0 && ((list = files) == null || list.isEmpty())) || this.inputView == null) {
            return;
        }
        BaseInputView baseInputView = null;
        final String str = (msgSource == null || msgSource.length() <= 0) ? null : msgSource;
        BaseInputView baseInputView2 = this.inputView;
        if (baseInputView2 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView = baseInputView2;
        }
        baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.f1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.Y2(this.f26758a, message, files, defaultSend, str);
            }
        });
    }

    public final void X4() {
        AgentSession.AgentConversation agentConversationR1;
        AgentSession.AgentConversation agentConversationR12;
        if (this.navigatingToChat) {
            return;
        }
        SessionHandler sessionHandler = this.sessionHandler;
        View view = null;
        String strB = (sessionHandler == null || (agentConversationR12 = sessionHandler.R1()) == null) ? null : agentConversationR12.B();
        String str = this.TAG;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        J j10 = this.currentState;
        Boolean boolValueOf = Boolean.valueOf(this.hasPendingSend);
        Boolean boolValueOf2 = Boolean.valueOf(this.deferredNavigatePending);
        ChatMessageAdapter chatMessageAdapter = this.chatMessageAdapter;
        String str2 = String.format("navigateToChatMainActivity: sid=%s state=%s hasPendingSend=%s deferred=%s adapterCount=%d", Arrays.copyOf(new Object[]{strB, j10, boolValueOf, boolValueOf2, Integer.valueOf(chatMessageAdapter != null ? chatMessageAdapter.getItemCount() : -1)}, 5));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.k(str, str2, false, 4, null);
        InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
        x3();
        SessionHandler sessionHandler2 = this.sessionHandler;
        String strB2 = (sessionHandler2 == null || (agentConversationR1 = sessionHandler2.R1()) == null) ? null : agentConversationR1.B();
        if ((strB2 == null || strB2.length() == 0) && this.hasPendingSend) {
            if (this.deferredNavigatePending) {
                return;
            }
            this.deferredNavigatePending = true;
            View view2 = this.rootView;
            if (view2 == null) {
                kotlin.jvm.internal.p.A("rootView");
                view2 = null;
            }
            view2.postDelayed(this.deferredNavigateTimeout, this.deferredNavigateTimeoutMs);
            C4148a.k(this.TAG, "navigateToChatMainActivity: sessionId empty & send in flight, defer " + this.deferredNavigateTimeoutMs + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
            return;
        }
        if (this.deferredNavigatePending) {
            this.deferredNavigatePending = false;
            View view3 = this.rootView;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("rootView");
                view3 = null;
            }
            view3.removeCallbacks(this.deferredNavigateTimeout);
        }
        this.navigatingToChat = true;
        this.skipSessionReset = true;
        INSTANCE.a();
        SessionHandler sessionHandler3 = this.sessionHandler;
        if (sessionHandler3 != null) {
            AgentConfig.Companion companion = AgentConfig.INSTANCE;
            companion.a().x(sessionHandler3);
            companion.a().w(sessionHandler3);
        }
        BaseInputView baseInputView = this.inputView;
        if (baseInputView != null) {
            C2689c0 c2689c0 = C2689c0.INSTANCE;
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            c2689c0.b(baseInputView);
        }
        Context applicationContext = getContext().getApplicationContext();
        Object systemService = applicationContext.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        boolean z10 = keyguardManager != null && keyguardManager.isKeyguardLocked();
        if (z10) {
            C4148a.k(this.TAG, "navigateToChatMainActivity: keyguard locked, set EXTRA_FROM_LOCKSCREEN_WAKE", false, 4, null);
        }
        Intent intent = new Intent();
        intent.setClassName(applicationContext.getPackageName(), "com.stepos.ailauncher.chat.activity.ChatMainActivity");
        intent.addFlags(805306368);
        intent.putExtra(EXTRA_REBIND_SESSION, true);
        if (z10) {
            intent.putExtra(ChatMainActivity.EXTRA_FROM_LOCKSCREEN_WAKE, true);
        }
        C2682o.INSTANCE.f(intent);
        WakeService.Companion companion2 = WakeService.INSTANCE;
        ExternalSessionRef externalSessionRefV0 = companion2.v0();
        if (externalSessionRefV0 != null) {
            intent.putExtra(EXTRA_EXTERNAL_DEVICE_ID, externalSessionRefV0.getDeviceId());
            intent.putExtra(EXTRA_EXTERNAL_AGENT_TYPE, externalSessionRefV0.getAgentType());
            intent.putExtra(EXTRA_EXTERNAL_SESSION_ID, externalSessionRefV0.getSessionId());
            intent.putExtra(EXTRA_EXTERNAL_DEVICE_NAME, externalSessionRefV0.getDeviceName());
            intent.putExtra(EXTRA_EXTERNAL_DEVICE_ONLINE, externalSessionRefV0.getDeviceOnline());
            companion2.p1(null);
        }
        try {
            applicationContext.startActivity(intent);
            androidx.dynamicanimation.animation.i iVar = this.chatHeightAnim;
            if (iVar != null) {
                iVar.d();
            }
            this.chatHeightAnim = null;
            androidx.dynamicanimation.animation.i iVar2 = this.translationYAnim;
            if (iVar2 != null) {
                iVar2.d();
            }
            this.translationYAnim = null;
            View view4 = this.scrimView;
            if (view4 != null) {
                if (view4 == null) {
                    kotlin.jvm.internal.p.A("scrimView");
                    view4 = null;
                }
                view4.animate().cancel();
                View view5 = this.scrimView;
                if (view5 == null) {
                    kotlin.jvm.internal.p.A("scrimView");
                    view5 = null;
                }
                view5.setAlpha(0.0f);
            }
            this.voiceGloballyStoppedForDismiss = true;
            View view6 = this.rootView;
            if (view6 == null) {
                kotlin.jvm.internal.p.A("rootView");
            } else {
                view = view6;
            }
            view.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.U0
                @Override // java.lang.Runnable
                public final void run() {
                    WakeDialogImpl.Y4(this.f26665a);
                }
            }, 80L);
        } catch (Throwable th) {
            C4148a.g(this.TAG, "navigateToChatMainActivity: startActivity failed", th, false, 8, null);
            this.navigatingToChat = false;
            this.skipSessionReset = false;
            INSTANCE.b();
            C2689c0.INSTANCE.c();
        }
    }

    public final void Y3() {
        ViewGroup.LayoutParams layoutParams;
        AgentSession.AgentConversation agentConversationR1;
        if (this.navigatingToChat) {
            return;
        }
        String strB = null;
        InputViewManager.f1(InputViewManager.INSTANCE, null, 1, null);
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler != null && (agentConversationR1 = sessionHandler.R1()) != null) {
            strB = agentConversationR1.B();
        }
        int iF = 0;
        boolean z10 = (strB == null || strB.length() == 0) && this.hasPendingSend;
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout != null && (layoutParams = launcherChatLayout.getLayoutParams()) != null) {
            iF = C5685n.f(layoutParams.height, 0);
        }
        int iV3 = z10 ? v3(J.d.INSTANCE) : T4();
        if (iV3 > iF) {
            androidx.dynamicanimation.animation.i iVar = this.chatHeightAnim;
            if (iVar != null) {
                iVar.d();
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iF, iV3);
            valueAnimatorOfInt.setDuration(120L);
            valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.wake.T0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WakeDialogImpl.Z3(this.f26664a, valueAnimator);
                }
            });
            valueAnimatorOfInt.start();
        }
        X4();
    }

    public final int Z4() {
        int iIntValue;
        ConstraintLayout constraintLayout = this.dragHandleArea;
        if (constraintLayout == null) {
            kotlin.jvm.internal.p.A("dragHandleArea");
            constraintLayout = null;
        }
        Integer numValueOf = Integer.valueOf(constraintLayout.getHeight());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue2 = numValueOf != null ? numValueOf.intValue() : M3(16);
        BaseInputView baseInputView = this.inputView;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        Integer numValueOf2 = Integer.valueOf(baseInputView.getHeight());
        if (numValueOf2.intValue() <= 0) {
            numValueOf2 = null;
        }
        if (numValueOf2 != null) {
            iIntValue = numValueOf2.intValue();
        } else {
            BaseInputView baseInputView2 = this.inputView;
            if (baseInputView2 == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView2 = null;
            }
            Integer numValueOf3 = Integer.valueOf(baseInputView2.getMeasuredHeight());
            Integer num = numValueOf3.intValue() > 0 ? numValueOf3 : null;
            iIntValue = num != null ? num.intValue() : M3(132);
        }
        FloatCardContainerView floatCardContainerView = this.floatCardContainer;
        return iIntValue2 + M3(0) + (iIntValue - ((floatCardContainerView == null || floatCardContainerView.getVisibility() != 0) ? 0 : floatCardContainerView.getHeight())) + this.navigationHeight;
    }

    public final boolean Z5() {
        BaseInputView baseInputView = this.inputView;
        if (baseInputView == null) {
            return false;
        }
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        return baseInputView.vb();
    }

    public final void a3(String sessionId) {
        Object objB;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        N3();
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            launcherChatLayout.U4(sessionId);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(this.TAG, "applySessionId: loadConversation failed", thE, false, 8, null);
        }
        W3();
    }

    public final boolean a6() {
        return com.stepos.ailauncher.common.utils.y.INSTANCE.e("agent_space");
    }

    public final void b3(final String text, final List<? extends Uri> uris) {
        BaseInputView baseInputView;
        kotlin.jvm.internal.p.i(uris, "uris");
        if (((text == null || text.length() == 0) && uris.isEmpty()) || (baseInputView = this.inputView) == null) {
            return;
        }
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.g1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.c3(this.f26769a, text, uris);
            }
        });
    }

    public final int b4(Context context, int attrResId) {
        kotlin.jvm.internal.p.i(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attrResId, typedValue, true);
        return typedValue.data;
    }

    public final void b6(WakeService.SuggestPayload payload) {
        FloatCardContent floatCardContent;
        IFloatCardService iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
        if (iFloatCardService == null) {
            C4148a.u(this.TAG, "showSuggestCardInternal: IFloatCardService is null", false, 4, null);
            return;
        }
        V3();
        if (this.floatCardHost == null) {
            C4148a.u(this.TAG, "showSuggestCardInternal: floatCardHost is null", false, 4, null);
            return;
        }
        if (this.suggestCardEventHandler == null) {
            U u10 = new U(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.x1
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WakeDialogImpl.c6(this.f26886a, (String) obj);
                }
            });
            this.suggestCardEventHandler = u10;
            kotlin.jvm.internal.p.f(u10);
            iFloatCardService.registerEventHandler(u10);
        }
        boolean zIsEmpty = payload.b().isEmpty();
        String str = this.currentSuggestCardId;
        if (str != null && !zIsEmpty) {
            String str2 = this.TAG;
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str3 = String.format("showSuggestCardInternal: update cardId='%s' items=%d", Arrays.copyOf(new Object[]{str, Integer.valueOf(payload.b().size())}, 2));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            C4148a.d(str2, str3, false, 4, null);
            List<String> listB = payload.b();
            ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
            for (String str4 : listB) {
                arrayList.add(new FloatCardOption(str4, str4, false, false, false, 28, null));
            }
            iFloatCardService.update(str, new FloatCardContent(C1172u.e(new FloatCardPage(payload.getTitle(), null, null, null, C1172u.e(new g.Selection("suggest_selection", null, arrayList, SelectionMode.Single, FloatCardOptionStyle.Plain, false, 34, null)), null, null, Boolean.FALSE, null, null, 878, null)), null, FloatCardStatus.Normal, null, null, 26, null));
            return;
        }
        String str5 = "suggest_card_" + System.currentTimeMillis();
        this.currentSuggestCardId = str5;
        if (zIsEmpty) {
            floatCardContent = new FloatCardContent(C1172u.e(new FloatCardPage(payload.getTitle(), null, null, null, null, null, null, Boolean.FALSE, null, null, 894, null)), null, FloatCardStatus.Loading, null, null, 26, null);
        } else {
            List<String> listB2 = payload.b();
            ArrayList arrayList2 = new ArrayList(C1174w.x(listB2, 10));
            for (String str6 : listB2) {
                arrayList2.add(new FloatCardOption(str6, str6, false, false, false, 28, null));
            }
            floatCardContent = new FloatCardContent(C1172u.e(new FloatCardPage(payload.getTitle(), null, null, null, C1172u.e(new g.Selection("suggest_selection", null, arrayList2, SelectionMode.Single, FloatCardOptionStyle.Plain, false, 34, null)), null, null, Boolean.FALSE, null, null, 878, null)), null, null, null, null, 30, null);
        }
        FloatCardRequest floatCardRequest = new FloatCardRequest(str5, "common_form", U.BUSINESS_TYPE, FloatCardScene.WakeDialog, floatCardContent, new FloatCardOptions(false, true, true, false, false, 24, null), null, 64, null);
        String str7 = this.TAG;
        kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
        String str8 = String.format("showSuggestCardInternal: show cardId='%s' isLoading=%s", Arrays.copyOf(new Object[]{str5, Boolean.valueOf(zIsEmpty)}, 2));
        kotlin.jvm.internal.p.h(str8, "format(...)");
        C4148a.d(str7, str8, false, 4, null);
        iFloatCardService.show(floatCardRequest);
    }

    public final int c4() {
        return ((Number) this.chatBgFadeThresholdPx.getValue()).intValue();
    }

    public final void d3(final String source) {
        final Long lValueOf;
        if (source == null || source.length() == 0 || this.inputView == null) {
            return;
        }
        this.currentStartSource = source;
        ChatTracker chatTracker = ChatTracker.INSTANCE;
        chatTracker.y(chatTracker.t(source));
        BaseInputView baseInputView = null;
        if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_START)) {
            this.skipEntranceAnim = true;
            long j10 = this.aiKeyLongClickGeneration + 1;
            this.aiKeyLongClickGeneration = j10;
            C4148a.d(this.TAG, "aiKeyLongClick START scheduled generation=" + j10, false, 4, null);
            lValueOf = Long.valueOf(this.aiKeyLongClickGeneration);
        } else {
            lValueOf = null;
        }
        if (kotlin.jvm.internal.p.d(source, C4814a.AI_KEY_LONG_CLICK_END)) {
            K4("END");
        }
        final String str = INSTANCE.f(source) ? MSG_SOURCE_AI_WAKE : null;
        BaseInputView baseInputView2 = this.inputView;
        if (baseInputView2 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView = baseInputView2;
        }
        baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.k0
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.e3(str, source, this, lValueOf);
            }
        });
    }

    public final int d4() {
        return ((Number) this.chatStrokeFadeThresholdPx.getValue()).intValue();
    }

    public final void d6() {
        WindowManager.LayoutParams attributes;
        if (this.dismissingWithAnim) {
            C4148a.d(this.TAG, "shrinkWindowToPanel: skip while dismissing", false, 4, null);
            return;
        }
        Window window = getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        if (!this.windowShrunkToPanel) {
            this.flagsBeforeShrink = Integer.valueOf(attributes.flags);
        }
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = 0;
        attributes.flags |= 32;
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(attributes);
        }
        this.windowShrunkToPanel = true;
        String str = this.TAG;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        Integer numValueOf = Integer.valueOf(attributes.height);
        String string = Integer.toString(attributes.flags, C0951a.a(16));
        kotlin.jvm.internal.p.h(string, "toString(...)");
        String str2 = String.format("shrinkWindowToPanel: height=%d flags=0x%s", Arrays.copyOf(new Object[]{numValueOf, string}, 2));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(str, str2, false, 4, null);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getActionMasked() == 0) {
            this.swipeOriginInDragArea = o4(ev);
            V4(ev);
        }
        C6(ev);
        if (this.swipeOriginInDragArea) {
            f4().onTouchEvent(ev);
        }
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            this.swipeOriginInDragArea = false;
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void e6(InterfaceC5063a<Y8.t> start) {
        if (this.panelView == null) {
            start.invoke();
            return;
        }
        androidx.dynamicanimation.animation.i iVar = this.translationYAnim;
        View view = null;
        if (iVar == null || !iVar.i()) {
            iVar = null;
        }
        if (iVar != null) {
            iVar.b(new n(start));
            return;
        }
        View view2 = this.panelView;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view2 = null;
        }
        if (Math.abs(view2.getTranslationY()) > 0.5f) {
            View view3 = this.panelView;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("panelView");
            } else {
                view = view3;
            }
            androidx.core.view.D.a(view, new l(view, this, start));
            return;
        }
        View view4 = this.panelView;
        if (view4 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view4 = null;
        }
        if (view4.getVisibility() == 0) {
            BaseInputView baseInputView = this.inputView;
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            if (baseInputView.isLaidOut()) {
                start.invoke();
                return;
            }
        }
        View view5 = this.panelView;
        if (view5 == null) {
            kotlin.jvm.internal.p.A("panelView");
        } else {
            view = view5;
        }
        androidx.core.view.D.a(view, new m(view, this, start));
    }

    public final GestureDetector f4() {
        return (GestureDetector) this.flingDetector.getValue();
    }

    public final void f6() {
        this.aiWakeWaiting = true;
        m6(this.currentState);
    }

    public final void g3(final WakeService.SuggestPayload payload) {
        kotlin.jvm.internal.p.i(payload, "payload");
        String str = this.TAG;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str2 = String.format("applySuggestCard: items=%d currentCardId=%s", Arrays.copyOf(new Object[]{Integer.valueOf(payload.b().size()), this.currentSuggestCardId}, 2));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        BaseInputView baseInputView = null;
        C4148a.d(str, str2, false, 4, null);
        if (this.inputView == null) {
            return;
        }
        String fileId = payload.getFileId();
        if (fileId != null && fileId.length() != 0) {
            this.pendingFileIdForMapping = payload.getFileId();
        }
        BaseInputView baseInputView2 = this.inputView;
        if (baseInputView2 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView = baseInputView2;
        }
        baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.e1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.h3(this.f26743a, payload);
            }
        });
    }

    public final com.stepos.ailauncher.chat.util.g g4() {
        return (com.stepos.ailauncher.chat.util.g) this.keepScreenOnController.getValue();
    }

    public final void g5() {
        BaseInputView baseInputView = this.inputView;
        if (baseInputView == null) {
            return;
        }
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.Z0
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.h5(this.f26686a);
            }
        });
    }

    public final void g6(float endTransY) {
        if (this.imeAnimationRunning) {
            return;
        }
        View view = this.panelView;
        if (view == null) {
            kotlin.jvm.internal.p.A("panelView");
            view = null;
        }
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, androidx.dynamicanimation.animation.e.f13691o, endTransY);
        iVar.y().f(1.0f);
        iVar.y().h(SPRING_STIFFNESS_KEYBOARD);
        iVar.y().g(endTransY);
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.chat.wake.K0
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                WakeDialogImpl.h6(this.f26640a, eVar, z10, f10, f11);
            }
        });
        iVar.t();
        this.translationYAnim = iVar;
    }

    public final com.stepos.ailauncher.chat.wake.effect.c h4() {
        return (com.stepos.ailauncher.chat.wake.effect.c) this.recordingSpectrumController.getValue();
    }

    public final void i3() {
        View view = this.aiWaitingBar;
        if (view == null) {
            return;
        }
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        c2851i7.h(this.aiWaitingBarGlassHandle);
        y7.E eD = C2851i7.d(c2851i7, view, true, Float.valueOf(28.0f), null, 8, null);
        this.aiWaitingBarGlassHandle = eD;
        c2851i7.i(view, eD, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.E1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.j3(this.f26618a, (y7.E) obj);
            }
        });
    }

    public final Ua.M i4() {
        return getDialogCoroutineScope();
    }

    public final void i5(final Uri uri, final long screenshotRound) {
        kotlin.jvm.internal.p.i(uri, "uri");
        BaseInputView baseInputView = this.inputView;
        if (baseInputView == null) {
            return;
        }
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.w1
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.j5(this.f26880a, uri, screenshotRound);
            }
        });
    }

    public final void i6() {
        BaseInputView baseInputView = this.inputView;
        if (baseInputView == null) {
            return;
        }
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.rc();
    }

    public final WindowManager j4() {
        return (WindowManager) this.touchBlockerWindowManager.getValue();
    }

    public final void j6(boolean triggerCancel) {
        BaseInputView baseInputView;
        View view;
        if (this.aiWakeWaiting || ((view = this.aiWaitingBar) != null && view.getVisibility() == 0)) {
            this.aiWakeWaiting = false;
            m6(this.currentState);
            if (!triggerCancel || (baseInputView = this.inputView) == null) {
                return;
            }
            BaseInputView baseInputView2 = null;
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            InterfaceC5063a<Boolean> onStopClicked = baseInputView.getOnStopClicked();
            if (onStopClicked != null ? onStopClicked.invoke().booleanValue() : false) {
                return;
            }
            BaseInputView baseInputView3 = this.inputView;
            if (baseInputView3 == null) {
                kotlin.jvm.internal.p.A("inputView");
            } else {
                baseInputView2 = baseInputView3;
            }
            InterfaceC5940b.InterfaceC0556b cancelListener = baseInputView2.getCancelListener();
            if (cancelListener != null) {
                cancelListener.onCancel();
            }
        }
    }

    public final void k3() {
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout == null) {
            return;
        }
        launcherChatLayout.setOnFirstAssistantResponse(new p9.p() { // from class: com.stepos.ailauncher.chat.wake.b1
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return WakeDialogImpl.l3(this.f26696a, ((Boolean) obj).booleanValue(), (DisplayMessage) obj2);
            }
        });
    }

    public final TtsMediaFocusController k4() {
        return (TtsMediaFocusController) this.ttsMediaFocusController.getValue();
    }

    public final void k5(String traceId) {
        this.readyUserMessageTraceId = traceId == null ? "" : traceId;
        final a.Expand expand = this.pendingUserMessageExpand;
        if (expand == null) {
            return;
        }
        if (traceId == null || traceId.length() == 0 || kotlin.jvm.internal.p.d(traceId, expand.getTraceId())) {
            View view = null;
            this.pendingUserMessageExpand = null;
            C0919o.d("INPUT_BAR", "用户消息就绪,执行延迟展开(traceId=" + expand.getTraceId() + ")", false, 4, null);
            View view2 = this.rootView;
            if (view2 == null) {
                kotlin.jvm.internal.p.A("rootView");
            } else {
                view = view2;
            }
            view.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.d1
                @Override // java.lang.Runnable
                public final void run() {
                    WakeDialogImpl.l5(this.f26740a, expand);
                }
            });
        }
    }

    public final void k6(int chatLayoutHeight) {
        View view;
        int i10;
        int i11;
        Z z10 = this.blurController;
        if (z10 == null || (view = this.chatPanelWrapper) == null) {
            return;
        }
        int iF = C5685n.f(chatLayoutHeight, 0);
        if (this.lastChatHeightForBlur < 0) {
            z5();
        }
        if (iF >= this.lastChatHeightForBlur) {
            i11 = this.blurAnchorBottomY;
            i10 = i11 - iF;
            this.blurAnchorTopY = i10;
        } else {
            i10 = this.blurAnchorTopY;
            i11 = i10 + iF;
            this.blurAnchorBottomY = i11;
        }
        int i12 = i11;
        int i13 = i10;
        this.lastChatHeightForBlur = iF;
        float fM = C5685n.m(view.getAlpha(), 0.0f, 1.0f);
        int iM3 = M3(30);
        int iF2 = C5685n.f((int) (iM3 * fM), 0);
        float fM3 = M3(this.CHAT_PANEL_CORNER_DP);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i14 = iArr[0];
        int width = i14 + view.getWidth();
        ArrayList arrayList = new ArrayList();
        if (iF2 > 0 && iF > 0 && width > i14 && i12 > i13) {
            arrayList.add(z10.c(iF2, 1.0f, fM3, i14, i13, width, i12));
        }
        View view2 = this.llInputMain;
        if (view2 != null && view2.getWidth() > 0 && view2.getHeight() > 0) {
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            float fM32 = M3(this.INPUT_BAR_CORNER_DP);
            int i15 = iArr2[0];
            arrayList.add(z10.c(iM3, 1.0f, fM32, i15, iArr2[1], i15 + view2.getWidth(), iArr2[1] + view2.getHeight()));
        }
        Z.b(z10, (float[][]) arrayList.toArray(new float[0][]), false, false, 6, null);
    }

    public final boolean l4(MotionEvent event) {
        float yVelocity;
        ViewGroup.LayoutParams layoutParams;
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            androidx.dynamicanimation.animation.i iVar = this.chatHeightAnim;
            if (iVar != null) {
                iVar.d();
            }
            this.dragStartY = event.getRawY();
            this.dragStartChatHeight = B3();
            this.isDragging = false;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            velocityTrackerObtain.addMovement(event);
            this.velocityTracker = velocityTrackerObtain;
            z5();
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker2 = this.velocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(event);
                }
                float rawY = this.dragStartY - event.getRawY();
                if (!this.isDragging && Math.abs(rawY) > M3(4)) {
                    this.isDragging = true;
                }
                if (this.isDragging) {
                    int iN = C5685n.n((int) (this.dragStartChatHeight + rawY), 0, U4(this.dragStartChatHeight));
                    if (iN != B3()) {
                        J5(iN);
                    }
                }
                return true;
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(event);
            velocityTracker3.computeCurrentVelocity(1000);
            yVelocity = velocityTracker3.getYVelocity();
        } else {
            yVelocity = 0.0f;
        }
        VelocityTracker velocityTracker4 = this.velocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.recycle();
        }
        this.velocityTracker = null;
        if (!this.isDragging) {
            return false;
        }
        this.isDragging = false;
        boolean zN4 = N4();
        if (this.navigatingToChat || yVelocity > -650.0f || !zN4) {
            LauncherChatLayout launcherChatLayout = this.chatLayout;
            J jZ3 = z3((launcherChatLayout == null || (layoutParams = launcherChatLayout.getLayoutParams()) == null) ? 0 : C5685n.f(layoutParams.height, 0));
            J.c cVar = J.c.INSTANCE;
            if (kotlin.jvm.internal.p.d(jZ3, cVar) && zN4) {
                X4();
            } else if (kotlin.jvm.internal.p.d(jZ3, cVar)) {
                N2(this, J.d.INSTANCE, false, 2, null);
            } else {
                N2(this, jZ3, false, 2, null);
            }
        } else {
            Y3();
        }
        return true;
    }

    public final void l6(boolean waitingShown) {
        BaseInputView baseInputView;
        if (this.dragHandleArea == null) {
            return;
        }
        int height = 0;
        ConstraintLayout constraintLayout = null;
        if (waitingShown && (baseInputView = this.inputView) != null) {
            if (baseInputView == null) {
                kotlin.jvm.internal.p.A("inputView");
                baseInputView = null;
            }
            View viewFindViewById = baseInputView.findViewById(R$id.imgRecyclerView);
            if (viewFindViewById != null) {
                if (viewFindViewById.getVisibility() != 0) {
                    viewFindViewById = null;
                }
                if (viewFindViewById != null) {
                    height = viewFindViewById.getHeight();
                }
            }
        }
        float f10 = height;
        ConstraintLayout constraintLayout2 = this.dragHandleArea;
        if (constraintLayout2 == null) {
            kotlin.jvm.internal.p.A("dragHandleArea");
            constraintLayout2 = null;
        }
        if (constraintLayout2.getTranslationY() == f10) {
            return;
        }
        ConstraintLayout constraintLayout3 = this.dragHandleArea;
        if (constraintLayout3 == null) {
            kotlin.jvm.internal.p.A("dragHandleArea");
        } else {
            constraintLayout = constraintLayout3;
        }
        constraintLayout.setTranslationY(f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m3() {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.WakeDialogImpl.m3():void");
    }

    public final boolean m4(MotionEvent event) {
        float yVelocity;
        ViewGroup.LayoutParams layoutParams;
        if (!kotlin.jvm.internal.p.d(this.currentState, J.e.INSTANCE)) {
            if (this.inputDragging || this.inputDragVelocityTracker != null) {
                this.inputDragging = false;
                VelocityTracker velocityTracker = this.inputDragVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                }
                this.inputDragVelocityTracker = null;
            }
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            androidx.dynamicanimation.animation.i iVar = this.chatHeightAnim;
            if (iVar != null) {
                iVar.d();
            }
            this.inputDragStartY = event.getRawY();
            this.inputDragStartChatH = B3();
            this.inputDragging = false;
            VelocityTracker velocityTracker2 = this.inputDragVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
            }
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            velocityTrackerObtain.addMovement(event);
            this.inputDragVelocityTracker = velocityTrackerObtain;
            z5();
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker3 = this.inputDragVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(event);
                }
                float rawY = this.inputDragStartY - event.getRawY();
                if (!this.inputDragging && Math.abs(rawY) > M3(4)) {
                    this.inputDragging = true;
                }
                if (this.inputDragging) {
                    int iN = C5685n.n((int) (this.inputDragStartChatH + rawY), 0, U4(this.inputDragStartChatH));
                    if (iN != B3()) {
                        J5(iN);
                    }
                }
                return true;
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        VelocityTracker velocityTracker4 = this.inputDragVelocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(event);
            velocityTracker4.computeCurrentVelocity(1000);
            yVelocity = velocityTracker4.getYVelocity();
        } else {
            yVelocity = 0.0f;
        }
        VelocityTracker velocityTracker5 = this.inputDragVelocityTracker;
        if (velocityTracker5 != null) {
            velocityTracker5.recycle();
        }
        this.inputDragVelocityTracker = null;
        boolean z10 = this.inputDragging;
        this.inputDragging = false;
        if (z10) {
            boolean zN4 = N4();
            if (this.navigatingToChat || yVelocity > -650.0f || !zN4) {
                LauncherChatLayout launcherChatLayout = this.chatLayout;
                J jZ3 = z3((launcherChatLayout == null || (layoutParams = launcherChatLayout.getLayoutParams()) == null) ? 0 : C5685n.f(layoutParams.height, 0));
                J.c cVar = J.c.INSTANCE;
                if (kotlin.jvm.internal.p.d(jZ3, cVar) && zN4) {
                    X4();
                } else if (kotlin.jvm.internal.p.d(jZ3, cVar)) {
                    N2(this, J.d.INSTANCE, false, 2, null);
                } else {
                    N2(this, jZ3, false, 2, null);
                }
            } else {
                Y3();
            }
        }
        return true;
    }

    public final void m5() {
        View view = null;
        if (this.skipEntranceAnim) {
            View view2 = this.panelView;
            if (view2 == null) {
                kotlin.jvm.internal.p.A("panelView");
                view2 = null;
            }
            view2.setTranslationY(0.0f);
            View view3 = this.panelView;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("panelView");
                view3 = null;
            }
            if (view3.getVisibility() != 0) {
                View view4 = this.panelView;
                if (view4 == null) {
                    kotlin.jvm.internal.p.A("panelView");
                } else {
                    view = view4;
                }
                view.setVisibility(0);
            }
            View view5 = this.vBottomView;
            if (view5 != null) {
                view5.animate().cancel();
                view5.setAlpha(1.0f);
            }
            q6("playEntranceAnim: skipEntranceAnim branch, no animation");
            return;
        }
        View view6 = this.panelView;
        if (view6 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view6 = null;
        }
        Integer numValueOf = Integer.valueOf(view6.getHeight());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        float fIntValue = numValueOf != null ? numValueOf.intValue() : C5685n.e(Z4(), M3(com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME));
        View view7 = this.panelView;
        if (view7 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view7 = null;
        }
        view7.setTranslationY(fIntValue);
        View view8 = this.panelView;
        if (view8 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view8 = null;
        }
        if (view8.getVisibility() != 0) {
            View view9 = this.panelView;
            if (view9 == null) {
                kotlin.jvm.internal.p.A("panelView");
                view9 = null;
            }
            view9.setVisibility(0);
        }
        View view10 = this.vBottomView;
        if (view10 != null) {
            view10.animate().cancel();
            view10.animate().alpha(1.0f).setDuration(SCRIM_FADE_IN_DURATION_MS).setInterpolator(SCRIM_INTERPOLATOR).start();
        }
        q6("playEntranceAnim: about to start SpringAnimation");
        L2(this, 0.0f, 0.0f, 2, null);
        androidx.dynamicanimation.animation.i iVar = this.translationYAnim;
        if (iVar != null) {
            iVar.b(new e.q() { // from class: com.stepos.ailauncher.chat.wake.t1
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    WakeDialogImpl.n5(this.f26868a, eVar, z10, f10, f11);
                }
            });
        }
    }

    public final void m6(J state) {
        View view = this.inputView;
        if (view == null) {
            view = this.aiWaitingBar;
        } else if (view == null) {
            kotlin.jvm.internal.p.A("inputView");
            view = null;
        }
        Runnable runnable = this.pendingSyncRunnable;
        if (runnable != null && view != null) {
            view.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.p0
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.n6(this.f26851a);
            }
        };
        this.pendingSyncRunnable = runnable2;
        if (view != null) {
            view.postDelayed(runnable2, 33L);
        } else {
            runnable2.run();
        }
    }

    public final boolean o4(MotionEvent event) {
        ChatRecycleView messageList;
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        View view = this.dragHandleArea;
        View view2 = null;
        if (view != null) {
            if (view == null) {
                kotlin.jvm.internal.p.A("dragHandleArea");
                view = null;
            }
            if (p4(view, rawX, rawY)) {
                return true;
            }
        }
        View view3 = this.inputView;
        if (view3 != null) {
            if (view3 == null) {
                kotlin.jvm.internal.p.A("inputView");
            } else {
                view2 = view3;
            }
            if (p4(view2, rawX, rawY)) {
                return true;
            }
        }
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        return (launcherChatLayout == null || !p4(launcherChatLayout, rawX, rawY) || (messageList = launcherChatLayout.getMessageList()) == null || messageList.canScrollVertically(1)) ? false : true;
    }

    public final void o5(String pressToTalkCancelReason) {
        Object objB;
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        t3();
        androidx.dynamicanimation.animation.i iVar = this.chatHeightAnim;
        if (iVar != null) {
            iVar.d();
        }
        this.chatHeightAnim = null;
        androidx.dynamicanimation.animation.i iVar2 = this.translationYAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        this.translationYAnim = null;
        View view = this.scrimView;
        if (view != null) {
            if (view == null) {
                kotlin.jvm.internal.p.A("scrimView");
                view = null;
            }
            view.animate().cancel();
        }
        View view2 = this.vBottomView;
        if (view2 != null && (viewPropertyAnimatorAnimate = view2.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        View view3 = this.dragBar;
        if (view3 != null) {
            if (view3 == null) {
                kotlin.jvm.internal.p.A("dragBar");
                view3 = null;
            }
            view3.removeCallbacks(this.restoreDragBarTintRunnable);
        }
        o6();
        y5();
        if (this.voiceGloballyStoppedForDismiss) {
            C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "quiesceAndDismiss: skip global voice sweep (dismissWithAnim already stopped)", false, 4, null);
        } else {
            C4148a.k(BaseInputView.WAKE_RECORD_LOG_TAG, "quiesceAndDismiss: stopAllVoiceForPageLeave", false, 4, null);
            this.voiceGloballyStoppedForDismiss = true;
            InputViewManager.INSTANCE.e1(pressToTalkCancelReason);
        }
        O();
        try {
            Result.Companion companion = Result.INSTANCE;
            dismiss();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(this.TAG, "quiesceAndDismiss: dismiss threw, swallowed", thE, false, 8, null);
        }
    }

    public final void o6() {
        View view;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.blurSyncListener;
        if (onPreDrawListener != null && (view = this.chatPanelWrapper) != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        }
        this.blurSyncListener = null;
        Z z10 = this.blurController;
        if (z10 != null) {
            z10.d();
        }
        this.blurController = null;
        this.llInputMain = null;
        this.lastChatHeightForBlur = -1;
        this.blurAnchorTopY = 0;
        this.blurAnchorBottomY = 0;
    }

    @Override // com.stepos.ailauncher.chat.wake.DialogC3116e0, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q6("onAttachedToWindow:begin (WMS attached, first traversal about to start)");
        w5();
        x5();
        TaskModule.INSTANCE.h(this.taskCardCallback);
        r5();
        q6("onAttachedToWindow: registers+refresh done");
    }

    public final boolean p4(View view, float rawX, float rawY) {
        if (view.getVisibility() == 0 && view.getWidth() > 0 && view.getHeight() > 0) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (rawX >= iArr[0] && rawX <= r1 + view.getWidth()) {
                if (rawY >= iArr[1] && rawY <= r3 + view.getHeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void p6() {
        C2851i7 c2851i7 = C2851i7.INSTANCE;
        c2851i7.h(this.chatPanelBlurHandle);
        this.chatPanelBlurHandle = null;
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        if (launcherChatLayout != null) {
            launcherChatLayout.O8();
            launcherChatLayout.setScrollToBottomBlurCrossWindow(false);
        }
        View view = this.chatPanelWrapper;
        if (view != null) {
            view.setForeground(this.chatPanelOriginalForeground);
        }
        this.chatPanelOriginalForeground = null;
        View view2 = this.inputBarStrokeTarget;
        if (view2 != null) {
            view2.setForeground(this.inputBarStrokeOriginalForeground);
        }
        this.inputBarStrokeTarget = null;
        this.inputBarStrokeOriginalForeground = null;
        c2851i7.h(this.aiWaitingBarGlassHandle);
        this.aiWaitingBarGlassHandle = null;
    }

    public final void q4() {
        R4();
        m3();
    }

    public final void q6(String stage) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.showStartMs;
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format("+%dms %s", Arrays.copyOf(new Object[]{Long.valueOf(jElapsedRealtime), stage}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        C4148a.k("WakeShowTiming", str, false, 4, null);
    }

    @Override // com.stepos.ailauncher.chat.wake.DialogC3116e0
    public void r(boolean isKeyguardLocked) {
        View view;
        BaseInputView baseInputView;
        this.showStartMs = SystemClock.elapsedRealtime();
        q6("afterCreated:begin");
        setContentView(R$layout.layout_wake_dialog);
        q6("setContentView done (XML inflate)");
        r4();
        q6("initViews done (findViewById×N)");
        InterfaceC5063a<Y8.t> interfaceC5063a = this.onViewInitialized;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        W4();
        R5();
        E2();
        q6("setupTouchListeners+adjustSoftInputHeight done");
        q4();
        q6("initChatLayout done (bindChatResource)");
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        View view2 = this.rootView;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("rootView");
            view2 = null;
        }
        ViewGroup viewGroup = (ViewGroup) view2;
        View view3 = this.panelView;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view = null;
        } else {
            view = view3;
        }
        BaseInputView baseInputView2 = this.inputView;
        if (baseInputView2 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        } else {
            baseInputView = baseInputView2;
        }
        this.circleSelectController = new CircleSelectController(context, viewGroup, view, baseInputView, null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.f0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.G2(this.f26757a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.q0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.H2(this.f26854a);
            }
        }, null, 144, null);
        q6("CircleSelectController created");
        View view4 = this.panelView;
        if (view4 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view4 = null;
        }
        view4.setVisibility(4);
        BaseInputView baseInputView3 = this.inputView;
        if (baseInputView3 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView3 = null;
        }
        baseInputView3.post(new Runnable() { // from class: com.stepos.ailauncher.chat.wake.B0
            @Override // java.lang.Runnable
            public final void run() {
                WakeDialogImpl.I2(this.f26591a);
            }
        });
        C4148a.d(this.TAG, "afterCreated: aclChat.height initialized to 0 (Minify)", false, 4, null);
        BaseInputView baseInputView4 = this.inputView;
        if (baseInputView4 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView4 = null;
        }
        baseInputView4.setOnDialogShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.M0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.J2(this.f26646a, ((Boolean) obj).booleanValue());
            }
        });
        v5();
        q6("afterCreated:end (sync body done, waiting for post & doOnPreDraw)");
        C4148a.k(this.TAG, "afterCreated: isKeyguardLocked=" + isKeyguardLocked + " windowNull=" + (getWindow() == null), false, 4, null);
        if (isKeyguardLocked) {
            U2();
        } else {
            C4148a.u(this.TAG, "afterCreated: isKeyguardLocked=false, skip keepScreenOn (debug)", false, 4, null);
        }
    }

    public final void r4() {
        View viewFindViewById = findViewById(R$id.wake_root);
        kotlin.jvm.internal.p.f(viewFindViewById);
        this.rootView = viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.wake_scrim);
        kotlin.jvm.internal.p.f(viewFindViewById2);
        this.scrimView = viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.wake_panel);
        kotlin.jvm.internal.p.f(viewFindViewById3);
        this.panelView = viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.wake_input_view);
        kotlin.jvm.internal.p.f(viewFindViewById4);
        BaseInputView baseInputView = (BaseInputView) viewFindViewById4;
        this.inputView = baseInputView;
        BaseInputView baseInputView2 = null;
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        baseInputView.setHostKeepScreenOnController(g4());
        BaseInputView baseInputView3 = this.inputView;
        if (baseInputView3 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView3 = null;
        }
        baseInputView3.setInputBarGlassEnabled(true);
        BaseInputView baseInputView4 = this.inputView;
        if (baseInputView4 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView4 = null;
        }
        baseInputView4.setInputBarGlassCrossWindow(true);
        View viewFindViewById5 = findViewById(R$id.wake_drag_handle_area);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        this.dragHandleArea = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = findViewById(R$id.wake_drag_handle);
        kotlin.jvm.internal.p.f(viewFindViewById6);
        this.dragBar = viewFindViewById6;
        this.vBottomView = findViewById(R$id.vChatBottomBg);
        this.aiWaitingBar = findViewById(R$id.wake_ai_waiting_bar);
        this.aiWaitingStop = findViewById(R$id.wake_ai_waiting_stop);
        this.aiWaitingText = (TextView) findViewById(R$id.wake_ai_waiting_text);
        View viewFindViewById7 = findViewById(R$id.sBottom);
        kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
        this.sBottomSpace = viewFindViewById7;
        View view = this.aiWaitingStop;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.wake.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WakeDialogImpl.s4(this.f26859a, view2);
                }
            });
        }
        t5();
        BaseInputView baseInputView5 = this.inputView;
        if (baseInputView5 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView5 = null;
        }
        ActionView actionView = baseInputView5.getActionView();
        if (actionView != null) {
            actionView.setListItemLayoutId(R$layout.item_chat_action_float);
        }
        BaseInputView baseInputView6 = this.inputView;
        if (baseInputView6 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView6 = null;
        }
        baseInputView6.setOnCancelSilentScreenshot(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.y0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.t4(this.f26891a);
            }
        });
        BaseInputView baseInputView7 = this.inputView;
        if (baseInputView7 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView7 = null;
        }
        baseInputView7.setOnRecordingStateChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.z0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.y4(((Boolean) obj).booleanValue());
            }
        });
        BaseInputView baseInputView8 = this.inputView;
        if (baseInputView8 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView8 = null;
        }
        baseInputView8.setOnAiWakeMessageSent(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.A0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.z4(this.f26586a);
            }
        });
        BaseInputView baseInputView9 = this.inputView;
        if (baseInputView9 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView9 = null;
        }
        baseInputView9.setOnAsrFinalizingChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.C0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.A4(this.f26601a, ((Boolean) obj).booleanValue());
            }
        });
        BaseInputView baseInputView10 = this.inputView;
        if (baseInputView10 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView10 = null;
        }
        baseInputView10.setOnSendRoundStarted(new p9.p() { // from class: com.stepos.ailauncher.chat.wake.D0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return WakeDialogImpl.B4(this.f26610a, (String) obj, ((Boolean) obj2).booleanValue());
            }
        });
        BaseInputView baseInputView11 = this.inputView;
        if (baseInputView11 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView11 = null;
        }
        baseInputView11.setOnSpeechPopupShown(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.E0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.C4(this.f26617a, ((Boolean) obj).booleanValue());
            }
        });
        BaseInputView baseInputView12 = this.inputView;
        if (baseInputView12 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView12 = null;
        }
        baseInputView12.setOnRecordingTouchBlockNeeded(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.F0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.D4(this.f26623a, ((Boolean) obj).booleanValue());
            }
        });
        BaseInputView baseInputView13 = this.inputView;
        if (baseInputView13 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView13 = null;
        }
        baseInputView13.setOnSpeechCancelStateChanged(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.G0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.E4(this.f26627a, ((Boolean) obj).booleanValue());
            }
        });
        final BaseInputView baseInputView14 = this.inputView;
        if (baseInputView14 == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView14 = null;
        }
        baseInputView14.setOnMessageSentCallback(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.H0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return WakeDialogImpl.F4(baseInputView14, this, (String) obj);
            }
        });
        baseInputView14.setOnSendInitiated(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.s0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return WakeDialogImpl.G4(this.f26862a, baseInputView14);
            }
        });
        baseInputView14.setOnStopClicked(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.t0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(WakeDialogImpl.H4(this.f26867a));
            }
        });
        View view2 = this.panelView;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("panelView");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.wake.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WakeDialogImpl.u4(view3);
            }
        });
        View view3 = this.scrimView;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("scrimView");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.wake.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                WakeDialogImpl.v4(this.f26873a, view4);
            }
        });
        final int iM3 = M3(30);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        View view4 = this.scrimView;
        if (view4 == null) {
            kotlin.jvm.internal.p.A("scrimView");
            view4 = null;
        }
        view4.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.ailauncher.chat.wake.w0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view5, MotionEvent motionEvent) {
                return WakeDialogImpl.w4(this.f26877a, ref$BooleanRef, iM3, view5, motionEvent);
            }
        });
        BaseInputView baseInputView15 = this.inputView;
        if (baseInputView15 == null) {
            kotlin.jvm.internal.p.A("inputView");
        } else {
            baseInputView2 = baseInputView15;
        }
        ActionView actionView2 = baseInputView2.getActionView();
        if (actionView2 != null) {
            actionView2.setOnDataFilledCallback(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.x0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return WakeDialogImpl.x4(this.f26885a, (List) obj);
                }
            });
        }
    }

    public final boolean s3() {
        return Settings.canDrawOverlays(getContext().getApplicationContext());
    }

    @Override // com.stepos.ailauncher.chat.wake.DialogC3116e0
    public String t() {
        BaseInputView baseInputView = this.inputView;
        if (baseInputView == null) {
            return "";
        }
        if (baseInputView == null) {
            kotlin.jvm.internal.p.A("inputView");
            baseInputView = null;
        }
        String strW5 = baseInputView.W5();
        return strW5 == null ? "" : strW5;
    }

    public final void t3() {
        this.noAnimImeSettleGeneration++;
    }

    public final void u6() {
        IFloatCardService iFloatCardService;
        G4.h hVar = this.floatCardHost;
        if (hVar != null && (iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class)) != null) {
            iFloatCardService.unregisterHost(hVar);
        }
        View view = null;
        this.floatCardHost = null;
        View view2 = this.panelView;
        if (view2 == null) {
            kotlin.jvm.internal.p.A("panelView");
        } else {
            view = view2;
        }
        view.setVisibility(0);
    }

    public final int v3(J state) {
        int iZ4 = Z4();
        if (kotlin.jvm.internal.p.d(state, J.b.INSTANCE) || kotlin.jvm.internal.p.d(state, J.e.INSTANCE)) {
            return 0;
        }
        if (kotlin.jvm.internal.p.d(state, J.d.INSTANCE)) {
            return M3(HALF_CHAT_HEIGHT_DP);
        }
        if (kotlin.jvm.internal.p.d(state, J.c.INSTANCE)) {
            return C5685n.f((this.screenHeightPx - M3(49)) - iZ4, 0);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void v5() {
        Object objB;
        TelephonyManager telephonyManager;
        this.answeredCallWatcher.e();
        if (this.phoneStateCallbackRegistered) {
            return;
        }
        this.lastPhoneCallState = null;
        com.stepos.ailauncher.common.permission.G g10 = com.stepos.ailauncher.common.permission.G.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!g10.R(context, PermScene.PHONE_STATE)) {
            C4148a.u(this.TAG, "registerPhoneStateReceiver: READ_PHONE_STATE not granted, skip callback", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = getContext().getApplicationContext().getSystemService("phone");
            telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (telephonyManager == null) {
            return;
        }
        int callState = telephonyManager.getCallState();
        this.lastPhoneCallState = Integer.valueOf(callState);
        telephonyManager.registerTelephonyCallback(getContext().getMainExecutor(), this.phoneStateCallback);
        this.phoneStateCallbackRegistered = true;
        objB = Result.b(Integer.valueOf(C4148a.d(this.TAG, "registerPhoneStateReceiver: seededCallState=" + callState, false, 4, null)));
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(this.TAG, "registerPhoneStateReceiver failed", thE, false, 8, null);
        }
    }

    public final void v6() {
        if (this.phoneStateCallbackRegistered) {
            this.phoneStateCallbackRegistered = false;
            Y8.t tVar = null;
            this.lastPhoneCallState = null;
            try {
                Result.Companion companion = Result.INSTANCE;
                Object systemService = getContext().getApplicationContext().getSystemService("phone");
                TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
                if (telephonyManager != null) {
                    telephonyManager.unregisterTelephonyCallback(this.phoneStateCallback);
                    tVar = Y8.t.f7040a;
                }
                Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void x3() {
        if (this.lockscreenKeepScreenOnApplied) {
            this.lockscreenKeepScreenOnApplied = false;
            g4().l(com.stepos.ailauncher.chat.util.g.REASON_LOCKSCREEN);
            y6();
        }
    }

    public final void x5() {
        Object objB;
        if (this.lockscreenKeepScreenOnApplied && !this.userPresentReceiverRegistered) {
            try {
                Result.Companion companion = Result.INSTANCE;
                getContext().getApplicationContext().registerReceiver(this.userPresentReceiver, new IntentFilter("android.intent.action.USER_PRESENT"), 4);
                this.userPresentReceiverRegistered = true;
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(this.TAG, "registerUserPresentReceiver failed", thE, false, 8, null);
            }
        }
    }

    public final void x6() {
        IFloatCardService iFloatCardService;
        U u10 = this.suggestCardEventHandler;
        if (u10 != null && (iFloatCardService = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class)) != null) {
            iFloatCardService.unregisterEventHandler(u10.getBusinessType());
        }
        this.suggestCardEventHandler = null;
        this.currentSuggestCardId = null;
        this.pendingFileIdForMapping = null;
    }

    public final float y3(int keyboardHeight, int statusBarTop) {
        int iF;
        ViewGroup.LayoutParams layoutParams;
        if (keyboardHeight <= 0) {
            return 0.0f;
        }
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            kotlin.jvm.internal.p.A("rootView");
            view = null;
        }
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        int height = viewGroup != null ? viewGroup.getHeight() : this.screenHeightPx;
        LauncherChatLayout launcherChatLayout = this.chatLayout;
        int iF2 = (launcherChatLayout == null || (layoutParams = launcherChatLayout.getLayoutParams()) == null) ? 0 : C5685n.f(layoutParams.height, 0);
        if (iF2 > 0) {
            iF = Z4() + iF2;
        } else {
            View view3 = this.panelView;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("panelView");
            } else {
                view2 = view3;
            }
            iF = C5685n.f(view2.getHeight(), 0);
        }
        return C5685n.e(-keyboardHeight, statusBarTop - (height - iF));
    }

    public final void y5() {
        View view = this.touchBlockerView;
        if (view == null) {
            return;
        }
        this.touchBlockerView = null;
        try {
            WindowManager windowManagerJ4 = j4();
            if (windowManagerJ4 != null) {
                windowManagerJ4.removeViewImmediate(view);
            }
            C4148a.d(this.TAG, "removeTouchBlockerOverlay: blocker removed", false, 4, null);
        } catch (Throwable th) {
            C4148a.g(this.TAG, "removeTouchBlockerOverlay: removeView failed", th, false, 8, null);
        }
    }

    public final void y6() {
        if (this.userPresentReceiverRegistered) {
            this.userPresentReceiverRegistered = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                getContext().getApplicationContext().unregisterReceiver(this.userPresentReceiver);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final J z3(int currentChatH) {
        J.d dVar = J.d.INSTANCE;
        int iV3 = v3(dVar);
        J.c cVar = J.c.INSTANCE;
        return currentChatH < iV3 / 2 ? J.e.INSTANCE : currentChatH < (iV3 + v3(cVar)) / 2 ? dVar : cVar;
    }

    public final void z5() {
        View view = this.chatPanelWrapper;
        if (view == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[1];
        this.blurAnchorTopY = i10;
        this.blurAnchorBottomY = i10 + view.getHeight();
        this.lastChatHeightForBlur = view.getLayoutParams().height;
    }

    public final void z6(int heightPx) {
        View view = this.chatPanelWrapper;
        if (view == null) {
            return;
        }
        float f10 = heightPx;
        float fM = C5685n.m(f10 / C5685n.f(c4(), 1), 0.0f, 1.0f);
        if (view.getAlpha() != fM) {
            view.setAlpha(fM);
        }
        int iM = (int) (C5685n.m(f10 / C5685n.f(d4(), 1), 0.0f, 1.0f) * 255);
        Drawable foreground = view.getForeground();
        if (foreground != null) {
            foreground.setAlpha(iM);
        }
        int iM3 = (int) (M3(12) * fM);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.bottomMargin == iM3) {
            return;
        }
        marginLayoutParams.bottomMargin = iM3;
        view.setLayoutParams(marginLayoutParams);
    }
}
