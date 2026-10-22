package com.stepos.ailauncher.chat.sheet;

import Ua.C1060i;
import Ua.L0;
import Z8.C1173v;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Lifecycle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.PickFileMediatorActivity;
import com.stepos.ailauncher.chat.TransferActivity;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import com.stepos.ailauncher.chat.activity.ChatScene;
import com.stepos.ailauncher.chat.broadcast.RecentsWindowMonitor;
import com.stepos.ailauncher.chat.input.camera.CameraLauncher;
import com.stepos.ailauncher.chat.panelui.PanelLayerDismissReason;
import com.stepos.ailauncher.chat.panelui.PanelLayerRecentsPhase;
import com.stepos.ailauncher.chat.sheet.BringLauncherTaskFrontActivity;
import com.stepos.ailauncher.chat.voice.longpress.RecordingPresentation;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.container.api.IOverlayPageHost;
import com.stepos.ailauncher.container.l0;
import com.stepos.ailauncher.container.m0;
import com.stepos.ailauncher.contract.api.homegesture.HomeDismissReason;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilitySnapshot;
import com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator;
import com.stepos.ailauncher.contract.api.homegesture.RootStrategy;
import com.stepos.ailauncher.sheet.SheetLaunchOptions;
import com.stepos.ailauncher.sheet.s0;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntUnaryOperator;
import k5.C4814a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bE\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\n*\u0004Ñ\u0002Ô\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0004\b \u0010\u0003J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0011J\u000f\u0010$\u001a\u00020\u001cH\u0007¢\u0006\u0004\b$\u0010\u001eJ\u000f\u0010%\u001a\u00020\u001cH\u0002¢\u0006\u0004\b%\u0010\u001eJ\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0016H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0016H\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b-\u0010\u0011J'\u00100\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0016H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u001cH\u0007¢\u0006\u0004\b2\u0010\u001eJ\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\u0003J\u0017\u00104\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u0010\u0011J\u0017\u00105\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010\bJ\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u0017\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010\bJ+\u0010=\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u001c2\b\b\u0002\u0010<\u001a\u00020\u001cH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b?\u0010\u0011J\u001f\u0010@\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0016H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bB\u0010\u0011J\u0017\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bC\u0010\u0011J\u0011\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bG\u0010\bJ\u0017\u0010H\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bH\u0010IJ\u0011\u0010J\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bJ\u0010KJ\u0013\u0010L\u001a\u00020\u001c*\u00020\u0004H\u0002¢\u0006\u0004\bL\u00106J\u0011\u0010M\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bM\u0010KJ\u0011\u0010N\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bN\u0010KJ\u0017\u0010O\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\bO\u0010\u0011J\u0017\u0010P\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\bP\u0010\u0011J\u0017\u0010Q\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bQ\u00106J\u000f\u0010R\u001a\u00020\u001cH\u0007¢\u0006\u0004\bR\u0010\u001eJ\u0017\u0010S\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bS\u0010\bJ\u0017\u0010T\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bT\u00106J\u0017\u0010U\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bU\u0010\bJ\u001f\u0010W\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u001cH\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0006H\u0007¢\u0006\u0004\bY\u0010\u0003J\u000f\u0010Z\u001a\u00020\u0006H\u0002¢\u0006\u0004\bZ\u0010\u0003J\u000f\u0010[\u001a\u00020\u0006H\u0002¢\u0006\u0004\b[\u0010\u0003J\u000f\u0010\\\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\\\u0010\u0003J\u0017\u0010]\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b]\u0010\u0011J\u001f\u0010_\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0006H\u0007¢\u0006\u0004\ba\u0010\u0003J\u000f\u0010b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bb\u0010\u0003J\u0019\u0010c\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bc\u0010\u0011J\u000f\u0010d\u001a\u00020\u0006H\u0002¢\u0006\u0004\bd\u0010\u0003J\u0017\u0010e\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020\u0006H\u0002¢\u0006\u0004\bg\u0010\u0003J%\u0010j\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001c0hH\u0002¢\u0006\u0004\bj\u0010kJ-\u0010l\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u001c2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001c0hH\u0002¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u0006H\u0002¢\u0006\u0004\bn\u0010\u0003J\u001f\u0010q\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010p\u001a\u00020oH\u0002¢\u0006\u0004\bq\u0010rJ'\u0010v\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010t\u001a\u00020s2\u0006\u0010u\u001a\u00020oH\u0002¢\u0006\u0004\bv\u0010wJ\u001f\u0010x\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010u\u001a\u00020oH\u0002¢\u0006\u0004\bx\u0010yJ!\u0010{\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010z\u001a\u00020\u001cH\u0002¢\u0006\u0004\b{\u0010|J\u0017\u0010}\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b}\u0010\u0011J\u0017\u0010~\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b~\u0010\bJ\u0017\u0010\u007f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u007f\u0010\u0011J\u0011\u0010\u0080\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u001eJ\u001a\u0010\u0082\u0001\u001a\u00020\u001c2\u0007\u0010\u0081\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0082\u0001\u00106J\u001b\u0010\u0083\u0001\u001a\u00020\u000e2\u0007\u0010\u0081\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0019\u0010\u0085\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u0011J\u0011\u0010\u0086\u0001\u001a\u00020\u0006H\u0007¢\u0006\u0005\b\u0086\u0001\u0010\u0003J\u0011\u0010\u0087\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0087\u0001\u0010\u0003J+\u0010\u0089\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010t\u001a\u00020s2\u0007\u0010\u0088\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001c\u0010\u008c\u0001\u001a\u00020\u001c2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0005\b\u008c\u0001\u0010fJ\u0011\u0010\u008d\u0001\u001a\u00020\u001cH\u0007¢\u0006\u0005\b\u008d\u0001\u0010\u001eJ\u001b\u0010\u008e\u0001\u001a\u00020\u001c2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0005\b\u008e\u0001\u00106J\u0011\u0010\u008f\u0001\u001a\u00020\u001cH\u0007¢\u0006\u0005\b\u008f\u0001\u0010\u001eJ\u0011\u0010\u0090\u0001\u001a\u00020\u0016H\u0007¢\u0006\u0005\b\u0090\u0001\u0010*J1\u0010\u0094\u0001\u001a\u00020\u001c2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000e2\u0007\u0010\u0092\u0001\u001a\u00020\u000e2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0011\u0010\u0096\u0001\u001a\u00020\u001cH\u0007¢\u0006\u0005\b\u0096\u0001\u0010\u001eJ(\u0010\u0099\u0001\u001a\u00020\u001c2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000e2\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u001cH\u0007¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J(\u0010\u009b\u0001\u001a\u00020\u001c2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000e2\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u001cH\u0007¢\u0006\u0006\b\u009b\u0001\u0010\u009a\u0001J\u0019\u0010\u009c\u0001\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u009c\u0001\u00106J\u0013\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0005\b\u009d\u0001\u0010KJ\u001c\u0010\u009e\u0001\u001a\u00020\u001c2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0005\b\u009e\u0001\u0010fJ\u0011\u0010\u009f\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u009f\u0001\u0010\u0003J\u0011\u0010 \u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b \u0001\u0010\u0003J\u0013\u0010¡\u0001\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0005\b¡\u0001\u0010KJ\u0013\u0010¢\u0001\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0005\b¢\u0001\u0010KJ\u0011\u0010£\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b£\u0001\u0010\u0003J\u0019\u0010¤\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¤\u0001\u0010\u0011J\u0011\u0010¥\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b¥\u0001\u0010\u0003J\u0019\u0010¦\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\b¦\u0001\u0010\bJ!\u0010§\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u001cH\u0002¢\u0006\u0005\b§\u0001\u0010XJ!\u0010¨\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¨\u0001\u0010\u0015J\u0019\u0010©\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\b©\u0001\u0010\bJ\u0019\u0010ª\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bª\u0001\u0010\bJ\u0019\u0010«\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0005\b«\u0001\u0010\bJ#\u0010¬\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010^\u001a\u00020\u001cH\u0002¢\u0006\u0005\b¬\u0001\u0010XJ/\u0010\u00ad\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u001c2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001c0hH\u0002¢\u0006\u0005\b\u00ad\u0001\u0010mJ\u0019\u0010®\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\b®\u0001\u0010\bJ\u0019\u0010¯\u0001\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\b¯\u0001\u00106J\u0019\u0010°\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\b°\u0001\u0010\bJ\u0019\u0010±\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0005\b±\u0001\u0010\bJ\u0019\u0010²\u0001\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\b²\u0001\u00106J\u0019\u0010³\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b³\u0001\u0010\u0011J\u0019\u0010´\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0005\b´\u0001\u0010\bJ\u0019\u0010µ\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bµ\u0001\u0010\bJ\u0011\u0010¶\u0001\u001a\u00020\u001cH\u0007¢\u0006\u0005\b¶\u0001\u0010\u001eJ\u0011\u0010·\u0001\u001a\u00020\u0006H\u0007¢\u0006\u0005\b·\u0001\u0010\u0003J\u0011\u0010¸\u0001\u001a\u00020\u001cH\u0007¢\u0006\u0005\b¸\u0001\u0010\u001eJ\u001b\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010\u000f\u001a\u00030¹\u0001H\u0007¢\u0006\u0006\bº\u0001\u0010»\u0001J\u0019\u0010¼\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¼\u0001\u0010\u0011J\u0019\u0010½\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b½\u0001\u0010\u0011J\u0019\u0010¾\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¾\u0001\u0010\u0011J\u0019\u0010¿\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b¿\u0001\u0010\u0011J\u0011\u0010À\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\bÀ\u0001\u0010\u0003J\u0011\u0010Á\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\bÁ\u0001\u0010\u0003J\u0011\u0010Â\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\bÂ\u0001\u0010\u0003J\u0011\u0010Ã\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\bÃ\u0001\u0010\u0003J\u001c\u0010Ä\u0001\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0006\bÄ\u0001\u0010\u0084\u0001J\u001d\u0010Æ\u0001\u001a\u0004\u0018\u00010\u000e2\u0007\u0010Å\u0001\u001a\u00020DH\u0002¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u001d\u0010É\u0001\u001a\u0005\u0018\u00010È\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u001e\u0010Ë\u0001\u001a\u0005\u0018\u00010È\u00012\u0007\u0010Å\u0001\u001a\u00020DH\u0002¢\u0006\u0006\bË\u0001\u0010Ì\u0001J\u0019\u0010Í\u0001\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÍ\u0001\u00106J\u0019\u0010Î\u0001\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÎ\u0001\u00106J#\u0010Ï\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010^\u001a\u00020\u001cH\u0002¢\u0006\u0005\bÏ\u0001\u0010XJ\u0019\u0010Ð\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÐ\u0001\u0010\bJ!\u0010Ñ\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÑ\u0001\u0010\u0015J2\u0010Ò\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0016H\u0002¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J3\u0010Ô\u0001\u001a\u00020\u00062\u0007\u0010Å\u0001\u001a\u00020D2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J!\u0010Ö\u0001\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\bÖ\u0001\u0010,J\u0019\u0010×\u0001\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0005\b×\u0001\u0010\u0011J\u0019\u0010Ø\u0001\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bØ\u0001\u00106J\u001d\u0010Ù\u0001\u001a\u00020\u001c2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0005\bÙ\u0001\u00106J\u0011\u0010Ú\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\bÚ\u0001\u0010*J\u0011\u0010Û\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\bÛ\u0001\u0010*J\u0011\u0010Ü\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\bÜ\u0001\u0010\u001eJ\u0019\u0010Ý\u0001\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÝ\u0001\u00106J\u0019\u0010Þ\u0001\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bÞ\u0001\u00106J&\u0010á\u0001\u001a\u00020\u001c2\t\u0010ß\u0001\u001a\u0004\u0018\u00010\u000e2\u0007\u0010à\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0006\bá\u0001\u0010â\u0001J\u0019\u0010ã\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0005\bã\u0001\u0010\bJ\u0011\u0010ä\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0005\bä\u0001\u0010\u0003J\u0019\u0010å\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0005\bå\u0001\u0010\bJ\u000f\u0010æ\u0001\u001a\u00020\u0006¢\u0006\u0005\bæ\u0001\u0010\u0003J\u001b\u0010è\u0001\u001a\u00020\u001c2\u0007\u0010ç\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0006\bè\u0001\u0010é\u0001J\u001b\u0010ê\u0001\u001a\u00020\u001c2\u0007\u0010ç\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0006\bê\u0001\u0010é\u0001J\u0019\u0010ë\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0005\bë\u0001\u0010\bR\u0017\u0010ì\u0001\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u0017\u0010î\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u0017\u0010ð\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bð\u0001\u0010ï\u0001R\u0017\u0010ñ\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bñ\u0001\u0010ï\u0001R\u0017\u0010ò\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bò\u0001\u0010ï\u0001R\u0017\u0010ó\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bó\u0001\u0010ï\u0001R\u0017\u0010ô\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bô\u0001\u0010ï\u0001R\u0017\u0010õ\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bõ\u0001\u0010ï\u0001R\u0017\u0010ö\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bö\u0001\u0010ï\u0001R\u0017\u0010÷\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\b÷\u0001\u0010ï\u0001R\u0017\u0010ø\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bø\u0001\u0010ï\u0001R\u0017\u0010ù\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bù\u0001\u0010ï\u0001R\u0017\u0010ú\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bú\u0001\u0010ï\u0001R\u0017\u0010û\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bû\u0001\u0010ï\u0001R\u0017\u0010ü\u0001\u001a\u00020s8\u0002X\u0082T¢\u0006\b\n\u0006\bü\u0001\u0010ï\u0001R\"\u0010þ\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R\"\u0010\u0080\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0002\u0010ÿ\u0001R%\u0010\u0082\u0002\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00040ý\u00010\u0081\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u0083\u0002R\u001c\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0084\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R(\u0010\u0087\u0002\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0005\b\u0089\u0002\u0010\u001e\"\u0006\b\u008a\u0002\u0010\u008b\u0002R)\u0010\u008d\u0002\u001a\u00020\u001c2\u0007\u0010\u008c\u0002\u001a\u00020\u001c8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\b\u008d\u0002\u0010\u0088\u0002\u001a\u0005\b\u008e\u0002\u0010\u001eR)\u0010\u008f\u0002\u001a\u00020\u001c2\u0007\u0010\u008c\u0002\u001a\u00020\u001c8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\b\u008f\u0002\u0010\u0088\u0002\u001a\u0005\b\u0090\u0002\u0010\u001eR\u0018\u0010\u0092\u0002\u001a\u00030\u0091\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0002\u0010\u0093\u0002R\u0018\u0010\u0095\u0002\u001a\u00030\u0094\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0002\u0010\u0096\u0002R\u0018\u0010\u0098\u0002\u001a\u00030\u0097\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0002\u0010\u0099\u0002R\u0018\u0010\u009a\u0002\u001a\u00030\u0097\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0002\u0010\u0099\u0002R\u0019\u0010\u009b\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u0088\u0002R\u0019\u0010\u009c\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u0088\u0002R\u0019\u0010\u009d\u0002\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010ï\u0001R\u0019\u0010\u009e\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010\u009f\u0002R\u0018\u0010¡\u0002\u001a\u00030 \u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0002\u0010¢\u0002R\u0018\u0010¤\u0002\u001a\u00030£\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0002\u0010¥\u0002R\u0018\u0010§\u0002\u001a\u00030¦\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0002\u0010¨\u0002R\u0018\u0010©\u0002\u001a\u00030¦\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0002\u0010¨\u0002R\u0019\u0010ª\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0002\u0010\u0088\u0002R\u0019\u0010«\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010\u0088\u0002R\u0019\u0010¬\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010\u0088\u0002R\u0019\u0010\u00ad\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010\u0088\u0002R\u0019\u0010®\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0002\u0010\u0088\u0002R\u0019\u0010¯\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010\u0088\u0002R\u0019\u0010°\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010\u0088\u0002R\u0019\u0010±\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010\u0088\u0002R\u0019\u0010²\u0002\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010ï\u0001R\u0019\u0010³\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010\u0088\u0002R\u0019\u0010´\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010\u009f\u0002R\u0019\u0010µ\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0002\u0010\u0088\u0002R\u0019\u0010¶\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010\u009f\u0002R\u0019\u0010·\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010\u0088\u0002R\u0019\u0010¸\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010\u0088\u0002R\u0018\u0010¹\u0002\u001a\u00030\u0097\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0002\u0010\u0099\u0002R\u0019\u0010º\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0002\u0010\u0088\u0002R\u0019\u0010»\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010\u009f\u0002R\u0019\u0010¼\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0002\u0010\u009f\u0002R\u0019\u0010½\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0002\u0010\u009f\u0002R\u0019\u0010¾\u0002\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0002\u0010ï\u0001R\u0019\u0010¿\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0002\u0010\u009f\u0002R\u0019\u0010À\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0002\u0010\u0088\u0002R\u001a\u0010Â\u0002\u001a\u00030Á\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0002\u0010Ã\u0002R\u0019\u0010Ä\u0002\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0002\u0010ï\u0001R\u0019\u0010Å\u0002\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010ï\u0001R\u0019\u0010Æ\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0002\u0010\u0088\u0002R\u0019\u0010Ç\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0002\u0010\u0088\u0002R\u0018\u0010É\u0002\u001a\u00030È\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0002\u0010Ê\u0002R\u0018\u0010Ë\u0002\u001a\u00030\u0097\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0002\u0010\u0099\u0002R\u0018\u0010Ì\u0002\u001a\u00030\u0097\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0002\u0010\u0099\u0002R%\u0010Î\u0002\u001a\u0010\u0012\u0005\u0012\u00030Á\u0002\u0012\u0004\u0012\u00020\u00060Í\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0002\u0010Ï\u0002R$\u0010Ð\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060Í\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0002\u0010Ï\u0002R\u0018\u0010Ò\u0002\u001a\u00030Ñ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÒ\u0002\u0010Ó\u0002R\u0018\u0010Õ\u0002\u001a\u00030Ô\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÕ\u0002\u0010Ö\u0002R\u0019\u0010×\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0002\u0010\u0088\u0002R\u0019\u0010Ø\u0002\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0002\u0010\u009f\u0002R\u001b\u0010Ù\u0002\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0002\u0010Ú\u0002R\u0018\u0010Û\u0002\u001a\u00030\u0097\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÛ\u0002\u0010\u0099\u0002R\u0018\u0010Ü\u0002\u001a\u00030\u0097\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0002\u0010\u0099\u0002¨\u0006Ý\u0002"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/DesktopChatResidentController;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "activity", "LY8/t;", "n0", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)V", "m0", "w2", "x2", "A2", "B2", "", "reason", "F0", "(Ljava/lang/String;)V", "u0", "w0", "d0", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;Ljava/lang/String;)V", "", "launcherId", "B3", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;I)V", "q0", "q2", "", "b2", "()Z", SdCardDbCreator.FIELD_LASTLOC_TIME, "s1", "b1", "r1", "u1", "e1", "J0", "taskId", "Z2", "(I)V", "c3", "()I", "s0", "(ILjava/lang/String;)V", "v1", "gen", "attempt", "z3", "(III)V", "H3", "o2", "C0", "g2", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)Z", "r3", "E0", "standalone", "x1", "fadeIn", "snapOpaque", "m3", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;ZZ)V", "h2", "E3", "(Ljava/lang/String;I)V", "y1", "B0", "Landroid/content/Context;", "c0", "()Landroid/content/Context;", "A0", "n1", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)I", "O2", "()Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "O1", "R2", "P2", "t2", "X2", SdCardDbCreator.FIELD_LASTLOC_INFO, "q1", "p1", "X1", SdCardDbCreator.FIELD_LASTLOC_ID, "kickLauncherAfter", "t1", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;Z)V", "E2", "F3", "z0", "W2", "y0", "animate", "G0", "(ZLjava/lang/String;)V", "F2", "G2", "j2", "C2", "J1", "(Ljava/lang/String;)Z", "H1", "Lkotlin/Function0;", "stillHidden", "l1", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;Lp9/a;)V", "E1", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;ZLp9/a;)V", "o3", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "phase", "N3", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)V", "", "transitionId", "expectedPhase", "s3", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;JLcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)V", "h3", "(Ljava/lang/String;Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)V", "peekIdleFromExplicitWake", "j3", "(Ljava/lang/String;Z)V", "l3", "h0", "i3", "Y1", "panel3", "W1", "I2", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)Ljava/lang/String;", "Y0", "u2", "t3", "wasFgAtPeek", "g3", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;JZ)V", "source", "U0", "P1", "V1", "S1", "L0", "agentId", "deviceId", "agentDisplayName", "M0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "t0", "sessionId", "restoreLast", "Q0", "(Ljava/lang/String;Z)Z", "O0", "s2", "L1", "S0", "j1", "i1", "W0", "J2", "S2", "o1", "X0", "o0", "g0", "d3", "u3", "i2", "D2", "F1", "j0", "i0", "Q1", "I1", "Y2", "Z1", "l2", "h1", "H", "r0", "f1", "T1", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;", "Z0", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeDismissReason;)Z", "b3", "M3", "D3", "e3", "O3", "w3", "v0", "v3", "L2", "context", "K2", "(Landroid/content/Context;)Ljava/lang/String;", "Landroid/app/ActivityManager$RunningTaskInfo;", "N2", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)Landroid/app/ActivityManager$RunningTaskInfo;", "M2", "(Landroid/content/Context;)Landroid/app/ActivityManager$RunningTaskInfo;", "U1", "C1", "I3", "q3", "L3", "x3", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;III)V", "m1", "(Landroid/content/Context;IILjava/lang/String;)V", "k1", "x0", "d2", "e2", "m2", "n2", "D1", "G3", "R1", "topPkg", "selfPkg", "c2", "(Ljava/lang/String;Ljava/lang/String;)Z", "l0", "M1", "y2", "r2", "action", "H0", "(I)Z", "I0", "w1", "TAG", "Ljava/lang/String;", "PEEK_FADE_MS", "J", "PEEK_RECENTS_COMMIT_MS", "YIELD_LANDING_RECHECK_MS", "SUPPRESS_NAV_WAKE_AFTER_HOME_MS", "CLEAR_OCCLUDED_DELAY_MS", "BRING_FRONT_STABLE_MS", "BRING_FRONT_SETTLE_MS", "BRING_FRONT_START_DELAY_MS", "MARK_OCCLUDED_DELAY_MS", "COVER_SAFETY_DELAY_MS", "COVER_PEEK_GLASS_RESTORE_DELAY_MS", "OPEN_DESKTOP_SETTLE_MS", "STANDALONE_OPEN_GRACE_MS", "RESTORE_3RD_AFTER_MORPH_MS", "Ljava/lang/ref/WeakReference;", "desktopRef", "Ljava/lang/ref/WeakReference;", "homeOverlayRef", "", "standaloneRefs", "Ljava/util/Set;", "Lcom/stepos/ailauncher/chat/sheet/Y;", "navInterceptor", "Lcom/stepos/ailauncher/chat/sheet/Y;", "enableAppNavInterceptor", "Z", "z1", "setEnableAppNavInterceptor", "(Z)V", UxipConstants.f30680s, "userDismissed", "B1", "hiddenForRecents", "A1", "Ljava/util/concurrent/atomic/AtomicLong;", "suppressNavWakeUntilElapsed", "Ljava/util/concurrent/atomic/AtomicLong;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "recentsCommitRunnable", "Ljava/lang/Runnable;", "yieldLandingRecheckRunnable", "recentsCommitPending", "recentsPeekVisualCommitted", "peekStartedElapsed", "workspaceRestoreGeneration", "I", "Ljava/util/concurrent/atomic/AtomicInteger;", "externalUiCover", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lcom/stepos/ailauncher/chat/sheet/V;", "externalUiHomeLayer", "Lcom/stepos/ailauncher/chat/sheet/V;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "homeLayerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dismissingExternalUi", "desktopUnderThirdPartyAtPeek", "desktopWasForegroundAtPeek", "desktopOccludedByOtherTask", "standaloneHiddenForPeek", "homeFollowingHiddenForPeek", "overlayOpenAtPeek", "minusOneYieldAtPeek", "panel3ExpandedAtPeek", "standaloneOpenProtectUntilElapsed", "closedStandaloneThisGesture", "underlyingThirdPartyTaskIdAtPeek", "coverPeekGlassSuspended", "pendingRestoreThirdPartyTaskId", "holdPanel1HiddenAfterBoardHome", "boardHomeExitRunning", "restoreThirdPartyAfterMorphRunnable", "pendingShowAfterBringFront", "bringFrontGeneration", "leftoverSheetFrontGeneration", "lastKnownLauncherTaskId", "openDesktopSettleUntilElapsed", "openDesktopForceRetries", "inputSinkDisabled", "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", "lastRecentsState", "Lcom/stepos/ailauncher/chat/broadcast/RecentsWindowMonitor$RecentsState;", "recentsTransitionSequence", "activeRecentsTransitionId", "recentsListenerRegistered", "overlayHostYieldCleanupRegistered", "LUa/M;", "overlayHostScope", "LUa/M;", "clearOccludedRunnable", "markOccludedRunnable", "Lkotlin/Function1;", "recentsListener", "Lp9/l;", "overlayRecentsSuspendListener", "com/stepos/ailauncher/chat/sheet/DesktopChatResidentController$c", "desktopRootStrategy", "Lcom/stepos/ailauncher/chat/sheet/DesktopChatResidentController$c;", "com/stepos/ailauncher/chat/sheet/DesktopChatResidentController$b", "boardRootStrategy", "Lcom/stepos/ailauncher/chat/sheet/DesktopChatResidentController$b;", "dismissKeepPassthrough", "dismissKickLauncherTaskId", "dismissKickAppContext", "Landroid/content/Context;", "restoreCoverPeekGlassRunnable", "coverSafetyRunnable", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DesktopChatResidentController {
    private static final long BRING_FRONT_SETTLE_MS = 450;
    private static final long BRING_FRONT_STABLE_MS = 560;
    private static final long BRING_FRONT_START_DELAY_MS = 160;
    private static final long CLEAR_OCCLUDED_DELAY_MS = 300;
    private static final long COVER_PEEK_GLASS_RESTORE_DELAY_MS = 450;
    private static final long COVER_SAFETY_DELAY_MS = 2000;
    private static final long MARK_OCCLUDED_DELAY_MS = 120;
    private static final long OPEN_DESKTOP_SETTLE_MS = 1200;
    private static final long PEEK_FADE_MS = 180;
    private static final long PEEK_RECENTS_COMMIT_MS = 120;
    private static final long RESTORE_3RD_AFTER_MORPH_MS = 550;
    private static final long STANDALONE_OPEN_GRACE_MS = 800;
    private static final long SUPPRESS_NAV_WAKE_AFTER_HOME_MS = 400;
    private static final String TAG = "DesktopChatResident";
    private static final long YIELD_LANDING_RECHECK_MS = 500;
    private static long activeRecentsTransitionId;
    private static volatile boolean boardHomeExitRunning;
    private static volatile int bringFrontGeneration;
    private static volatile boolean closedStandaloneThisGesture;
    private static volatile boolean coverPeekGlassSuspended;
    private static volatile boolean desktopOccludedByOtherTask;
    private static volatile WeakReference<ChatActivity> desktopRef;
    private static volatile boolean desktopUnderThirdPartyAtPeek;
    private static volatile boolean desktopWasForegroundAtPeek;
    private static volatile boolean dismissKeepPassthrough;
    private static Context dismissKickAppContext;
    private static volatile boolean enableAppNavInterceptor;
    private static volatile boolean hiddenForRecents;
    private static volatile boolean holdPanel1HiddenAfterBoardHome;
    private static volatile boolean homeFollowingHiddenForPeek;
    private static volatile WeakReference<ChatActivity> homeOverlayRef;
    private static volatile boolean inputSinkDisabled;
    private static volatile int leftoverSheetFrontGeneration;
    private static volatile boolean minusOneYieldAtPeek;
    private static volatile Y navInterceptor;
    private static volatile int openDesktopForceRetries;
    private static volatile long openDesktopSettleUntilElapsed;
    private static boolean overlayHostYieldCleanupRegistered;
    private static volatile boolean overlayOpenAtPeek;
    private static volatile boolean panel3ExpandedAtPeek;
    private static long peekStartedElapsed;
    private static volatile boolean pendingShowAfterBringFront;
    private static volatile boolean recentsCommitPending;
    private static boolean recentsListenerRegistered;
    private static volatile boolean recentsPeekVisualCommitted;
    private static long recentsTransitionSequence;
    private static volatile boolean standaloneHiddenForPeek;
    private static volatile long standaloneOpenProtectUntilElapsed;
    private static volatile boolean userDismissed;
    private static int workspaceRestoreGeneration;
    public static final DesktopChatResidentController INSTANCE = new DesktopChatResidentController();
    private static final Set<WeakReference<ChatActivity>> standaloneRefs = new LinkedHashSet();
    private static final AtomicLong suppressNavWakeUntilElapsed = new AtomicLong(0);
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Runnable recentsCommitRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.M
        @Override // java.lang.Runnable
        public final void run() {
            DesktopChatResidentController.U2();
        }
    };
    private static final Runnable yieldLandingRecheckRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.N
        @Override // java.lang.Runnable
        public final void run() {
            DesktopChatResidentController.P3();
        }
    };
    private static final AtomicInteger externalUiCover = new AtomicInteger(0);
    private static final V externalUiHomeLayer = new V();
    private static final AtomicBoolean homeLayerRegistered = new AtomicBoolean(false);
    private static final AtomicBoolean dismissingExternalUi = new AtomicBoolean(false);
    private static volatile int underlyingThirdPartyTaskIdAtPeek = -1;
    private static volatile int pendingRestoreThirdPartyTaskId = -1;
    private static final Runnable restoreThirdPartyAfterMorphRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.O
        @Override // java.lang.Runnable
        public final void run() {
            DesktopChatResidentController.p3();
        }
    };
    private static volatile int lastKnownLauncherTaskId = -1;
    private static volatile RecentsWindowMonitor.RecentsState lastRecentsState = RecentsWindowMonitor.RecentsState.IDLE;
    private static final Ua.M overlayHostScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
    private static final Runnable clearOccludedRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.P
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            DesktopChatResidentController.D0();
        }
    };
    private static final Runnable markOccludedRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.Q
        @Override // java.lang.Runnable
        public final void run() {
            DesktopChatResidentController.p2();
        }
    };
    private static final InterfaceC5074l<RecentsWindowMonitor.RecentsState, Y8.t> recentsListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.sheet.S
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return DesktopChatResidentController.V2((RecentsWindowMonitor.RecentsState) obj);
        }
    };
    private static final InterfaceC5074l<Boolean, Y8.t> overlayRecentsSuspendListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.sheet.m
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return DesktopChatResidentController.H2(((Boolean) obj).booleanValue());
        }
    };
    private static final c desktopRootStrategy = new c();
    private static final b boardRootStrategy = new b();
    private static volatile int dismissKickLauncherTaskId = -1;
    private static final Runnable restoreCoverPeekGlassRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.n
        @Override // java.lang.Runnable
        public final void run() {
            DesktopChatResidentController.f3();
        }
    };
    private static final Runnable coverSafetyRunnable = new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.o
        @Override // java.lang.Runnable
        public final void run() {
            DesktopChatResidentController.K0();
        }
    };

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecentsWindowMonitor.RecentsState.values().length];
            try {
                iArr[RecentsWindowMonitor.RecentsState.PEEK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecentsWindowMonitor.RecentsState.OVERVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecentsWindowMonitor.RecentsState.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"com/stepos/ailauncher/chat/sheet/DesktopChatResidentController$b", "Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;", "", "isPresent", "()Z", "", "taskId", "()I", "rootAction", "action", "consumeRoot", "(I)Z", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "homeGroupExitParticipant", "(I)Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", HomeGestureEligibilityContract.EXTRA_SCENE, "I", "getScene", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements RootStrategy {
        private final HomeRootToken token = HomeRootToken.BOARD;
        private final int scene = 2;

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public boolean consumeRoot(int action) {
            return DesktopChatResidentController.INSTANCE.H0(action);
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int getScene() {
            return this.scene;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public HomeRootToken getToken() {
            return this.token;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public HomeGroupExitParticipant homeGroupExitParticipant(int action) {
            ChatActivity chatActivityP2;
            if (action == 1 && (chatActivityP2 = DesktopChatResidentController.INSTANCE.P2()) != null) {
                return new C2734e(chatActivityP2);
            }
            return null;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public boolean isPresent() {
            DesktopChatResidentController desktopChatResidentController = DesktopChatResidentController.INSTANCE;
            desktopChatResidentController.S2();
            return desktopChatResidentController.O2() != null;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int rootAction() {
            return isPresent() ? 1 : 0;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int taskId() {
            ChatActivity chatActivityO2 = DesktopChatResidentController.INSTANCE.O2();
            if (chatActivityO2 != null) {
                return chatActivityO2.getTaskId();
            }
            return -1;
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"com/stepos/ailauncher/chat/sheet/DesktopChatResidentController$c", "Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;", "", "isPresent", "()Z", "", "taskId", "()I", "rootAction", "action", "consumeRoot", "(I)Z", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "homeGroupExitParticipant", "(I)Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", HomeGestureEligibilityContract.EXTRA_SCENE, "I", "getScene", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements RootStrategy {
        private final HomeRootToken token = HomeRootToken.DESKTOP;
        private final int scene = 1;

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public boolean consumeRoot(int action) {
            return DesktopChatResidentController.INSTANCE.I0(action);
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int getScene() {
            return this.scene;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public HomeRootToken getToken() {
            return this.token;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public HomeGroupExitParticipant homeGroupExitParticipant(int action) {
            ChatActivity chatActivityW0;
            if (action == 1 && (chatActivityW0 = DesktopChatResidentController.INSTANCE.W0()) != null) {
                return new C2734e(chatActivityW0);
            }
            return null;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public boolean isPresent() {
            DesktopChatResidentController desktopChatResidentController = DesktopChatResidentController.INSTANCE;
            if (desktopChatResidentController.W0() == null || desktopChatResidentController.B1()) {
                return desktopChatResidentController.D1();
            }
            return true;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int rootAction() {
            DesktopChatResidentController desktopChatResidentController = DesktopChatResidentController.INSTANCE;
            if (b0.a((desktopChatResidentController.W0() == null || desktopChatResidentController.B1()) ? false : true, desktopChatResidentController.m2()) && !b0.d(m0.INSTANCE.h(), desktopChatResidentController.n2())) {
                boolean zF2 = DesktopChatResidentController.f2(desktopChatResidentController, null, 1, null);
                return b0.c(DesktopChatResidentController.desktopUnderThirdPartyAtPeek || DesktopChatResidentController.desktopOccludedByOtherTask, DesktopChatResidentController.pendingShowAfterBringFront, (SystemClock.uptimeMillis() > DesktopChatResidentController.openDesktopSettleUntilElapsed ? 1 : (SystemClock.uptimeMillis() == DesktopChatResidentController.openDesktopSettleUntilElapsed ? 0 : -1)) < 0, zF2, (DesktopChatResidentController.pendingShowAfterBringFront || zF2) ? false : true) ? 2 : 0;
            }
            ChatActivity chatActivityW0 = desktopChatResidentController.W0();
            if (chatActivityW0 == null || desktopChatResidentController.B1()) {
                return 0;
            }
            if (b0.c(DesktopChatResidentController.desktopUnderThirdPartyAtPeek || DesktopChatResidentController.desktopOccludedByOtherTask || (desktopChatResidentController.A1() && !DesktopChatResidentController.desktopWasForegroundAtPeek), DesktopChatResidentController.pendingShowAfterBringFront, SystemClock.uptimeMillis() < DesktopChatResidentController.openDesktopSettleUntilElapsed, desktopChatResidentController.R1(chatActivityW0) || desktopChatResidentController.d2(chatActivityW0), (DesktopChatResidentController.pendingShowAfterBringFront || DesktopChatResidentController.desktopOccludedByOtherTask) ? false : true)) {
                return 2;
            }
            if (!chatActivityW0.O7() || desktopChatResidentController.A1() || chatActivityW0.getPanelHiddenForRecents() || DesktopChatResidentController.desktopOccludedByOtherTask) {
                return (chatActivityW0.O7() && DesktopChatResidentController.desktopWasForegroundAtPeek) ? 1 : 0;
            }
            return 1;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int taskId() {
            DesktopChatResidentController desktopChatResidentController = DesktopChatResidentController.INSTANCE;
            ChatActivity chatActivityW0 = desktopChatResidentController.W0();
            if (chatActivityW0 != null) {
                Integer numValueOf = Integer.valueOf(chatActivityW0.getTaskId());
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    desktopChatResidentController.Z2(iIntValue);
                    return iIntValue;
                }
            }
            return desktopChatResidentController.c3();
        }
    }

    public static final void A2(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        ChatScene chatSceneA = ChatScene.INSTANCE.a(activity.getIntent());
        if (chatSceneA.isLockScreen()) {
            X2("panel-resume:" + chatSceneA.getWireValue());
            return;
        }
        com.stepos.ailauncher.homegesture.J.o(com.stepos.ailauncher.homegesture.J.INSTANCE, "chat-resume:" + chatSceneA.getWireValue(), false, 2, null);
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.z0();
        desktopChatResidentController.F0("chat-resume:" + chatSceneA.getWireValue());
        X2("panel-resume:" + chatSceneA.getWireValue());
    }

    public static final void A3(int i10, int i11, int i12) {
        if (i10 != leftoverSheetFrontGeneration) {
            return;
        }
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        if (desktopChatResidentController.D1()) {
            if (!f2(desktopChatResidentController, null, 1, null)) {
                desktopChatResidentController.v1("leftover-sheets-landed attempt=" + i11);
                return;
            }
            if (i11 >= 3) {
                pendingShowAfterBringFront = false;
                C4148a.u(TAG, "leftover sheets still under 3rd after retries", false, 4, null);
                X2("leftover-sheets-still-under3rd");
                return;
            }
            Integer numValueOf = Integer.valueOf(desktopChatResidentController.c3());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                i12 = numValueOf.intValue();
            }
            C4148a.u(TAG, "leftover sheets still under 3rd → retry bringFront attempt=" + i11 + " launcherId=" + i12, false, 4, null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("retry-");
            sb2.append(i11);
            desktopChatResidentController.s0(i12, sb2.toString());
            desktopChatResidentController.z3(i12, i10, i11 + 1);
        }
    }

    public static final void B2(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (activity.isChangingConfigurations()) {
            return;
        }
        ChatScene chatSceneA = ChatScene.INSTANCE.a(activity.getIntent());
        if (chatSceneA.isLockScreen()) {
            X2("panel-stop:" + chatSceneA.getWireValue());
        }
    }

    public static final void C3(long j10, int i10) throws Resources.NotFoundException {
        DesktopChatResidentController desktopChatResidentController;
        ChatActivity chatActivityW0;
        if (userDismissed || (chatActivityW0 = (desktopChatResidentController = INSTANCE).W0()) == null || SystemClock.uptimeMillis() > j10 + 50) {
            return;
        }
        if (!desktopChatResidentController.R1(chatActivityW0) && !desktopChatResidentController.d2(chatActivityW0)) {
            openDesktopForceRetries = 0;
            if (hiddenForRecents || chatActivityW0.getPanelHiddenForRecents() || desktopOccludedByOtherTask || !chatActivityW0.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
                J3(desktopChatResidentController, chatActivityW0, false, 2, null);
                desktopOccludedByOtherTask = false;
                C4148a.k(TAG, "openDesktop settle check → show panel1", false, 4, null);
                return;
            }
            return;
        }
        if (openDesktopForceRetries >= 2) {
            C4148a.h(TAG, "openDesktop settle: still covered after retries, give up", false, 4, null);
            desktopOccludedByOtherTask = true;
            desktopChatResidentController.i2(chatActivityW0);
            return;
        }
        openDesktopForceRetries++;
        C4148a.u(TAG, "openDesktop settle check: still covered → force front+retry n=" + openDesktopForceRetries, false, 4, null);
        if (i10 > 0) {
            e0 e0Var = e0.INSTANCE;
            Context applicationContext = chatActivityW0.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            e0Var.b(applicationContext, i10, false, true);
        }
        pendingShowAfterBringFront = true;
        desktopChatResidentController.L3(chatActivityW0, "settle-still-covered");
    }

    public static final void D0() throws Resources.NotFoundException {
        ComponentName componentName;
        Intent intent;
        ComponentName component;
        ComponentName componentName2;
        ComponentName componentName3;
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (chatActivityW0 == null) {
            return;
        }
        if (chatActivityW0.y7()) {
            C4148a.d(TAG, "clearOccluded → keep quick-switch window hidden", false, 4, null);
            return;
        }
        if (userDismissed) {
            return;
        }
        if (T1()) {
            ActivityManager.RunningTaskInfo runningTaskInfoN2 = desktopChatResidentController.N2(chatActivityW0);
            String packageName = (runningTaskInfoN2 == null || (componentName3 = runningTaskInfoN2.topActivity) == null) ? null : componentName3.getPackageName();
            T t10 = T.INSTANCE;
            boolean zC = t10.c(packageName, (runningTaskInfoN2 == null || (componentName2 = runningTaskInfoN2.baseActivity) == null) ? null : componentName2.getClassName(), (runningTaskInfoN2 == null || (intent = runningTaskInfoN2.baseIntent) == null || (component = intent.getComponent()) == null) ? null : component.getClassName(), (runningTaskInfoN2 == null || (componentName = runningTaskInfoN2.topActivity) == null) ? null : componentName.getClassName());
            boolean z10 = lastRecentsState == RecentsWindowMonitor.RecentsState.IDLE;
            String packageName2 = chatActivityW0.getPackageName();
            kotlin.jvm.internal.p.h(packageName2, "getPackageName(...)");
            if (!t10.e(true, z10, packageName, packageName2, desktopChatResidentController.C1(chatActivityW0), zC) || !chatActivityW0.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED) || !desktopChatResidentController.X1(chatActivityW0)) {
                C4148a.d(TAG, "clearOccluded: skip while external UI cover (keep panel) top=" + packageName + " relay=" + desktopChatResidentController.C1(chatActivityW0) + " extUi=" + zC, false, 4, null);
                return;
            }
            C4148a.k(TAG, "clearOccluded: drop leftover cover on desktop resume top=" + packageName, false, 4, null);
            desktopChatResidentController.b3("stable-desktop-resume");
        }
        if (chatActivityW0.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED) && lastRecentsState == RecentsWindowMonitor.RecentsState.IDLE) {
            boolean z11 = (!desktopChatResidentController.X1(chatActivityW0) || desktopChatResidentController.R1(chatActivityW0) || desktopChatResidentController.d2(chatActivityW0)) ? false : true;
            if (pendingShowAfterBringFront && z11) {
                desktopChatResidentController.p1(chatActivityW0);
                return;
            }
            if (!z11) {
                if (hiddenForRecents || desktopOccludedByOtherTask) {
                    h1(chatActivityW0);
                    C4148a.d(TAG, "skip auto-show: still under other task (keep InputSink off)", false, 4, null);
                    return;
                } else {
                    desktopOccludedByOtherTask = false;
                    C4148a.d(TAG, "desktopOccluded cleared (stable resume, not front)", false, 4, null);
                    return;
                }
            }
            if (!hiddenForRecents && !desktopOccludedByOtherTask) {
                desktopOccludedByOtherTask = false;
                C4148a.d(TAG, "desktopOccluded cleared (stable resume)", false, 4, null);
            } else if (holdPanel1HiddenAfterBoardHome && desktopChatResidentController.d2(chatActivityW0)) {
                h1(chatActivityW0);
                C4148a.d(TAG, "clearOccluded: skip restore, still holding panel1 under 3rd after board home", false, 4, null);
            } else {
                J3(desktopChatResidentController, chatActivityW0, false, 2, null);
                desktopChatResidentController.o0(chatActivityW0);
                C4148a.k(TAG, "clearOccluded → restore panel1 (edge-back/resume on desktop)", false, 4, null);
            }
        }
    }

    public static final void D2(ChatActivity activity) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (activity.isFinishing() || activity.isDestroyed() || activity.y7() || RecentsWindowMonitor.INSTANCE.h() != RecentsWindowMonitor.RecentsState.IDLE) {
            return;
        }
        if (activity.getHiddenForRecentsPeek()) {
            activity.E3();
        }
        if (activity.getPanelHiddenForRecents()) {
            WeakReference<ChatActivity> weakReference = desktopRef;
            if ((weakReference != null ? weakReference.get() : null) == activity) {
                DesktopChatResidentController desktopChatResidentController = INSTANCE;
                J3(desktopChatResidentController, activity, false, 2, null);
                desktopChatResidentController.o0(activity);
            } else {
                n3(INSTANCE, activity, false, false, 6, null);
                Object objB = com.stepos.ailauncher.chat.panelui.v.INSTANCE.b(activity);
                if (objB != null) {
                    com.stepos.ailauncher.chat.panelui.i.INSTANCE.g(objB);
                }
            }
        }
    }

    public static final void E2() {
        boolean zR;
        com.stepos.ailauncher.homegesture.J j10 = com.stepos.ailauncher.homegesture.J.INSTANCE;
        j10.g();
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        boolean z10 = f2(desktopChatResidentController, null, 1, null) && (m0.INSTANCE.h() || desktopChatResidentController.n2() > 0);
        if (z10) {
            j10.h(true);
            zR = true;
        } else {
            zR = j10.r();
            j10.h(zR);
        }
        minusOneYieldAtPeek = zR;
        if (zR) {
            desktopChatResidentController.F3();
        } else {
            desktopChatResidentController.z0();
        }
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshotCurrentSnapshot = iHomeGestureCoordinator != null ? iHomeGestureCoordinator.currentSnapshot() : null;
        if (homeGestureEligibilitySnapshotCurrentSnapshot != null) {
            HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshot = (!homeGestureEligibilitySnapshotCurrentSnapshot.getConsumable() || minusOneYieldAtPeek) ? null : homeGestureEligibilitySnapshotCurrentSnapshot;
            if (homeGestureEligibilitySnapshot != null) {
                iHomeGestureCoordinator.beginPeek(homeGestureEligibilitySnapshot);
            }
        }
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        boolean z11 = T1() || (chatActivityW0 != null && desktopChatResidentController.U1(chatActivityW0));
        boolean z12 = (chatActivityW0 == null || userDismissed || z11 || (!desktopOccludedByOtherTask && !desktopChatResidentController.R1(chatActivityW0) && !desktopChatResidentController.d2(chatActivityW0))) ? false : true;
        desktopUnderThirdPartyAtPeek = z12;
        desktopWasForegroundAtPeek = (chatActivityW0 == null || userDismissed || z12) ? false : true;
        if (z12 && chatActivityW0 != null) {
            desktopChatResidentController.g0(chatActivityW0, true);
            C4148a.k(TAG, "onRecentsPeek → panel1 hide pixels early (under3rd)", false, 4, null);
        }
        closedStandaloneThisGesture = false;
        boardHomeExitRunning = false;
        standaloneHiddenForPeek = false;
        homeFollowingHiddenForPeek = false;
        m0 m0Var = m0.INSTANCE;
        overlayOpenAtPeek = m0Var.h();
        panel3ExpandedAtPeek = false;
        if (C2732c.c(z11, m0Var.h(), desktopChatResidentController.n2())) {
            if (chatActivityW0 == null && (chatActivityW0 = desktopChatResidentController.R2()) == null) {
                chatActivityW0 = desktopChatResidentController.L1();
            }
            desktopChatResidentController.A0(chatActivityW0);
        } else {
            underlyingThirdPartyTaskIdAtPeek = -1;
            if (z11) {
                desktopChatResidentController.M3("peek-cover");
            }
        }
        recentsPeekVisualCommitted = false;
        peekStartedElapsed = SystemClock.elapsedRealtime();
        workspaceRestoreGeneration++;
        desktopChatResidentController.y0("new-peek");
        recentsCommitPending = true;
        mainHandler.postDelayed(recentsCommitRunnable, 120L);
        Integer numValueOf = homeGestureEligibilitySnapshotCurrentSnapshot != null ? Integer.valueOf(homeGestureEligibilitySnapshotCurrentSnapshot.getAction()) : null;
        Boolean boolValueOf = homeGestureEligibilitySnapshotCurrentSnapshot != null ? Boolean.valueOf(homeGestureEligibilitySnapshotCurrentSnapshot.getConsumable()) : null;
        Long lValueOf = homeGestureEligibilitySnapshotCurrentSnapshot != null ? Long.valueOf(homeGestureEligibilitySnapshotCurrentSnapshot.getGeneration()) : null;
        RecentsWindowMonitor recentsWindowMonitor = RecentsWindowMonitor.INSTANCE;
        C4148a.k(TAG, "onRecentsPeek → schedule recents-commit 120ms action=" + numValueOf + " consumable=" + boolValueOf + " gen=" + lValueOf + " recents=" + recentsWindowMonitor.h() + " peekElapsed=" + recentsWindowMonitor.o() + "ms overlayOpen=" + m0Var.h() + " hostFg=" + m0Var.g() + " latched=" + j10.f() + " yieldElapsed=" + j10.t() + "ms under3rd=" + z12 + " yieldMinusOne=" + minusOneYieldAtPeek + " covering3rd=" + z10 + " under3rdTask=" + underlyingThirdPartyTaskIdAtPeek, false, 4, null);
    }

    public static final void F2() {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.y0(M5.a.CARD_TYPE_OVERVIEW);
        desktopChatResidentController.G0(false, M5.a.CARD_TYPE_OVERVIEW);
        desktopChatResidentController.x0("onRecentsShown");
        desktopChatResidentController.Y0("ENTER_RECENTS");
        desktopChatResidentController.j2("onRecentsShown-fallback");
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (chatActivityW0 != null && !userDismissed) {
            desktopChatResidentController.g0(chatActivityW0, false);
        }
        C4148a.k(TAG, "onRecentsShown → standalone finish; panel3 hidden; desktop passthrough", false, 4, null);
        desktopChatResidentController.e3(M5.a.CARD_TYPE_OVERVIEW);
        X2("recents-shown");
    }

    public static final boolean G1() {
        return hiddenForRecents;
    }

    public static final Y8.t H2(boolean z10) throws Resources.NotFoundException {
        if (z10) {
            INSTANCE.G2();
        } else if (lastRecentsState == RecentsWindowMonitor.RecentsState.IDLE) {
            INSTANCE.h3("RECENTS_SUSPEND_CLEARED", PanelLayerRecentsPhase.OVERVIEW);
        }
        return Y8.t.f7040a;
    }

    public static final boolean H3() {
        long j10 = suppressNavWakeUntilElapsed.get();
        if (j10 <= 0) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime >= j10) {
            return false;
        }
        C4148a.k(TAG, "suppress NAVIGATION_WAKE for " + (j10 - jElapsedRealtime) + "ms after HOME consume", false, 4, null);
        return true;
    }

    public static /* synthetic */ void J3(DesktopChatResidentController desktopChatResidentController, ChatActivity chatActivity, boolean z10, int i10, Object obj) throws Resources.NotFoundException {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        desktopChatResidentController.I3(chatActivity, z10);
    }

    public static final void K0() {
        INSTANCE.v3();
    }

    public static final boolean K1() {
        return standaloneHiddenForPeek;
    }

    public static final void K3(ChatActivity chatActivity) throws Resources.NotFoundException {
        if (chatActivity.isFinishing() || chatActivity.isDestroyed()) {
            return;
        }
        chatActivity.f9();
    }

    public static final int L0() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.S2();
        ChatActivity chatActivityO2 = desktopChatResidentController.O2();
        if (chatActivityO2 == null || !ChatScene.INSTANCE.a(chatActivityO2.getIntent()).isStandaloneTask() || desktopChatResidentController.a2(chatActivityO2)) {
            return -1;
        }
        Integer numValueOf = Integer.valueOf(chatActivityO2.getTaskId());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            int iIntValue = numValueOf.intValue();
            try {
                ActivityManager activityManager = (ActivityManager) chatActivityO2.getSystemService(ActivityManager.class);
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) != null) {
                    ComponentName componentName = runningTaskInfo.topActivity;
                    String className = componentName != null ? componentName.getClassName() : null;
                    if (className == null) {
                        className = "";
                    }
                    ComponentName componentName2 = runningTaskInfo.topActivity;
                    if (kotlin.jvm.internal.p.d(componentName2 != null ? componentName2.getPackageName() : null, chatActivityO2.getPackageName()) && className.length() > 0) {
                        if (!kotlin.jvm.internal.p.d(className, chatActivityO2.getClass().getName())) {
                            return iIntValue;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static final boolean M0(final String agentId, final String deviceId, final String agentDisplayName) throws Resources.NotFoundException {
        final ChatActivity chatActivity;
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        final ChatActivity chatActivityW0 = userDismissed ? null : INSTANCE.W0();
        if (chatActivityW0 == null) {
            ChatActivity chatActivityL1 = INSTANCE.L1();
            if (chatActivityL1 == null) {
                boolean zL = l0.INSTANCE.l(agentId, deviceId, agentDisplayName);
                C4148a.k(TAG, "deliverAgentConversation: no resident chat, embedded overlay handled=" + zL + " agentId=" + agentId, false, 4, null);
                return zL;
            }
            chatActivity = chatActivityL1;
        } else {
            chatActivity = chatActivityW0;
        }
        if (chatActivityW0 != null) {
            DesktopChatResidentController desktopChatResidentController = INSTANCE;
            J3(desktopChatResidentController, chatActivityW0, false, 2, null);
            desktopChatResidentController.o0(chatActivityW0);
            Integer numValueOf = Integer.valueOf(chatActivityW0.getTaskId());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : -1;
            if (iIntValue > 0) {
                e0 e0Var = e0.INSTANCE;
                Context applicationContext = chatActivityW0.getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                e0Var.b(applicationContext, iIntValue, false, true);
            }
        }
        chatActivity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.z
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                DesktopChatResidentController.N0(chatActivity, chatActivityW0, agentId, deviceId, agentDisplayName);
            }
        });
        String str = chatActivityW0 != null ? "desktop" : "homeOverlay";
        C4148a.k(TAG, "deliverAgentConversation reused " + str + " chat, agentId=" + agentId + " deviceId=" + deviceId + " taskId=" + chatActivity.getTaskId(), false, 4, null);
        return true;
    }

    public static final void N0(ChatActivity chatActivity, ChatActivity chatActivity2, String str, String str2, String str3) throws Resources.NotFoundException {
        if (chatActivity.isFinishing() || chatActivity.isDestroyed()) {
            return;
        }
        if (chatActivity2 == null) {
            chatActivity.P9(false);
        }
        chatActivity.t8(str, str2, str3);
    }

    public static final Y8.t N1() {
        INSTANCE.y0("home-consume");
        return Y8.t.f7040a;
    }

    public static final boolean O0(final String sessionId, final boolean restoreLast) {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.S2();
        final ChatActivity chatActivityO2 = desktopChatResidentController.O2();
        if (chatActivityO2 == null) {
            return false;
        }
        boolean zS2 = desktopChatResidentController.s2(chatActivityO2);
        if (zS2 && !e0.INSTANCE.a(chatActivityO2, chatActivityO2.getTaskId())) {
            C4148a.u(TAG, "deliverBoardRestore front request failed taskId=" + chatActivityO2.getTaskId(), false, 4, null);
            return false;
        }
        ChatScene.Companion companion = ChatScene.INSTANCE;
        if (C2732c.d(companion.a(chatActivityO2.getIntent()))) {
            b1("deliver-board-restore");
        }
        boolean panelHiddenForRecents = chatActivityO2.getPanelHiddenForRecents();
        standaloneHiddenForPeek = false;
        closedStandaloneThisGesture = false;
        desktopChatResidentController.q2();
        chatActivityO2.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.p
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                DesktopChatResidentController.P0(chatActivityO2, sessionId, restoreLast);
            }
        });
        C4148a.k(TAG, "deliverBoardRestore reused standalone, sessionId=" + sessionId + " scene=" + companion.a(chatActivityO2.getIntent()) + " taskId=" + chatActivityO2.getTaskId() + " wasHidden=" + panelHiddenForRecents + " frontRequested=" + zS2 + " (enterFromBottom + showVisually)", false, 4, null);
        return true;
    }

    public static final void P0(ChatActivity chatActivity, String str, boolean z10) throws Resources.NotFoundException {
        if (chatActivity.isFinishing() || chatActivity.isDestroyed()) {
            return;
        }
        chatActivity.M8(str, true, z10);
        J3(INSTANCE, chatActivity, false, 2, null);
    }

    public static final boolean P1() {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        if (desktopChatResidentController.V1(desktopChatResidentController.J2())) {
            return true;
        }
        WeakReference<ChatActivity> weakReference = homeOverlayRef;
        if (desktopChatResidentController.V1(weakReference != null ? weakReference.get() : null)) {
            return true;
        }
        Iterator<WeakReference<ChatActivity>> it = standaloneRefs.iterator();
        while (it.hasNext()) {
            if (INSTANCE.V1(it.next().get())) {
                return true;
            }
        }
        return false;
    }

    public static final void P3() {
        INSTANCE.W2();
    }

    public static final boolean Q0(final String sessionId, final boolean restoreLast) throws Resources.NotFoundException {
        DesktopChatResidentController desktopChatResidentController;
        final ChatActivity chatActivityW0;
        if (userDismissed || (chatActivityW0 = (desktopChatResidentController = INSTANCE).W0()) == null) {
            return false;
        }
        J3(desktopChatResidentController, chatActivityW0, false, 2, null);
        desktopChatResidentController.o0(chatActivityW0);
        Integer numValueOf = Integer.valueOf(chatActivityW0.getTaskId());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : -1;
        if (iIntValue > 0) {
            e0 e0Var = e0.INSTANCE;
            Context applicationContext = chatActivityW0.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            e0Var.b(applicationContext, iIntValue, false, true);
        }
        chatActivityW0.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.u
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                DesktopChatResidentController.R0(chatActivityW0, sessionId, restoreLast);
            }
        });
        C4148a.k(TAG, "deliverRestore reused resident chat, sessionId=" + sessionId + " taskId=" + iIntValue, false, 4, null);
        return true;
    }

    public static final ChatActivity Q2(WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return (ChatActivity) it.get();
    }

    public static final void R0(ChatActivity chatActivity, String str, boolean z10) throws Resources.NotFoundException {
        if (chatActivity.isFinishing() || chatActivity.isDestroyed()) {
            return;
        }
        ChatActivity.N8(chatActivity, str, false, z10, 2, null);
    }

    public static final boolean S0(final String sessionId) throws Resources.NotFoundException {
        DesktopChatResidentController desktopChatResidentController;
        final ChatActivity chatActivityW0;
        if (userDismissed || (chatActivityW0 = (desktopChatResidentController = INSTANCE).W0()) == null) {
            return false;
        }
        J3(desktopChatResidentController, chatActivityW0, false, 2, null);
        desktopChatResidentController.o0(chatActivityW0);
        Integer numValueOf = Integer.valueOf(chatActivityW0.getTaskId());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : -1;
        if (iIntValue > 0) {
            e0 e0Var = e0.INSTANCE;
            Context applicationContext = chatActivityW0.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            e0Var.b(applicationContext, iIntValue, false, true);
        }
        chatActivityW0.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.G
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                DesktopChatResidentController.T0(chatActivityW0, sessionId);
            }
        });
        C4148a.k(TAG, "deliverRestoreHalf reused resident chat, sessionId=" + sessionId + " taskId=" + iIntValue, false, 4, null);
        return true;
    }

    public static final boolean S1() {
        DesktopChatResidentController desktopChatResidentController;
        ChatActivity chatActivityW0;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        if (userDismissed || (chatActivityW0 = (desktopChatResidentController = INSTANCE).W0()) == null || desktopChatResidentController.a2(chatActivityW0)) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) chatActivityW0.getSystemService(ActivityManager.class);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) != null) {
                ComponentName componentName = runningTaskInfo.topActivity;
                String className = componentName != null ? componentName.getClassName() : null;
                if (className == null) {
                    className = "";
                }
                ComponentName componentName2 = runningTaskInfo.topActivity;
                if (kotlin.jvm.internal.p.d(componentName2 != null ? componentName2.getPackageName() : null, chatActivityW0.getPackageName()) && className.length() > 0) {
                    if (!kotlin.jvm.internal.p.d(className, chatActivityW0.getClass().getName())) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final void T0(ChatActivity chatActivity, String str) throws Resources.NotFoundException {
        if (chatActivity.isFinishing() || chatActivity.isDestroyed()) {
            return;
        }
        chatActivity.O8(str);
    }

    public static final boolean T1() {
        return externalUiCover.get() > 0;
    }

    public static final boolean T2(WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        ChatActivity chatActivity = (ChatActivity) it.get();
        return chatActivity == null || chatActivity.isFinishing() || chatActivity.isDestroyed();
    }

    public static final boolean U0(final String source) throws Resources.NotFoundException {
        DesktopChatResidentController desktopChatResidentController;
        final ChatActivity chatActivityW0;
        if (userDismissed || (chatActivityW0 = (desktopChatResidentController = INSTANCE).W0()) == null) {
            return false;
        }
        final RecordingPresentation recordingPresentation = (C4814a.INSTANCE.d(source) && (hiddenForRecents || desktopOccludedByOtherTask || chatActivityW0.getPanelHiddenForRecents())) ? RecordingPresentation.FULL_SCREEN : null;
        J3(desktopChatResidentController, chatActivityW0, false, 2, null);
        desktopChatResidentController.o0(chatActivityW0);
        Integer numValueOf = Integer.valueOf(chatActivityW0.getTaskId());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : -1;
        if (iIntValue > 0) {
            e0 e0Var = e0.INSTANCE;
            Context applicationContext = chatActivityW0.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            e0Var.b(applicationContext, iIntValue, false, true);
        }
        chatActivityW0.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.I
            @Override // java.lang.Runnable
            public final void run() {
                DesktopChatResidentController.V0(chatActivityW0, source, recordingPresentation);
            }
        });
        C4148a.k(TAG, "deliverWake reused resident chat, source=" + source + " taskId=" + iIntValue, false, 4, null);
        return true;
    }

    public static final void U2() {
        INSTANCE.G0(true, "delay");
    }

    public static final void V0(ChatActivity chatActivity, String str, RecordingPresentation recordingPresentation) {
        if (chatActivity.isFinishing() || chatActivity.isDestroyed()) {
            return;
        }
        chatActivity.V8(str, recordingPresentation);
    }

    public static final Y8.t V2(RecentsWindowMonitor.RecentsState state) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(state, "state");
        RecentsWindowMonitor.RecentsState recentsState = lastRecentsState;
        lastRecentsState = state;
        int[] iArr = a.$EnumSwitchMapping$0;
        int i10 = iArr[state.ordinal()];
        if (i10 == 1) {
            if (recentsState == RecentsWindowMonitor.RecentsState.IDLE) {
                long j10 = recentsTransitionSequence + 1;
                recentsTransitionSequence = j10;
                activeRecentsTransitionId = j10;
            }
            E2();
        } else if (i10 == 2) {
            INSTANCE.z0();
            if (recentsState == RecentsWindowMonitor.RecentsState.IDLE) {
                long j11 = recentsTransitionSequence + 1;
                recentsTransitionSequence = j11;
                activeRecentsTransitionId = j11;
                C4148a.u(TAG, "IDLE→OVERVIEW skipped PEEK; run peek hide first", false, 4, null);
                E2();
            }
            F2();
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            DesktopChatResidentController desktopChatResidentController = INSTANCE;
            desktopChatResidentController.C0("recents-idle");
            int i11 = iArr[recentsState.ordinal()];
            if (i11 == 1) {
                C4148a.d(TAG, RecentsWindowMonitor.INSTANCE.n() ? "PEEK→IDLE (explicit-wake)" : "PEEK→IDLE (CANCEL_GESTURE)", false, 4, null);
                desktopChatResidentController.C2();
            } else if (i11 == 2) {
                u2();
            }
        }
        return Y8.t.f7040a;
    }

    public static final void X2(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        INSTANCE.S2();
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.notifyTopologyChanged(reason);
            return;
        }
        C4148a.u(TAG, "refreshHomeGestureEligibility skipped, no coordinator reason=" + reason, false, 4, null);
    }

    public static final void Y2(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (activity.isFinishing() || activity.isDestroyed() || !activity.getPanelHiddenForRecents()) {
            return;
        }
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        if (desktopChatResidentController.Q1(activity) && desktopChatResidentController.Z1(activity)) {
            desktopChatResidentController.i0(activity);
            desktopChatResidentController.I1(activity);
        }
    }

    public static final boolean Z0(HomeDismissReason reason) {
        Object objB;
        kotlin.jvm.internal.p.i(reason, "reason");
        Object obj = null;
        if (!dismissingExternalUi.compareAndSet(false, true)) {
            C4148a.k(TAG, "dismissExternalUiForHome reentrant reason=" + reason, false, 4, null);
            return true;
        }
        try {
            C4148a.k(TAG, "dismissExternalUiForHome reason=" + reason + " cover=" + externalUiCover.get(), false, 4, null);
            com.stepos.ailauncher.common.permission.G g10 = com.stepos.ailauncher.common.permission.G.INSTANCE;
            g10.W();
            com.stepos.ailauncher.common.permission.G.x(g10, "home-gesture", false, 2, null);
            g10.D();
            CameraLauncher.INSTANCE.a();
            TransferActivity.INSTANCE.d();
            PickFileMediatorActivity.INSTANCE.b();
            ChatActivity chatActivityW0 = INSTANCE.W0();
            int taskId = chatActivityW0 != null ? chatActivityW0.getTaskId() : -1;
            if (chatActivityW0 == null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(C3197a.INSTANCE.a());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (!Result.g(objB)) {
                    obj = objB;
                }
            } else {
                obj = chatActivityW0;
            }
            if (obj != null) {
                U.INSTANCE.a((Context) obj, taskId);
            }
            if (chatActivityW0 != null && !chatActivityW0.isFinishing() && !chatActivityW0.isDestroyed()) {
                U.INSTANCE.c(chatActivityW0);
            }
            desktopUnderThirdPartyAtPeek = false;
            desktopWasForegroundAtPeek = true;
            DesktopChatResidentController desktopChatResidentController = INSTANCE;
            desktopChatResidentController.b3("home-dismiss:" + reason);
            if (lastRecentsState == RecentsWindowMonitor.RecentsState.IDLE) {
                desktopChatResidentController.D3("home-dismiss-idle");
            }
            return true;
        } finally {
            dismissingExternalUi.set(false);
        }
    }

    public static final void a3() throws Resources.NotFoundException {
        C4148a.u(TAG, "requestHomeDismiss called from:\n" + Log.getStackTraceString(new Throwable("call-site")), false, 4, null);
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (chatActivityW0 == null || userDismissed) {
            C4148a.u(TAG, "requestHomeDismiss: no desktop chat", false, 4, null);
        } else {
            C4148a.k(TAG, "requestHomeDismiss → dismiss desktop", false, 4, null);
            desktopChatResidentController.a1(chatActivityW0);
        }
    }

    public static final void b1(final String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.sheet.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DesktopChatResidentController.c1(reason);
            }
        };
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            interfaceC5063a.invoke();
        } else {
            mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.D
                @Override // java.lang.Runnable
                public final void run() {
                    DesktopChatResidentController.d1(interfaceC5063a);
                }
            });
        }
    }

    public static final Y8.t c1(String str) throws Resources.NotFoundException {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.r1();
        desktopChatResidentController.u1(str);
        d0.c(str);
        l0.INSTANCE.f();
        C4148a.k(TAG, "dismissUnderlyingChatForBoard done reason=" + str, false, 4, null);
        return Y8.t.f7040a;
    }

    public static final void d1(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final void e0() throws Resources.NotFoundException {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (chatActivityW0 == null || userDismissed) {
            return;
        }
        if (openDesktopSettleUntilElapsed == 0) {
            C4148a.d(TAG, "openDesktop settle restore skipped (settle cancelled)", false, 4, null);
            return;
        }
        if (desktopChatResidentController.R1(chatActivityW0) || desktopChatResidentController.d2(chatActivityW0)) {
            return;
        }
        J3(desktopChatResidentController, chatActivityW0, false, 2, null);
        desktopOccludedByOtherTask = false;
        desktopChatResidentController.o0(chatActivityW0);
        C4148a.k(TAG, "openDesktop settle → restored after force front", false, 4, null);
    }

    public static final boolean e1() {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.S2();
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        boolean z10 = (chatActivityW0 == null || userDismissed || hiddenForRecents || chatActivityW0.isFinishing() || chatActivityW0.isDestroyed()) ? false : true;
        if (z10) {
            C4148a.k(TAG, "dismissWakeSurface → keep desktop resident (occlude passthrough, no collapse)", false, 4, null);
            openDesktopSettleUntilElapsed = 0L;
        }
        Set<WeakReference<ChatActivity>> set = standaloneRefs;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            ChatActivity chatActivity = (ChatActivity) ((WeakReference) it.next()).get();
            if (chatActivity != null) {
                arrayList.add(chatActivity);
            }
        }
        ArrayList<ChatActivity> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            ChatActivity chatActivity2 = (ChatActivity) obj;
            if (!chatActivity2.isFinishing() && !chatActivity2.isDestroyed()) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            if (!z10) {
                C4148a.d(TAG, "dismissWakeSurface: no standalone wake surface (desktop resident kept)", false, 4, null);
            }
            return z10;
        }
        for (ChatActivity chatActivity3 : arrayList2) {
            C4148a.k(TAG, "dismissWakeSurface → morph-dismiss standalone scene=" + ChatScene.INSTANCE.a(chatActivity3.getIntent()) + " taskId=" + chatActivity3.getTaskId(), false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                chatActivity3.J1();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        return true;
    }

    public static final void f0(int i10) {
        INSTANCE.k1(i10, "re-covered-retry");
    }

    public static final void f1() {
        int iUpdateAndGet = externalUiCover.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.ailauncher.chat.sheet.l
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i10) {
                return DesktopChatResidentController.g1(i10);
            }
        });
        C4148a.k(TAG, "endPermissionCover n=" + iUpdateAndGet, false, 4, null);
        if (iUpdateAndGet > 0) {
            return;
        }
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.v0();
        desktopChatResidentController.O3();
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (chatActivityW0 == null || chatActivityW0.isFinishing() || chatActivityW0.isDestroyed() || userDismissed) {
            return;
        }
        if (hiddenForRecents || desktopOccludedByOtherTask) {
            h1(chatActivityW0);
        }
        if (!dismissingExternalUi.get() && lastRecentsState == RecentsWindowMonitor.RecentsState.IDLE) {
            desktopChatResidentController.e3("cover-end-idle");
        }
    }

    public static /* synthetic */ boolean f2(DesktopChatResidentController desktopChatResidentController, ChatActivity chatActivity, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            chatActivity = desktopChatResidentController.J2();
        }
        return desktopChatResidentController.e2(chatActivity);
    }

    public static final void f3() {
        INSTANCE.e3("delayed");
    }

    public static final int g1(int i10) {
        return T.INSTANCE.a(i10 - 1);
    }

    public static final void h1(ChatActivity activity) {
        Window window;
        kotlin.jvm.internal.p.i(activity, "activity");
        if (activity.isFinishing() || activity.isDestroyed() || (window = activity.getWindow()) == null) {
            return;
        }
        boolean zA = C2730a.INSTANCE.a(activity, false);
        if (zA) {
            inputSinkDisabled = true;
        } else {
            C4148a.u(TAG, "ensurePassthrough: InputSink disable failed", false, 4, null);
        }
        window.addFlags(16);
        if (!activity.getPanelHiddenForRecents()) {
            activity.Q9(true);
        }
        C4148a.d(TAG, "ensureInvisibleTouchPassthrough sinkOff=" + zA, false, 4, null);
    }

    public static final void i3(String reason) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(reason, "reason");
        RecentsWindowMonitor.RecentsState recentsStateH = RecentsWindowMonitor.INSTANCE.h();
        if (recentsStateH == RecentsWindowMonitor.RecentsState.PEEK || recentsStateH == RecentsWindowMonitor.RecentsState.OVERVIEW) {
            return;
        }
        INSTANCE.h3(reason, PanelLayerRecentsPhase.PEEK);
    }

    public static final void k0(ChatActivity chatActivity, InterfaceC5063a interfaceC5063a) {
        if (chatActivity.isFinishing() || chatActivity.isDestroyed() || !((Boolean) interfaceC5063a.invoke()).booleanValue()) {
            return;
        }
        INSTANCE.i0(chatActivity);
    }

    public static final boolean k2() {
        return homeFollowingHiddenForPeek;
    }

    public static /* synthetic */ void k3(DesktopChatResidentController desktopChatResidentController, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        desktopChatResidentController.j3(str, z10);
    }

    public static final void l3(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.t3();
        D5.a aVar = D5.a.INSTANCE;
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) aVar.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.resumePartition(HomeRootToken.MINUS_ONE);
        }
        if (!m0.INSTANCE.h()) {
            IOverlayPageHost iOverlayPageHost = (IOverlayPageHost) aVar.a(IOverlayPageHost.class);
            if (iOverlayPageHost == null) {
                C4148a.u(TAG, "restoreMinusOneStackFromThirdParty no IOverlayPageHost reason=" + reason, false, 4, null);
            } else {
                iOverlayPageHost.requestOpenOverlay(false);
                C4148a.k(TAG, "restoreMinusOneStackFromThirdParty → requestOpenOverlay reason=" + reason, false, 4, null);
            }
        }
        int iC3 = desktopChatResidentController.c3();
        Context contextC0 = desktopChatResidentController.c0();
        if (contextC0 != null && iC3 > 0) {
            e0.INSTANCE.b(contextC0, iC3, false, true);
        }
        C4148a.k(TAG, "restoreMinusOneStackFromThirdParty done reason=" + reason + " launcherId=" + iC3, false, 4, null);
        X2("restore-minus-one-stack");
    }

    public static /* synthetic */ void n3(DesktopChatResidentController desktopChatResidentController, ChatActivity chatActivity, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        desktopChatResidentController.m3(chatActivity, z10, z11);
    }

    public static final void p0(ChatActivity chatActivity) {
        if (chatActivity.isFinishing() || chatActivity.isDestroyed()) {
            return;
        }
        WeakReference<ChatActivity> weakReference = desktopRef;
        if ((weakReference != null ? weakReference.get() : null) == chatActivity && enableAppNavInterceptor && !hiddenForRecents && !userDismissed) {
            INSTANCE.X0();
            Y y10 = new Y(chatActivity);
            y10.d();
            navInterceptor = y10;
        }
    }

    public static final void p2() {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (chatActivityW0 == null || userDismissed || chatActivityW0.isFinishing() || chatActivityW0.isDestroyed()) {
            return;
        }
        if (chatActivityW0.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
            C4148a.d(TAG, "skip markOccluded: already resumed visible", false, 4, null);
            return;
        }
        if (lastRecentsState != RecentsWindowMonitor.RecentsState.IDLE) {
            return;
        }
        if (T1()) {
            desktopChatResidentController.w3();
            C4148a.d(TAG, "skip markOccluded: external UI cover", false, 4, null);
        } else if (desktopChatResidentController.G3(chatActivityW0)) {
            C4148a.d(TAG, "skip markOccluded: picker relay task is covering desktop", false, 4, null);
        } else if (desktopChatResidentController.R1(chatActivityW0) || desktopChatResidentController.d2(chatActivityW0)) {
            desktopChatResidentController.d0(chatActivityW0, "delayed-after-pause");
        }
    }

    public static final void p3() {
        INSTANCE.y1("morph-timeout");
    }

    public static final boolean q1() {
        INSTANCE.S2();
        Iterator it = new ArrayList(standaloneRefs).iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        boolean z10 = false;
        while (it.hasNext()) {
            ChatActivity chatActivity = (ChatActivity) ((WeakReference) it.next()).get();
            if (chatActivity != null && !chatActivity.isFinishing() && !chatActivity.isDestroyed()) {
                ChatScene chatSceneA = ChatScene.INSTANCE.a(chatActivity.getIntent());
                if (chatSceneA.isStandaloneTask() && !INSTANCE.a2(chatActivity)) {
                    C4148a.k(TAG, "finishBuriedStandaloneBoard → finishAndRemoveTask taskId=" + chatActivity.getTaskId() + " scene=" + chatSceneA, false, 4, null);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        chatActivity.finishAndRemoveTask();
                        Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.b(C4849c.a(th));
                    }
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public static final boolean r0() {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (chatActivityW0 == null || chatActivityW0.isFinishing() || chatActivityW0.isDestroyed() || userDismissed) {
            C4148a.d(TAG, "beginPermissionCover skip (no desktop)", false, 4, null);
            return false;
        }
        if (hiddenForRecents || desktopOccludedByOtherTask) {
            C4148a.d(TAG, "beginPermissionCover skip (already occluded/recents)", false, 4, null);
            return false;
        }
        int iIncrementAndGet = externalUiCover.incrementAndGet();
        C4148a.k(TAG, "beginPermissionCover n=" + iIncrementAndGet + " keep desktop panel visible", false, 4, null);
        if (iIncrementAndGet == 1) {
            desktopChatResidentController.w3();
        }
        desktopChatResidentController.O3();
        return true;
    }

    public static final void s1() throws Resources.NotFoundException {
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (chatActivityW0 == null || userDismissed) {
            return;
        }
        C4148a.k(TAG, "finishDesktopResidentForLockScreen → dismiss desktop taskId=" + chatActivityW0.getTaskId(), false, 4, null);
        desktopChatResidentController.a1(chatActivityW0);
    }

    public static final boolean t0() {
        if (!userDismissed && INSTANCE.W0() != null) {
            return true;
        }
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        if (desktopChatResidentController.L1() != null) {
            return true;
        }
        desktopChatResidentController.S2();
        return desktopChatResidentController.O2() != null;
    }

    public static final void t2(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        X2(reason);
    }

    public static final void u2() throws Resources.NotFoundException {
        View decorView;
        final long j10 = activeRecentsTransitionId;
        final int i10 = workspaceRestoreGeneration + 1;
        workspaceRestoreGeneration = i10;
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        k3(desktopChatResidentController, "EXIT_RECENTS", false, 2, null);
        desktopChatResidentController.h3("EXIT_RECENTS", PanelLayerRecentsPhase.OVERVIEW);
        com.stepos.ailauncher.homegesture.J.INSTANCE.g();
        minusOneYieldAtPeek = false;
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.endPeek();
        }
        final boolean z10 = desktopWasForegroundAtPeek;
        closedStandaloneThisGesture = false;
        if (pendingShowAfterBringFront) {
            C4148a.d(TAG, "onBackToWorkspace → KEEP_EXISTING in flight, skip restore", false, 4, null);
            return;
        }
        ChatActivity chatActivityW0 = desktopChatResidentController.W0();
        if (userDismissed || chatActivityW0 == null) {
            desktopChatResidentController.t3();
            hiddenForRecents = false;
            desktopWasForegroundAtPeek = false;
            desktopUnderThirdPartyAtPeek = false;
            desktopOccludedByOtherTask = false;
            if (chatActivityW0 == null) {
                C4148a.d(TAG, "onBackToWorkspace: no live activity", false, 4, null);
                return;
            }
            return;
        }
        if (!desktopChatResidentController.d2(chatActivityW0) && z10) {
            desktopChatResidentController.g3(chatActivityW0, j10, z10);
            return;
        }
        h1(chatActivityW0);
        Window window = chatActivityW0.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.s
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                DesktopChatResidentController.v2(i10, z10, j10);
            }
        }, BRING_FRONT_STABLE_MS);
    }

    public static final void v2(int i10, boolean z10, long j10) throws Resources.NotFoundException {
        if (i10 == workspaceRestoreGeneration && lastRecentsState == RecentsWindowMonitor.RecentsState.IDLE) {
            DesktopChatResidentController desktopChatResidentController = INSTANCE;
            ChatActivity chatActivityW0 = desktopChatResidentController.W0();
            if (chatActivityW0 == null || userDismissed) {
                desktopChatResidentController.t3();
                hiddenForRecents = false;
                desktopWasForegroundAtPeek = false;
                desktopUnderThirdPartyAtPeek = false;
                return;
            }
            if (!desktopChatResidentController.d2(chatActivityW0)) {
                desktopChatResidentController.g3(chatActivityW0, j10, z10);
                return;
            }
            desktopChatResidentController.d3(chatActivityW0, "EXIT_RECENTS");
            desktopWasForegroundAtPeek = false;
            desktopUnderThirdPartyAtPeek = false;
            C4148a.k(TAG, "onBackToWorkspace → landed on 3rd-party wasFgAtPeek=" + z10, false, 4, null);
        }
    }

    public static final void w2(ChatActivity activity) {
        View decorView;
        kotlin.jvm.internal.p.i(activity, "activity");
        WeakReference<ChatActivity> weakReference = desktopRef;
        if ((weakReference != null ? weakReference.get() : null) != activity || activity.isFinishing() || userDismissed) {
            return;
        }
        DesktopChatResidentController desktopChatResidentController = INSTANCE;
        desktopChatResidentController.u0(activity);
        desktopChatResidentController.w0(activity);
        if (hiddenForRecents && !pendingShowAfterBringFront) {
            h1(activity);
            return;
        }
        RecentsWindowMonitor.RecentsState recentsStateH = RecentsWindowMonitor.INSTANCE.h();
        RecentsWindowMonitor.RecentsState recentsState = RecentsWindowMonitor.RecentsState.IDLE;
        if (recentsStateH != recentsState || lastRecentsState != recentsState) {
            C4148a.d(TAG, "desktop pause during recents=" + recentsStateH + " → skip occluded", false, 4, null);
            if (hiddenForRecents) {
                h1(activity);
                return;
            }
            return;
        }
        if (T1()) {
            desktopChatResidentController.w3();
            C4148a.d(TAG, "desktop pause under external UI cover → skip occluded", false, 4, null);
            return;
        }
        if (desktopChatResidentController.G3(activity)) {
            C4148a.d(TAG, "desktop pause under picker relay task → keep panel visible", false, 4, null);
            return;
        }
        if (desktopChatResidentController.R1(activity)) {
            desktopChatResidentController.d0(activity, "pause-top-other-task");
            return;
        }
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.postDelayed(markOccludedRunnable, 120L);
        C4148a.d(TAG, "desktop pause → schedule markOccluded 120ms (top not yet other-task)", false, 4, null);
    }

    public static final void x2(ChatActivity activity) {
        View decorView;
        kotlin.jvm.internal.p.i(activity, "activity");
        WeakReference<ChatActivity> weakReference = desktopRef;
        if ((weakReference != null ? weakReference.get() : null) == activity && !userDismissed) {
            DesktopChatResidentController desktopChatResidentController = INSTANCE;
            desktopChatResidentController.w0(activity);
            if (hiddenForRecents || activity.getPanelHiddenForRecents()) {
                h1(activity);
            }
            desktopChatResidentController.u0(activity);
            Window window = activity.getWindow();
            if (window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            decorView.postDelayed(clearOccludedRunnable, 300L);
        }
    }

    public static final void y3(int i10, int i11, ChatActivity chatActivity, int i12) throws Resources.NotFoundException {
        if (i10 == bringFrontGeneration && pendingShowAfterBringFront && !userDismissed) {
            DesktopChatResidentController desktopChatResidentController = INSTANCE;
            ChatActivity chatActivityJ2 = desktopChatResidentController.J2();
            if (chatActivityJ2 == null || chatActivityJ2.isDestroyed()) {
                C4148a.u(TAG, "KEEP_EXISTING: no live panel → fallback openDesktop attempt=" + i11, false, 4, null);
                Context applicationContext = chatActivity.getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                desktopChatResidentController.m1(applicationContext, i12, i10, "existing-gone");
                return;
            }
            if (ChatScene.INSTANCE.a(chatActivityJ2.getIntent()) != ChatScene.DESKTOP) {
                C4148a.u(TAG, "KEEP_EXISTING: not DESKTOP scene, skip", false, 4, null);
                return;
            }
            if (chatActivityJ2.isFinishing()) {
                if (i11 >= 3) {
                    C4148a.u(TAG, "KEEP_EXISTING: still finishing → fallback recreate", false, 4, null);
                    Context applicationContext2 = chatActivityJ2.getApplicationContext();
                    kotlin.jvm.internal.p.h(applicationContext2, "getApplicationContext(...)");
                    desktopChatResidentController.m1(applicationContext2, i12, i10, "still-finishing");
                    return;
                }
                C4148a.u(TAG, "KEEP_EXISTING: panel finishing, soft retry attempt=" + i11 + " (avoid HOME/RESET kill)", false, 4, null);
                e0 e0Var = e0.INSTANCE;
                Context applicationContext3 = chatActivityJ2.getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext3, "getApplicationContext(...)");
                e0Var.b(applicationContext3, i12, false, true);
                desktopChatResidentController.x3(chatActivityJ2, i12, i10, i11 + 1);
                return;
            }
            if (!desktopChatResidentController.R1(chatActivityJ2) && !desktopChatResidentController.d2(chatActivityJ2) && desktopChatResidentController.X1(chatActivityJ2)) {
                desktopChatResidentController.p1(chatActivityJ2);
                openDesktopForceRetries = 0;
                C4148a.k(TAG, "KEEP_EXISTING → show panel1 on desktop attempt=" + i11, false, 4, null);
                return;
            }
            if (i11 >= 3) {
                if (desktopChatResidentController.d2(chatActivityJ2)) {
                    C4148a.h(TAG, "KEEP_EXISTING: still under 3rd after retries, give up show", false, 4, null);
                    h1(chatActivityJ2);
                    return;
                } else {
                    desktopChatResidentController.p1(chatActivityJ2);
                    openDesktopForceRetries = 0;
                    C4148a.u(TAG, "KEEP_EXISTING: force show after retries (top not 3rd)", false, 4, null);
                    return;
                }
            }
            C4148a.u(TAG, "KEEP_EXISTING: still covered → soft force front attempt=" + i11, false, 4, null);
            e0 e0Var2 = e0.INSTANCE;
            Context applicationContext4 = chatActivityJ2.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext4, "getApplicationContext(...)");
            e0Var2.b(applicationContext4, i12, false, true);
            desktopChatResidentController.x3(chatActivityJ2, i12, i10, i11 + 1);
        }
    }

    public static final boolean z2(ChatActivity chatActivity, WeakReference it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.get() == chatActivity || it.get() == null;
    }

    public final void A0(ChatActivity activity) {
        if (O2() == null) {
            underlyingThirdPartyTaskIdAtPeek = -1;
        } else {
            if (activity == null && (activity = W0()) == null && (activity = R2()) == null) {
                return;
            }
            underlyingThirdPartyTaskIdAtPeek = n1(activity);
        }
    }

    public final boolean A1() {
        return hiddenForRecents;
    }

    public final void B0(String reason) {
        if (holdPanel1HiddenAfterBoardHome) {
            holdPanel1HiddenAfterBoardHome = false;
            C4148a.d(TAG, "clear holdPanel1HiddenAfterBoardHome (" + reason + ")", false, 4, null);
        }
    }

    public final boolean B1() {
        return userDismissed;
    }

    public final void B3(ChatActivity activity, final int launcherId) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        final long j10 = openDesktopSettleUntilElapsed;
        decorView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.J
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                DesktopChatResidentController.C3(j10, launcherId);
            }
        }, 1200L);
    }

    public final void C0(String reason) {
        if (suppressNavWakeUntilElapsed.getAndSet(0L) > SystemClock.elapsedRealtime()) {
            C4148a.d(TAG, "clear NAVIGATION_WAKE suppress (" + reason + ")", false, 4, null);
        }
    }

    public final boolean C1(ChatActivity activity) {
        Object objB;
        Object objB2;
        String packageName;
        ComponentName component;
        ActivityManager activityManager = (ActivityManager) activity.getSystemService(ActivityManager.class);
        if (activityManager == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(activityManager.getAppTasks());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        List<ActivityManager.AppTask> listM = (List) objB;
        if (listM == null) {
            listM = C1173v.m();
        }
        for (ActivityManager.AppTask appTask : listM) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(appTask.getTaskInfo());
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (Result.g(objB2)) {
                objB2 = null;
            }
            ActivityManager.RecentTaskInfo recentTaskInfo = (ActivityManager.RecentTaskInfo) objB2;
            if (recentTaskInfo != null && recentTaskInfo.id != activity.getTaskId()) {
                T t10 = T.INSTANCE;
                ComponentName componentName = recentTaskInfo.topActivity;
                if (componentName == null || (packageName = componentName.getPackageName()) == null) {
                    ComponentName componentName2 = recentTaskInfo.baseActivity;
                    packageName = componentName2 != null ? componentName2.getPackageName() : null;
                }
                ComponentName componentName3 = recentTaskInfo.baseActivity;
                String className = componentName3 != null ? componentName3.getClassName() : null;
                Intent intent = recentTaskInfo.baseIntent;
                String className2 = (intent == null || (component = intent.getComponent()) == null) ? null : component.getClassName();
                ComponentName componentName4 = recentTaskInfo.topActivity;
                if (t10.c(packageName, className, className2, componentName4 != null ? componentName4.getClassName() : null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void C2() throws Resources.NotFoundException {
        y0("cancel");
        boolean zG = RecentsWindowMonitor.INSTANCE.g();
        if (C2732c.h(boardHomeExitRunning)) {
            t3();
            j3(zG ? "EXPLICIT_WAKE" : "CANCEL_GESTURE", zG);
            o3();
        } else {
            C4148a.d(TAG, zG ? "EXPLICIT_WAKE → skip peek-restore (board home exit)" : "CANCEL_GESTURE → skip peek-restore (board home exit)", false, 4, null);
        }
        com.stepos.ailauncher.homegesture.J.INSTANCE.g();
        minusOneYieldAtPeek = false;
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.endPeek();
        }
        closedStandaloneThisGesture = false;
        if (pendingShowAfterBringFront) {
            ChatActivity chatActivityW0 = W0();
            if (chatActivityW0 != null) {
                h1(chatActivityW0);
                Integer numValueOf = Integer.valueOf(chatActivityW0.getTaskId());
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                int iIntValue = numValueOf != null ? numValueOf.intValue() : C2740k.INSTANCE.a();
                if (iIntValue > 0) {
                    e0 e0Var = e0.INSTANCE;
                    Context applicationContext = chatActivityW0.getApplicationContext();
                    kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                    e0Var.b(applicationContext, iIntValue, false, true);
                }
            }
            C4148a.d(TAG, "CANCEL_GESTURE → wait openDesktop attach + force front", false, 4, null);
            return;
        }
        S2();
        boolean z10 = O2() != null;
        boolean z11 = pendingRestoreThirdPartyTaskId > 0;
        if (C2732c.f(userDismissed, z10, z11)) {
            l2("CANCEL_GESTURE");
            return;
        }
        if (userDismissed && (z10 || z11)) {
            dismissKickLauncherTaskId = -1;
            dismissKickAppContext = null;
            C4148a.d(TAG, "CANCEL_GESTURE → skip kick launcher board=" + z10 + " restore3rd=" + z11, false, 4, null);
            return;
        }
        ChatActivity chatActivityW02 = W0();
        if (chatActivityW02 == null) {
            hiddenForRecents = false;
            return;
        }
        if (chatActivityW02.y7()) {
            C4148a.d(TAG, "CANCEL_GESTURE → keep quick-switch window hidden", false, 4, null);
            return;
        }
        if (desktopUnderThirdPartyAtPeek || desktopOccludedByOtherTask || R1(chatActivityW02) || d2(chatActivityW02)) {
            d3(chatActivityW02, "CANCEL_GESTURE");
            return;
        }
        if (!T1()) {
            D3("peek-cancel");
        }
        if (hiddenForRecents) {
            I3(chatActivityW02, true);
            s3(chatActivityW02, activeRecentsTransitionId, PanelLayerRecentsPhase.PEEK);
            o0(chatActivityW02);
            C4148a.d(TAG, "CANCEL_GESTURE → fade-restore desktop panel1 (was foreground peek)", false, 4, null);
        }
    }

    public final boolean D1() {
        return !b0.d(m0.INSTANCE.h(), n2()) && m2() > 0;
    }

    public final void D3(String reason) {
        if (coverPeekGlassSuspended) {
            Handler handler = mainHandler;
            Runnable runnable = restoreCoverPeekGlassRunnable;
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 450L);
            C4148a.k(TAG, "schedule restore cover peek glass in 450ms (" + reason + ")", false, 4, null);
        }
    }

    public final void E0() throws Resources.NotFoundException {
        h3("clear-peek-flags", PanelLayerRecentsPhase.PEEK);
        desktopWasForegroundAtPeek = false;
        desktopUnderThirdPartyAtPeek = false;
        standaloneHiddenForPeek = false;
        homeFollowingHiddenForPeek = false;
        closedStandaloneThisGesture = false;
        underlyingThirdPartyTaskIdAtPeek = -1;
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.endPeek();
        }
    }

    public final void E1(ChatActivity activity, boolean animate, InterfaceC5063a<Boolean> stillHidden) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        activity.Q9(true);
        h1(activity);
        H(activity);
        j0(activity, animate, stillHidden);
    }

    public final void E3(String reason, int taskId) {
        Window window;
        View decorView;
        underlyingThirdPartyTaskIdAtPeek = -1;
        m0 m0Var = m0.INSTANCE;
        if (!C2732c.i(taskId, m0Var.h(), overlayOpenAtPeek, n2())) {
            pendingRestoreThirdPartyTaskId = -1;
            if (taskId > 0) {
                C4148a.k(TAG, reason + " → skip restore 3rd taskId=" + taskId + " overlayOpen=" + m0Var.h() + " overlayOpenAtPeek=" + overlayOpenAtPeek, false, 4, null);
                return;
            }
            return;
        }
        pendingRestoreThirdPartyTaskId = taskId;
        ChatActivity chatActivityR2 = R2();
        if (chatActivityR2 == null && (chatActivityR2 = W0()) == null) {
            chatActivityR2 = L1();
        }
        if (chatActivityR2 != null && (window = chatActivityR2.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            Runnable runnable = restoreThirdPartyAfterMorphRunnable;
            decorView.removeCallbacks(runnable);
            decorView.postDelayed(runnable, RESTORE_3RD_AFTER_MORPH_MS);
        }
        C4148a.d(TAG, reason + " → defer restore 3rd taskId=" + taskId + " until morph/detach", false, 4, null);
    }

    public final void F0(String reason) {
        if (RecentsWindowMonitor.INSTANCE.f(reason)) {
            lastRecentsState = RecentsWindowMonitor.RecentsState.IDLE;
            minusOneYieldAtPeek = false;
            C4148a.k(TAG, "panel resumed → clear stuck Recents PEEK reason=" + reason, false, 4, null);
        }
    }

    public final void F1(ChatActivity activity, boolean animate) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        hiddenForRecents = true;
        activity.Q9(true);
        h1(activity);
        H(activity);
        j0(activity, animate, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.sheet.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(DesktopChatResidentController.G1());
            }
        });
        X2("hide-for-recents");
    }

    public final void F3() {
        Handler handler = mainHandler;
        Runnable runnable = yieldLandingRecheckRunnable;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 500L);
        C4148a.k(TAG, "schedule yield-landing-recheck 500ms", false, 4, null);
    }

    public final void G0(boolean animate, String reason) {
        recentsCommitPending = false;
        if (recentsPeekVisualCommitted) {
            C4148a.d(TAG, "commitRecentsPeekVisual skip already-done reason=" + reason, false, 4, null);
            return;
        }
        recentsPeekVisualCommitted = true;
        long jElapsedRealtime = peekStartedElapsed > 0 ? SystemClock.elapsedRealtime() - peekStartedElapsed : 0L;
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.dismissPopupsForRecents();
        }
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.suspendPartition(HomeRootToken.DESKTOP);
        }
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.suspendPartition(HomeRootToken.BOARD);
        }
        com.stepos.ailauncher.homegesture.J j10 = com.stepos.ailauncher.homegesture.J.INSTANCE;
        if (!j10.q(j10.r(), kotlin.jvm.internal.p.d(reason, M5.a.CARD_TYPE_OVERVIEW), minusOneYieldAtPeek)) {
            C4148a.k(TAG, "commitRecentsPeekVisual skip MINUS_ONE suspend (yield HOME)", false, 4, null);
        } else if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.suspendPartition(HomeRootToken.MINUS_ONE);
        }
        J1("RECENTS_COMMIT");
        H1();
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 == null || userDismissed) {
            C4148a.k(TAG, "commitRecentsPeekVisual reason=" + reason + " after=" + jElapsedRealtime + "ms animate=" + animate + " no-desktop", false, 4, null);
            X2("peek-standalone-only");
            return;
        }
        g0(chatActivityW0, animate);
        C4148a.k(TAG, "commitRecentsPeekVisual reason=" + reason + " after=" + jElapsedRealtime + "ms animate=" + animate + " under3rdAtPeek=" + desktopUnderThirdPartyAtPeek + " wasFg=" + desktopWasForegroundAtPeek, false, 4, null);
        X2("peek-hide-desktop");
    }

    public final void G2() {
        J1("RECENTS_SUSPEND");
        boolean z10 = homeFollowingHiddenForPeek;
        j2("RECENTS_SUSPEND");
        if (z10) {
            C4148a.d(TAG, "onRecentsSuspendEarly skip panel3 already hidden", false, 4, null);
        } else if (homeFollowingHiddenForPeek) {
            C4148a.k(TAG, "panel3 hidden on recents suspend (early)", false, 4, null);
        }
    }

    public final boolean G3(ChatActivity activity) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        int i10;
        ComponentName component;
        RecentsWindowMonitor.RecentsState recentsStateH = RecentsWindowMonitor.INSTANCE.h();
        RecentsWindowMonitor.RecentsState recentsState = RecentsWindowMonitor.RecentsState.IDLE;
        if (recentsStateH == recentsState && lastRecentsState == recentsState) {
            try {
                ActivityManager activityManager = (ActivityManager) activity.getSystemService(ActivityManager.class);
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) != null && (i10 = runningTaskInfo.taskId) > 0 && i10 != activity.getTaskId()) {
                    a0 a0Var = a0.INSTANCE;
                    ComponentName componentName = runningTaskInfo.baseActivity;
                    String className = null;
                    String className2 = componentName != null ? componentName.getClassName() : null;
                    Intent intent = runningTaskInfo.baseIntent;
                    if (intent != null && (component = intent.getComponent()) != null) {
                        className = component.getClassName();
                    }
                    return a0Var.a(className2, className);
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final void H(ChatActivity activity) {
        if (com.stepos.ailauncher.sheet.V.b(Q1(activity))) {
            Window window = activity.getWindow();
            if (window != null) {
                window.addFlags(8);
                return;
            }
            return;
        }
        C4148a.d(TAG, "skip NOT_FOCUSABLE (still resumed) taskId=" + activity.getTaskId(), false, 4, null);
    }

    public final boolean H0(int action) throws Resources.NotFoundException {
        S2();
        ChatActivity chatActivityO2 = O2();
        if (chatActivityO2 != null) {
            C4148a.k(TAG, "consumeBoardRoot action=" + action + " scene=" + ChatScene.INSTANCE.a(chatActivityO2.getIntent()) + " taskId=" + chatActivityO2.getTaskId(), false, 4, null);
            x1(chatActivityO2);
            return true;
        }
        ChatActivity chatActivityR2 = R2();
        if (chatActivityR2 != null && !C2732c.a(ChatScene.INSTANCE.a(chatActivityR2.getIntent()))) {
            C4148a.k(TAG, "consumeBoardRoot → skip non-board taskId=" + chatActivityR2.getTaskId(), false, 4, null);
            return false;
        }
        if (!closedStandaloneThisGesture) {
            return false;
        }
        closedStandaloneThisGesture = false;
        standaloneHiddenForPeek = false;
        pendingShowAfterBringFront = false;
        h2("consume-standalone-already-closed");
        E3("consume-standalone-already-closed", underlyingThirdPartyTaskIdAtPeek);
        E0();
        C4148a.k(TAG, "consumeBoardRoot → standalone already closed", false, 4, null);
        X2("consume-standalone-already-closed");
        return true;
    }

    public final void H1() {
        ChatActivity chatActivityL1 = L1();
        if (chatActivityL1 == null) {
            return;
        }
        if (!Y1()) {
            C4148a.d(TAG, "SHOW_GESTURE → skip panel3 hide (not on minus-one) taskId=" + chatActivityL1.getTaskId() + " " + I2(chatActivityL1), false, 4, null);
            return;
        }
        overlayOpenAtPeek = true;
        panel3ExpandedAtPeek = chatActivityL1.R7();
        try {
            Result.Companion companion = Result.INSTANCE;
            chatActivityL1.setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        N3(chatActivityL1, PanelLayerRecentsPhase.PEEK);
        chatActivityL1.Q9(true);
        h1(chatActivityL1);
        H(chatActivityL1);
        C4148a.k(TAG, "SHOW_GESTURE → panel3 follow minus-one (defer hide until overview) expanded=" + panel3ExpandedAtPeek + " taskId=" + chatActivityL1.getTaskId() + " " + I2(chatActivityL1), false, 4, null);
    }

    public final boolean I0(int action) throws Resources.NotFoundException {
        Object objB;
        if (action == 2) {
            ChatActivity chatActivityW0 = W0();
            if (chatActivityW0 == null || userDismissed) {
                if (D1()) {
                    return J0();
                }
                return false;
            }
            if (T1()) {
                C4148a.k(TAG, "consumeDesktopRoot OPEN_DESKTOP → dismiss external UI instead", false, 4, null);
                Z0(HomeDismissReason.HOME);
                E0();
                X2("consume-opendesktop-as-cover");
                return true;
            }
            if (!desktopOccludedByOtherTask && !pendingShowAfterBringFront && !R1(chatActivityW0) && !d2(chatActivityW0)) {
                C4148a.k(TAG, "consumeDesktopRoot OPEN_DESKTOP skipped, already on desktop", false, 4, null);
                E0();
                openDesktopSettleUntilElapsed = 0L;
                X2("opendesktop-already-front");
                return true;
            }
            C4148a.k(TAG, "consumeDesktopRoot → OPEN_DESKTOP taskId=" + chatActivityW0.getTaskId(), false, 4, null);
            openDesktopForceRetries = 0;
            u0(chatActivityW0);
            holdPanel1HiddenAfterBoardHome = false;
            L3(chatActivityW0, "consume-panel1-under3rd");
            E0();
            X2("consume-opendesktop-panel1");
            return true;
        }
        ChatActivity chatActivityW02 = W0();
        if (chatActivityW02 == null || userDismissed) {
            return false;
        }
        if (!chatActivityW02.O7()) {
            C4148a.d(TAG, "consumeDesktopRoot → already collapsed", false, 4, null);
            return true;
        }
        C4148a.k(TAG, "consumeDesktopRoot → dismiss taskId=" + chatActivityW02.getTaskId(), false, 4, null);
        desktopOccludedByOtherTask = false;
        x0("dismiss-desktop");
        u0(chatActivityW02);
        o2();
        if (g2(chatActivityW02)) {
            r3(chatActivityW02);
            E0();
            a1(chatActivityW02);
        } else {
            n3(this, chatActivityW02, false, false, 2, null);
            E0();
            try {
                Result.Companion companion = Result.INSTANCE;
                chatActivityW02.g1();
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "dismissSheet desktop failed: " + thE.getMessage(), false, 4, null);
                INSTANCE.a1(chatActivityW02);
            }
            Result.a(objB);
        }
        X2("consume-dismiss-desktop");
        return true;
    }

    public final void I1(ChatActivity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        View viewFindFocus = decorView.findFocus();
        if (viewFindFocus != null) {
            viewFindFocus.clearFocus();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(InputMethodManager.class);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(decorView.getWindowToken(), 0);
    }

    public final String I2(ChatActivity panel3) {
        return "isOpen=" + m0.INSTANCE.h() + " resumed=" + a2(panel3) + " topTask=" + W1(panel3) + " collapsed=" + (!panel3.R7());
    }

    public final void I3(final ChatActivity activity, boolean animate) throws Resources.NotFoundException {
        View decorView;
        Object objB;
        if (activity.y7() || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        t3();
        q3(activity);
        Window window = activity.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes.alpha < 1.0f) {
                attributes.alpha = 1.0f;
                window.setAttributes(attributes);
            }
            View decorView2 = window.getDecorView();
            kotlin.jvm.internal.p.h(decorView2, "getDecorView(...)");
            decorView2.animate().cancel();
            boolean z10 = decorView2.getVisibility() == 0 && decorView2.getAlpha() >= 0.99f;
            decorView2.setVisibility(0);
            if (!animate || z10) {
                decorView2.setAlpha(1.0f);
            } else {
                if (decorView2.getAlpha() >= 0.99f) {
                    decorView2.setAlpha(0.0f);
                }
                decorView2.animate().alpha(1.0f).setDuration(180L).start();
            }
        }
        hiddenForRecents = false;
        activity.Q9(false);
        if (lastRecentsState == RecentsWindowMonitor.RecentsState.IDLE && (objB = com.stepos.ailauncher.chat.panelui.v.INSTANCE.b(activity)) != null) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.g(objB);
        }
        desktopOccludedByOtherTask = false;
        B0("show-visually");
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        activity.f9();
        Window window2 = activity.getWindow();
        if (window2 != null && (decorView = window2.getDecorView()) != null) {
            decorView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.E
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    DesktopChatResidentController.K3(activity);
                }
            });
        }
        X2("show-visually");
    }

    public final boolean J0() throws Resources.NotFoundException {
        t3();
        recentsPeekVisualCommitted = false;
        hiddenForRecents = false;
        holdPanel1HiddenAfterBoardHome = false;
        pendingShowAfterBringFront = true;
        E0();
        int iC3 = c3();
        leftoverSheetFrontGeneration++;
        int i10 = leftoverSheetFrontGeneration;
        s0(iC3, "consume");
        z3(iC3, i10, 0);
        C4148a.k(TAG, "consumeDesktopRoot → OPEN_DESKTOP leftover sheets (no panel1) launcherId=" + iC3, false, 4, null);
        X2("consume-opendesktop-leftover-sheets");
        return true;
    }

    public final boolean J1(String reason) {
        if (b2()) {
            C4148a.k(TAG, reason + " → skip hide standalone (open grace)", false, 4, null);
            return false;
        }
        S2();
        Iterator<WeakReference<ChatActivity>> it = standaloneRefs.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            ChatActivity chatActivity = it.next().get();
            if (chatActivity != null && !chatActivity.isFinishing() && !chatActivity.isDestroyed()) {
                N3(chatActivity, PanelLayerRecentsPhase.PEEK);
                l1(chatActivity, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.sheet.t
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return Boolean.valueOf(DesktopChatResidentController.K1());
                    }
                });
                C4148a.k(TAG, reason + " → standalone hide (visual only) scene=" + ChatScene.INSTANCE.a(chatActivity.getIntent()) + " taskId=" + chatActivity.getTaskId(), false, 4, null);
                z10 = true;
            }
        }
        standaloneHiddenForPeek = z10;
        X2(reason + "-hide-standalone");
        return z10;
    }

    public final ChatActivity J2() {
        WeakReference<ChatActivity> weakReference = desktopRef;
        ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
        if (chatActivity == null) {
            return null;
        }
        if (!chatActivity.isDestroyed()) {
            return chatActivity;
        }
        desktopRef = null;
        return null;
    }

    public final String K2(Context context) {
        ComponentName componentName;
        ActivityManager.RunningTaskInfo runningTaskInfoM2 = M2(context);
        if (runningTaskInfoM2 == null || (componentName = runningTaskInfoM2.topActivity) == null) {
            return null;
        }
        return componentName.getPackageName();
    }

    public final ChatActivity L1() {
        WeakReference<ChatActivity> weakReference = homeOverlayRef;
        ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
        if (chatActivity == null) {
            return null;
        }
        if (chatActivity.isDestroyed()) {
            homeOverlayRef = null;
            return null;
        }
        if (!chatActivity.isFinishing() && ChatScene.INSTANCE.a(chatActivity.getIntent()).isHomeFollowing()) {
            return chatActivity;
        }
        return null;
    }

    public final String L2(ChatActivity activity) {
        kotlin.jvm.internal.p.g(activity, "null cannot be cast to non-null type android.content.Context");
        return K2(activity);
    }

    public final void L3(ChatActivity activity, String reason) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        pendingShowAfterBringFront = true;
        bringFrontGeneration++;
        int i10 = bringFrontGeneration;
        if (!Z.INSTANCE.a()) {
            h1(activity);
        }
        Integer numValueOf = Integer.valueOf(activity.getTaskId());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : -1;
        Integer numValueOf2 = Integer.valueOf(C2740k.INSTANCE.a());
        if (numValueOf2.intValue() <= 0) {
            numValueOf2 = null;
        }
        int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : -1;
        Integer numValueOf3 = Integer.valueOf(iIntValue);
        if (numValueOf3.intValue() <= 0) {
            numValueOf3 = null;
        }
        int iIntValue3 = numValueOf3 != null ? numValueOf3.intValue() : iIntValue2;
        if (iIntValue3 <= 0) {
            C4148a.h(TAG, "startOpenDesktopImmediate: no launcherTaskId", false, 4, null);
            return;
        }
        C4148a.k(TAG, "startOpenDesktopImmediate KEEP_EXISTING reason=" + reason + " chatTask=" + iIntValue + " providerHome=" + iIntValue2 + " gen=" + i10, false, 4, null);
        openDesktopSettleUntilElapsed = SystemClock.uptimeMillis() + 1200;
        e0 e0Var = e0.INSTANCE;
        Context applicationContext = activity.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        e0Var.b(applicationContext, iIntValue3, false, true);
        x3(activity, iIntValue3, i10, 0);
    }

    public final void M1() {
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator == null) {
            return;
        }
        iHomeGestureCoordinator.registerRoot(HomeRootToken.DESKTOP, desktopRootStrategy);
        iHomeGestureCoordinator.registerRoot(HomeRootToken.BOARD, boardRootStrategy);
        iHomeGestureCoordinator.setOnConsumeStarted(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.sheet.K
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DesktopChatResidentController.N1();
            }
        });
        j1();
        C4148a.d(TAG, "installHomeRoots", false, 4, null);
    }

    public final ActivityManager.RunningTaskInfo M2(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null) {
                return (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final void M3(String reason) {
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 == null || chatActivityW0.isFinishing() || chatActivityW0.isDestroyed()) {
            return;
        }
        mainHandler.removeCallbacks(restoreCoverPeekGlassRunnable);
        coverPeekGlassSuspended = true;
        chatActivityW0.N9(true);
        C4148a.k(TAG, "suspend cover peek glass (" + reason + ")", false, 4, null);
    }

    public final ActivityManager.RunningTaskInfo N2(ChatActivity activity) {
        kotlin.jvm.internal.p.g(activity, "null cannot be cast to non-null type android.content.Context");
        return M2(activity);
    }

    public final void N3(ChatActivity activity, PanelLayerRecentsPhase phase) {
        Object objB = com.stepos.ailauncher.chat.panelui.v.INSTANCE.b(activity);
        if (objB == null) {
            return;
        }
        com.stepos.ailauncher.chat.panelui.i.INSTANCE.h(objB, activeRecentsTransitionId, phase);
    }

    public final boolean O1(ChatActivity chatActivity) {
        return C2732c.b(ChatScene.INSTANCE.a(chatActivity.getIntent()).isLockScreen(), chatActivity.isFinishing(), chatActivity.isDestroyed(), a2(chatActivity), chatActivity.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED), m0.INSTANCE.h());
    }

    public final ChatActivity O2() {
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<ChatActivity>> it = standaloneRefs.iterator();
        while (it.hasNext()) {
            ChatActivity chatActivity = it.next().get();
            if (chatActivity != null && O1(chatActivity)) {
                arrayList.add(chatActivity);
            }
        }
        Object obj = null;
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (INSTANCE.a2((ChatActivity) next)) {
                obj = next;
                break;
            }
        }
        ChatActivity chatActivity2 = (ChatActivity) obj;
        return chatActivity2 != null ? chatActivity2 : (ChatActivity) Z8.F.C0(arrayList);
    }

    public final void O3() {
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        boolean z10 = externalUiCover.get() > 0;
        if (iHomeGestureCoordinator == null) {
            homeLayerRegistered.set(false);
            return;
        }
        if (z10) {
            if (homeLayerRegistered.compareAndSet(false, true)) {
                iHomeGestureCoordinator.registerPopup(externalUiHomeLayer);
                C4148a.k(TAG, "register HOME popup external-ui-cover", false, 4, null);
                return;
            }
            return;
        }
        if (homeLayerRegistered.compareAndSet(true, false)) {
            iHomeGestureCoordinator.unregisterPopup(V.LAYER_ID);
            C4148a.k(TAG, "unregister HOME popup external-ui-cover", false, 4, null);
        }
    }

    public final ChatActivity P2() {
        int taskId;
        ChatActivity chatActivityO2 = O2();
        Object obj = null;
        if (chatActivityO2 == null || (taskId = chatActivityO2.getTaskId()) <= 0) {
            return null;
        }
        Iterator it = SequencesKt___SequencesKt.S(Z8.F.d0(standaloneRefs), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.sheet.L
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return DesktopChatResidentController.Q2((WeakReference) obj2);
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ChatActivity chatActivity = (ChatActivity) next;
            if (chatActivity.getTaskId() == taskId && !chatActivity.isFinishing() && !chatActivity.isDestroyed() && SheetLaunchOptions.INSTANCE.b(chatActivity.getIntent())) {
                obj = next;
                break;
            }
        }
        return (ChatActivity) obj;
    }

    public final boolean Q1(ChatActivity activity) {
        return activity.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public final boolean R1(ChatActivity activity) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName component;
        try {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService(ActivityManager.class);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) != null) {
                ComponentName componentName = runningTaskInfo.topActivity;
                String className = componentName != null ? componentName.getClassName() : null;
                if (className == null) {
                    className = "";
                }
                if (!La.D.K(className, "BringLauncherTaskFrontActivity", false, 2, null) && !La.D.K(className, "ChatDesktopDebugActivity", false, 2, null)) {
                    T t10 = T.INSTANCE;
                    ComponentName componentName2 = runningTaskInfo.topActivity;
                    String packageName = componentName2 != null ? componentName2.getPackageName() : null;
                    ComponentName componentName3 = runningTaskInfo.baseActivity;
                    String className2 = componentName3 != null ? componentName3.getClassName() : null;
                    Intent intent = runningTaskInfo.baseIntent;
                    String className3 = (intent == null || (component = intent.getComponent()) == null) ? null : component.getClassName();
                    ComponentName componentName4 = runningTaskInfo.topActivity;
                    if (t10.c(packageName, className2, className3, componentName4 != null ? componentName4.getClassName() : null)) {
                        return false;
                    }
                    ComponentName componentName5 = runningTaskInfo.topActivity;
                    if (kotlin.jvm.internal.p.d(componentName5 != null ? componentName5.getPackageName() : null, activity.getPackageName())) {
                        return false;
                    }
                    int i10 = runningTaskInfo.taskId;
                    if (i10 > 0 && i10 != activity.getTaskId()) {
                        return true;
                    }
                    ComponentName componentName6 = runningTaskInfo.topActivity;
                    String packageName2 = componentName6 != null ? componentName6.getPackageName() : null;
                    String packageName3 = activity.getPackageName();
                    kotlin.jvm.internal.p.h(packageName3, "getPackageName(...)");
                    return c2(packageName2, packageName3);
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final ChatActivity R2() {
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<ChatActivity>> it = standaloneRefs.iterator();
        while (it.hasNext()) {
            ChatActivity chatActivity = it.next().get();
            if (chatActivity != null && !chatActivity.isFinishing() && !chatActivity.isDestroyed()) {
                arrayList.add(chatActivity);
            }
        }
        Object obj = null;
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (INSTANCE.a2((ChatActivity) next)) {
                obj = next;
                break;
            }
        }
        ChatActivity chatActivity2 = (ChatActivity) obj;
        return chatActivity2 != null ? chatActivity2 : (ChatActivity) Z8.F.C0(arrayList);
    }

    public final void S2() {
        Z8.A.J(standaloneRefs, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.sheet.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(DesktopChatResidentController.T2((WeakReference) obj));
            }
        });
    }

    public final boolean U1(ChatActivity activity) {
        ComponentName component;
        ActivityManager.RunningTaskInfo runningTaskInfoN2 = N2(activity);
        if (runningTaskInfoN2 == null) {
            return C1(activity);
        }
        T t10 = T.INSTANCE;
        ComponentName componentName = runningTaskInfoN2.topActivity;
        String packageName = componentName != null ? componentName.getPackageName() : null;
        ComponentName componentName2 = runningTaskInfoN2.baseActivity;
        String className = componentName2 != null ? componentName2.getClassName() : null;
        Intent intent = runningTaskInfoN2.baseIntent;
        String className2 = (intent == null || (component = intent.getComponent()) == null) ? null : component.getClassName();
        ComponentName componentName3 = runningTaskInfoN2.topActivity;
        return t10.c(packageName, className, className2, componentName3 != null ? componentName3.getClassName() : null) || C1(activity);
    }

    public final boolean V1(ChatActivity activity) {
        return activity != null && a2(activity) && activity.e8();
    }

    public final ChatActivity W0() {
        ChatActivity chatActivityJ2 = J2();
        if (chatActivityJ2 == null || chatActivityJ2.isFinishing() || ChatScene.INSTANCE.a(chatActivityJ2.getIntent()) != ChatScene.DESKTOP) {
            return null;
        }
        return chatActivityJ2;
    }

    public final boolean W1(ChatActivity panel3) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) panel3.getSystemService(ActivityManager.class);
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) != null) {
                if (runningTaskInfo.taskId == panel3.getTaskId()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final void W2() {
        RecentsWindowMonitor recentsWindowMonitor = RecentsWindowMonitor.INSTANCE;
        RecentsWindowMonitor.RecentsState recentsStateH = recentsWindowMonitor.h();
        boolean zF2 = f2(this, null, 1, null);
        long jO = recentsWindowMonitor.o();
        com.stepos.ailauncher.homegesture.J j10 = com.stepos.ailauncher.homegesture.J.INSTANCE;
        boolean zF = j10.f();
        m0 m0Var = m0.INSTANCE;
        C4148a.k(TAG, "yield-landing-recheck recents=" + recentsStateH + " covering3rd=" + zF2 + " peekElapsed=" + jO + "ms latched=" + zF + " overlayOpen=" + m0Var.h() + " hostFg=" + m0Var.g() + " minusOneSheets=" + n2(), false, 4, null);
        if (recentsStateH == RecentsWindowMonitor.RecentsState.OVERVIEW) {
            C4148a.k(TAG, "yield-landing-recheck skip overview", false, 4, null);
            return;
        }
        if (zF2) {
            C4148a.k(TAG, "yield-landing-recheck still covering 3rd, keep yield", false, 4, null);
            return;
        }
        if (!j10.c(false) && recentsStateH != RecentsWindowMonitor.RecentsState.PEEK) {
            C4148a.k(TAG, "yield-landing-recheck skip not-stuck", false, 4, null);
            return;
        }
        F0("stale-yield-peek-landing");
        minusOneYieldAtPeek = false;
        X2("stale-yield-peek-landing");
    }

    public final void X0() {
        Y y10 = navInterceptor;
        if (y10 != null) {
            y10.f();
        }
        navInterceptor = null;
    }

    public final boolean X1(ChatActivity activity) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Integer numValueOf = Integer.valueOf(activity.getTaskId());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return a2(activity);
        }
        int iIntValue = numValueOf.intValue();
        try {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService(ActivityManager.class);
            return (activityManager == null || (runningTasks = activityManager.getRunningTasks(1)) == null || (runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks)) == null) ? a2(activity) : runningTaskInfo.taskId == iIntValue;
        } catch (Throwable th) {
            C4148a.u(TAG, "getRunningTasks failed: " + th.getMessage(), false, 4, null);
            return a2(activity);
        }
    }

    public final void Y0(String reason) {
        Set<WeakReference<ChatActivity>> set = standaloneRefs;
        if (!set.isEmpty() || standaloneHiddenForPeek) {
            S2();
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ChatActivity chatActivity = (ChatActivity) ((WeakReference) it.next()).get();
                if (chatActivity != null) {
                    com.stepos.ailauncher.chat.panelui.i.INSTANCE.b(com.stepos.ailauncher.chat.panelui.v.INSTANCE.a(chatActivity), PanelLayerDismissReason.OVERVIEW);
                }
            }
            o1(reason);
            closedStandaloneThisGesture = true;
            standaloneHiddenForPeek = false;
            X2("dismiss-all-standalone:" + reason);
        }
    }

    public final boolean Y1() {
        ChatActivity chatActivityL1 = L1();
        if (chatActivityL1 == null || chatActivityL1.isFinishing() || chatActivityL1.isDestroyed()) {
            return false;
        }
        return m0.INSTANCE.h() || a2(chatActivityL1) || W1(chatActivityL1);
    }

    public final boolean Z1(ChatActivity activity) {
        if (hiddenForRecents) {
            WeakReference<ChatActivity> weakReference = desktopRef;
            if ((weakReference != null ? weakReference.get() : null) == activity) {
                return true;
            }
        }
        if (homeFollowingHiddenForPeek && L1() == activity) {
            return true;
        }
        if (!standaloneHiddenForPeek) {
            return false;
        }
        S2();
        Set<WeakReference<ChatActivity>> set = standaloneRefs;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == activity) {
                return true;
            }
        }
        return false;
    }

    public final void Z2(int taskId) {
        if (taskId > 0) {
            lastKnownLauncherTaskId = taskId;
        }
    }

    public final void a1(ChatActivity activity) throws Resources.NotFoundException {
        View decorView;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Window window = activity.getWindow();
        com.stepos.ailauncher.foundation.appui.card.provider.appauther.u.a(window != null ? window.getDecorView() : null);
        ChatScene chatSceneA = ChatScene.INSTANCE.a(activity.getIntent());
        if (!chatSceneA.isStandaloneTask()) {
            t1(activity, true);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        h1(activity);
        Window window2 = activity.getWindow();
        if (window2 != null && (decorView = window2.getDecorView()) != null) {
            decorView.setAlpha(0.0f);
            decorView.setVisibility(4);
        }
        C4148a.k(TAG, "dismissForHome → finishAndRemoveTask scene=" + chatSceneA, false, 4, null);
        activity.finishAndRemoveTask();
    }

    public final boolean a2(ChatActivity activity) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return activity.getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public final boolean b2() {
        return SystemClock.elapsedRealtime() < standaloneOpenProtectUntilElapsed;
    }

    public final void b3(String reason) {
        AtomicInteger atomicInteger = externalUiCover;
        if (atomicInteger.get() == 0) {
            v0();
            O3();
            return;
        }
        atomicInteger.set(0);
        v0();
        O3();
        C4148a.u(TAG, "resetExternalUiCover reason=" + reason, false, 4, null);
    }

    public final Context c0() {
        Object objB;
        Context applicationContext;
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 != null && (applicationContext = chatActivityW0.getApplicationContext()) != null) {
            return applicationContext;
        }
        ChatActivity chatActivityR2 = R2();
        Context applicationContext2 = chatActivityR2 != null ? chatActivityR2.getApplicationContext() : null;
        if (applicationContext2 != null) {
            return applicationContext2;
        }
        ChatActivity chatActivityL1 = L1();
        Context applicationContext3 = chatActivityL1 != null ? chatActivityL1.getApplicationContext() : null;
        if (applicationContext3 != null) {
            return applicationContext3;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(C3197a.INSTANCE.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Context) (Result.g(objB) ? null : objB);
    }

    public final boolean c2(String topPkg, String selfPkg) {
        return (topPkg == null || topPkg.length() == 0 || kotlin.jvm.internal.p.d(topPkg, "com.android.launcher3") || kotlin.jvm.internal.p.d(topPkg, selfPkg) || kotlin.jvm.internal.p.d(topPkg, "com.android.systemui") || La.D.X(topPkg, "com.android.systemui", false, 2, null)) ? false : true;
    }

    public final int c3() {
        Context contextC0 = c0();
        int iB = b0.b(contextC0 != null ? C2740k.INSTANCE.d(contextC0) : -1, lastKnownLauncherTaskId);
        Z2(iB);
        return iB;
    }

    public final void d0(ChatActivity activity, String reason) {
        View decorView;
        View decorView2;
        if (activity.isFinishing() || activity.isDestroyed() || userDismissed) {
            return;
        }
        if (T1()) {
            C4148a.d(TAG, "applyDesktopOccluded skipped (external UI cover) reason=" + reason, false, 4, null);
            return;
        }
        if (G3(activity)) {
            C4148a.d(TAG, "applyDesktopOccluded skipped (picker relay task) reason=" + reason, false, 4, null);
            return;
        }
        if (SystemClock.uptimeMillis() < openDesktopSettleUntilElapsed) {
            Integer numValueOf = Integer.valueOf(activity.getTaskId());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : C2740k.INSTANCE.a();
            C4148a.u(TAG, "desktop re-covered during openDesktop settle reason=" + reason + " → force front id=" + iIntValue, false, 4, null);
            h1(activity);
            if (iIntValue > 0) {
                e0 e0Var = e0.INSTANCE;
                Context applicationContext = activity.getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                e0Var.b(applicationContext, iIntValue, false, true);
            }
            Window window = activity.getWindow();
            if (window == null || (decorView2 = window.getDecorView()) == null) {
                return;
            }
            decorView2.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.v
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    DesktopChatResidentController.e0();
                }
            }, 220L);
            return;
        }
        desktopOccludedByOtherTask = true;
        i2(activity);
        X0();
        C4148a.k(TAG, "desktop occluded → passthrough keep pixels reason=" + reason, false, 4, null);
        if (pendingShowAfterBringFront) {
            bringFrontGeneration++;
            final int i10 = bringFrontGeneration;
            C4148a.u(TAG, "desktop re-covered during bringFront → retry gen=" + i10, false, 4, null);
            Window window2 = activity.getWindow();
            if (window2 != null && (decorView = window2.getDecorView()) != null) {
                decorView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        DesktopChatResidentController.f0(i10);
                    }
                }, BRING_FRONT_START_DELAY_MS);
            }
        }
        X2("desktop-occluded:" + reason);
    }

    public final boolean d2(ChatActivity activity) {
        return e2(activity);
    }

    public final void d3(ChatActivity activity, String reason) {
        desktopOccludedByOtherTask = true;
        if (Z.INSTANCE.c(hiddenForRecents, true)) {
            u3(activity);
            C4148a.k(TAG, reason + " → panel1 reveal pixels keep occlude (under3rd)", false, 4, null);
        } else {
            i2(activity);
            C4148a.k(TAG, reason + " → panel1 keep passthrough (under3rd, no recents hide)", false, 4, null);
        }
        X0();
        X2("landed-under3rd:" + reason);
    }

    public final boolean e2(ChatActivity activity) {
        Context contextC0;
        if (activity != null) {
            contextC0 = activity;
        } else {
            try {
                contextC0 = c0();
                if (contextC0 == null) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        String strK2 = K2(contextC0);
        if (strK2 == null) {
            return false;
        }
        if (activity != null && T1() && T.INSTANCE.b(strK2)) {
            return false;
        }
        if (activity != null && G3(activity) && T.INSTANCE.b(strK2)) {
            return false;
        }
        String packageName = contextC0.getPackageName();
        kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
        return c2(strK2, packageName);
    }

    public final void e3(String reason) {
        mainHandler.removeCallbacks(restoreCoverPeekGlassRunnable);
        if (coverPeekGlassSuspended) {
            coverPeekGlassSuspended = false;
            ChatActivity chatActivityW0 = W0();
            if (chatActivityW0 != null && !chatActivityW0.isFinishing() && !chatActivityW0.isDestroyed()) {
                chatActivityW0.N9(false);
            }
            C4148a.k(TAG, "restore cover peek glass (" + reason + ")", false, 4, null);
        }
    }

    public final void g0(ChatActivity activity, boolean animate) {
        if (!Z.INSTANCE.b()) {
            i2(activity);
            X0();
        } else {
            N3(activity, lastRecentsState == RecentsWindowMonitor.RecentsState.OVERVIEW ? PanelLayerRecentsPhase.OVERVIEW : PanelLayerRecentsPhase.PEEK);
            F1(activity, animate);
            X0();
        }
    }

    public final boolean g2(ChatActivity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return false;
        }
        return decorView.getVisibility() != 0 || decorView.getAlpha() < 0.08f;
    }

    public final void g3(ChatActivity activity, long transitionId, boolean wasFgAtPeek) throws Resources.NotFoundException {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        I3(activity, true);
        s3(activity, transitionId, PanelLayerRecentsPhase.OVERVIEW);
        recentsPeekVisualCommitted = false;
        u0(activity);
        o0(activity);
        desktopWasForegroundAtPeek = false;
        desktopUnderThirdPartyAtPeek = false;
        Integer numValueOf = Integer.valueOf(activity.getTaskId());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : -1;
        if (iIntValue > 0) {
            e0 e0Var = e0.INSTANCE;
            Context applicationContext = activity.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            e0Var.b(applicationContext, iIntValue, false, true);
        }
        C4148a.k(TAG, "onBackToWorkspace → restore full stack wasFgAtPeek=" + wasFgAtPeek + " taskId=" + iIntValue, false, 4, null);
    }

    public final void h0(ChatActivity activity) throws Resources.NotFoundException {
        if (ChatScene.INSTANCE.a(activity.getIntent()).isHomeFollowing() && !activity.R7()) {
            activity.a7();
        }
    }

    public final void h2(String reason) {
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 == null || userDismissed) {
            return;
        }
        desktopOccludedByOtherTask = true;
        F1(chatActivityW0, false);
        X0();
        C4148a.k(TAG, reason + " → keep panel1 hidden under 3rd (no cascade)", false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h3(java.lang.String r8, com.stepos.ailauncher.chat.panelui.PanelLayerRecentsPhase r9) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            com.stepos.ailauncher.chat.activity.ChatActivity r1 = r7.L1()
            boolean r0 = com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.homeFollowingHiddenForPeek
            r6 = 0
            if (r1 == 0) goto L11
            boolean r2 = r1.getPanelHiddenForRecents()
            r3 = 1
            if (r2 != r3) goto L11
            goto L12
        L11:
            r3 = r6
        L12:
            com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.homeFollowingHiddenForPeek = r6
            if (r1 == 0) goto L6a
            boolean r2 = r1.isFinishing()
            if (r2 != 0) goto L6a
            boolean r2 = r1.isDestroyed()
            if (r2 != 0) goto L6a
            if (r0 != 0) goto L27
            if (r3 != 0) goto L27
            goto L6a
        L27:
            r4 = 4
            r5 = 0
            r2 = 1
            r3 = 0
            r0 = r7
            n3(r0, r1, r2, r3, r4, r5)
            long r2 = com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.activeRecentsTransitionId
            r0.s3(r1, r2, r9)
            boolean r7 = com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.overlayOpenAtPeek
            if (r7 != 0) goto L40
            com.stepos.ailauncher.container.m0 r7 = com.stepos.ailauncher.container.m0.INSTANCE
            boolean r7 = r7.h()
            if (r7 == 0) goto L43
        L40:
            r1.P9(r6)
        L43:
            r0.h0(r1)
            com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.overlayOpenAtPeek = r6
            com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.panel3ExpandedAtPeek = r6
            int r7 = r1.getTaskId()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            java.lang.String r8 = " → fade-restore panel3 taskId="
            r9.append(r8)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8 = 4
            r9 = 0
            java.lang.String r0 = "DesktopChatResident"
            h8.C4148a.d(r0, r7, r6, r8, r9)
            return
        L6a:
            com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.overlayOpenAtPeek = r6
            com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.panel3ExpandedAtPeek = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.sheet.DesktopChatResidentController.h3(java.lang.String, com.stepos.ailauncher.chat.panelui.PanelLayerRecentsPhase):void");
    }

    public final void i0(ChatActivity activity) {
        Window window;
        if (activity.y7() || (window = activity.getWindow()) == null) {
            return;
        }
        View decorView = window.getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        decorView.animate().cancel();
        decorView.setAlpha(0.0f);
        if (com.stepos.ailauncher.sheet.V.c(Q1(activity))) {
            decorView.setVisibility(4);
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        float fA = com.stepos.ailauncher.sheet.V.a();
        if (attributes.alpha != fA) {
            attributes.alpha = fA;
            window.setAttributes(attributes);
        }
        decorView.setVisibility(0);
        C4148a.d(TAG, "peek decor stay mapped (still resumed) taskId=" + activity.getTaskId(), false, 4, null);
    }

    public final void i1() {
        if (overlayHostYieldCleanupRegistered) {
            return;
        }
        overlayHostYieldCleanupRegistered = true;
        Ua.M m10 = overlayHostScope;
        C1060i.d(m10, null, null, new DesktopChatResidentController$ensureOverlayHostYieldCleanup$1(null), 3, null);
        C1060i.d(m10, null, null, new DesktopChatResidentController$ensureOverlayHostYieldCleanup$2(null), 3, null);
    }

    public final void i2(ChatActivity activity) {
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            activity.setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        activity.Q9(true);
        h1(activity);
        H(activity);
        X2("keep-pixels-passthrough");
    }

    public final void j0(final ChatActivity activity, boolean animate, final InterfaceC5063a<Boolean> stillHidden) {
        Window window;
        View decorView;
        if (activity.y7() || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.animate().cancel();
        I1(activity);
        if (!animate) {
            i0(activity);
            return;
        }
        decorView.setVisibility(0);
        if (decorView.getAlpha() <= 0.01f) {
            decorView.setAlpha(1.0f);
        }
        decorView.animate().alpha(0.0f).setDuration(180L).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.A
            @Override // java.lang.Runnable
            public final void run() {
                DesktopChatResidentController.k0(activity, stillHidden);
            }
        }).start();
    }

    public final void j1() {
        if (recentsListenerRegistered) {
            return;
        }
        RecentsWindowMonitor.INSTANCE.c(recentsListener);
        m0.INSTANCE.a(overlayRecentsSuspendListener);
        recentsListenerRegistered = true;
        C4148a.d(TAG, "RecentsWindowMonitor listener registered", false, 4, null);
        i1();
    }

    public final void j2(String reason) {
        ChatActivity chatActivityL1 = L1();
        if (chatActivityL1 == null) {
            return;
        }
        N3(chatActivityL1, PanelLayerRecentsPhase.OVERVIEW);
        try {
            Result.Companion companion = Result.INSTANCE;
            chatActivityL1.setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        if (m0.INSTANCE.h()) {
            overlayOpenAtPeek = true;
            panel3ExpandedAtPeek = chatActivityL1.R7();
        }
        if (!homeFollowingHiddenForPeek) {
            chatActivityL1.P9(true);
            E1(chatActivityL1, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.sheet.r
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(DesktopChatResidentController.k2());
                }
            });
            homeFollowingHiddenForPeek = true;
        }
        C4148a.k(TAG, reason + " → panel3 keep visual hidden taskId=" + chatActivityL1.getTaskId(), false, 4, null);
    }

    public final void j3(String reason, boolean peekIdleFromExplicitWake) {
        D5.a aVar = D5.a.INSTANCE;
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) aVar.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.resumePartition(HomeRootToken.MINUS_ONE);
        }
        if (C2732c.g(overlayOpenAtPeek, m0.INSTANCE.h(), peekIdleFromExplicitWake)) {
            IOverlayPageHost iOverlayPageHost = (IOverlayPageHost) aVar.a(IOverlayPageHost.class);
            if (iOverlayPageHost == null) {
                C4148a.u(TAG, reason + " → cannot restore overlay (no IOverlayPageHost)", false, 4, null);
                return;
            }
            iOverlayPageHost.requestOpenOverlay(false);
            C4148a.k(TAG, reason + " → requestOpenOverlay (restore minus-one, expandedAtPeek=" + panel3ExpandedAtPeek + ")", false, 4, null);
        }
    }

    public final void k1(int gen, String reason) {
        ChatActivity chatActivityW0;
        if (gen == bringFrontGeneration && (chatActivityW0 = W0()) != null) {
            L3(chatActivityW0, reason);
        }
    }

    public final void l0(ChatActivity activity) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(activity, "activity");
        ChatScene chatSceneA = ChatScene.INSTANCE.a(activity.getIntent());
        if (chatSceneA == ChatScene.DESKTOP) {
            m0(activity);
        } else if (chatSceneA.isHomeFollowing()) {
            n0(activity);
        } else if (chatSceneA.isStandaloneTask()) {
            q0(activity);
        }
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.notifyTopologyChanged("attach:" + chatSceneA.getWireValue());
        }
    }

    public final void l1(ChatActivity activity, InterfaceC5063a<Boolean> stillHidden) {
        E1(activity, true, stillHidden);
    }

    public final void l2(String reason) {
        Integer numValueOf = Integer.valueOf(dismissKickLauncherTaskId);
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(C2740k.INSTANCE.a());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf == null) {
                return;
            }
        }
        int iIntValue = numValueOf.intValue();
        Context context = dismissKickAppContext;
        if (context == null) {
            return;
        }
        dismissKickLauncherTaskId = -1;
        dismissKickAppContext = null;
        C4148a.k(TAG, reason + " → kick launcher after dismiss taskId=" + iIntValue + " ok=" + e0.INSTANCE.b(context, iIntValue, false, true), false, 4, null);
    }

    public final void m0(ChatActivity activity) throws Resources.NotFoundException {
        WeakReference<ChatActivity> weakReference = desktopRef;
        ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
        if (chatActivity != null && chatActivity != activity && !chatActivity.isFinishing() && !chatActivity.isDestroyed()) {
            C4148a.k(TAG, "attach desktop → finish previous instance taskId=" + chatActivity.getTaskId(), false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                chatActivity.finish();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
        desktopRef = new WeakReference<>(activity);
        Z2(activity.getTaskId());
        userDismissed = false;
        hiddenForRecents = false;
        b3("attach-desktop");
        inputSinkDisabled = false;
        desktopOccludedByOtherTask = false;
        desktopUnderThirdPartyAtPeek = false;
        desktopWasForegroundAtPeek = false;
        dismissKickLauncherTaskId = -1;
        dismissKickAppContext = null;
        boolean z10 = pendingShowAfterBringFront;
        pendingShowAfterBringFront = false;
        RecentsWindowMonitor recentsWindowMonitor = RecentsWindowMonitor.INSTANCE;
        recentsWindowMonitor.e("attach-desktop");
        lastRecentsState = recentsWindowMonitor.h();
        j1();
        o0(activity);
        J3(this, activity, false, 2, null);
        if (z10) {
            openDesktopSettleUntilElapsed = SystemClock.uptimeMillis() + 1200;
            Integer numValueOf = Integer.valueOf(activity.getTaskId());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : C2740k.INSTANCE.a();
            if (iIntValue > 0) {
                e0 e0Var = e0.INSTANCE;
                Context applicationContext = activity.getApplicationContext();
                kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                e0Var.b(applicationContext, iIntValue, false, true);
            }
            B3(activity, iIntValue);
            C4148a.k(TAG, "attach desktop chat (from openDesktop, settle 1200ms)", false, 4, null);
        } else {
            C4148a.d(TAG, "attach desktop chat", false, 4, null);
        }
        X2("attach-desktop");
    }

    public final void m1(Context context, int launcherId, int gen, String reason) {
        if (gen == bringFrontGeneration && pendingShowAfterBringFront && !userDismissed) {
            C4148a.u(TAG, "fallbackOpenDesktopRecreate reason=" + reason + " launcherId=" + launcherId, false, 4, null);
            BringLauncherTaskFrontActivity.Companion companion = BringLauncherTaskFrontActivity.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            BringLauncherTaskFrontActivity.Companion.b(companion, applicationContext, launcherId, null, null, null, 28, null);
        }
    }

    public final int m2() {
        return s0.INSTANCE.b("desktop").R();
    }

    public final void m3(ChatActivity activity, boolean fadeIn, boolean snapOpaque) {
        if (activity.y7() || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Window window = activity.getWindow();
        if (window != null) {
            window.clearFlags(24);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (snapOpaque && attributes.alpha < 1.0f) {
                attributes.alpha = 1.0f;
                window.setAttributes(attributes);
            }
            View decorView = window.getDecorView();
            decorView.animate().cancel();
            decorView.setVisibility(0);
            if (fadeIn) {
                decorView.animate().alpha(1.0f).setDuration(180L).start();
            } else if (snapOpaque) {
                decorView.setAlpha(1.0f);
            }
        }
        activity.Q9(false);
        C2730a.INSTANCE.a(activity, true);
        inputSinkDisabled = false;
    }

    public final void n0(ChatActivity activity) {
        WeakReference<ChatActivity> weakReference = homeOverlayRef;
        ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
        if (chatActivity != null && chatActivity != activity && !chatActivity.isFinishing() && !chatActivity.isDestroyed()) {
            ChatScene.Companion companion = ChatScene.INSTANCE;
            if (companion.a(chatActivity.getIntent()) == ChatScene.HOME_OVERLAY && companion.a(activity.getIntent()) != ChatScene.HOME_RESIDENT) {
                C4148a.k(TAG, "attach panel3 → finish previous HOME_OVERLAY taskId=" + chatActivity.getTaskId(), false, 4, null);
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    chatActivity.finish();
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
        homeOverlayRef = new WeakReference<>(activity);
        try {
            Result.Companion companion4 = Result.INSTANCE;
            activity.setRecentsScreenshotEnabled(false);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion5 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        C4148a.d(TAG, "attach panel3(HomeResident/following) scene=" + ChatScene.INSTANCE.a(activity.getIntent()) + " taskId=" + activity.getTaskId(), false, 4, null);
        X2("attach-home-following");
    }

    public final int n1(ChatActivity activity) {
        String packageName;
        int i10;
        ComponentName component;
        try {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService(ActivityManager.class);
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager != null ? activityManager.getRunningTasks(8) : null;
            if (runningTasks == null) {
                runningTasks = C1173v.m();
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                ComponentName componentName = runningTaskInfo.topActivity;
                if (componentName != null && (packageName = componentName.getPackageName()) != null) {
                    T t10 = T.INSTANCE;
                    ComponentName componentName2 = runningTaskInfo.baseActivity;
                    String className = componentName2 != null ? componentName2.getClassName() : null;
                    Intent intent = runningTaskInfo.baseIntent;
                    String className2 = (intent == null || (component = intent.getComponent()) == null) ? null : component.getClassName();
                    ComponentName componentName3 = runningTaskInfo.topActivity;
                    if (!t10.c(packageName, className, className2, componentName3 != null ? componentName3.getClassName() : null)) {
                        String packageName2 = activity.getPackageName();
                        kotlin.jvm.internal.p.h(packageName2, "getPackageName(...)");
                        if (c2(packageName, packageName2) && (i10 = runningTaskInfo.taskId) > 0) {
                            return i10;
                        }
                    }
                }
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int n2() {
        return s0.INSTANCE.b(com.stepos.ailauncher.chat.wake.Q.SESSION_MINUS_ONE).R();
    }

    public final void o0(final ChatActivity activity) {
        View decorView;
        if (!enableAppNavInterceptor) {
            X0();
            return;
        }
        if (navInterceptor != null) {
            Y y10 = navInterceptor;
            if (y10 != null) {
                y10.m(true);
                return;
            }
            return;
        }
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.F
            @Override // java.lang.Runnable
            public final void run() {
                DesktopChatResidentController.p0(activity);
            }
        });
    }

    public final void o1(String reason) {
        View decorView;
        Set<WeakReference<ChatActivity>> set = standaloneRefs;
        if (set.isEmpty()) {
            return;
        }
        S2();
        ArrayList<ChatActivity> arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            ChatActivity chatActivity = (ChatActivity) ((WeakReference) it.next()).get();
            if (chatActivity != null) {
                arrayList.add(chatActivity);
            }
        }
        standaloneRefs.clear();
        for (ChatActivity chatActivity2 : arrayList) {
            if (!chatActivity2.isFinishing() && !chatActivity2.isDestroyed()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    chatActivity2.setRecentsScreenshotEnabled(false);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
                chatActivity2.Q9(true);
                h1(chatActivity2);
                Window window = chatActivity2.getWindow();
                if (window != null && (decorView = window.getDecorView()) != null) {
                    decorView.setAlpha(0.0f);
                    decorView.setVisibility(8);
                }
                C4148a.k(TAG, reason + " → finishAndRemoveTask standalone scene=" + ChatScene.INSTANCE.a(chatActivity2.getIntent()), false, 4, null);
                chatActivity2.finishAndRemoveTask();
            }
        }
    }

    public final void o2() {
        suppressNavWakeUntilElapsed.set(SystemClock.elapsedRealtime() + 400);
    }

    public final void o3() throws Resources.NotFoundException {
        DesktopChatResidentController desktopChatResidentController;
        if (standaloneHiddenForPeek) {
            standaloneHiddenForPeek = false;
            S2();
            Iterator<WeakReference<ChatActivity>> it = standaloneRefs.iterator();
            while (it.hasNext()) {
                ChatActivity chatActivity = it.next().get();
                if (chatActivity != null) {
                    DesktopChatResidentController desktopChatResidentController2 = this;
                    n3(desktopChatResidentController2, chatActivity, true, false, 4, null);
                    desktopChatResidentController2.s3(chatActivity, activeRecentsTransitionId, PanelLayerRecentsPhase.PEEK);
                    this = desktopChatResidentController2;
                }
            }
            desktopChatResidentController = this;
            C4148a.d(TAG, "CANCEL_GESTURE → fade-restore panel2", false, 4, null);
        } else {
            desktopChatResidentController = this;
        }
        desktopChatResidentController.h3("CANCEL_GESTURE", PanelLayerRecentsPhase.PEEK);
    }

    public final void p1(ChatActivity activity) throws Resources.NotFoundException {
        if (activity.isFinishing() || activity.isDestroyed() || userDismissed) {
            return;
        }
        pendingShowAfterBringFront = false;
        openDesktopSettleUntilElapsed = 0L;
        J3(this, activity, false, 2, null);
        o0(activity);
        desktopOccludedByOtherTask = false;
        boolean zRa = activity.ra();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bringFront → show desktop panel (minifyPassthrough=");
        sb2.append(zRa);
        sb2.append(" InputSink=");
        sb2.append(!zRa);
        sb2.append(")");
        C4148a.k(TAG, sb2.toString(), false, 4, null);
    }

    public final void q0(ChatActivity activity) {
        Object next;
        S2();
        ChatScene chatSceneA = ChatScene.INSTANCE.a(activity.getIntent());
        if (chatSceneA.isStandaloneTask()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<WeakReference<ChatActivity>> it = standaloneRefs.iterator();
            while (it.hasNext()) {
                ChatActivity chatActivity = it.next().get();
                if (chatActivity != null && chatActivity != activity && !chatActivity.isFinishing() && !chatActivity.isDestroyed() && ChatScene.INSTANCE.a(chatActivity.getIntent()).isStandaloneTask()) {
                    if (s0.INSTANCE.a(chatActivity.getTaskId(), chatActivity)) {
                        arrayList2.add(chatActivity);
                    } else {
                        arrayList.add(chatActivity);
                    }
                }
            }
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int taskId = ((ChatActivity) next).getTaskId();
                    do {
                        Object next2 = it2.next();
                        int taskId2 = ((ChatActivity) next2).getTaskId();
                        if (taskId < taskId2) {
                            next = next2;
                            taskId = taskId2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            ChatActivity chatActivity2 = (ChatActivity) next;
            Iterator it3 = arrayList2.iterator();
            kotlin.jvm.internal.p.h(it3, "iterator(...)");
            while (it3.hasNext()) {
                Object next3 = it3.next();
                kotlin.jvm.internal.p.h(next3, "next(...)");
                ChatActivity chatActivity3 = (ChatActivity) next3;
                if (chatActivity3 == chatActivity2) {
                    C4148a.k(TAG, "attach standalone → keep previous (task still has stacked sheet/repair) taskId=" + chatActivity3.getTaskId() + " scene=" + ChatScene.INSTANCE.a(chatActivity3.getIntent()), false, 4, null);
                } else {
                    C4148a.k(TAG, "attach standalone → finish older covered board taskId=" + chatActivity3.getTaskId() + " scene=" + ChatScene.INSTANCE.a(chatActivity3.getIntent()), false, 4, null);
                    arrayList.add(chatActivity3);
                }
            }
            Iterator it4 = arrayList.iterator();
            kotlin.jvm.internal.p.h(it4, "iterator(...)");
            while (it4.hasNext()) {
                Object next4 = it4.next();
                kotlin.jvm.internal.p.h(next4, "next(...)");
                ChatActivity chatActivity4 = (ChatActivity) next4;
                C4148a.k(TAG, "attach standalone → finish previous taskId=" + chatActivity4.getTaskId() + " scene=" + ChatScene.INSTANCE.a(chatActivity4.getIntent()), false, 4, null);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    chatActivity4.finish();
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
        Set<WeakReference<ChatActivity>> set = standaloneRefs;
        set.add(new WeakReference<>(activity));
        q2();
        leftoverSheetFrontGeneration++;
        j1();
        C4148a.d(TAG, "attach standalone chat scene=" + chatSceneA + " total=" + set.size(), false, 4, null);
        if (C2732c.d(chatSceneA)) {
            b1("attach-standalone");
        }
        X2("attach-standalone");
    }

    public final void q2() {
        standaloneOpenProtectUntilElapsed = SystemClock.elapsedRealtime() + 800;
    }

    public final void q3(ChatActivity activity) throws Resources.NotFoundException {
        Window window;
        if (activity.y7() || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(24);
        if (!activity.ra()) {
            C2730a.INSTANCE.a(activity, true);
            inputSinkDisabled = false;
        } else {
            inputSinkDisabled = C2730a.INSTANCE.a(activity, false);
            C4148a.d(TAG, "restoreTouchAndSink → keep InputSink off (minify passthrough)", false, 4, null);
            activity.f9();
        }
    }

    public final void r1() throws Resources.NotFoundException {
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 == null || userDismissed) {
            return;
        }
        Z2(chatActivityW0.getTaskId());
        C4148a.k(TAG, "finishDesktopResidentForBoard → quiet finish desktop taskId=" + chatActivityW0.getTaskId(), false, 4, null);
        t1(chatActivityW0, false);
    }

    public final void r2() throws Resources.NotFoundException {
        WeakReference<ChatActivity> weakReference = desktopRef;
        ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
        if (chatActivity != null && !chatActivity.isDestroyed()) {
            if (dismissKeepPassthrough) {
                h1(chatActivity);
            } else {
                chatActivity.Q9(false);
                q3(chatActivity);
            }
        }
        userDismissed = true;
        if (!dismissKeepPassthrough) {
            hiddenForRecents = false;
            if (chatActivity == null || !chatActivity.ra()) {
                inputSinkDisabled = false;
            }
        }
        pendingShowAfterBringFront = false;
        desktopUnderThirdPartyAtPeek = false;
        desktopWasForegroundAtPeek = false;
        Y y10 = navInterceptor;
        if (y10 != null) {
            y10.f();
        }
        navInterceptor = null;
        dismissKeepPassthrough = false;
        b3("user-dismissed");
        C4148a.d(TAG, "markUserDismissed", false, 4, null);
        X2("user-dismissed");
    }

    public final void r3(ChatActivity activity) {
        if (activity.y7() || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Window window = activity.getWindow();
        if (window != null) {
            window.clearFlags(24);
            window.getDecorView().animate().cancel();
        }
        activity.Q9(false);
        C2730a.INSTANCE.a(activity, true);
        inputSinkDisabled = false;
    }

    public final void s0(int launcherId, String reason) {
        Context contextC0 = c0();
        if (contextC0 == null) {
            return;
        }
        if (launcherId <= 0) {
            e0.INSTANCE.h(contextC0);
            C4148a.u(TAG, "leftover sheets bringFront reason=" + reason + " no launcherId → HOME intent", false, 4, null);
            return;
        }
        e0.INSTANCE.b(contextC0, launcherId, false, true);
        C4148a.k(TAG, "leftover sheets bringFront reason=" + reason + " launcherId=" + launcherId, false, 4, null);
    }

    public final boolean s2(ChatActivity activity) {
        Object next;
        boolean z10;
        ComponentName component;
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService(ActivityManager.class);
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager != null ? activityManager.getRunningTasks(32) : null;
            if (runningTasks == null) {
                runningTasks = C1173v.m();
            }
            ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) Z8.F.s0(runningTasks);
            if (runningTaskInfo == null) {
                return false;
            }
            Iterator<T> it = runningTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ActivityManager.RunningTaskInfo) next).taskId == activity.getTaskId()) {
                    break;
                }
            }
            ActivityManager.RunningTaskInfo runningTaskInfo2 = (ActivityManager.RunningTaskInfo) next;
            C2731b c2731b = C2731b.INSTANCE;
            ChatScene chatSceneA = ChatScene.INSTANCE.a(activity.getIntent());
            int taskId = activity.getTaskId();
            int i10 = runningTaskInfo.taskId;
            ComponentName componentName = runningTaskInfo.topActivity;
            String packageName = componentName != null ? componentName.getPackageName() : null;
            String packageName2 = activity.getPackageName();
            kotlin.jvm.internal.p.h(packageName2, "getPackageName(...)");
            boolean zD = kotlin.jvm.internal.p.d(runningTaskInfo2 != null ? runningTaskInfo2.topActivity : null, activity.getComponentName());
            RecentsWindowMonitor.RecentsState recentsState = lastRecentsState;
            RecentsWindowMonitor.RecentsState recentsState2 = RecentsWindowMonitor.RecentsState.IDLE;
            boolean z11 = recentsState == recentsState2 && RecentsWindowMonitor.INSTANCE.h() == recentsState2;
            if (!T1()) {
                T t10 = T.INSTANCE;
                ComponentName componentName2 = runningTaskInfo.topActivity;
                String packageName3 = componentName2 != null ? componentName2.getPackageName() : null;
                ComponentName componentName3 = runningTaskInfo.baseActivity;
                String className = componentName3 != null ? componentName3.getClassName() : null;
                Intent intent = runningTaskInfo.baseIntent;
                String className2 = (intent == null || (component = intent.getComponent()) == null) ? null : component.getClassName();
                ComponentName componentName4 = runningTaskInfo.topActivity;
                z10 = t10.c(packageName3, className, className2, componentName4 != null ? componentName4.getClassName() : null);
            }
            return c2731b.a(chatSceneA, taskId, i10, packageName, packageName2, zD, z11, z10);
        } catch (Throwable th) {
            C4148a.u(TAG, "board restore task snapshot unavailable: " + th.getMessage(), false, 4, null);
            return false;
        }
    }

    public final void s3(ChatActivity activity, long transitionId, PanelLayerRecentsPhase expectedPhase) {
        Object objB = com.stepos.ailauncher.chat.panelui.v.INSTANCE.b(activity);
        if (objB == null) {
            return;
        }
        com.stepos.ailauncher.chat.panelui.i.INSTANCE.f(objB, transitionId, expectedPhase);
    }

    public final void t1(ChatActivity activity, boolean kickLauncherAfter) throws Resources.NotFoundException {
        View decorView;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Window window = activity.getWindow();
        com.stepos.ailauncher.foundation.appui.card.provider.appauther.u.a(window != null ? window.getDecorView() : null);
        h1(activity);
        Window window2 = activity.getWindow();
        if (window2 != null) {
            window2.addFlags(8);
        }
        Window window3 = activity.getWindow();
        if (window3 != null && (decorView = window3.getDecorView()) != null) {
            decorView.setAlpha(0.0f);
            decorView.setVisibility(4);
        }
        if (kickLauncherAfter) {
            Integer numValueOf = Integer.valueOf(activity.getTaskId());
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            dismissKickLauncherTaskId = numValueOf != null ? numValueOf.intValue() : -1;
            dismissKickAppContext = activity.getApplicationContext();
            dismissKeepPassthrough = true;
        } else {
            dismissKickLauncherTaskId = -1;
            dismissKickAppContext = null;
            dismissKeepPassthrough = false;
        }
        r2();
        C4148a.k(TAG, "finishDesktopResidentNow kickLauncherAfter=" + kickLauncherAfter + " taskId=" + activity.getTaskId(), false, 4, null);
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }

    public final void t3() {
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.resumePartition(HomeRootToken.DESKTOP);
            iHomeGestureCoordinator.resumePartition(HomeRootToken.BOARD);
            iHomeGestureCoordinator.resumePartition(HomeRootToken.MINUS_ONE);
        }
    }

    public final void u0(ChatActivity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.removeCallbacks(clearOccludedRunnable);
    }

    public final void u1(String reason) {
        ChatActivity chatActivityL1 = L1();
        if (chatActivityL1 == null) {
            return;
        }
        ChatScene chatSceneA = ChatScene.INSTANCE.a(chatActivityL1.getIntent());
        C4148a.k(TAG, "finishLeftoverHomeFollowingForBoard reason=" + reason + " scene=" + chatSceneA + " taskId=" + chatActivityL1.getTaskId(), false, 4, null);
        if (chatSceneA == ChatScene.HOME_RESIDENT) {
            try {
                Result.Companion companion = Result.INSTANCE;
                chatActivityL1.finishAndRemoveTask();
                Result.b(Y8.t.f7040a);
                return;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
                return;
            }
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            chatActivityL1.finish();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
    }

    public final void u3(ChatActivity activity) {
        if (activity.y7() || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Window window = activity.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes.alpha < 1.0f) {
                attributes.alpha = 1.0f;
                window.setAttributes(attributes);
            }
            View decorView = window.getDecorView();
            kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
            decorView.animate().cancel();
            decorView.setVisibility(0);
            decorView.setAlpha(1.0f);
        }
        hiddenForRecents = false;
        i2(activity);
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.resumePartition(HomeRootToken.DESKTOP);
        }
        Object objB = com.stepos.ailauncher.chat.panelui.v.INSTANCE.b(activity);
        if (objB != null) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.g(objB);
        }
    }

    public final void v0() {
        Window window;
        View decorView;
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 == null || (window = chatActivityW0.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.removeCallbacks(coverSafetyRunnable);
    }

    public final void v1(String reason) {
        pendingShowAfterBringFront = false;
        desktopOccludedByOtherTask = false;
        desktopUnderThirdPartyAtPeek = false;
        openDesktopSettleUntilElapsed = 0L;
        C4148a.k(TAG, "leftover sheets landed on desktop reason=" + reason, false, 4, null);
        X2(reason);
    }

    public final void v3() {
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 != null && externalUiCover.get() > 0) {
            if (lastRecentsState != RecentsWindowMonitor.RecentsState.IDLE) {
                w3();
                return;
            }
            String strL2 = L2(chatActivityW0);
            T t10 = T.INSTANCE;
            String packageName = chatActivityW0.getPackageName();
            kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
            if (!t10.g(true, strL2, packageName)) {
                w3();
                return;
            }
            C4148a.u(TAG, "cover safety valve: force end top=" + strL2, false, 4, null);
            b3("safety-valve");
            d0(chatActivityW0, "cover-safety-valve");
        }
    }

    public final void w0(ChatActivity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.removeCallbacks(markOccludedRunnable);
    }

    public final void w1(ChatActivity activity) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(activity, "activity");
        if (ChatScene.INSTANCE.a(activity.getIntent()).isStandaloneTask()) {
            standaloneHiddenForPeek = false;
            closedStandaloneThisGesture = true;
            pendingShowAfterBringFront = false;
            holdPanel1HiddenAfterBoardHome = true;
            int i10 = underlyingThirdPartyTaskIdAtPeek;
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.b(com.stepos.ailauncher.chat.panelui.v.INSTANCE.a(activity), PanelLayerDismissReason.OVERVIEW);
            desktopWasForegroundAtPeek = false;
            desktopUnderThirdPartyAtPeek = false;
            h2("consume-group-exit-standalone");
            E3("consume-group-exit-standalone", i10);
            E0();
            if (W0() != null && !userDismissed) {
                desktopOccludedByOtherTask = true;
            }
            X2("consume-group-exit-standalone");
        }
    }

    public final void w3() {
        Window window;
        View decorView;
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 == null || (window = chatActivityW0.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        Runnable runnable = coverSafetyRunnable;
        decorView.removeCallbacks(runnable);
        if (externalUiCover.get() <= 0) {
            return;
        }
        decorView.postDelayed(runnable, 2000L);
    }

    public final void x0(String reason) {
        if (pendingShowAfterBringFront) {
            pendingShowAfterBringFront = false;
            bringFrontGeneration++;
            leftoverSheetFrontGeneration++;
            C4148a.k(TAG, "cancelPendingBringFront reason=" + reason, false, 4, null);
        }
    }

    public final void x1(ChatActivity standalone) throws Resources.NotFoundException {
        Object objB;
        standaloneHiddenForPeek = false;
        closedStandaloneThisGesture = false;
        pendingShowAfterBringFront = false;
        holdPanel1HiddenAfterBoardHome = true;
        boardHomeExitRunning = true;
        int i10 = underlyingThirdPartyTaskIdAtPeek;
        m3(standalone, false, false);
        try {
            Result.Companion companion = Result.INSTANCE;
            standalone.overridePendingTransition(0, 0);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        try {
            standalone.O6();
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "dismissSheetAfterHomeConsume standalone failed: " + thE.getMessage(), false, 4, null);
            boardHomeExitRunning = false;
            INSTANCE.a1(standalone);
        }
        desktopWasForegroundAtPeek = false;
        desktopUnderThirdPartyAtPeek = false;
        h2("consume-dismiss-standalone");
        E3("consume-dismiss-standalone", i10);
        E0();
        if ((W0() != null && !userDismissed) || D1()) {
            desktopOccludedByOtherTask = true;
        }
        X2("consume-dismiss-standalone");
    }

    public final void x3(final ChatActivity activity, final int launcherId, final int gen, final int attempt) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.y
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                DesktopChatResidentController.y3(gen, attempt, activity, launcherId);
            }
        }, attempt != 0 ? attempt != 1 ? 450L : 280L : BRING_FRONT_STABLE_MS);
    }

    public final void y0(String reason) {
        if (recentsCommitPending) {
            recentsCommitPending = false;
            mainHandler.removeCallbacks(recentsCommitRunnable);
            long jElapsedRealtime = peekStartedElapsed > 0 ? SystemClock.elapsedRealtime() - peekStartedElapsed : 0L;
            C4148a.k(TAG, "recents-commit cancelled reason=" + reason + " after=" + jElapsedRealtime + "ms committed=" + recentsPeekVisualCommitted, false, 4, null);
        }
    }

    public final void y1(String reason) {
        Window window;
        View decorView;
        int i10 = pendingRestoreThirdPartyTaskId;
        m0 m0Var = m0.INSTANCE;
        if (!C2732c.i(i10, m0Var.h(), overlayOpenAtPeek, n2())) {
            pendingRestoreThirdPartyTaskId = -1;
            if (i10 > 0) {
                C4148a.k(TAG, "skip restore underlying 3rd (" + reason + ") taskId=" + i10 + " overlayOpen=" + m0Var.h(), false, 4, null);
                return;
            }
            return;
        }
        pendingRestoreThirdPartyTaskId = -1;
        ChatActivity chatActivityW0 = W0();
        if (chatActivityW0 == null) {
            chatActivityW0 = L1();
        }
        if (chatActivityW0 != null && (window = chatActivityW0.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.removeCallbacks(restoreThirdPartyAfterMorphRunnable);
        }
        Context contextC0 = c0();
        if (contextC0 == null) {
            return;
        }
        C4148a.k(TAG, "restore underlying 3rd after panel2 home (" + reason + ") taskId=" + i10 + " ok=" + e0.INSTANCE.b(contextC0, i10, false, true), false, 4, null);
    }

    public final void y2(final ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        com.stepos.ailauncher.chat.panelui.i.INSTANCE.b(com.stepos.ailauncher.chat.panelui.v.INSTANCE.a(activity), PanelLayerDismissReason.OWNER_DESTROY);
        ChatScene chatSceneA = ChatScene.INSTANCE.a(activity.getIntent());
        if (chatSceneA.isStandaloneTask()) {
            Set<WeakReference<ChatActivity>> set = standaloneRefs;
            Z8.A.J(set, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.sheet.H
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(DesktopChatResidentController.z2(activity, (WeakReference) obj));
                }
            });
            C4148a.d(TAG, "detach standalone chat, remaining=" + set.size(), false, 4, null);
            if (set.isEmpty()) {
                boardHomeExitRunning = false;
                y1("detach-standalone");
            }
            X2("detach-standalone");
            return;
        }
        if (chatSceneA.isHomeFollowing()) {
            WeakReference<ChatActivity> weakReference = homeOverlayRef;
            ChatActivity chatActivity = weakReference != null ? weakReference.get() : null;
            if (chatActivity == null || chatActivity == activity) {
                homeOverlayRef = null;
                C4148a.d(TAG, "detach panel3(HomeResident/following) scene=" + chatSceneA, false, 4, null);
            }
            X2("detach-home-following");
            return;
        }
        if (chatSceneA != ChatScene.DESKTOP) {
            return;
        }
        WeakReference<ChatActivity> weakReference2 = desktopRef;
        ChatActivity chatActivity2 = weakReference2 != null ? weakReference2.get() : null;
        if (chatActivity2 == null || chatActivity2 == activity) {
            inputSinkDisabled = false;
            dismissKeepPassthrough = false;
            Y y10 = navInterceptor;
            if (y10 != null) {
                y10.f();
            }
            navInterceptor = null;
            e3("detach-desktop");
            desktopRef = null;
            hiddenForRecents = false;
            b3("detach-desktop");
            C4148a.d(TAG, "detach desktop chat", false, 4, null);
            X2("detach-desktop");
        }
    }

    public final void z0() {
        mainHandler.removeCallbacks(yieldLandingRecheckRunnable);
    }

    public final boolean z1() {
        return enableAppNavInterceptor;
    }

    public final void z3(final int launcherId, final int gen, final int attempt) {
        mainHandler.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.B
            @Override // java.lang.Runnable
            public final void run() {
                DesktopChatResidentController.A3(gen, attempt, launcherId);
            }
        }, attempt != 0 ? attempt != 1 ? 450L : 280L : BRING_FRONT_STABLE_MS);
    }
}
