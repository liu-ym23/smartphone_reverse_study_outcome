package com.stepos.widget.recipient;

import La.D;
import La.H;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.glass.StepOSGlassLinearLayout;
import com.stepos.widget.glass.StepOSGlassPresets;
import com.stepos.widget.internal.HotspotRipple;
import com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView;
import com.stepos.widget.recipient.StepOSRecipientEdit;
import io.ktor.http.ContentDisposition;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u008e\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bf\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ¸\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0018¹\u0003º\u0003»\u0003¼\u0003½\u0003¾\u0003¿\u0003À\u0003Á\u0003Â\u0003Ã\u0003¸\u0003B1\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\tH\u0003¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\tH\u0003¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u0016H\u0002¢\u0006\u0004\b%\u0010\u0018J\u000f\u0010&\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010#J\u0017\u0010'\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b'\u0010!J\u0019\u0010(\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\tH\u0002¢\u0006\u0004\b,\u0010#J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\tH\u0002¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00162\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\u00162\u0006\u00105\u001a\u0002042\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0016H\u0002¢\u0006\u0004\b:\u0010\u0018J\u001f\u0010=\u001a\u00020\u00162\u0006\u0010<\u001a\u00020;2\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020\u00162\u0006\u00105\u001a\u0002042\u0006\u0010?\u001a\u00020\u0012H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00162\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\bB\u00107J!\u0010E\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\t2\b\b\u0002\u0010D\u001a\u00020\u0012H\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u0012H\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0016H\u0002¢\u0006\u0004\bJ\u0010\u0018J\u0017\u0010M\u001a\u00020\u00162\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020O2\u0006\u0010L\u001a\u00020OH\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u0012H\u0002¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0016H\u0002¢\u0006\u0004\bT\u0010\u0018J\u0017\u0010U\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u000eH\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010Z\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bZ\u0010[J\u0017\u0010\\\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\\\u0010VJ\u000f\u0010]\u001a\u00020\u0016H\u0002¢\u0006\u0004\b]\u0010\u0018J\u000f\u0010^\u001a\u00020\u0016H\u0002¢\u0006\u0004\b^\u0010\u0018J\u000f\u0010_\u001a\u00020\u0016H\u0002¢\u0006\u0004\b_\u0010\u0018J\u000f\u0010`\u001a\u00020\u0016H\u0002¢\u0006\u0004\b`\u0010\u0018J\u000f\u0010a\u001a\u00020\u0016H\u0002¢\u0006\u0004\ba\u0010\u0018J\u000f\u0010b\u001a\u00020\u0016H\u0002¢\u0006\u0004\bb\u0010\u0018J\u000f\u0010c\u001a\u00020\u0016H\u0002¢\u0006\u0004\bc\u0010\u0018J\u000f\u0010d\u001a\u00020\u0016H\u0002¢\u0006\u0004\bd\u0010\u0018J\u000f\u0010e\u001a\u00020\u0016H\u0002¢\u0006\u0004\be\u0010\u0018J\u0017\u0010h\u001a\u00020\u00162\b\u0010g\u001a\u0004\u0018\u00010f¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u0004\u0018\u00010f¢\u0006\u0004\bj\u0010kJ\u0017\u0010n\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010l¢\u0006\u0004\bn\u0010oJ\u0017\u0010q\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010p¢\u0006\u0004\bq\u0010rJ\u0017\u0010t\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010s¢\u0006\u0004\bt\u0010uJ\u0017\u0010w\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010v¢\u0006\u0004\bw\u0010xJ\u0017\u0010z\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010y¢\u0006\u0004\bz\u0010{J\u0017\u0010}\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010|¢\u0006\u0004\b}\u0010~J\u001a\u0010\u0080\u0001\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010\u007f¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001c\u0010\u0084\u0001\u001a\u00020\u00162\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u0001¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001b\u0010\u0087\u0001\u001a\u00020\u00162\t\u0010m\u001a\u0005\u0018\u00010\u0086\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001a\u0010\u0089\u0001\u001a\u00020\u00162\b\u0010m\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0018\u0010\u008c\u0001\u001a\u00020\u00162\u0007\u0010\u008b\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u008c\u0001\u0010IJ\u000f\u0010\u008d\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u008d\u0001\u0010SJ\u001a\u0010\u008f\u0001\u001a\u00020\u00162\u0007\u0010\u008e\u0001\u001a\u00020\u0012H\u0007¢\u0006\u0005\b\u008f\u0001\u0010IJ\u001b\u0010\u0091\u0001\u001a\u00020\u00162\u0007\u0010\u0090\u0001\u001a\u00020\tH\u0007¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u0018\u0010\u0094\u0001\u001a\u00020\u00162\u0007\u0010\u0093\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u0094\u0001\u0010IJ\u0019\u0010\u0096\u0001\u001a\u00020\u00162\u0007\u0010\u0095\u0001\u001a\u00020\t¢\u0006\u0006\b\u0096\u0001\u0010\u0092\u0001J\u000f\u0010\u0097\u0001\u001a\u00020\t¢\u0006\u0005\b\u0097\u0001\u0010#J$\u0010\u009a\u0001\u001a\u00020\u00162\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010\u0099\u0001\u001a\u00020\u0012¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u009c\u0001\u0010SJ\u001c\u0010\u009f\u0001\u001a\u00020\u00162\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001a\u0010¡\u0001\u001a\u00020\u00162\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u000e¢\u0006\u0005\b¡\u0001\u0010VJ\u000f\u0010¢\u0001\u001a\u00020\u0016¢\u0006\u0005\b¢\u0001\u0010\u0018J\u000f\u0010£\u0001\u001a\u00020\u0016¢\u0006\u0005\b£\u0001\u0010\u0018J\u000f\u0010¤\u0001\u001a\u00020\u0016¢\u0006\u0005\b¤\u0001\u0010\u0018J\u001a\u0010¥\u0001\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010O¢\u0006\u0006\b¥\u0001\u0010¦\u0001J$\u0010¥\u0001\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010O2\b\u0010\u0010\u001a\u0004\u0018\u00010O¢\u0006\u0006\b¥\u0001\u0010§\u0001J$\u0010¥\u0001\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010©\u0001\u001a\u0005\u0018\u00010¨\u0001¢\u0006\u0006\b¥\u0001\u0010ª\u0001J+\u0010¥\u0001\u001a\u00020\t2\u0019\u0010\u00ad\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000e0«\u0001j\t\u0012\u0004\u0012\u00020\u000e`¬\u0001¢\u0006\u0006\b¥\u0001\u0010®\u0001J\"\u0010¯\u0001\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0006\b¯\u0001\u0010°\u0001J*\u0010¯\u0001\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0006\b¯\u0001\u0010±\u0001J*\u0010¯\u0001\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0006\b¯\u0001\u0010²\u0001J1\u0010¯\u0001\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0005\b¯\u0001\u0010\u0015J\u001a\u0010³\u0001\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010O¢\u0006\u0006\b³\u0001\u0010¦\u0001J\u000f\u0010´\u0001\u001a\u00020\u0016¢\u0006\u0005\b´\u0001\u0010\u0018J,\u0010·\u0001\u001a\u00020\u00162\u0007\u0010µ\u0001\u001a\u00020\u000e2\u0007\u0010¶\u0001\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u000f\u0010¹\u0001\u001a\u00020\t¢\u0006\u0005\b¹\u0001\u0010#J\u0017\u0010»\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0º\u0001¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u001d\u0010¾\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0½\u0001¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u001e\u0010À\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030¨\u00010½\u0001¢\u0006\u0006\bÀ\u0001\u0010¿\u0001J\u0017\u0010Á\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0º\u0001¢\u0006\u0006\bÁ\u0001\u0010¼\u0001J\u0017\u0010Â\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0º\u0001¢\u0006\u0006\bÂ\u0001\u0010¼\u0001J\u000f\u0010Ã\u0001\u001a\u00020\u0016¢\u0006\u0005\bÃ\u0001\u0010\u0018J\u000f\u0010Ä\u0001\u001a\u00020\u0016¢\u0006\u0005\bÄ\u0001\u0010\u0018J+\u0010Æ\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000e0«\u0001j\t\u0012\u0004\u0012\u00020\u000e`¬\u00012\u0007\u0010Å\u0001\u001a\u00020\t¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u0019\u0010È\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010º\u0001¢\u0006\u0006\bÈ\u0001\u0010¼\u0001J\u000f\u0010É\u0001\u001a\u00020\u0012¢\u0006\u0005\bÉ\u0001\u0010SJ\u000f\u0010Ê\u0001\u001a\u00020\u0012¢\u0006\u0005\bÊ\u0001\u0010SJ\u0010\u0010Ë\u0001\u001a\u00020\u000e¢\u0006\u0006\bË\u0001\u0010Ì\u0001J\u0011\u0010Î\u0001\u001a\u00030Í\u0001¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u0011\u0010Ñ\u0001\u001a\u00030Ð\u0001¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J\u001b\u0010Ô\u0001\u001a\u00020\u00162\t\u0010m\u001a\u0005\u0018\u00010Ó\u0001¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u0019\u0010\u009f\u0001\u001a\u00020\u00162\u0007\u0010Ö\u0001\u001a\u00020\t¢\u0006\u0006\b\u009f\u0001\u0010\u0092\u0001J\u0018\u0010Ø\u0001\u001a\u00020\u00162\u0007\u0010×\u0001\u001a\u00020\u0012¢\u0006\u0005\bØ\u0001\u0010IJ\u001b\u0010Ú\u0001\u001a\u00020\u00162\t\b\u0001\u0010Ù\u0001\u001a\u00020\t¢\u0006\u0006\bÚ\u0001\u0010\u0092\u0001J\u001a\u0010Ü\u0001\u001a\u00020\u00162\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u000e¢\u0006\u0005\bÜ\u0001\u0010VJ\u0019\u0010Þ\u0001\u001a\u00020\u00162\u0007\u0010Ý\u0001\u001a\u00020-¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J&\u0010á\u0001\u001a\u00020\u00162\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u000e2\t\b\u0001\u0010à\u0001\u001a\u00020\t¢\u0006\u0006\bá\u0001\u0010â\u0001J\u000f\u0010ã\u0001\u001a\u00020\u0016¢\u0006\u0005\bã\u0001\u0010\u0018J\u001e\u0010æ\u0001\u001a\u00020\u00162\n\u0010å\u0001\u001a\u0005\u0018\u00010ä\u0001H\u0016¢\u0006\u0006\bæ\u0001\u0010ç\u0001J\u001a\u0010è\u0001\u001a\u00020\u00122\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0006\bè\u0001\u0010é\u0001J\u0018\u0010Ä\u0001\u001a\u00020\u00162\u0007\u0010ê\u0001\u001a\u00020\u0012¢\u0006\u0005\bÄ\u0001\u0010IJ\u001e\u0010ì\u0001\u001a\u00020\u00162\n\u0010ë\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016¢\u0006\u0006\bì\u0001\u0010 \u0001J\u001e\u0010í\u0001\u001a\u00020\u00122\n\u0010ë\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016¢\u0006\u0006\bí\u0001\u0010î\u0001J\u001a\u0010ï\u0001\u001a\u00020\u00122\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0006\bï\u0001\u0010é\u0001J'\u0010ñ\u0001\u001a\u00020\u00162\n\u0010ë\u0001\u001a\u0005\u0018\u00010\u009d\u00012\u0007\u0010ð\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0006\bñ\u0001\u0010ò\u0001J'\u0010ö\u0001\u001a\u00020\u00122\u0007\u0010ó\u0001\u001a\u00020\t2\n\u0010õ\u0001\u001a\u0005\u0018\u00010ô\u0001H\u0016¢\u0006\u0006\bö\u0001\u0010÷\u0001J\u001a\u0010ù\u0001\u001a\u00020\u00162\u0007\u0010ø\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bù\u0001\u0010IJ\u001a\u0010û\u0001\u001a\u00020\u00162\u0007\u0010ú\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bû\u0001\u0010IJ6\u0010\u0080\u0002\u001a\u00020\u00162\u0007\u0010ü\u0001\u001a\u00020\t2\u0007\u0010ý\u0001\u001a\u00020\t2\u0007\u0010þ\u0001\u001a\u00020\t2\u0007\u0010ÿ\u0001\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0080\u0002\u0010\u0081\u0002J\u001f\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0084\u00022\b\u0010\u0083\u0002\u001a\u00030\u0082\u0002H\u0016¢\u0006\u0006\b\u0085\u0002\u0010\u0086\u0002J\u001b\u0010\u0088\u0002\u001a\u00020\u00122\u0007\u0010<\u001a\u00030\u0087\u0002H\u0016¢\u0006\u0006\b\u0088\u0002\u0010\u0089\u0002J\u001c\u0010\u008c\u0002\u001a\u00020\u00162\b\u0010\u008b\u0002\u001a\u00030\u008a\u0002H\u0016¢\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002J$\u0010\u0090\u0002\u001a\u00020\u00162\u0007\u0010\u008e\u0002\u001a\u00020\t2\u0007\u0010\u008f\u0002\u001a\u00020\tH\u0014¢\u0006\u0006\b\u0090\u0002\u0010\u0091\u0002J?\u0010\u0093\u0002\u001a\u00020\u00162\u0007\u0010\u0092\u0002\u001a\u00020\u00122\u0007\u0010ü\u0001\u001a\u00020\t2\u0007\u0010ý\u0001\u001a\u00020\t2\u0007\u0010þ\u0001\u001a\u00020\t2\u0007\u0010ÿ\u0001\u001a\u00020\tH\u0014¢\u0006\u0006\b\u0093\u0002\u0010\u0094\u0002J\u0011\u0010\u0095\u0002\u001a\u00020\u0016H\u0014¢\u0006\u0005\b\u0095\u0002\u0010\u0018J\u0011\u0010\u0096\u0002\u001a\u00020\u0016H\u0014¢\u0006\u0005\b\u0096\u0002\u0010\u0018J\u001c\u0010\u0099\u0002\u001a\u00020\u00162\b\u0010\u0098\u0002\u001a\u00030\u0097\u0002H\u0014¢\u0006\u0006\b\u0099\u0002\u0010\u009a\u0002J\u001a\u0010\u009c\u0002\u001a\u00020\u00162\u0007\u0010\u009b\u0002\u001a\u00020\u0012H\u0016¢\u0006\u0005\b\u009c\u0002\u0010IJ\u0013\u0010\u009e\u0002\u001a\u00030\u009d\u0002H\u0014¢\u0006\u0006\b\u009e\u0002\u0010\u009f\u0002J\u001e\u0010¡\u0002\u001a\u00020\u00162\n\u0010 \u0002\u001a\u0005\u0018\u00010\u009d\u0002H\u0014¢\u0006\u0006\b¡\u0002\u0010¢\u0002J\u0011\u0010¤\u0002\u001a\u00020\u0012H\u0000¢\u0006\u0005\b£\u0002\u0010SR\u0018\u0010¦\u0002\u001a\u00030¥\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0002\u0010§\u0002R\u0018\u0010©\u0002\u001a\u00030¨\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0002\u0010ª\u0002R\u0018\u0010«\u0002\u001a\u00030¨\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0002\u0010ª\u0002R\u0018\u0010¬\u0002\u001a\u00030¨\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0002\u0010ª\u0002R\u0018\u0010\u00ad\u0002\u001a\u00030Ð\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u0018\u0010°\u0002\u001a\u00030¯\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0002\u0010±\u0002R\u0018\u0010²\u0002\u001a\u00030Í\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0002\u0010³\u0002R\u0018\u0010µ\u0002\u001a\u00030´\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R)\u0010·\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u000e0«\u0001j\t\u0012\u0004\u0012\u00020\u000e`¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0002\u0010¸\u0002R5\u0010»\u0002\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0¹\u0002j\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`º\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0002\u0010¼\u0002R7\u0010½\u0002\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030¨\u00010¹\u0002j\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0005\u0012\u00030¨\u0001`º\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0002\u0010¼\u0002R\u001b\u0010¾\u0002\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0002\u0010¿\u0002R\u001b\u0010À\u0002\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0002\u0010Á\u0002R\u001c\u0010Ã\u0002\u001a\u0005\u0018\u00010Â\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0002\u0010Ä\u0002R\u001c\u0010Æ\u0002\u001a\u0005\u0018\u00010Å\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0002\u0010Ç\u0002R\u0018\u0010È\u0002\u001a\u00030Å\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0002\u0010Ç\u0002R\u0019\u0010É\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010Ê\u0002R\u0018\u0010Ì\u0002\u001a\u00030Ë\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0002\u0010Í\u0002R\u0019\u0010Î\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0002\u0010Ê\u0002R\u0018\u0010Ï\u0002\u001a\u00030Ë\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÏ\u0002\u0010Í\u0002R\u001b\u0010Ð\u0002\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010Ñ\u0002R\u001b\u0010Ò\u0002\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010Ó\u0002R\u001b\u0010Ô\u0002\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0002\u0010Õ\u0002R\u001b\u0010Ö\u0002\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0002\u0010×\u0002R\u001b\u0010Ø\u0002\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0002\u0010Ù\u0002R\u001b\u0010Ú\u0002\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0002\u0010Û\u0002R\u001c\u0010Ü\u0002\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0002\u0010Ý\u0002R\u001c\u0010Þ\u0002\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0002\u0010ß\u0002R\u001b\u0010à\u0002\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0002\u0010á\u0002R\u0019\u0010â\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0002\u0010Ê\u0002R\u0019\u0010ã\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0002\u0010ä\u0002R\u0018\u0010å\u0002\u001a\u00030Ë\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0002\u0010Í\u0002R\u0019\u0010æ\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0002\u0010Ê\u0002R\u0019\u0010ç\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0002\u0010Ê\u0002R\u0018\u0010è\u0002\u001a\u00030Ë\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0002\u0010Í\u0002R\u0019\u0010é\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0002\u0010ä\u0002R\u0019\u0010ê\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0002\u0010Ê\u0002R\u001b\u0010ë\u0002\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0002\u0010ì\u0002R\u0019\u0010í\u0002\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bí\u0002\u0010ä\u0002R+\u0010î\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u000e0«\u0001j\t\u0012\u0004\u0012\u00020\u000e`¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0002\u0010¸\u0002R\u0019\u0010ï\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0002\u0010Ê\u0002R\u001c\u0010ð\u0002\u001a\u0005\u0018\u00010ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0002\u0010ñ\u0002R\u0019\u0010ò\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0002\u0010ä\u0002R\u0019\u0010ó\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0002\u0010Ê\u0002R\u0019\u0010ô\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0002\u0010Ê\u0002R\u0019\u0010õ\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0002\u0010Ê\u0002R\u0019\u0010ö\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0002\u0010Ê\u0002R3\u0010ø\u0002\u001a\u00020\t2\t\b\u0001\u0010÷\u0002\u001a\u00020\t8G@FX\u0086\u000e¢\u0006\u0017\n\u0006\bø\u0002\u0010ä\u0002\u001a\u0005\bù\u0002\u0010#\"\u0006\bú\u0002\u0010\u0092\u0001R0\u0010û\u0002\u001a\u00020\u00122\u0007\u0010÷\u0002\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\bû\u0002\u0010Ê\u0002\u001a\u0005\bû\u0002\u0010S\"\u0005\bü\u0002\u0010IR1\u0010ý\u0002\u001a\u00020\t2\u0007\u0010÷\u0002\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\bý\u0002\u0010ä\u0002\u001a\u0005\bþ\u0002\u0010#\"\u0006\bÿ\u0002\u0010\u0092\u0001R8\u0010\u0080\u0003\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010÷\u0002\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0003\u0010\u0081\u0003\u001a\u0006\b\u0082\u0003\u0010\u0083\u0003\"\u0006\b\u0084\u0003\u0010\u0085\u0003R8\u0010\u0086\u0003\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010÷\u0002\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0003\u0010\u0081\u0003\u001a\u0006\b\u0087\u0003\u0010\u0083\u0003\"\u0006\b\u0088\u0003\u0010\u0085\u0003R8\u0010\u0089\u0003\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010÷\u0002\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0089\u0003\u0010\u0081\u0003\u001a\u0006\b\u008a\u0003\u0010\u0083\u0003\"\u0006\b\u008b\u0003\u0010\u0085\u0003R8\u0010\u008c\u0003\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010÷\u0002\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u008c\u0003\u0010\u0081\u0003\u001a\u0006\b\u008d\u0003\u0010\u0083\u0003\"\u0006\b\u008e\u0003\u0010\u0085\u0003R8\u0010\u008f\u0003\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010÷\u0002\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u008f\u0003\u0010\u0081\u0003\u001a\u0006\b\u0090\u0003\u0010\u0083\u0003\"\u0006\b\u0091\u0003\u0010\u0085\u0003R8\u0010\u0092\u0003\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010÷\u0002\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0003\u0010\u0081\u0003\u001a\u0006\b\u0093\u0003\u0010\u0083\u0003\"\u0006\b\u0094\u0003\u0010\u0085\u0003R8\u0010\u0095\u0003\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010÷\u0002\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0003\u0010\u0081\u0003\u001a\u0006\b\u0096\u0003\u0010\u0083\u0003\"\u0006\b\u0097\u0003\u0010\u0085\u0003R8\u0010\u0098\u0003\u001a\u0004\u0018\u00010\t2\u000b\b\u0001\u0010÷\u0002\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0003\u0010\u0081\u0003\u001a\u0006\b\u0099\u0003\u0010\u0083\u0003\"\u0006\b\u009a\u0003\u0010\u0085\u0003R1\u0010\u009b\u0003\u001a\u00020\t2\u0007\u0010÷\u0002\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b\u009b\u0003\u0010ä\u0002\u001a\u0005\b\u009c\u0003\u0010#\"\u0006\b\u009d\u0003\u0010\u0092\u0001R0\u0010\u009e\u0003\u001a\u00020\u00122\u0007\u0010÷\u0002\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u009e\u0003\u0010Ê\u0002\u001a\u0005\b\u009e\u0003\u0010S\"\u0005\b\u009f\u0003\u0010IR0\u0010 \u0003\u001a\u00020\u00122\u0007\u0010÷\u0002\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b \u0003\u0010Ê\u0002\u001a\u0005\b \u0003\u0010S\"\u0005\b¡\u0003\u0010IR'\u0010¢\u0003\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b¢\u0003\u0010Ê\u0002\u001a\u0005\b¢\u0003\u0010S\"\u0005\b£\u0003\u0010IR0\u0010¤\u0003\u001a\u00020\u00122\u0007\u0010÷\u0002\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b¤\u0003\u0010Ê\u0002\u001a\u0005\b¤\u0003\u0010S\"\u0005\b¥\u0003\u0010IR0\u0010¦\u0003\u001a\u00020\u00122\u0007\u0010÷\u0002\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b¦\u0003\u0010Ê\u0002\u001a\u0005\b¦\u0003\u0010S\"\u0005\b§\u0003\u0010IR)\u0010¨\u0003\u001a\u00020\t2\u0007\u0010÷\u0002\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\b¨\u0003\u0010ä\u0002\u001a\u0005\b©\u0003\u0010#R\u0018\u0010ª\u0003\u001a\u00030Ë\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0003\u0010Í\u0002R.\u0010¯\u0003\u001a\u0004\u0018\u00010O2\t\u0010÷\u0002\u001a\u0004\u0018\u00010O8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b«\u0003\u0010¬\u0003\"\u0006\b\u00ad\u0003\u0010®\u0003R(\u0010°\u0003\u001a\u00020\u00122\u0007\u0010÷\u0002\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b°\u0003\u0010S\"\u0005\b±\u0003\u0010IR0\u0010·\u0003\u001a\u0005\u0018\u00010²\u00032\n\u0010÷\u0002\u001a\u0005\u0018\u00010²\u00038F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b³\u0003\u0010´\u0003\"\u0006\bµ\u0003\u0010¶\u0003¨\u0006Ä\u0003"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Landroid/view/View$OnFocusChangeListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", Const.JSON_KEY_NUMBER, "contactName", "dragPos", "", com.stepos.ailauncher.chat.trace.g.ACTION_REFRESH, "insertRecipient", "(Ljava/lang/String;Ljava/lang/String;IZ)Z", "LY8/t;", "focusInput", "()V", "stretchRowToOwnHeight", Const.JSON_KEY_ADDRESS, "name", "Lcom/stepos/widget/recipient/StepOSRecipientChip;", "createChip", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/widget/recipient/StepOSRecipientChip;", "chip", "applyChipAppearance", "(Lcom/stepos/widget/recipient/StepOSRecipientChip;)V", "restingChipBgColor", "()I", "selectedChipTextColor", "refreshChipColors", "invalidateColor", "openContactDetail", "findChip", "(Ljava/lang/String;)Lcom/stepos/widget/recipient/StepOSRecipientChip;", "lastChip", "()Lcom/stepos/widget/recipient/StepOSRecipientChip;", "editChildIndex", "", "eventX", "destChipIndex", "(F)I", "preferred", "insertChipBeforeEdit", "(Lcom/stepos/widget/recipient/StepOSRecipientChip;I)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$DragPayload;", "payload", "detachDragChip", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$DragPayload;)V", "moveDragChip", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$DragPayload;F)V", "syncDataToChipOrder", "Landroid/view/DragEvent;", "event", "acceptForeignDrop", "(Landroid/view/DragEvent;Lcom/stepos/widget/recipient/StepOSRecipientEdit$DragPayload;)V", "accepted", "finishLocalDrag", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$DragPayload;Z)V", "restoreDragChip", "index", "notify", "removeRecipientAt", "(IZ)Z", "focused", "refreshCollapsedState", "(Z)V", "commitOrClearInputOnBlur", "Landroid/text/Editable;", "s", "handleAfterTextChanged", "(Landroid/text/Editable;)V", "", "splitRecipient", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "handleDeleteKey", "()Z", "notifySingleRecipientWhenGroup", "clearSingleRecipientFlag", "(Ljava/lang/String;)V", "cons", "removeSpecialCharacter", "(Ljava/lang/String;)Ljava/lang/String;", "isValidRecipient", "(Ljava/lang/String;)Z", "updateSingleRecipientFlag", "applyEditInputType", "applyTextAppearance", "applyHintTextColor", "applyAddButtonRipple", "applyContentTextColor", "applyDefaultGlass", "applyGlassFallback", "expandAddButtonTouchTarget", "dispatchChanged", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "adapter", "setAdapter", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;)V", "getAdapter", "()Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "Landroid/widget/AdapterView$OnItemClickListener;", "listener", "setOnItemClickListener", "(Landroid/widget/AdapterView$OnItemClickListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientChangedListener;", "setOnRecipientChangedListener", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientChangedListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientSimpleChangedListener;", "setOnRecipientSimpleChangedListener", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientSimpleChangedListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientFirstAddListener;", "setOnRecipientFirstAddListener", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientFirstAddListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnSingleRecipientAddWhenGroupListener;", "setOnSingleRecipientAddWhenGroupListener", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnSingleRecipientAddWhenGroupListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnTextChangedListener;", "setOnTextChangedListener", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnTextChangedListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnDropDownListener;", "setOnDropDownListener", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnDropDownListener;)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$RecipientDragWatcher;", "watcher", "setDragWatcher", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$RecipientDragWatcher;)V", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientSipStateCheckListener;", "setRecipientSipStateCheckListener", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientSipStateCheckListener;)V", "setButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "visible", "setButtonVisibility", "getButtonVisibility", "recognition", "setIsValidateRecognition", "type", "setRecipientColorType", "(I)V", x5.d.EXTRA_ENABLED, "setEnabledDrag", "imeOptions", "setImeOptions", "getImeOptions", "text", "filter", "setText", "(Ljava/lang/CharSequence;Z)V", "isPopupShowing", "Landroid/view/View;", "view", "setDropDownAnchor", "(Landroid/view/View;)V", "setHeaderText", "setHideHintView", "enableF12Optimize", "completeInput", "addRecipient", "(Ljava/lang/CharSequence;)Z", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z", "Lcom/stepos/widget/recipient/StepOSContactInfo;", "contactInfo", "(Ljava/lang/String;Lcom/stepos/widget/recipient/StepOSContactInfo;)Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "(Ljava/util/ArrayList;)I", "addRecipientInternal", "(Ljava/lang/String;Ljava/lang/String;)Z", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "(Ljava/lang/String;Ljava/lang/String;I)Z", "removeRecipient", "removeAll", "phoneOrEmail", "to", "changeContact", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRecipientCount", "", "getRecipientDataList", "()Ljava/util/List;", "", "getRecipientMap", "()Ljava/util/Map;", "getRecipientsInfo", "getValidNumbers", "getRecipients", "refreshRecipientEditLayout", "refreshLayout", "singleRecipientType", "removeSingleRecipientWhenGroup", "(I)Ljava/util/ArrayList;", "getAllNumbers", "hasInvalidRecipient", "hasValidRecipient", "getInputText", "()Ljava/lang/String;", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView;", "getRecipientAutoCompleteTextView", "()Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView;", "Landroid/widget/ScrollView;", "getRecipientScrollView", "()Landroid/widget/ScrollView;", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnKeyPreImeListener;", "setOnKeyPreImeListener", "(Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView$OnKeyPreImeListener;)V", "anchorId", "noBackground", "setNoBackground", "resId", "setTextAppearance", "familyName", "setTypefaceFromAttrs", ContentDisposition.Parameters.Size, "setLabelTextSize", "(F)V", "color", "setHintText", "(Ljava/lang/String;I)V", "recoveryToDragBefore", "Landroid/view/View$OnDragListener;", "l", "setOnDragListener", "(Landroid/view/View$OnDragListener;)V", "dispatchDragEvent", "(Landroid/view/DragEvent;)Z", "focus", "v", "onClick", "onLongClick", "(Landroid/view/View;)Z", "onDragEvent", "hasFocus", "onFocusChange", "(Landroid/view/View;Z)V", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "requestFocus", "(ILandroid/graphics/Rect;)Z", "focusable", "setFocusable", "focusableInTouchMode", "setFocusableInTouchMode", "left", "top", "right", "bottom", "setPadding", "(IIII)V", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "Landroid/view/KeyEvent;", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "onLayout", "(ZIIII)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "hasWindowFocus", "onWindowFocusChanged", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", VoiceWakeupReceiver.EXTRA_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "onImeDeleteFromChip$StepOSWidget_release", "onImeDeleteFromChip", "Lcom/stepos/widget/glass/StepOSGlassLinearLayout;", "glassRow", "Lcom/stepos/widget/glass/StepOSGlassLinearLayout;", "Landroid/widget/TextView;", "hintView", "Landroid/widget/TextView;", "summaryHint", "summaryName", "scrollView", "Landroid/widget/ScrollView;", "Lcom/stepos/widget/recipient/StepOSRecipientChipFlow;", "chipFlow", "Lcom/stepos/widget/recipient/StepOSRecipientChipFlow;", "editView", "Lcom/stepos/widget/recipient/StepOSRecipientAutoCompleteTextView;", "Landroid/widget/ImageButton;", "addButton", "Landroid/widget/ImageButton;", "recipientData", "Ljava/util/ArrayList;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "recipientNames", "Ljava/util/LinkedHashMap;", "recipientInfo", "recipientAdapter", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "selectedChip", "Lcom/stepos/widget/recipient/StepOSRecipientChip;", "Landroid/os/HandlerThread;", "queryThread", "Landroid/os/HandlerThread;", "Landroid/os/Handler;", "queryHandler", "Landroid/os/Handler;", "mainHandler", "refreshPosted", "Z", "Ljava/lang/Runnable;", "expandTouchTarget", "Ljava/lang/Runnable;", "collapseUnlessFocused", "restoreCollapsedIfUnfocused", "onRecipientChangedListener", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientChangedListener;", "onRecipientSimpleChangedListener", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientSimpleChangedListener;", "onRecipientFirstAddListener", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientFirstAddListener;", "onSingleAddWhenGroupListener", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnSingleRecipientAddWhenGroupListener;", "onTextChangedListener", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnTextChangedListener;", "onDropDownListener", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnDropDownListener;", "dragWatcher", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$RecipientDragWatcher;", "sipStateCheckListener", "Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientSipStateCheckListener;", "buttonClickListener", "Landroid/view/View$OnClickListener;", "listenFocusChange", "internalFocusChangeCount", "I", "notifyFocusLost", "inAfterTextChanged", "refreshNeededFromTextChange", "deferredRefresh", "changeCount", "f12OptimizeEnabled", "customHintText", "Ljava/lang/String;", "customHintColor", "dragSnapshot", "inDrag", "hostDragListener", "Landroid/view/View$OnDragListener;", "firstDragIndex", "dragStarted", "dragDropped", "dragEnded", "isDragRecovery", UxipConstants.f30680s, "maxHeight", "getMaxHeight", "setMaxHeight", "isEasyMode", "setEasyMode", "colorType", "getColorType", "setColorType", "textColor", "Ljava/lang/Integer;", "getTextColor", "()Ljava/lang/Integer;", "setTextColor", "(Ljava/lang/Integer;)V", "chipTextColor", "getChipTextColor", "setChipTextColor", "hintTextColor", "getHintTextColor", "setHintTextColor", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "chipBackgroundColor", "getChipBackgroundColor", "setChipBackgroundColor", "selectedChipBackgroundColor", "getSelectedChipBackgroundColor", "setSelectedChipBackgroundColor", "invalidTextColor", "getInvalidTextColor", "setInvalidTextColor", "rippleColor", "getRippleColor", "setRippleColor", "inputType", "getInputType", "setInputType", "isAddButtonVisible", "setAddButtonVisible", "isHintVisible", "setHintVisible", "isDragEnabled", "setDragEnabled", "isValidateRecognition", "setValidateRecognition", "isChipBackgroundEnabled", "setChipBackgroundEnabled", "singleRecipientFlag", "getSingleRecipientFlag", "refreshNamesRunnable", "getHint", "()Ljava/lang/CharSequence;", "setHint", "(Ljava/lang/CharSequence;)V", "hint", "isGlassEnabled", "setGlassEnabled", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "glassEffect", "Companion", "ColorType", "OnRecipientChangedListener", "OnRecipientSimpleChangedListener", "OnRecipientFirstAddListener", "OnSingleRecipientAddWhenGroupListener", "OnTextChangedListener", "OnDropDownListener", "RecipientDragWatcher", "OnRecipientSipStateCheckListener", "DragPayload", "SavedState", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSRecipientEdit extends FrameLayout implements View.OnClickListener, View.OnLongClickListener, View.OnFocusChangeListener {
    public static final int COLOR_TYPE_CALENDAR = 2;
    public static final int COLOR_TYPE_EMAIL = 0;
    public static final int COLOR_TYPE_SMS = 1;
    public static final int SINGLE_RECIPIENT_MASK = 6;
    private final ImageButton addButton;
    private View.OnClickListener buttonClickListener;
    private int changeCount;
    private Integer chipBackgroundColor;
    private final StepOSRecipientChipFlow chipFlow;
    private Integer chipTextColor;
    private boolean collapseUnlessFocused;
    private int colorType;
    private int customHintColor;
    private String customHintText;
    private final Runnable deferredRefresh;
    private boolean dragDropped;
    private boolean dragEnded;
    private ArrayList<String> dragSnapshot;
    private boolean dragStarted;
    private RecipientDragWatcher dragWatcher;
    private final StepOSRecipientAutoCompleteTextView editView;
    private final Runnable expandTouchTarget;
    private boolean f12OptimizeEnabled;
    private int firstDragIndex;
    private final StepOSGlassLinearLayout glassRow;
    private Integer hintTextColor;
    private final TextView hintView;
    private View.OnDragListener hostDragListener;
    private boolean inAfterTextChanged;
    private boolean inDrag;
    private int inputType;
    private int internalFocusChangeCount;
    private Integer invalidTextColor;
    private boolean isAddButtonVisible;
    private boolean isChipBackgroundEnabled;
    private boolean isDragEnabled;
    private boolean isDragRecovery;
    private boolean isEasyMode;
    private boolean isHintVisible;
    private boolean isValidateRecognition;
    private boolean listenFocusChange;
    private final Handler mainHandler;
    private int maxHeight;
    private final Runnable notifyFocusLost;
    private OnDropDownListener onDropDownListener;
    private OnRecipientChangedListener onRecipientChangedListener;
    private OnRecipientFirstAddListener onRecipientFirstAddListener;
    private OnRecipientSimpleChangedListener onRecipientSimpleChangedListener;
    private OnSingleRecipientAddWhenGroupListener onSingleAddWhenGroupListener;
    private OnTextChangedListener onTextChangedListener;
    private Handler queryHandler;
    private HandlerThread queryThread;
    private StepOSRecipientBaseAdapter recipientAdapter;
    private final ArrayList<String> recipientData;
    private final LinkedHashMap<String, StepOSContactInfo> recipientInfo;
    private final LinkedHashMap<String, String> recipientNames;
    private final Runnable refreshNamesRunnable;
    private boolean refreshNeededFromTextChange;
    private boolean refreshPosted;
    private final Runnable restoreCollapsedIfUnfocused;
    private Integer rippleColor;
    private final ScrollView scrollView;
    private StepOSRecipientChip selectedChip;
    private Integer selectedChipBackgroundColor;
    private Integer selectedTextColor;
    private int singleRecipientFlag;
    private OnRecipientSipStateCheckListener sipStateCheckListener;
    private final TextView summaryHint;
    private final TextView summaryName;
    private Integer textColor;

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$ColorType;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface ColorType {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$DragPayload;", "", "chip", "Lcom/stepos/widget/recipient/StepOSRecipientChip;", Const.JSON_KEY_ADDRESS, "", "source", "Lcom/stepos/widget/recipient/StepOSRecipientEdit;", "<init>", "(Lcom/stepos/widget/recipient/StepOSRecipientChip;Ljava/lang/String;Lcom/stepos/widget/recipient/StepOSRecipientEdit;)V", "getChip", "()Lcom/stepos/widget/recipient/StepOSRecipientChip;", "getAddress", "()Ljava/lang/String;", "getSource", "()Lcom/stepos/widget/recipient/StepOSRecipientEdit;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DragPayload {
        private final String address;
        private final StepOSRecipientChip chip;
        private final StepOSRecipientEdit source;

        public DragPayload(StepOSRecipientChip chip, String address, StepOSRecipientEdit source) {
            kotlin.jvm.internal.p.i(chip, "chip");
            kotlin.jvm.internal.p.i(address, "address");
            kotlin.jvm.internal.p.i(source, "source");
            this.chip = chip;
            this.address = address;
            this.source = source;
        }

        public final String getAddress() {
            return this.address;
        }

        public final StepOSRecipientChip getChip() {
            return this.chip;
        }

        public final StepOSRecipientEdit getSource() {
            return this.source;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnDropDownListener;", "", "", "showing", "LY8/t;", "onDropDownVisibilityChanged", "(Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnDropDownListener {
        void onDropDownVisibilityChanged(boolean showing);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientChangedListener;", "", "LY8/t;", "onRecipientChanged", "()V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnRecipientChangedListener {
        void onRecipientChanged();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientFirstAddListener;", "", "LY8/t;", "onRecipientFirstAdd", "()V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnRecipientFirstAddListener {
        void onRecipientFirstAdd();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientSimpleChangedListener;", "", "Lcom/stepos/widget/recipient/StepOSRecipientEdit;", "edit", "LY8/t;", "onRecipientSimpleChanged", "(Lcom/stepos/widget/recipient/StepOSRecipientEdit;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnRecipientSimpleChangedListener {
        void onRecipientSimpleChanged(StepOSRecipientEdit edit);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnRecipientSipStateCheckListener;", "", "", Const.JSON_KEY_ADDRESS, "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onRecipientSipStateCheck", "(Ljava/lang/String;I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnRecipientSipStateCheckListener {
        void onRecipientSipStateCheck(String address, int state);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnSingleRecipientAddWhenGroupListener;", "", "", "flag", "LY8/t;", "onSingleRecipientAddWhenGroup", "(I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnSingleRecipientAddWhenGroupListener {
        void onSingleRecipientAddWhenGroup(int flag);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$OnTextChangedListener;", "", "", "s", "", "start", "before", "count", "LY8/t;", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnTextChangedListener {
        void onTextChanged(CharSequence s10, int start, int before, int count);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$RecipientDragWatcher;", "", "<init>", "()V", "", Const.JSON_KEY_ADDRESS, "LY8/t;", "onDragStarted", "(Ljava/lang/String;)V", "", "accepted", "onDragEnded", "(Ljava/lang/String;Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class RecipientDragWatcher {
        public void onDragEnded(String address, boolean accepted) {
            kotlin.jvm.internal.p.i(address, "address");
        }

        public void onDragStarted(String address) {
            kotlin.jvm.internal.p.i(address, "address");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientEdit(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$10(StepOSRecipientEdit stepOSRecipientEdit, TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 5 && i10 != 6) {
            return false;
        }
        stepOSRecipientEdit.completeInput();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$11(StepOSRecipientEdit stepOSRecipientEdit, boolean z10) {
        OnDropDownListener onDropDownListener = stepOSRecipientEdit.onDropDownListener;
        if (onDropDownListener != null) {
            onDropDownListener.onDropDownVisibilityChanged(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$9(StepOSRecipientEdit stepOSRecipientEdit) {
        return !stepOSRecipientEdit.collapseUnlessFocused;
    }

    private final void acceptForeignDrop(DragEvent event, DragPayload payload) {
        detachDragChip(payload);
        ClipData clipData = event.getClipData();
        if (clipData == null || clipData.getItemCount() == 0) {
            return;
        }
        Rfc822Token[] rfc822TokenArr = Rfc822Tokenizer.tokenize(clipData.getItemAt(0).coerceToText(getContext()));
        kotlin.jvm.internal.p.f(rfc822TokenArr);
        if (rfc822TokenArr.length == 0) {
            return;
        }
        int iN = C5685n.n(destChipIndex(event.getX()), 0, this.recipientData.size());
        String address = rfc822TokenArr[0].getAddress();
        if (address == null || addRecipientInternal(address, rfc822TokenArr[0].getName(), iN, true)) {
            return;
        }
        ViewParent parent = payload.getChip().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(payload.getChip());
        }
        payload.getChip().setVisibility(8);
    }

    private final void applyAddButtonRipple() {
        HotspotRipple hotspotRipple = HotspotRipple.INSTANCE;
        ImageButton imageButton = this.addButton;
        Integer num = this.rippleColor;
        HotspotRipple.install$StepOSWidget_release$default(hotspotRipple, imageButton, num != null ? num.intValue() : androidx.core.content.a.c(getContext(), R.color.stepos_recipient_ripple), getResources().getDimension(R.dimen.stepos_recipient_add_size) / 2.0f, false, false, 0.0f, 56, null);
    }

    private final void applyChipAppearance(StepOSRecipientChip chip) throws Resources.NotFoundException {
        int iC;
        int iRestingChipBgColor;
        Integer num;
        boolean z10 = this.selectedChip == chip || chip.isFocused();
        if (this.isValidateRecognition && !isValidRecipient(chip.address)) {
            iC = invalidateColor();
        } else if (z10) {
            iC = selectedChipTextColor();
        } else {
            Integer num2 = this.chipTextColor;
            if (num2 == null) {
                Integer num3 = this.textColor;
                if (num3 == null) {
                    iC = this.isChipBackgroundEnabled ? androidx.core.content.a.c(getContext(), R.color.stepos_recipient_chip_text) : androidx.core.content.a.c(getContext(), R.color.stepos_recipient_text);
                } else {
                    if (num3 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    iC = num3.intValue();
                }
            } else {
                if (num2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                iC = num2.intValue();
            }
        }
        chip.setTextAppearance(this.isEasyMode ? R.style.StepOSTextAppearance_Recipient_Easy : R.style.StepOSTextAppearance_Recipient);
        if (!z10 || (num = this.selectedChipBackgroundColor) == null) {
            iRestingChipBgColor = restingChipBgColor();
        } else {
            if (num == null) {
                throw new IllegalStateException("Required value was null.");
            }
            iRestingChipBgColor = num.intValue();
        }
        chip.applyColors(iC, iRestingChipBgColor, z10, this.isChipBackgroundEnabled);
    }

    private final void applyContentTextColor() {
        Integer num = this.textColor;
        this.editView.setTextColor(num != null ? num.intValue() : androidx.core.content.a.c(getContext(), R.color.stepos_recipient_input_text));
        if (this.customHintText != null) {
            return;
        }
        this.summaryName.setTextColor(num != null ? num.intValue() : androidx.core.content.a.c(getContext(), R.color.stepos_recipient_text));
    }

    private final void applyDefaultGlass() {
        float f10 = getResources().getDisplayMetrics().density;
        boolean z10 = (getResources().getConfiguration().uiMode & 48) == 32;
        this.glassRow.setGlassCornerRadius(getResources().getDimension(R.dimen.stepos_recipient_row_corner_radius));
        if (z10) {
            this.glassRow.applyCustomGlass(StepOSGlassPresets.INSTANCE.TITLE_BAR_DARK_TUNED(f10));
        } else {
            this.glassRow.applyCustomGlass(StepOSGlassPresets.INSTANCE.TITLE_BAR_LIGHT_TUNED(f10));
        }
    }

    private final void applyEditInputType() {
        this.editView.setInputType(33);
    }

    private final void applyGlassFallback() {
        if (this.glassRow.getIsGlassEnabled()) {
            this.glassRow.setElevation(0.0f);
            this.glassRow.setSurfaceDrawable(null);
        } else {
            this.glassRow.setElevation(getResources().getDimension(R.dimen.stepos_recipient_row_elevation));
            this.glassRow.setSurfaceDrawable(androidx.core.content.a.e(getContext(), R.drawable.stepos_bg_recipient_row_fallback));
        }
    }

    private final void applyHintTextColor() {
        Integer num = this.hintTextColor;
        int iIntValue = num != null ? num.intValue() : androidx.core.content.a.c(getContext(), R.color.stepos_recipient_hint);
        this.hintView.setTextColor(iIntValue);
        this.summaryHint.setTextColor(iIntValue);
        this.editView.setHintTextColor(iIntValue);
    }

    private final void applyTextAppearance() throws Resources.NotFoundException {
        boolean z10 = this.isEasyMode;
        int i10 = z10 ? R.style.StepOSTextAppearance_Recipient_Easy : R.style.StepOSTextAppearance_Recipient;
        int i11 = z10 ? R.style.StepOSTextAppearance_Recipient_Easy : R.style.StepOSTextAppearance_Recipient_Hint;
        this.editView.setTextAppearance(i10);
        this.hintView.setTextAppearance(i11);
        this.summaryHint.setTextAppearance(i11);
        this.summaryName.setTextAppearance(i10);
        applyHintTextColor();
        applyContentTextColor();
        refreshChipColors();
    }

    private final void clearSingleRecipientFlag(String number) {
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
        if (stepOSRecipientBaseAdapter == null) {
            return;
        }
        if (stepOSRecipientBaseAdapter.isEmailAddress(number)) {
            this.singleRecipientFlag &= -3;
        } else if (stepOSRecipientBaseAdapter.isSns(number)) {
            this.singleRecipientFlag &= -5;
        }
    }

    private final void commitOrClearInputOnBlur() {
        Editable text = this.editView.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (H.x0(string)) {
            return;
        }
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
        if (stepOSRecipientBaseAdapter != null ? stepOSRecipientBaseAdapter.isValid(string) : isValidRecipient(removeSpecialCharacter(string))) {
            addRecipient(string);
        }
        this.editView.setText("");
    }

    private final StepOSRecipientChip createChip(String address, String name) throws Resources.NotFoundException {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        StepOSRecipientChip stepOSRecipientChip = new StepOSRecipientChip(context, null, 0, 6, null);
        stepOSRecipientChip.address = address;
        stepOSRecipientChip.setContactName(name);
        stepOSRecipientChip.setOnClickListener(this);
        stepOSRecipientChip.setOnLongClickListener(this);
        stepOSRecipientChip.setOnFocusChangeListener(this);
        applyChipAppearance(stepOSRecipientChip);
        return stepOSRecipientChip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deferredRefresh$lambda$6(StepOSRecipientEdit stepOSRecipientEdit) {
        stepOSRecipientEdit.refreshCollapsedState(stepOSRecipientEdit.hasFocus());
    }

    private final int destChipIndex(float eventX) {
        getLocationOnScreen(new int[2]);
        float f10 = r1[0] + eventX;
        int[] iArr = new int[2];
        int iEditChildIndex = editChildIndex();
        for (int i10 = 0; i10 < iEditChildIndex; i10++) {
            View childAt = this.chipFlow.getChildAt(i10);
            if (childAt instanceof StepOSRecipientChip) {
                ((StepOSRecipientChip) childAt).getLocationOnScreen(iArr);
                if (f10 < iArr[0] + (r4.getWidth() / 2.0f)) {
                    return i10;
                }
            }
        }
        return iEditChildIndex;
    }

    private final void detachDragChip(DragPayload payload) {
        StepOSRecipientChipFlow stepOSRecipientChipFlow;
        ViewParent parent = payload.getChip().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null && viewGroup == (stepOSRecipientChipFlow = this.chipFlow)) {
            stepOSRecipientChipFlow.removeView(payload.getChip());
        }
    }

    private final void dispatchChanged() {
        OnRecipientChangedListener onRecipientChangedListener = this.onRecipientChangedListener;
        if (onRecipientChangedListener != null) {
            onRecipientChangedListener.onRecipientChanged();
        }
        OnRecipientSimpleChangedListener onRecipientSimpleChangedListener = this.onRecipientSimpleChangedListener;
        if (onRecipientSimpleChangedListener != null) {
            onRecipientSimpleChangedListener.onRecipientSimpleChanged(this);
        }
    }

    private final int editChildIndex() {
        int iIndexOfChild = this.chipFlow.indexOfChild(this.editView);
        return iIndexOfChild < 0 ? this.chipFlow.getChildCount() : iIndexOfChild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableF12Optimize$lambda$16(StepOSRecipientEdit stepOSRecipientEdit, TextView textView, int i10, KeyEvent keyEvent) throws Resources.NotFoundException {
        if (i10 != 6) {
            return false;
        }
        Editable text = stepOSRecipientEdit.editView.getText();
        if (text == null || text.length() == 0) {
            stepOSRecipientEdit.onFocusChange(stepOSRecipientEdit.editView, false);
        } else {
            stepOSRecipientEdit.editView.setCursorVisible(false);
            Editable text2 = stepOSRecipientEdit.editView.getText();
            stepOSRecipientEdit.editView.setText("");
            stepOSRecipientEdit.addRecipient(text2);
            stepOSRecipientEdit.editView.setCursorVisible(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void expandAddButtonTouchTarget() throws Resources.NotFoundException {
        if (this.addButton.getVisibility() != 0) {
            return;
        }
        ViewParent parent = this.addButton.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_recipient_add_touch_target);
        int iF = C5685n.f((dimensionPixelSize - this.addButton.getWidth()) / 2, 0);
        int iF2 = C5685n.f((dimensionPixelSize - this.addButton.getHeight()) / 2, 0);
        Rect rect = new Rect();
        this.addButton.getHitRect(rect);
        rect.inset(-iF, -iF2);
        viewGroup.setTouchDelegate(new TouchDelegate(rect, this.addButton));
    }

    private final StepOSRecipientChip findChip(String address) {
        int childCount = this.chipFlow.getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                return null;
            }
            View childAt = this.chipFlow.getChildAt(i10);
            StepOSRecipientChip stepOSRecipientChip = childAt instanceof StepOSRecipientChip ? (StepOSRecipientChip) childAt : null;
            if (stepOSRecipientChip != null && kotlin.jvm.internal.p.d(stepOSRecipientChip.address, address)) {
                return stepOSRecipientChip;
            }
            i10++;
        }
    }

    private final void finishLocalDrag(DragPayload payload, boolean accepted) throws Resources.NotFoundException {
        if (!accepted) {
            restoreDragChip(payload);
        } else if (payload.getChip().getParent() == this.chipFlow) {
            syncDataToChipOrder();
            payload.getChip().setVisibility(0);
        } else {
            int iIndexOf = this.recipientData.indexOf(payload.getAddress());
            if (iIndexOf >= 0) {
                removeRecipientAt$default(this, iIndexOf, false, 2, null);
            }
            ViewParent parent = payload.getChip().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(payload.getChip());
            }
        }
        payload.getChip().setDragState(false);
        payload.getChip().setVisibility(0);
        this.firstDragIndex = -1;
        this.inDrag = false;
        RecipientDragWatcher recipientDragWatcher = this.dragWatcher;
        if (recipientDragWatcher != null) {
            recipientDragWatcher.onDragEnded(payload.getAddress(), accepted);
        }
        int childCount = this.chipFlow.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.chipFlow.getChildAt(i10);
            StepOSRecipientChip stepOSRecipientChip = childAt instanceof StepOSRecipientChip ? (StepOSRecipientChip) childAt : null;
            if (stepOSRecipientChip != null) {
                stepOSRecipientChip.setDragState(false);
            }
        }
        if (payload.getChip().getParent() != this.chipFlow) {
            this.selectedChip = null;
            this.editView.requestFocus();
            refreshCollapsedState(hasFocus());
        } else {
            this.selectedChip = payload.getChip();
            payload.getChip().requestFocus();
            refreshChipColors();
            refreshCollapsedState(true);
        }
    }

    private final void focusInput() {
        if (requestFocus()) {
            Object systemService = getContext().getSystemService("input_method");
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.editView, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAfterTextChanged(Editable s10) {
        int i10;
        char cCharAt;
        int length = s10.length();
        if (length == 0) {
            return;
        }
        if (this.changeCount == 1) {
            int i11 = length - 1;
            if (s10.charAt(i11) == ' ' && length > 1) {
                int i12 = length - 2;
                char cCharAt2 = s10.charAt(i12);
                if (cCharAt2 == ',' || cCharAt2 == ';') {
                    addRecipient(H.D1(s10.subSequence(0, i12).toString()).toString());
                    this.editView.setText("");
                    return;
                }
                String string = H.D1(s10.subSequence(0, i11).toString()).toString();
                StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
                if (stepOSRecipientBaseAdapter == null || !stepOSRecipientBaseAdapter.isEmailAddress(string)) {
                    return;
                }
                addRecipient(string);
                this.editView.setText("");
                return;
            }
        }
        if (this.f12OptimizeEnabled && this.changeCount == 1 && length > 1 && ((cCharAt = s10.charAt((i10 = length - 1))) == ',' || cCharAt == 12289 || cCharAt == 65292)) {
            this.editView.setCursorVisible(false);
            addRecipient(H.D1(s10.subSequence(0, i10).toString()).toString());
            this.editView.setText("");
            this.editView.setCursorVisible(true);
            return;
        }
        if (this.changeCount <= 1 || BaseInputConnection.getComposingSpanStart(s10) >= 0) {
            return;
        }
        CharSequence charSequenceSplitRecipient = splitRecipient(s10);
        if (TextUtils.equals(s10, charSequenceSplitRecipient)) {
            return;
        }
        this.editView.setText(charSequenceSplitRecipient);
        this.editView.setSelection(charSequenceSplitRecipient.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[Catch: all -> 0x0041, TRY_ENTER, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x0005, B:5:0x000a, B:11:0x0025, B:13:0x0030, B:15:0x0033, B:17:0x003e, B:22:0x0047, B:24:0x0054, B:28:0x0062, B:30:0x006c, B:31:0x0071, B:33:0x007a, B:35:0x0082, B:37:0x008a, B:39:0x0090, B:41:0x0096, B:43:0x00a3), top: B:48:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleDeleteKey() {
        /*
            r6 = this;
            r0 = 0
            r6.listenFocusChange = r0
            r6.internalFocusChangeCount = r0
            com.stepos.widget.recipient.StepOSRecipientChip r1 = r6.selectedChip     // Catch: java.lang.Throwable -> L41
            r2 = 1
            if (r1 == 0) goto L7a
            com.stepos.widget.recipient.StepOSRecipientChipFlow r3 = r6.chipFlow     // Catch: java.lang.Throwable -> L41
            int r3 = r3.indexOfChild(r1)     // Catch: java.lang.Throwable -> L41
            java.util.ArrayList<java.lang.String> r4 = r6.recipientData     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = r1.address     // Catch: java.lang.Throwable -> L41
            int r1 = r4.indexOf(r1)     // Catch: java.lang.Throwable -> L41
            if (r1 >= 0) goto L23
            com.stepos.widget.recipient.b r1 = new com.stepos.widget.recipient.b
            r1.<init>()
        L1f:
            r6.post(r1)
            return r0
        L23:
            r4 = 2
            r5 = 0
            removeRecipientAt$default(r6, r1, r0, r4, r5)     // Catch: java.lang.Throwable -> L41
            com.stepos.widget.recipient.StepOSRecipientChipFlow r0 = r6.chipFlow     // Catch: java.lang.Throwable -> L41
            int r0 = r0.getChildCount()     // Catch: java.lang.Throwable -> L41
            if (r3 < r2) goto L62
            int r0 = r0 - r2
            if (r3 == r0) goto L62
            com.stepos.widget.recipient.StepOSRecipientChipFlow r0 = r6.chipFlow     // Catch: java.lang.Throwable -> L41
            int r3 = r3 - r2
            android.view.View r0 = r0.getChildAt(r3)     // Catch: java.lang.Throwable -> L41
            boolean r1 = r0 instanceof com.stepos.widget.recipient.StepOSRecipientChip     // Catch: java.lang.Throwable -> L41
            if (r1 == 0) goto L44
            com.stepos.widget.recipient.StepOSRecipientChip r0 = (com.stepos.widget.recipient.StepOSRecipientChip) r0     // Catch: java.lang.Throwable -> L41
            goto L45
        L41:
            r0 = move-exception
            goto Lb5
        L44:
            r0 = r5
        L45:
            if (r0 == 0) goto L62
            r6.selectedChip = r0     // Catch: java.lang.Throwable -> L41
            r6.refreshChipColors()     // Catch: java.lang.Throwable -> L41
            com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView r0 = r6.editView     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.isFocused()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L59
            com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView r0 = r6.editView     // Catch: java.lang.Throwable -> L41
            r0.requestFocus()     // Catch: java.lang.Throwable -> L41
        L59:
            com.stepos.widget.recipient.b r0 = new com.stepos.widget.recipient.b
            r0.<init>()
        L5e:
            r6.post(r0)
            return r2
        L62:
            r6.selectedChip = r5     // Catch: java.lang.Throwable -> L41
            com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView r0 = r6.editView     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.isFocused()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L71
            com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView r0 = r6.editView     // Catch: java.lang.Throwable -> L41
            r0.requestFocus()     // Catch: java.lang.Throwable -> L41
        L71:
            r6.refreshChipColors()     // Catch: java.lang.Throwable -> L41
            com.stepos.widget.recipient.b r0 = new com.stepos.widget.recipient.b
            r0.<init>()
            goto L5e
        L7a:
            java.util.ArrayList<java.lang.String> r1 = r6.recipientData     // Catch: java.lang.Throwable -> L41
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L41
            if (r1 != 0) goto Lae
            com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView r1 = r6.editView     // Catch: java.lang.Throwable -> L41
            android.text.Editable r1 = r1.getText()     // Catch: java.lang.Throwable -> L41
            if (r1 == 0) goto L90
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L41
            if (r1 != 0) goto Lae
        L90:
            com.stepos.widget.recipient.StepOSRecipientChip r1 = r6.lastChip()     // Catch: java.lang.Throwable -> L41
            if (r1 == 0) goto Lae
            r6.selectedChip = r1     // Catch: java.lang.Throwable -> L41
            r6.refreshChipColors()     // Catch: java.lang.Throwable -> L41
            com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView r0 = r6.editView     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.isFocused()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto La8
            com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView r0 = r6.editView     // Catch: java.lang.Throwable -> L41
            r0.requestFocus()     // Catch: java.lang.Throwable -> L41
        La8:
            com.stepos.widget.recipient.b r0 = new com.stepos.widget.recipient.b
            r0.<init>()
            goto L5e
        Lae:
            com.stepos.widget.recipient.b r1 = new com.stepos.widget.recipient.b
            r1.<init>()
            goto L1f
        Lb5:
            com.stepos.widget.recipient.b r1 = new com.stepos.widget.recipient.b
            r1.<init>()
            r6.post(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.recipient.StepOSRecipientEdit.handleDeleteKey():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDeleteKey$lambda$27(StepOSRecipientEdit stepOSRecipientEdit) {
        stepOSRecipientEdit.listenFocusChange = true;
        stepOSRecipientEdit.internalFocusChangeCount = 0;
    }

    private final void insertChipBeforeEdit(StepOSRecipientChip chip, int preferred) {
        ViewParent parent = chip.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(chip);
        }
        this.chipFlow.addView(chip, C5685n.n(preferred, 0, editChildIndex()));
    }

    private final boolean insertRecipient(String number, String contactName, int dragPos, boolean refresh) throws IOException {
        OnRecipientFirstAddListener onRecipientFirstAddListener;
        final String strRemoveSpecialCharacter = removeSpecialCharacter(number);
        if (strRemoveSpecialCharacter.length() == 0 || this.recipientData.contains(strRemoveSpecialCharacter)) {
            return false;
        }
        if (contactName == null || contactName.length() == 0) {
            contactName = strRemoveSpecialCharacter;
        }
        if (dragPos < 0 || dragPos > this.recipientData.size()) {
            dragPos = this.recipientData.size();
        }
        this.recipientData.add(dragPos, strRemoveSpecialCharacter);
        this.recipientNames.put(strRemoveSpecialCharacter, contactName);
        insertChipBeforeEdit(createChip(strRemoveSpecialCharacter, contactName), dragPos);
        updateSingleRecipientFlag(strRemoveSpecialCharacter);
        if (refresh) {
            refreshCollapsedState(hasFocus());
            dispatchChanged();
            notifySingleRecipientWhenGroup();
        }
        if (this.recipientData.size() == 1 && (onRecipientFirstAddListener = this.onRecipientFirstAddListener) != null) {
            onRecipientFirstAddListener.onRecipientFirstAdd();
        }
        final OnRecipientSipStateCheckListener onRecipientSipStateCheckListener = this.sipStateCheckListener;
        if (onRecipientSipStateCheckListener != null) {
            post(new Runnable() { // from class: com.stepos.widget.recipient.h
                @Override // java.lang.Runnable
                public final void run() {
                    onRecipientSipStateCheckListener.onRecipientSipStateCheck(strRemoveSpecialCharacter, 1);
                }
            });
        }
        return true;
    }

    private final int invalidateColor() {
        Integer num = this.invalidTextColor;
        if (num != null) {
            return num.intValue();
        }
        Context context = getContext();
        int i10 = this.colorType;
        return androidx.core.content.a.c(context, i10 != 1 ? i10 != 2 ? R.color.stepos_recipient_chip_invalid_email : R.color.stepos_recipient_chip_invalid_calendar : R.color.stepos_recipient_chip_invalid_sms);
    }

    private final boolean isValidRecipient(String number) {
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
        if (stepOSRecipientBaseAdapter == null) {
            return Patterns.PHONE.matcher(number).matches() || Patterns.EMAIL_ADDRESS.matcher(number).matches() || D.X(number, "@", false, 2, null);
        }
        if ((this.inputType & 1) != 0 && stepOSRecipientBaseAdapter.isPhoneNumber(number)) {
            return true;
        }
        if ((2 & this.inputType) == 0 || !stepOSRecipientBaseAdapter.isEmailAddress(number)) {
            return (this.inputType & 4) != 0 && stepOSRecipientBaseAdapter.isSns(number);
        }
        return true;
    }

    private final StepOSRecipientChip lastChip() {
        StepOSRecipientChip stepOSRecipientChip;
        int iEditChildIndex = editChildIndex();
        do {
            iEditChildIndex--;
            if (-1 >= iEditChildIndex) {
                return null;
            }
            View childAt = this.chipFlow.getChildAt(iEditChildIndex);
            stepOSRecipientChip = childAt instanceof StepOSRecipientChip ? (StepOSRecipientChip) childAt : null;
        } while (stepOSRecipientChip == null);
        return stepOSRecipientChip;
    }

    private final void moveDragChip(DragPayload payload, float eventX) {
        int iDestChipIndex = destChipIndex(eventX);
        int iIndexOfChild = this.chipFlow.indexOfChild(payload.getChip());
        int iEditChildIndex = editChildIndex();
        if (iDestChipIndex > iEditChildIndex) {
            iDestChipIndex = iEditChildIndex;
        }
        if (iIndexOfChild >= 0 && iIndexOfChild < iDestChipIndex) {
            iDestChipIndex--;
        }
        if (iIndexOfChild < 0 && iDestChipIndex < 0) {
            iDestChipIndex = iEditChildIndex;
        }
        int iN = C5685n.n(iDestChipIndex, 0, iEditChildIndex);
        if (iN == iIndexOfChild) {
            return;
        }
        insertChipBeforeEdit(payload.getChip(), iN);
        payload.getChip().setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusLost$lambda$5(StepOSRecipientEdit stepOSRecipientEdit) {
        View.OnFocusChangeListener onFocusChangeListener;
        if (stepOSRecipientEdit.hasFocus() || (onFocusChangeListener = stepOSRecipientEdit.getOnFocusChangeListener()) == null) {
            return;
        }
        onFocusChangeListener.onFocusChange(stepOSRecipientEdit, false);
    }

    private final void notifySingleRecipientWhenGroup() {
        OnSingleRecipientAddWhenGroupListener onSingleRecipientAddWhenGroupListener;
        if (this.recipientData.size() > 1) {
            int i10 = this.singleRecipientFlag;
            if ((i10 & 6) <= 0 || (onSingleRecipientAddWhenGroupListener = this.onSingleAddWhenGroupListener) == null) {
                return;
            }
            onSingleRecipientAddWhenGroupListener.onSingleRecipientAddWhenGroup(this.inputType & i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFocusChange$lambda$23(StepOSRecipientEdit stepOSRecipientEdit, View view) {
        if (stepOSRecipientEdit.collapseUnlessFocused && view.isFocused()) {
            view.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLongClick$lambda$22(StepOSRecipientChip stepOSRecipientChip, ClipData clipData, DragPayload dragPayload, StepOSRecipientEdit stepOSRecipientEdit) {
        if (!stepOSRecipientChip.startDragAndDrop(clipData, new View.DragShadowBuilder(stepOSRecipientChip), dragPayload, 0)) {
            stepOSRecipientEdit.inDrag = false;
            stepOSRecipientEdit.firstDragIndex = -1;
            stepOSRecipientChip.setDragState(false);
            return;
        }
        stepOSRecipientChip.setVisibility(4);
        StepOSRecipientChipFlow stepOSRecipientChipFlow = stepOSRecipientEdit.chipFlow;
        View childAt = stepOSRecipientChipFlow.getChildAt(stepOSRecipientChipFlow.indexOfChild(stepOSRecipientChip) + 1);
        if (childAt != null) {
            childAt.requestFocus();
        }
        RecipientDragWatcher recipientDragWatcher = stepOSRecipientEdit.dragWatcher;
        if (recipientDragWatcher != null) {
            recipientDragWatcher.onDragStarted(stepOSRecipientChip.address);
        }
    }

    private final void openContactDetail(StepOSRecipientChip chip) {
        String strX1;
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
        if (stepOSRecipientBaseAdapter == null) {
            return;
        }
        String str = this.recipientNames.get(chip.address);
        if (str == null || (strX1 = H.x1(str, Const.STR_MART_SEMICOLON, null, 2, null)) == null) {
            strX1 = chip.address;
        }
        stepOSRecipientBaseAdapter.goContactDetail(chip.address, strX1);
    }

    private final void refreshChipColors() throws Resources.NotFoundException {
        int childCount = this.chipFlow.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.chipFlow.getChildAt(i10);
            if (childAt instanceof StepOSRecipientChip) {
                applyChipAppearance((StepOSRecipientChip) childAt);
            }
        }
    }

    private final void refreshCollapsedState(boolean focused) {
        if (this.inAfterTextChanged) {
            this.refreshNeededFromTextChange = true;
            return;
        }
        boolean z10 = focused || this.recipientData.isEmpty() || this.isChipBackgroundEnabled;
        this.hintView.setVisibility((this.isHintVisible && z10) ? 0 : 8);
        if (z10) {
            this.scrollView.setVisibility(0);
            this.summaryHint.setVisibility(8);
            this.summaryName.setVisibility(8);
            return;
        }
        this.scrollView.setVisibility(8);
        this.summaryHint.setVisibility(this.isHintVisible ? 0 : 8);
        this.summaryName.setVisibility(0);
        String str = this.customHintText;
        if (str != null) {
            this.summaryName.setText(str);
            this.summaryName.setTextColor(this.customHintColor);
            return;
        }
        String str2 = this.recipientNames.get(this.recipientData.get(0));
        if (str2 == null) {
            String str3 = this.recipientData.get(0);
            kotlin.jvm.internal.p.h(str3, "get(...)");
            str2 = str3;
        }
        TextView textView = this.summaryName;
        if (this.recipientData.size() != 1) {
            str2 = str2 + " " + getContext().getString(R.string.stepos_recipient_others, Integer.valueOf(this.recipientData.size() - 1));
        }
        textView.setText(str2);
        applyContentTextColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshNamesRunnable$lambda$30(final StepOSRecipientEdit stepOSRecipientEdit) {
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = stepOSRecipientEdit.recipientAdapter;
        if (stepOSRecipientBaseAdapter == null) {
            return;
        }
        Iterator it = new ArrayList(stepOSRecipientEdit.recipientData).iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            final String str = (String) it.next();
            try {
                kotlin.jvm.internal.p.f(str);
                final String strQueryDisplayName = stepOSRecipientBaseAdapter.queryDisplayName(str);
                if (!TextUtils.equals(strQueryDisplayName, stepOSRecipientEdit.recipientNames.get(str))) {
                    stepOSRecipientEdit.post(new Runnable() { // from class: com.stepos.widget.recipient.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            StepOSRecipientEdit.refreshNamesRunnable$lambda$30$lambda$29(this.f31317a, str, strQueryDisplayName);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshNamesRunnable$lambda$30$lambda$29(StepOSRecipientEdit stepOSRecipientEdit, String str, String str2) {
        stepOSRecipientEdit.recipientNames.put(str, str2);
        kotlin.jvm.internal.p.f(str);
        StepOSRecipientChip stepOSRecipientChipFindChip = stepOSRecipientEdit.findChip(str);
        if (stepOSRecipientChipFindChip != null) {
            stepOSRecipientChipFindChip.setContactName(str2);
        }
        stepOSRecipientEdit.refreshCollapsedState(stepOSRecipientEdit.hasFocus());
    }

    private final boolean removeRecipientAt(int index, boolean notify) {
        int i10 = 0;
        if (index < 0 || index >= this.recipientData.size()) {
            return false;
        }
        String strRemove = this.recipientData.remove(index);
        kotlin.jvm.internal.p.h(strRemove, "removeAt(...)");
        String str = strRemove;
        this.recipientNames.remove(str);
        this.recipientInfo.remove(str);
        int childCount = this.chipFlow.getChildCount();
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = this.chipFlow.getChildAt(i10);
            StepOSRecipientChip stepOSRecipientChip = childAt instanceof StepOSRecipientChip ? (StepOSRecipientChip) childAt : null;
            if (stepOSRecipientChip != null && kotlin.jvm.internal.p.d(stepOSRecipientChip.address, str)) {
                if (this.selectedChip == stepOSRecipientChip) {
                    this.selectedChip = null;
                }
                this.chipFlow.removeViewAt(i10);
            } else {
                i10++;
            }
        }
        clearSingleRecipientFlag(str);
        OnRecipientSipStateCheckListener onRecipientSipStateCheckListener = this.sipStateCheckListener;
        if (onRecipientSipStateCheckListener != null) {
            onRecipientSipStateCheckListener.onRecipientSipStateCheck(str, 2);
        }
        if (notify) {
            refreshCollapsedState(true);
            dispatchChanged();
        }
        return true;
    }

    public static /* synthetic */ boolean removeRecipientAt$default(StepOSRecipientEdit stepOSRecipientEdit, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        return stepOSRecipientEdit.removeRecipientAt(i10, z10);
    }

    private final String removeSpecialCharacter(String cons) throws IOException {
        String string = H.D1(cons).toString();
        if (string.length() == 0) {
            return "";
        }
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
        if ((this.inputType & 4) == 0 || !D.X(string, "@", false, 2, null)) {
            if ((this.inputType & 1) != 0 && stepOSRecipientBaseAdapter != null && stepOSRecipientBaseAdapter.isPhoneNumber(string)) {
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < string.length(); i10++) {
                    char cCharAt = string.charAt(i10);
                    if (cCharAt != ' ' && cCharAt != '.' && cCharAt != '-' && cCharAt != '(' && cCharAt != ')') {
                        sb2.append(cCharAt);
                    }
                }
                String string2 = sb2.toString();
                kotlin.jvm.internal.p.h(string2, "toString(...)");
                return string2;
            }
            if ((stepOSRecipientBaseAdapter != null && stepOSRecipientBaseAdapter.isEmailAddress(string)) || Patterns.EMAIL_ADDRESS.matcher(string).matches()) {
                int iT0 = H.t0(string, '<', 0, false, 6, null);
                int iT02 = H.t0(string, '>', 0, false, 6, null);
                if (iT0 >= 0 && iT02 > iT0) {
                    String strSubstring = string.substring(iT0 + 1, iT02);
                    kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                    return strSubstring;
                }
            }
        }
        return string;
    }

    private final int restingChipBgColor() {
        Integer num = this.chipBackgroundColor;
        return num != null ? num.intValue() : androidx.core.content.a.c(getContext(), R.color.stepos_recipient_chip_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restoreCollapsedIfUnfocused$lambda$4(StepOSRecipientEdit stepOSRecipientEdit) {
        if (stepOSRecipientEdit.collapseUnlessFocused && stepOSRecipientEdit.hasWindowFocus()) {
            stepOSRecipientEdit.collapseUnlessFocused = false;
            if (stepOSRecipientEdit.hasFocus()) {
                return;
            }
            stepOSRecipientEdit.refreshCollapsedState(false);
        }
    }

    private final void restoreDragChip(DragPayload payload) {
        int iN = C5685n.n(this.firstDragIndex, 0, this.recipientData.size());
        if (!this.recipientData.contains(payload.getAddress())) {
            this.recipientData.add(iN, payload.getAddress());
        }
        insertChipBeforeEdit(payload.getChip(), C5685n.n(this.recipientData.indexOf(payload.getAddress()), 0, editChildIndex()));
        payload.getChip().setVisibility(0);
        payload.getChip().setDragState(false);
    }

    private final int selectedChipTextColor() {
        Integer num = this.selectedTextColor;
        return num != null ? num.intValue() : androidx.core.content.a.c(getContext(), R.color.stepos_recipient_text_on_selected);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0079 A[LOOP:2: B:29:0x0077->B:30:0x0079, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.CharSequence splitRecipient(java.lang.CharSequence r14) {
        /*
            r13 = this;
            int r0 = r14.length()
            if (r0 != 0) goto L7
            return r14
        L7:
            int r0 = r14.length()
            r1 = 0
            r4 = r1
        Ld:
            if (r4 >= r0) goto L1e
            char r2 = r14.charAt(r4)
            r3 = 32
            int r2 = kotlin.jvm.internal.p.k(r2, r3)
            if (r2 > 0) goto L1e
            int r4 = r4 + 1
            goto Ld
        L1e:
            if (r4 < r0) goto L22
            goto L94
        L22:
            java.lang.String r5 = r14.toString()
            r6 = 4
            r7 = 0
            r3 = 32
            r2 = r5
            r5 = 0
            int r3 = La.H.t0(r2, r3, r4, r5, r6, r7)
            r5 = r1
            r11 = r4
        L32:
            java.lang.String r6 = "substring(...)"
            if (r3 <= 0) goto L8d
            if (r3 > r0) goto L8d
            int r7 = r3 + (-1)
            char r8 = r2.charAt(r7)
            r9 = 44
            r10 = 1
            if (r8 == r9) goto L5f
            r9 = 59
            if (r8 == r9) goto L5f
            java.lang.String r7 = r2.substring(r11, r3)
            kotlin.jvm.internal.p.h(r7, r6)
            com.stepos.widget.recipient.StepOSRecipientBaseAdapter r6 = r13.recipientAdapter
            if (r6 == 0) goto L5d
            boolean r6 = r6.isEmailAddress(r7)
            if (r6 != r10) goto L5d
            r13.addRecipient(r7)
        L5b:
            r12 = r10
            goto L6a
        L5d:
            r12 = r5
            goto L6a
        L5f:
            java.lang.String r5 = r2.substring(r11, r7)
            kotlin.jvm.internal.p.h(r5, r6)
            r13.addRecipient(r5)
            goto L5b
        L6a:
            int r7 = r3 + 1
            r9 = 4
            r10 = 0
            r6 = 32
            r8 = 0
            r5 = r2
            int r2 = La.H.t0(r5, r6, r7, r8, r9, r10)
            r3 = r2
        L77:
            if (r7 != r3) goto L85
            int r7 = r3 + 1
            r9 = 4
            r10 = 0
            r6 = 32
            r8 = 0
            int r3 = La.H.t0(r5, r6, r7, r8, r9, r10)
            goto L77
        L85:
            r2 = r5
            if (r12 == 0) goto L8b
            r5 = r1
            r11 = r7
            goto L32
        L8b:
            r5 = r12
            goto L32
        L8d:
            if (r11 < r0) goto L92
            java.lang.String r13 = ""
            return r13
        L92:
            if (r11 != r4) goto L95
        L94:
            return r14
        L95:
            java.lang.String r13 = r2.substring(r11)
            kotlin.jvm.internal.p.h(r13, r6)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.recipient.StepOSRecipientEdit.splitRecipient(java.lang.CharSequence):java.lang.CharSequence");
    }

    private final void stretchRowToOwnHeight() {
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            return;
        }
        if (this.glassRow.getMeasuredWidth() == measuredWidth && this.glassRow.getMeasuredHeight() == measuredHeight) {
            return;
        }
        this.glassRow.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    private final void syncDataToChipOrder() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.chipFlow.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.chipFlow.getChildAt(i10);
            StepOSRecipientChip stepOSRecipientChip = childAt instanceof StepOSRecipientChip ? (StepOSRecipientChip) childAt : null;
            if (stepOSRecipientChip != null) {
                arrayList.add(stepOSRecipientChip.address);
            }
        }
        if (kotlin.jvm.internal.p.d(arrayList, this.recipientData)) {
            return;
        }
        this.recipientData.clear();
        this.recipientData.addAll(arrayList);
    }

    private final void updateSingleRecipientFlag(String number) {
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
        if (stepOSRecipientBaseAdapter == null) {
            return;
        }
        if (stepOSRecipientBaseAdapter.isEmailAddress(number)) {
            this.singleRecipientFlag |= 2;
        } else if (stepOSRecipientBaseAdapter.isSns(number)) {
            this.singleRecipientFlag |= 4;
        }
    }

    public final boolean addRecipient(CharSequence number) {
        return addRecipient(number, (CharSequence) null);
    }

    public final boolean addRecipientInternal(String number, String contactName) {
        kotlin.jvm.internal.p.i(number, "number");
        return addRecipientInternal(number, contactName, true);
    }

    public final void changeContact(String phoneOrEmail, String to, String contactName) throws Resources.NotFoundException, IOException {
        kotlin.jvm.internal.p.i(phoneOrEmail, "phoneOrEmail");
        kotlin.jvm.internal.p.i(to, "to");
        int iIndexOf = this.recipientData.indexOf(phoneOrEmail);
        if (iIndexOf < 0) {
            return;
        }
        String strRemoveSpecialCharacter = removeSpecialCharacter(to);
        this.recipientData.set(iIndexOf, strRemoveSpecialCharacter);
        this.recipientNames.remove(phoneOrEmail);
        this.recipientNames.put(strRemoveSpecialCharacter, contactName == null ? strRemoveSpecialCharacter : contactName);
        View childAt = this.chipFlow.getChildAt(iIndexOf);
        StepOSRecipientChip stepOSRecipientChip = childAt instanceof StepOSRecipientChip ? (StepOSRecipientChip) childAt : null;
        if (stepOSRecipientChip != null) {
            stepOSRecipientChip.address = strRemoveSpecialCharacter;
            if (contactName == null) {
                contactName = strRemoveSpecialCharacter;
            }
            stepOSRecipientChip.setContactName(contactName);
            applyChipAppearance(stepOSRecipientChip);
        }
        refreshCollapsedState(hasFocus());
    }

    public final void completeInput() {
        Editable text = this.editView.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (!H.x0(string)) {
            addRecipient(string);
            this.editView.setText("");
        }
        refreshCollapsedState(hasFocus());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchDragEvent(DragEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        View.OnDragListener onDragListener = this.hostDragListener;
        if (onDragListener != null && isEnabled() && onDragListener.onDrag(this, event)) {
            return true;
        }
        return onDragEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Editable text;
        kotlin.jvm.internal.p.i(event, "event");
        if (event.getKeyCode() == 66 && this.editView.getListSelection() == -1 && (text = this.editView.getText()) != null && text.length() != 0) {
            if (event.getAction() == 1) {
                this.editView.setText("");
                addRecipient(text);
            }
            return true;
        }
        if (event.getAction() == 0 && event.getKeyCode() == 67) {
            if (handleDeleteKey()) {
                return true;
            }
        } else if (event.getAction() == 0 && !this.editView.isFocused()) {
            this.selectedChip = null;
            this.editView.requestFocus();
        }
        return super.dispatchKeyEvent(event);
    }

    public final void enableF12Optimize() {
        this.f12OptimizeEnabled = true;
        this.editView.setImeOptions(6);
        this.editView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.stepos.widget.recipient.f
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                return StepOSRecipientEdit.enableF12Optimize$lambda$16(this.f31316a, textView, i10, keyEvent);
            }
        });
    }

    /* renamed from: getAdapter, reason: from getter */
    public final StepOSRecipientBaseAdapter getRecipientAdapter() {
        return this.recipientAdapter;
    }

    public final List<String> getAllNumbers() {
        ArrayList arrayList = new ArrayList(this.recipientData);
        String inputText = getInputText();
        if (inputText.length() > 0 && !this.recipientData.contains(inputText)) {
            arrayList.add(inputText);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: getButtonVisibility, reason: from getter */
    public final boolean getIsAddButtonVisible() {
        return this.isAddButtonVisible;
    }

    public final Integer getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public final Integer getChipTextColor() {
        return this.chipTextColor;
    }

    public final int getColorType() {
        return this.colorType;
    }

    public final y7.o getGlassEffect() {
        return this.glassRow.getGlassEffect();
    }

    public final CharSequence getHint() {
        return this.hintView.getText();
    }

    public final Integer getHintTextColor() {
        return this.hintTextColor;
    }

    public final int getImeOptions() {
        return this.editView.getImeOptions();
    }

    public final String getInputText() {
        Editable text = this.editView.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        return removeSpecialCharacter(string);
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final Integer getInvalidTextColor() {
        return this.invalidTextColor;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    /* renamed from: getRecipientAutoCompleteTextView, reason: from getter */
    public final StepOSRecipientAutoCompleteTextView getEditView() {
        return this.editView;
    }

    public final int getRecipientCount() {
        int size = this.recipientData.size();
        String inputText = getInputText();
        return (inputText.length() <= 0 || this.recipientData.contains(inputText)) ? size : size + 1;
    }

    public final List<String> getRecipientDataList() {
        List<String> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(this.recipientData));
        kotlin.jvm.internal.p.h(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public final Map<String, String> getRecipientMap() {
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(this.recipientNames));
        kotlin.jvm.internal.p.h(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    /* renamed from: getRecipientScrollView, reason: from getter */
    public final ScrollView getScrollView() {
        return this.scrollView;
    }

    public final List<String> getRecipients() {
        String strX1;
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.recipientData.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            String str = next;
            String str2 = this.recipientNames.get(str);
            if (str2 == null || (strX1 = H.x1(str2, Const.STR_MART_SEMICOLON, null, 2, null)) == null) {
                strX1 = str;
            }
            arrayList.add(str + Const.STR_MART_SEMICOLON + strX1);
        }
        return arrayList;
    }

    public final Map<String, StepOSContactInfo> getRecipientsInfo() {
        Map<String, StepOSContactInfo> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(this.recipientInfo));
        kotlin.jvm.internal.p.h(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    public final Integer getRippleColor() {
        return this.rippleColor;
    }

    public final Integer getSelectedChipBackgroundColor() {
        return this.selectedChipBackgroundColor;
    }

    public final Integer getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final int getSingleRecipientFlag() {
        return this.singleRecipientFlag;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final List<String> getValidNumbers() throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.recipientData.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            String str = next;
            if (isValidRecipient(str)) {
                arrayList.add(str);
            }
        }
        Editable text = this.editView.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        String strRemoveSpecialCharacter = removeSpecialCharacter(string);
        if (strRemoveSpecialCharacter.length() > 0 && !this.recipientData.contains(strRemoveSpecialCharacter) && isValidRecipient(strRemoveSpecialCharacter)) {
            arrayList.add(strRemoveSpecialCharacter);
        }
        return arrayList;
    }

    public final boolean hasInvalidRecipient() {
        ArrayList<String> arrayList = this.recipientData;
        if (arrayList == null || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!isValidRecipient((String) it.next())) {
                    return true;
                }
            }
        }
        String inputText = getInputText();
        return inputText.length() > 0 && !isValidRecipient(inputText);
    }

    public final boolean hasValidRecipient() {
        ArrayList<String> arrayList = this.recipientData;
        if (arrayList == null || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                if (isValidRecipient((String) it.next())) {
                    return true;
                }
            }
        }
        String inputText = getInputText();
        return inputText.length() > 0 && isValidRecipient(inputText);
    }

    public final boolean isAddButtonVisible() {
        return this.isAddButtonVisible;
    }

    /* renamed from: isChipBackgroundEnabled, reason: from getter */
    public final boolean getIsChipBackgroundEnabled() {
        return this.isChipBackgroundEnabled;
    }

    /* renamed from: isDragEnabled, reason: from getter */
    public final boolean getIsDragEnabled() {
        return this.isDragEnabled;
    }

    /* renamed from: isEasyMode, reason: from getter */
    public final boolean getIsEasyMode() {
        return this.isEasyMode;
    }

    public final boolean isGlassEnabled() {
        return this.glassRow.getIsGlassEnabled();
    }

    /* renamed from: isHintVisible, reason: from getter */
    public final boolean getIsHintVisible() {
        return this.isHintVisible;
    }

    public final boolean isPopupShowing() {
        return this.editView.isPopupShowing();
    }

    /* renamed from: isValidateRecognition, reason: from getter */
    public final boolean getIsValidateRecognition() {
        return this.isValidateRecognition;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyDefaultGlass();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        if (kotlin.jvm.internal.p.d(v10, this.addButton)) {
            View.OnClickListener onClickListener = this.buttonClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(v10);
                return;
            }
            return;
        }
        if (v10 instanceof StepOSRecipientChip) {
            openContactDetail((StepOSRecipientChip) v10);
        } else {
            focusInput();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        applyDefaultGlass();
        applyGlassFallback();
        if (hasFocus()) {
            return;
        }
        this.collapseUnlessFocused = true;
        refreshCollapsedState(false);
        removeCallbacks(this.restoreCollapsedIfUnfocused);
        post(this.restoreCollapsedIfUnfocused);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        kotlin.jvm.internal.p.i(outAttrs, "outAttrs");
        this.editView.setImeOptions((this.editView.getImeOptions() & (-256)) | 1);
        this.editView.setImeActionLabel(getResources().getString(R.string.stepos_recipient_ime_action), 1);
        return super.onCreateInputConnection(outAttrs);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.collapseUnlessFocused = false;
        removeCallbacks(this.restoreCollapsedIfUnfocused);
        removeCallbacks(this.expandTouchTarget);
        removeCallbacks(this.notifyFocusLost);
        removeCallbacks(this.deferredRefresh);
        this.mainHandler.removeCallbacksAndMessages(null);
        Handler handler = this.queryHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = this.queryThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.queryHandler = null;
        this.queryThread = null;
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
        if (stepOSRecipientBaseAdapter != null) {
            stepOSRecipientBaseAdapter.unregisterContentObserver();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent event) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(event, "event");
        Object localState = event.getLocalState();
        DragPayload dragPayload = localState instanceof DragPayload ? (DragPayload) localState : null;
        if (dragPayload == null) {
            return this.editView.onDragEvent(event);
        }
        switch (event.getAction()) {
            case 1:
                if (dragPayload.getSource() == this) {
                    this.dragStarted = true;
                    this.dragDropped = false;
                    this.dragEnded = false;
                    this.dragSnapshot = new ArrayList<>(getRecipients());
                    this.inDrag = true;
                }
                return true;
            case 2:
                moveDragChip(dragPayload, event.getX());
                return true;
            case 3:
                if (dragPayload.getSource() == this) {
                    this.dragDropped = true;
                    syncDataToChipOrder();
                    dragPayload.getChip().setVisibility(0);
                    dragPayload.getChip().setDragState(false);
                    this.firstDragIndex = -1;
                } else {
                    acceptForeignDrop(event, dragPayload);
                }
                return true;
            case 4:
                if (dragPayload.getSource() == this) {
                    this.dragEnded = true;
                    if (!this.isDragRecovery) {
                        finishLocalDrag(dragPayload, event.getResult());
                    }
                }
                return true;
            case 6:
                detachDragChip(dragPayload);
            case 5:
                return true;
            default:
                return false;
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(final View v10, boolean hasFocus) throws Resources.NotFoundException {
        StepOSRecipientChip stepOSRecipientChip;
        if (this.collapseUnlessFocused) {
            if (hasFocus) {
                refreshCollapsedState(false);
                if (v10 != null) {
                    v10.post(new Runnable() { // from class: com.stepos.widget.recipient.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            StepOSRecipientEdit.onFocusChange$lambda$23(this.f31326a, v10);
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        boolean z10 = v10 instanceof StepOSRecipientChip;
        if (z10) {
            if (hasFocus) {
                stepOSRecipientChip = (StepOSRecipientChip) v10;
            } else {
                stepOSRecipientChip = this.selectedChip;
                if (stepOSRecipientChip == v10) {
                    stepOSRecipientChip = null;
                }
            }
            this.selectedChip = stepOSRecipientChip;
        }
        if (!this.listenFocusChange) {
            int i10 = this.internalFocusChangeCount;
            if (i10 < 2) {
                this.internalFocusChangeCount = i10 + 1;
                return;
            } else {
                this.internalFocusChangeCount = 0;
                this.listenFocusChange = true;
            }
        }
        if (v10 == this.editView) {
            if (!hasFocus) {
                commitOrClearInputOnBlur();
            }
            View.OnFocusChangeListener onFocusChangeListener = getOnFocusChangeListener();
            if (onFocusChangeListener != null) {
                if (hasFocus) {
                    removeCallbacks(this.notifyFocusLost);
                    onFocusChangeListener.onFocusChange(this, true);
                } else {
                    removeCallbacks(this.notifyFocusLost);
                    post(this.notifyFocusLost);
                }
            }
        } else if (z10) {
            if (hasFocus) {
                removeCallbacks(this.notifyFocusLost);
            }
            refreshChipColors();
        }
        refreshCollapsedState(hasFocus() || hasFocus);
    }

    public final boolean onImeDeleteFromChip$StepOSWidget_release() {
        return handleDeleteKey();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        kotlin.jvm.internal.p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(StepOSRecipientEdit.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        removeCallbacks(this.expandTouchTarget);
        post(this.expandTouchTarget);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v10) {
        final StepOSRecipientChip stepOSRecipientChip = v10 instanceof StepOSRecipientChip ? (StepOSRecipientChip) v10 : null;
        if (stepOSRecipientChip == null || !this.isDragEnabled) {
            return false;
        }
        Editable text = this.editView.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        if (!H.x0(string)) {
            addRecipient(string);
            this.editView.setText("");
        }
        int iIndexOf = this.recipientData.indexOf(stepOSRecipientChip.address);
        this.firstDragIndex = iIndexOf;
        if (iIndexOf < 0) {
            return false;
        }
        this.dragSnapshot = new ArrayList<>(getRecipients());
        this.inDrag = true;
        this.isDragRecovery = false;
        stepOSRecipientChip.setDragState(true);
        String str = this.recipientNames.get(stepOSRecipientChip.address);
        if (str == null) {
            str = stepOSRecipientChip.address;
        }
        final ClipData clipDataNewPlainText = ClipData.newPlainText(null, new Rfc822Token(str, stepOSRecipientChip.address, null).toString());
        final DragPayload dragPayload = new DragPayload(stepOSRecipientChip, stepOSRecipientChip.address, this);
        stepOSRecipientChip.post(new Runnable() { // from class: com.stepos.widget.recipient.i
            @Override // java.lang.Runnable
            public final void run() {
                StepOSRecipientEdit.onLongClick$lambda$22(stepOSRecipientChip, clipDataNewPlainText, dragPayload, this);
            }
        });
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMin = this.maxHeight;
        if (iMin > 0) {
            int mode = View.MeasureSpec.getMode(heightMeasureSpec);
            int size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode != 0) {
                iMin = Math.min(size, iMin);
            }
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        stretchRowToOwnHeight();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        removeAll();
        int size = savedState.getAddresses().size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = savedState.getAddresses().get(i10);
            kotlin.jvm.internal.p.h(str, "get(...)");
            addRecipientInternal(str, (String) F.t0(savedState.getNames(), i10), false);
        }
        this.editView.setText(savedState.getEditText());
        refreshCollapsedState(hasFocus());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = AbsSavedState.EMPTY_STATE;
        }
        kotlin.jvm.internal.p.f(parcelableOnSaveInstanceState);
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setAddresses(new ArrayList<>(this.recipientData));
        ArrayList<String> arrayList = this.recipientData;
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (String str : arrayList) {
            String str2 = this.recipientNames.get(str);
            if (str2 != null) {
                str = str2;
            }
            arrayList2.add(str);
        }
        savedState.setNames(new ArrayList<>(arrayList2));
        Editable text = this.editView.getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        savedState.setEditText(string);
        savedState.setInputType(this.inputType);
        savedState.setColorType(this.colorType);
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && this.collapseUnlessFocused) {
            removeCallbacks(this.restoreCollapsedIfUnfocused);
            post(this.restoreCollapsedIfUnfocused);
        }
    }

    public final void recoveryToDragBefore() {
        if (this.inDrag || (this.dragStarted && !this.dragDropped && this.dragEnded)) {
            ArrayList<String> arrayList = new ArrayList<>(this.dragSnapshot);
            this.inDrag = false;
            this.firstDragIndex = -1;
            this.dragStarted = false;
            this.dragDropped = false;
            this.dragEnded = false;
            this.isDragRecovery = true;
            removeAll();
            addRecipient(arrayList);
            refreshLayout(false);
        }
    }

    public final void refreshLayout() {
        refreshCollapsedState(hasFocus());
        dispatchChanged();
    }

    public final void refreshRecipientEditLayout() {
        this.mainHandler.removeCallbacks(this.refreshNamesRunnable);
        this.mainHandler.postDelayed(this.refreshNamesRunnable, 500L);
    }

    public final void removeAll() {
        this.editView.setText("");
        this.singleRecipientFlag = 0;
        this.recipientData.clear();
        this.recipientNames.clear();
        this.recipientInfo.clear();
        StepOSRecipientAutoCompleteTextView stepOSRecipientAutoCompleteTextView = this.editView;
        this.chipFlow.removeAllViews();
        this.chipFlow.addView(stepOSRecipientAutoCompleteTextView);
        refreshCollapsedState(hasFocus());
        dispatchChanged();
    }

    public final boolean removeRecipient(CharSequence number) throws IOException {
        int iIndexOf;
        String string = number != null ? number.toString() : null;
        if (string == null) {
            string = "";
        }
        String strRemoveSpecialCharacter = removeSpecialCharacter(string);
        if (strRemoveSpecialCharacter.length() == 0 || (iIndexOf = this.recipientData.indexOf(strRemoveSpecialCharacter)) < 0) {
            return false;
        }
        boolean zHasFocus = hasFocus();
        boolean zRemoveRecipientAt$default = removeRecipientAt$default(this, iIndexOf, false, 2, null);
        if (zRemoveRecipientAt$default && zHasFocus && !hasFocus()) {
            this.editView.requestFocus();
        }
        return zRemoveRecipientAt$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<java.lang.String> removeSingleRecipientWhenGroup(int r10) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.stepos.widget.recipient.StepOSRecipientBaseAdapter r1 = r9.recipientAdapter
            if (r1 != 0) goto Lb
            goto L7a
        Lb:
            int r2 = r9.singleRecipientFlag
            int r3 = r1.getInputType()
            r2 = r2 & r3
            r2 = r2 & r10
            r3 = 2
            r2 = r2 & r3
            r4 = 1
            r5 = 0
            if (r2 != r3) goto L1b
            r2 = r4
            goto L1c
        L1b:
            r2 = r5
        L1c:
            int r3 = r9.singleRecipientFlag
            int r6 = r1.getInputType()
            r3 = r3 & r6
            r10 = r10 & r3
            r3 = 4
            r10 = r10 & r3
            if (r10 != r3) goto L29
            goto L2a
        L29:
            r4 = r5
        L2a:
            if (r2 != 0) goto L2f
            if (r4 != 0) goto L2f
            goto L7a
        L2f:
            java.util.ArrayList r10 = new java.util.ArrayList
            java.util.ArrayList<java.lang.String> r3 = r9.recipientData
            r10.<init>(r3)
            int r3 = r10.size()
            int r3 = r3 + (-1)
            if (r3 < 0) goto L6a
        L3e:
            int r6 = r3 + (-1)
            java.lang.Object r7 = r10.get(r3)
            java.lang.String r7 = (java.lang.String) r7
            if (r2 == 0) goto L51
            kotlin.jvm.internal.p.f(r7)
            boolean r8 = r1.isEmailAddress(r7)
            if (r8 != 0) goto L5c
        L51:
            if (r4 == 0) goto L65
            kotlin.jvm.internal.p.f(r7)
            boolean r8 = r1.isSns(r7)
            if (r8 == 0) goto L65
        L5c:
            boolean r3 = r9.removeRecipientAt(r3, r5)
            if (r3 == 0) goto L65
            r0.add(r7)
        L65:
            if (r6 >= 0) goto L68
            goto L6a
        L68:
            r3 = r6
            goto L3e
        L6a:
            boolean r10 = r0.isEmpty()
            if (r10 != 0) goto L7a
            boolean r10 = r9.hasFocus()
            r9.refreshCollapsedState(r10)
            r9.dispatchChanged()
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.recipient.StepOSRecipientEdit.removeSingleRecipientWhenGroup(int):java.util.ArrayList");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (this.collapseUnlessFocused) {
            return false;
        }
        refreshCollapsedState(true);
        boolean zRequestFocus = this.editView.requestFocus(direction, previouslyFocusedRect);
        if (!zRequestFocus) {
            refreshCollapsedState(hasFocus());
        }
        return zRequestFocus;
    }

    public final void setAdapter(StepOSRecipientBaseAdapter adapter) {
        StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = this.recipientAdapter;
        if (stepOSRecipientBaseAdapter != null) {
            stepOSRecipientBaseAdapter.unregisterContentObserver();
        }
        this.recipientAdapter = adapter;
        this.editView.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerContentObserver();
        }
        applyEditInputType();
    }

    public final void setAddButtonVisible(boolean z10) {
        this.isAddButtonVisible = z10;
        this.addButton.setVisibility(z10 ? 0 : 8);
    }

    public final void setButtonClickListener(View.OnClickListener listener) {
        this.buttonClickListener = listener;
    }

    public final void setButtonVisibility(boolean visible) {
        setAddButtonVisible(visible);
    }

    public final void setChipBackgroundColor(Integer num) throws Resources.NotFoundException {
        if (kotlin.jvm.internal.p.d(this.chipBackgroundColor, num)) {
            return;
        }
        this.chipBackgroundColor = num;
        refreshChipColors();
    }

    public final void setChipBackgroundEnabled(boolean z10) throws Resources.NotFoundException {
        if (this.isChipBackgroundEnabled == z10) {
            return;
        }
        this.isChipBackgroundEnabled = z10;
        refreshChipColors();
        refreshCollapsedState(hasFocus());
    }

    public final void setChipTextColor(Integer num) throws Resources.NotFoundException {
        if (kotlin.jvm.internal.p.d(this.chipTextColor, num)) {
            return;
        }
        this.chipTextColor = num;
        refreshChipColors();
    }

    public final void setColorType(int i10) throws Resources.NotFoundException {
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException(("colorType must be EMAIL/SMS/CALENDAR but was " + i10).toString());
        }
        if (this.colorType == i10) {
            return;
        }
        this.colorType = i10;
        refreshChipColors();
    }

    public final void setDragEnabled(boolean z10) {
        this.isDragEnabled = z10;
    }

    public final void setDragWatcher(RecipientDragWatcher watcher) {
        this.dragWatcher = watcher;
    }

    public final void setDropDownAnchor(View view) {
        this.editView.setDropDownAnchor(view != null ? view.getId() : -1);
    }

    public final void setEasyMode(boolean z10) throws Resources.NotFoundException {
        if (this.isEasyMode == z10) {
            return;
        }
        this.isEasyMode = z10;
        applyTextAppearance();
    }

    public final void setEnabledDrag(boolean enabled) {
        this.isDragEnabled = enabled;
    }

    @Override // android.view.View
    public void setFocusable(boolean focusable) {
        this.editView.setFocusable(focusable);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        this.editView.setFocusableInTouchMode(focusableInTouchMode);
    }

    public final void setGlassEffect(y7.o oVar) {
        if (oVar != null) {
            this.glassRow.setGlassEffect(oVar);
        }
    }

    public final void setGlassEnabled(boolean z10) {
        this.glassRow.setGlassEnabled(z10);
        applyGlassFallback();
    }

    public final void setHeaderText(String text) {
        setHint(text);
    }

    public final void setHideHintView() {
        setHintVisible(false);
    }

    public final void setHint(CharSequence charSequence) {
        this.hintView.setText(charSequence);
        this.summaryHint.setText(charSequence);
    }

    public final void setHintText(String text, int color) {
        this.customHintText = text;
        this.customHintColor = color;
        refreshCollapsedState(hasFocus());
    }

    public final void setHintTextColor(Integer num) {
        if (kotlin.jvm.internal.p.d(this.hintTextColor, num)) {
            return;
        }
        this.hintTextColor = num;
        applyHintTextColor();
    }

    public final void setHintVisible(boolean z10) {
        if (this.isHintVisible == z10) {
            return;
        }
        this.isHintVisible = z10;
        refreshCollapsedState(hasFocus());
    }

    public final void setImeOptions(int imeOptions) {
        this.editView.setImeOptions(imeOptions);
    }

    public final void setInputType(int i10) {
        if (this.inputType == i10) {
            return;
        }
        this.inputType = i10;
        applyEditInputType();
    }

    public final void setInvalidTextColor(Integer num) throws Resources.NotFoundException {
        if (kotlin.jvm.internal.p.d(this.invalidTextColor, num)) {
            return;
        }
        this.invalidTextColor = num;
        refreshChipColors();
    }

    public final void setIsValidateRecognition(boolean recognition) throws Resources.NotFoundException {
        setValidateRecognition(recognition);
    }

    public final void setLabelTextSize(float size) {
        this.hintView.setTextSize(size);
        this.summaryHint.setTextSize(size);
    }

    public final void setMaxHeight(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("maxHeight must be >= 0 but was " + i10).toString());
        }
        if (this.maxHeight == i10) {
            return;
        }
        this.maxHeight = i10;
        requestLayout();
    }

    public final void setNoBackground(boolean noBackground) {
        if (noBackground) {
            this.glassRow.setElevation(0.0f);
            this.glassRow.setSurfaceDrawable(null);
            setBackground(null);
        }
    }

    @Override // android.view.View
    public void setOnDragListener(View.OnDragListener l10) {
        this.hostDragListener = l10;
    }

    public final void setOnDropDownListener(OnDropDownListener listener) {
        this.onDropDownListener = listener;
    }

    public final void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.editView.setOnItemClickListener(listener);
    }

    public final void setOnKeyPreImeListener(StepOSRecipientAutoCompleteTextView.OnKeyPreImeListener listener) {
        this.editView.setOnKeyPreImeListener(listener);
    }

    public final void setOnRecipientChangedListener(OnRecipientChangedListener listener) {
        this.onRecipientChangedListener = listener;
    }

    public final void setOnRecipientFirstAddListener(OnRecipientFirstAddListener listener) {
        this.onRecipientFirstAddListener = listener;
    }

    public final void setOnRecipientSimpleChangedListener(OnRecipientSimpleChangedListener listener) {
        this.onRecipientSimpleChangedListener = listener;
    }

    public final void setOnSingleRecipientAddWhenGroupListener(OnSingleRecipientAddWhenGroupListener listener) {
        this.onSingleAddWhenGroupListener = listener;
    }

    public final void setOnTextChangedListener(OnTextChangedListener listener) {
        this.onTextChangedListener = listener;
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        this.glassRow.setPadding(left, top, right, bottom);
    }

    public final void setRecipientColorType(int type) throws Resources.NotFoundException {
        setColorType(type);
    }

    public final void setRecipientSipStateCheckListener(OnRecipientSipStateCheckListener listener) {
        this.sipStateCheckListener = listener;
    }

    public final void setRippleColor(Integer num) {
        if (kotlin.jvm.internal.p.d(this.rippleColor, num)) {
            return;
        }
        this.rippleColor = num;
        applyAddButtonRipple();
    }

    public final void setSelectedChipBackgroundColor(Integer num) throws Resources.NotFoundException {
        if (kotlin.jvm.internal.p.d(this.selectedChipBackgroundColor, num)) {
            return;
        }
        this.selectedChipBackgroundColor = num;
        refreshChipColors();
    }

    public final void setSelectedTextColor(Integer num) throws Resources.NotFoundException {
        if (kotlin.jvm.internal.p.d(this.selectedTextColor, num)) {
            return;
        }
        this.selectedTextColor = num;
        refreshChipColors();
    }

    public final void setText(CharSequence text, boolean filter) {
        StepOSRecipientAutoCompleteTextView stepOSRecipientAutoCompleteTextView = this.editView;
        if (filter) {
            stepOSRecipientAutoCompleteTextView.setText(text);
        } else {
            stepOSRecipientAutoCompleteTextView.setText(text, false);
        }
    }

    public final void setTextAppearance(int resId) {
        if (resId == -1) {
            return;
        }
        this.hintView.setTextAppearance(resId);
        this.editView.setTextAppearance(resId);
        this.summaryHint.setTextAppearance(resId);
        this.summaryName.setTextAppearance(resId);
    }

    public final void setTextColor(Integer num) throws Resources.NotFoundException {
        if (kotlin.jvm.internal.p.d(this.textColor, num)) {
            return;
        }
        this.textColor = num;
        applyContentTextColor();
        refreshChipColors();
    }

    public final void setTypefaceFromAttrs(String familyName) {
        if (familyName == null) {
            return;
        }
        Typeface typefaceCreate = Typeface.create(familyName, 0);
        if (typefaceCreate == null) {
            return;
        }
        this.hintView.setTypeface(typefaceCreate);
        this.editView.setTypeface(typefaceCreate);
        this.summaryHint.setTypeface(typefaceCreate);
        this.summaryName.setTypeface(typefaceCreate);
        int childCount = this.chipFlow.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.chipFlow.getChildAt(i10);
            StepOSRecipientChip stepOSRecipientChip = childAt instanceof StepOSRecipientChip ? (StepOSRecipientChip) childAt : null;
            if (stepOSRecipientChip != null) {
                stepOSRecipientChip.setTypeface(typefaceCreate);
            }
        }
    }

    public final void setValidateRecognition(boolean z10) throws Resources.NotFoundException {
        if (this.isValidateRecognition == z10) {
            return;
        }
        this.isValidateRecognition = z10;
        refreshChipColors();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final boolean addRecipient(CharSequence number, CharSequence contactName) {
        String string = number != null ? number.toString() : null;
        if (string == null) {
            string = "";
        }
        return addRecipientInternal(string, contactName != null ? contactName.toString() : null, true);
    }

    public final boolean addRecipientInternal(String number, String contactName, boolean refresh) {
        kotlin.jvm.internal.p.i(number, "number");
        return insertRecipient(number, contactName, -1, refresh);
    }

    public final void setDropDownAnchor(int anchorId) {
        this.editView.setDropDownAnchor(anchorId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientEdit(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final boolean addRecipient(String number, StepOSContactInfo contactInfo) {
        kotlin.jvm.internal.p.i(number, "number");
        if (contactInfo != null) {
            this.recipientInfo.put(number, contactInfo);
        }
        return addRecipient(number, contactInfo != null ? contactInfo.getContactName() : null);
    }

    public final boolean addRecipientInternal(String number, String contactName, int dragPos) {
        kotlin.jvm.internal.p.i(number, "number");
        return insertRecipient(number, contactName, dragPos, true);
    }

    public final void refreshLayout(boolean focus) {
        refreshCollapsedState(focus);
        dispatchChanged();
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R2\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R2\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(¨\u0006-"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientEdit$SavedState;", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "source", "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "addresses", "Ljava/util/ArrayList;", "getAddresses", "()Ljava/util/ArrayList;", "setAddresses", "(Ljava/util/ArrayList;)V", "names", "getNames", "setNames", "editText", "Ljava/lang/String;", "getEditText", "()Ljava/lang/String;", "setEditText", "(Ljava/lang/String;)V", "inputType", "I", "getInputType", "()I", "setInputType", "(I)V", "colorType", "getColorType", "setColorType", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private ArrayList<String> addresses;
        private int colorType;
        private String editText;
        private int inputType;
        private ArrayList<String> names;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.stepos.widget.recipient.StepOSRecipientEdit$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public StepOSRecipientEdit.SavedState[] newArray(int size) {
                return new StepOSRecipientEdit.SavedState[size];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public StepOSRecipientEdit.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSRecipientEdit.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public StepOSRecipientEdit.SavedState createFromParcel(Parcel source) {
                kotlin.jvm.internal.p.i(source, "source");
                return new StepOSRecipientEdit.SavedState(source, null);
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            kotlin.jvm.internal.p.i(superState, "superState");
            this.addresses = new ArrayList<>();
            this.names = new ArrayList<>();
            this.editText = "";
        }

        public final ArrayList<String> getAddresses() {
            return this.addresses;
        }

        public final int getColorType() {
            return this.colorType;
        }

        public final String getEditText() {
            return this.editText;
        }

        public final int getInputType() {
            return this.inputType;
        }

        public final ArrayList<String> getNames() {
            return this.names;
        }

        public final void setAddresses(ArrayList<String> arrayList) {
            kotlin.jvm.internal.p.i(arrayList, "<set-?>");
            this.addresses = arrayList;
        }

        public final void setColorType(int i10) {
            this.colorType = i10;
        }

        public final void setEditText(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.editText = str;
        }

        public final void setInputType(int i10) {
            this.inputType = i10;
        }

        public final void setNames(ArrayList<String> arrayList) {
            kotlin.jvm.internal.p.i(arrayList, "<set-?>");
            this.names = arrayList;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            kotlin.jvm.internal.p.i(dest, "dest");
            super.writeToParcel(dest, flags);
            dest.writeStringList(this.addresses);
            dest.writeStringList(this.names);
            dest.writeString(this.editText);
            dest.writeInt(this.inputType);
            dest.writeInt(this.colorType);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            kotlin.jvm.internal.p.i(source, "source");
            this.addresses = new ArrayList<>();
            this.names = new ArrayList<>();
            this.editText = "";
            ArrayList<String> arrayListCreateStringArrayList = source.createStringArrayList();
            this.addresses = arrayListCreateStringArrayList == null ? new ArrayList<>() : arrayListCreateStringArrayList;
            ArrayList<String> arrayListCreateStringArrayList2 = source.createStringArrayList();
            this.names = arrayListCreateStringArrayList2 == null ? new ArrayList<>() : arrayListCreateStringArrayList2;
            String string = source.readString();
            this.editText = string != null ? string : "";
            this.inputType = source.readInt();
            this.colorType = source.readInt();
        }
    }

    public /* synthetic */ StepOSRecipientEdit(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposRecipientEditStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_RecipientEdit : i11);
    }

    public final boolean addRecipientInternal(String number, String contactName, int dragPos, boolean refresh) {
        kotlin.jvm.internal.p.i(number, "number");
        return insertRecipient(number, contactName, dragPos, refresh);
    }

    public final int addRecipient(ArrayList<String> list) {
        String strA0;
        kotlin.jvm.internal.p.i(list, "list");
        Iterator<String> it = list.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        int i10 = 0;
        while (it.hasNext()) {
            String next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            String str = next;
            if (str.length() != 0) {
                List listB1 = H.b1(str, new String[]{Const.STR_MART_SEMICOLON}, false, 0, 6, null);
                String str2 = (String) listB1.get(0);
                if (listB1.size() <= 1) {
                    strA0 = null;
                } else {
                    strA0 = listB1.size() == 2 ? (String) listB1.get(1) : F.A0(F.h0(listB1, 1), Const.STR_MART_SEMICOLON, null, null, 0, null, null, 62, null);
                }
                if (addRecipientInternal(str2, strA0, false)) {
                    i10++;
                }
            }
        }
        if (i10 > 0) {
            refreshCollapsedState(hasFocus());
            dispatchChanged();
            notifySingleRecipientWhenGroup();
        }
        return i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientEdit(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        StepOSGlassLinearLayout stepOSGlassLinearLayout = new StepOSGlassLinearLayout(context, null, 0, 0, 14, null);
        stepOSGlassLinearLayout.setId(R.id.stepos_recipient_glass_row);
        stepOSGlassLinearLayout.setOrientation(0);
        stepOSGlassLinearLayout.setGravity(16);
        this.glassRow = stepOSGlassLinearLayout;
        TextView textView = new TextView(context);
        this.hintView = textView;
        TextView textView2 = new TextView(context);
        this.summaryHint = textView2;
        TextView textView3 = new TextView(context);
        this.summaryName = textView3;
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        StepOSRecipientChipFlow stepOSRecipientChipFlow = new StepOSRecipientChipFlow(context, null, 0, 6, null);
        this.chipFlow = stepOSRecipientChipFlow;
        StepOSRecipientAutoCompleteTextView stepOSRecipientAutoCompleteTextView = new StepOSRecipientAutoCompleteTextView(context, null, 0, 6, null);
        stepOSRecipientAutoCompleteTextView.setId(R.id.stepos_recipient_edit);
        this.editView = stepOSRecipientAutoCompleteTextView;
        ImageButton imageButton = new ImageButton(context);
        imageButton.setId(R.id.stepos_recipient_add);
        this.addButton = imageButton;
        this.recipientData = new ArrayList<>();
        this.recipientNames = new LinkedHashMap<>();
        this.recipientInfo = new LinkedHashMap<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.expandTouchTarget = new Runnable() { // from class: com.stepos.widget.recipient.k
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.f31328a.expandAddButtonTouchTarget();
            }
        };
        this.restoreCollapsedIfUnfocused = new Runnable() { // from class: com.stepos.widget.recipient.l
            @Override // java.lang.Runnable
            public final void run() {
                StepOSRecipientEdit.restoreCollapsedIfUnfocused$lambda$4(this.f31329a);
            }
        };
        this.listenFocusChange = true;
        this.notifyFocusLost = new Runnable() { // from class: com.stepos.widget.recipient.m
            @Override // java.lang.Runnable
            public final void run() {
                StepOSRecipientEdit.notifyFocusLost$lambda$5(this.f31330a);
            }
        };
        this.deferredRefresh = new Runnable() { // from class: com.stepos.widget.recipient.n
            @Override // java.lang.Runnable
            public final void run() {
                StepOSRecipientEdit.deferredRefresh$lambda$6(this.f31331a);
            }
        };
        this.dragSnapshot = new ArrayList<>();
        this.firstDragIndex = -1;
        this.inputType = 3;
        this.isAddButtonVisible = true;
        this.isHintVisible = true;
        this.isValidateRecognition = true;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_recipient_padding_horizontal);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stepos_recipient_padding_vertical);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.stepos_recipient_flow_padding_vertical);
        setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.stepos_recipient_min_height));
        stepOSGlassLinearLayout.setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        int i12 = R.style.StepOSTextAppearance_Recipient_Hint;
        textView.setTextAppearance(i12);
        textView2.setTextAppearance(i12);
        int i13 = R.style.StepOSTextAppearance_Recipient;
        textView3.setTextAppearance(i13);
        textView.setPaddingRelative(0, 0, getResources().getDimensionPixelSize(R.dimen.stepos_recipient_hint_padding_end), 0);
        textView2.setPaddingRelative(0, 0, getResources().getDimensionPixelSize(R.dimen.stepos_recipient_summary_padding_end), 0);
        textView3.setVisibility(8);
        textView2.setVisibility(8);
        stepOSRecipientAutoCompleteTextView.setTextAppearance(i13);
        stepOSRecipientAutoCompleteTextView.setTextColor(androidx.core.content.a.c(context, R.color.stepos_recipient_input_text));
        stepOSRecipientAutoCompleteTextView.setHintTextColor(androidx.core.content.a.c(context, R.color.stepos_recipient_hint));
        stepOSRecipientAutoCompleteTextView.setBackground(null);
        stepOSRecipientAutoCompleteTextView.setTextCursorDrawable(R.drawable.stepos_bg_text_cursor);
        stepOSRecipientAutoCompleteTextView.setMinWidth(getResources().getDimensionPixelSize(R.dimen.stepos_recipient_add_touch_target));
        stepOSRecipientAutoCompleteTextView.setThreshold(1);
        if (getId() == -1) {
            setId(View.generateViewId());
        }
        stepOSRecipientAutoCompleteTextView.setDropDownAnchor(getId());
        stepOSRecipientAutoCompleteTextView.setAcceptFocusRequest$StepOSWidget_release(new InterfaceC5063a() { // from class: com.stepos.widget.recipient.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(StepOSRecipientEdit._init_$lambda$9(this.f31332a));
            }
        });
        stepOSRecipientAutoCompleteTextView.setOnFocusChangeListener(this);
        stepOSRecipientAutoCompleteTextView.addTextChangedListener(new TextWatcher() { // from class: com.stepos.widget.recipient.StepOSRecipientEdit.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s10) {
                if (s10 == null) {
                    return;
                }
                Object[] spans = s10.getSpans(0, s10.length(), StepOSParcelableImageSpan.class);
                kotlin.jvm.internal.p.h(spans, "getSpans(...)");
                if (spans.length == 0) {
                    OnRecipientChangedListener onRecipientChangedListener = StepOSRecipientEdit.this.onRecipientChangedListener;
                    if (onRecipientChangedListener != null) {
                        onRecipientChangedListener.onRecipientChanged();
                    }
                    StepOSRecipientEdit.this.inAfterTextChanged = true;
                    StepOSRecipientEdit.this.refreshNeededFromTextChange = false;
                    try {
                        StepOSRecipientEdit.this.handleAfterTextChanged(s10);
                    } finally {
                        StepOSRecipientEdit.this.inAfterTextChanged = false;
                        if (StepOSRecipientEdit.this.refreshNeededFromTextChange) {
                            StepOSRecipientEdit stepOSRecipientEdit = StepOSRecipientEdit.this;
                            stepOSRecipientEdit.removeCallbacks(stepOSRecipientEdit.deferredRefresh);
                            StepOSRecipientEdit stepOSRecipientEdit2 = StepOSRecipientEdit.this;
                            stepOSRecipientEdit2.post(stepOSRecipientEdit2.deferredRefresh);
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s10, int start, int before, int count) {
                StepOSRecipientEdit.this.changeCount = count;
                OnTextChangedListener onTextChangedListener = StepOSRecipientEdit.this.onTextChangedListener;
                if (onTextChangedListener != null) {
                    onTextChangedListener.onTextChanged(s10, start, before, count);
                }
            }
        });
        stepOSRecipientAutoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.stepos.widget.recipient.p
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView4, int i14, KeyEvent keyEvent) {
                return StepOSRecipientEdit._init_$lambda$10(this.f31333a, textView4, i14, keyEvent);
            }
        });
        stepOSRecipientAutoCompleteTextView.setOnDropDownListener(new StepOSRecipientAutoCompleteTextView.OnDropDownListener() { // from class: com.stepos.widget.recipient.c
            @Override // com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView.OnDropDownListener
            public final void onDropDownVisibilityChanged(boolean z10) {
                StepOSRecipientEdit._init_$lambda$11(this.f31313a, z10);
            }
        });
        stepOSRecipientAutoCompleteTextView.setOnEmptyDeleteListener(new StepOSRecipientAutoCompleteTextView.OnEmptyDeleteListener() { // from class: com.stepos.widget.recipient.d
            @Override // com.stepos.widget.recipient.StepOSRecipientAutoCompleteTextView.OnEmptyDeleteListener
            public final boolean onEmptyDelete() {
                return this.f31314a.handleDeleteKey();
            }
        });
        stepOSRecipientChipFlow.setPaddingRelative(0, dimensionPixelSize3, 0, dimensionPixelSize3);
        stepOSRecipientChipFlow.addView(stepOSRecipientAutoCompleteTextView, new ViewGroup.LayoutParams(-2, -2));
        scrollView.setFillViewport(true);
        scrollView.addView(stepOSRecipientChipFlow, new ViewGroup.LayoutParams(-1, -2));
        imageButton.setImageResource(R.drawable.stepos_icon_editinput_clean);
        imageButton.setBackground(null);
        imageButton.setContentDescription(context.getString(R.string.stepos_recipient_close));
        imageButton.setOnClickListener(this);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.stepos_recipient_add_padding);
        imageButton.setPaddingRelative(dimensionPixelSize4, dimensionPixelSize4, dimensionPixelSize4, dimensionPixelSize4);
        applyAddButtonRipple();
        stepOSGlassLinearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        stepOSGlassLinearLayout.addView(scrollView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        stepOSGlassLinearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        stepOSGlassLinearLayout.addView(textView3, new LinearLayout.LayoutParams(0, -2, 1.0f));
        Resources resources = getResources();
        int i14 = R.dimen.stepos_recipient_add_size;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(resources.getDimensionPixelSize(i14), getResources().getDimensionPixelSize(i14));
        layoutParams.setMarginEnd(0);
        t tVar = t.f7040a;
        stepOSGlassLinearLayout.addView(imageButton, layoutParams);
        addView(stepOSGlassLinearLayout, new FrameLayout.LayoutParams(-1, -2));
        setOnClickListener(this);
        stepOSGlassLinearLayout.setClickable(true);
        stepOSGlassLinearLayout.setOnClickListener(this);
        stepOSRecipientChipFlow.setClickable(true);
        stepOSRecipientChipFlow.setOnClickListener(this);
        stepOSRecipientAutoCompleteTextView.setOnClickListener(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSRecipientEdit, i10, i11);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        setInputType(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSRecipientEdit_steposRecipientEditInputType, 3));
        int i15 = R.styleable.StepOSRecipientEdit_steposRecipientEditHint;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            setHint(typedArrayObtainStyledAttributes.getText(i15));
        } else {
            setHint(context.getString(R.string.stepos_recipient_hint));
        }
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSRecipientEdit_steposRecipientEditMaxHeight, getResources().getDimensionPixelSize(R.dimen.stepos_recipient_max_height)));
        setEasyMode(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSRecipientEdit_steposRecipientEditEasyMode, false));
        setColorType(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSRecipientEdit_steposRecipientEditColorType, 0));
        setAddButtonVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSRecipientEdit_steposRecipientEditAddButtonVisible, true));
        this.isDragEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSRecipientEdit_steposRecipientEditDragEnabled, false);
        setValidateRecognition(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSRecipientEdit_steposRecipientEditValidateRecognition, true));
        setChipBackgroundEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSRecipientEdit_steposRecipientEditChipBackgroundEnabled, false));
        stepOSGlassLinearLayout.setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSRecipientEdit_steposGlassEnabled, true));
        y7.o oVar = GlassEffectResolver.INSTANCE.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSRecipientEdit_steposGlassEffect);
        if (oVar != null) {
            stepOSGlassLinearLayout.setGlassEffect(oVar);
        }
        setHintVisible(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSRecipientEdit_steposRecipientEditHintVisible, true));
        int i16 = R.styleable.StepOSRecipientEdit_steposRecipientEditTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            setTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i16, 0)));
        }
        int i17 = R.styleable.StepOSRecipientEdit_steposRecipientEditChipTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            setChipTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i17, 0)));
        }
        int i18 = R.styleable.StepOSRecipientEdit_steposRecipientEditHintTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            setHintTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i18, 0)));
        }
        int i19 = R.styleable.StepOSRecipientEdit_steposRecipientEditSelectedTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i19)) {
            setSelectedTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i19, 0)));
        }
        int i20 = R.styleable.StepOSRecipientEdit_steposRecipientEditChipBackgroundColor;
        if (typedArrayObtainStyledAttributes.hasValue(i20)) {
            setChipBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i20, 0)));
        }
        int i21 = R.styleable.StepOSRecipientEdit_steposRecipientEditSelectedChipBackgroundColor;
        if (typedArrayObtainStyledAttributes.hasValue(i21)) {
            setSelectedChipBackgroundColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i21, 0)));
        }
        int i22 = R.styleable.StepOSRecipientEdit_steposRecipientEditInvalidTextColor;
        if (typedArrayObtainStyledAttributes.hasValue(i22)) {
            setInvalidTextColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i22, 0)));
        }
        int i23 = R.styleable.StepOSRecipientEdit_steposRecipientEditRippleColor;
        if (typedArrayObtainStyledAttributes.hasValue(i23)) {
            setRippleColor(Integer.valueOf(typedArrayObtainStyledAttributes.getColor(i23, 0)));
        }
        typedArrayObtainStyledAttributes.recycle();
        applyEditInputType();
        applyTextAppearance();
        applyDefaultGlass();
        applyGlassFallback();
        refreshCollapsedState(hasFocus());
        this.refreshNamesRunnable = new Runnable() { // from class: com.stepos.widget.recipient.e
            @Override // java.lang.Runnable
            public final void run() {
                StepOSRecipientEdit.refreshNamesRunnable$lambda$30(this.f31315a);
            }
        };
    }
}
