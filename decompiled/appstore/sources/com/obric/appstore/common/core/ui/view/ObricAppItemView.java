package com.obric.appstore.common.core.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bg.h;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.ui.widget.oui.OAppItemView;
import com.bytedanceos.common.ui.widget.oui.ViewExtKt;
import com.obric.appstore.R;
import com.obric.appstore.buss.detail.p;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.layout.OUIConstraintLayout;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.l;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b0\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b \u0010\u001aJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\"\u0010\u001aJ\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0017H\u0016¢\u0006\u0004\b$\u0010\u001aJ\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0017H\u0016¢\u0006\u0004\b&\u0010\u001aJ\u0019\u0010)\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0017H\u0016¢\u0006\u0004\b,\u0010\u001aJ\u000f\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010\rJ\u0017\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u0010\u0016J\u0015\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0017¢\u0006\u0004\b1\u0010\u001aJ\u0017\u00104\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020:H\u0014¢\u0006\u0004\b<\u0010=J#\u0010?\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010>\u001a\u00020'H\u0007¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u000bH\u0014¢\u0006\u0004\bA\u0010\rJ#\u0010B\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u0007H\u0007¢\u0006\u0004\bB\u0010CJ\u0015\u0010E\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u0007¢\u0006\u0004\bE\u0010\u0016J\u0015\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u0017¢\u0006\u0004\bG\u0010\u001aJ\r\u0010I\u001a\u00020H¢\u0006\u0004\bI\u0010JJ\u001d\u0010N\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020K¢\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001a\u00020\u000b2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010K¢\u0006\u0004\bQ\u0010RJ\u0019\u0010S\u001a\u00020\u000b2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bS\u0010RJ\u0015\u0010V\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020T¢\u0006\u0004\bV\u0010WJ'\u0010]\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020X2\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\u000fH\u0016¢\u0006\u0004\b]\u0010^R\u0017\u0010d\u001a\u00020_8\u0006¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0017\u0010j\u001a\u00020e8\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0017\u0010m\u001a\u00020_8\u0006¢\u0006\f\n\u0004\bk\u0010a\u001a\u0004\bl\u0010cR\u0017\u0010p\u001a\u00020_8\u0006¢\u0006\f\n\u0004\bn\u0010a\u001a\u0004\bo\u0010cR\u0017\u0010u\u001a\u00020Z8\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0017\u0010x\u001a\u00020_8\u0006¢\u0006\f\n\u0004\bv\u0010a\u001a\u0004\bw\u0010cR\u0017\u0010{\u001a\u00020_8\u0006¢\u0006\f\n\u0004\by\u0010a\u001a\u0004\bz\u0010cR\u0018\u0010}\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010|R\u001a\u0010\u0082\u0001\u001a\u00020~8\u0006¢\u0006\u000e\n\u0004\b?\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001a\u0010\u0085\u0001\u001a\u00020H8\u0006¢\u0006\u000e\n\u0005\bE\u0010\u0083\u0001\u001a\u0005\b\u0084\u0001\u0010JR\u0019\u0010\u0087\u0001\u001a\u00020Z8\u0006¢\u0006\r\n\u0004\bG\u0010r\u001a\u0005\b\u0086\u0001\u0010tR(\u0010\\\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b\f\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0005\b\u008b\u0001\u0010\u0012R(\u0010>\u001a\u0004\u0018\u00010'8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b\u000e\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0005\b\u008f\u0001\u0010*R\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0091\u0001R\u001a\u0010\u0095\u0001\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b8\u0010\u0091\u0001R\u0019\u0010\u0098\u0001\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0019\u0010\u009b\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009e\u0001\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010¡\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0019\u0010£\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010 \u0001R\u0018\u0010¤\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010 \u0001R\u0019\u0010¦\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010 \u0001R\u0019\u0010¨\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010 \u0001R\u001b\u0010«\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010 \u0001¨\u0006®\u0001"}, d2 = {"Lcom/obric/appstore/common/core/ui/view/ObricAppItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "Lcom/bytedanceos/common/ui/widget/oui/OAppItemView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "l", "()V", "m", "Lcom/bytedanceos/common/model/AppInfo;", ServerElements.INFO, "h", "(Lcom/bytedanceos/common/model/AppInfo;)V", "bindIcon", "position", "bindAppStatus", "(I)V", "", "selected", "setSelected", "(Z)V", "pressed", "setPressed", "enabled", "setEnabled", "changeAlphaWhenPress", "setChangeAlphaWhenPress", "changeAlphaWhenDisable", "setChangeAlphaWhenDisable", "changeAlphaWhenSelected", "setChangeAlphaWhenSelected", "keep", "setKeepPressAlpha", "", "scene", "refreshColors", "(Ljava/lang/String;)V", "disable", "disablePressReleaseAnim", "resetAlphaAnim", "color", "setOverridePressColor", "show", "showLine", "", "number", "setNumber", "(Ljava/lang/Object;)V", "Lcom/obric/appstore/common/core/ui/view/AppItemViewStyle;", "style", "p", "(Lcom/obric/appstore/common/core/ui/view/AppItemViewStyle;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "pageSource", "i", "(Lcom/bytedanceos/common/model/AppInfo;Ljava/lang/String;)V", "onAttachedToWindow", "updateItemView", "(Lcom/bytedanceos/common/model/AppInfo;I)V", Style.KEY_HEIGHT, "j", "display", "k", "Lcom/obric/appstore/common/core/ui/view/ObricAppStatusView;", "getAppStatusView", "()Lcom/obric/appstore/common/core/ui/view/ObricAppStatusView;", "Landroid/view/View$OnClickListener;", "btnClickListener", "itemClickListener", "setOnClickListener", "(Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;)V", "briefClickListener", "setBriefOnClickListener", "(Landroid/view/View$OnClickListener;)V", "setBtnOnClickListener", "", "radius", "setAppIconRadius", "(F)V", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "v", "appInfo", "operateApp", "(Landroid/app/Activity;Landroid/view/View;Lcom/bytedanceos/common/model/AppInfo;)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getVIndex", "()Landroid/widget/TextView;", "vIndex", "Lcom/bytedanceos/common/network/widget/NetworkImageView;", "b", "Lcom/bytedanceos/common/network/widget/NetworkImageView;", "getVIcon", "()Lcom/bytedanceos/common/network/widget/NetworkImageView;", "vIcon", "c", "getVName", "vName", "d", "getVBrief", "vBrief", "e", "Landroid/view/View;", "getVScoreAndSizeContainer", "()Landroid/view/View;", "vScoreAndSizeContainer", "f", "getVScore", "vScore", "g", "getVSize", "vSize", "Lcom/obric/oui/layout/OUIConstraintLayout;", "vPressContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "getVRate", "()Landroid/widget/ImageView;", "vRate", "Lcom/obric/appstore/common/core/ui/view/ObricAppStatusView;", "getVStatus", "vStatus", "getVDivider", "vDivider", "Lcom/bytedanceos/common/model/AppInfo;", "getAppInfo", "()Lcom/bytedanceos/common/model/AppInfo;", "setAppInfo", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "n", "Landroid/view/View$OnClickListener;", "onBtnClickListener", "o", "onBriefClickListener", "onItemClickListener", "q", "Lcom/obric/appstore/common/core/ui/view/AppItemViewStyle;", "viewStyle", "r", "I", "layoutHeight", "s", "F", "appIconRadius", "t", "Z", "isDisplayDeveloper", "u", "changeAlphaWhenPressEnabled", "changeAlphaWhenDisableEnabled", "w", "changeAlphaWhenSelectedEnabled", FixCard.FixStyle.KEY_X, "keepPressAlphaEnabled", FixCard.FixStyle.KEY_Y, "Ljava/lang/Integer;", "overridePressColorValue", "z", "disablePressReleaseAnimEnabled", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nObricAppItemView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObricAppItemView.kt\ncom/obric/appstore/common/core/ui/view/ObricAppItemView\n+ 2 OUnitExtension.kt\ncom/obric/oui/common/util/OUnitExtensionKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,519:1\n189#2,3:520\n188#2,5:523\n181#2,3:529\n180#2,5:532\n181#2,3:540\n180#2,5:543\n181#2,3:551\n180#2,5:554\n181#2,3:559\n180#2,5:562\n181#2,3:567\n180#2,5:570\n181#2,3:575\n180#2,5:578\n181#2,3:583\n180#2,5:586\n181#2,3:591\n180#2,5:594\n181#2,3:608\n180#2,5:611\n181#2,3:616\n180#2,5:619\n181#2,3:627\n180#2,5:630\n181#2,3:635\n180#2,5:638\n181#2,3:652\n180#2,5:655\n181#2,3:660\n180#2,5:663\n181#2,3:671\n180#2,5:674\n181#2,3:679\n180#2,5:682\n181#2,3:687\n180#2,5:690\n181#2,3:695\n180#2,5:698\n181#2,3:703\n180#2,5:706\n181#2,3:720\n180#2,5:723\n181#2,3:728\n180#2,5:731\n181#2,3:739\n180#2,5:742\n181#2,3:747\n180#2,5:750\n181#2,3:755\n180#2,5:758\n181#2,3:763\n180#2,5:766\n181#2,3:771\n180#2,5:774\n1#3:528\n315#4:537\n329#4,2:538\n331#4,2:548\n316#4:550\n315#4:599\n329#4,4:600\n316#4:604\n315#4:605\n329#4,2:606\n331#4,2:624\n316#4:626\n315#4:643\n329#4,4:644\n316#4:648\n315#4:649\n329#4,2:650\n331#4,2:668\n316#4:670\n315#4:711\n329#4,4:712\n316#4:716\n315#4:717\n329#4,2:718\n331#4,2:736\n316#4:738\n*S KotlinDebug\n*F\n+ 1 ObricAppItemView.kt\ncom/obric/appstore/common/core/ui/view/ObricAppItemView\n*L\n81#1:520,3\n81#1:523,5\n308#1:529,3\n308#1:532,5\n311#1:540,3\n311#1:543,5\n316#1:551,3\n316#1:554,5\n317#1:559,3\n317#1:562,5\n318#1:567,3\n318#1:570,5\n321#1:575,3\n321#1:578,5\n322#1:583,3\n322#1:586,5\n323#1:591,3\n323#1:594,5\n341#1:608,3\n341#1:611,5\n342#1:616,3\n342#1:619,5\n346#1:627,3\n346#1:630,5\n347#1:635,3\n347#1:638,5\n364#1:652,3\n364#1:655,5\n365#1:660,3\n365#1:663,5\n369#1:671,3\n369#1:674,5\n370#1:679,3\n370#1:682,5\n371#1:687,3\n371#1:690,5\n374#1:695,3\n374#1:698,5\n375#1:703,3\n375#1:706,5\n389#1:720,3\n389#1:723,5\n390#1:728,3\n390#1:731,5\n394#1:739,3\n394#1:742,5\n395#1:747,3\n395#1:750,5\n396#1:755,3\n396#1:758,5\n399#1:763,3\n399#1:766,5\n400#1:771,3\n400#1:774,5\n310#1:537\n310#1:538,2\n310#1:548,2\n310#1:550\n333#1:599\n333#1:600,4\n333#1:604\n339#1:605\n339#1:606,2\n339#1:624,2\n339#1:626\n356#1:643\n356#1:644,4\n356#1:648\n362#1:649\n362#1:650,2\n362#1:668,2\n362#1:670\n381#1:711\n381#1:712,4\n381#1:716\n387#1:717\n387#1:718,2\n387#1:736,2\n387#1:738\n*E\n"})
public class ObricAppItemView extends OUIConstraintLayout implements OAppItemView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f10892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetworkImageView f10893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f10894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f10895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f10896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f10897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f10898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OUIConstraintLayout f10899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f10900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ObricAppStatusView f10901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f10902k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppInfo f10903l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f10904m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View.OnClickListener f10905n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f10906o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnClickListener f10907p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AppItemViewStyle f10908q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10909r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f10910s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f10911t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10912u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f10913v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10914w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10915x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f10916y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10917z;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10918a = null;

        static {
            int[] r10 = new int[AppItemViewStyle.values().length];
            r10[AppItemViewStyle.PAGER_HOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r10[AppItemViewStyle.LARGE_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r10[AppItemViewStyle.SHOW_INDEX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r10[AppItemViewStyle.APP_INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r10[AppItemViewStyle.DEFAULT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f10918a = r10;
        }
    }

    @JvmOverloads
    public ObricAppItemView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void g(ObricAppItemView r10) {
        n(r10);
    }

    public static final void n(ObricAppItemView r10) {
        q.g(r10, "this$0");
        ViewGroup.LayoutParams r11 = r10.f10902k.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
    L6:
        if (r12 == null) goto L9;
        r12.setMarginStart(r10.f10894c.getLeft());
        r12.setMarginEnd(h.d(r10.getWidth() - r10.f10901j.getRight(), 0));
        r10.f10902k.setLayoutParams(r12);
        return;
    L9:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static /* synthetic */ void o(ObricAppItemView r10, AppInfo r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        r10.updateItemView(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemView");
    }

    public final void bindAppStatus(int r10) {
        AppInfo r11 = this.f10903l;
        if (r11 != null) goto L5;
        return;
    L5:
        this.f10901j.updateDownloadStatus(r11);
        this.f10901j.setTag(r11);
        this.f10901j.setTag(R.id.page_button_pos, Integer.valueOf(r10));
        this.f10901j.setTag(R.id.appinfo, r11);
        this.f10901j.setTag(R.id.app_row_index, Integer.valueOf(r10));
        View.OnClickListener r12 = this.f10905n;
        if (r12 == null) goto L8;
        this.f10901j.setOnClickListener(r12);
    L8:
        View.OnClickListener r13 = this.f10906o;
        if (r13 == null) goto L12;
        this.f10895d.setOnClickListener(r13);
        return;
    }

    public final void bindIcon() {
        AppInfo r10 = this.f10903l;
        if (r10 != null) goto L5;
        return;
    L5:
        this.f10893b.e(r10.appIcon, this.f10910s);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.IOUIAlpha
    public void disablePressReleaseAnim(boolean r10) {
        this.f10917z = r10;
        super.disablePressReleaseAnim(r10);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L6;
        r11.disablePressReleaseAnim(r10);
        return;
    }

    @Nullable
    public final AppInfo getAppInfo() {
        return this.f10903l;
    }

    @NotNull
    public final ObricAppStatusView getAppStatusView() {
        return this.f10901j;
    }

    @Nullable
    public final String getPageSource() {
        return this.f10904m;
    }

    @NotNull
    public final TextView getVBrief() {
        return this.f10895d;
    }

    @NotNull
    public final View getVDivider() {
        return this.f10902k;
    }

    @NotNull
    public final NetworkImageView getVIcon() {
        return this.f10893b;
    }

    @NotNull
    public final TextView getVIndex() {
        return this.f10892a;
    }

    @NotNull
    public final TextView getVName() {
        return this.f10894c;
    }

    @NotNull
    public final ImageView getVRate() {
        return this.f10900i;
    }

    @NotNull
    public final TextView getVScore() {
        return this.f10897f;
    }

    @NotNull
    public final View getVScoreAndSizeContainer() {
        return this.f10896e;
    }

    @NotNull
    public final TextView getVSize() {
        return this.f10898g;
    }

    @NotNull
    public final ObricAppStatusView getVStatus() {
        return this.f10901j;
    }

    public final void h(AppInfo r10) {
        if (this.f10911t == false) goto L5;
        this.f10895d.setText(p.b(r10));
        return;
    L5:
        TextView r11 = this.f10895d;
        String r12 = r10.appBrief;
        String r13 = null;
        if (r12 != null) goto L8;
    L12:
        String r14 = r10.recmd_brief;
        if (r14 != null) goto L15;
    L17:
        if (r13 != null) goto L21;
        r12 = r10.appCategoryName;
        if (r12 != null) goto L22;
        r12 = "";
    L22:
        r11.setText(StringsKt__StringsKt.A0(r12).toString());
        return;
    L21:
        r12 = r13;
        goto L22
    L15:
        if (r14.length() <= 0) goto L17;
        r13 = r14;
        goto L17
    L8:
        if (r12.length() > 0) goto L11;
        r12 = null;
    L11:
        if (r12 != null) goto L22;
        goto L12
    }

    public final void i(AppInfo r10, String r11) {
        q.g(r11, "pageSource");
        o(this, r10, 0, 2, null);
        this.f10904m = r11;
    }

    public final void j(int r10) {
        this.f10909r = r10;
        if (r10 <= 0) goto L6;
        setMinimumHeight(r10);
        return;
    }

    public final void k(boolean r10) {
        this.f10911t = r10;
    }

    public final void l() {
        OUIConstraintLayout r10 = this.f10899h;
        if (r10 == null) goto L9;
        r10.setChangeAlphaWhenPress(this.f10912u);
        r10.setChangeAlphaWhenDisable(this.f10913v);
        r10.setChangeAlphaWhenSelected(this.f10914w);
        r10.setKeepPressAlpha(this.f10915x);
        r10.disablePressReleaseAnim(this.f10917z);
        Integer r11 = this.f10916y;
        if (r11 == null) goto L7;
        r10.setOverridePressColor(r11.intValue());
    L7:
        r10.setEnabled(isEnabled());
        r10.setSelected(isSelected());
        return;
    }

    public final void m() {
        post(new b(this));
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        oe.a.a("appstore_app_item_show", new AnonymousClass1(this));
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        super.onDraw(r10);
    }

    @Override // com.bytedanceos.common.ui.widget.oui.OAppItemView
    public void operateApp(Activity r10, View r11, AppInfo r12) {
        q.g(r10, "activity");
        q.g(r11, "v");
        q.g(r12, "appInfo");
        this.f10901j.operateApp(r10, r11, r12, String.valueOf(this.f10904m));
    }

    public final void p(AppItemViewStyle r10) {
        q.g(r10, "style");
        this.f10908q = r10;
        if (r10 != AppItemViewStyle.LARGE_IMAGE) goto L6;
        this.f10901j.setUseForHomeCard(true);
        return;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.IOUIAlpha
    public void refreshColors(String r10) {
        super.refreshColors(r10);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L6;
        r11.refreshColors(r10);
        return;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.IOUIAlpha
    public void resetAlphaAnim() {
        super.resetAlphaAnim();
        OUIConstraintLayout r10 = this.f10899h;
        if (r10 == null) goto L6;
        r10.resetAlphaAnim();
        return;
    }

    public final void setAppIconRadius(float r10) {
        this.f10910s = r10;
    }

    public final void setAppInfo(@Nullable AppInfo r10) {
        this.f10903l = r10;
    }

    public final void setBriefOnClickListener(@Nullable View.OnClickListener r10) {
        this.f10906o = r10;
        this.f10895d.setOnClickListener(r10);
    }

    public final void setBtnOnClickListener(@Nullable View.OnClickListener r10) {
        this.f10905n = r10;
        this.f10901j.setOnClickListener(r10);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenDisable(boolean r10) {
        this.f10913v = r10;
        super.setChangeAlphaWhenDisable(false);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L6;
        r11.setChangeAlphaWhenDisable(r10);
        return;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenPress(boolean r10) {
        this.f10912u = r10;
        super.setChangeAlphaWhenPress(false);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L6;
        r11.setChangeAlphaWhenPress(r10);
        return;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.IOUIAlpha
    public void setChangeAlphaWhenSelected(boolean r10) {
        this.f10914w = r10;
        super.setChangeAlphaWhenSelected(false);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L6;
        r11.setChangeAlphaWhenSelected(r10);
        return;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L7;
        r11.setEnabled(r10);
        return;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.IOUIAlpha
    public void setKeepPressAlpha(boolean r10) {
        this.f10915x = r10;
        super.setKeepPressAlpha(r10);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L6;
        r11.setKeepPressAlpha(r10);
        return;
    }

    public final void setNumber(@Nullable Object r10) {
        if (r10 != null) goto L6;
        this.f10892a.setVisibility(8);
        return;
    L6:
        String r11 = r10.toString();
        if (o.r(r11) == false) goto L10;
        this.f10892a.setVisibility(8);
        return;
    L10:
        this.f10892a.setVisibility(0);
        this.f10892a.setText(r11);
        m();
    }

    public final void setOnClickListener(View.OnClickListener r10, View.OnClickListener r11) {
        q.g(r10, "btnClickListener");
        q.g(r11, "itemClickListener");
        this.f10905n = r10;
        this.f10907p = r11;
        setOnClickListener(r11);
        this.f10901j.setOnClickListener(this.f10905n);
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, com.obric.oui.common.style.IOUIAlpha
    public void setOverridePressColor(int r10) {
        this.f10916y = Integer.valueOf(r10);
        super.setOverridePressColor(r10);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L6;
        r11.setOverridePressColor(r10);
        return;
    }

    public final void setPageSource(@Nullable String r10) {
        this.f10904m = r10;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, android.view.View
    public void setPressed(boolean r10) {
        super.setPressed(r10);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isPressed() == r10) goto L9;
        r11.setPressed(r10);
        return;
    }

    @Override // com.obric.oui.layout.OUIConstraintLayout, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        OUIConstraintLayout r11 = this.f10899h;
        if (r11 == null) goto L6;
        r11.setSelected(r10);
    L6:
        OUIConstraintLayout r12 = this.f10899h;
        if (r12 == null) goto L10;
        IOUIAlpha r13 = r12.getAlphaHelper();
        q.e(r13, "null cannot be cast to non-null type com.obric.oui.common.style.OUIAlphaHelper");
        ((OUIAlphaHelper) r13).onSelectedChanged(r12, r10);
        return;
    }

    public final void showLine(boolean r10) {
        l.p(this.f10902k, r10);
    }

    public final void updateItemView(AppInfo r13, int r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        this.f10903l = r13;
        setTag(R.id.appinfo, r13);
        View.OnClickListener r10 = this.f10907p;
        if (r10 == null) goto L7;
        setOnClickListener(r10);
    L7:
        int r11 = a.f10918a[this.f10908q.ordinal()];
        boolean r12 = false;
        ConstraintLayout.LayoutParams r15 = null;
        if (r11 == 1) goto L142;
        if (r11 != 2) goto L12;
        float r16 = 0;
        setPadding(yf.b.b(TypedValue.applyDimension(1, r16, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r16, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r16, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r16, Resources.getSystem().getDisplayMetrics())));
        ViewGroup.LayoutParams r17 = this.f10901j.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L126;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
    L128:
        if (r18 == null) goto L131;
        r18.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, 14, Resources.getSystem().getDisplayMetrics())));
    L131:
        ViewGroup.LayoutParams r19 = this.f10893b.getLayoutParams();
        if ((r19 instanceof ConstraintLayout.LayoutParams) == false) goto L134;
        r15 = (ConstraintLayout.LayoutParams) r19;
    L134:
        if (r15 == null) goto L137;
        r15.A = yf.b.b(TypedValue.applyDimension(1, 14, Resources.getSystem().getDisplayMetrics()));
    L137:
        OUIConstraintLayout r20 = this.f10899h;
        if (r20 == null) goto L140;
        r20.setBackgroundColor(0);
    L140:
        this.f10894c.setTextColor(getContext().getColor(R.color.oui_on_accent_text_1));
        this.f10895d.setTextColor(getContext().getColor(R.color.oui_on_accent_text_3));
        this.f10901j.v(AppStatusBtnStyle.ACCENT);
    L163:
        float r21 = r13.appScores;
        if (r21 > 0.0f) goto L167;
        r21 = 1.0f;
    L167:
        TextView r22 = this.f10897f;
        x r23 = x.f21192a;
        String r24 = getContext().getString(R.string.format_app_score);
        q.f(r24, "getString(...)");
        String r25 = String.format(r24, Arrays.copyOf(new Object[]{String.valueOf(r21)}, 1));
        q.f(r25, "format(...)");
        r22.setText(r25);
        this.f10898g.setText(SizeConverter.BTrim.convert(r13.appBytes));
        com.obric.appstore.util.d r26 = com.obric.appstore.util.d.f11069a;
        Context r27 = getContext();
        q.f(r27, "getContext(...)");
        if (this.f10908q != AppItemViewStyle.LARGE_IMAGE) goto L170;
        r12 = true;
    L170:
        this.f10900i.setImageResource(r26.e(r27, r21, r12));
        h(r13);
        this.f10894c.setText(r13.appName);
        bindAppStatus(r14);
        bindIcon();
        m();
        return;
    L126:
        r18 = null;
        goto L128
    L12:
        if (r11 == 3) goto L89;
        if (r11 == 4) goto L54;
        if (r11 != 5) goto L163;
        if (getLayoutParams() != null) goto L21;
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
    L24:
        int r28 = this.f10909r;
        if (r28 <= 0) goto L27;
        setMinimumHeight(r28);
    L27:
        ViewGroup.LayoutParams r29 = getLayoutParams();
        if (r29 == null) goto L50;
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == false) goto L32;
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
    L33:
        if (r30 == null) goto L35;
        float r31 = 12;
        r30.setMarginStart(yf.b.b(TypedValue.applyDimension(1, r31, Resources.getSystem().getDisplayMetrics())));
        r30.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, r31, Resources.getSystem().getDisplayMetrics())));
    L35:
        setLayoutParams(r29);
        float r32 = 0;
        setPadding(yf.b.b(TypedValue.applyDimension(1, r32, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r32, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r32, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r32, Resources.getSystem().getDisplayMetrics())));
        ViewGroup.LayoutParams r33 = this.f10901j.getLayoutParams();
        if ((r33 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r34 = (ViewGroup.MarginLayoutParams) r33;
    L39:
        if (r34 == null) goto L42;
        r34.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
    L42:
        ViewGroup.LayoutParams r35 = this.f10893b.getLayoutParams();
        if ((r35 instanceof ConstraintLayout.LayoutParams) == false) goto L45;
        r15 = (ConstraintLayout.LayoutParams) r35;
    L45:
        if (r15 == null) goto L48;
        r15.A = yf.b.b(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
    L48:
        this.f10894c.setTextColor(getContext().getColor(R.color.oui_text_0));
        this.f10895d.setTextColor(getContext().getColor(R.color.oui_text_3));
        ViewGroup.LayoutParams r36 = this.f10896e.getLayoutParams();
        q.e(r36, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        float r37 = 3;
        ((ViewGroup.MarginLayoutParams) r36).topMargin = yf.b.b(TypedValue.applyDimension(1, r37, Resources.getSystem().getDisplayMetrics()));
        ViewGroup.LayoutParams r38 = this.f10895d.getLayoutParams();
        q.e(r38, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r38).topMargin = yf.b.b(TypedValue.applyDimension(1, r37, Resources.getSystem().getDisplayMetrics()));
        goto L163
    L38:
        r34 = null;
        goto L39
    L32:
        r30 = null;
        goto L33
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L21:
        ViewGroup.LayoutParams r39 = getLayoutParams();
        if (r39 == null) goto L52;
        r39.width = -1;
        r39.height = -2;
        setLayoutParams(r39);
        goto L24
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L54:
        if (getLayoutParams() != null) goto L56;
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
    L59:
        int r40 = this.f10909r;
        if (r40 <= 0) goto L62;
        setMinimumHeight(r40);
    L62:
        ViewGroup.LayoutParams r41 = getLayoutParams();
        if (r41 == null) goto L85;
        if ((r41 instanceof ViewGroup.MarginLayoutParams) == false) goto L67;
        ViewGroup.MarginLayoutParams r42 = (ViewGroup.MarginLayoutParams) r41;
    L68:
        if (r42 == null) goto L70;
        float r43 = 8;
        r42.setMarginStart(yf.b.b(TypedValue.applyDimension(1, r43, Resources.getSystem().getDisplayMetrics())));
        r42.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, r43, Resources.getSystem().getDisplayMetrics())));
    L70:
        setLayoutParams(r41);
        float r44 = 0;
        setPadding(yf.b.b(TypedValue.applyDimension(1, r44, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r44, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r44, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r44, Resources.getSystem().getDisplayMetrics())));
        ViewGroup.LayoutParams r45 = this.f10901j.getLayoutParams();
        if ((r45 instanceof ViewGroup.MarginLayoutParams) == false) goto L73;
        ViewGroup.MarginLayoutParams r46 = (ViewGroup.MarginLayoutParams) r45;
    L74:
        if (r46 == null) goto L77;
        r46.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
    L77:
        ViewGroup.LayoutParams r47 = this.f10893b.getLayoutParams();
        if ((r47 instanceof ConstraintLayout.LayoutParams) == false) goto L80;
        r15 = (ConstraintLayout.LayoutParams) r47;
    L80:
        if (r15 == null) goto L83;
        r15.A = yf.b.b(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
    L83:
        this.f10894c.setTextColor(getContext().getColor(R.color.oui_text_1));
        this.f10895d.setTextColor(getContext().getColor(R.color.oui_text_3));
        ViewGroup.LayoutParams r48 = this.f10896e.getLayoutParams();
        q.e(r48, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        float r49 = 3;
        ((ViewGroup.MarginLayoutParams) r48).topMargin = yf.b.b(TypedValue.applyDimension(1, r49, Resources.getSystem().getDisplayMetrics()));
        ViewGroup.LayoutParams r50 = this.f10895d.getLayoutParams();
        q.e(r50, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r50).topMargin = yf.b.b(TypedValue.applyDimension(1, r49, Resources.getSystem().getDisplayMetrics()));
        goto L163
    L73:
        r46 = null;
        goto L74
    L67:
        r42 = null;
        goto L68
    L85:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L56:
        ViewGroup.LayoutParams r51 = getLayoutParams();
        if (r51 == null) goto L87;
        r51.width = -1;
        r51.height = -2;
        setLayoutParams(r51);
        goto L59
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L89:
        if (getLayoutParams() != null) goto L91;
        setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
    L94:
        int r52 = this.f10909r;
        if (r52 <= 0) goto L97;
        setMinimumHeight(r52);
    L97:
        ViewGroup.LayoutParams r53 = getLayoutParams();
        if (r53 == null) goto L120;
        if ((r53 instanceof ViewGroup.MarginLayoutParams) == false) goto L102;
        ViewGroup.MarginLayoutParams r54 = (ViewGroup.MarginLayoutParams) r53;
    L103:
        if (r54 == null) goto L105;
        float r55 = 12;
        r54.setMarginStart(yf.b.b(TypedValue.applyDimension(1, r55, Resources.getSystem().getDisplayMetrics())));
        r54.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, r55, Resources.getSystem().getDisplayMetrics())));
    L105:
        setLayoutParams(r53);
        float r56 = 0;
        setPadding(yf.b.b(TypedValue.applyDimension(1, r56, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r56, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r56, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r56, Resources.getSystem().getDisplayMetrics())));
        ViewGroup.LayoutParams r57 = this.f10901j.getLayoutParams();
        if ((r57 instanceof ViewGroup.MarginLayoutParams) == false) goto L108;
        ViewGroup.MarginLayoutParams r58 = (ViewGroup.MarginLayoutParams) r57;
    L109:
        if (r58 == null) goto L112;
        r58.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
    L112:
        ViewGroup.LayoutParams r59 = this.f10893b.getLayoutParams();
        if ((r59 instanceof ConstraintLayout.LayoutParams) == false) goto L115;
        r15 = (ConstraintLayout.LayoutParams) r59;
    L115:
        if (r15 == null) goto L118;
        r15.A = 0;
    L118:
        this.f10894c.setTextColor(getContext().getColor(R.color.oui_text_0));
        this.f10895d.setTextColor(getContext().getColor(R.color.oui_text_3));
        goto L163
    L108:
        r58 = null;
        goto L109
    L102:
        r54 = null;
        goto L103
    L120:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L91:
        ViewGroup.LayoutParams r60 = getLayoutParams();
        if (r60 == null) goto L122;
        r60.width = -1;
        r60.height = -2;
        setLayoutParams(r60);
        goto L94
    L122:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L142:
        if (getLayoutParams() != null) goto L144;
        setLayoutParams(new ConstraintLayout.LayoutParams(defpackage.b.f5914a.c(getContext()) - yf.b.b(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())), -2));
    L147:
        int r61 = this.f10909r;
        if (r61 <= 0) goto L150;
        setMinimumHeight(r61);
    L150:
        float r62 = 0;
        setPadding(yf.b.b(TypedValue.applyDimension(1, r62, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r62, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r62, Resources.getSystem().getDisplayMetrics())), yf.b.b(TypedValue.applyDimension(1, r62, Resources.getSystem().getDisplayMetrics())));
        ViewGroup.LayoutParams r63 = this.f10901j.getLayoutParams();
        if ((r63 instanceof ViewGroup.MarginLayoutParams) == false) goto L153;
        ViewGroup.MarginLayoutParams r64 = (ViewGroup.MarginLayoutParams) r63;
    L154:
        if (r64 == null) goto L157;
        r64.setMarginEnd(yf.b.b(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
    L157:
        ViewGroup.LayoutParams r65 = this.f10893b.getLayoutParams();
        if ((r65 instanceof ConstraintLayout.LayoutParams) == false) goto L160;
        r15 = (ConstraintLayout.LayoutParams) r65;
    L160:
        if (r15 == null) goto L163;
        r15.A = yf.b.b(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        goto L163
    L153:
        r64 = null;
        goto L154
    L144:
        ViewGroup.LayoutParams r66 = getLayoutParams();
        if (r66 == null) goto L173;
        r66.width = defpackage.b.f5914a.c(getContext()) - yf.b.b(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics()));
        r66.height = -2;
        setLayoutParams(r66);
        goto L147
    L173:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmOverloads
    public ObricAppItemView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ ObricAppItemView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public ObricAppItemView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        this.f10908q = AppItemViewStyle.DEFAULT;
        this.f10909r = -2;
        this.f10910s = TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics());
        this.f10912u = true;
        this.f10913v = true;
        LayoutInflater.from(r10).inflate(R.layout.obric_app_item_view, this);
        this.f10899h = (OUIConstraintLayout) ViewExtKt.findView(this, R.id.press_container);
        this.f10892a = (TextView) ViewExtKt.findView(this, R.id.app_index);
        this.f10893b = (NetworkImageView) ViewExtKt.findView(this, R.id.appIcon);
        this.f10894c = (TextView) ViewExtKt.findView(this, R.id.appName);
        this.f10895d = (TextView) ViewExtKt.findView(this, R.id.appBrief);
        this.f10900i = (ImageView) ViewExtKt.findView(this, R.id.appRate);
        this.f10901j = (ObricAppStatusView) ViewExtKt.findView(this, R.id.appStatusLay);
        this.f10902k = ViewExtKt.findView(this, R.id.line);
        this.f10897f = (TextView) ViewExtKt.findView(this, R.id.app_score);
        this.f10898g = (TextView) ViewExtKt.findView(this, R.id.app_size);
        this.f10896e = ViewExtKt.findView(this, R.id.score_and_app_size_container);
        setRadius(0);
        OUIConstraintLayout r13 = this.f10899h;
        if (r13 == null) goto L6;
        r13.setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
    L6:
        l();
    }
}
