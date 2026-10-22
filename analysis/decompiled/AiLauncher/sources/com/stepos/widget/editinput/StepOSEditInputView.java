package com.stepos.widget.editinput;

import Y8.t;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C1299l;
import androidx.customview.view.AbsSavedState;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.editinput.StepOSEditInputView;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.glass.StepOSGlassPresets;
import com.stepos.widget.internal.HotspotRipple;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;
import y7.o;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bN\b\u0016\u0018\u0000 ñ\u00012\u00020\u0001:\bò\u0001ó\u0001ô\u0001ñ\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u000e*\u00020\u000bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010\u0010J!\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010\u0010J\u000f\u0010'\u001a\u00020\u000eH\u0002¢\u0006\u0004\b'\u0010\u0010J\u000f\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\u0010J\u000f\u0010)\u001a\u00020\u000eH\u0002¢\u0006\u0004\b)\u0010\u0010J\u000f\u0010*\u001a\u00020\u000eH\u0002¢\u0006\u0004\b*\u0010\u0010J\u000f\u0010+\u001a\u00020\u000eH\u0002¢\u0006\u0004\b+\u0010\u0010J\u000f\u0010,\u001a\u00020\u000eH\u0002¢\u0006\u0004\b,\u0010\u0010J\u000f\u0010-\u001a\u00020\u000eH\u0002¢\u0006\u0004\b-\u0010\u0010J\u000f\u0010.\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010\u0010J\u000f\u0010/\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u0010\u0010J\u0019\u00102\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u000200H\u0002¢\u0006\u0004\b4\u00105J\u0019\u00108\u001a\u0004\u0018\u0001072\u0006\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u00109J)\u0010?\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\r\u0010B\u001a\u00020A¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\u000e2\b\b\u0001\u0010D\u001a\u00020\u0006¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\u000e2\b\b\u0001\u0010G\u001a\u00020\u0006¢\u0006\u0004\bH\u0010FJ\r\u0010I\u001a\u00020\u000e¢\u0006\u0004\bI\u0010\u0010J\u0017\u0010J\u001a\u00020\u000e2\b\b\u0001\u0010G\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010FJ\u0017\u0010K\u001a\u00020\u000e2\b\b\u0001\u0010G\u001a\u00020\u0006¢\u0006\u0004\bK\u0010FJ7\u0010Q\u001a\u00020\u000e2\u0006\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0006H\u0014¢\u0006\u0004\bQ\u0010RJ\u0017\u0010U\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u000eH\u0014¢\u0006\u0004\bW\u0010\u0010J\u000f\u0010Y\u001a\u00020XH\u0014¢\u0006\u0004\bY\u0010ZJ\u0019\u0010\\\u001a\u00020\u000e2\b\u0010[\u001a\u0004\u0018\u00010XH\u0014¢\u0006\u0004\b\\\u0010]R\u0016\u0010^\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010m\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010hR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010rR,\u0010u\u001a\u00020\u00062\b\b\u0001\u0010t\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010FR,\u0010z\u001a\u00020\u00062\b\b\u0001\u0010t\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010v\u001a\u0004\b{\u0010x\"\u0004\b|\u0010FR,\u0010}\u001a\u00020\u00062\b\b\u0001\u0010t\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010v\u001a\u0004\b~\u0010x\"\u0004\b\u007f\u0010FR\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010vR\u0018\u0010\u0089\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010vR\u0019\u0010\u008a\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u008c\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008b\u0001R\u0019\u0010\u008d\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008b\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u0083\u0001R\u001b\u0010\u008f\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0081\u0001R\u0019\u0010\u0090\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008b\u0001R\u0019\u0010\u0091\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008b\u0001R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0083\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0083\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0081\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0081\u0001R\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0081\u0001R\u0019\u0010\u0097\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u008b\u0001R\u0019\u0010\u0098\u0001\u001a\u0004\u0018\u0001078\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0083\u0001R\u0019\u0010\u0099\u0001\u001a\u0004\u0018\u0001078\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0083\u0001R\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009c\u0001R\u001b\u0010\u009e\u0001\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010¡\u0001\u001a\u0005\u0018\u00010 \u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R,\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R-\u0010²\u0001\u001a\u0004\u0018\u00010;2\b\u0010t\u001a\u0004\u0018\u00010;8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R-\u0010·\u0001\u001a\u0004\u0018\u0001072\b\u0010t\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R-\u0010º\u0001\u001a\u0004\u0018\u00010;2\b\u0010t\u001a\u0004\u0018\u00010;8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¸\u0001\u0010¯\u0001\"\u0006\b¹\u0001\u0010±\u0001R-\u0010½\u0001\u001a\u0004\u0018\u00010;2\b\u0010t\u001a\u0004\u0018\u00010;8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b»\u0001\u0010¯\u0001\"\u0006\b¼\u0001\u0010±\u0001R.\u0010Á\u0001\u001a\u0005\u0018\u00010\u0085\u00012\t\u0010t\u001a\u0005\u0018\u00010\u0085\u00018F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0005\bE\u0010À\u0001R'\u0010Ä\u0001\u001a\u00020\u00062\u0006\u0010t\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÂ\u0001\u0010x\"\u0005\bÃ\u0001\u0010FR'\u0010Ç\u0001\u001a\u00020\u00062\u0006\u0010t\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÅ\u0001\u0010x\"\u0005\bÆ\u0001\u0010FR'\u0010È\u0001\u001a\u0002002\u0006\u0010t\u001a\u0002008F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÈ\u0001\u00105\"\u0005\bÉ\u0001\u00103R'\u0010Ê\u0001\u001a\u0002002\u0006\u0010t\u001a\u0002008F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÊ\u0001\u00105\"\u0005\bË\u0001\u00103R'\u0010Ì\u0001\u001a\u0002002\u0006\u0010t\u001a\u0002008F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÌ\u0001\u00105\"\u0005\bÍ\u0001\u00103R-\u0010Ð\u0001\u001a\u0004\u0018\u0001072\b\u0010t\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÎ\u0001\u0010´\u0001\"\u0006\bÏ\u0001\u0010¶\u0001R-\u0010Ó\u0001\u001a\u0004\u0018\u00010;2\b\u0010t\u001a\u0004\u0018\u00010;8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÑ\u0001\u0010¯\u0001\"\u0006\bÒ\u0001\u0010±\u0001R'\u0010Ô\u0001\u001a\u0002002\u0006\u0010t\u001a\u0002008F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÔ\u0001\u00105\"\u0005\bÕ\u0001\u00103R'\u0010Ö\u0001\u001a\u0002002\u0006\u0010t\u001a\u0002008F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÖ\u0001\u00105\"\u0005\b×\u0001\u00103R-\u0010Ú\u0001\u001a\u0004\u0018\u0001072\b\u0010t\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bØ\u0001\u0010´\u0001\"\u0006\bÙ\u0001\u0010¶\u0001R-\u0010Ý\u0001\u001a\u0004\u0018\u0001072\b\u0010t\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÛ\u0001\u0010´\u0001\"\u0006\bÜ\u0001\u0010¶\u0001R-\u0010à\u0001\u001a\u0004\u0018\u00010;2\b\u0010t\u001a\u0004\u0018\u00010;8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÞ\u0001\u0010¯\u0001\"\u0006\bß\u0001\u0010±\u0001R-\u0010ã\u0001\u001a\u0004\u0018\u00010;2\b\u0010t\u001a\u0004\u0018\u00010;8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bá\u0001\u0010¯\u0001\"\u0006\bâ\u0001\u0010±\u0001R-\u0010æ\u0001\u001a\u0004\u0018\u00010;2\b\u0010t\u001a\u0004\u0018\u00010;8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bä\u0001\u0010¯\u0001\"\u0006\bå\u0001\u0010±\u0001R\u0013\u0010ç\u0001\u001a\u0002008F¢\u0006\u0007\u001a\u0005\bç\u0001\u00105R'\u0010è\u0001\u001a\u0002002\u0006\u0010t\u001a\u0002008F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bè\u0001\u00105\"\u0005\bé\u0001\u00103R'\u0010ê\u0001\u001a\u0002002\u0006\u0010t\u001a\u0002008F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bê\u0001\u00105\"\u0005\bë\u0001\u00103R/\u0010ð\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010t\u001a\u0005\u0018\u00010\u009a\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001¨\u0006õ\u0001"}, d2 = {"Lcom/stepos/widget/editinput/StepOSEditInputView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroidx/appcompat/widget/l;", "createActionButton", "(Landroid/content/Context;)Landroidx/appcompat/widget/l;", "LY8/t;", "refreshActionTouchDelegates", "()V", "Landroid/view/View;", "parent", "target", "minTouch", "Landroid/graphics/Rect;", "expandedTouchBounds", "(Landroid/view/View;Landroid/view/View;I)Landroid/graphics/Rect;", "currentStart", "currentEnd", "parentSize", "", "expandAxis", "(IIII)[I", "installActionRipple", "(Landroidx/appcompat/widget/l;)V", "adoptHostBackground", "Landroid/content/res/TypedArray;", Const.INTENT_KEY_APIKEY, "index", "readAppearance", "(Landroid/content/res/TypedArray;I)Ljava/lang/Integer;", "applyDefaultAppearances", "applyEditTextConfig", "applyInputType", "applyTitle", "applyCleanIcon", "applyPasswordToggle", "refreshPasswordButton", "refreshCleanIconVisibility", "applyErrorState", "applyErrorOverlay", "", "force", "applyGlassPreset", "(Z)V", "isNightMode", "()Z", "drawableRes", "Landroid/graphics/drawable/Drawable;", "defaultIcon", "(I)Landroid/graphics/drawable/Drawable;", "view", "", "description", "", "attrName", "warnIfUnlabeled", "(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/String;)V", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "color", "setTextColorHint", "(I)V", "resId", "setCleanIconResource", "cleanContent", "setPasswordHiddenIconResource", "setPasswordVisibleIconResource", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDetachedFromWindow", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", VoiceWakeupReceiver.EXTRA_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "attrsValue", "Landroid/util/AttributeSet;", "Landroid/widget/LinearLayout;", "container", "Landroid/widget/LinearLayout;", "Lcom/stepos/widget/editinput/EditInputGlassRow;", "rowView", "Lcom/stepos/widget/editinput/EditInputGlassRow;", "Landroid/widget/TextView;", "titleView", "Landroid/widget/TextView;", "editTextView", "Landroid/widget/EditText;", "dividerView", "Landroid/view/View;", "errorView", "Lcom/stepos/widget/editinput/ActionTouchDelegate;", "actionTouchDelegates", "Lcom/stepos/widget/editinput/ActionTouchDelegate;", "cleanButtonView", "Landroidx/appcompat/widget/l;", "passwordButtonView", UxipConstants.f30680s, "titleTextAppearance", "I", "getTitleTextAppearance", "()I", "setTitleTextAppearance", "editTextAppearance", "getEditTextAppearance", "setEditTextAppearance", "errorTextAppearance", "getErrorTextAppearance", "setErrorTextAppearance", "titleValue", "Ljava/lang/CharSequence;", "titleIconValue", "Landroid/graphics/drawable/Drawable;", "hintValue", "Landroid/content/res/ColorStateList;", "textColorHintValue", "Landroid/content/res/ColorStateList;", "inputTypeValue", "imeOptionsValue", "cleanIconEnabledValue", "Z", "autoCleanIconEnabledValue", "cleanIconVisibleValue", "cleanIconValue", "cleanIconContentDescriptionValue", "passwordToggleEnabledValue", "passwordVisibleValue", "passwordHiddenIconValue", "passwordVisibleIconValue", "passwordHiddenContentDescriptionValue", "passwordVisibleContentDescriptionValue", "errorTextValue", "pressScaleEnabledValue", "fieldBackgroundFallback", "errorRingDrawable", "Ly7/o;", "explicitGlassEffectValue", "Ly7/o;", "appliedGlassEffect", "appliedGlassNight", "Ljava/lang/Boolean;", "Lcom/stepos/widget/editinput/StepOSEditInputView$OnCleanIconClickListener;", "onCleanIconClickListener", "Lcom/stepos/widget/editinput/StepOSEditInputView$OnCleanIconClickListener;", "getOnCleanIconClickListener", "()Lcom/stepos/widget/editinput/StepOSEditInputView$OnCleanIconClickListener;", "setOnCleanIconClickListener", "(Lcom/stepos/widget/editinput/StepOSEditInputView$OnCleanIconClickListener;)V", "Lcom/stepos/widget/editinput/StepOSEditInputView$OnPasswordToggleListener;", "onPasswordToggleListener", "Lcom/stepos/widget/editinput/StepOSEditInputView$OnPasswordToggleListener;", "getOnPasswordToggleListener", "()Lcom/stepos/widget/editinput/StepOSEditInputView$OnPasswordToggleListener;", "setOnPasswordToggleListener", "(Lcom/stepos/widget/editinput/StepOSEditInputView$OnPasswordToggleListener;)V", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "title", "getTitleIcon", "()Landroid/graphics/drawable/Drawable;", "setTitleIcon", "(Landroid/graphics/drawable/Drawable;)V", "titleIcon", "getHint", "setHint", "hint", "getText", "setText", "text", "getTextColorHint", "()Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "textColorHint", "getInputType", "setInputType", "inputType", "getImeOptions", "setImeOptions", "imeOptions", "isCleanIconEnabled", "setCleanIconEnabled", "isAutoCleanIconEnabled", "setAutoCleanIconEnabled", "isCleanIconVisible", "setCleanIconVisible", "getCleanIcon", "setCleanIcon", "cleanIcon", "getCleanIconContentDescription", "setCleanIconContentDescription", "cleanIconContentDescription", "isPasswordToggleEnabled", "setPasswordToggleEnabled", "isPasswordVisible", "setPasswordVisible", "getPasswordHiddenIcon", "setPasswordHiddenIcon", "passwordHiddenIcon", "getPasswordVisibleIcon", "setPasswordVisibleIcon", "passwordVisibleIcon", "getPasswordHiddenContentDescription", "setPasswordHiddenContentDescription", "passwordHiddenContentDescription", "getPasswordVisibleContentDescription", "setPasswordVisibleContentDescription", "passwordVisibleContentDescription", "getErrorText", "setErrorText", "errorText", "isErrorShown", "isPressScaleEnabled", "setPressScaleEnabled", "isGlassEnabled", "setGlassEnabled", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "glassEffect", "Companion", "OnCleanIconClickListener", "OnPasswordToggleListener", "SavedState", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSEditInputView extends FrameLayout {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int IME_OPTIONS_UNSPECIFIED = 0;

    @Deprecated
    public static final String WIDGET_LOG_TAG = "StepOSEditInputView";
    private final ActionTouchDelegate actionTouchDelegates;
    private o appliedGlassEffect;
    private Boolean appliedGlassNight;
    private final AttributeSet attrsValue;
    private boolean autoCleanIconEnabledValue;
    private final C1299l cleanButtonView;
    private CharSequence cleanIconContentDescriptionValue;
    private boolean cleanIconEnabledValue;
    private Drawable cleanIconValue;
    private boolean cleanIconVisibleValue;
    private final LinearLayout container;
    private final View dividerView;
    private int editTextAppearance;
    private final EditText editTextView;
    private final Drawable errorRingDrawable;
    private int errorTextAppearance;
    private CharSequence errorTextValue;
    private final TextView errorView;
    private o explicitGlassEffectValue;
    private final Drawable fieldBackgroundFallback;
    private CharSequence hintValue;
    private int imeOptionsValue;
    private int inputTypeValue;
    private OnCleanIconClickListener onCleanIconClickListener;
    private OnPasswordToggleListener onPasswordToggleListener;
    private final C1299l passwordButtonView;
    private CharSequence passwordHiddenContentDescriptionValue;
    private Drawable passwordHiddenIconValue;
    private boolean passwordToggleEnabledValue;
    private CharSequence passwordVisibleContentDescriptionValue;
    private Drawable passwordVisibleIconValue;
    private boolean passwordVisibleValue;
    private boolean pressScaleEnabledValue;
    private final EditInputGlassRow rowView;
    private ColorStateList textColorHintValue;
    private Drawable titleIconValue;
    private int titleTextAppearance;
    private CharSequence titleValue;
    private final TextView titleView;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/widget/editinput/StepOSEditInputView$Companion;", "", "<init>", "()V", "IME_OPTIONS_UNSPECIFIED", "", "WIDGET_LOG_TAG", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/widget/editinput/StepOSEditInputView$OnCleanIconClickListener;", "", "LY8/t;", "onCleanIconClick", "()V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnCleanIconClickListener {
        void onCleanIconClick();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/editinput/StepOSEditInputView$OnPasswordToggleListener;", "", "", "isPasswordVisible", "LY8/t;", "onPasswordToggle", "(Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnPasswordToggleListener {
        void onPasswordToggle(boolean isPasswordVisible);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSEditInputView(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$18(StepOSEditInputView stepOSEditInputView, View view) {
        stepOSEditInputView.cleanContent();
        OnCleanIconClickListener onCleanIconClickListener = stepOSEditInputView.onCleanIconClickListener;
        if (onCleanIconClickListener != null) {
            onCleanIconClickListener.onCleanIconClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$19(StepOSEditInputView stepOSEditInputView, View view) {
        stepOSEditInputView.setPasswordVisible(!stepOSEditInputView.passwordVisibleValue);
        OnPasswordToggleListener onPasswordToggleListener = stepOSEditInputView.onPasswordToggleListener;
        if (onPasswordToggleListener != null) {
            onPasswordToggleListener.onPasswordToggle(stepOSEditInputView.passwordVisibleValue);
        }
    }

    private final void adoptHostBackground() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.attrsValue, new int[]{R.attr.background});
        p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        Drawable background = getBackground();
        super.setBackground(null);
        EditInputGlassRow editInputGlassRow = this.rowView;
        if (!zHasValue && background == null) {
            background = this.fieldBackgroundFallback;
        }
        editInputGlassRow.setSurfaceDrawable(background);
    }

    private final void applyCleanIcon() {
        C1299l c1299l = this.cleanButtonView;
        Drawable drawableDefaultIcon = this.cleanIconValue;
        if (drawableDefaultIcon == null) {
            drawableDefaultIcon = defaultIcon(com.stepos.widget.R.drawable.stepos_icon_editinput_clean);
        }
        c1299l.setImageDrawable(drawableDefaultIcon);
        this.cleanButtonView.setContentDescription(this.cleanIconContentDescriptionValue);
        refreshCleanIconVisibility();
        warnIfUnlabeled(this.cleanButtonView, this.cleanIconContentDescriptionValue, "steposEditInputViewCleanIconContentDescription");
    }

    private final void applyDefaultAppearances() {
        if (this.titleTextAppearance == 0) {
            this.titleView.setTextAppearance(getContext(), com.stepos.widget.R.style.StepOSTextAppearance_EditInput_Title);
        }
        if (this.editTextAppearance == 0) {
            this.editTextView.setTextAppearance(getContext(), com.stepos.widget.R.style.StepOSTextAppearance_EditInput_Text);
        }
        if (this.errorTextAppearance == 0) {
            this.errorView.setTextAppearance(getContext(), com.stepos.widget.R.style.StepOSTextAppearance_EditInput_Error);
        }
    }

    private final void applyEditTextConfig() {
        this.editTextView.setHint(this.hintValue);
        ColorStateList colorStateList = this.textColorHintValue;
        if (colorStateList != null) {
            this.editTextView.setHintTextColor(colorStateList);
        }
        applyInputType();
        this.editTextView.setImeOptions(this.imeOptionsValue);
    }

    private final void applyErrorOverlay() {
        EditInputGlassRow editInputGlassRow = this.rowView;
        editInputGlassRow.setErrorRing(editInputGlassRow.getIsGlassEnabled() ? this.errorRingDrawable : null);
    }

    private final void applyErrorState() {
        CharSequence charSequence = this.errorTextValue;
        boolean z10 = charSequence == null || charSequence.length() == 0;
        boolean z11 = !z10;
        this.errorView.setText(this.errorTextValue);
        this.errorView.setVisibility(z10 ? 8 : 0);
        this.rowView.setActivated(z11);
        applyErrorOverlay();
    }

    private final void applyGlassPreset(boolean force) {
        boolean zIsNightMode = isNightMode();
        o oVar = this.explicitGlassEffectValue;
        if (!force && p.d(this.appliedGlassNight, Boolean.valueOf(zIsNightMode)) && p.d(this.appliedGlassEffect, oVar)) {
            return;
        }
        this.appliedGlassNight = Boolean.valueOf(zIsNightMode);
        this.appliedGlassEffect = oVar;
        if (oVar != null) {
            this.rowView.setGlassEffect(oVar);
        } else {
            float f10 = getResources().getDisplayMetrics().density;
            this.rowView.applyCustomGlass(zIsNightMode ? StepOSGlassPresets.INSTANCE.TITLE_BAR_DARK_TUNED(f10) : StepOSGlassPresets.INSTANCE.TITLE_BAR_LIGHT_TUNED(f10));
        }
    }

    public static /* synthetic */ void applyGlassPreset$default(StepOSEditInputView stepOSEditInputView, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyGlassPreset");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        stepOSEditInputView.applyGlassPreset(z10);
    }

    private final void applyInputType() {
        Typeface typeface = this.editTextView.getTypeface();
        p.h(typeface, "getTypeface(...)");
        int selectionStart = this.editTextView.getSelectionStart();
        int selectionEnd = this.editTextView.getSelectionEnd();
        this.editTextView.setInputType(this.passwordToggleEnabledValue ? this.passwordVisibleValue ? 145 : 129 : this.inputTypeValue);
        this.editTextView.setTypeface(typeface);
        if (selectionStart >= 0) {
            int length = this.editTextView.length();
            this.editTextView.setSelection(C5685n.n(selectionStart, 0, length), C5685n.n(selectionEnd, 0, length));
        }
    }

    private final void applyPasswordToggle() {
        this.passwordButtonView.setVisibility(this.passwordToggleEnabledValue ? 0 : 8);
        if (!this.passwordToggleEnabledValue && this.passwordVisibleValue) {
            this.passwordVisibleValue = false;
        }
        refreshPasswordButton();
        refreshCleanIconVisibility();
        if (this.passwordToggleEnabledValue) {
            C1299l c1299l = this.passwordButtonView;
            boolean z10 = this.passwordVisibleValue;
            warnIfUnlabeled(c1299l, z10 ? this.passwordVisibleContentDescriptionValue : this.passwordHiddenContentDescriptionValue, z10 ? "steposEditInputViewPasswordVisibleContentDescription" : "steposEditInputViewPasswordHiddenContentDescription");
        }
    }

    private final void applyTitle() {
        this.titleView.setText(this.titleValue);
        TextView textView = this.titleView;
        CharSequence charSequence = this.titleValue;
        textView.setVisibility((charSequence == null || charSequence.length() == 0) ? 8 : 0);
        TextView textView2 = this.titleView;
        Drawable drawable = this.titleIconValue;
        textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable != null ? drawable.mutate() : null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final C1299l createActionButton(Context context) throws Resources.NotFoundException {
        C1299l c1299l = new C1299l(context);
        int dimensionPixelSize = c1299l.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_editinput_action_icon_size);
        c1299l.setClickable(true);
        c1299l.setFocusable(true);
        c1299l.setScaleType(ImageView.ScaleType.FIT_CENTER);
        c1299l.setMinimumWidth(0);
        c1299l.setMinimumHeight(0);
        c1299l.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        c1299l.setPadding(0, 0, 0, 0);
        c1299l.setBackground(null);
        c1299l.setImageTintList(null);
        installActionRipple(c1299l);
        return c1299l;
    }

    private final Drawable defaultIcon(int drawableRes) {
        Drawable drawableE = androidx.core.content.a.e(getContext(), drawableRes);
        if (drawableE != null) {
            return drawableE.mutate();
        }
        return null;
    }

    private final int[] expandAxis(int currentStart, int currentEnd, int parentSize, int minTouch) {
        int iMin = Math.min(minTouch, parentSize);
        int i10 = currentEnd - currentStart;
        if (i10 >= iMin) {
            return new int[]{currentStart, currentEnd};
        }
        int i11 = iMin - i10;
        int i12 = i11 / 2;
        int iMax = currentStart - i12;
        int i13 = (currentEnd + i11) - i12;
        if (iMax < 0) {
            i13 -= iMax;
            iMax = 0;
        }
        if (i13 > parentSize) {
            iMax = Math.max(0, iMax - (i13 - parentSize));
        } else {
            parentSize = i13;
        }
        return new int[]{iMax, parentSize};
    }

    private final Rect expandedTouchBounds(View parent, View target, int minTouch) {
        Rect rect = new Rect();
        target.getHitRect(rect);
        int[] iArrExpandAxis = expandAxis(rect.left, rect.right, parent.getWidth(), minTouch);
        rect.left = iArrExpandAxis[0];
        rect.right = iArrExpandAxis[1];
        int[] iArrExpandAxis2 = expandAxis(rect.top, rect.bottom, parent.getHeight(), minTouch);
        rect.top = iArrExpandAxis2[0];
        rect.bottom = iArrExpandAxis2[1];
        return rect;
    }

    private final void installActionRipple(C1299l c1299l) {
        c1299l.setForeground(androidx.core.content.a.e(c1299l.getContext(), com.stepos.widget.R.drawable.stepos_ripple_editinput_action));
    }

    private final boolean isNightMode() {
        return (getResources().getConfiguration().uiMode & 48) == 32;
    }

    private final Integer readAppearance(TypedArray a10, int index) {
        Integer numValueOf = Integer.valueOf(a10.getResourceId(index, 0));
        if (numValueOf.intValue() != 0) {
            return numValueOf;
        }
        return null;
    }

    private final void refreshActionTouchDelegates() throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_editinput_action_size);
        ArrayList arrayList = new ArrayList(2);
        if (this.cleanButtonView.getVisibility() == 0) {
            arrayList.add(new TouchDelegate(expandedTouchBounds(this.rowView, this.cleanButtonView, dimensionPixelSize), this.cleanButtonView));
        }
        if (this.passwordButtonView.getVisibility() == 0) {
            arrayList.add(new TouchDelegate(expandedTouchBounds(this.rowView, this.passwordButtonView, dimensionPixelSize), this.passwordButtonView));
        }
        this.actionTouchDelegates.setDelegates(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void refreshCleanIconVisibility() {
        /*
            r5 = this;
            boolean r0 = r5.cleanIconEnabledValue
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
        L6:
            r0 = r2
            goto L18
        L8:
            boolean r0 = r5.autoCleanIconEnabledValue
            if (r0 == 0) goto L16
            android.widget.EditText r0 = r5.editTextView
            int r0 = r0.length()
            if (r0 <= 0) goto L6
            r0 = r1
            goto L18
        L16:
            boolean r0 = r5.cleanIconVisibleValue
        L18:
            r3 = 8
            if (r0 == 0) goto L1e
            r4 = r2
            goto L1f
        L1e:
            r4 = r3
        L1f:
            if (r0 == 0) goto L26
            boolean r0 = r5.passwordToggleEnabledValue
            if (r0 == 0) goto L26
            r3 = r2
        L26:
            androidx.appcompat.widget.l r0 = r5.cleanButtonView
            int r0 = r0.getVisibility()
            if (r0 != r4) goto L38
            android.view.View r0 = r5.dividerView
            int r0 = r0.getVisibility()
            if (r0 == r3) goto L37
            goto L38
        L37:
            r1 = r2
        L38:
            androidx.appcompat.widget.l r0 = r5.cleanButtonView
            r0.setVisibility(r4)
            android.view.View r0 = r5.dividerView
            r0.setVisibility(r3)
            if (r1 == 0) goto L49
            com.stepos.widget.editinput.EditInputGlassRow r5 = r5.rowView
            r5.requestLayout()
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.editinput.StepOSEditInputView.refreshCleanIconVisibility():void");
    }

    private final void refreshPasswordButton() {
        Drawable drawableDefaultIcon;
        boolean z10 = this.passwordVisibleValue;
        this.passwordButtonView.setSelected(z10);
        C1299l c1299l = this.passwordButtonView;
        if (z10) {
            drawableDefaultIcon = this.passwordVisibleIconValue;
            if (drawableDefaultIcon == null) {
                drawableDefaultIcon = defaultIcon(com.stepos.widget.R.drawable.stepos_icon_editinput_password_visible);
            }
        } else {
            drawableDefaultIcon = this.passwordHiddenIconValue;
            if (drawableDefaultIcon == null) {
                drawableDefaultIcon = defaultIcon(com.stepos.widget.R.drawable.stepos_icon_editinput_password_hidden);
            }
        }
        c1299l.setImageDrawable(drawableDefaultIcon);
        this.passwordButtonView.setContentDescription(z10 ? this.passwordVisibleContentDescriptionValue : this.passwordHiddenContentDescriptionValue);
        applyInputType();
    }

    private final void warnIfUnlabeled(View view, CharSequence description, String attrName) {
        if (view.getVisibility() == 0) {
            if (description == null || description.length() == 0) {
                Log.w(WIDGET_LOG_TAG, "图标操作项缺少无障碍描述，请配置 " + attrName + "（CLAUDE.md §4.10）");
            }
        }
    }

    public final void cleanContent() {
        this.editTextView.setText("");
        if (this.autoCleanIconEnabledValue) {
            return;
        }
        refreshCleanIconVisibility();
    }

    /* renamed from: getCleanIcon, reason: from getter */
    public final Drawable getCleanIconValue() {
        return this.cleanIconValue;
    }

    /* renamed from: getCleanIconContentDescription, reason: from getter */
    public final CharSequence getCleanIconContentDescriptionValue() {
        return this.cleanIconContentDescriptionValue;
    }

    /* renamed from: getEditText, reason: from getter */
    public final EditText getEditTextView() {
        return this.editTextView;
    }

    public final int getEditTextAppearance() {
        return this.editTextAppearance;
    }

    /* renamed from: getErrorText, reason: from getter */
    public final CharSequence getErrorTextValue() {
        return this.errorTextValue;
    }

    public final int getErrorTextAppearance() {
        return this.errorTextAppearance;
    }

    /* renamed from: getGlassEffect, reason: from getter */
    public final o getExplicitGlassEffectValue() {
        return this.explicitGlassEffectValue;
    }

    /* renamed from: getHint, reason: from getter */
    public final CharSequence getHintValue() {
        return this.hintValue;
    }

    /* renamed from: getImeOptions, reason: from getter */
    public final int getImeOptionsValue() {
        return this.imeOptionsValue;
    }

    /* renamed from: getInputType, reason: from getter */
    public final int getInputTypeValue() {
        return this.inputTypeValue;
    }

    public final OnCleanIconClickListener getOnCleanIconClickListener() {
        return this.onCleanIconClickListener;
    }

    public final OnPasswordToggleListener getOnPasswordToggleListener() {
        return this.onPasswordToggleListener;
    }

    /* renamed from: getPasswordHiddenContentDescription, reason: from getter */
    public final CharSequence getPasswordHiddenContentDescriptionValue() {
        return this.passwordHiddenContentDescriptionValue;
    }

    /* renamed from: getPasswordHiddenIcon, reason: from getter */
    public final Drawable getPasswordHiddenIconValue() {
        return this.passwordHiddenIconValue;
    }

    /* renamed from: getPasswordVisibleContentDescription, reason: from getter */
    public final CharSequence getPasswordVisibleContentDescriptionValue() {
        return this.passwordVisibleContentDescriptionValue;
    }

    /* renamed from: getPasswordVisibleIcon, reason: from getter */
    public final Drawable getPasswordVisibleIconValue() {
        return this.passwordVisibleIconValue;
    }

    public final CharSequence getText() {
        return this.editTextView.getText();
    }

    /* renamed from: getTextColorHint, reason: from getter */
    public final ColorStateList getTextColorHintValue() {
        return this.textColorHintValue;
    }

    /* renamed from: getTitle, reason: from getter */
    public final CharSequence getTitleValue() {
        return this.titleValue;
    }

    /* renamed from: getTitleIcon, reason: from getter */
    public final Drawable getTitleIconValue() {
        return this.titleIconValue;
    }

    public final int getTitleTextAppearance() {
        return this.titleTextAppearance;
    }

    /* renamed from: isAutoCleanIconEnabled, reason: from getter */
    public final boolean getAutoCleanIconEnabledValue() {
        return this.autoCleanIconEnabledValue;
    }

    /* renamed from: isCleanIconEnabled, reason: from getter */
    public final boolean getCleanIconEnabledValue() {
        return this.cleanIconEnabledValue;
    }

    public final boolean isCleanIconVisible() {
        if (this.cleanIconEnabledValue) {
            return this.autoCleanIconEnabledValue ? this.editTextView.length() > 0 : this.cleanIconVisibleValue;
        }
        return false;
    }

    public final boolean isErrorShown() {
        CharSequence charSequence = this.errorTextValue;
        return !(charSequence == null || charSequence.length() == 0);
    }

    public final boolean isGlassEnabled() {
        return this.rowView.getIsGlassEnabled();
    }

    /* renamed from: isPasswordToggleEnabled, reason: from getter */
    public final boolean getPasswordToggleEnabledValue() {
        return this.passwordToggleEnabledValue;
    }

    /* renamed from: isPasswordVisible, reason: from getter */
    public final boolean getPasswordVisibleValue() {
        return this.passwordVisibleValue;
    }

    /* renamed from: isPressScaleEnabled, reason: from getter */
    public final boolean getPressScaleEnabledValue() {
        return this.pressScaleEnabledValue;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        installActionRipple(this.cleanButtonView);
        installActionRipple(this.passwordButtonView);
        HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(this, this.pressScaleEnabledValue);
        applyGlassPreset$default(this, false, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.onCleanIconClickListener = null;
        this.onPasswordToggleListener = null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) throws Resources.NotFoundException {
        super.onLayout(changed, left, top, right, bottom);
        refreshActionTouchDelegates();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.passwordToggleEnabledValue = savedState.getPasswordToggleEnabled();
        this.passwordVisibleValue = savedState.getPasswordVisible() && savedState.getPasswordToggleEnabled();
        this.autoCleanIconEnabledValue = savedState.getAutoCleanIconEnabled();
        this.cleanIconVisibleValue = savedState.getCleanIconVisible();
        this.errorTextValue = savedState.getError();
        applyPasswordToggle();
        refreshCleanIconVisibility();
        applyErrorState();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = AbsSavedState.EMPTY_STATE;
        }
        p.f(parcelableOnSaveInstanceState);
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setPasswordVisible$StepOSWidget_release(this.passwordVisibleValue);
        savedState.setPasswordToggleEnabled$StepOSWidget_release(this.passwordToggleEnabledValue);
        savedState.setAutoCleanIconEnabled$StepOSWidget_release(this.autoCleanIconEnabledValue);
        savedState.setCleanIconVisible$StepOSWidget_release(this.cleanIconVisibleValue);
        CharSequence charSequence = this.errorTextValue;
        savedState.setError$StepOSWidget_release(charSequence != null ? charSequence.toString() : null);
        return savedState;
    }

    public final void setAutoCleanIconEnabled(boolean z10) {
        if (this.autoCleanIconEnabledValue == z10) {
            return;
        }
        this.autoCleanIconEnabledValue = z10;
        refreshCleanIconVisibility();
    }

    public final void setCleanIcon(Drawable drawable) {
        if (this.cleanIconValue == drawable) {
            return;
        }
        this.cleanIconValue = drawable;
        C1299l c1299l = this.cleanButtonView;
        if (drawable == null) {
            drawable = defaultIcon(com.stepos.widget.R.drawable.stepos_icon_editinput_clean);
        }
        c1299l.setImageDrawable(drawable);
    }

    public final void setCleanIconContentDescription(CharSequence charSequence) {
        if (p.d(this.cleanIconContentDescriptionValue, charSequence)) {
            return;
        }
        this.cleanIconContentDescriptionValue = charSequence;
        this.cleanButtonView.setContentDescription(charSequence);
    }

    public final void setCleanIconEnabled(boolean z10) {
        if (this.cleanIconEnabledValue == z10) {
            return;
        }
        this.cleanIconEnabledValue = z10;
        refreshCleanIconVisibility();
    }

    public final void setCleanIconResource(int resId) {
        setCleanIcon(androidx.core.content.a.e(getContext(), resId));
    }

    public final void setCleanIconVisible(boolean z10) {
        this.cleanIconVisibleValue = z10;
        if (this.autoCleanIconEnabledValue) {
            return;
        }
        refreshCleanIconVisibility();
    }

    public final void setEditTextAppearance(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("editTextAppearance must be a style resource id but was " + i10).toString());
        }
        if (this.editTextAppearance == i10) {
            return;
        }
        this.editTextAppearance = i10;
        this.editTextView.setTextAppearance(getContext(), i10);
    }

    public final void setErrorText(CharSequence charSequence) {
        if (p.d(this.errorTextValue, charSequence)) {
            return;
        }
        this.errorTextValue = charSequence;
        applyErrorState();
    }

    public final void setErrorTextAppearance(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("errorTextAppearance must be a style resource id but was " + i10).toString());
        }
        if (this.errorTextAppearance == i10) {
            return;
        }
        this.errorTextAppearance = i10;
        this.errorView.setTextAppearance(getContext(), i10);
    }

    public final void setGlassEffect(o oVar) {
        if (p.d(this.explicitGlassEffectValue, oVar)) {
            return;
        }
        this.explicitGlassEffectValue = oVar;
        applyGlassPreset$default(this, false, 1, null);
    }

    public final void setGlassEnabled(boolean z10) {
        this.rowView.setGlassEnabled(z10);
        applyErrorOverlay();
    }

    public final void setHint(CharSequence charSequence) {
        if (p.d(this.hintValue, charSequence)) {
            return;
        }
        this.hintValue = charSequence;
        this.editTextView.setHint(charSequence);
    }

    public final void setImeOptions(int i10) {
        if (this.imeOptionsValue == i10) {
            return;
        }
        this.imeOptionsValue = i10;
        this.editTextView.setImeOptions(i10);
    }

    public final void setInputType(int i10) {
        if (this.inputTypeValue == i10) {
            return;
        }
        this.inputTypeValue = i10;
        applyInputType();
    }

    public final void setOnCleanIconClickListener(OnCleanIconClickListener onCleanIconClickListener) {
        this.onCleanIconClickListener = onCleanIconClickListener;
    }

    public final void setOnPasswordToggleListener(OnPasswordToggleListener onPasswordToggleListener) {
        this.onPasswordToggleListener = onPasswordToggleListener;
    }

    public final void setPasswordHiddenContentDescription(CharSequence charSequence) {
        if (p.d(this.passwordHiddenContentDescriptionValue, charSequence)) {
            return;
        }
        this.passwordHiddenContentDescriptionValue = charSequence;
        refreshPasswordButton();
    }

    public final void setPasswordHiddenIcon(Drawable drawable) {
        if (this.passwordHiddenIconValue == drawable) {
            return;
        }
        this.passwordHiddenIconValue = drawable;
        refreshPasswordButton();
    }

    public final void setPasswordHiddenIconResource(int resId) {
        setPasswordHiddenIcon(androidx.core.content.a.e(getContext(), resId));
    }

    public final void setPasswordToggleEnabled(boolean z10) {
        if (this.passwordToggleEnabledValue == z10) {
            return;
        }
        this.passwordToggleEnabledValue = z10;
        applyPasswordToggle();
    }

    public final void setPasswordVisible(boolean z10) {
        if (this.passwordVisibleValue == z10) {
            return;
        }
        if (!this.passwordToggleEnabledValue) {
            throw new IllegalStateException("isPasswordVisible 需要先打开 isPasswordToggleEnabled");
        }
        this.passwordVisibleValue = z10;
        refreshPasswordButton();
    }

    public final void setPasswordVisibleContentDescription(CharSequence charSequence) {
        if (p.d(this.passwordVisibleContentDescriptionValue, charSequence)) {
            return;
        }
        this.passwordVisibleContentDescriptionValue = charSequence;
        refreshPasswordButton();
    }

    public final void setPasswordVisibleIcon(Drawable drawable) {
        if (this.passwordVisibleIconValue == drawable) {
            return;
        }
        this.passwordVisibleIconValue = drawable;
        refreshPasswordButton();
    }

    public final void setPasswordVisibleIconResource(int resId) {
        setPasswordVisibleIcon(androidx.core.content.a.e(getContext(), resId));
    }

    public final void setPressScaleEnabled(boolean z10) {
        if (this.pressScaleEnabledValue == z10) {
            return;
        }
        this.pressScaleEnabledValue = z10;
        HotspotRipple.INSTANCE.setPressScaleEnabled$StepOSWidget_release(this, z10);
    }

    public final void setText(CharSequence charSequence) {
        EditText editText = this.editTextView;
        if (charSequence == null) {
            charSequence = "";
        }
        editText.setText(charSequence);
        refreshCleanIconVisibility();
    }

    public final void setTextColorHint(ColorStateList colorStateList) {
        if (p.d(this.textColorHintValue, colorStateList)) {
            return;
        }
        this.textColorHintValue = colorStateList;
        if (colorStateList != null) {
            this.editTextView.setHintTextColor(colorStateList);
        } else {
            this.editTextView.setHintTextColor(androidx.core.content.a.c(getContext(), com.stepos.widget.R.color.stepos_editinput_hint));
        }
    }

    public final void setTitle(CharSequence charSequence) {
        if (p.d(this.titleValue, charSequence)) {
            return;
        }
        this.titleValue = charSequence;
        applyTitle();
    }

    public final void setTitleIcon(Drawable drawable) {
        if (this.titleIconValue == drawable) {
            return;
        }
        this.titleIconValue = drawable;
        applyTitle();
    }

    public final void setTitleTextAppearance(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("titleTextAppearance must be a style resource id but was " + i10).toString());
        }
        if (this.titleTextAppearance == i10) {
            return;
        }
        this.titleTextAppearance = i10;
        this.titleView.setTextAppearance(getContext(), i10);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R$\u0010\"\u001a\u0004\u0018\u00010!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/stepos/widget/editinput/StepOSEditInputView$SavedState;", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "source", "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "passwordVisible", "Z", "getPasswordVisible$StepOSWidget_release", "()Z", "setPasswordVisible$StepOSWidget_release", "(Z)V", "passwordToggleEnabled", "getPasswordToggleEnabled$StepOSWidget_release", "setPasswordToggleEnabled$StepOSWidget_release", "autoCleanIconEnabled", "getAutoCleanIconEnabled$StepOSWidget_release", "setAutoCleanIconEnabled$StepOSWidget_release", "cleanIconVisible", "getCleanIconVisible$StepOSWidget_release", "setCleanIconVisible$StepOSWidget_release", "", "error", "Ljava/lang/String;", "getError$StepOSWidget_release", "()Ljava/lang/String;", "setError$StepOSWidget_release", "(Ljava/lang/String;)V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private boolean autoCleanIconEnabled;
        private boolean cleanIconVisible;
        private String error;
        private boolean passwordToggleEnabled;
        private boolean passwordVisible;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.stepos.widget.editinput.StepOSEditInputView$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public StepOSEditInputView.SavedState[] newArray(int size) {
                return new StepOSEditInputView.SavedState[size];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public StepOSEditInputView.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                p.i(source, "source");
                return new StepOSEditInputView.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public StepOSEditInputView.SavedState createFromParcel(Parcel source) {
                p.i(source, "source");
                return new StepOSEditInputView.SavedState(source, null);
            }
        };

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            p.i(superState, "superState");
            this.autoCleanIconEnabled = true;
        }

        /* renamed from: getAutoCleanIconEnabled$StepOSWidget_release, reason: from getter */
        public final boolean getAutoCleanIconEnabled() {
            return this.autoCleanIconEnabled;
        }

        /* renamed from: getCleanIconVisible$StepOSWidget_release, reason: from getter */
        public final boolean getCleanIconVisible() {
            return this.cleanIconVisible;
        }

        /* renamed from: getError$StepOSWidget_release, reason: from getter */
        public final String getError() {
            return this.error;
        }

        /* renamed from: getPasswordToggleEnabled$StepOSWidget_release, reason: from getter */
        public final boolean getPasswordToggleEnabled() {
            return this.passwordToggleEnabled;
        }

        /* renamed from: getPasswordVisible$StepOSWidget_release, reason: from getter */
        public final boolean getPasswordVisible() {
            return this.passwordVisible;
        }

        public final void setAutoCleanIconEnabled$StepOSWidget_release(boolean z10) {
            this.autoCleanIconEnabled = z10;
        }

        public final void setCleanIconVisible$StepOSWidget_release(boolean z10) {
            this.cleanIconVisible = z10;
        }

        public final void setError$StepOSWidget_release(String str) {
            this.error = str;
        }

        public final void setPasswordToggleEnabled$StepOSWidget_release(boolean z10) {
            this.passwordToggleEnabled = z10;
        }

        public final void setPasswordVisible$StepOSWidget_release(boolean z10) {
            this.passwordVisible = z10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            p.i(out, "out");
            super.writeToParcel(out, flags);
            out.writeInt(this.passwordVisible ? 1 : 0);
            out.writeInt(this.passwordToggleEnabled ? 1 : 0);
            out.writeInt(this.autoCleanIconEnabled ? 1 : 0);
            out.writeInt(this.cleanIconVisible ? 1 : 0);
            out.writeString(this.error);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            p.i(source, "source");
            this.autoCleanIconEnabled = true;
            this.passwordVisible = source.readInt() != 0;
            this.passwordToggleEnabled = source.readInt() != 0;
            this.autoCleanIconEnabled = source.readInt() != 0;
            this.cleanIconVisible = source.readInt() != 0;
            this.error = source.readString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSEditInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSEditInputView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSEditInputView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? com.stepos.widget.R.attr.steposEditInputViewStyle : i10, (i12 & 8) != 0 ? com.stepos.widget.R.style.StepOSWidget_EditInputView : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSEditInputView(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        this.attrsValue = attributeSet;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.container = linearLayout;
        EditInputGlassRow editInputGlassRow = new EditInputGlassRow(context);
        editInputGlassRow.setOrientation(0);
        editInputGlassRow.setGravity(16);
        editInputGlassRow.setLayoutParams(new LinearLayout.LayoutParams(-1, editInputGlassRow.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_editinput_row_height)));
        Resources resources = editInputGlassRow.getResources();
        int i12 = com.stepos.widget.R.dimen.stepos_editinput_row_padding_horizontal;
        editInputGlassRow.setPaddingRelative(resources.getDimensionPixelSize(i12), 0, editInputGlassRow.getResources().getDimensionPixelSize(i12), 0);
        editInputGlassRow.setClipToPadding(false);
        editInputGlassRow.setClipChildren(false);
        this.rowView = editInputGlassRow;
        TextView textView = new TextView(context);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginEnd(textView.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_editinput_title_spacing));
        textView.setLayoutParams(layoutParams);
        this.titleView = textView;
        EditText editText = new EditText(context);
        editText.setId(com.stepos.widget.R.id.stepos_editinput_content);
        editText.setGravity(16);
        editText.setBackground(null);
        editText.setMinHeight(0);
        editText.setMinimumHeight(0);
        editText.setPadding(0, 0, 0, 0);
        editText.setTextCursorDrawable(com.stepos.widget.R.drawable.stepos_bg_text_cursor);
        editText.setInputType(1);
        editText.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.editTextView = editText;
        View view = new View(context);
        view.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(view.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_editinput_divider_width), view.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_editinput_divider_height));
        Resources resources2 = view.getResources();
        int i13 = com.stepos.widget.R.dimen.stepos_editinput_divider_margin_horizontal;
        layoutParams2.setMarginStart(resources2.getDimensionPixelSize(i13));
        layoutParams2.setMarginEnd(view.getResources().getDimensionPixelSize(i13));
        view.setLayoutParams(layoutParams2);
        view.setBackgroundColor(androidx.core.content.a.c(context, com.stepos.widget.R.color.stepos_editinput_divider));
        this.dividerView = view;
        TextView textView2 = new TextView(context);
        textView2.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = textView2.getResources().getDimensionPixelSize(com.stepos.widget.R.dimen.stepos_editinput_error_margin_top);
        textView2.setLayoutParams(layoutParams3);
        this.errorView = textView2;
        ActionTouchDelegate actionTouchDelegate = new ActionTouchDelegate(editInputGlassRow);
        this.actionTouchDelegates = actionTouchDelegate;
        C1299l c1299lCreateActionButton = createActionButton(context);
        this.cleanButtonView = c1299lCreateActionButton;
        C1299l c1299lCreateActionButton2 = createActionButton(context);
        c1299lCreateActionButton2.setVisibility(8);
        this.passwordButtonView = c1299lCreateActionButton2;
        this.inputTypeValue = 1;
        this.autoCleanIconEnabledValue = true;
        this.pressScaleEnabledValue = true;
        this.fieldBackgroundFallback = androidx.core.content.a.e(context, com.stepos.widget.R.drawable.stepos_bg_editinput_field);
        this.errorRingDrawable = androidx.core.content.a.e(context, com.stepos.widget.R.drawable.stepos_bg_editinput_error_ring);
        editInputGlassRow.addView(textView);
        editInputGlassRow.addView(editText);
        editInputGlassRow.addView(c1299lCreateActionButton);
        editInputGlassRow.addView(view);
        editInputGlassRow.addView(c1299lCreateActionButton2);
        linearLayout.addView(editInputGlassRow);
        linearLayout.addView(textView2);
        addView(linearLayout);
        editInputGlassRow.setTouchDelegate(actionTouchDelegate);
        adoptHostBackground();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.stepos.widget.R.styleable.StepOSEditInputView, i10, i11);
        p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.titleValue = typedArrayObtainStyledAttributes.getText(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewTitle);
        this.titleIconValue = typedArrayObtainStyledAttributes.getDrawable(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewTitleIcon);
        Integer appearance = readAppearance(typedArrayObtainStyledAttributes, com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewTitleTextAppearance);
        if (appearance != null) {
            setTitleTextAppearance(appearance.intValue());
        }
        Integer appearance2 = readAppearance(typedArrayObtainStyledAttributes, com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewEditTextAppearance);
        if (appearance2 != null) {
            setEditTextAppearance(appearance2.intValue());
        }
        Integer appearance3 = readAppearance(typedArrayObtainStyledAttributes, com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewErrorTextAppearance);
        if (appearance3 != null) {
            setErrorTextAppearance(appearance3.intValue());
        }
        this.cleanIconEnabledValue = typedArrayObtainStyledAttributes.getBoolean(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewShowCleanIcon, false);
        this.cleanIconValue = typedArrayObtainStyledAttributes.getDrawable(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewCleanIcon);
        this.cleanIconContentDescriptionValue = typedArrayObtainStyledAttributes.getText(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewCleanIconContentDescription);
        this.passwordToggleEnabledValue = typedArrayObtainStyledAttributes.getBoolean(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewPasswordSwitch, false);
        this.passwordHiddenIconValue = typedArrayObtainStyledAttributes.getDrawable(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewPasswordHiddenIcon);
        this.passwordVisibleIconValue = typedArrayObtainStyledAttributes.getDrawable(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewPasswordVisibleIcon);
        this.passwordHiddenContentDescriptionValue = typedArrayObtainStyledAttributes.getText(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewPasswordHiddenContentDescription);
        this.passwordVisibleContentDescriptionValue = typedArrayObtainStyledAttributes.getText(com.stepos.widget.R.styleable.StepOSEditInputView_steposEditInputViewPasswordVisibleContentDescription);
        this.pressScaleEnabledValue = typedArrayObtainStyledAttributes.getBoolean(com.stepos.widget.R.styleable.StepOSEditInputView_steposPressScaleEnabled, true);
        editInputGlassRow.setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(com.stepos.widget.R.styleable.StepOSEditInputView_steposGlassEnabled, true));
        this.explicitGlassEffectValue = GlassEffectResolver.INSTANCE.read$StepOSWidget_release(typedArrayObtainStyledAttributes, com.stepos.widget.R.styleable.StepOSEditInputView_steposGlassEffect);
        this.hintValue = typedArrayObtainStyledAttributes.getText(com.stepos.widget.R.styleable.StepOSEditInputView_android_hint);
        String string = typedArrayObtainStyledAttributes.getString(com.stepos.widget.R.styleable.StepOSEditInputView_android_text);
        if (string != null) {
            editText.setText(string);
        }
        this.textColorHintValue = typedArrayObtainStyledAttributes.getColorStateList(com.stepos.widget.R.styleable.StepOSEditInputView_android_textColorHint);
        this.inputTypeValue = typedArrayObtainStyledAttributes.getInt(com.stepos.widget.R.styleable.StepOSEditInputView_android_inputType, 1);
        this.imeOptionsValue = typedArrayObtainStyledAttributes.getInt(com.stepos.widget.R.styleable.StepOSEditInputView_android_imeOptions, 0);
        t tVar = t.f7040a;
        typedArrayObtainStyledAttributes.recycle();
        applyDefaultAppearances();
        applyEditTextConfig();
        applyTitle();
        applyCleanIcon();
        applyPasswordToggle();
        applyErrorState();
        applyGlassPreset(true);
        HotspotRipple hotspotRipple = HotspotRipple.INSTANCE;
        hotspotRipple.applyPressScale$StepOSWidget_release(c1299lCreateActionButton);
        hotspotRipple.applyPressScale$StepOSWidget_release(c1299lCreateActionButton2);
        hotspotRipple.setPressScaleEnabled$StepOSWidget_release(this, this.pressScaleEnabledValue);
        c1299lCreateActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.editinput.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StepOSEditInputView._init_$lambda$18(this.f31193a, view2);
            }
        });
        c1299lCreateActionButton2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.editinput.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StepOSEditInputView._init_$lambda$19(this.f31194a, view2);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.stepos.widget.editinput.StepOSEditInputView.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s10) {
                StepOSEditInputView.this.refreshCleanIconVisibility();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s10, int start, int before, int count) {
            }
        });
    }

    public final void setTextColorHint(int color) {
        setTextColorHint(ColorStateList.valueOf(color));
    }
}
