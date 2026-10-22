package com.stepos.ailauncher.sheet;

import Z8.C1173v;
import android.animation.Animator;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Lifecycle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.Z;
import androidx.core.view.a0;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.container.glass.SheetGlassStyle;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sheet.SheetLaunchOptions;
import com.stepos.ailauncher.sheet.internal.C3442a;
import com.stepos.ailauncher.sheet.widget.DraggableSheetLayout;
import com.stepos.ailauncher.task.detail.TaskWebView;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h6.C4145a;
import io.ktor.http.LinkHeader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 £\u00032\u00020\u0001:\u0004¤\u0003¥\u0003B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J!\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u0019\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J+\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010+\u001a\u00020\u000e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\u0003J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010\u0003J\u0017\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J#\u0010=\u001a\u00020\u00062\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00060:H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\u0003J\u000f\u0010@\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010\u0003J!\u0010B\u001a\u00020\u00062\u0006\u00107\u001a\u0002062\b\b\u0002\u0010A\u001a\u00020\u000eH\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\bD\u00109J\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\u0003J\u000f\u0010F\u001a\u00020\u000eH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0006H\u0002¢\u0006\u0004\bH\u0010\u0003J\u0017\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0014H\u0002¢\u0006\u0004\bJ\u0010KJ\u001f\u0010N\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u000eH\u0002¢\u0006\u0004\bN\u0010\u0018J\u000f\u0010O\u001a\u00020\u0006H\u0003¢\u0006\u0004\bO\u0010\u0003J\u000f\u0010P\u001a\u00020\u0006H\u0003¢\u0006\u0004\bP\u0010\u0003J\u000f\u0010Q\u001a\u00020\u0006H\u0003¢\u0006\u0004\bQ\u0010\u0003J\u0017\u0010T\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bT\u0010UJ'\u0010Y\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020;2\u0006\u0010X\u001a\u00020\u0014H\u0014¢\u0006\u0004\bY\u0010ZJ\u001f\u0010[\u001a\u00020\u00062\u0006\u00101\u001a\u0002002\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b[\u0010\\J\u001f\u0010^\u001a\u00020\u00062\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b^\u0010\rJ\u000f\u0010_\u001a\u00020\u0006H\u0004¢\u0006\u0004\b_\u0010\u0003J3\u0010c\u001a\u00020\u00062\u0006\u0010a\u001a\u00020`2\b\b\u0002\u0010b\u001a\u00020\u000e2\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0004¢\u0006\u0004\bc\u0010dJ!\u0010e\u001a\u00020\u00062\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0004¢\u0006\u0004\be\u0010\rJ\u000f\u0010f\u001a\u00020\u0014H\u0014¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020;H\u0014¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\u000eH\u0014¢\u0006\u0004\bj\u0010GJ\u000f\u0010k\u001a\u00020\u000eH\u0014¢\u0006\u0004\bk\u0010GJ\u000f\u0010l\u001a\u00020\u0006H\u0004¢\u0006\u0004\bl\u0010\u0003J\u000f\u0010m\u001a\u00020\u000eH\u0014¢\u0006\u0004\bm\u0010GJ\u000f\u0010n\u001a\u00020\u000eH\u0004¢\u0006\u0004\bn\u0010GJ\u0017\u0010p\u001a\u00020\u00062\u0006\u0010o\u001a\u00020\u000eH\u0000¢\u0006\u0004\bp\u0010\u0011J\u000f\u0010q\u001a\u00020\u000eH\u0004¢\u0006\u0004\bq\u0010GJ\u000f\u0010r\u001a\u00020\u000eH\u0014¢\u0006\u0004\br\u0010GJ\u000f\u0010s\u001a\u00020\u0006H\u0000¢\u0006\u0004\bs\u0010\u0003J\u000f\u0010t\u001a\u00020\u0006H\u0014¢\u0006\u0004\bt\u0010\u0003J\u000f\u0010u\u001a\u00020\u0006H\u0014¢\u0006\u0004\bu\u0010\u0003J\u000f\u0010v\u001a\u00020\u000eH\u0014¢\u0006\u0004\bv\u0010GJ\u000f\u0010w\u001a\u00020\u000eH\u0014¢\u0006\u0004\bw\u0010GJ\u000f\u0010x\u001a\u00020\u0014H\u0014¢\u0006\u0004\bx\u0010gJ\u000f\u0010y\u001a\u00020\u000eH\u0014¢\u0006\u0004\by\u0010GJ\u000f\u0010z\u001a\u00020\u000eH\u0014¢\u0006\u0004\bz\u0010GJ\u000f\u0010{\u001a\u00020\u000eH\u0014¢\u0006\u0004\b{\u0010GJ\u000f\u0010|\u001a\u00020\u0006H\u0004¢\u0006\u0004\b|\u0010\u0003J\u000f\u0010}\u001a\u00020\u000eH\u0014¢\u0006\u0004\b}\u0010GJ\u000f\u0010~\u001a\u00020\u000eH\u0014¢\u0006\u0004\b~\u0010GJ\u000f\u0010\u007f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u007f\u0010GJ\u0014\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0013\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0014¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J(\u0010\u0089\u0001\u001a\u00020\u00062\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001H$¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001d\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0006\u00101\u001a\u000200H\u0014¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0019\u0010\u008e\u0001\u001a\u00020\u00062\u0006\u00101\u001a\u000200H\u0015¢\u0006\u0005\b\u008e\u0001\u00103J\u001a\u0010\u0090\u0001\u001a\u00020\u00062\u0007\u0010\u008f\u0001\u001a\u00020\u0014H\u0014¢\u0006\u0005\b\u0090\u0001\u0010KJ\u001a\u0010\u0092\u0001\u001a\u00020\u00062\u0007\u0010\u0091\u0001\u001a\u00020\u0014H\u0014¢\u0006\u0005\b\u0092\u0001\u0010KJ\u001a\u0010\u0093\u0001\u001a\u00020\u00062\u0007\u0010\u0091\u0001\u001a\u00020\u0014H\u0014¢\u0006\u0005\b\u0093\u0001\u0010KJ\u001a\u0010\u0095\u0001\u001a\u00020\u00062\u0007\u0010\u0094\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0095\u0001\u0010\u0011J\u0011\u0010\u0096\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0096\u0001\u0010GJ\u0013\u0010\u0098\u0001\u001a\u00030\u0097\u0001H\u0014¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u0011\u0010\u009a\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u009a\u0001\u0010GJ\u0015\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0014¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0015\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0014¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0014\u0010¡\u0001\u001a\u0004\u0018\u00010`H\u0014¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0011\u0010£\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b£\u0001\u0010GJ\u0011\u0010¤\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b¤\u0001\u0010GJ\u0011\u0010¥\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b¥\u0001\u0010GJ\u0011\u0010¦\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b¦\u0001\u0010GJ\u0014\u0010§\u0001\u001a\u0004\u0018\u00010;H\u0014¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u0014\u0010©\u0001\u001a\u0004\u0018\u00010`H\u0014¢\u0006\u0006\b©\u0001\u0010¢\u0001J\u0011\u0010ª\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\bª\u0001\u0010GJ\u0011\u0010«\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b«\u0001\u0010GJ\u0011\u0010¬\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b¬\u0001\u0010GJ\u0014\u0010\u00ad\u0001\u001a\u0004\u0018\u00010;H\u0014¢\u0006\u0006\b\u00ad\u0001\u0010¨\u0001J\u0011\u0010®\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b®\u0001\u0010GJ\u0019\u0010¯\u0001\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0014H\u0014¢\u0006\u0005\b¯\u0001\u0010KJ,\u0010²\u0001\u001a\u00020\u00062\u0018\b\u0002\u0010±\u0001\u001a\u0011\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0014\u0018\u00010°\u0001H\u0004¢\u0006\u0006\b²\u0001\u0010³\u0001J\u0015\u0010´\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0014¢\u0006\u0006\b´\u0001\u0010 \u0001J\u0011\u0010µ\u0001\u001a\u00020\u0006H\u0015¢\u0006\u0005\bµ\u0001\u0010\u0003J\u0011\u0010¶\u0001\u001a\u00020\u0006H\u0015¢\u0006\u0005\b¶\u0001\u0010\u0003J\u0010\u0010·\u0001\u001a\u000200¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u0019\u0010¹\u0001\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0015¢\u0006\u0005\b¹\u0001\u0010\u0011J\u001e\u0010º\u0001\u001a\u00020\u00062\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0015¢\u0006\u0006\bº\u0001\u0010»\u0001J\u0011\u0010¼\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b¼\u0001\u0010GJ(\u0010¿\u0001\u001a\u00020\u00062\t\b\u0002\u0010½\u0001\u001a\u00020\u000e2\u000b\b\u0002\u0010¾\u0001\u001a\u0004\u0018\u000100¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0019\u0010Á\u0001\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0005\bÁ\u0001\u0010\u0011J\u0018\u0010Ã\u0001\u001a\u00020\u00062\u0007\u0010Â\u0001\u001a\u00020\u000e¢\u0006\u0005\bÃ\u0001\u0010\u0011J\u0011\u0010Ä\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\bÄ\u0001\u0010GJ\u0011\u0010Å\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\bÅ\u0001\u0010GJ\u001a\u0010Æ\u0001\u001a\u00020\u00062\u0007\u0010\u008f\u0001\u001a\u00020\u0014H\u0004¢\u0006\u0005\bÆ\u0001\u0010KJD\u0010É\u0001\u001a\u00020\u00062\u0007\u0010Ç\u0001\u001a\u00020\u00142\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0004¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J$\u0010Ë\u0001\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00142\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0006\bË\u0001\u0010Ì\u0001J\u0011\u0010Í\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\bÍ\u0001\u0010GJ\u0011\u0010Î\u0001\u001a\u00020;H\u0014¢\u0006\u0005\bÎ\u0001\u0010iJ$\u0010Ñ\u0001\u001a\u00020;2\u0007\u0010Ï\u0001\u001a\u00020;2\u0007\u0010Ð\u0001\u001a\u00020;H\u0014¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J\u0018\u0010Ô\u0001\u001a\u00020\u00062\u0007\u0010Ó\u0001\u001a\u00020\u000e¢\u0006\u0005\bÔ\u0001\u0010\u0011J\u0014\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u0011\u0010×\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b×\u0001\u0010GJ\u0018\u0010Ø\u0001\u001a\u00020\u00062\u0007\u0010\u0094\u0001\u001a\u00020\u000e¢\u0006\u0005\bØ\u0001\u0010\u0011J\u0011\u0010Ù\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0005\bÙ\u0001\u0010\u0003J\u001a\u0010Û\u0001\u001a\u00020\u00062\t\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0019¢\u0006\u0005\bÛ\u0001\u0010\u001cJ\u001a\u0010Ý\u0001\u001a\u00020\u00062\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0019¢\u0006\u0005\bÝ\u0001\u0010\u001cJ\u0018\u0010Þ\u0001\u001a\u00020\u00062\u0007\u0010Ó\u0001\u001a\u00020\u000e¢\u0006\u0005\bÞ\u0001\u0010\u0011J\u0018\u0010à\u0001\u001a\u00020\u00062\u0007\u0010ß\u0001\u001a\u00020\u000e¢\u0006\u0005\bà\u0001\u0010\u0011J\u0011\u0010á\u0001\u001a\u00020\u0006H\u0004¢\u0006\u0005\bá\u0001\u0010\u0003J\u0011\u0010â\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\bâ\u0001\u0010GJ\u001a\u0010ã\u0001\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0006\bã\u0001\u0010ä\u0001J&\u0010ã\u0001\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\n\u0010å\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016¢\u0006\u0006\bã\u0001\u0010æ\u0001J\u0011\u0010ç\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0005\bç\u0001\u0010\u0003J\u0011\u0010è\u0001\u001a\u00020\u000eH\u0017¢\u0006\u0005\bè\u0001\u0010GJ\u0014\u0010é\u0001\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0006\bé\u0001\u0010ê\u0001J$\u0010ì\u0001\u001a\u00020\u00062\u0007\u0010ë\u0001\u001a\u00020\u00142\u0007\u0010\u0091\u0001\u001a\u00020\u0014H\u0007¢\u0006\u0006\bì\u0001\u0010í\u0001J$\u0010ï\u0001\u001a\u00020\u00062\u0007\u0010î\u0001\u001a\u00020\u00142\u0007\u0010\u0091\u0001\u001a\u00020\u0014H\u0017¢\u0006\u0006\bï\u0001\u0010í\u0001J\u0011\u0010ð\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0005\bð\u0001\u0010\u0003J\u0011\u0010ñ\u0001\u001a\u00020\u0006H\u0017¢\u0006\u0005\bñ\u0001\u0010\u0003J\u0011\u0010ò\u0001\u001a\u00020\u0006H\u0005¢\u0006\u0005\bò\u0001\u0010\u0003J\u0011\u0010ó\u0001\u001a\u00020\u0006H\u0004¢\u0006\u0005\bó\u0001\u0010\u0003J%\u0010ö\u0001\u001a\u00020\u00062\u0007\u0010Ü\u0001\u001a\u00020\u00192\b\u0010õ\u0001\u001a\u00030ô\u0001H\u0004¢\u0006\u0006\bö\u0001\u0010÷\u0001J\u000f\u0010ø\u0001\u001a\u00020\u0006¢\u0006\u0005\bø\u0001\u0010\u0003J\u000f\u0010ù\u0001\u001a\u00020\u0006¢\u0006\u0005\bù\u0001\u0010\u0003J&\u0010û\u0001\u001a\u00020\u00062\u0015\u0010ú\u0001\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0006\u0018\u00010:¢\u0006\u0005\bû\u0001\u0010>J\u001a\u0010ý\u0001\u001a\u00020\u00062\u0007\u0010ü\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\bý\u0001\u0010\u0011J\u001b\u0010ÿ\u0001\u001a\u00020\u00062\u0007\u0010þ\u0001\u001a\u00020;H\u0014¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J\u001c\u0010\u0083\u0002\u001a\u00020\u00062\b\u0010\u0082\u0002\u001a\u00030\u0081\u0002H\u0016¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002J\u0011\u0010\u0085\u0002\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0085\u0002\u0010\u0003J\u001a\u0010\u0087\u0002\u001a\u00020\u00062\u0007\u0010\u0086\u0002\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u0087\u0002\u0010\u0011J\u0011\u0010\u0088\u0002\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0088\u0002\u0010\u0003J\u0011\u0010\u0089\u0002\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0089\u0002\u0010GJ\u0011\u0010\u008a\u0002\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u008a\u0002\u0010\u0003J\u0011\u0010\u008b\u0002\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u008b\u0002\u0010\u0003J\u000f\u0010\u008c\u0002\u001a\u00020\u000e¢\u0006\u0005\b\u008c\u0002\u0010GJ\u000f\u0010\u008d\u0002\u001a\u00020\u000e¢\u0006\u0005\b\u008d\u0002\u0010GJ\u000f\u0010\u008e\u0002\u001a\u00020\u0006¢\u0006\u0005\b\u008e\u0002\u0010\u0003J\u000f\u0010\u008f\u0002\u001a\u00020\u0006¢\u0006\u0005\b\u008f\u0002\u0010\u0003J\u0011\u0010\u0090\u0002\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0090\u0002\u0010\u0003J\u0011\u0010\u0091\u0002\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0091\u0002\u0010GJ\u0011\u0010\u0092\u0002\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0092\u0002\u0010GJ\u0011\u0010\u0093\u0002\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0093\u0002\u0010GJ\u0011\u0010\u0094\u0002\u001a\u00020\u0006H\u0015¢\u0006\u0005\b\u0094\u0002\u0010\u0003J\u000f\u0010\u0095\u0002\u001a\u00020\u0006¢\u0006\u0005\b\u0095\u0002\u0010\u0003J\u0011\u0010\u0096\u0002\u001a\u00020\u0006H\u0016¢\u0006\u0005\b\u0096\u0002\u0010\u0003J\u0011\u0010\u0097\u0002\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0097\u0002\u0010\u0003J\u0011\u0010\u0098\u0002\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0098\u0002\u0010\u0003R\u001a\u0010\u009a\u0002\u001a\u00030\u0099\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009a\u0002\u0010\u009b\u0002R\u001b\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002R\u0019\u0010\u009e\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010\u009f\u0002R)\u0010¡\u0002\u001a\u00020\u000e2\u0007\u0010 \u0002\u001a\u00020\u000e8\u0004@BX\u0084\u000e¢\u0006\u000f\n\u0006\b¡\u0002\u0010\u009f\u0002\u001a\u0005\b¢\u0002\u0010GR\u0019\u0010£\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0002\u0010\u009f\u0002R\u0019\u0010¤\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010\u009f\u0002R\u0019\u0010¥\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0002\u0010\u009f\u0002R\u0019\u0010¦\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010\u009f\u0002R\u001c\u0010¨\u0002\u001a\u0005\u0018\u00010§\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0002\u0010©\u0002R\u001c\u0010ª\u0002\u001a\u0005\u0018\u00010§\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0002\u0010©\u0002R\u001c\u0010¬\u0002\u001a\u0005\u0018\u00010«\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010\u00ad\u0002R\u001c\u0010®\u0002\u001a\u0005\u0018\u00010§\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0002\u0010©\u0002R\u001c\u0010¯\u0002\u001a\u0005\u0018\u00010«\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010\u00ad\u0002R\u0019\u0010°\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010\u009f\u0002R\u0019\u0010±\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010\u009f\u0002R\u0019\u0010²\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010³\u0002R\u0019\u0010´\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010³\u0002R\u001c\u0010¶\u0002\u001a\u0005\u0018\u00010µ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010·\u0002R\u001c\u0010¹\u0002\u001a\u0005\u0018\u00010¸\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0002\u0010º\u0002R\u0019\u0010»\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010¼\u0002R\u001a\u0010¾\u0002\u001a\u00030½\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0002\u0010¿\u0002R\u0019\u0010À\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0002\u0010\u009f\u0002R\u0019\u0010Á\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010³\u0002R\u0019\u0010Â\u0002\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0002\u0010Ã\u0002R\u0019\u0010Ä\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0002\u0010\u009f\u0002R\u0019\u0010Å\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010¼\u0002R\u0019\u0010Æ\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0002\u0010³\u0002R\u0019\u0010Ç\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0002\u0010¼\u0002R\u0019\u0010È\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0002\u0010¼\u0002R\u0019\u0010É\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010\u009f\u0002R\u0019\u0010Ê\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0002\u0010³\u0002R\u001c\u0010Ì\u0002\u001a\u0005\u0018\u00010Ë\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0002\u0010Í\u0002R\u0019\u0010Î\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0002\u0010¼\u0002R\u0019\u0010Ï\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0002\u0010¼\u0002R\u0019\u0010Ð\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010¼\u0002R\u0019\u0010Ñ\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0002\u0010\u009f\u0002R\u001c\u0010Ò\u0002\u001a\u0005\u0018\u00010Ë\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010Í\u0002R\u0019\u0010Ó\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0002\u0010\u009f\u0002R\u0019\u0010Ô\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0002\u0010\u009f\u0002R\u0019\u0010Õ\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0002\u0010\u009f\u0002R\u0018\u0010×\u0002\u001a\u00030Ö\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0002\u0010Ø\u0002R!\u0010Ù\u0002\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0002\u0010Ú\u0002R\u0018\u0010Ü\u0002\u001a\u00030Û\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0002\u0010Ý\u0002R\u001b\u0010Þ\u0002\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0002\u0010ß\u0002R\u0018\u0010á\u0002\u001a\u00030à\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0002\u0010â\u0002R\u0019\u0010ã\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0002\u0010\u009f\u0002R\u0019\u0010ä\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0002\u0010\u009f\u0002R\u0019\u0010å\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0002\u0010\u009f\u0002R,\u0010æ\u0002\u001a\u0005\u0018\u00010\u0085\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bæ\u0002\u0010ç\u0002\u001a\u0006\bè\u0002\u0010é\u0002\"\u0006\bê\u0002\u0010ë\u0002R\u0019\u0010ì\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0002\u0010\u009f\u0002R\u0019\u0010í\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0002\u0010\u009f\u0002R\u0019\u0010î\u0002\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0002\u0010³\u0002R\u0019\u0010ï\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0002\u0010¼\u0002R\u0019\u0010ð\u0002\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0002\u0010¼\u0002R\u001b\u0010ñ\u0002\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0002\u0010ò\u0002R\u0019\u0010ó\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0002\u0010\u009f\u0002R\u0019\u0010ô\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0002\u0010\u009f\u0002R'\u0010õ\u0002\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0006\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0002\u0010ö\u0002R\u0019\u0010÷\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0002\u0010\u009f\u0002R\u0016\u0010ù\u0002\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bø\u0002\u0010GR\u0016\u0010û\u0002\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bú\u0002\u0010GR\u0016\u0010ý\u0002\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\bü\u0002\u0010GR\u0016\u0010ÿ\u0002\u001a\u00020;8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\bþ\u0002\u0010iR\u0018\u0010\u0082\u0003\u001a\u00030½\u00028DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0080\u0003\u0010\u0081\u0003R\u0018\u0010\u0086\u0003\u001a\u00030\u0083\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0084\u0003\u0010\u0085\u0003R\u0018\u0010\u0088\u0003\u001a\u00030\u0085\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0087\u0003\u0010é\u0002R\u0018\u0010\u008c\u0003\u001a\u00030\u0089\u00038DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u008a\u0003\u0010\u008b\u0003R\u0018\u0010\u008e\u0003\u001a\u00030\u0085\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u008d\u0003\u0010é\u0002R\u0016\u0010\u0090\u0003\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0003\u0010GR\u0013\u0010\u0092\u0003\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\b\u0091\u0003\u0010GR\u0014\u0010\u0094\u0003\u001a\u0002008F¢\u0006\b\u001a\u0006\b\u0093\u0003\u0010¸\u0001R\u001b\u0010\u0098\u0003\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0095\u00038F¢\u0006\b\u001a\u0006\b\u0096\u0003\u0010\u0097\u0003R\u0013\u0010\u009a\u0003\u001a\u00020\u00148F¢\u0006\u0007\u001a\u0005\b\u0099\u0003\u0010gR\u0014\u0010\u009c\u0003\u001a\u0002008F¢\u0006\b\u001a\u0006\b\u009b\u0003\u0010¸\u0001R\u0018\u0010 \u0003\u001a\u00030\u009d\u00038TX\u0094\u0004¢\u0006\b\u001a\u0006\b\u009e\u0003\u0010\u009f\u0003R\u0013\u0010¢\u0003\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\b¡\u0003\u0010G¨\u0006¦\u0003"}, d2 = {"Lcom/stepos/ailauncher/sheet/O;", "Landroidx/appcompat/app/d;", "<init>", "()V", "", "reason", "LY8/t;", "H3", "(Ljava/lang/String;)V", "d4", "Lkotlin/Function0;", "onEnterEnd", "d3", "(Lp9/a;)V", "", "animate", "F1", "(Z)V", "inPreview", "N0", "", "cornerDp", "reattachGlass", "M0", "(FZ)V", "Landroid/view/View;", "v", "m1", "(Landroid/view/View;)V", "V0", "z0", "A0", "S0", "J0", "F3", "Landroid/content/Intent;", "intent", "B3", "(Landroid/content/Intent;)Z", "G3", "e3", "U0", "y3", "extra", "onAllEnded", "s2", "(ZLp9/a;)Lp9/a;", "U3", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "k4", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "G0", "h4", "Landroidx/core/view/a0;", "insets", "g4", "(Landroidx/core/view/a0;)V", "Lkotlin/Function1;", "", "delegate", "X0", "(Lp9/l;)V", "k1", "u3", "fromAnimationFrame", "E0", "(Landroidx/core/view/a0;Z)V", "L0", "A3", "o2", "()Z", "e2", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "Q3", "(F)V", "target", "enter", "v0", "x3", "i4", "I1", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "proposed", "imeGeometryHeight", "imeFraction", "D3", "(FIF)F", "S3", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;Z)V", "onEnd", "b3", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/stepos/ailauncher/sheet/f0;", "motion", "floatingBottom", "m3", "(Lcom/stepos/ailauncher/sheet/f0;ZLp9/a;)V", "W2", "i2", "()F", "j2", "()I", "n4", "m4", "Q0", "i1", "Z0", "hidden", "P3", "q2", "b1", "z2", "f2", SdCardDbCreator.FIELD_LASTLOC_NB, "j1", "t3", "T2", "h1", "f1", "X3", "d2", "O2", "K1", "e4", "f4", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/sheet/j;", "c2", "()Lcom/stepos/ailauncher/sheet/j;", "Landroid/widget/FrameLayout;", "container", "Landroid/os/Bundle;", "savedInstanceState", "F2", "(Landroid/widget/FrameLayout;Landroid/os/Bundle;)V", "", "R3", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)Ljava/lang/CharSequence;", "S2", "fraction", "R2", "progress", "P2", "Q2", "visible", "K2", "Z3", "Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "x1", "()Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "h2", "Lcom/stepos/ailauncher/sheet/g0;", "s1", "()Lcom/stepos/ailauncher/sheet/g0;", "Lcom/stepos/ailauncher/sheet/e0;", "p1", "()Lcom/stepos/ailauncher/sheet/e0;", "t1", "()Lcom/stepos/ailauncher/sheet/f0;", "w1", "v1", "o1", "z1", "n1", "()Ljava/lang/Integer;", "D1", "E1", "L1", "l4", "y1", "x2", "C0", "Lkotlin/Pair;", "sheetLook", "l1", "(Lkotlin/Pair;)V", "A1", "H2", "G2", "u1", "()Lcom/stepos/ailauncher/sheet/SheetSettleState;", "L2", "onCreate", "(Landroid/os/Bundle;)V", "c1", "allowOrientation", "restoreTo", "q1", "(ZLcom/stepos/ailauncher/sheet/SheetSettleState;)V", "B1", TaskWebView.EDGE_SPACER_TRANSPARENT, "J3", "u2", "w2", "B0", "toAlpha", "fromAlpha", "p3", "(FLjava/lang/Float;Ljava/lang/String;Lp9/a;)V", "c4", "(FLjava/lang/String;)V", "b4", SdCardDbCreator.FIELD_LASTLOC_ID, "defaultPadding", "imeHeight", "C3", "(II)I", x5.d.EXTRA_ENABLED, "I3", "v2", "()Landroid/view/View;", "o4", "M3", "M2", "handleView", "setSheetDragGestureHandleView", "view", "setSheetDragPriorityView", "O3", "extend", "L3", "w3", "N2", "startActivity", "(Landroid/content/Intent;)V", "options", "(Landroid/content/Intent;Landroid/os/Bundle;)V", "g1", "r3", "s3", "()Ljava/lang/Float;", "offsetPx", "P0", "(FF)V", "positionPx", "D0", "H1", "T0", "W0", "v3", "Landroid/widget/FrameLayout$LayoutParams;", "params", "u0", "(Landroid/view/View;Landroid/widget/FrameLayout$LayoutParams;)V", "g2", "z3", "onLift", "e1", "keyboardVisible", "I2", "keyboardHeightPx", "J2", "(I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onEnterAnimationComplete", "hasFocus", "onWindowFocusChanged", "onResume", "W3", "onPause", "onStop", "k2", "r2", "R0", "O0", "E3", "m2", "Y3", "V3", "onDestroy", "J1", "finish", "Y0", "V2", "Lh6/a;", "binding", "Lh6/a;", "registeredUniqueInstanceKey", "Ljava/lang/String;", "finishingWithAnim", "Z", UxipConstants.f30680s, "nineSplitExitStarted", "R1", "exitTouchReleased", "enterTransitionRunning", "enterTransitionCompleted", "finishWithExitAnimRequested", "Landroidx/dynamicanimation/animation/i;", "dimSpring", "Landroidx/dynamicanimation/animation/i;", "exitColorAnim", "Landroid/animation/Animator;", "nineSplitExitColorAnim", "Landroid/animation/Animator;", "dragHandleAlphaAnim", "dismissAnimator", "holdWindowForExitAnim", "homeGroupExitPrepared", "homeGroupExitStartDimAlpha", "F", "homeGroupExitDistancePx", "Lcom/stepos/ailauncher/sheet/O$b;", "sharedExitInteractionState", "Lcom/stepos/ailauncher/sheet/O$b;", "Ly7/E;", "panelGlassHandle", "Ly7/E;", "_layerIndex", "I", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "_heightMode", "Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "previewMode", "lastImmersiveFraction", "previewRestoreState", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", "previewAllowOrientation", "previewSavedOrientation", "previewSavedFullTopRatio", "previewSavedPanelTopPad", "previewSavedContentHPad", "previewExitPendingPortrait", "previewChromeCornerDp", "Landroid/graphics/drawable/Drawable;", "previewSavedPanelBackground", "Landroid/graphics/drawable/Drawable;", "previewSavedBottomPad", "previewSavedContentBottomPad", "previewSavedContentTopPad", "chromeTransparent", "chromeSavedPanelBackground", "maskPassthrough", "hiddenForRecentsPeek", "stackCoverContentHidden", "Lcom/stepos/ailauncher/sheet/t0;", "stackPauseHandoff", "Lcom/stepos/ailauncher/sheet/t0;", "pendingEnterAnimation", "Lp9/a;", "Ljava/lang/Runnable;", "deferredEnterTimeout", "Ljava/lang/Runnable;", "passthroughObservedView", "Landroid/view/View;", "Landroid/view/View$OnLayoutChangeListener;", "passthroughLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "dragHandleWanted", "halfSettleWanted", "contentExtendsToBottomEdge", "residentBottomSlot", "Landroid/widget/FrameLayout;", "T1", "()Landroid/widget/FrameLayout;", "K3", "(Landroid/widget/FrameLayout;)V", "imeVisible", "imeAnimationDeferringGeometry", "imeAnimationFraction", "imeGeometryHeightAtAnimationStart", "lastGeometryKeyboardHeight", "lastWindowInsets", "Landroidx/core/view/a0;", "imeGeometryPinnedForDialog", "dialogHoldsKeyboard", "imeLiftDelegate", "Lp9/l;", "imeLiftReleasePending", "b2", "usesHomeDim", "P1", "imeGeometryPinStale", "p2", "isSheetExitRunning", "Q1", "layerIndex", "O1", "()Lcom/stepos/ailauncher/sheet/SheetHeightMode;", "heightMode", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "X1", "()Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout;", "sheetLayout", "M1", "contentContainer", "Landroid/view/ViewGroup;", "Y1", "()Landroid/view/ViewGroup;", "sheetPanel", "Z1", "sheetRoot", "U1", "residentSlotPinnedToRoot", "n2", "isPreviewMode", "N1", "currentSettleState", "LXa/t;", "V1", "()LXa/t;", "scaleEnterRunning", "W1", "sheetHalfFullFraction", "S1", "presentationSettleState", "Lcom/stepos/ailauncher/sheet/s0;", SdCardDbCreator.FIELD_LASTLOC_INFO, "()Lcom/stepos/ailauncher/sheet/s0;", "stack", "l2", "isMaskTouchPassthrough", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class O extends androidx.appcompat.app.d {
    private static final long DEFERRED_ENTER_TIMEOUT_MS = 1200;
    private static final float HALF_EXIT_TOUCH_RELEASE_PROGRESS = 0.6f;
    private static final float HOME_GROUP_EXIT_SAFETY_MARGIN_DP = 2.0f;
    private static final String TAG = "LiteSheetActivity";
    private static final String TAG_ENTER = "LiteSheetEnter";
    private C4145a binding;
    private Drawable chromeSavedPanelBackground;
    private boolean chromeTransparent;
    private boolean contentExtendsToBottomEdge;
    private boolean dialogHoldsKeyboard;
    private androidx.dynamicanimation.animation.i dimSpring;
    private Animator dismissAnimator;
    private androidx.dynamicanimation.animation.i dragHandleAlphaAnim;
    private boolean enterTransitionCompleted;
    private boolean enterTransitionRunning;
    private androidx.dynamicanimation.animation.i exitColorAnim;
    private boolean exitTouchReleased;
    private boolean finishWithExitAnimRequested;
    private boolean finishingWithAnim;
    private volatile boolean hiddenForRecentsPeek;
    private boolean holdWindowForExitAnim;
    private float homeGroupExitDistancePx;
    private boolean homeGroupExitPrepared;
    private float homeGroupExitStartDimAlpha;
    private boolean imeAnimationDeferringGeometry;
    private float imeAnimationFraction;
    private int imeGeometryHeightAtAnimationStart;
    private boolean imeGeometryPinnedForDialog;
    private InterfaceC5074l<? super Integer, Y8.t> imeLiftDelegate;
    private boolean imeLiftReleasePending;
    private boolean imeVisible;
    private int lastGeometryKeyboardHeight;
    private androidx.core.view.a0 lastWindowInsets;
    private boolean maskPassthrough;
    private Animator nineSplitExitColorAnim;
    private boolean nineSplitExitStarted;
    private y7.E panelGlassHandle;
    private View passthroughObservedView;
    private InterfaceC5063a<Y8.t> pendingEnterAnimation;
    private boolean previewAllowOrientation;
    private boolean previewExitPendingPortrait;
    private boolean previewMode;
    private int previewSavedBottomPad;
    private int previewSavedContentBottomPad;
    private int previewSavedContentHPad;
    private int previewSavedContentTopPad;
    private Drawable previewSavedPanelBackground;
    private int previewSavedPanelTopPad;
    private String registeredUniqueInstanceKey;
    private FrameLayout residentBottomSlot;
    private SharedExitInteractionState sharedExitInteractionState;
    private boolean stackCoverContentHidden;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object UNIQUE_INSTANCE_LOCK = new Object();
    private static final Map<String, List<WeakReference<O>>> UNIQUE_INSTANCES = new LinkedHashMap();
    private int _layerIndex = 1;
    private SheetHeightMode _heightMode = SheetHeightMode.FULL_9;
    private float lastImmersiveFraction = -1.0f;
    private SheetSettleState previewRestoreState = SheetSettleState.FULL;
    private int previewSavedOrientation = -1;
    private float previewSavedFullTopRatio = 0.06f;
    private float previewChromeCornerDp = 28.0f;
    private final t0 stackPauseHandoff = new t0();
    private final Runnable deferredEnterTimeout = new Runnable() { // from class: com.stepos.ailauncher.sheet.L
        @Override // java.lang.Runnable
        public final void run() {
            O.d1(this.f27678a);
        }
    };
    private final View.OnLayoutChangeListener passthroughLayoutListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.sheet.M
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            O.U2(this.f27679a, view, i10, i11, i12, i13, i14, i15, i16, i17);
        }
    };
    private boolean dragHandleWanted = true;
    private boolean halfSettleWanted = true;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R,\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/sheet/O$a;", "", "<init>", "()V", "", "key", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "TAG_ENTER", "", "DEFERRED_ENTER_TIMEOUT_MS", "J", "", "HOME_GROUP_EXIT_SAFETY_MARGIN_DP", "F", "HALF_EXIT_TOUCH_RELEASE_PROGRESS", "UNIQUE_INSTANCE_LOCK", "Ljava/lang/Object;", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/sheet/O;", "UNIQUE_INSTANCES", "Ljava/util/Map;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.O$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(String key) {
            List listM;
            if (key != null) {
                if (La.H.x0(key)) {
                    key = null;
                }
                if (key == null) {
                    return;
                }
                synchronized (O.UNIQUE_INSTANCE_LOCK) {
                    try {
                        List list = (List) O.UNIQUE_INSTANCES.get(key);
                        if (list == null) {
                            listM = C1173v.m();
                        } else {
                            ArrayList arrayList = new ArrayList();
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                O o10 = (O) ((WeakReference) it.next()).get();
                                if (o10 == null || o10.isDestroyed() || o10.isFinishing()) {
                                    it.remove();
                                } else if (!o10.isChangingConfigurations()) {
                                    arrayList.add(o10);
                                    it.remove();
                                }
                            }
                            if (list.isEmpty()) {
                                O.UNIQUE_INSTANCES.remove(key);
                            }
                            listM = arrayList;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator it2 = listM.iterator();
                while (it2.hasNext()) {
                    ((O) it2.next()).I1();
                }
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/sheet/O$b;", "", "", LinkHeader.Parameters.Anchor, DidiCardProvider.ACTION_DISMISS, ChatTracker.TRIGGER_DRAG, "<init>", "(ZZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "c", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sheet.O$b, reason: from toString */
    public static final /* data */ class SharedExitInteractionState {
        private final boolean anchor;
        private final boolean dismiss;
        private final boolean drag;

        public SharedExitInteractionState(boolean z10, boolean z11, boolean z12) {
            this.anchor = z10;
            this.dismiss = z11;
            this.drag = z12;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAnchor() {
            return this.anchor;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getDismiss() {
            return this.dismiss;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getDrag() {
            return this.drag;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedExitInteractionState)) {
                return false;
            }
            SharedExitInteractionState sharedExitInteractionState = (SharedExitInteractionState) other;
            return this.anchor == sharedExitInteractionState.anchor && this.dismiss == sharedExitInteractionState.dismiss && this.drag == sharedExitInteractionState.drag;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.anchor) * 31) + Boolean.hashCode(this.dismiss)) * 31) + Boolean.hashCode(this.drag);
        }

        public String toString() {
            return "SharedExitInteractionState(anchor=" + this.anchor + ", dismiss=" + this.dismiss + ", drag=" + this.drag + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[SheetSettleState.values().length];
            try {
                iArr[SheetSettleState.HALF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetSettleState.FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SheetHeightMode.values().length];
            try {
                iArr2[SheetHeightMode.FULL_9.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[SheetHeightMode.HALF_EXPANDABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SheetHeightMode.MINIFY_EXPANDABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SheetExitAnim.values().length];
            try {
                iArr3[SheetExitAnim.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[SheetExitAnim.SLIDE_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[SheetExitAnim.NAV_HANDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[SheetExitAnim.MorphToBar.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[SheetExitAnim.SPRING_SCALE_DOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/sheet/O$d", "Landroidx/core/view/Z$b;", "Landroidx/core/view/Z;", "animation", "LY8/t;", "c", "(Landroidx/core/view/Z;)V", "Landroidx/core/view/a0;", "insets", "", "runningAnimations", Const.INTENT_KEY_UMID, "(Landroidx/core/view/a0;Ljava/util/List;)Landroidx/core/view/a0;", Const.INTENT_KEY_PKGNAME, "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends Z.b {
        public d() {
            super(1);
        }

        @Override // androidx.core.view.Z.b
        public void b(androidx.core.view.Z animation) throws Resources.NotFoundException {
            InterfaceC5074l interfaceC5074l;
            kotlin.jvm.internal.p.i(animation, "animation");
            if ((animation.d() & a0.o.b()) == 0) {
                return;
            }
            O.this.k1();
            if (O.this.previewMode || !O.this.imeLiftReleasePending || (interfaceC5074l = O.this.imeLiftDelegate) == null) {
                return;
            }
            O.this.X0(interfaceC5074l);
        }

        @Override // androidx.core.view.Z.b
        public void c(androidx.core.view.Z animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (O.this.previewMode || (animation.d() & a0.o.b()) == 0) {
                return;
            }
            O o10 = O.this;
            o10.imeGeometryHeightAtAnimationStart = o10.lastGeometryKeyboardHeight;
            O.this.imeAnimationDeferringGeometry = true;
            O.this.imeAnimationFraction = 0.0f;
        }

        @Override // androidx.core.view.Z.b
        public androidx.core.view.a0 d(androidx.core.view.a0 insets, List<androidx.core.view.Z> runningAnimations) throws Resources.NotFoundException {
            Object next;
            kotlin.jvm.internal.p.i(insets, "insets");
            kotlin.jvm.internal.p.i(runningAnimations, "runningAnimations");
            Iterator<T> it = runningAnimations.iterator();
            while (true) {
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
            if (!O.this.previewMode && z10 != null) {
                O.this.imeAnimationFraction = z10.c();
                O.this.h4();
                O.this.E0(insets, true);
            }
            return insets;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/sheet/O$e", "Lcom/stepos/ailauncher/sheet/widget/DraggableSheetLayout$a;", "LY8/t;", Const.INTENT_KEY_UMID, "()V", "", "progress", Const.INTENT_KEY_APIKEY, "(F)V", "c", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements DraggableSheetLayout.a {
        public e() {
        }

        @Override // com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.a
        public void a(float progress) {
            float immersiveFraction = O.this.X1().getImmersiveFraction();
            if (immersiveFraction != O.this.lastImmersiveFraction) {
                O.this.lastImmersiveFraction = immersiveFraction;
                O.this.R2(immersiveFraction);
            }
            if (O.this.finishingWithAnim || O.this.previewMode) {
                return;
            }
            if (O.this.maskPassthrough) {
                O.this.J0();
            }
            O.this.P2(progress);
            if (!O.this.enterTransitionRunning) {
                O.this.a2().t(O.this, progress);
            }
            if (O.this.b2()) {
                C4145a c4145a = O.this.binding;
                C4145a c4145a2 = null;
                if (c4145a == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c4145a = null;
                }
                if (c4145a.ailDimView.getVisibility() != 0) {
                    return;
                }
                C4145a c4145a3 = O.this.binding;
                if (c4145a3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c4145a2 = c4145a3;
                }
                c4145a2.ailDimView.setAlpha(C5685n.m(1.0f - progress, 0.0f, 1.0f) * O.this.i2());
            }
        }

        @Override // com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.a
        public void b(SheetSettleState state) {
            kotlin.jvm.internal.p.i(state, "state");
            O.this.k4(state);
            O.this.S2(state);
            if (O.this.maskPassthrough) {
                O.this.J0();
            }
        }

        @Override // com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.a
        public void c() throws Resources.NotFoundException {
            if (!O.this.O2()) {
                O.this.g1();
            } else {
                O o10 = O.this;
                o10.S3(o10.N1(), true);
            }
        }

        @Override // com.stepos.ailauncher.sheet.widget.DraggableSheetLayout.a
        public void d() {
            if (!O.this.enterTransitionRunning || O.this.finishingWithAnim || O.this.isFinishing() || O.this.isDestroyed() || !O.this.a2().y(O.this)) {
                return;
            }
            Log.i(O.TAG_ENTER, "first rebound → cover underlay (" + O.this.getClass().getSimpleName() + ")");
            O.this.a2().A(O.this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/sheet/O$f", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends AbstractC1417G {
        public f() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() throws Resources.NotFoundException {
            if (O.this.N2()) {
                return;
            }
            O.this.g1();
        }
    }

    public static final void A2(O o10) {
        if (o10.isDestroyed() || o10.finishingWithAnim || o10.chromeTransparent) {
            return;
        }
        com.stepos.ailauncher.sheet.internal.D d10 = com.stepos.ailauncher.sheet.internal.D.INSTANCE;
        d10.e(o10.panelGlassHandle);
        o10.panelGlassHandle = com.stepos.ailauncher.sheet.internal.D.b(d10, o10.Y1(), o10.T2(), null, null, 12, null);
    }

    public static final void B2(O o10, View view) throws Resources.NotFoundException {
        o10.d2();
    }

    public static /* synthetic */ void C1(O o10, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitPreviewMode");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        o10.B1(z10);
    }

    public static final void C2(final O o10) throws Resources.NotFoundException {
        o10.enterTransitionRunning = true;
        o10.X1().setDragEnabled(false);
        o10.a2().B();
        final InterfaceC5063a<Y8.t> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return O.D2(this.f28207a);
            }
        };
        if (o10.Z3()) {
            Log.i(TAG_ENTER, "skip spring → settle " + o10.u1() + " (" + o10.getClass().getSimpleName() + ")");
            DraggableSheetLayout.y1(o10.X1(), o10.u1(), false, null, 4, null);
            o10.z0();
            interfaceC5063a.invoke();
            return;
        }
        o10.H2();
        if (!o10.c1() || o10.hasWindowFocus()) {
            o10.d3(interfaceC5063a);
            return;
        }
        o10.X1().setVisibility(4);
        o10.pendingEnterAnimation = new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return O.E2(this.f28209a, interfaceC5063a);
            }
        };
        o10.getWindow().getDecorView().postDelayed(o10.deferredEnterTimeout, 1200L);
        Log.i(TAG_ENTER, "defer spring until window visible (" + o10.getClass().getSimpleName() + ")");
    }

    public static final Y8.t D2(O o10) {
        o10.enterTransitionCompleted = true;
        o10.enterTransitionRunning = false;
        o10.X1().setDragEnabled(true);
        if (o10.b2()) {
            o10.v0(o10.i2(), true);
        }
        if (o10.a2().R() > 1) {
            o10.a2().W();
        }
        o10.G2();
        return Y8.t.f7040a;
    }

    public static final Y8.t E2(O o10, InterfaceC5063a interfaceC5063a) throws Resources.NotFoundException {
        o10.d3(interfaceC5063a);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void F0(O o10, androidx.core.view.a0 a0Var, boolean z10, int i10, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyImeFrame");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        o10.E0(a0Var, z10);
    }

    public static final Y8.t G1(O o10) {
        o10.L2(false);
        return Y8.t.f7040a;
    }

    public static final androidx.core.view.a0 H0(O o10, View view, androidx.core.view.a0 insets) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        o10.lastWindowInsets = insets;
        o10.g4(insets);
        if (o10.previewMode) {
            o10.Y1().setPadding(0, 0, 0, 0);
            o10.M1().setPadding(0, 0, 0, 0);
            return androidx.core.view.a0.f13159b;
        }
        if (!o10.hiddenForRecentsPeek) {
            o10.L0(insets);
        }
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        o10.Y1().setPadding(o10.Y1().getPaddingLeft(), o10.Y1().getPaddingTop(), o10.Y1().getPaddingRight(), (o10.h1() || o10.b4()) ? o10.getResources().getDimensionPixelSize(R$dimen.ail_sheet_content_padding) : eVarF.f41980d + o10.getResources().getDimensionPixelSize(R$dimen.ail_sheet_content_padding));
        F0(o10, insets, false, 2, null);
        o10.X1().setFullTopRatio(Math.max(0.06f, (eVarF.f41978b / o10.getResources().getDisplayMetrics().heightPixels) + 0.02f));
        if (o10.maskPassthrough) {
            o10.J0();
        }
        return insets;
    }

    private final void H3(String reason) {
        Window window = getWindow();
        if (window == null || Y3()) {
            return;
        }
        int i10 = window.getAttributes().flags;
        WindowFocusRestoreAction windowFocusRestoreActionD = V.d((i10 & 8) != 0, (i10 & 16) != 0, m2(), this.maskPassthrough, isFinishing() || isDestroyed());
        if (windowFocusRestoreActionD == null) {
            return;
        }
        if (windowFocusRestoreActionD.getClearNotFocusable()) {
            window.clearFlags(8);
        }
        if (windowFocusRestoreActionD.getClearNotTouchable()) {
            window.clearFlags(16);
        }
        if (windowFocusRestoreActionD.getEnableInputSink()) {
            C3442a.INSTANCE.a(this, true);
        }
        Log.w(TAG, "restoreWindowFocusIfNeeded reason=" + reason + " clearFocus=" + windowFocusRestoreActionD.getClearNotFocusable() + " clearTouch=" + windowFocusRestoreActionD.getClearNotTouchable() + " sink=" + windowFocusRestoreActionD.getEnableInputSink());
    }

    public static final void I0(O o10) throws Resources.NotFoundException {
        if (o10.isDestroyed() || o10.previewMode || o10.hiddenForRecentsPeek) {
            return;
        }
        if (o10.maskPassthrough) {
            o10.J0();
        } else {
            o10.L0(androidx.core.view.N.B(o10.getWindow().getDecorView()));
        }
    }

    public static final void K0(O o10) {
        if (o10.maskPassthrough) {
            o10.J0();
        }
    }

    public static final Y8.t N3(O o10, FrameLayout frameLayout) {
        if (!o10.isDestroyed() && !o10.dragHandleWanted) {
            frameLayout.setVisibility(8);
            Log.i("DragHandleAlpha", "setVisible GONE after fadeOut");
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void T3(O o10, SheetSettleState sheetSettleState, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: settleSheetTo");
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        o10.S3(sheetSettleState, z10);
    }

    public static final void U2(O o10, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (o10.maskPassthrough) {
            o10.J0();
        }
    }

    public static final void W(O o10, View view) throws Resources.NotFoundException {
        o10.d2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void X2(O o10, InterfaceC5063a interfaceC5063a, int i10, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playBarClipEnter");
        }
        if ((i10 & 1) != 0) {
            interfaceC5063a = null;
        }
        o10.W2(interfaceC5063a);
    }

    public static final Y8.t Y2(O o10, InterfaceC5063a interfaceC5063a) {
        o10.X1().setDragEnabled(true);
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t Z2(View view, O o10, float f10) {
        view.setAlpha(f10 * o10.i2());
        return Y8.t.f7040a;
    }

    public static final Y8.t a3(O o10) {
        o10.X1().setDragEnabled(true);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c3(O o10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playEnterFromBottom");
        }
        if ((i10 & 1) != 0) {
            interfaceC5063a = null;
        }
        o10.b3(interfaceC5063a);
    }

    public static final void d1(O o10) {
        o10.d4("timeout");
    }

    public static final Y8.t f3(O o10, float f10, float f11) {
        if (o10.b2()) {
            C4145a c4145a = o10.binding;
            C4145a c4145a2 = null;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            if (c4145a.ailDimView.getVisibility() == 0) {
                C4145a c4145a3 = o10.binding;
                if (c4145a3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c4145a2 = c4145a3;
                }
                c4145a2.ailDimView.setAlpha(f10 * (1.0f - f11));
            }
        }
        o10.Q2(f11);
        return Y8.t.f7040a;
    }

    public static final Y8.t g3(O o10, boolean z10) {
        o10.dismissAnimator = null;
        if (!z10 && !o10.isDestroyed()) {
            o10.Y0();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t h3(Integer num, boolean z10, InterfaceC5074l interfaceC5074l, O o10, float f10) {
        if (num == null || !z10) {
            interfaceC5074l.invoke(Float.valueOf(f10));
        } else {
            o10.Q2(f10);
        }
        if (!z10 && f10 >= 0.6f) {
            o10.y3();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t i3(O o10, InterfaceC5063a interfaceC5063a) {
        o10.U0();
        androidx.dynamicanimation.animation.i iVar = o10.exitColorAnim;
        if (iVar != null) {
            iVar.d();
        }
        o10.exitColorAnim = null;
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t j3(boolean z10, O o10) {
        if (z10) {
            o10.y3();
        }
        return Y8.t.f7040a;
    }

    public static final boolean j4(O o10, WeakReference ref) {
        kotlin.jvm.internal.p.i(ref, "ref");
        O o11 = (O) ref.get();
        return o11 == null || o11 == o10;
    }

    public static final Y8.t k3(InterfaceC5074l interfaceC5074l, O o10, float f10) {
        interfaceC5074l.invoke(Float.valueOf(f10));
        o10.C0(a0.b(f10));
        return Y8.t.f7040a;
    }

    public static final Y8.t l3(InterfaceC5074l interfaceC5074l, boolean z10, boolean z11, O o10, Integer num, int i10, float f10) {
        interfaceC5074l.invoke(Float.valueOf(f10));
        if (z10 && !z11) {
            o10.C0(a0.b(f10));
        }
        if (!z10 && num != null) {
            float f11 = C3436d.f(f10);
            if (f11 > 0.0f) {
                C3436d.q(o10.Y1(), C3436d.i(i10, num.intValue(), f11));
            }
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void n3(O o10, SheetScaleMotion sheetScaleMotion, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playScaleEnter");
        }
        if ((i10 & 2) != 0) {
            z10 = o10.w1();
        }
        if ((i10 & 4) != 0) {
            interfaceC5063a = null;
        }
        o10.m3(sheetScaleMotion, z10, interfaceC5063a);
    }

    public static final Y8.t o3(O o10, InterfaceC5063a interfaceC5063a) {
        o10.X1().setDragEnabled(true);
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q3(O o10, float f10, Float f11, String str, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playSheetDragHandleAlpha");
        }
        if ((i10 & 2) != 0) {
            f11 = null;
        }
        if ((i10 & 4) != 0) {
            str = ChatTracker.CONTENT_SHEET;
        }
        if ((i10 & 8) != 0) {
            interfaceC5063a = null;
        }
        o10.p3(f10, f11, str, interfaceC5063a);
    }

    public static /* synthetic */ void r1(O o10, boolean z10, SheetSettleState sheetSettleState, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterPreviewMode");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            sheetSettleState = null;
        }
        o10.q1(z10, sheetSettleState);
    }

    public static final Y8.t t2(Ref$IntRef ref$IntRef, InterfaceC5063a interfaceC5063a) {
        int i10 = ref$IntRef.f34818a - 1;
        ref$IntRef.f34818a = i10;
        if (i10 <= 0) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t w0(O o10, float f10) {
        if (!o10.isDestroyed()) {
            C4145a c4145a = o10.binding;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            c4145a.ailDimView.setAlpha(f10);
        }
        return Y8.t.f7040a;
    }

    public static final void x0(O o10, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10 || o10.isDestroyed()) {
            return;
        }
        C4145a c4145a = o10.binding;
        C4145a c4145a2 = null;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        c4145a.ailDimView.setAlpha(0.0f);
        C4145a c4145a3 = o10.binding;
        if (c4145a3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4145a2 = c4145a3;
        }
        c4145a2.ailDimView.setVisibility(8);
    }

    public static final Y8.t y0(O o10, float f10) {
        if (!o10.isDestroyed()) {
            C4145a c4145a = o10.binding;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            c4145a.ailDimView.setAlpha(f10);
        }
        return Y8.t.f7040a;
    }

    public static final void y2(O o10) {
        if (!o10.previewMode || o10.isDestroyed()) {
            return;
        }
        DraggableSheetLayout.y1(o10.X1(), SheetSettleState.IMMERSIVE, false, null, 4, null);
        androidx.core.view.Y.a(o10.getWindow(), o10.getWindow().getDecorView()).a(a0.o.g());
    }

    public final void A0() {
        boolean z10 = this.previewMode;
        if (z10 || this.chromeTransparent) {
            Log.i("DragHandleAlpha", "exit skip preview=" + z10 + " chromeTransparent=" + this.chromeTransparent);
            return;
        }
        if (!this.dragHandleWanted) {
            Log.i("DragHandleAlpha", "exit skip wanted=false (page hides handle)");
            return;
        }
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        FrameLayout ailDragHandle = c4145a.ailDragHandle;
        kotlin.jvm.internal.p.h(ailDragHandle, "ailDragHandle");
        if (ailDragHandle.getVisibility() != 0) {
            Log.i("DragHandleAlpha", "exit force-VISIBLE was=" + ailDragHandle.getVisibility() + " alpha=" + ailDragHandle.getAlpha());
            ailDragHandle.setVisibility(0);
            if (ailDragHandle.getAlpha() < 0.01f) {
                ailDragHandle.setAlpha(0.34f);
            }
        }
        q3(this, 0.0f, null, "LiteSheet.exit", null, 10, null);
    }

    public SheetOffsetMotion A1() {
        if (get_layerIndex() > 1) {
            return i0.INSTANCE.w();
        }
        return null;
    }

    public final void A3() {
        if (isFinishing() || isDestroyed() || !this.hiddenForRecentsPeek || !o2()) {
            return;
        }
        O0();
        e2();
    }

    public final void B0(float fraction) {
        float fM = C5685n.m(fraction, 0.0f, 1.0f);
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        FrameLayout ailDragHandle = c4145a.ailDragHandle;
        kotlin.jvm.internal.p.h(ailDragHandle, "ailDragHandle");
        ailDragHandle.setVisibility(0);
        Integer numValueOf = Integer.valueOf(M1().getHeight());
        ailDragHandle.setTranslationY(((numValueOf.intValue() > 0 ? numValueOf : null) != null ? r2.intValue() : getResources().getDimension(R$dimen.ail_sheet_content_top_inset)) * (1.0f - fM));
    }

    public final void B1(boolean animate) {
        if (!this.previewMode || this.finishingWithAnim || isDestroyed()) {
            return;
        }
        if (this.previewAllowOrientation) {
            boolean z10 = getResources().getConfiguration().orientation == 2;
            int i10 = this.previewSavedOrientation;
            if (i10 == -1) {
                i10 = 1;
            }
            setRequestedOrientation(i10);
            if (z10) {
                this.previewExitPendingPortrait = true;
                return;
            }
        }
        F1(animate);
    }

    public final boolean B3(Intent intent) {
        if (!kotlin.jvm.internal.p.d(intent.getAction(), "android.intent.action.CHOOSER")) {
            return false;
        }
        Intent intentAddFlags = new Intent(intent).addFlags(402653184);
        kotlin.jvm.internal.p.h(intentAddFlags, "addFlags(...)");
        super.startActivity(intentAddFlags, null);
        return true;
    }

    public void C0(float alpha) {
        M1().setAlpha(alpha);
    }

    public int C3(int defaultPadding, int imeHeight) {
        return defaultPadding;
    }

    public void D0(float positionPx, float progress) {
        if (!this.homeGroupExitPrepared || isDestroyed()) {
            return;
        }
        float fM = C5685n.m(progress, 0.0f, 1.0f);
        X1().setHomeGroupExitOffsetY(this.homeGroupExitDistancePx * fM);
        if (b2()) {
            C4145a c4145a = this.binding;
            C4145a c4145a2 = null;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            if (c4145a.ailDimView.getVisibility() == 0) {
                C4145a c4145a3 = this.binding;
                if (c4145a3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c4145a2 = c4145a3;
                }
                c4145a2.ailDimView.setAlpha(this.homeGroupExitStartDimAlpha * (1.0f - fM));
            }
        }
        Q2(fM);
    }

    public SheetScaleMotion D1() {
        return null;
    }

    public float D3(float proposed, int imeGeometryHeight, float imeFraction) {
        return proposed;
    }

    public final void E0(androidx.core.view.a0 insets, boolean fromAnimationFrame) throws Resources.NotFoundException {
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        t0.e eVarF2 = insets.f(a0.o.b());
        kotlin.jvm.internal.p.h(eVarF2, "getInsets(...)");
        boolean z10 = this.imeGeometryPinnedForDialog;
        int i10 = z10 ? 0 : eVarF2.f41980d;
        int i11 = z10 ? 0 : (!this.imeAnimationDeferringGeometry || fromAnimationFrame) ? i10 : this.imeGeometryHeightAtAnimationStart;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.ail_sheet_content_padding);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.ail_sheet_keyboard_gap);
        int i12 = (h1() || b4()) ? 0 : eVarF.f41980d;
        int i13 = this.imeLiftDelegate != null ? 0 : i11;
        if (i13 <= 0) {
            dimensionPixelSize2 = i12 + dimensionPixelSize;
        }
        int iC3 = (U1() || this.contentExtendsToBottomEdge) ? C3(dimensionPixelSize2, i13) : 0;
        FrameLayout frameLayout = this.residentBottomSlot;
        if (frameLayout != null) {
            if (frameLayout.getPaddingBottom() != iC3) {
                frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), iC3);
            }
            float fD3 = D3(U1() ? -i13 : 0.0f, i13, this.imeAnimationFraction);
            if (frameLayout.getTranslationY() != fD3) {
                frameLayout.setTranslationY(fD3);
            }
        }
        FrameLayout frameLayoutM1 = M1();
        int paddingLeft = M1().getPaddingLeft();
        int paddingTop = M1().getPaddingTop();
        int paddingRight = M1().getPaddingRight();
        if (this.contentExtendsToBottomEdge) {
            dimensionPixelSize2 = a1();
        }
        frameLayoutM1.setPadding(paddingLeft, paddingTop, paddingRight, dimensionPixelSize2);
        X1().setMinPanelTopForImePx(eVarF.f41978b);
        boolean z11 = i10 > 0;
        if (!fromAnimationFrame && z11 && !this.imeVisible) {
            I2(true);
        }
        X1().setImeInsetPx(i13);
        if (!fromAnimationFrame && !z11 && this.imeVisible) {
            I2(false);
        }
        if (this.maskPassthrough) {
            J0();
        }
        InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l = this.imeLiftDelegate;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Integer.valueOf(i11));
        }
        J2(C5685n.f(i11 - eVarF.f41980d, 0));
        if (!fromAnimationFrame && z11 != this.imeVisible) {
            this.imeVisible = z11;
            K2(z11);
        }
        this.lastGeometryKeyboardHeight = i11;
    }

    public boolean E1() {
        return false;
    }

    public void E3() throws Resources.NotFoundException {
        if (getWindowHiddenForQuickSwitch() || this.exitTouchReleased) {
            return;
        }
        this.hiddenForRecentsPeek = false;
        C3442a.INSTANCE.a(this, true);
        com.stepos.ailauncher.sheet.internal.J.INSTANCE.k(this.maskPassthrough);
        Window window = getWindow();
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        decorView.animate().cancel();
        window.clearFlags(24);
        Q3(1.0f);
        decorView.setVisibility(0);
        decorView.setAlpha(1.0f);
        F3();
        H3("restore-after-peek");
    }

    public final void F1(boolean animate) {
        this.previewExitPendingPortrait = false;
        this.previewMode = false;
        N0(false);
        X1().setStackPeekSuppressed(false);
        X1().setFullTopRatio(this.previewSavedFullTopRatio);
        X1().setDragEnabled(true);
        X1().setDismissEnabled(true);
        X1().setBottomAnchorEnabled(true);
        if (b2() && a2().y(this)) {
            v0(i2(), true);
        }
        X1().x1(this.previewRestoreState, animate, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return O.G1(this.f28275a);
            }
        });
    }

    public abstract void F2(FrameLayout container, Bundle savedInstanceState);

    public final void F3() throws Resources.NotFoundException {
        if (m2()) {
            return;
        }
        if (h1()) {
            L0(androidx.core.view.N.B(getWindow().getDecorView()));
            return;
        }
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        if (decorView.getWidth() <= 0 || decorView.getHeight() <= 0) {
            return;
        }
        com.stepos.ailauncher.sheet.internal.J j10 = com.stepos.ailauncher.sheet.internal.J.INSTANCE;
        Window window = getWindow();
        kotlin.jvm.internal.p.h(window, "getWindow(...)");
        com.stepos.ailauncher.sheet.internal.J.h(j10, window, new Region(0, 0, decorView.getWidth(), decorView.getHeight()), false, 4, null);
    }

    public final void G0() {
        C4145a c4145a = this.binding;
        C4145a c4145a2 = null;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        androidx.core.view.N.u0(c4145a.b(), new androidx.core.view.A() { // from class: com.stepos.ailauncher.sheet.z
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return O.H0(this.f28277a, view, a0Var);
            }
        });
        C4145a c4145a3 = this.binding;
        if (c4145a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a3 = null;
        }
        androidx.core.view.N.E0(c4145a3.b(), new d());
        C4145a c4145a4 = this.binding;
        if (c4145a4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4145a2 = c4145a4;
        }
        androidx.core.view.N.e0(c4145a2.b());
        getWindow().getDecorView().post(new Runnable() { // from class: com.stepos.ailauncher.sheet.A
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                O.I0(this.f27663a);
            }
        });
    }

    public void G2() {
    }

    public final void G3() {
        X1().setHomeGroupExitOffsetY(0.0f);
        if (b2()) {
            C4145a c4145a = this.binding;
            C4145a c4145a2 = null;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            if (c4145a.ailDimView.getVisibility() == 0) {
                C4145a c4145a3 = this.binding;
                if (c4145a3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c4145a2 = c4145a3;
                }
                c4145a2.ailDimView.setAlpha(this.homeGroupExitStartDimAlpha);
            }
        }
        Q2(0.0f);
        this.homeGroupExitPrepared = false;
        this.homeGroupExitDistancePx = 0.0f;
    }

    public void H1() {
        if (this.homeGroupExitPrepared) {
            a2().C(this);
            this.homeGroupExitPrepared = false;
            V2();
        }
    }

    public void H2() {
    }

    public final void I1() {
        if (isDestroyed() || isFinishing() || isChangingConfigurations()) {
            return;
        }
        this.finishingWithAnim = true;
        this.finishWithExitAnimRequested = false;
        this.holdWindowForExitAnim = false;
        a2().C(this);
        androidx.dynamicanimation.animation.i iVar = this.dimSpring;
        if (iVar != null) {
            iVar.d();
        }
        this.dimSpring = null;
        U0();
        androidx.dynamicanimation.animation.i iVar2 = this.exitColorAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        this.exitColorAnim = null;
        S0("finishImmediately");
        Animator animator = this.dismissAnimator;
        if (animator != null) {
            animator.removeAllListeners();
        }
        Animator animator2 = this.dismissAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.dismissAnimator = null;
        if (this.binding != null) {
            DraggableSheetLayout.P(X1(), false, 1, null);
            X1().c0();
            X1().setDismissEnabled(false);
        }
        V2();
    }

    public void I2(boolean keyboardVisible) {
    }

    public final void I3(boolean enabled) throws Resources.NotFoundException {
        if (this.previewMode || isDestroyed() || enabled == this.maskPassthrough) {
            return;
        }
        this.maskPassthrough = enabled;
        if (enabled) {
            com.stepos.ailauncher.sheet.internal.J.INSTANCE.k(true);
            if (b2()) {
                v0(0.0f, false);
            }
            J0();
            return;
        }
        com.stepos.ailauncher.sheet.internal.J.INSTANCE.k(false);
        V0();
        if (b2() && !this.finishingWithAnim && !this.previewMode && a2().y(this)) {
            v0(i2(), true);
        }
        F3();
    }

    public final void J0() {
        Region region;
        if (!this.maskPassthrough || isDestroyed() || this.previewMode || m2()) {
            return;
        }
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        int width = decorView.getWidth();
        int height = decorView.getHeight();
        if (width <= 0 || height <= 0) {
            decorView.post(new Runnable() { // from class: com.stepos.ailauncher.sheet.t
                @Override // java.lang.Runnable
                public final void run() {
                    O.K0(this.f28206a);
                }
            });
            return;
        }
        View viewV2 = v2();
        if (viewV2 == null || viewV2.getVisibility() != 0 || viewV2.getWidth() <= 0 || viewV2.getHeight() <= 0) {
            viewV2 = null;
        }
        if (viewV2 != null) {
            m1(viewV2);
            int[] iArr = new int[2];
            viewV2.getLocationInWindow(iArr);
            int i10 = iArr[0];
            region = new Region(i10, iArr[1], viewV2.getWidth() + i10, iArr[1] + viewV2.getHeight());
        } else {
            V0();
            region = new Region(0, C5685n.n((int) X1().getPanelTopPx(), 0, height), width, height);
        }
        com.stepos.ailauncher.sheet.internal.J j10 = com.stepos.ailauncher.sheet.internal.J.INSTANCE;
        Window window = getWindow();
        kotlin.jvm.internal.p.h(window, "getWindow(...)");
        j10.g(window, region, o4());
    }

    public final void J1() throws Resources.NotFoundException {
        this.finishWithExitAnimRequested = true;
        finish();
    }

    public void J2(int keyboardHeightPx) {
    }

    public final void J3(boolean transparent) {
        if (this.previewMode || isDestroyed() || transparent == this.chromeTransparent) {
            return;
        }
        this.chromeTransparent = transparent;
        X1().setChromeTransparent(transparent);
        C4145a c4145a = null;
        if (transparent) {
            this.chromeSavedPanelBackground = Y1().getBackground();
            com.stepos.ailauncher.sheet.internal.D.INSTANCE.e(this.panelGlassHandle);
            this.panelGlassHandle = null;
            Y1().setBackground(null);
            if (!w2()) {
                C4145a c4145a2 = this.binding;
                if (c4145a2 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c4145a2 = null;
                }
                c4145a2.ailDragHandle.setVisibility(8);
            }
            C4145a c4145a3 = this.binding;
            if (c4145a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a = c4145a3;
            }
            c4145a.ailSettleHint.setVisibility(8);
            return;
        }
        if (!u2()) {
            ViewGroup viewGroupY1 = Y1();
            Drawable drawableE = this.chromeSavedPanelBackground;
            if (drawableE == null) {
                drawableE = androidx.core.content.a.e(this, R$drawable.ail_bg_sheet);
            }
            viewGroupY1.setBackground(drawableE);
            M0(T2(), true);
        }
        this.chromeSavedPanelBackground = null;
        if (!w2()) {
            C4145a c4145a4 = this.binding;
            if (c4145a4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a4 = null;
            }
            c4145a4.ailDragHandle.setVisibility(this.dragHandleWanted ? 0 : 8);
            if (this.dragHandleWanted) {
                C4145a c4145a5 = this.binding;
                if (c4145a5 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c4145a = c4145a5;
                }
                C3440h.g(c4145a.ailDragHandle, "chromeOpaque");
            }
        }
        k4(X1().getSettleState());
    }

    public boolean K1() {
        return true;
    }

    public void K2(boolean visible) {
    }

    public final void K3(FrameLayout frameLayout) {
        this.residentBottomSlot = frameLayout;
    }

    public final void L0(androidx.core.view.a0 insets) throws Resources.NotFoundException {
        if (m2() || this.previewMode || this.maskPassthrough || !h1()) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.ail_nav_handle_min_bottom_inset);
        com.stepos.ailauncher.sheet.internal.J j10 = com.stepos.ailauncher.sheet.internal.J.INSTANCE;
        j10.j(insets, dimensionPixelSize);
        Window window = getWindow();
        kotlin.jvm.internal.p.h(window, "getWindow(...)");
        j10.d(window, dimensionPixelSize);
    }

    public boolean L1() {
        return false;
    }

    public void L2(boolean inPreview) {
    }

    public final void L3(boolean extend) {
        if (isDestroyed() || this.contentExtendsToBottomEdge == extend) {
            return;
        }
        this.contentExtendsToBottomEdge = extend;
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        androidx.core.view.N.e0(c4145a.b());
    }

    public final void M0(float cornerDp, boolean reattachGlass) {
        float f10 = getResources().getDisplayMetrics().density * cornerDp;
        Drawable background = Y1().getBackground();
        Drawable drawableMutate = background != null ? background.mutate() : null;
        GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadii(new float[]{f10, f10, f10, f10, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        com.stepos.ailauncher.sheet.internal.D d10 = com.stepos.ailauncher.sheet.internal.D.INSTANCE;
        d10.d(Y1(), cornerDp);
        if (reattachGlass && i1()) {
            d10.e(this.panelGlassHandle);
            this.panelGlassHandle = com.stepos.ailauncher.sheet.internal.D.b(d10, Y1(), cornerDp, null, null, 12, null);
        }
        Y1().invalidate();
    }

    public final FrameLayout M1() {
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        FrameLayout ailContentContainer = c4145a.ailContentContainer;
        kotlin.jvm.internal.p.h(ailContentContainer, "ailContentContainer");
        return ailContentContainer;
    }

    public final void M2() {
        if (isDestroyed() || this.previewMode || this.chromeTransparent || w2() || !this.dragHandleWanted) {
            return;
        }
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        FrameLayout ailDragHandle = c4145a.ailDragHandle;
        kotlin.jvm.internal.p.h(ailDragHandle, "ailDragHandle");
        ailDragHandle.setVisibility(0);
        androidx.dynamicanimation.animation.i iVar = this.dragHandleAlphaAnim;
        if (iVar == null || !iVar.i() || ailDragHandle.getAlpha() >= 0.34f) {
            float fM = C5685n.m(ailDragHandle.getAlpha(), 0.0f, 1.0f);
            if (fM >= 0.33f) {
                return;
            }
            q3(this, 0.34f, Float.valueOf(fM), "stackReveal.fadeIn", null, 8, null);
        }
    }

    public final void M3(boolean visible) {
        if (isDestroyed()) {
            return;
        }
        this.dragHandleWanted = visible;
        boolean z10 = this.previewMode;
        if (z10 || this.chromeTransparent) {
            Log.i("DragHandleAlpha", "setVisible skip apply visible=" + visible + " preview=" + z10 + " chromeTransparent=" + this.chromeTransparent);
            return;
        }
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        final FrameLayout ailDragHandle = c4145a.ailDragHandle;
        kotlin.jvm.internal.p.h(ailDragHandle, "ailDragHandle");
        if (!visible) {
            if (ailDragHandle.getVisibility() == 0 && ailDragHandle.getAlpha() >= 0.01f) {
                q3(this, 0.0f, null, "setVisible.fadeOut", new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.s
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return O.N3(this.f28204a, ailDragHandle);
                    }
                }, 2, null);
                return;
            }
            S0("setVisible(false).alreadyHidden");
            ailDragHandle.setVisibility(8);
            ailDragHandle.setAlpha(0.0f);
            Log.i("DragHandleAlpha", "setVisible GONE immediate");
            return;
        }
        ailDragHandle.setVisibility(0);
        androidx.dynamicanimation.animation.i iVar = this.dragHandleAlphaAnim;
        if (iVar == null || !iVar.i()) {
            float fM = C5685n.m(ailDragHandle.getAlpha(), 0.0f, 1.0f);
            if (fM >= 0.33f) {
                C3440h.g(ailDragHandle, "setVisible.alreadyRest");
                return;
            } else {
                q3(this, 0.34f, Float.valueOf(fM), "setVisible.fadeIn", null, 8, null);
                return;
            }
        }
        Log.i("DragHandleAlpha", "setVisible VISIBLE keep-spring alpha=" + ailDragHandle.getAlpha());
    }

    public final void N0(boolean inPreview) {
        C4145a c4145a = this.binding;
        C4145a c4145a2 = null;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        FrameLayout ailDragHandle = c4145a.ailDragHandle;
        kotlin.jvm.internal.p.h(ailDragHandle, "ailDragHandle");
        C4145a c4145a3 = this.binding;
        if (c4145a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a3 = null;
        }
        TextView ailSettleHint = c4145a3.ailSettleHint;
        kotlin.jvm.internal.p.h(ailSettleHint, "ailSettleHint");
        androidx.core.view.b0 b0VarA = androidx.core.view.Y.a(getWindow(), getWindow().getDecorView());
        kotlin.jvm.internal.p.h(b0VarA, "getInsetsController(...)");
        if (inPreview) {
            ailDragHandle.setVisibility(8);
            ailSettleHint.setVisibility(8);
            com.stepos.ailauncher.sheet.internal.D.INSTANCE.e(this.panelGlassHandle);
            this.panelGlassHandle = null;
            Y1().setPadding(0, 0, 0, 0);
            M1().setPadding(0, 0, 0, 0);
            Y1().setBackground(new ColorDrawable(-16777216));
            M0(0.0f, false);
            b0VarA.f(2);
            b0VarA.a(a0.o.g());
            b0VarA.e(false);
            b0VarA.d(false);
            return;
        }
        ailDragHandle.setVisibility(this.dragHandleWanted ? 0 : 8);
        if (this.dragHandleWanted) {
            C3440h.g(ailDragHandle, "exitPreview");
        }
        k4(X1().getSettleState());
        ViewGroup viewGroupY1 = Y1();
        Drawable drawableE = this.previewSavedPanelBackground;
        if (drawableE == null) {
            drawableE = androidx.core.content.a.e(this, R$drawable.ail_bg_sheet);
        }
        viewGroupY1.setBackground(drawableE);
        Y1().setPadding(Y1().getPaddingLeft(), this.previewSavedPanelTopPad, Y1().getPaddingRight(), this.previewSavedBottomPad);
        FrameLayout frameLayoutM1 = M1();
        int i10 = this.previewSavedContentHPad;
        frameLayoutM1.setPadding(i10, this.previewSavedContentTopPad, i10, this.previewSavedContentBottomPad);
        M0(this.previewChromeCornerDp, true);
        b0VarA.g(a0.o.g());
        C4145a c4145a4 = this.binding;
        if (c4145a4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4145a2 = c4145a4;
        }
        androidx.core.view.N.e0(c4145a2.b());
        Q0();
    }

    public final SheetSettleState N1() {
        return X1().getSettleState();
    }

    public boolean N2() {
        if (!this.previewMode) {
            return false;
        }
        C1(this, false, 1, null);
        return true;
    }

    public final void O0() {
        Window window;
        if (getWindowHiddenForQuickSwitch() || isFinishing() || isDestroyed() || !this.hiddenForRecentsPeek || (window = getWindow()) == null) {
            return;
        }
        View decorView = window.getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        decorView.animate().cancel();
        decorView.setAlpha(0.0f);
        if (V.c(o2())) {
            decorView.setVisibility(4);
            return;
        }
        Q3(V.a());
        decorView.setVisibility(0);
        Log.d(TAG, "peek decor stay mapped taskId=" + getTaskId());
    }

    /* renamed from: O1, reason: from getter */
    public final SheetHeightMode get_heightMode() {
        return this._heightMode;
    }

    public boolean O2() {
        return false;
    }

    public final void O3(boolean enabled) {
        if (isDestroyed() || !e4()) {
            return;
        }
        this.halfSettleWanted = enabled;
        X1().setAllowCollapseToHalf(enabled);
        if (enabled || this.previewMode) {
            return;
        }
        SheetSettleState settleState = X1().getSettleState();
        if (settleState == SheetSettleState.HALF || settleState == SheetSettleState.MINIFY) {
            DraggableSheetLayout.y1(X1(), SheetSettleState.FULL, true, null, 4, null);
        }
    }

    public final void P0(float offsetPx, float progress) {
        if (!this.homeGroupExitPrepared || isDestroyed()) {
            return;
        }
        X1().setHomeGroupExitOffsetY(offsetPx);
        if (b2()) {
            C4145a c4145a = this.binding;
            C4145a c4145a2 = null;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            if (c4145a.ailDimView.getVisibility() == 0) {
                C4145a c4145a3 = this.binding;
                if (c4145a3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c4145a2 = c4145a3;
                }
                c4145a2.ailDimView.setAlpha(this.homeGroupExitStartDimAlpha * (1.0f - C5685n.m(progress, 0.0f, 1.0f)));
            }
        }
        Q2(C5685n.m(progress, 0.0f, 1.0f));
    }

    public final boolean P1() {
        return !this.dialogHoldsKeyboard && this.imeGeometryPinnedForDialog;
    }

    public void P2(float progress) {
    }

    public final void P3(boolean hidden) {
        if (isDestroyed() || isFinishing() || this.stackCoverContentHidden == hidden) {
            return;
        }
        this.stackCoverContentHidden = hidden;
        if (hidden) {
            f2();
        } else {
            a4();
        }
    }

    public final void Q0() {
        androidx.core.view.b0 b0VarA = androidx.core.view.Y.a(getWindow(), getWindow().getDecorView());
        kotlin.jvm.internal.p.h(b0VarA, "getInsetsController(...)");
        b0VarA.e(n4());
        b0VarA.d(m4());
    }

    /* renamed from: Q1, reason: from getter */
    public final int get_layerIndex() {
        return this._layerIndex;
    }

    public void Q2(float progress) {
    }

    public final void Q3(float alpha) {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes.alpha == alpha) {
            return;
        }
        attributes.alpha = alpha;
        window.setAttributes(attributes);
    }

    public final void R0() {
        this.hiddenForRecentsPeek = true;
        com.stepos.ailauncher.sheet.internal.J j10 = com.stepos.ailauncher.sheet.internal.J.INSTANCE;
        j10.k(true);
        C3442a.INSTANCE.a(this, false);
        Window window = getWindow();
        if (window != null) {
            j10.i(window);
        }
        e2();
    }

    /* renamed from: R1, reason: from getter */
    public final boolean getNineSplitExitStarted() {
        return this.nineSplitExitStarted;
    }

    public void R2(float fraction) {
    }

    public CharSequence R3(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        return null;
    }

    public final void S0(String reason) {
        androidx.dynamicanimation.animation.i iVar = this.dragHandleAlphaAnim;
        if (iVar != null) {
            boolean zI = iVar.i();
            C4145a c4145a = this.binding;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            Log.i("DragHandleAlpha", "cancel reason=" + reason + " wasRunning=" + zI + " alpha=" + c4145a.ailDragHandle.getAlpha());
        }
        if (iVar != null) {
            iVar.d();
        }
        this.dragHandleAlphaAnim = null;
    }

    public final SheetSettleState S1() {
        return this.enterTransitionCompleted ? N1() : u1();
    }

    public void S2(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
    }

    public final void S3(SheetSettleState state, boolean animate) {
        kotlin.jvm.internal.p.i(state, "state");
        if (this.previewMode || this.finishingWithAnim || isDestroyed()) {
            return;
        }
        if (state == SheetSettleState.HALF || state == SheetSettleState.FULL || state == SheetSettleState.MINIFY) {
            DraggableSheetLayout.y1(X1(), state, animate, null, 4, null);
        }
    }

    public void T0() {
        if (this.homeGroupExitPrepared) {
            G3();
            this.finishingWithAnim = false;
            this.homeGroupExitDistancePx = 0.0f;
            X1().setBottomAnchorEnabled(true);
            X1().setDismissEnabled(true);
            X1().setDragEnabled(true);
        }
        SharedExitInteractionState sharedExitInteractionState = this.sharedExitInteractionState;
        if (sharedExitInteractionState != null) {
            X1().n1();
            X1().setBottomAnchorEnabled(sharedExitInteractionState.getAnchor());
            X1().setDismissEnabled(sharedExitInteractionState.getDismiss());
            X1().setDragEnabled(sharedExitInteractionState.getDrag());
            this.sharedExitInteractionState = null;
        }
    }

    /* renamed from: T1, reason: from getter */
    public final FrameLayout getResidentBottomSlot() {
        return this.residentBottomSlot;
    }

    public float T2() {
        return getResources().getDimension(R$dimen.ail_sheet_corner) / getResources().getDisplayMetrics().density;
    }

    public final void U0() {
        Animator animator = this.nineSplitExitColorAnim;
        if (animator != null) {
            animator.cancel();
        }
        this.nineSplitExitColorAnim = null;
    }

    public boolean U1() {
        return false;
    }

    public final void U3() {
        C4145a c4145a = this.binding;
        C4145a c4145a2 = null;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        c4145a.ailDimView.setBackgroundColor(j2());
        if (b2()) {
            C4145a c4145a3 = this.binding;
            if (c4145a3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a3 = null;
            }
            c4145a3.ailDimView.setVisibility(0);
            C4145a c4145a4 = this.binding;
            if (c4145a4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a2 = c4145a4;
            }
            c4145a2.ailDimView.setAlpha(0.0f);
            return;
        }
        C4145a c4145a5 = this.binding;
        if (c4145a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a5 = null;
        }
        c4145a5.ailDimView.setVisibility(8);
        C4145a c4145a6 = this.binding;
        if (c4145a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a6 = null;
        }
        c4145a6.ailDimView.setAlpha(0.0f);
        C4145a c4145a7 = this.binding;
        if (c4145a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a7 = null;
        }
        c4145a7.ailDimView.setOnClickListener(null);
    }

    public final void V() {
        if (isDestroyed() || isFinishing() || this.binding == null || this.homeGroupExitPrepared) {
            return;
        }
        U0();
        androidx.dynamicanimation.animation.i iVar = this.exitColorAnim;
        if (iVar != null) {
            iVar.d();
        }
        C4145a c4145a = null;
        this.exitColorAnim = null;
        C0(1.0f);
        C3436d.g(Y1());
        M1().setAlpha(1.0f);
        M1().setVisibility(0);
        if (this.finishingWithAnim) {
            androidx.dynamicanimation.animation.i iVar2 = this.dimSpring;
            if (iVar2 != null) {
                iVar2.d();
            }
            this.dimSpring = null;
            S0("abortExitForRestore");
            Animator animator = this.dismissAnimator;
            if (animator != null) {
                animator.removeAllListeners();
            }
            Animator animator2 = this.dismissAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
            this.dismissAnimator = null;
            X1().O(true);
            X1().c0();
            this.finishingWithAnim = false;
            this.finishWithExitAnimRequested = false;
            this.nineSplitExitStarted = false;
            this.holdWindowForExitAnim = false;
            this.exitTouchReleased = false;
            X1().setDismissEnabled(true);
            X1().setBottomAnchorEnabled(true);
            X1().setDragEnabled(true);
            if (b2()) {
                C4145a c4145a2 = this.binding;
                if (c4145a2 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c4145a2 = null;
                }
                c4145a2.ailDimView.setVisibility(0);
                C4145a c4145a3 = this.binding;
                if (c4145a3 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c4145a3 = null;
                }
                c4145a3.ailDimView.setClickable(true);
                C4145a c4145a4 = this.binding;
                if (c4145a4 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c4145a4 = null;
                }
                c4145a4.ailDimView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.sheet.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws Resources.NotFoundException {
                        O.W(this.f28276a, view);
                    }
                });
                C4145a c4145a5 = this.binding;
                if (c4145a5 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c4145a = c4145a5;
                }
                c4145a.ailDimView.setAlpha(i2());
            }
            if (this.dragHandleWanted) {
                c4(0.34f, "abortExitForRestore");
            }
            Window window = getWindow();
            if (window != null) {
                window.clearFlags(16);
            }
            if (!m2()) {
                C3442a.INSTANCE.a(this, true);
            }
            a2().J(this, X1(), get_layerIndex());
        }
    }

    public final void V0() {
        View view = this.passthroughObservedView;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.passthroughLayoutListener);
        }
        this.passthroughObservedView = null;
    }

    public final Xa.t<Boolean> V1() {
        return X1().getScaleEnterRunning();
    }

    public void V2() {
        super.finish();
        int i10 = this.holdWindowForExitAnim ? R$anim.sheet_close_exit_layer_above : 0;
        this.holdWindowForExitAnim = false;
        overridePendingTransition(0, i10);
    }

    /* renamed from: V3 */
    public boolean getWindowHiddenForQuickSwitch() {
        return false;
    }

    public final void W0() {
        if (this.homeGroupExitPrepared) {
            X1().setHomeGroupExitOffsetY(0.0f);
            this.homeGroupExitPrepared = false;
            this.finishingWithAnim = false;
            this.homeGroupExitDistancePx = 0.0f;
            X1().setBottomAnchorEnabled(true);
            X1().setDismissEnabled(true);
            X1().setDragEnabled(true);
        }
    }

    public final float W1() {
        return X1().getHalfFullFraction();
    }

    public final void W2(final InterfaceC5063a<Y8.t> onEnd) throws Resources.NotFoundException {
        if (this.previewMode || this.finishingWithAnim || isDestroyed()) {
            return;
        }
        X1().setBottomAnchorEnabled(true);
        X1().setDismissEnabled(true);
        X1().setDragEnabled(false);
        Integer numN1 = n1();
        C4145a c4145a = this.binding;
        InterfaceC5074l<? super Float, Y8.t> interfaceC5074l = null;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        final View view = b2() ? c4145a.ailDimView : null;
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
        }
        InterfaceC5063a<Y8.t> interfaceC5063aS2 = s2(numN1 != null, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.B
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return O.Y2(this.f27664a, onEnd);
            }
        });
        if (numN1 != null) {
            androidx.dynamicanimation.animation.i iVar = this.exitColorAnim;
            if (iVar != null) {
                iVar.d();
            }
            this.exitColorAnim = C3436d.j(Y1(), numN1.intValue(), androidx.core.content.a.c(this, R$color.ail_sheet_bg), view, b2() ? i2() : 0.0f, true, get_heightMode() == SheetHeightMode.FULL_9 ? i0.INSTANCE.e() : i0.INSTANCE.d(), interfaceC5063aS2);
        }
        DraggableSheetLayout draggableSheetLayoutX1 = X1();
        boolean zO1 = o1();
        if (numN1 == null && view != null) {
            interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.C
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return O.Z2(view, this, ((Float) obj).floatValue());
                }
            };
        }
        draggableSheetLayoutX1.G0(zO1, interfaceC5074l, interfaceC5063aS2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return O.a3(this.f27668a);
            }
        });
    }

    public boolean W3() {
        return true;
    }

    public final void X0(InterfaceC5074l<? super Integer, Y8.t> delegate) throws Resources.NotFoundException {
        this.imeLiftReleasePending = false;
        this.imeLiftDelegate = null;
        delegate.invoke(0);
        if (isDestroyed()) {
            return;
        }
        u3();
    }

    public final DraggableSheetLayout X1() {
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        DraggableSheetLayout ailSheetLayout = c4145a.ailSheetLayout;
        kotlin.jvm.internal.p.h(ailSheetLayout, "ailSheetLayout");
        return ailSheetLayout;
    }

    public boolean X3() {
        return false;
    }

    public void Y0() {
        V2();
    }

    public final ViewGroup Y1() {
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        FrameLayout ailSheetPanel = c4145a.ailSheetPanel;
        kotlin.jvm.internal.p.h(ailSheetPanel, "ailSheetPanel");
        return ailSheetPanel;
    }

    public boolean Y3() {
        return false;
    }

    public final boolean Z0() {
        return this.stackPauseHandoff.b(SystemClock.uptimeMillis());
    }

    public final FrameLayout Z1() {
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        FrameLayout ailSheetRoot = c4145a.ailSheetRoot;
        kotlin.jvm.internal.p.h(ailSheetRoot, "ailSheetRoot");
        return ailSheetRoot;
    }

    public boolean Z3() {
        return true;
    }

    public int a1() {
        return 0;
    }

    public s0 a2() {
        return s0.INSTANCE.b(SheetLaunchOptions.INSTANCE.d(getIntent()));
    }

    public void a4() {
        M1().setVisibility(0);
        FrameLayout frameLayout = this.residentBottomSlot;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    public boolean b1() {
        return false;
    }

    public final boolean b2() {
        return i2() > 0.0f;
    }

    public final void b3(InterfaceC5063a<Y8.t> onEnd) {
        if (this.previewMode || this.finishingWithAnim || isDestroyed()) {
            return;
        }
        X1().M0(onEnd);
    }

    public boolean b4() {
        return false;
    }

    public boolean c1() {
        return false;
    }

    public InterfaceC3456j c2() {
        return C3437e.INSTANCE;
    }

    public final void c4(float alpha, String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        if (isDestroyed()) {
            return;
        }
        S0("snap:" + reason);
        C4145a c4145a = this.binding;
        C4145a c4145a2 = null;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        float alpha2 = c4145a.ailDragHandle.getAlpha();
        C4145a c4145a3 = this.binding;
        if (c4145a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a3 = null;
        }
        c4145a3.ailDragHandle.setAlpha(C5685n.m(alpha, 0.0f, 1.0f));
        C4145a c4145a4 = this.binding;
        if (c4145a4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4145a2 = c4145a4;
        }
        Log.i("DragHandleAlpha", "snapSheet reason=" + reason + " before=" + alpha2 + " after=" + c4145a2.ailDragHandle.getAlpha());
    }

    public final void d2() throws Resources.NotFoundException {
        if (!f1() || this.maskPassthrough || X3()) {
            return;
        }
        if (this.previewMode) {
            C1(this, false, 1, null);
        } else {
            g1();
        }
    }

    public final void d3(InterfaceC5063a<Y8.t> onEnterEnd) throws Resources.NotFoundException {
        SheetScaleMotion sheetScaleMotionT1 = t1();
        SheetOffsetMotion sheetOffsetMotionP1 = p1();
        SheetSpring sheetSpringS1 = s1();
        z0();
        SheetSettleState sheetSettleStateU1 = u1();
        boolean zV1 = v1();
        boolean z10 = sheetScaleMotionT1 != null;
        boolean z11 = sheetOffsetMotionP1 != null;
        boolean z12 = sheetSpringS1 != null;
        Log.i(TAG_ENTER, "spring → " + sheetSettleStateU1 + " barClip=" + zV1 + " scale=" + z10 + " offset=" + z11 + " rise=" + z12 + " (" + getClass().getSimpleName() + ")");
        if (v1()) {
            W2(onEnterEnd);
            return;
        }
        if (sheetScaleMotionT1 != null) {
            X1().T0(sheetScaleMotionT1.getCollapsedScale(), X1().getWidth() * sheetScaleMotionT1.getTravelWidthFraction(), sheetScaleMotionT1.getOffset().getStiffness(), sheetScaleMotionT1.getOffset().getDampingRatio(), sheetScaleMotionT1.getScale().getStiffness(), sheetScaleMotionT1.getScale().getDampingRatio(), w1(), onEnterEnd);
            return;
        }
        if (sheetOffsetMotionP1 != null) {
            X1().S0(X1().getWidth() * sheetOffsetMotionP1.getTravelWidthFraction(), sheetOffsetMotionP1.getOffset().getStiffness(), sheetOffsetMotionP1.getOffset().getDampingRatio(), onEnterEnd);
        } else if (sheetSpringS1 != null) {
            X1().Q0(sheetSpringS1.getStiffness(), sheetSpringS1.getDampingRatio(), onEnterEnd);
        } else {
            X1().M0(onEnterEnd);
        }
    }

    public final void d4(String reason) {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.pendingEnterAnimation;
        if (interfaceC5063a == null) {
            return;
        }
        this.pendingEnterAnimation = null;
        getWindow().getDecorView().removeCallbacks(this.deferredEnterTimeout);
        if (isDestroyed()) {
            return;
        }
        X1().setVisibility(0);
        Log.i(TAG_ENTER, "deferred spring fires: " + reason + " (" + getClass().getSimpleName() + ")");
        interfaceC5063a.invoke();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (this.sharedExitInteractionState != null) {
            return true;
        }
        return super.dispatchTouchEvent(event);
    }

    public final void e1(InterfaceC5074l<? super Integer, Y8.t> onLift) throws Resources.NotFoundException {
        if (onLift != null) {
            this.imeLiftReleasePending = false;
            if (this.imeLiftDelegate == onLift) {
                return;
            }
            this.imeLiftDelegate = onLift;
            if (isDestroyed()) {
                return;
            }
            u3();
            return;
        }
        InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l = this.imeLiftDelegate;
        if (interfaceC5074l == null) {
            return;
        }
        if (!this.imeVisible || this.imeLiftReleasePending) {
            X0(interfaceC5074l);
        } else {
            this.imeLiftReleasePending = true;
        }
    }

    public final void e2() {
        View decorView;
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        View viewFindFocus = decorView.findFocus();
        if (viewFindFocus != null) {
            viewFindFocus.clearFocus();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(InputMethodManager.class);
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(decorView.getWindowToken(), 0);
    }

    public final void e3() throws Resources.NotFoundException {
        Float fValueOf = Float.valueOf(1.0f);
        if (this.finishingWithAnim) {
            return;
        }
        if (this.previewMode) {
            this.previewMode = false;
            this.previewExitPendingPortrait = false;
            X1().setDragEnabled(true);
            N0(false);
            X1().setStackPeekSuppressed(false);
            X1().setFullTopRatio(this.previewSavedFullTopRatio);
        }
        this.finishingWithAnim = true;
        X1().setDismissEnabled(false);
        X1().setBottomAnchorEnabled(false);
        androidx.dynamicanimation.animation.i iVar = this.dimSpring;
        if (iVar != null) {
            iVar.d();
        }
        U0();
        androidx.dynamicanimation.animation.i iVar2 = this.exitColorAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        Animator animatorC1 = null;
        this.exitColorAnim = null;
        A0();
        a2().C(this);
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        final float alpha = c4145a.ailDimView.getAlpha();
        final InterfaceC5074l<? super Float, Y8.t> interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return O.f3(this.f28163a, alpha, ((Float) obj).floatValue());
            }
        };
        Window window = getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null && (decorView.getVisibility() != 0 || decorView.getAlpha() < 0.08f)) {
            interfaceC5074l.invoke(fValueOf);
            Y0();
            return;
        }
        SheetExitAnim sheetExitAnimX1 = x1();
        final boolean z10 = (sheetExitAnimX1 == SheetExitAnim.NONE || sheetExitAnimX1 == SheetExitAnim.SPRING_SCALE_DOWN || !h2()) ? false : true;
        final InterfaceC5063a<Y8.t> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return O.g3(this.f28165a, z10);
            }
        };
        int i10 = c.$EnumSwitchMapping$2[sheetExitAnimX1.ordinal()];
        if (i10 == 1) {
            interfaceC5074l.invoke(fValueOf);
            Y0();
        } else if (i10 == 2) {
            SheetOffsetMotion sheetOffsetMotionA1 = A1();
            if (sheetOffsetMotionA1 != null) {
                X1().f1(sheetOffsetMotionA1.getOffset().getStiffness(), sheetOffsetMotionA1.getOffset().getDampingRatio(), Float.valueOf(X1().getWidth() * sheetOffsetMotionA1.getTravelWidthFraction()), interfaceC5074l, interfaceC5063a);
            } else {
                animatorC1 = X1().c1(interfaceC5074l, interfaceC5063a);
            }
        } else if (i10 == 3) {
            animatorC1 = X1().i1(interfaceC5074l, interfaceC5063a);
        } else if (i10 == 4) {
            animatorC1 = X1().Z0(T2() * getResources().getDisplayMetrics().density, interfaceC5074l, interfaceC5063a);
        } else {
            if (i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            SheetScaleMotion sheetScaleMotionD1 = D1();
            if (sheetScaleMotionD1 == null) {
                animatorC1 = X1().c1(interfaceC5074l, interfaceC5063a);
            } else {
                final boolean z11 = X1().getStateForExit() == SheetSettleState.FULL;
                this.nineSplitExitStarted = z11;
                boolean zE1 = E1();
                final Integer numY1 = y1();
                final int iC = androidx.core.content.a.c(this, R$color.ail_sheet_bg);
                if (!x2() && Y1().getBackground() == null && (zE1 || numY1 != null)) {
                    Y1().setBackground(androidx.core.content.a.e(this, R$drawable.ail_bg_sheet));
                    C3436d.q(Y1(), iC);
                }
                C4145a c4145a2 = this.binding;
                if (c4145a2 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c4145a2 = null;
                }
                View view = c4145a2.ailDimView;
                if (!b2() || view.getVisibility() != 0) {
                    view = null;
                }
                if (view != null) {
                    view.setClickable(false);
                }
                if (view != null) {
                    view.setOnClickListener(null);
                }
                float alpha2 = view != null ? view.getAlpha() : 0.0f;
                if (numY1 != null && z11) {
                    this.nineSplitExitColorAnim = C3436d.n(Y1(), numY1.intValue(), a0.a(X1().f0()), view, alpha2);
                }
                final InterfaceC5074l interfaceC5074l2 = new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.n
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return O.h3(numY1, z11, interfaceC5074l, this, ((Float) obj).floatValue());
                    }
                };
                InterfaceC5063a<Y8.t> interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.o
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return O.i3(this.f28189a, interfaceC5063a);
                    }
                };
                InterfaceC5063a<Y8.t> interfaceC5063a3 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.p
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return O.j3(z11, this);
                    }
                };
                if (zE1) {
                    DraggableSheetLayout draggableSheetLayoutX1 = X1();
                    float collapsedScale = sheetScaleMotionD1.getCollapsedScale();
                    float collapsedScaleY = sheetScaleMotionD1.getCollapsedScaleY();
                    float width = X1().getWidth() * sheetScaleMotionD1.getTravelWidthFraction();
                    i0 i0Var = i0.INSTANCE;
                    draggableSheetLayoutX1.X0(collapsedScale, width, i0Var.o().getStiffness(), i0Var.o().getDampingRatio(), i0Var.p().getStiffness(), i0Var.p().getDampingRatio(), collapsedScaleY, 2.0f, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.q
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return O.k3(interfaceC5074l2, this, ((Float) obj).floatValue());
                        }
                    }, interfaceC5063a3, interfaceC5063a2);
                } else {
                    final boolean zZ1 = z1();
                    DraggableSheetLayout draggableSheetLayoutX12 = X1();
                    float collapsedScale2 = sheetScaleMotionD1.getCollapsedScale();
                    float collapsedScaleY2 = sheetScaleMotionD1.getCollapsedScaleY();
                    final boolean z12 = z11;
                    draggableSheetLayoutX12.a1(collapsedScale2, X1().getWidth() * sheetScaleMotionD1.getTravelWidthFraction(), z11 ? i0.INSTANCE.o().getStiffness() : sheetScaleMotionD1.getOffset().getStiffness(), z11 ? i0.INSTANCE.o().getDampingRatio() : sheetScaleMotionD1.getOffset().getDampingRatio(), z11 ? i0.INSTANCE.p().getStiffness() : sheetScaleMotionD1.getScale().getStiffness(), z11 ? i0.INSTANCE.p().getDampingRatio() : sheetScaleMotionD1.getScale().getDampingRatio(), collapsedScaleY2, z11 ? 2.0f : 0.0f, zZ1, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.r
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return O.l3(interfaceC5074l2, z12, zZ1, this, numY1, iC, ((Float) obj).floatValue());
                        }
                    }, interfaceC5063a3, interfaceC5063a2);
                }
            }
        }
        this.dismissAnimator = animatorC1;
        if (!z10 || isDestroyed()) {
            return;
        }
        this.holdWindowForExitAnim = true;
        V2();
    }

    public boolean e4() {
        return false;
    }

    public boolean f1() {
        return true;
    }

    public void f2() {
        M1().setVisibility(4);
        FrameLayout frameLayout = this.residentBottomSlot;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
    }

    public String f4() {
        return null;
    }

    @Override // android.app.Activity
    public void finish() throws Resources.NotFoundException {
        boolean z10 = (!this.finishWithExitAnimRequested || this.finishingWithAnim || x1() == SheetExitAnim.NONE || isFinishing() || isDestroyed() || isChangingConfigurations()) ? false : true;
        this.finishWithExitAnimRequested = false;
        if (z10) {
            e3();
        } else {
            V2();
        }
    }

    public void g1() throws Resources.NotFoundException {
        if (this.finishingWithAnim) {
            return;
        }
        e3();
    }

    public final void g2() throws Resources.NotFoundException {
        if (isDestroyed() || this.previewMode) {
            return;
        }
        this.dialogHoldsKeyboard = true;
        if (this.imeGeometryPinnedForDialog) {
            return;
        }
        this.imeGeometryPinnedForDialog = true;
        u3();
    }

    public final void g4(androidx.core.view.a0 insets) {
        if (P1() && !insets.r(a0.o.b())) {
            this.imeGeometryPinnedForDialog = false;
        }
    }

    public boolean h1() {
        return true;
    }

    public boolean h2() {
        return false;
    }

    public final void h4() {
        if (P1()) {
            this.imeGeometryPinnedForDialog = false;
        }
    }

    public boolean i1() {
        return true;
    }

    public float i2() {
        return 0.4f;
    }

    public final void i4() {
        String str = this.registeredUniqueInstanceKey;
        if (str == null) {
            return;
        }
        synchronized (UNIQUE_INSTANCE_LOCK) {
            try {
                Map<String, List<WeakReference<O>>> map = UNIQUE_INSTANCES;
                List<WeakReference<O>> list = map.get(str);
                if (list != null) {
                    Z8.A.L(list, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.k
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(O.j4(this.f28161a, (WeakReference) obj));
                        }
                    });
                    if (list.isEmpty()) {
                        map.remove(str);
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.registeredUniqueInstanceKey = null;
    }

    public boolean j1() {
        return false;
    }

    public int j2() {
        return -16777216;
    }

    public final void k1() throws Resources.NotFoundException {
        if (this.imeAnimationDeferringGeometry) {
            this.imeAnimationDeferringGeometry = false;
            if (this.previewMode || isDestroyed() || this.lastGeometryKeyboardHeight != this.imeGeometryHeightAtAnimationStart) {
                return;
            }
            u3();
        }
    }

    /* renamed from: k2, reason: from getter */
    public final boolean getHiddenForRecentsPeek() {
        return this.hiddenForRecentsPeek;
    }

    public final void k4(SheetSettleState state) {
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        TextView ailSettleHint = c4145a.ailSettleHint;
        kotlin.jvm.internal.p.h(ailSettleHint, "ailSettleHint");
        if (this.previewMode || state == SheetSettleState.IMMERSIVE) {
            ailSettleHint.setVisibility(8);
            return;
        }
        CharSequence charSequenceR3 = R3(state);
        if (charSequenceR3 == null || charSequenceR3.length() == 0) {
            ailSettleHint.setVisibility(8);
        } else {
            ailSettleHint.setVisibility(8);
            ailSettleHint.setText(charSequenceR3);
        }
    }

    public final void l1(Pair<Integer, Float> sheetLook) {
        if (this.panelGlassHandle == null && !isDestroyed() && !this.chromeTransparent && Y1().isAttachedToWindow()) {
            Drawable background = Y1().getBackground();
            SheetGlassStyle sheetGlassStyle = null;
            Y1().setBackground(null);
            com.stepos.ailauncher.sheet.internal.D d10 = com.stepos.ailauncher.sheet.internal.D.INSTANCE;
            ViewGroup viewGroupY1 = Y1();
            float fT2 = T2();
            if (sheetLook == null) {
                sheetLook = com.stepos.ailauncher.container.glass.h.INSTANCE.J(X1().getHalfFullFraction());
            }
            int i10 = c.$EnumSwitchMapping$0[X1().getSettleState().ordinal()];
            if (i10 == 1) {
                sheetGlassStyle = SheetGlassStyle.HALF;
            } else if (i10 == 2) {
                sheetGlassStyle = SheetGlassStyle.FULL;
            }
            y7.E eA = d10.a(viewGroupY1, fT2, sheetGlassStyle, sheetLook);
            this.panelGlassHandle = eA;
            if (eA == null && Y1().getBackground() == null) {
                Y1().setBackground(background);
            }
        }
    }

    /* renamed from: l2, reason: from getter */
    public final boolean getMaskPassthrough() {
        return this.maskPassthrough;
    }

    public boolean l4() {
        return get_layerIndex() <= 1;
    }

    public final void m1(View v10) {
        View view = this.passthroughObservedView;
        if (view == v10) {
            return;
        }
        if (view != null) {
            view.removeOnLayoutChangeListener(this.passthroughLayoutListener);
        }
        this.passthroughObservedView = v10;
        v10.addOnLayoutChangeListener(this.passthroughLayoutListener);
    }

    public boolean m2() {
        return this.hiddenForRecentsPeek || this.exitTouchReleased;
    }

    public final void m3(SheetScaleMotion motion, boolean floatingBottom, final InterfaceC5063a<Y8.t> onEnd) {
        kotlin.jvm.internal.p.i(motion, "motion");
        if (this.previewMode || this.finishingWithAnim || isDestroyed()) {
            return;
        }
        X1().setBottomAnchorEnabled(true);
        X1().setDismissEnabled(true);
        X1().setDragEnabled(false);
        if (b2()) {
            C4145a c4145a = this.binding;
            C4145a c4145a2 = null;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            c4145a.ailDimView.setVisibility(0);
            C4145a c4145a3 = this.binding;
            if (c4145a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a2 = c4145a3;
            }
            c4145a2.ailDimView.setAlpha(0.0f);
        }
        X1().T0(motion.getCollapsedScale(), X1().getWidth() * motion.getTravelWidthFraction(), motion.getOffset().getStiffness(), motion.getOffset().getDampingRatio(), motion.getScale().getStiffness(), motion.getScale().getDampingRatio(), floatingBottom, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return O.o3(this.f27669a, onEnd);
            }
        });
    }

    public boolean m4() {
        return getResources().getBoolean(R$bool.ail_sheet_light_status_bar);
    }

    public Integer n1() {
        return null;
    }

    /* renamed from: n2, reason: from getter */
    public final boolean getPreviewMode() {
        return this.previewMode;
    }

    public boolean n4() {
        return getResources().getBoolean(R$bool.ail_sheet_light_status_bar);
    }

    public boolean o1() {
        return false;
    }

    public final boolean o2() {
        return getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public boolean o4() {
        return false;
    }

    @Override // androidx.appcompat.app.d, b.q, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.previewExitPendingPortrait && newConfig.orientation == 1) {
            F1(true);
        } else if (this.previewMode) {
            X1().post(new Runnable() { // from class: com.stepos.ailauncher.sheet.N
                @Override // java.lang.Runnable
                public final void run() {
                    O.y2(this.f27680a);
                }
            });
        }
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        androidx.core.view.Y.b(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().addFlags(Integer.MIN_VALUE);
        com.stepos.ailauncher.sheet.internal.N.INSTANCE.a(this);
        com.stepos.ailauncher.sheet.internal.D.INSTANCE.c(this);
        SheetLaunchOptions d0VarA = SheetLaunchOptions.INSTANCE.a(getIntent());
        this._layerIndex = d0VarA.getLayer();
        this._heightMode = d0VarA.getHeightMode();
        if (!e4()) {
            this._heightMode = SheetHeightMode.FULL_9;
        } else if (K1() && this._layerIndex > 1) {
            SheetHeightMode sheetHeightMode = this._heightMode;
            SheetHeightMode sheetHeightMode2 = SheetHeightMode.FULL_9;
            if (sheetHeightMode != sheetHeightMode2) {
                this._heightMode = sheetHeightMode2;
            }
        }
        x3();
        C4145a c4145aC = C4145a.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(c4145aC, "inflate(...)");
        this.binding = c4145aC;
        C4145a c4145a = null;
        if (c4145aC == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145aC = null;
        }
        setContentView(c4145aC.b());
        C4145a c4145a2 = this.binding;
        if (c4145a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a2 = null;
        }
        ViewParent parent = c4145a2.b().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
        X1().setHeightMode(this._heightMode);
        X1().setStackBackgroundPreserveOpacity(t3());
        X1().setStackBackgroundColorAlphaEnabled(j1());
        X1().setAllowCollapseToHalf(e4());
        X1().setHandleBoundsProvider(c2());
        X1().setContentAnchorView(M1());
        X1().setBottomAnchorEnabled(true);
        X1().setFreezeContentHeightOnFullDrag(L1());
        X1().setUseFullDragThreshold(l4());
        U3();
        G0();
        if (i1()) {
            Y1().post(new Runnable() { // from class: com.stepos.ailauncher.sheet.I
                @Override // java.lang.Runnable
                public final void run() {
                    O.A2(this.f27675a);
                }
            });
        }
        F2(M1(), savedInstanceState);
        k4(X1().getSettleState());
        X1().setCallback(new e());
        if (f1()) {
            C4145a c4145a3 = this.binding;
            if (c4145a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a = c4145a3;
            }
            c4145a.ailDimView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.sheet.J
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    O.B2(this.f27676a, view);
                }
            });
        }
        getOnBackPressedDispatcher().m(this, new f());
        Q0();
        a2().J(this, X1(), get_layerIndex());
        X1().post(new Runnable() { // from class: com.stepos.ailauncher.sheet.K
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                O.C2(this.f27677a);
            }
        });
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        View decorView;
        this.stackPauseHandoff.a();
        i4();
        this.pendingEnterAnimation = null;
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.removeCallbacks(this.deferredEnterTimeout);
        }
        androidx.dynamicanimation.animation.i iVar = this.dimSpring;
        if (iVar != null) {
            iVar.d();
        }
        U0();
        androidx.dynamicanimation.animation.i iVar2 = this.exitColorAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        this.exitColorAnim = null;
        S0("onDestroy");
        Animator animator = this.dismissAnimator;
        if (animator != null) {
            animator.cancel();
        }
        this.dismissAnimator = null;
        if (this.binding != null) {
            DraggableSheetLayout.P(X1(), false, 1, null);
        }
        com.stepos.ailauncher.sheet.internal.D.INSTANCE.e(this.panelGlassHandle);
        this.panelGlassHandle = null;
        if (!isChangingConfigurations()) {
            a2().C(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        d4("enter-anim-complete");
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.previewMode || this.chromeTransparent || w2() || !W3()) {
            return;
        }
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        FrameLayout ailDragHandle = c4145a.ailDragHandle;
        kotlin.jvm.internal.p.h(ailDragHandle, "ailDragHandle");
        if (ailDragHandle.getVisibility() == 0 && ailDragHandle.getAlpha() > 0.01f) {
            q3(this, 0.0f, null, "onPause.fadeOut", null, 10, null);
        } else {
            ailDragHandle.setVisibility(8);
            ailDragHandle.setAlpha(0.0f);
        }
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        this.stackPauseHandoff.a();
        super.onResume();
        H3("onResume");
        A3();
        if (!m2()) {
            if (this.maskPassthrough) {
                J0();
            } else if (h1()) {
                L0(androidx.core.view.N.B(getWindow().getDecorView()));
            }
        }
        if (b2() && !this.hiddenForRecentsPeek && !this.maskPassthrough && !this.finishingWithAnim && !this.previewMode && a2().y(this)) {
            v0(i2(), true);
        }
        if (a2().y(this)) {
            P3(false);
        }
        if (!this.previewMode) {
            Q0();
        }
        if (this.hiddenForRecentsPeek || this.previewMode || this.chromeTransparent || w2()) {
            return;
        }
        M3(this.dragHandleWanted);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        this.stackPauseHandoff.a();
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) throws Resources.NotFoundException {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            H3("window-focus");
            d4("window-focus");
        }
        if (hasFocus && this.previewMode) {
            androidx.core.view.Y.a(getWindow(), getWindow().getDecorView()).a(a0.o.g());
            return;
        }
        if (hasFocus && this.maskPassthrough) {
            J0();
        } else if (hasFocus && !this.hiddenForRecentsPeek && h1()) {
            L0(androidx.core.view.N.B(getWindow().getDecorView()));
        }
    }

    public SheetOffsetMotion p1() {
        if (get_layerIndex() > 1) {
            return i0.INSTANCE.w();
        }
        return null;
    }

    /* renamed from: p2, reason: from getter */
    public final boolean getFinishingWithAnim() {
        return this.finishingWithAnim;
    }

    public final void p3(float toAlpha, Float fromAlpha, String reason, InterfaceC5063a<Y8.t> onEnd) {
        kotlin.jvm.internal.p.i(reason, "reason");
        if (!isDestroyed() && !this.previewMode) {
            S0("before:" + reason);
            C4145a c4145a = this.binding;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            this.dragHandleAlphaAnim = C3440h.d(c4145a.ailDragHandle, toAlpha, fromAlpha, false, null, reason, onEnd, 24, null);
            return;
        }
        Log.i("DragHandleAlpha", "playSheet skip reason=" + reason + " destroyed=" + isDestroyed() + " preview=" + this.previewMode);
        if (onEnd != null) {
            onEnd.invoke();
        }
    }

    public final void q1(boolean allowOrientation, SheetSettleState restoreTo) {
        Drawable background;
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        SheetSettleState sheetSettleState;
        if (this.previewMode || this.finishingWithAnim || isDestroyed()) {
            return;
        }
        SheetSettleState settleState = X1().getSettleState();
        SheetSettleState sheetSettleState2 = SheetSettleState.HALF;
        if (restoreTo != sheetSettleState2 && restoreTo != (sheetSettleState = SheetSettleState.FULL)) {
            restoreTo = (settleState == sheetSettleState2 || settleState == sheetSettleState) ? settleState : sheetSettleState;
        }
        this.previewRestoreState = restoreTo;
        this.previewAllowOrientation = allowOrientation;
        this.previewMode = true;
        this.previewExitPendingPortrait = false;
        this.previewSavedFullTopRatio = X1().getFullTopRatio();
        this.previewSavedPanelTopPad = Y1().getPaddingTop();
        this.previewSavedBottomPad = Y1().getPaddingBottom();
        this.previewSavedContentHPad = M1().getPaddingLeft();
        this.previewSavedContentTopPad = M1().getPaddingTop();
        this.previewSavedContentBottomPad = M1().getPaddingBottom();
        this.previewChromeCornerDp = T2();
        Drawable background2 = Y1().getBackground();
        if (background2 == null || (constantState = background2.getConstantState()) == null || (drawableNewDrawable = constantState.newDrawable()) == null || (background = drawableNewDrawable.mutate()) == null) {
            background = Y1().getBackground();
        }
        this.previewSavedPanelBackground = background;
        X1().setDragEnabled(false);
        X1().setDismissEnabled(false);
        X1().setBottomAnchorEnabled(false);
        FrameLayout frameLayoutM1 = M1();
        ViewGroup.LayoutParams layoutParams = M1().getLayoutParams();
        layoutParams.height = -1;
        frameLayoutM1.setLayoutParams(layoutParams);
        N0(true);
        if (b2()) {
            C4145a c4145a = this.binding;
            C4145a c4145a2 = null;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            c4145a.ailDimView.setVisibility(0);
            C4145a c4145a3 = this.binding;
            if (c4145a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a2 = c4145a3;
            }
            c4145a2.ailDimView.setAlpha(1.0f);
        }
        if (allowOrientation) {
            this.previewSavedOrientation = getRequestedOrientation();
            setRequestedOrientation(10);
        }
        X1().setStackPeekSuppressed(true);
        DraggableSheetLayout.y1(X1(), SheetSettleState.IMMERSIVE, true, null, 4, null);
        L2(true);
    }

    /* renamed from: q2, reason: from getter */
    public final boolean getStackCoverContentHidden() {
        return this.stackCoverContentHidden;
    }

    public final boolean r2() {
        Window window;
        View decorView;
        return (isFinishing() || isDestroyed() || this.hiddenForRecentsPeek || (window = getWindow()) == null || (decorView = window.getDecorView()) == null || decorView.getVisibility() != 0 || decorView.getAlpha() < 0.08f) ? false : true;
    }

    public boolean r3() {
        if (this.binding == null || isFinishing() || isDestroyed() || this.finishingWithAnim) {
            return false;
        }
        if (this.homeGroupExitPrepared) {
            return true;
        }
        if (this.previewMode) {
            this.previewMode = false;
            this.previewExitPendingPortrait = false;
            X1().setStackPeekSuppressed(false);
            X1().setFullTopRatio(this.previewSavedFullTopRatio);
            N0(false);
        }
        float height = X1().getHeight();
        if (height <= 0.0f) {
            return false;
        }
        this.homeGroupExitDistancePx = C5685n.e(height - X1().getPanelTopPx(), 0.0f) + (getResources().getDisplayMetrics().density * 2.0f);
        this.finishingWithAnim = true;
        this.homeGroupExitPrepared = true;
        C4145a c4145a = this.binding;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        this.homeGroupExitStartDimAlpha = c4145a.ailDimView.getAlpha();
        this.holdWindowForExitAnim = false;
        this.finishWithExitAnimRequested = false;
        androidx.dynamicanimation.animation.i iVar = this.dimSpring;
        if (iVar != null) {
            iVar.d();
        }
        this.dimSpring = null;
        U0();
        androidx.dynamicanimation.animation.i iVar2 = this.exitColorAnim;
        if (iVar2 != null) {
            iVar2.d();
        }
        this.exitColorAnim = null;
        S0("homeGroupExit");
        Animator animator = this.dismissAnimator;
        if (animator != null) {
            animator.removeAllListeners();
        }
        Animator animator2 = this.dismissAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.dismissAnimator = null;
        X1().O(true);
        X1().c0();
        X1().setDismissEnabled(false);
        X1().setDragEnabled(false);
        X1().setBottomAnchorEnabled(false);
        return true;
    }

    public SheetSpring s1() {
        return null;
    }

    public final InterfaceC5063a<Y8.t> s2(boolean extra, final InterfaceC5063a<Y8.t> onAllEnded) {
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = extra ? 2 : 1;
        return new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.F
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return O.t2(ref$IntRef, onAllEnded);
            }
        };
    }

    public final Float s3() {
        if (this.binding != null && !this.previewMode && !this.finishingWithAnim && !isFinishing() && !isDestroyed()) {
            this.sharedExitInteractionState = new SharedExitInteractionState(X1().getBottomAnchorEnabled(), X1().getDismissEnabled(), X1().getDragEnabled());
            Float fH0 = X1().h0();
            if (fH0 == null || !r3()) {
                return null;
            }
            return fH0;
        }
        return null;
    }

    public final void setSheetDragGestureHandleView(View handleView) {
        if (isDestroyed()) {
            return;
        }
        X1().setDragHandleView(handleView);
    }

    public final void setSheetDragPriorityView(View view) {
        if (isDestroyed()) {
            return;
        }
        X1().setDragPriorityView(view);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) throws Exception {
        kotlin.jvm.internal.p.i(intent, "intent");
        startActivity(intent, null);
    }

    public SheetScaleMotion t1() {
        return null;
    }

    public boolean t3() {
        return false;
    }

    public final void u0(View view, FrameLayout.LayoutParams params) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(params, "params");
        FrameLayout frameLayout = this.residentBottomSlot;
        Z1().addView(view, frameLayout != null ? C5685n.f(Z1().indexOfChild(frameLayout), 0) : Z1().getChildCount(), params);
    }

    public final SheetSettleState u1() {
        int i10 = c.$EnumSwitchMapping$1[this._heightMode.ordinal()];
        if (i10 == 1) {
            return SheetSettleState.FULL;
        }
        if (i10 == 2) {
            return SheetSettleState.HALF;
        }
        if (i10 == 3) {
            return SheetSettleState.MINIFY;
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean u2() {
        return false;
    }

    public final void u3() throws Resources.NotFoundException {
        androidx.core.view.a0 a0VarB = this.lastWindowInsets;
        if (a0VarB == null) {
            C4145a c4145a = this.binding;
            if (c4145a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a = null;
            }
            a0VarB = androidx.core.view.N.B(c4145a.b());
            if (a0VarB != null) {
                this.lastWindowInsets = a0VarB;
            } else {
                a0VarB = null;
            }
            if (a0VarB == null) {
                return;
            }
        }
        F0(this, a0VarB, false, 2, null);
    }

    public final void v0(float target, boolean enter) {
        C4145a c4145a = null;
        if (!b2() && target <= 0.0f) {
            C4145a c4145a2 = this.binding;
            if (c4145a2 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a2 = null;
            }
            c4145a2.ailDimView.setVisibility(8);
            C4145a c4145a3 = this.binding;
            if (c4145a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a = c4145a3;
            }
            c4145a.ailDimView.setAlpha(0.0f);
            return;
        }
        if (b2()) {
            androidx.dynamicanimation.animation.i iVar = this.dimSpring;
            if (iVar != null) {
                iVar.d();
            }
            C4145a c4145a4 = this.binding;
            if (c4145a4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a4 = null;
            }
            float alpha = c4145a4.ailDimView.getAlpha();
            if (target > 0.0f) {
                C4145a c4145a5 = this.binding;
                if (c4145a5 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c4145a5 = null;
                }
                c4145a5.ailDimView.setVisibility(0);
                if (alpha != target) {
                    androidx.dynamicanimation.animation.i iVarQ = a2().q(alpha, target, enter, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.H
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return O.y0(this.f27674a, ((Float) obj).floatValue());
                        }
                    });
                    iVarQ.t();
                    this.dimSpring = iVarQ;
                    return;
                } else {
                    C4145a c4145a6 = this.binding;
                    if (c4145a6 == null) {
                        kotlin.jvm.internal.p.A("binding");
                    } else {
                        c4145a = c4145a6;
                    }
                    c4145a.ailDimView.setAlpha(target);
                    return;
                }
            }
            if (alpha > 0.0f) {
                C4145a c4145a7 = this.binding;
                if (c4145a7 == null) {
                    kotlin.jvm.internal.p.A("binding");
                } else {
                    c4145a = c4145a7;
                }
                c4145a.ailDimView.setVisibility(0);
                androidx.dynamicanimation.animation.i iVarQ2 = a2().q(alpha, 0.0f, enter, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sheet.v
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return O.w0(this.f28208a, ((Float) obj).floatValue());
                    }
                });
                iVarQ2.b(new e.q() { // from class: com.stepos.ailauncher.sheet.G
                    @Override // androidx.dynamicanimation.animation.e.q
                    public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                        O.x0(this.f27673a, eVar, z10, f10, f11);
                    }
                });
                iVarQ2.t();
                this.dimSpring = iVarQ2;
                return;
            }
            C4145a c4145a8 = this.binding;
            if (c4145a8 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a8 = null;
            }
            c4145a8.ailDimView.setAlpha(0.0f);
            C4145a c4145a9 = this.binding;
            if (c4145a9 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a = c4145a9;
            }
            c4145a.ailDimView.setVisibility(8);
        }
    }

    public boolean v1() {
        return false;
    }

    public View v2() {
        return null;
    }

    public final void v3() {
        if (isDestroyed()) {
            return;
        }
        C4145a c4145a = this.binding;
        C4145a c4145a2 = null;
        if (c4145a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a = null;
        }
        c4145a.ailDimView.setBackgroundColor(j2());
        if (!b2() || this.maskPassthrough || this.previewMode) {
            C4145a c4145a3 = this.binding;
            if (c4145a3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a3 = null;
            }
            c4145a3.ailDimView.setVisibility(8);
            C4145a c4145a4 = this.binding;
            if (c4145a4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a2 = c4145a4;
            }
            c4145a2.ailDimView.setAlpha(0.0f);
            return;
        }
        float fI2 = i2();
        if (fI2 <= 0.0f) {
            C4145a c4145a5 = this.binding;
            if (c4145a5 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4145a5 = null;
            }
            c4145a5.ailDimView.setVisibility(8);
            C4145a c4145a6 = this.binding;
            if (c4145a6 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4145a2 = c4145a6;
            }
            c4145a2.ailDimView.setAlpha(0.0f);
            return;
        }
        C4145a c4145a7 = this.binding;
        if (c4145a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4145a7 = null;
        }
        c4145a7.ailDimView.setVisibility(0);
        C4145a c4145a8 = this.binding;
        if (c4145a8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4145a2 = c4145a8;
        }
        c4145a2.ailDimView.setAlpha(fI2);
    }

    public boolean w1() {
        return false;
    }

    public boolean w2() {
        return false;
    }

    public final void w3() {
        if (this.maskPassthrough) {
            J0();
        }
    }

    public SheetExitAnim x1() {
        return SheetExitAnim.NONE;
    }

    public boolean x2() {
        return false;
    }

    public final void x3() {
        ArrayList arrayList;
        String strF4 = f4();
        if (strF4 != null) {
            if (La.H.x0(strF4)) {
                strF4 = null;
            }
            if (strF4 == null) {
                return;
            }
            this.registeredUniqueInstanceKey = strF4;
            synchronized (UNIQUE_INSTANCE_LOCK) {
                try {
                    Map<String, List<WeakReference<O>>> map = UNIQUE_INSTANCES;
                    List<WeakReference<O>> arrayList2 = map.get(strF4);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                        map.put(strF4, arrayList2);
                    }
                    List<WeakReference<O>> list = arrayList2;
                    arrayList = new ArrayList();
                    Iterator<WeakReference<O>> it = list.iterator();
                    while (it.hasNext()) {
                        O o10 = it.next().get();
                        if (o10 == null || o10 == this || o10.isDestroyed() || o10.isFinishing() || o10.isChangingConfigurations()) {
                            it.remove();
                        } else {
                            arrayList.add(o10);
                            it.remove();
                        }
                    }
                    list.add(new WeakReference<>(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((O) it2.next()).I1();
            }
        }
    }

    public Integer y1() {
        return null;
    }

    public final void y3() {
        if (this.exitTouchReleased || !this.finishingWithAnim || isDestroyed()) {
            return;
        }
        this.exitTouchReleased = true;
        C3442a.INSTANCE.a(this, false);
        com.stepos.ailauncher.sheet.internal.J j10 = com.stepos.ailauncher.sheet.internal.J.INSTANCE;
        Window window = getWindow();
        kotlin.jvm.internal.p.h(window, "getWindow(...)");
        j10.i(window);
        getWindow().addFlags(16);
        Log.d(TAG, "sheet exit: release exit touch before springs end");
    }

    public final void z0() {
        if (!w2() && this.dragHandleWanted && !this.previewMode && !this.chromeTransparent) {
            q3(this, 0.34f, Float.valueOf(0.0f), "LiteSheet.enter", null, 8, null);
            return;
        }
        Log.i("DragHandleAlpha", "enter skip morphSelf=" + w2() + " wanted=" + this.dragHandleWanted + " preview=" + this.previewMode + " chromeTransparent=" + this.chromeTransparent);
    }

    public boolean z1() {
        return false;
    }

    public final void z2() {
        if (b1()) {
            P3(true);
        }
    }

    public final void z3() {
        this.dialogHoldsKeyboard = false;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle options) throws Exception {
        kotlin.jvm.internal.p.i(intent, "intent");
        SheetLaunchOptions.Companion aVar = SheetLaunchOptions.INSTANCE;
        SheetLaunchOptions d0VarA = aVar.a(intent);
        String strD = aVar.d(getIntent());
        int i10 = get_layerIndex();
        String strD2 = aVar.d(intent);
        int iC = d0VarA.getLayer();
        ComponentName component = intent.getComponent();
        this.stackPauseHandoff.c(u0.a(strD, i10, strD2, iC, kotlin.jvm.internal.p.d(component != null ? component.getPackageName() : null, getPackageName()), (intent.getFlags() & 402653184) != 0), SystemClock.uptimeMillis());
        if (B3(intent)) {
            return;
        }
        try {
            super.startActivity(intent, options);
        } catch (Exception e10) {
            this.stackPauseHandoff.a();
            throw e10;
        }
    }
}
