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
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.util.OEAExtensionKt;
import com.obric.common.oui.R;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.calendar.format.WeekDayFormatter;
import com.obric.oui.common.util.OUILogger;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.picker.reels.OReelPicker;
import com.obric.oui.picker.reels.pickers.OReelDynamicPicker;
import com.obric.oui.picker.reels.pickers.OReelPickerBuilder;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.sheet.OSheetContentFrameLayout;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.log.L;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ODatePickerView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 Ñ\u00012\u00020\u0001:\u0006Ñ\u0001Ò\u0001Ó\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010F\u001a\u00020/2\b\u0010G\u001a\u0004\u0018\u00010HJ\u001f\u0010I\u001a\u00020/2\u0012\u0010J\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0K\"\u00020H¢\u0006\u0002\u0010LJ\u0016\u0010I\u001a\u00020/2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010MJ\u0006\u0010N\u001a\u00020\u000bJ\b\u0010O\u001a\u00020/H\u0002J\u0006\u0010P\u001a\u00020/J\u0018\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020\u001aH\u0002J\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020\u0013J\u0006\u0010W\u001a\u00020XJ\b\u0010Y\u001a\u0004\u0018\u00010XJ\b\u0010Z\u001a\u00020\u0007H\u0002J\b\u0010[\u001a\u0004\u0018\u00010XJ\b\u0010\\\u001a\u00020\u0007H\u0002J\u0006\u0010]\u001a\u00020'J\b\u0010^\u001a\u0004\u0018\u00010XJ\f\u0010_\u001a\b\u0012\u0004\u0012\u00020X0;J\b\u0010`\u001a\u00020\u0007H\u0007J\u0006\u0010a\u001a\u00020\u0007J\u0006\u0010b\u001a\u00020\u0007J\u0006\u0010c\u001a\u00020\u0007J\u0006\u0010d\u001a\u00020\u0007J\u0006\u0010e\u001a\u00020\u0007J\u0006\u0010f\u001a\u00020\u0007J\u0006\u0010g\u001a\u00020\u0007J\b\u0010h\u001a\u00020/H\u0002J\b\u0010i\u001a\u00020/H\u0002J\b\u0010j\u001a\u00020/H\u0002J\u0006\u0010k\u001a\u00020/J\u0006\u0010l\u001a\u00020\u000bJ\u0006\u0010m\u001a\u00020\u000bJ\u0006\u0010n\u001a\u00020\u000bJ\b\u0010o\u001a\u00020/H\u0014J\u0012\u0010p\u001a\u00020/2\b\u0010q\u001a\u0004\u0018\u00010rH\u0014J\b\u0010s\u001a\u00020/H\u0014J0\u0010t\u001a\u00020/2\u0006\u0010u\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u0007H\u0014J\u0018\u0010z\u001a\u00020/2\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u0007H\u0014J\u0010\u0010}\u001a\u00020/2\b\u0010G\u001a\u0004\u0018\u00010HJ\u0006\u0010~\u001a\u00020/J\u0018\u0010\u007f\u001a\u00020/2\u0007\u0010\u0080\u0001\u001a\u00020X2\u0007\u0010\u0081\u0001\u001a\u00020XJ\u0010\u0010\u0082\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u00020\u000bJ\u001b\u0010\u0084\u0001\u001a\u00020/2\u0007\u0010\u0085\u0001\u001a\u00020U2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u000bJ\u001d\u0010\u0087\u0001\u001a\u00020/2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010X2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u000bJ\u0010\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020'J\u001d\u0010\u008c\u0001\u001a\u00020/2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010X2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010XJ\u001b\u0010\u008f\u0001\u001a\u00020/2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010X2\u0007\u0010\u0091\u0001\u001a\u00020\u000bJ\u0012\u0010\u0092\u0001\u001a\u00020/2\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0007J\u0013\u0010\u0094\u0001\u001a\u00020/2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020/2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001J\t\u0010\u0098\u0001\u001a\u00020/H\u0002J\u0010\u0010\u0099\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u00020\u000bJ\u0013\u0010\u009a\u0001\u001a\u00020/2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0007J\u0012\u0010\u009d\u0001\u001a\u00020/2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010XJ\u0011\u0010\u009e\u0001\u001a\u00020/2\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020/2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010XJ\u0010\u0010 \u0001\u001a\u00020/2\u0007\u0010¡\u0001\u001a\u00020@J\u0010\u0010¢\u0001\u001a\u00020/2\u0007\u0010\u0083\u0001\u001a\u00020\u000bJ\u0011\u0010£\u0001\u001a\u00020/2\u0006\u0010C\u001a\u00020\u0007H\u0002J\u0012\u0010¤\u0001\u001a\u00020/2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010XJ\u0012\u0010¥\u0001\u001a\u00020/2\t\b\u0001\u0010¦\u0001\u001a\u00020\u0007J\u0010\u0010§\u0001\u001a\u00020/2\u0007\u0010\u0085\u0001\u001a\u00020\u0007J\u0010\u0010¨\u0001\u001a\u00020/2\u0007\u0010©\u0001\u001a\u00020\u0007J\u0010\u0010ª\u0001\u001a\u00020/2\u0007\u0010«\u0001\u001a\u00020\u000bJ\u0010\u0010¬\u0001\u001a\u00020/2\u0007\u0010\u00ad\u0001\u001a\u00020\u0007J\u0010\u0010®\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u00020\u0007J\u0010\u0010°\u0001\u001a\u00020/2\u0007\u0010±\u0001\u001a\u00020\u0007J\u0010\u0010²\u0001\u001a\u00020/2\u0007\u0010³\u0001\u001a\u00020\u0007J\u0010\u0010´\u0001\u001a\u00020/2\u0007\u0010µ\u0001\u001a\u00020\u0007J\u0010\u0010¶\u0001\u001a\u00020/2\u0007\u0010\u00ad\u0001\u001a\u00020\u0007J\u0010\u0010·\u0001\u001a\u00020/2\u0007\u0010¸\u0001\u001a\u00020\u0007J\u0010\u0010¹\u0001\u001a\u00020/2\u0007\u0010º\u0001\u001a\u00020\u0007J\u0013\u0010»\u0001\u001a\u00020/2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010¼\u0001J\u001d\u0010½\u0001\u001a\u00020/2\u000e\u0010¾\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010K¢\u0006\u0003\u0010À\u0001J\u0012\u0010½\u0001\u001a\u00020/2\t\b\u0001\u0010Á\u0001\u001a\u00020\u0007J\u0012\u0010Â\u0001\u001a\u00020/2\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0007J\u0010\u0010Ã\u0001\u001a\u00020/2\u0007\u0010¯\u0001\u001a\u00020\u0007J\u0010\u0010Ä\u0001\u001a\u00020/2\u0007\u0010±\u0001\u001a\u00020\u0007J)\u0010Å\u0001\u001a\u00020/2\b\u0010Æ\u0001\u001a\u00030Ç\u00012\t\u0010È\u0001\u001a\u0004\u0018\u00010%2\t\u0010É\u0001\u001a\u0004\u0018\u00010%H\u0002J\u001d\u0010Ê\u0001\u001a\u00020/2\b\u0010Ë\u0001\u001a\u00030Ç\u00012\b\u0010Ì\u0001\u001a\u00030Ç\u0001H\u0002J\u0012\u0010Í\u0001\u001a\u00020/2\u0007\u0010Î\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010Ï\u0001\u001a\u00020/2\u0007\u0010\u0088\u0001\u001a\u00020XH\u0002J\r\u0010Ð\u0001\u001a\u00020'*\u00020XH\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010*\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R7\u00104\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R7\u00107\u001a\u001f\u0012\u0013\u0012\u00110'¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R=\u0010:\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020'0;¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020/\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00101\"\u0004\b>\u00103R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ô\u0001"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "datePickerMode", "Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "selectDateOnMonthChange", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/obric/oui/calendar/ODatePickerView$DatePickerMode;Z)V", "alphaInAnimator", "Landroid/animation/ObjectAnimator;", "alphaOutAnimator", "arrowAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "calendarView", "Lcom/obric/oui/calendar/MaterialCalendarView;", "currentDateTextView", "Landroid/widget/TextView;", "currentDayOfMonth", "currentMonth", "currentYear", "dateFormat", "", "fadeInAnimator", "fadeOutAnimator", "flCalendarContainer", "Landroid/widget/FrameLayout;", "isSyncingFromCalendar", "isSyncingFromPicker", "isYearMonthOpen", "ivOpenYearMonth", "Landroid/widget/ImageView;", "llOpenYearMonth", "Landroid/view/View;", "mSelectTime", "", "millisecond", "nextBtn", "onDateChangedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", DBHelper.COL_TIME, "", "getOnDateChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnDateChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onDateLongClickListener", "getOnDateLongClickListener", "setOnDateLongClickListener", "onMonthChangedListener", "getOnMonthChangedListener", "setOnMonthChangedListener", "onRangeSelectedListener", "", "times", "getOnRangeSelectedListener", "setOnRangeSelectedListener", "outOfMonthVisibility", "Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "pickerView", "previousBtn", "second", "syncCalendarRunnable", "Ljava/lang/Runnable;", "addDecorator", "decorator", "Lcom/obric/oui/calendar/DayViewDecorator;", "addDecorators", "decorators", "", "([Lcom/obric/oui/calendar/DayViewDecorator;)V", "", "allowClickDaysOutsideCurrentMonth", "applyOutOfMonthVisibility", "clearSelection", "formatDate13", "timestamp", "format", "getCalendarMode", "Lcom/obric/oui/calendar/CalendarMode;", "getCalendarView", "getCurrentDate", "Lcom/obric/oui/calendar/CalendarDay;", "getMaximumDate", "getMillisecond", "getMinimumDate", "getSecond", "getSelectTimestamp", "getSelectedDate", "getSelectedDates", "getSelectionColor", "getSelectionMode", "getShowOtherDates", "getTileHSpacing", "getTileHeight", "getTileVSpacing", "getTileWidth", "getWeekDaysHeight", "initCalendar", "initView", "initYearAndMonthPickerView", "invalidateDecorators", "isDynamicHeightEnabled", "isPagingEnabled", "isShowWeekDays", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeDecorator", "removeDecorators", "selectRange", "firstDay", "lastDay", "setAllowClickDaysOutsideCurrentMonth", "enabled", "setCalendarDisplayMode", "mode", "cacheCurrentPosition", "setCurrentDate", "date", "useSmoothScroll", "setCurrentTimeMillis", "selectedTime", "setDateRange", "minDate", "maxDate", "setDateSelected", "day", "selected", "setDateTextAppearance", "resourceId", "setDayFormatter", "formatter", "Lcom/obric/oui/calendar/format/DayFormatter;", "setDayFormatterContentDescription", "setDefaultDate", "setDynamicHeightEnabled", "setFirstDayOfWeek", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "setMaximumDate", "setMillisecond", "setMinimumDate", "setOutOfMonthVisibility", "visibility", "setPagingEnabled", "setSecond", "setSelectedDate", "setSelectionColor", "color", "setSelectionMode", "setShowOtherDates", "showOtherDates", "setShowWeekDays", "showWeekDays", "setTileHSpacing", "spacingPx", "setTileHeight", "heightPx", "setTileHeightDp", "heightDp", "setTileSize", "sizePx", "setTileSizeDp", "sizeDp", "setTileVSpacing", "setTileWidth", "widthPx", "setTileWidthDp", "widthDp", "setWeekDayFormatter", "Lcom/obric/oui/calendar/format/WeekDayFormatter;", "setWeekDayLabels", "weekDayLabels", "", "([Ljava/lang/CharSequence;)V", "arrayRes", "setWeekDayTextAppearance", "setWeekDaysHeight", "setWeekDaysHeightDp", "showAlphaAnimation", "hideStart", "", "toHide", "toShow", "showRotateAnimation", "from", "to", "syncCalendar", "yearReal", "syncPicker", "toTimestamp", "Companion", "DatePickerMode", "OutOfMonthVisibility", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODatePickerView extends ConstraintLayout {
    public static final Companion Companion = null;
    public static final int MONTH_ID = 1002;
    private static final long SYNC_CALENDAR_DEBOUNCE_MS = 100;
    public static final String TAG = "DatePickerView";
    public static final int YEAR_FROM = 1900;
    public static final int YEAR_ID = 1001;
    public static final int YEAR_TO = 2100;
    private ObjectAnimator alphaInAnimator;
    private ObjectAnimator alphaOutAnimator;
    private AnimationManager arrowAnimator;
    private MaterialCalendarView calendarView;
    private TextView currentDateTextView;
    private int currentDayOfMonth;
    private int currentMonth;
    private int currentYear;
    private String dateFormat;
    private DatePickerMode datePickerMode;
    private AnimationManager fadeInAnimator;
    private AnimationManager fadeOutAnimator;
    private FrameLayout flCalendarContainer;
    private boolean isSyncingFromCalendar;
    private boolean isSyncingFromPicker;
    private boolean isYearMonthOpen;
    private ImageView ivOpenYearMonth;
    private View llOpenYearMonth;
    private long mSelectTime;
    private int millisecond;
    private ImageView nextBtn;
    private Function1<? super Long, Unit> onDateChangedListener;
    private Function1<? super Long, Unit> onDateLongClickListener;
    private Function1<? super Long, Unit> onMonthChangedListener;
    private Function1<? super List<Long>, Unit> onRangeSelectedListener;
    private OutOfMonthVisibility outOfMonthVisibility;
    private View pickerView;
    private ImageView previousBtn;
    private int second;
    private boolean selectDateOnMonthChange;
    private Runnable syncCalendarRunnable;

    /* JADX INFO: compiled from: ODatePickerView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$Companion;", "", "()V", "MONTH_ID", "", "SYNC_CALENDAR_DEBOUNCE_MS", "", "TAG", "", "YEAR_FROM", "YEAR_ID", "YEAR_TO", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$DatePickerMode;", "", "(Ljava/lang/String;I)V", "BOARD_SHEET", "NARROW_SHEET", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum DatePickerMode extends Enum<DatePickerMode> {
        private static final /* synthetic */ DatePickerMode[] $VALUES = null;
        public static final DatePickerMode BOARD_SHEET = null;

        @Deprecated(message = "this mode is deprecated, please use BOARD_SHEET")
        public static final DatePickerMode NARROW_SHEET = null;

        private static final /* synthetic */ DatePickerMode[] $values() {
            return new DatePickerMode[]{BOARD_SHEET, NARROW_SHEET};
        }

        public static DatePickerMode valueOf(String r1) {
            return (DatePickerMode) Enum.valueOf(DatePickerMode.class, r1);
        }

        public static DatePickerMode[] values() {
            return (DatePickerMode[]) $VALUES.clone();
        }

        private DatePickerMode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            BOARD_SHEET = new DatePickerMode("BOARD_SHEET", 0);
            NARROW_SHEET = new DatePickerMode("NARROW_SHEET", 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/calendar/ODatePickerView$OutOfMonthVisibility;", "", "(Ljava/lang/String;I)V", "GREY", "HIDE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum OutOfMonthVisibility extends Enum<OutOfMonthVisibility> {
        private static final /* synthetic */ OutOfMonthVisibility[] $VALUES = null;
        public static final OutOfMonthVisibility GREY = null;
        public static final OutOfMonthVisibility HIDE = null;

        private static final /* synthetic */ OutOfMonthVisibility[] $values() {
            return new OutOfMonthVisibility[]{GREY, HIDE};
        }

        public static OutOfMonthVisibility valueOf(String r1) {
            return (OutOfMonthVisibility) Enum.valueOf(OutOfMonthVisibility.class, r1);
        }

        public static OutOfMonthVisibility[] values() {
            return (OutOfMonthVisibility[]) $VALUES.clone();
        }

        private OutOfMonthVisibility(String r1, int r2) {
            super(r1, r2);
        }

        static {
            GREY = new OutOfMonthVisibility("GREY", 0);
            HIDE = new OutOfMonthVisibility("HIDE", 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: ODatePickerView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[OutOfMonthVisibility.values().length];
            r0[OutOfMonthVisibility.HIDE.ordinal()] = 1;
            r0[OutOfMonthVisibility.GREY.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[DayOfWeek.values().length];
            r1[DayOfWeek.SUNDAY.ordinal()] = 1;
            r1[DayOfWeek.MONDAY.ordinal()] = 2;
            r1[DayOfWeek.TUESDAY.ordinal()] = 3;
            r1[DayOfWeek.WEDNESDAY.ordinal()] = 4;
            r1[DayOfWeek.THURSDAY.ordinal()] = 5;
            r1[DayOfWeek.FRIDAY.ordinal()] = 6;
            r1[DayOfWeek.SATURDAY.ordinal()] = 7;
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[DatePickerMode.values().length];
            r2[DatePickerMode.BOARD_SHEET.ordinal()] = 1;
            r2[DatePickerMode.NARROW_SHEET.ordinal()] = 2;
            $EnumSwitchMapping$2 = r2;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-Pj-wFp7ztrW-fHVo5hBjL95r48, reason: not valid java name */
    public static /* synthetic */ void m409$r8$lambda$PjwFp7ztrWfHVo5hBjL95r48(ODatePickerView r0, View r1) {
        m411initCalendar$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$-fshZPTFAoiUO8u5XABDEjwHNus, reason: not valid java name */
    public static /* synthetic */ void m410$r8$lambda$fshZPTFAoiUO8u5XABDEjwHNus(ODatePickerView r0, View r1) {
        m412initCalendar$lambda1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$6lQyEDGiyrZD5PKqJPYks79ouSo(ODatePickerView r0, OReelDynamicPicker.PickedData r1) {
        m417initYearAndMonthPickerView$lambda13$lambda12(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$DIswhdWtS0Ksxr4QeC3b_eawr4c(Calendar r0, ODatePickerView r1, MaterialCalendarView r2, CalendarDay r3) {
        m413initCalendar$lambda2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$YTiYZD1ebCfF9b6aWlz7zxkEeNA(ODatePickerView r0, MaterialCalendarView r1, CalendarDay r2) {
        m415initCalendar$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$hdlDL4WROXez3JBSbc9EdC4JRj4(Calendar r0, ODatePickerView r1, MaterialCalendarView r2, CalendarDay r3, boolean r4) {
        m414initCalendar$lambda3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$lWzDrVUB06jCiHrTVrXnF5reZXU(ODatePickerView r0, int r1) {
        m418initYearAndMonthPickerView$lambda13$lambda12$lambda11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$rX7eTU5wEBxzaBoxLjuCFb7oKTA(ODatePickerView r0, View r1) {
        m419initYearAndMonthPickerView$lambda15(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$rrA3bm_k0kWg97l2h_8SzT3FEww(ODatePickerView r0, MaterialCalendarView r1, List r2) {
        m416initCalendar$lambda6(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public ODatePickerView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0, null, false, 30, null);
    }

    public ODatePickerView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, null, false, 28, null);
    }

    public ODatePickerView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, null, false, 24, null);
    }

    public ODatePickerView(Context r10, AttributeSet r11, int r12, DatePickerMode r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "datePickerMode");
        this(r10, r11, r12, r13, false, 16, null);
    }

    public static final /* synthetic */ ImageView access$getIvOpenYearMonth$p(ODatePickerView r0) {
        return r0.ivOpenYearMonth;
    }

    public /* synthetic */ ODatePickerView(Context r7, AttributeSet r8, int r9, DatePickerMode r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        AttributeSet r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        int r3 = 0;
    L10:
        if ((r12 & 8) == 0) goto L12;
        r10 = DatePickerMode.BOARD_SHEET;
    L12:
        DatePickerMode r4 = r10;
        if ((r12 & 16) == 0) goto L15;
        boolean r5 = false;
    L16:
        this(r7, r2, r3, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L8:
        r3 = r9;
        goto L10
    }

    public ODatePickerView(Context r2, AttributeSet r3, int r4, DatePickerMode r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "datePickerMode");
        super(r2, r3, r4);
        this.datePickerMode = r5;
        this.selectDateOnMonthChange = r6;
        this.currentDayOfMonth = CalendarDay.today().getDay();
        this.currentYear = CalendarDay.today().getYear();
        this.currentMonth = CalendarDay.today().getMonth();
        this.outOfMonthVisibility = OutOfMonthVisibility.GREY;
        ConstraintLayout.inflate(r2, R.layout.o_date_picker_view_default, this);
        String r7 = getResources().getString(R.string.oui_date_picker_date_format);
        Intrinsics.checkNotNullExpressionValue(r7, "resources.getString(R.st…_date_picker_date_format)");
        this.dateFormat = r7;
        View r8 = findViewById(R.id.calendarView);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.calendarView)");
        this.calendarView = (MaterialCalendarView) r8;
        View r9 = findViewById(R.id.previousBtn);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.previousBtn)");
        this.previousBtn = (ImageView) r9;
        View r10 = findViewById(R.id.nextBtn);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.nextBtn)");
        this.nextBtn = (ImageView) r10;
        View r11 = findViewById(R.id.currentDateTextView);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.currentDateTextView)");
        this.currentDateTextView = (TextView) r11;
        View r12 = findViewById(R.id.ll_open_year_month);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.ll_open_year_month)");
        this.llOpenYearMonth = r12;
        View r13 = findViewById(R.id.iv_open_year_month);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.iv_open_year_month)");
        this.ivOpenYearMonth = (ImageView) r13;
        View r14 = findViewById(R.id.fl_calendar_container);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.fl_calendar_container)");
        this.flCalendarContainer = (FrameLayout) r14;
        initView();
    }

    public final Function1<Long, Unit> getOnMonthChangedListener() {
        return this.onMonthChangedListener;
    }

    public final void setOnMonthChangedListener(Function1<? super Long, Unit> r1) {
        this.onMonthChangedListener = r1;
    }

    public final Function1<Long, Unit> getOnDateChangedListener() {
        return this.onDateChangedListener;
    }

    public final void setOnDateChangedListener(Function1<? super Long, Unit> r1) {
        this.onDateChangedListener = r1;
    }

    public final Function1<Long, Unit> getOnDateLongClickListener() {
        return this.onDateLongClickListener;
    }

    public final void setOnDateLongClickListener(Function1<? super Long, Unit> r1) {
        this.onDateLongClickListener = r1;
    }

    public final Function1<List<Long>, Unit> getOnRangeSelectedListener() {
        return this.onRangeSelectedListener;
    }

    public final void setOnRangeSelectedListener(Function1<? super List<Long>, Unit> r1) {
        this.onRangeSelectedListener = r1;
    }

    private final void initView() {
        initCalendar();
        initYearAndMonthPickerView();
    }

    private final void initCalendar() {
        final Calendar r0 = Calendar.getInstance();
        this.calendarView.setTopbarVisible(false);
        this.previousBtn.setOnClickListener(new ODatePickerView$$ExternalSyntheticLambda2(this));
        this.nextBtn.setOnClickListener(new ODatePickerView$$ExternalSyntheticLambda3(this));
        this.calendarView.setOnMonthChangedListener(new ODatePickerView$$ExternalSyntheticLambda4(r0, this));
        this.calendarView.setOnDateChangedListener(new ODatePickerView$$ExternalSyntheticLambda5(r0, this));
        this.calendarView.setOnDateLongClickListener(new ODatePickerView$$ExternalSyntheticLambda6(this));
        this.calendarView.setOnRangeSelectedListener(new ODatePickerView$$ExternalSyntheticLambda7(this));
        applyOutOfMonthVisibility();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-0, reason: not valid java name */
    private static final void m411initCalendar$lambda0(ODatePickerView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.calendarView.goToPrevious();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-1, reason: not valid java name */
    private static final void m412initCalendar$lambda1(ODatePickerView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.calendarView.goToNext();
    }

    /* JADX INFO: renamed from: initCalendar$lambda-2, reason: not valid java name */
    private static final void m413initCalendar$lambda2(Calendar r4, ODatePickerView r5, MaterialCalendarView r6, CalendarDay r7) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        OUILogger.INSTANCE.i(TAG, "setOnMonthChangedListener widget:" + r6 + ",date:" + r7);
        r4.set(r7.getYear(), r7.getMonth() - 1, 1);
        long r2 = r4.getTimeInMillis();
        r5.currentDateTextView.setText(r5.formatDate13(r2, r5.dateFormat));
        r5.currentYear = r7.getYear();
        r5.currentMonth = r7.getMonth();
        if (r5.selectDateOnMonthChange == false) goto L5;
        r5.calendarView.setSelectedDate(CalendarDay.from(r7.getYear(), r7.getMonth(), 1));
    L5:
        Intrinsics.checkNotNullExpressionValue(r7, "date");
        r5.syncPicker(r7);
        Function1<? super Long, Unit> r8 = r5.onMonthChangedListener;
        if (r8 == null) goto L10;
        r8.invoke(Long.valueOf(r2));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-3, reason: not valid java name */
    private static final void m414initCalendar$lambda3(Calendar r3, ODatePickerView r4, MaterialCalendarView r5, CalendarDay r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r5, "widget");
        Intrinsics.checkNotNullParameter(r6, "date");
        OUILogger.INSTANCE.i(TAG, "setOnDateChangedListener widget:" + r5 + ",date:" + r6 + ",selected:" + r7);
        r3.set(r6.getYear(), r6.getMonth() - 1, r6.getDay());
        long r0 = r3.getTimeInMillis();
        r4.currentDateTextView.setText(r4.formatDate13(r0, r4.dateFormat));
        r4.currentDayOfMonth = r6.getDay();
        r4.currentYear = r6.getYear();
        r4.currentMonth = r6.getMonth();
        Function1<? super Long, Unit> r8 = r4.onDateChangedListener;
        if (r8 == null) goto L7;
        r8.invoke(Long.valueOf(r0));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-4, reason: not valid java name */
    private static final void m415initCalendar$lambda4(ODatePickerView r2, MaterialCalendarView r3, CalendarDay r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "widget");
        Intrinsics.checkNotNullParameter(r4, "date");
        Function1<? super Long, Unit> r5 = r2.onDateLongClickListener;
        if (r5 == null) goto L7;
        r5.invoke(Long.valueOf(r2.toTimestamp(r4)));
        return;
    }

    /* JADX INFO: renamed from: initCalendar$lambda-6, reason: not valid java name */
    private static final void m416initCalendar$lambda6(ODatePickerView r3, MaterialCalendarView r4, List r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "widget");
        Intrinsics.checkNotNullParameter(r5, "dates");
        Function1<? super List<Long>, Unit> r6 = r3.onRangeSelectedListener;
        if (r6 == null) goto L12;
        List r7 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        CalendarDay r1 = (CalendarDay) r8.next();
        Intrinsics.checkNotNullExpressionValue(r1, "it");
        r0.add(Long.valueOf(r3.toTimestamp(r1)));
        goto L7
    L9:
        r6.invoke(r0);
        return;
    }

    private final void syncPicker(CalendarDay r7) {
        if (this.isSyncingFromPicker == false) goto L6;
        this.isSyncingFromPicker = false;
        return;
    L6:
        KeyEvent.Callback r0 = this.pickerView;
        if ((r0 instanceof OReelPicker) == false) goto L9;
        OReelPicker r1 = (OReelPicker) r0;
    L10:
        if (r1 == null) goto L26;
        int r2 = RangesKt.coerceAtLeast(r7.getYear() - 1900, 0);
        int r8 = RangesKt.coerceIn(r7.getMonth() - 1, 0, 11);
        this.isSyncingFromCalendar = true;
        WheelView r4 = r1.getReelView(0);
        if (r4 != null) goto L16;
    L18:
        WheelView r3 = r1.getReelView(1);
        if (r3 != null) goto L22;
    L24:
        this.isSyncingFromCalendar = false;
        return;
    L22:
        if (r3.getCurrentIndex() == r8) goto L24;
        r3.setCurrentIndex(r8, false);
        goto L24
    L16:
        if (r4.getCurrentIndex() == r2) goto L18;
        r4.setCurrentIndex(r2, false);
        goto L18
    L26:
        return;
    L9:
        r1 = null;
        goto L10
    }

    private final void initYearAndMonthPickerView() {
        OReelDynamicPicker.Builder r0 = new OReelDynamicPicker.Builder();
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        ODatePickerView r8 = this;
        OReelDynamicPicker.Builder r2 = r0.addYear(r1, 1001, 1900, YEAR_TO, Integer.valueOf(this.currentYear), Integer.valueOf(OUnitExtensionKt.vdp(r8, 164)));
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        OReelDynamicPicker.Builder r4 = r2.addMonth(r3, 1002, Integer.valueOf(this.currentMonth), Integer.valueOf(OUnitExtensionKt.vdp(r8, 164)));
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        OReelDynamicPicker.Builder r6 = r4.setWidth(OEAExtensionKt.getScreenWidth(r5)).setHeight(OUnitExtensionKt.vdp(r8, 258));
        r6.setOnChangedListener(new ODatePickerView$$ExternalSyntheticLambda0(this));
        Context r9 = getContext();
        Intrinsics.checkNotNullExpressionValue(r9, "context");
        View r7 = ((OReelDynamicPicker) OReelPickerBuilder.DefaultImpls.build$default(r6, r9, null, 0, 6, null)).asView();
        if (r7 != null) goto L5;
        r7 = null;
    L6:
        this.pickerView = r7;
        this.llOpenYearMonth.setOnClickListener(new ODatePickerView$$ExternalSyntheticLambda1(this));
        return;
    L5:
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, r7.getLayoutParams().height);
        r10.gravity = 17;
        r7.setLayoutParams(r10);
        r7.setAlpha(0.0f);
        r7.setVisibility(4);
        this.flCalendarContainer.addView(r7);
        goto L6
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-13$lambda-12, reason: not valid java name */
    private static final void m417initYearAndMonthPickerView$lambda13$lambda12(final ODatePickerView r3, OReelDynamicPicker.PickedData r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "it");
        Integer r0 = r4.getSelections().get(1001);
        Integer r5 = r4.getSelections().get(1002);
        if (r0 != null) goto L5;
        int r1 = r3.currentYear;
    L6:
        r3.currentYear = r1;
        if (r5 != null) goto L9;
        int r6 = r3.currentMonth;
    L10:
        r3.currentMonth = r6;
        Calendar r7 = Calendar.getInstance();
        final int r2 = r3.currentYear + 1900;
        r7.set(r2, RangesKt.coerceAtLeast(r3.currentMonth, 0), 1);
        String r8 = r3.formatDate13(r7.getTimeInMillis(), r3.dateFormat);
        r3.currentDateTextView.setText(r8);
        if (r3.isSyncingFromCalendar == false) goto L13;
        return;
    L13:
        Runnable r9 = r3.syncCalendarRunnable;
        if (r9 == null) goto L17;
        r3.removeCallbacks(r9);
    L17:
        Runnable r10 = new ODatePickerView$$ExternalSyntheticLambda8(r3, r2);
        r3.syncCalendarRunnable = r10;
        r3.postDelayed(r10, 100);
        return;
    L9:
        r6 = r5.intValue();
        goto L10
    L5:
        r1 = r0.intValue();
        goto L6
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-13$lambda-12$lambda-11, reason: not valid java name */
    private static final void m418initYearAndMonthPickerView$lambda13$lambda12$lambda11(ODatePickerView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.syncCalendar(r2);
    }

    /* JADX INFO: renamed from: initYearAndMonthPickerView$lambda-15, reason: not valid java name */
    private static final void m419initYearAndMonthPickerView$lambda15(ODatePickerView r6, View r7) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        AnimationManager r8 = r6.arrowAnimator;
        if (r8 == null) goto L6;
        AnimationManager.cancelAnimation$default(r8, false, 1, null);
    L6:
        float r9 = r6.ivOpenYearMonth.getRotation();
        float r4 = 0.0f;
        if (r6.isYearMonthOpen == true) goto L9;
        float r3 = 90.0f;
    L10:
        r6.showRotateAnimation(r9, r3);
        boolean r10 = r6.isYearMonthOpen;
        if (r10 == true) goto L13;
        MaterialCalendarView r5 = r6.pickerView;
    L14:
        if (r10 == true) goto L16;
        MaterialCalendarView r11 = r6.calendarView;
    L17:
        AnimationManager r12 = r6.fadeOutAnimator;
        if (r12 == null) goto L21;
        AnimationManager.cancelAnimation$default(r12, false, 1, null);
    L21:
        AnimationManager r13 = r6.fadeInAnimator;
        if (r13 == null) goto L25;
        AnimationManager.cancelAnimation$default(r13, false, 1, null);
    L25:
        ObjectAnimator r0 = r6.alphaOutAnimator;
        if (r0 == null) goto L29;
        r0.cancel();
    L29:
        ObjectAnimator r1 = r6.alphaInAnimator;
        if (r1 == null) goto L33;
        r1.cancel();
    L33:
        if (r11 != null) goto L35;
        float r2 = 1.0f;
    L36:
        if (r5 == null) goto L39;
        r4 = r5.getAlpha();
    L39:
        if (r5 == null) goto L42;
        r5.setAlpha(r4);
    L42:
        if (r11 == null) goto L45;
        r11.setAlpha(r2);
    L45:
        r6.showAlphaAnimation(r2, r11, r5);
        r6.isYearMonthOpen = !r6.isYearMonthOpen;
        return;
    L35:
        r2 = r11.getAlpha();
        goto L36
    L16:
        r11 = r6.pickerView;
        goto L17
    L13:
        r5 = r6.calendarView;
        goto L14
    L9:
        r3 = 0.0f;
        goto L10
    }

    private final void syncCalendar(int r5) {
        if (this.isSyncingFromCalendar == false) goto L5;
        return;
    L5:
        int r0 = this.currentMonth + 1;
        CalendarDay r2 = this.calendarView.getCurrentDate();
        if (r2.getYear() == r5) goto L8;
    L9:
        this.isSyncingFromPicker = true;
        this.calendarView.setCurrentDate(CalendarDay.from(r5, r0, 1));
        return;
    L8:
        if (r2.getMonth() != r0) goto L9;
    }

    private final void applyOutOfMonthVisibility() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.outOfMonthVisibility.ordinal()];
        boolean r1 = false;
        if (r0 != 1) goto L5;
        int r2 = 0;
    L10:
        this.calendarView.setShowOtherDates(r2);
        MaterialCalendarView r3 = this.calendarView;
        if (this.outOfMonthVisibility != OutOfMonthVisibility.GREY) goto L13;
        r1 = true;
    L13:
        r3.setAllowClickDaysOutsideCurrentMonth(r1);
        return;
    L5:
        if (r0 != 2) goto L8;
        r2 = 7;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final MaterialCalendarView getCalendarView() {
        return this.calendarView;
    }

    public final void setOutOfMonthVisibility(OutOfMonthVisibility r2) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        this.outOfMonthVisibility = r2;
        applyOutOfMonthVisibility();
    }

    private final void showRotateAnimation(float r8, float r9) {
        this.arrowAnimator = ValueAnimatable.Builder.of$default(new ValueAnimatable.Builder(), r8, r9, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), null, 8, null).onUpdate(new AnonymousClass1(this)).onEnd(AnonymousClass2.INSTANCE).build().start();
    }

    private final void showAlphaAnimation(float r24, final View r25, final View r26) {
        final float r6 = 1.0f;
        PathInterpolator r3 = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
        if (r25 == null) goto L6;
        r25.setVisibility(0);
    L6:
        if (r26 == null) goto L9;
        r26.setVisibility(0);
    L9:
        AnimationManager r13 = null;
        if (r25 == null) goto L16;
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r25, "alpha", new float[]{r24, 0.0f});
        r14.setDuration(50);
        r14.setInterpolator(r3);
        this.alphaOutAnimator = r14;
        if (r25 != this.pickerView) goto L14;
        final float r8 = 1.05f;
    L15:
        ValueAnimatable.Builder r16 = new ValueAnimatable.Builder();
        FloatSpringSpec r9 = AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r9.setAccuracy(0.001f);
        Unit r15 = Unit.INSTANCE;
        ValueAnimatable r1 = ValueAnimatable.Builder.of$default(r16, 1.0f, r8, r9, null, 8, null).onUpdate(new AnonymousClass3(r25)).onEnd(new AnonymousClass4(r25, r8)).build();
    L17:
        if (r26 == null) goto L23;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r26, "alpha", new float[]{r26.getAlpha(), 1.0f});
        r10.setDuration(200);
        r10.setInterpolator(r3);
        this.alphaInAnimator = r10;
        if (r26 != this.pickerView) goto L21;
        float r4 = 1.05f;
    L22:
        r26.setScaleX(r4);
        r26.setScaleY(r4);
        ValueAnimatable.Builder r17 = new ValueAnimatable.Builder();
        FloatSpringSpec r5 = AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r5.setAccuracy(0.001f);
        Unit r7 = Unit.INSTANCE;
        ValueAnimatable r2 = ValueAnimatable.Builder.of$default(r17, r4, 1.0f, r5, null, 8, null).onUpdate(new AnonymousClass7(r26)).onEnd(new AnonymousClass8(r26, r6)).build();
    L24:
        if (r1 != null) goto L26;
        AnimationManager r11 = null;
    L27:
        this.fadeOutAnimator = r11;
        if (r2 == null) goto L31;
        r13 = r2.start();
    L31:
        this.fadeInAnimator = r13;
        ObjectAnimator r12 = this.alphaOutAnimator;
        if (r12 == null) goto L35;
        r12.start();
    L35:
        ObjectAnimator r0 = this.alphaInAnimator;
        if (r0 == null) goto L40;
        r0.start();
        return;
    L40:
        return;
    L26:
        r11 = r1.start();
        goto L27
    L21:
        r4 = 0.95f;
        goto L22
    L23:
        r2 = null;
        goto L24
    L14:
        r8 = 0.95f;
        goto L15
    L16:
        r1 = null;
        goto L17
    }

    private final void setDefaultDate() {
        Calendar r0 = Calendar.getInstance();
        OUILogger.INSTANCE.i(TAG, "默认选中的时间:" + this.mSelectTime + " , mSelectTime:" + this.mSelectTime);
        r0.setTimeInMillis(this.mSelectTime);
        int r2 = r0.get(1);
        int r4 = r0.get(2) + 1;
        int r1 = r0.get(5);
        int r5 = r0.get(11);
        int r6 = r0.get(12);
        int r7 = r0.get(13);
        int r3 = r0.get(14);
        this.currentDayOfMonth = r1;
        OUILogger.INSTANCE.i(TAG, "转化时间year:" + r2 + ",month:" + r4 + ",day:" + r1 + ",hour:" + r5 + ",minute:" + r6 + ", selectDate:" + CalendarDay.from(r2, r4, r1));
        String r8 = formatDate13(this.mSelectTime, this.dateFormat);
        this.calendarView.setCurrentDate(CalendarDay.from(r2, r4, r1));
        this.calendarView.setSelectedDate(CalendarDay.from(r2, r4, r1));
        this.currentDateTextView.setText(r8);
        setSecond(r7);
        setMillisecond(r3);
    }

    public final long getSelectTimestamp() {
        Calendar r6 = Calendar.getInstance();
        CalendarDay r0 = this.calendarView.getSelectedDates().get(0);
        int r1 = r0.getYear();
        int r2 = r0.getMonth() - 1;
        int r3 = r0.getDay();
        r6.set(13, getSecond());
        r6.set(14, getMillisecond());
        r6.set(r1, r2, r3, 0, 0);
        return r6.getTimeInMillis();
    }

    private final void setSecond(int r1) {
        this.second = r1;
    }

    private final int getSecond() {
        return this.second;
    }

    private final void setMillisecond(int r1) {
        this.millisecond = r1;
    }

    private final int getMillisecond() {
        return this.millisecond;
    }

    private final String formatDate13(long r1, String r3) {
        Date r0 = new Date(r1);
        SimpleDateFormat r2 = new SimpleDateFormat(r3, Locale.getDefault());
        r2.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
        String r4 = r2.format(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "format1.format(date)");
        return r4;
    }

    public final void setCurrentTimeMillis(long r1) {
        this.mSelectTime = r1;
        setDefaultDate();
    }

    public final void setSelectionMode(int r1) {
        this.calendarView.setSelectionMode(r1);
    }

    public final int getSelectionMode() {
        return this.calendarView.getSelectionMode();
    }

    public final void setSelectionColor(int r1) {
        this.calendarView.setSelectionColor(r1);
    }

    public final int getSelectionColor() {
        return this.calendarView.getSelectionColor();
    }

    public final void setDateTextAppearance(int r1) {
        this.calendarView.setDateTextAppearance(r1);
    }

    public final void setWeekDayTextAppearance(int r1) {
        this.calendarView.setWeekDayTextAppearance(r1);
    }

    public final void setDayFormatter(DayFormatter r1) {
        this.calendarView.setDayFormatter(r1);
    }

    public final void setDayFormatterContentDescription(DayFormatter r1) {
        this.calendarView.setDayFormatterContentDescription(r1);
    }

    public final void setWeekDayFormatter(WeekDayFormatter r1) {
        this.calendarView.setWeekDayFormatter(r1);
    }

    public final void setWeekDayLabels(CharSequence[] r2) {
        Intrinsics.checkNotNullParameter(r2, "weekDayLabels");
        this.calendarView.setWeekDayLabels(r2);
    }

    public final void setWeekDayLabels(int r1) {
        this.calendarView.setWeekDayLabels(r1);
    }

    public final void setShowWeekDays(boolean r1) {
        this.calendarView.state().edit().setShowWeekDays(r1).commit();
    }

    public final boolean isShowWeekDays() {
        return this.calendarView.isShowWeekDays();
    }

    public static /* synthetic */ void setCalendarDisplayMode$default(ODatePickerView r0, CalendarMode r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setCalendarDisplayMode(r1, r2);
    }

    public final void setCalendarDisplayMode(CalendarMode r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.calendarView.state().edit().setCalendarDisplayMode(r2).isCacheCalendarPositionEnabled(r3).commit();
    }

    public final CalendarMode getCalendarMode() {
        CalendarMode r1 = this.calendarView.getCalendarMode();
        Intrinsics.checkNotNullExpressionValue(r1, "calendarView.calendarMode");
        return r1;
    }

    public final void setDateRange(CalendarDay r1, CalendarDay r2) {
        this.calendarView.state().edit().setMinimumDate(r1).setMaximumDate(r2).commit();
    }

    public final void setMinimumDate(CalendarDay r1) {
        this.calendarView.state().edit().setMinimumDate(r1).commit();
    }

    public final CalendarDay getMinimumDate() {
        return this.calendarView.getMinimumDate();
    }

    public final void setMaximumDate(CalendarDay r1) {
        this.calendarView.state().edit().setMaximumDate(r1).commit();
    }

    public final CalendarDay getMaximumDate() {
        return this.calendarView.getMaximumDate();
    }

    public final void setShowOtherDates(int r1) {
        this.calendarView.setShowOtherDates(r1);
    }

    public final int getShowOtherDates() {
        return this.calendarView.getShowOtherDates();
    }

    public final void setAllowClickDaysOutsideCurrentMonth(boolean r1) {
        this.calendarView.setAllowClickDaysOutsideCurrentMonth(r1);
    }

    public final boolean allowClickDaysOutsideCurrentMonth() {
        return this.calendarView.allowClickDaysOutsideCurrentMonth();
    }

    public final void setPagingEnabled(boolean r1) {
        this.calendarView.setPagingEnabled(r1);
    }

    public final boolean isPagingEnabled() {
        return this.calendarView.isPagingEnabled();
    }

    public final void setDynamicHeightEnabled(boolean r1) {
        this.calendarView.setDynamicHeightEnabled(r1);
    }

    public final boolean isDynamicHeightEnabled() {
        return this.calendarView.isDynamicHeightEnabled();
    }

    public final void setTileSize(int r1) {
        this.calendarView.setTileSize(r1);
    }

    public final void setTileSizeDp(int r1) {
        this.calendarView.setTileSizeDp(r1);
    }

    public final void setTileWidth(int r1) {
        this.calendarView.setTileWidth(r1);
    }

    public final void setTileWidthDp(int r1) {
        this.calendarView.setTileWidthDp(r1);
    }

    public final int getTileWidth() {
        return this.calendarView.getTileWidth();
    }

    public final void setTileHeight(int r1) {
        this.calendarView.setTileHeight(r1);
    }

    public final void setTileHeightDp(int r1) {
        this.calendarView.setTileHeightDp(r1);
    }

    public final int getTileHeight() {
        return this.calendarView.getTileHeight();
    }

    public final void setTileHSpacing(int r1) {
        this.calendarView.setTileHSpacing(r1);
    }

    public final int getTileHSpacing() {
        return this.calendarView.getTileHSpacing();
    }

    public final void setTileVSpacing(int r1) {
        this.calendarView.setTileVSpacing(r1);
    }

    public final int getTileVSpacing() {
        return this.calendarView.getTileVSpacing();
    }

    public final void setWeekDaysHeight(int r1) {
        this.calendarView.setWeekDaysHeight(r1);
    }

    public final void setWeekDaysHeightDp(int r1) {
        this.calendarView.setWeekDaysHeightDp(r1);
    }

    public final int getWeekDaysHeight() {
        return this.calendarView.getWeekDaysHeight();
    }

    public static /* synthetic */ void setCurrentDate$default(ODatePickerView r0, CalendarDay r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setCurrentDate(r1, r2);
    }

    public final void setCurrentDate(CalendarDay r1, boolean r2) {
        this.calendarView.setCurrentDate(r1, r2);
    }

    public final CalendarDay getCurrentDate() {
        CalendarDay r1 = this.calendarView.getCurrentDate();
        Intrinsics.checkNotNullExpressionValue(r1, "calendarView.currentDate");
        return r1;
    }

    public final void setSelectedDate(CalendarDay r1) {
        this.calendarView.setSelectedDate(r1);
    }

    public final CalendarDay getSelectedDate() {
        return this.calendarView.getSelectedDate();
    }

    public final List<CalendarDay> getSelectedDates() {
        List<CalendarDay> r1 = this.calendarView.getSelectedDates();
        Intrinsics.checkNotNullExpressionValue(r1, "calendarView.selectedDates");
        return r1;
    }

    public final void clearSelection() {
        this.calendarView.clearSelection();
    }

    public final void setDateSelected(CalendarDay r1, boolean r2) {
        this.calendarView.setDateSelected(r1, r2);
    }

    public final void selectRange(CalendarDay r2, CalendarDay r3) {
        Intrinsics.checkNotNullParameter(r2, "firstDay");
        Intrinsics.checkNotNullParameter(r3, "lastDay");
        this.calendarView.selectRange(r2, r3);
    }

    public final void addDecorator(DayViewDecorator r1) {
        this.calendarView.addDecorator(r1);
    }

    public final void addDecorators(Collection<? extends DayViewDecorator> r1) {
        this.calendarView.addDecorators(r1);
    }

    public final void addDecorators(DayViewDecorator... r2) {
        Intrinsics.checkNotNullParameter(r2, "decorators");
        this.calendarView.addDecorators((DayViewDecorator[]) Arrays.copyOf(r2, r2.length));
    }

    public final void removeDecorator(DayViewDecorator r1) {
        this.calendarView.removeDecorator(r1);
    }

    public final void removeDecorators() {
        this.calendarView.removeDecorators();
    }

    public final void invalidateDecorators() {
        this.calendarView.invalidateDecorators();
    }

    public final void setFirstDayOfWeek(DayOfWeek r2) {
        Intrinsics.checkNotNullParameter(r2, "firstDayOfWeek");
        switch(WhenMappings.$EnumSwitchMapping$1[r2.ordinal()]) {
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
        org.threeten.bp.DayOfWeek r3 = org.threeten.bp.DayOfWeek.SATURDAY;
    L13:
        this.calendarView.state().edit().setFirstDayOfWeek(r3).commit();
        return;
    L7:
        r3 = org.threeten.bp.DayOfWeek.FRIDAY;
        goto L13
    L8:
        r3 = org.threeten.bp.DayOfWeek.THURSDAY;
        goto L13
    L9:
        r3 = org.threeten.bp.DayOfWeek.WEDNESDAY;
        goto L13
    L10:
        r3 = org.threeten.bp.DayOfWeek.TUESDAY;
        goto L13
    L11:
        r3 = org.threeten.bp.DayOfWeek.MONDAY;
        goto L13
    L12:
        r3 = org.threeten.bp.DayOfWeek.SUNDAY;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    private final long toTimestamp(CalendarDay r8) {
        Calendar r7 = Calendar.getInstance();
        r7.set(r8.getYear(), r8.getMonth() - 1, r8.getDay(), 0, 0, 0);
        r7.set(14, 0);
        return r7.getTimeInMillis();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        KtExt r0 = KtExt.INSTANCE;
        ViewParent r1 = getParent();
        if (r1 != null) goto L6;
    L4:
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) r1;
        if ((r2 instanceof OSheetContentFrameLayout) == false) goto L35;
        OSheetContentFrameLayout r3 = (OSheetContentFrameLayout) r2;
        if (r3.getId() != R.id.content_container) goto L36;
        int r4 = r3.getPaddingLeft();
        int r5 = r3.getPaddingTop();
        int r6 = r3.getPaddingRight();
        int r7 = r3.getPaddingBottom();
        int r8 = WhenMappings.$EnumSwitchMapping$2[this.datePickerMode.ordinal()];
        if (r8 != 1) goto L14;
        ODatePickerView r12 = this;
        if (r4 == OUnitExtensionKt.vdp(r12, 16)) goto L28;
    L33:
        L.d(TAG, "onAttachedToWindow, we are inside an broad inset sheet, current parent padding: [" + r4 + ", " + r5 + ", " + r6 + ", " + r7 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        r3.setPadding(OUnitExtensionKt.vdp(r12, 16), OUnitExtensionKt.vdp(r12, 6), OUnitExtensionKt.vdp(r12, 16), OUnitExtensionKt.vdp(r12, 16));
        return;
    L28:
        if (r5 != OUnitExtensionKt.vdp(r12, 6)) goto L33;
        if (r6 != OUnitExtensionKt.vdp(r12, 16)) goto L33;
        if (r7 != OUnitExtensionKt.vdp(r12, 16)) goto L33;
        return;
    L14:
        if (r8 != 2) goto L40;
        ODatePickerView r13 = this;
        if (r4 == OUnitExtensionKt.vdp(r13, 0)) goto L19;
    L24:
        L.d(TAG, "onAttachedToWindow, we are inside an narrow inset sheet, current parent padding: [" + r4 + ", " + r5 + ", " + r6 + ", " + r7 + DefaultContactListAdapter.SNIPPET_END_MATCH);
        r3.setPadding(0, 0, 0, 0);
        return;
    L19:
        if (r5 != OUnitExtensionKt.vdp(r13, 0)) goto L24;
        if (r6 != OUnitExtensionKt.vdp(r13, 0)) goto L24;
        if (r7 != OUnitExtensionKt.vdp(r13, 0)) goto L24;
        return;
    L40:
        return;
    L36:
        return;
    L35:
        return;
    L6:
        if ((r1 instanceof ViewGroup) == false) goto L4;
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r0 = this.syncCalendarRunnable;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.syncCalendarRunnable = null;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        String r3 = getResources().getString(R.string.oui_date_picker_date_format);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getString(R.st…_date_picker_date_format)");
        this.dateFormat = r3;
    }
}
