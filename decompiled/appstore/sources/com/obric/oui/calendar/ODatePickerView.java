package com.obric.oui.calendar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.pickers.OReelPickerBuilder;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 $2\u00020\u0001:\u0006\u009e\u0001ô\u0001õ\u0001B;\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u0010J\u001f\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010$\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010\u0010J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u0019J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0019J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010*J\u001f\u00102\u001a\u0002002\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u0013\u00104\u001a\u00020.*\u00020\u0012H\u0002¢\u0006\u0004\b4\u00105J\r\u00107\u001a\u000206¢\u0006\u0004\b7\u00108J\u0015\u0010;\u001a\u00020\u000e2\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020.¢\u0006\u0004\b=\u0010>J\u0015\u0010@\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020.¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u0006¢\u0006\u0004\bC\u0010\u0019J\r\u0010D\u001a\u00020\u0006¢\u0006\u0004\bD\u0010*J\u0017\u0010F\u001a\u00020\u000e2\b\b\u0001\u0010E\u001a\u00020\u0006¢\u0006\u0004\bF\u0010\u0019J\u000f\u0010G\u001a\u00020\u0006H\u0007¢\u0006\u0004\bG\u0010*J\u0017\u0010I\u001a\u00020\u000e2\b\b\u0001\u0010H\u001a\u00020\u0006¢\u0006\u0004\bI\u0010\u0019J\u0017\u0010J\u001a\u00020\u000e2\b\b\u0001\u0010H\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010\u0019J\u0017\u0010M\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bO\u0010NJ\u0017\u0010Q\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010P¢\u0006\u0004\bQ\u0010RJ\u001b\u0010V\u001a\u00020\u000e2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S¢\u0006\u0004\bV\u0010WJ\u0017\u0010V\u001a\u00020\u000e2\b\b\u0001\u0010X\u001a\u00020\u0006¢\u0006\u0004\bV\u0010\u0019J\u0015\u0010Z\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\n¢\u0006\u0004\bZ\u0010[J\r\u0010]\u001a\u00020\\¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u000e2\b\u0010_\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b`\u0010\u0015J\u000f\u0010a\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u000e2\b\u0010c\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bd\u0010\u0015J\u000f\u0010e\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\be\u0010bJ\u0015\u0010g\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020\u0006¢\u0006\u0004\bg\u0010\u0019J\r\u0010h\u001a\u00020\u0006¢\u0006\u0004\bh\u0010*J\u0015\u0010j\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\n¢\u0006\u0004\bj\u0010[J\u0015\u0010k\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\n¢\u0006\u0004\bk\u0010[J\u0015\u0010l\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\n¢\u0006\u0004\bl\u0010[J\u0015\u0010n\u001a\u00020\u000e2\u0006\u0010m\u001a\u00020\u0006¢\u0006\u0004\bn\u0010\u0019J\u0015\u0010p\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020\u0006¢\u0006\u0004\bp\u0010\u0019J\u0015\u0010r\u001a\u00020\u000e2\u0006\u0010q\u001a\u00020\u0006¢\u0006\u0004\br\u0010\u0019J\u0015\u0010t\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020\u0006¢\u0006\u0004\bt\u0010\u0019J\r\u0010u\u001a\u00020\u0006¢\u0006\u0004\bu\u0010*J\u0015\u0010w\u001a\u00020\u000e2\u0006\u0010v\u001a\u00020\u0006¢\u0006\u0004\bw\u0010\u0019J\u0015\u0010y\u001a\u00020\u000e2\u0006\u0010x\u001a\u00020\u0006¢\u0006\u0004\by\u0010\u0019J\r\u0010z\u001a\u00020\u0006¢\u0006\u0004\bz\u0010*J\u0015\u0010|\u001a\u00020\u000e2\u0006\u0010{\u001a\u00020\u0006¢\u0006\u0004\b|\u0010\u0019J\r\u0010}\u001a\u00020\u0006¢\u0006\u0004\b}\u0010*J\u0015\u0010~\u001a\u00020\u000e2\u0006\u0010{\u001a\u00020\u0006¢\u0006\u0004\b~\u0010\u0019J\r\u0010\u007f\u001a\u00020\u0006¢\u0006\u0004\b\u007f\u0010*J\u0017\u0010\u0080\u0001\u001a\u00020\u000e2\u0006\u0010v\u001a\u00020\u0006¢\u0006\u0005\b\u0080\u0001\u0010\u0019J\u0017\u0010\u0081\u0001\u001a\u00020\u000e2\u0006\u0010x\u001a\u00020\u0006¢\u0006\u0005\b\u0081\u0001\u0010\u0019J\u000f\u0010\u0082\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0082\u0001\u0010*J\u000f\u0010\u0083\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u0083\u0001\u0010bJ\u0019\u0010\u0084\u0001\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0005\b\u0084\u0001\u0010\u0015J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0005\b\u0085\u0001\u0010bJ\u0017\u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0086\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001c\u0010\u008b\u0001\u001a\u00020\u000e2\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0007¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J$\u0010\u008f\u0001\u001a\u00020\u000e2\u0007\u0010\u008d\u0001\u001a\u00020\u00062\u0007\u0010\u008e\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J?\u0010\u0096\u0001\u001a\u00020\u000e2\u0007\u0010\u0091\u0001\u001a\u00020\n2\u0007\u0010\u0092\u0001\u001a\u00020\u00062\u0007\u0010\u0093\u0001\u001a\u00020\u00062\u0007\u0010\u0094\u0001\u001a\u00020\u00062\u0007\u0010\u0095\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0098\u0001\u0010\u0010J\u0011\u0010\u0099\u0001\u001a\u00020\u000eH\u0014¢\u0006\u0005\b\u0099\u0001\u0010\u0010J\u001e\u0010\u009c\u0001\u001a\u00020\u000e2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0014¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0018\u0010£\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010\u0014R\u0018\u0010¥\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010\u0014R\u0018\u0010§\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010\u0014R\u0017\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¨\u0001\u0010\u0014R\u0017\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b©\u0001\u0010\u0014R\u0018\u0010«\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bª\u0001\u00104R\u0019\u0010®\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001a\u0010²\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001a\u0010´\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010±\u0001R\u001a\u0010¸\u0001\u001a\u00030µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010»\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010½\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010±\u0001R\u001a\u0010Á\u0001\u001a\u00030¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001b\u0010Ã\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010º\u0001R\u001b\u0010Æ\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010Å\u0001R\u0018\u0010Ç\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b2\u0010¡\u0001R\u001b\u0010È\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010Å\u0001R\u001c\u0010Ê\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Å\u0001R\u001c\u0010Î\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Í\u0001R\u0019\u0010Ò\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010¡\u0001R\u0019\u0010Ô\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010¡\u0001R\u0019\u0010×\u0001\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001b\u0010Ú\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000f\u0010Ù\u0001R\u0018\u0010Ü\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0016\u0010Û\u0001RJ\u0010ç\u0001\u001a#\u0012\u0016\u0012\u00140.¢\u0006\u000f\bÞ\u0001\u0012\n\bß\u0001\u0012\u0005\b\b(à\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010Ý\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001\"\u0006\bå\u0001\u0010æ\u0001RJ\u0010ë\u0001\u001a#\u0012\u0016\u0012\u00140.¢\u0006\u000f\bÞ\u0001\u0012\n\bß\u0001\u0012\u0005\b\b(à\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010Ý\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bè\u0001\u0010â\u0001\u001a\u0006\bé\u0001\u0010ä\u0001\"\u0006\bê\u0001\u0010æ\u0001RJ\u0010ï\u0001\u001a#\u0012\u0016\u0012\u00140.¢\u0006\u000f\bÞ\u0001\u0012\n\bß\u0001\u0012\u0005\b\b(à\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010Ý\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bì\u0001\u0010â\u0001\u001a\u0006\bí\u0001\u0010ä\u0001\"\u0006\bî\u0001\u0010æ\u0001RP\u0010ó\u0001\u001a*\u0012\u001d\u0012\u001b\u0012\u0004\u0012\u00020.0\u0086\u0001¢\u0006\u000f\bÞ\u0001\u0012\n\bß\u0001\u0012\u0005\b\b(ð\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010Ý\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b&\u0010â\u0001\u001a\u0006\bñ\u0001\u0010ä\u0001\"\u0006\bò\u0001\u0010æ\u0001¨\u0006ö\u0001"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "datePickerMode", "", "selectDateOnMonthChange", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/calendar/ODatePickerView$DatePickerMode;Z)V", "", "z", "()V", "s", "Lcom/obric/oui/calendar/CalendarDay;", "date", "I", "(Lcom/obric/oui/calendar/CalendarDay;)V", "A", "yearReal", "H", "(I)V", "q", "", "from", "to", "G", "(FF)V", "hideStart", "Landroid/view/View;", "toHide", "toShow", "F", "(FLandroid/view/View;Landroid/view/View;)V", "E", "second", "setSecond", "getSecond", "()I", "millisecond", "setMillisecond", "getMillisecond", "", "timestamp", "", "format", "r", "(JLjava/lang/String;)Ljava/lang/String;", "J", "(Lcom/obric/oui/calendar/CalendarDay;)J", "Lcom/obric/oui/calendar/MaterialCalendarView;", "getCalendarView", "()Lcom/obric/oui/calendar/MaterialCalendarView;", "Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "visibility", "setOutOfMonthVisibility", "(Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;)V", "getSelectTimestamp", "()J", "selectedTime", "setCurrentTimeMillis", "(J)V", "mode", "setSelectionMode", "getSelectionMode", "color", "setSelectionColor", "getSelectionColor", "resourceId", "setDateTextAppearance", "setWeekDayTextAppearance", "Lcom/obric/oui/calendar/format/DayFormatter;", "formatter", "setDayFormatter", "(Lcom/obric/oui/calendar/format/DayFormatter;)V", "setDayFormatterContentDescription", "Lcom/obric/oui/calendar/format/WeekDayFormatter;", "setWeekDayFormatter", "(Lcom/obric/oui/calendar/format/WeekDayFormatter;)V", "", "", "weekDayLabels", "setWeekDayLabels", "([Ljava/lang/CharSequence;)V", "arrayRes", "showWeekDays", "setShowWeekDays", "(Z)V", "Lcom/obric/oui/calendar/CalendarMode;", "getCalendarMode", "()Lcom/obric/oui/calendar/CalendarMode;", "minDate", "setMinimumDate", "getMinimumDate", "()Lcom/obric/oui/calendar/CalendarDay;", "maxDate", "setMaximumDate", "getMaximumDate", "showOtherDates", "setShowOtherDates", "getShowOtherDates", "enabled", "setAllowClickDaysOutsideCurrentMonth", "setPagingEnabled", "setDynamicHeightEnabled", "sizePx", "setTileSize", "sizeDp", "setTileSizeDp", "widthPx", "setTileWidth", "widthDp", "setTileWidthDp", "getTileWidth", "heightPx", "setTileHeight", "heightDp", "setTileHeightDp", "getTileHeight", "spacingPx", "setTileHSpacing", "getTileHSpacing", "setTileVSpacing", "getTileVSpacing", "setWeekDaysHeight", "setWeekDaysHeightDp", "getWeekDaysHeight", "getCurrentDate", "setSelectedDate", "getSelectedDate", "", "getSelectedDates", "()Ljava/util/List;", "Ljava/time/DayOfWeek;", "firstDayOfWeek", "setFirstDayOfWeek", "(Ljava/time/DayOfWeek;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "a", "Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "b", "Z", "c", "currentDayOfMonth", "d", "currentYear", "e", "currentMonth", "f", "g", "h", "mSelectTime", "i", "Lcom/obric/oui/calendar/MaterialCalendarView;", "calendarView", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "previousBtn", "k", "nextBtn", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "currentDateTextView", "m", "Landroid/view/View;", "llOpenYearMonth", "n", "ivOpenYearMonth", "Landroid/widget/FrameLayout;", "o", "Landroid/widget/FrameLayout;", "flCalendarContainer", "p", "pickerView", "Ljb/d;", "Ljb/d;", "arrowAnimator", "isYearMonthOpen", "fadeOutAnimator", "t", "fadeInAnimator", "Landroid/animation/ObjectAnimator;", "u", "Landroid/animation/ObjectAnimator;", "alphaOutAnimator", "v", "alphaInAnimator", "w", "isSyncingFromCalendar", FixCard.FixStyle.KEY_X, "isSyncingFromPicker", FixCard.FixStyle.KEY_Y, "Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "outOfMonthVisibility", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "syncCalendarRunnable", "Ljava/lang/String;", "dateFormat", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "time", "B", "Lkotlin/jvm/functions/Function1;", "getOnMonthChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnMonthChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onMonthChangedListener", "C", "getOnDateChangedListener", "setOnDateChangedListener", "onDateChangedListener", "D", "getOnDateLongClickListener", "setOnDateLongClickListener", "onDateLongClickListener", "times", "getOnRangeSelectedListener", "setOnRangeSelectedListener", "onRangeSelectedListener", "DatePickerMode", "OutOfMonthVisibility", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODatePickerView extends ConstraintLayout {
    public static final a F = null;
    public String A;
    public Function1 B;
    public Function1 C;
    public Function1 D;
    public Function1 E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DatePickerMode f12592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MaterialCalendarView f12600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f12601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f12602k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f12603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f12604m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView f12605n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f12606o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f12607p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public jb.d f12608q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12609r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public jb.d f12610s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public jb.d f12611t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ObjectAnimator f12612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ObjectAnimator f12613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12614w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12615x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OutOfMonthVisibility f12616y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Runnable f12617z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "", "(Ljava/lang/String;I)V", "BOARD_SHEET", "NARROW_SHEET", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DatePickerMode extends Enum<DatePickerMode> {
        private static final /* synthetic */ DatePickerMode[] $VALUES = null;
        public static final DatePickerMode BOARD_SHEET = null;

        @Deprecated(message = "this mode is deprecated, please use BOARD_SHEET")
        public static final DatePickerMode NARROW_SHEET = null;

        private static final /* synthetic */ DatePickerMode[] $values() {
            return new DatePickerMode[]{BOARD_SHEET, NARROW_SHEET};
        }

        static {
            BOARD_SHEET = new DatePickerMode("BOARD_SHEET", 0);
            NARROW_SHEET = new DatePickerMode("NARROW_SHEET", 1);
            $VALUES = $values();
        }

        private DatePickerMode(String r10, int r11) {
            super(r10, r11);
        }

        public static DatePickerMode valueOf(String r10) {
            return (DatePickerMode) Enum.valueOf(DatePickerMode.class, r10);
        }

        public static DatePickerMode[] values() {
            return (DatePickerMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "", "(Ljava/lang/String;I)V", "GREY", "HIDE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum OutOfMonthVisibility extends Enum<OutOfMonthVisibility> {
        private static final /* synthetic */ OutOfMonthVisibility[] $VALUES = null;
        public static final OutOfMonthVisibility GREY = null;
        public static final OutOfMonthVisibility HIDE = null;

        private static final /* synthetic */ OutOfMonthVisibility[] $values() {
            return new OutOfMonthVisibility[]{GREY, HIDE};
        }

        static {
            GREY = new OutOfMonthVisibility("GREY", 0);
            HIDE = new OutOfMonthVisibility("HIDE", 1);
            $VALUES = $values();
        }

        private OutOfMonthVisibility(String r10, int r11) {
            super(r10, r11);
        }

        public static OutOfMonthVisibility valueOf(String r10) {
            return (OutOfMonthVisibility) Enum.valueOf(OutOfMonthVisibility.class, r10);
        }

        public static OutOfMonthVisibility[] values() {
            return (OutOfMonthVisibility[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12618a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12619b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f12620c = null;

        static {
            int[] r10 = new int[OutOfMonthVisibility.values().length];
            r10[OutOfMonthVisibility.HIDE.ordinal()] = 1;
            r10[OutOfMonthVisibility.GREY.ordinal()] = 2;
            f12618a = r10;
            int[] r11 = new int[DayOfWeek.values().length];
            r11[DayOfWeek.SUNDAY.ordinal()] = 1;
            r11[DayOfWeek.MONDAY.ordinal()] = 2;
            r11[DayOfWeek.TUESDAY.ordinal()] = 3;
            r11[DayOfWeek.WEDNESDAY.ordinal()] = 4;
            r11[DayOfWeek.THURSDAY.ordinal()] = 5;
            r11[DayOfWeek.FRIDAY.ordinal()] = 6;
            r11[DayOfWeek.SATURDAY.ordinal()] = 7;
            f12619b = r11;
            int[] r12 = new int[DatePickerMode.values().length];
            r12[DatePickerMode.BOARD_SHEET.ordinal()] = 1;
            r12[DatePickerMode.NARROW_SHEET.ordinal()] = 2;
            f12620c = r12;
        }
    }

    static {
        F = new a(null);
    }

    @JvmOverloads
    public ODatePickerView(@NotNull Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        DatePickerMode r13 = null;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 30, null);
    }

    public static final void B(final ODatePickerView r10, jd.b.C0283b r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "it");
        Integer r12 = (Integer) r11.a().get(1001);
        Integer r13 = (Integer) r11.a().get(1002);
        if (r12 != null) goto L5;
        int r14 = r10.f12595d;
    L6:
        r10.f12595d = r14;
        if (r13 != null) goto L9;
        int r15 = r10.f12596e;
    L10:
        r10.f12596e = r15;
        Calendar r16 = Calendar.getInstance();
        final int r17 = r10.f12595d + 1900;
        r16.set(r17, bg.h.d(r10.f12596e, 0), 1);
        String r18 = r10.r(r16.getTimeInMillis(), r10.A);
        r10.f12603l.setText(r18);
        if (r10.f12614w == false) goto L13;
        return;
    L13:
        Runnable r19 = r10.f12617z;
        if (r19 == null) goto L17;
        r10.removeCallbacks(r19);
    L17:
        Runnable r20 = new r(r10, r17);
        r10.f12617z = r20;
        r10.postDelayed(r20, 100);
        return;
    L9:
        r15 = r13.intValue();
        goto L10
    L5:
        r14 = r12.intValue();
        goto L6
    }

    public static final void C(ODatePickerView r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.H(r11);
    }

    public static final void D(ODatePickerView r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        jb.d r12 = r10.f12608q;
        if (r12 == null) goto L6;
        jb.d.c(r12, false, 1, null);
    L6:
        float r13 = r10.f12605n.getRotation();
        float r14 = 0.0f;
        if (r10.f12609r == true) goto L9;
        float r15 = 90.0f;
    L10:
        r10.G(r13, r15);
        boolean r16 = r10.f12609r;
        if (r16 == true) goto L13;
        View r17 = r10.f12607p;
    L14:
        if (r16 == true) goto L16;
        View r18 = r10.f12600i;
    L17:
        jb.d r19 = r10.f12610s;
        if (r19 == null) goto L21;
        jb.d.c(r19, false, 1, null);
    L21:
        jb.d r20 = r10.f12611t;
        if (r20 == null) goto L25;
        jb.d.c(r20, false, 1, null);
    L25:
        ObjectAnimator r21 = r10.f12612u;
        if (r21 == null) goto L29;
        r21.cancel();
    L29:
        ObjectAnimator r22 = r10.f12613v;
        if (r22 == null) goto L33;
        r22.cancel();
    L33:
        if (r18 != null) goto L35;
        float r23 = 1.0f;
    L36:
        if (r17 == null) goto L39;
        r14 = r17.getAlpha();
    L39:
        if (r17 == null) goto L42;
        r17.setAlpha(r14);
    L42:
        if (r18 == null) goto L45;
        r18.setAlpha(r23);
    L45:
        r10.F(r23, r18, r17);
        r10.f12609r = !r10.f12609r;
        return;
    L35:
        r23 = r18.getAlpha();
        goto L36
    L16:
        r18 = r10.f12607p;
        goto L17
    L13:
        r17 = r10.f12600i;
        goto L14
    L9:
        r15 = 0.0f;
        goto L10
    }

    public static /* synthetic */ void g(ODatePickerView r10, View r11) {
        t(r10, r11);
    }

    private final int getMillisecond() {
        return this.f12598g;
    }

    private final int getSecond() {
        return this.f12597f;
    }

    public static /* synthetic */ void h(Calendar r10, ODatePickerView r11, MaterialCalendarView r12, CalendarDay r13) {
        v(r10, r11, r12, r13);
    }

    public static /* synthetic */ void i(ODatePickerView r10, View r11) {
        u(r10, r11);
    }

    public static /* synthetic */ void j(ODatePickerView r10, MaterialCalendarView r11, List r12) {
        y(r10, r11, r12);
    }

    public static /* synthetic */ void k(ODatePickerView r10, MaterialCalendarView r11, CalendarDay r12) {
        x(r10, r11, r12);
    }

    public static /* synthetic */ void l(ODatePickerView r10, int r11) {
        C(r10, r11);
    }

    public static /* synthetic */ void m(ODatePickerView r10, View r11) {
        D(r10, r11);
    }

    public static /* synthetic */ void n(Calendar r10, ODatePickerView r11, MaterialCalendarView r12, CalendarDay r13, boolean r14) {
        w(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void o(ODatePickerView r10, jd.b.C0283b r11) {
        B(r10, r11);
    }

    public static final /* synthetic */ ImageView p(ODatePickerView r10) {
        return r10.f12605n;
    }

    private final void setMillisecond(int r10) {
        this.f12598g = r10;
    }

    private final void setSecond(int r10) {
        this.f12597f = r10;
    }

    public static final void t(ODatePickerView r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f12600i.v();
    }

    public static final void u(ODatePickerView r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f12600i.u();
    }

    public static final void v(Calendar r10, ODatePickerView r11, MaterialCalendarView r12, CalendarDay r13) {
        kotlin.jvm.internal.q.g(r11, "this$0");
        tc.d.f24779a.d("DatePickerView", "setOnMonthChangedListener widget:" + r12 + ",date:" + r13);
        r10.set(r13.getYear(), r13.getMonth() - 1, 1);
        long r14 = r10.getTimeInMillis();
        r11.f12603l.setText(r11.r(r14, r11.A));
        r11.f12595d = r13.getYear();
        r11.f12596e = r13.getMonth();
        if (r11.f12593b == false) goto L5;
        r11.f12600i.setSelectedDate(CalendarDay.from(r13.getYear(), r13.getMonth(), 1));
    L5:
        kotlin.jvm.internal.q.f(r13, "date");
        r11.I(r13);
        Function1 r15 = r11.B;
        if (r15 == null) goto L10;
        r15.invoke(Long.valueOf(r14));
        return;
    }

    public static final void w(Calendar r10, ODatePickerView r11, MaterialCalendarView r12, CalendarDay r13, boolean r14) {
        kotlin.jvm.internal.q.g(r11, "this$0");
        kotlin.jvm.internal.q.g(r12, "widget");
        kotlin.jvm.internal.q.g(r13, "date");
        tc.d.f24779a.d("DatePickerView", "setOnDateChangedListener widget:" + r12 + ",date:" + r13 + ",selected:" + r14);
        r10.set(r13.getYear(), r13.getMonth() + (-1), r13.getDay());
        long r15 = r10.getTimeInMillis();
        r11.f12603l.setText(r11.r(r15, r11.A));
        r11.f12594c = r13.getDay();
        r11.f12595d = r13.getYear();
        r11.f12596e = r13.getMonth();
        Function1 r16 = r11.C;
        if (r16 == null) goto L7;
        r16.invoke(Long.valueOf(r15));
        return;
    }

    public static final void x(ODatePickerView r10, MaterialCalendarView r11, CalendarDay r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "widget");
        kotlin.jvm.internal.q.g(r12, "date");
        Function1 r13 = r10.D;
        if (r13 == null) goto L7;
        r13.invoke(Long.valueOf(r10.J(r12)));
        return;
    }

    public static final void y(ODatePickerView r10, MaterialCalendarView r11, List r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "widget");
        kotlin.jvm.internal.q.g(r12, "dates");
        Function1 r13 = r10.E;
        if (r13 == null) goto L12;
        ArrayList r14 = new ArrayList(kotlin.collections.u.r(r12, 10));
        Iterator r15 = r12.iterator();
    L7:
        if (r15.hasNext() == false) goto L9;
        CalendarDay r16 = (CalendarDay) r15.next();
        kotlin.jvm.internal.q.f(r16, "it");
        r14.add(Long.valueOf(r10.J(r16)));
        goto L7
    L9:
        r13.invoke(r14);
        return;
    }

    private final void z() {
        s();
        A();
    }

    public final void A() {
        jd.b.a r10 = new jd.b.a();
        Context r11 = getContext();
        kotlin.jvm.internal.q.f(r11, "context");
        jd.b.a r12 = r10.e(r11, 1001, 1900, 2100, Integer.valueOf(this.f12595d), Integer.valueOf(tc.f.r(this, 164)));
        Context r13 = getContext();
        kotlin.jvm.internal.q.f(r13, "context");
        jd.b.a r14 = r12.b(r13, 1002, Integer.valueOf(this.f12596e), Integer.valueOf(tc.f.r(this, 164)));
        Context r15 = getContext();
        kotlin.jvm.internal.q.f(r15, "context");
        jd.b.a r16 = r14.l(qb.a.a(r15)).k(tc.f.r(this, 258));
        r16.setOnChangedListener(new p(this));
        Context r17 = getContext();
        kotlin.jvm.internal.q.f(r17, "context");
        View r18 = ((jd.b) OReelPickerBuilder.a.a(r16, r17, null, 0, 6, null)).asView();
        if (r18 != null) goto L5;
        r18 = null;
    L6:
        this.f12607p = r18;
        this.f12604m.setOnClickListener(new q(this));
        return;
    L5:
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-1, r18.getLayoutParams().height);
        r19.gravity = 17;
        r18.setLayoutParams(r19);
        r18.setAlpha(0.0f);
        r18.setVisibility(4);
        this.f12606o.addView(r18);
        goto L6
    }

    public final void E() {
        Calendar r10 = Calendar.getInstance();
        tc.d r11 = tc.d.f24779a;
        r11.d("DatePickerView", "默认选中的时间:" + this.f12599h + " , mSelectTime:" + this.f12599h);
        r10.setTimeInMillis(this.f12599h);
        int r12 = r10.get(1);
        int r13 = r10.get(2) + 1;
        int r14 = r10.get(5);
        int r15 = r10.get(11);
        int r16 = r10.get(12);
        int r17 = r10.get(13);
        int r18 = r10.get(14);
        this.f12594c = r14;
        r11.d("DatePickerView", "转化时间year:" + r12 + ",month:" + r13 + ",day:" + r14 + ",hour:" + r15 + ",minute:" + r16 + ", selectDate:" + CalendarDay.from(r12, r13, r14));
        String r19 = r(this.f12599h, this.A);
        this.f12600i.setCurrentDate(CalendarDay.from(r12, r13, r14));
        this.f12600i.setSelectedDate(CalendarDay.from(r12, r13, r14));
        this.f12603l.setText(r19);
        setSecond(r17);
        setMillisecond(r18);
    }

    public final void F(float r24, final View r25, final View r26) {
        PathInterpolator r10 = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        if (r25 == null) goto L6;
        r25.setVisibility(0);
    L6:
        if (r26 == null) goto L9;
        r26.setVisibility(0);
    L9:
        jb.d r13 = null;
        if (r25 == null) goto L16;
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r25, "alpha", new float[]{r24, 0.0f});
        r14.setDuration(50);
        r14.setInterpolator(r10);
        this.f12612u = r14;
        if (r25 != this.f12607p) goto L14;
        final float r11 = 1.05f;
    L15:
        com.obric.common.oea.foundation.animation.builder.d.a r16 = new com.obric.common.oea.foundation.animation.builder.d.a();
        com.obric.common.oea.foundation.animation.spec.spring.b r12 = kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r12.e(0.001f);
        Unit r15 = Unit.f21064a;
        com.obric.common.oea.foundation.animation.builder.d r17 = com.obric.common.oea.foundation.animation.builder.d.a.e(r16, 1.0f, r11, r12, null, 8, null).g(new ODatePickerView$showAlphaAnimation$3(r25)).f(new ODatePickerView$showAlphaAnimation$4(r25, r11)).c();
    L17:
        if (r26 == null) goto L23;
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r26, "alpha", new float[]{r26.getAlpha(), 1.0f});
        r18.setDuration(200);
        r18.setInterpolator(r10);
        this.f12613v = r18;
        if (r26 != this.f12607p) goto L21;
        float r19 = 1.05f;
    L22:
        r26.setScaleX(r19);
        r26.setScaleY(r19);
        com.obric.common.oea.foundation.animation.builder.d.a r110 = new com.obric.common.oea.foundation.animation.builder.d.a();
        com.obric.common.oea.foundation.animation.spec.spring.b r20 = kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r20.e(0.001f);
        Unit r21 = Unit.f21064a;
        final float r22 = 1.0f;
        com.obric.common.oea.foundation.animation.builder.d r23 = com.obric.common.oea.foundation.animation.builder.d.a.e(r110, r19, 1.0f, r20, null, 8, null).g(new ODatePickerView$showAlphaAnimation$7(r26)).f(new ODatePickerView$showAlphaAnimation$8(r26, r22)).c();
    L24:
        if (r17 != null) goto L26;
        jb.d r27 = null;
    L27:
        this.f12610s = r27;
        if (r23 == null) goto L31;
        r13 = r23.a();
    L31:
        this.f12611t = r13;
        ObjectAnimator r28 = this.f12612u;
        if (r28 == null) goto L35;
        r28.start();
    L35:
        ObjectAnimator r29 = this.f12613v;
        if (r29 == null) goto L40;
        r29.start();
        return;
    L40:
        return;
    L26:
        r27 = r17.a();
        goto L27
    L21:
        r19 = 0.95f;
        goto L22
    L23:
        r23 = null;
        goto L24
    L14:
        r11 = 0.95f;
        goto L15
    L16:
        r17 = null;
        goto L17
    }

    public final void G(float r10, float r11) {
        this.f12608q = com.obric.common.oea.foundation.animation.builder.d.a.e(new com.obric.common.oea.foundation.animation.builder.d.a(), r10, r11, kb.a.d(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), null, 8, null).g(new ODatePickerView$showRotateAnimation$1(this)).f(ODatePickerView$showRotateAnimation$2.INSTANCE).c().a();
    }

    public final void H(int r10) {
        if (this.f12614w == false) goto L5;
        return;
    L5:
        int r11 = this.f12596e + 1;
        CalendarDay r12 = this.f12600i.getCurrentDate();
        if (r12.getYear() == r10) goto L8;
    L9:
        this.f12615x = true;
        this.f12600i.setCurrentDate(CalendarDay.from(r10, r11, 1));
        return;
    L8:
        if (r12.getMonth() != r11) goto L9;
    }

    public final void I(CalendarDay r10) {
        if (this.f12615x == false) goto L6;
        this.f12615x = false;
        return;
    L6:
        KeyEvent.Callback r11 = this.f12607p;
        if ((r11 instanceof OReelPicker) == false) goto L9;
        OReelPicker r12 = (OReelPicker) r11;
    L10:
        if (r12 == null) goto L26;
        int r13 = bg.h.d(r10.getYear() - 1900, 0);
        int r14 = bg.h.k(r10.getMonth() - 1, 0, 11);
        this.f12614w = true;
        WheelView r15 = r12.getReelView(0);
        if (r15 != null) goto L16;
    L18:
        WheelView r16 = r12.getReelView(1);
        if (r16 != null) goto L22;
    L24:
        this.f12614w = false;
        return;
    L22:
        if (r16.getCurrentIndex() == r14) goto L24;
        r16.S(r14, false);
        goto L24
    L16:
        if (r15.getCurrentIndex() == r13) goto L18;
        r15.S(r13, false);
        goto L18
    L26:
        return;
    L9:
        r12 = null;
        goto L10
    }

    public final long J(CalendarDay r10) {
        Calendar r11 = Calendar.getInstance();
        r11.set(r10.getYear(), r10.getMonth() - 1, r10.getDay(), 0, 0, 0);
        r11.set(14, 0);
        return r11.getTimeInMillis();
    }

    @NotNull
    public final CalendarMode getCalendarMode() {
        CalendarMode r10 = this.f12600i.getCalendarMode();
        kotlin.jvm.internal.q.f(r10, "calendarView.calendarMode");
        return r10;
    }

    @NotNull
    public final MaterialCalendarView getCalendarView() {
        return this.f12600i;
    }

    @NotNull
    public final CalendarDay getCurrentDate() {
        CalendarDay r10 = this.f12600i.getCurrentDate();
        kotlin.jvm.internal.q.f(r10, "calendarView.currentDate");
        return r10;
    }

    @Nullable
    public final CalendarDay getMaximumDate() {
        return this.f12600i.getMaximumDate();
    }

    @Nullable
    public final CalendarDay getMinimumDate() {
        return this.f12600i.getMinimumDate();
    }

    @Nullable
    public final Function1<Long, Unit> getOnDateChangedListener() {
        return this.C;
    }

    @Nullable
    public final Function1<Long, Unit> getOnDateLongClickListener() {
        return this.D;
    }

    @Nullable
    public final Function1<Long, Unit> getOnMonthChangedListener() {
        return this.B;
    }

    @Nullable
    public final Function1<List<Long>, Unit> getOnRangeSelectedListener() {
        return this.E;
    }

    public final long getSelectTimestamp() {
        Calendar r10 = Calendar.getInstance();
        CalendarDay r11 = this.f12600i.getSelectedDates().get(0);
        int r12 = r11.getYear();
        int r13 = r11.getMonth() - 1;
        int r14 = r11.getDay();
        r10.set(13, getSecond());
        r10.set(14, getMillisecond());
        r10.set(r12, r13, r14, 0, 0);
        return r10.getTimeInMillis();
    }

    @Nullable
    public final CalendarDay getSelectedDate() {
        return this.f12600i.getSelectedDate();
    }

    @NotNull
    public final List<CalendarDay> getSelectedDates() {
        List<CalendarDay> r10 = this.f12600i.getSelectedDates();
        kotlin.jvm.internal.q.f(r10, "calendarView.selectedDates");
        return r10;
    }

    @ColorInt
    public final int getSelectionColor() {
        return this.f12600i.getSelectionColor();
    }

    public final int getSelectionMode() {
        return this.f12600i.getSelectionMode();
    }

    public final int getShowOtherDates() {
        return this.f12600i.getShowOtherDates();
    }

    public final int getTileHSpacing() {
        return this.f12600i.getTileHSpacing();
    }

    public final int getTileHeight() {
        return this.f12600i.getTileHeight();
    }

    public final int getTileVSpacing() {
        return this.f12600i.getTileVSpacing();
    }

    public final int getTileWidth() {
        return this.f12600i.getTileWidth();
    }

    public final int getWeekDaysHeight() {
        return this.f12600i.getWeekDaysHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        td.c r10 = td.c.f24796a;
        ViewParent r11 = getParent();
        if (r11 != null) goto L6;
    L4:
        r11 = null;
    L7:
        ViewGroup r12 = (ViewGroup) r11;
        if ((r12 instanceof OSheetContentFrameLayout) == false) goto L35;
        OSheetContentFrameLayout r13 = (OSheetContentFrameLayout) r12;
        if (r13.getId() != R$id.content_container) goto L36;
        int r14 = r13.getPaddingLeft();
        int r15 = r13.getPaddingTop();
        int r16 = r13.getPaddingRight();
        int r17 = r13.getPaddingBottom();
        int r18 = b.f12620c[this.f12592a.ordinal()];
        if (r18 == 1) goto L26;
        if (r18 == 2) goto L17;
        return;
    L17:
        if (r14 == tc.f.r(this, 0)) goto L19;
    L24:
        L.a("DatePickerView", "onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [" + r14 + ", " + r15 + ", " + r16 + ", " + r17 + ']');
        r13.setPadding(0, 0, 0, 0);
        return;
    L19:
        if (r15 != tc.f.r(this, 0)) goto L24;
        if (r16 != tc.f.r(this, 0)) goto L24;
        if (r17 != tc.f.r(this, 0)) goto L24;
        return;
    L26:
        if (r14 == tc.f.r(this, 16)) goto L28;
    L33:
        L.a("DatePickerView", "onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [" + r14 + ", " + r15 + ", " + r16 + ", " + r17 + ']');
        r13.setPadding(tc.f.r(this, 16), tc.f.r(this, 6), tc.f.r(this, 16), tc.f.r(this, 16));
        return;
    L28:
        if (r15 != tc.f.r(this, 6)) goto L33;
        if (r16 != tc.f.r(this, 16)) goto L33;
        if (r17 != tc.f.r(this, 16)) goto L33;
        return;
    L36:
        return;
    L35:
        return;
    L6:
        if ((r11 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        String r11 = getResources().getString(R$string.oui_date_picker_date_format);
        kotlin.jvm.internal.q.f(r11, "resources.getString(R.st…_date_picker_date_format)");
        this.A = r11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r10 = this.f12617z;
        if (r10 == null) goto L6;
        removeCallbacks(r10);
    L6:
        this.f12617z = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void q() {
        int r10 = b.f12618a[this.f12616y.ordinal()];
        boolean r11 = false;
        if (r10 != 1) goto L5;
        int r12 = 0;
    L10:
        this.f12600i.setShowOtherDates(r12);
        MaterialCalendarView r13 = this.f12600i;
        if (this.f12616y != OutOfMonthVisibility.GREY) goto L13;
        r11 = true;
    L13:
        r13.setAllowClickDaysOutsideCurrentMonth(r11);
        return;
    L5:
        if (r10 != 2) goto L8;
        r12 = 7;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final String r(long r10, String r11) {
        Date r12 = new Date(r10);
        SimpleDateFormat r13 = new SimpleDateFormat(r11, Locale.getDefault());
        r13.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        String r14 = r13.format(r12);
        kotlin.jvm.internal.q.f(r14, "format1.format(date)");
        return r14;
    }

    public final void s() {
        final Calendar r10 = Calendar.getInstance();
        this.f12600i.setTopbarVisible(false);
        this.f12601j.setOnClickListener(new j(this));
        this.f12602k.setOnClickListener(new k(this));
        this.f12600i.setOnMonthChangedListener(new l(r10, this));
        this.f12600i.setOnDateChangedListener(new m(r10, this));
        this.f12600i.setOnDateLongClickListener(new n(this));
        this.f12600i.setOnRangeSelectedListener(new o(this));
        q();
    }

    public final void setAllowClickDaysOutsideCurrentMonth(boolean r10) {
        this.f12600i.setAllowClickDaysOutsideCurrentMonth(r10);
    }

    public final void setCurrentTimeMillis(long r10) {
        this.f12599h = r10;
        E();
    }

    public final void setDateTextAppearance(@StyleRes int r10) {
        this.f12600i.setDateTextAppearance(r10);
    }

    public final void setDayFormatter(@Nullable DayFormatter r10) {
        this.f12600i.setDayFormatter(r10);
    }

    public final void setDayFormatterContentDescription(@Nullable DayFormatter r10) {
        this.f12600i.setDayFormatterContentDescription(r10);
    }

    public final void setDynamicHeightEnabled(boolean r10) {
        this.f12600i.setDynamicHeightEnabled(r10);
    }

    @RequiresApi(30)
    public final void setFirstDayOfWeek(@NotNull DayOfWeek r10) {
        kotlin.jvm.internal.q.g(r10, "firstDayOfWeek");
        switch(b.f12619b[r10.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        org.threeten.bp.DayOfWeek r11 = org.threeten.bp.DayOfWeek.SATURDAY;
    L13:
        this.f12600i.J().g().j(r11).g();
        return;
    L7:
        r11 = org.threeten.bp.DayOfWeek.FRIDAY;
        goto L13
    L8:
        r11 = org.threeten.bp.DayOfWeek.THURSDAY;
        goto L13
    L9:
        r11 = org.threeten.bp.DayOfWeek.WEDNESDAY;
        goto L13
    L10:
        r11 = org.threeten.bp.DayOfWeek.TUESDAY;
        goto L13
    L11:
        r11 = org.threeten.bp.DayOfWeek.MONDAY;
        goto L13
    L12:
        r11 = org.threeten.bp.DayOfWeek.SUNDAY;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void setMaximumDate(@Nullable CalendarDay r10) {
        this.f12600i.J().g().k(r10).g();
    }

    public final void setMinimumDate(@Nullable CalendarDay r10) {
        this.f12600i.J().g().l(r10).g();
    }

    public final void setOnDateChangedListener(@Nullable Function1<? super Long, Unit> r10) {
        this.C = r10;
    }

    public final void setOnDateLongClickListener(@Nullable Function1<? super Long, Unit> r10) {
        this.D = r10;
    }

    public final void setOnMonthChangedListener(@Nullable Function1<? super Long, Unit> r10) {
        this.B = r10;
    }

    public final void setOnRangeSelectedListener(@Nullable Function1<? super List<Long>, Unit> r10) {
        this.E = r10;
    }

    public final void setOutOfMonthVisibility(@NotNull OutOfMonthVisibility r10) {
        kotlin.jvm.internal.q.g(r10, "visibility");
        this.f12616y = r10;
        q();
    }

    public final void setPagingEnabled(boolean r10) {
        this.f12600i.setPagingEnabled(r10);
    }

    public final void setSelectedDate(@Nullable CalendarDay r10) {
        this.f12600i.setSelectedDate(r10);
    }

    public final void setSelectionColor(@ColorInt int r10) {
        this.f12600i.setSelectionColor(r10);
    }

    public final void setSelectionMode(int r10) {
        this.f12600i.setSelectionMode(r10);
    }

    public final void setShowOtherDates(int r10) {
        this.f12600i.setShowOtherDates(r10);
    }

    public final void setShowWeekDays(boolean r10) {
        this.f12600i.J().g().m(r10).g();
    }

    public final void setTileHSpacing(int r10) {
        this.f12600i.setTileHSpacing(r10);
    }

    public final void setTileHeight(int r10) {
        this.f12600i.setTileHeight(r10);
    }

    public final void setTileHeightDp(int r10) {
        this.f12600i.setTileHeightDp(r10);
    }

    public final void setTileSize(int r10) {
        this.f12600i.setTileSize(r10);
    }

    public final void setTileSizeDp(int r10) {
        this.f12600i.setTileSizeDp(r10);
    }

    public final void setTileVSpacing(int r10) {
        this.f12600i.setTileVSpacing(r10);
    }

    public final void setTileWidth(int r10) {
        this.f12600i.setTileWidth(r10);
    }

    public final void setTileWidthDp(int r10) {
        this.f12600i.setTileWidthDp(r10);
    }

    public final void setWeekDayFormatter(@Nullable WeekDayFormatter r10) {
        this.f12600i.setWeekDayFormatter(r10);
    }

    public final void setWeekDayLabels(@NotNull CharSequence[] r10) {
        kotlin.jvm.internal.q.g(r10, "weekDayLabels");
        this.f12600i.setWeekDayLabels(r10);
    }

    public final void setWeekDayTextAppearance(@StyleRes int r10) {
        this.f12600i.setWeekDayTextAppearance(r10);
    }

    public final void setWeekDaysHeight(int r10) {
        this.f12600i.setWeekDaysHeight(r10);
    }

    public final void setWeekDaysHeightDp(int r10) {
        this.f12600i.setWeekDaysHeightDp(r10);
    }

    @JvmOverloads
    public ODatePickerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        int r12 = 0;
        DatePickerMode r13 = null;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 28, null);
    }

    public final void setWeekDayLabels(@ArrayRes int r10) {
        this.f12600i.setWeekDayLabels(r10);
    }

    @JvmOverloads
    public ODatePickerView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        DatePickerMode r13 = null;
        boolean r14 = false;
        this(r10, r11, r12, r13, r14, 24, null);
    }

    public /* synthetic */ ODatePickerView(Context r10, AttributeSet r11, int r12, DatePickerMode r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        r11 = null;
    L5:
        AttributeSet r17 = r11;
        if ((r15 & 4) == 0) goto L8;
        int r18 = 0;
    L10:
        if ((r15 & 8) == 0) goto L12;
        r13 = DatePickerMode.BOARD_SHEET;
    L12:
        DatePickerMode r19 = r13;
        if ((r15 & 16) == 0) goto L15;
        boolean r20 = false;
    L16:
        this(r10, r17, r18, r19, r20);
        return;
    L15:
        r20 = r14;
        goto L16
    L8:
        r18 = r12;
        goto L10
    }

    public ODatePickerView(Context r10, AttributeSet r11, int r12, DatePickerMode r13, boolean r14) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r13, "datePickerMode");
        super(r10, r11, r12);
        this.f12592a = r13;
        this.f12593b = r14;
        this.f12594c = CalendarDay.today().getDay();
        this.f12595d = CalendarDay.today().getYear();
        this.f12596e = CalendarDay.today().getMonth();
        this.f12616y = OutOfMonthVisibility.GREY;
        ViewGroup.inflate(r10, R$layout.o_date_picker_view_default, this);
        String r15 = getResources().getString(R$string.oui_date_picker_date_format);
        kotlin.jvm.internal.q.f(r15, "resources.getString(R.st…_date_picker_date_format)");
        this.A = r15;
        View r16 = findViewById(R$id.calendarView);
        kotlin.jvm.internal.q.f(r16, "findViewById(R.id.calendarView)");
        this.f12600i = (MaterialCalendarView) r16;
        View r17 = findViewById(R$id.previousBtn);
        kotlin.jvm.internal.q.f(r17, "findViewById(R.id.previousBtn)");
        this.f12601j = (ImageView) r17;
        View r18 = findViewById(R$id.nextBtn);
        kotlin.jvm.internal.q.f(r18, "findViewById(R.id.nextBtn)");
        this.f12602k = (ImageView) r18;
        View r19 = findViewById(R$id.currentDateTextView);
        kotlin.jvm.internal.q.f(r19, "findViewById(R.id.currentDateTextView)");
        this.f12603l = (TextView) r19;
        View r20 = findViewById(R$id.ll_open_year_month);
        kotlin.jvm.internal.q.f(r20, "findViewById(R.id.ll_open_year_month)");
        this.f12604m = r20;
        View r21 = findViewById(R$id.iv_open_year_month);
        kotlin.jvm.internal.q.f(r21, "findViewById(R.id.iv_open_year_month)");
        this.f12605n = (ImageView) r21;
        View r22 = findViewById(R$id.fl_calendar_container);
        kotlin.jvm.internal.q.f(r22, "findViewById(R.id.fl_calendar_container)");
        this.f12606o = (FrameLayout) r22;
        z();
    }
}
