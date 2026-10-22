package com.stepos.agentframework.uikit;

import C8.e;
import I8.a;
import Yb.AbstractC1128b;
import Z8.C1172u;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.Target;
import com.stepos.agentframework.uikit.MarkwonHelper;
import com.stepos.ailauncher.chat.view.M8;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.a;
import io.noties.markwon.core.spans.LinkSpan;
import io.noties.markwon.image.h;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.text.Regex;
import net.sqlcipher.database.SQLiteDatabase;
import p7.AppUI;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t0.C5502d;
import u8.AbstractC5589a;
import u8.e;
import u8.g;
import u8.i;
import u8.k;
import u8.m;
import v8.C5671a;
import v9.C5685n;
import y8.C5961i;
import z8.C6377a;

@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0003\b\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:!\u009f\u0002 \u0002¡\u0002¢\u0002£\u0002¤\u0002\u0017¥\u0002¦\u0002§\u0002¨\u0002©\u0002ª\u0002\u001c«\u00025¬\u0002\u00ad\u0002B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0004\b%\u0010&J/\u0010,\u001a\u00020+2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0011H\u0007¢\u0006\u0004\b,\u0010-J3\u00102\u001a\u0002012\u0006\u0010'\u001a\u00020\u00042\u0006\u0010.\u001a\u00020+2\b\b\u0002\u0010/\u001a\u00020\u00192\b\b\u0002\u00100\u001a\u00020\u0019H\u0007¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0007¢\u0006\u0004\b8\u0010\u0018J\u0017\u0010:\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0011H\u0002¢\u0006\u0004\b:\u0010\u0018J\u0017\u0010=\u001a\u00020<2\u0006\u0010;\u001a\u00020\u0019H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u0019H\u0002¢\u0006\u0004\b?\u0010\u001fJ\u0017\u0010@\u001a\u00020<2\u0006\u0010;\u001a\u00020\u0019H\u0002¢\u0006\u0004\b@\u0010>J\u001f\u0010B\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0019H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020E2\u0006\u0010D\u001a\u00020\u0011H\u0007¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u0011H\u0007¢\u0006\u0004\bI\u0010\u0018J\u0017\u0010K\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u000eH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\b2\u0006\u00109\u001a\u00020+H\u0007¢\u0006\u0004\bM\u0010NJ\u001f\u0010R\u001a\u00020\b2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u0011H\u0007¢\u0006\u0004\bR\u0010SJ\u001f\u0010T\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020O2\u0006\u0010Q\u001a\u00020\u0011H\u0007¢\u0006\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u0010WR(\u0010X\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bX\u0010W\u0012\u0004\b]\u0010\u0003\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R(\u0010^\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b^\u0010_\u0012\u0004\bb\u0010\u0003\u001a\u0004\b_\u0010`\"\u0004\ba\u0010\u001dR(\u0010c\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bc\u0010_\u0012\u0004\bf\u0010\u0003\u001a\u0004\bd\u0010`\"\u0004\be\u0010\u001dR(\u0010g\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bg\u0010_\u0012\u0004\bj\u0010\u0003\u001a\u0004\bh\u0010`\"\u0004\bi\u0010\u001dR(\u0010k\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bk\u0010_\u0012\u0004\bn\u0010\u0003\u001a\u0004\bl\u0010`\"\u0004\bm\u0010\u001dR(\u0010o\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bo\u0010_\u0012\u0004\br\u0010\u0003\u001a\u0004\bp\u0010`\"\u0004\bq\u0010\u001dR(\u0010s\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bs\u0010_\u0012\u0004\bv\u0010\u0003\u001a\u0004\bt\u0010`\"\u0004\bu\u0010\u001dR(\u0010w\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bw\u0010_\u0012\u0004\bz\u0010\u0003\u001a\u0004\bx\u0010`\"\u0004\by\u0010\u001dR(\u0010{\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b{\u0010_\u0012\u0004\b~\u0010\u0003\u001a\u0004\b|\u0010`\"\u0004\b}\u0010\u001dR+\u0010\u007f\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001b\n\u0004\b\u007f\u0010_\u0012\u0005\b\u0082\u0001\u0010\u0003\u001a\u0005\b\u0080\u0001\u0010`\"\u0005\b\u0081\u0001\u0010\u001dR-\u0010\u0083\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u0083\u0001\u0010_\u0012\u0005\b\u0086\u0001\u0010\u0003\u001a\u0005\b\u0084\u0001\u0010`\"\u0005\b\u0085\u0001\u0010\u001dR0\u0010\u0087\u0001\u001a\u00020<8\u0006@\u0006X\u0087\u000e¢\u0006\u001f\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u0012\u0005\b\u008d\u0001\u0010\u0003\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R-\u0010\u008e\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u008e\u0001\u0010_\u0012\u0005\b\u0091\u0001\u0010\u0003\u001a\u0005\b\u008f\u0001\u0010`\"\u0005\b\u0090\u0001\u0010\u001dR-\u0010\u0092\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u0092\u0001\u0010_\u0012\u0005\b\u0094\u0001\u0010\u0003\u001a\u0005\b\u0088\u0001\u0010`\"\u0005\b\u0093\u0001\u0010\u001dR-\u0010\u0095\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u0095\u0001\u0010_\u0012\u0005\b\u0098\u0001\u0010\u0003\u001a\u0005\b\u0096\u0001\u0010`\"\u0005\b\u0097\u0001\u0010\u001dR-\u0010\u0099\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u0099\u0001\u0010_\u0012\u0005\b\u009c\u0001\u0010\u0003\u001a\u0005\b\u009a\u0001\u0010`\"\u0005\b\u009b\u0001\u0010\u001dR-\u0010\u009d\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u009d\u0001\u0010_\u0012\u0005\b \u0001\u0010\u0003\u001a\u0005\b\u009e\u0001\u0010`\"\u0005\b\u009f\u0001\u0010\u001dR-\u0010¡\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b¡\u0001\u0010_\u0012\u0005\b¤\u0001\u0010\u0003\u001a\u0005\b¢\u0001\u0010`\"\u0005\b£\u0001\u0010\u001dR-\u0010¥\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b¥\u0001\u0010_\u0012\u0005\b¨\u0001\u0010\u0003\u001a\u0005\b¦\u0001\u0010`\"\u0005\b§\u0001\u0010\u001dR-\u0010©\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b©\u0001\u0010_\u0012\u0005\b¬\u0001\u0010\u0003\u001a\u0005\bª\u0001\u0010`\"\u0005\b«\u0001\u0010\u001dR-\u0010\u00ad\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u00ad\u0001\u0010_\u0012\u0005\b°\u0001\u0010\u0003\u001a\u0005\b®\u0001\u0010`\"\u0005\b¯\u0001\u0010\u001dR-\u0010±\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b±\u0001\u0010_\u0012\u0005\b´\u0001\u0010\u0003\u001a\u0005\b²\u0001\u0010`\"\u0005\b³\u0001\u0010\u001dR-\u0010µ\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bµ\u0001\u0010_\u0012\u0005\b¸\u0001\u0010\u0003\u001a\u0005\b¶\u0001\u0010`\"\u0005\b·\u0001\u0010\u001dR-\u0010¹\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b¹\u0001\u0010_\u0012\u0005\b¼\u0001\u0010\u0003\u001a\u0005\bº\u0001\u0010`\"\u0005\b»\u0001\u0010\u001dR-\u0010½\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b½\u0001\u0010_\u0012\u0005\bÀ\u0001\u0010\u0003\u001a\u0005\b¾\u0001\u0010`\"\u0005\b¿\u0001\u0010\u001dR-\u0010Á\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bÁ\u0001\u0010_\u0012\u0005\bÄ\u0001\u0010\u0003\u001a\u0005\bÂ\u0001\u0010`\"\u0005\bÃ\u0001\u0010\u001dR-\u0010Å\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bÅ\u0001\u0010_\u0012\u0005\bÈ\u0001\u0010\u0003\u001a\u0005\bÆ\u0001\u0010`\"\u0005\bÇ\u0001\u0010\u001dR\u0016\u0010É\u0001\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0007\n\u0005\bÉ\u0001\u0010_R-\u0010Ê\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bÊ\u0001\u0010_\u0012\u0005\bÍ\u0001\u0010\u0003\u001a\u0005\bË\u0001\u0010`\"\u0005\bÌ\u0001\u0010\u001dR-\u0010Î\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bÎ\u0001\u0010_\u0012\u0005\bÑ\u0001\u0010\u0003\u001a\u0005\bÏ\u0001\u0010`\"\u0005\bÐ\u0001\u0010\u001dR-\u0010Ò\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bÒ\u0001\u0010_\u0012\u0005\bÕ\u0001\u0010\u0003\u001a\u0005\bÓ\u0001\u0010`\"\u0005\bÔ\u0001\u0010\u001dRR\u0010Ø\u0001\u001a$\u0012\u0004\u0012\u00020O\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00110×\u0001\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001b\u0018\u00010Ö\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u001f\n\u0006\bØ\u0001\u0010Ù\u0001\u0012\u0005\bÞ\u0001\u0010\u0003\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R\u0016\u0010ß\u0001\u001a\u00020\u00198\u0006X\u0086T¢\u0006\u0007\n\u0005\bß\u0001\u0010_R-\u0010à\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bà\u0001\u0010_\u0012\u0005\bã\u0001\u0010\u0003\u001a\u0005\bá\u0001\u0010`\"\u0005\bâ\u0001\u0010\u001dR-\u0010ä\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bä\u0001\u0010_\u0012\u0005\bç\u0001\u0010\u0003\u001a\u0005\bå\u0001\u0010`\"\u0005\bæ\u0001\u0010\u001dR-\u0010è\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bè\u0001\u0010_\u0012\u0005\bë\u0001\u0010\u0003\u001a\u0005\bé\u0001\u0010`\"\u0005\bê\u0001\u0010\u001dR-\u0010ì\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bì\u0001\u0010_\u0012\u0005\bï\u0001\u0010\u0003\u001a\u0005\bí\u0001\u0010`\"\u0005\bî\u0001\u0010\u001dR-\u0010ð\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bð\u0001\u0010_\u0012\u0005\bó\u0001\u0010\u0003\u001a\u0005\bñ\u0001\u0010`\"\u0005\bò\u0001\u0010\u001dR-\u0010ô\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bô\u0001\u0010_\u0012\u0005\b÷\u0001\u0010\u0003\u001a\u0005\bõ\u0001\u0010`\"\u0005\bö\u0001\u0010\u001dR-\u0010ø\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bø\u0001\u0010_\u0012\u0005\bû\u0001\u0010\u0003\u001a\u0005\bù\u0001\u0010`\"\u0005\bú\u0001\u0010\u001dR-\u0010ü\u0001\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\bü\u0001\u0010_\u0012\u0005\bÿ\u0001\u0010\u0003\u001a\u0005\bý\u0001\u0010`\"\u0005\bþ\u0001\u0010\u001dR-\u0010\u0080\u0002\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u0080\u0002\u0010_\u0012\u0005\b\u0083\u0002\u0010\u0003\u001a\u0005\b\u0081\u0002\u0010`\"\u0005\b\u0082\u0002\u0010\u001dR-\u0010\u0084\u0002\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u0084\u0002\u0010_\u0012\u0005\b\u0087\u0002\u0010\u0003\u001a\u0005\b\u0085\u0002\u0010`\"\u0005\b\u0086\u0002\u0010\u001dR-\u0010\u0088\u0002\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u0088\u0002\u0010_\u0012\u0005\b\u008b\u0002\u0010\u0003\u001a\u0005\b\u0089\u0002\u0010`\"\u0005\b\u008a\u0002\u0010\u001dR,\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u008c\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0002\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002R\u001b\u0010\u0093\u0002\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0002\u0010\u0094\u0002R\u001e\u0010\u0096\u0002\u001a\t\u0012\u0004\u0012\u00020\u00110\u0095\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R\u0016\u0010\u0098\u0002\u001a\u00020\u00198\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0098\u0002\u0010_R'\u0010\u009a\u0002\u001a\u00030\u0099\u00028\u0006X\u0087\u0004¢\u0006\u0017\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u0012\u0005\b\u009e\u0002\u0010\u0003\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002¨\u0006®\u0002"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper;", "", "<init>", "()V", "Landroid/content/Context;", "ctx", "Landroid/widget/TextView;", "textView", "", "showImage", "useRecyclerTablePlugin", "Lkotlin/Function0;", "includeFirstHeadingTopGap", "Lkotlin/Function1;", "LYb/u;", "isSupplementaryParagraph", "Ljava/util/function/Consumer;", "", "copyCodeCallback", "Lu8/e;", "Z", "(Landroid/content/Context;Landroid/widget/TextView;ZZLp9/a;Lp9/l;Ljava/util/function/Consumer;)Lu8/e;", "literal", "o", "(Ljava/lang/String;)Ljava/lang/String;", "", "textColor", "LY8/t;", "n", "(I)V", "h0", "(I)I", "hollow", "i0", "(IZ)I", "Lcom/stepos/agentframework/uikit/MarkwonHelper$q;", "configurator", "y0", "(Lcom/stepos/agentframework/uikit/MarkwonHelper$q;)V", "context", "markwon", "language", "source", "", "f0", "(Landroid/content/Context;Lu8/e;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;", "body", "gutterWidthDp", "gutterPaddingDp", "Landroid/text/Spanned;", "A0", "(Landroid/content/Context;Ljava/lang/CharSequence;II)Landroid/text/Spanned;", "LC8/e;", "p", "()LC8/e;", "markdown", "j0", "text", "k0", UxipConstants.f30680s, "", "s", "(I)F", "r", "x0", "attr", "p0", "(Landroid/content/Context;I)I", "family", "Landroid/graphics/Typeface;", "z0", "(Ljava/lang/String;)Landroid/graphics/Typeface;", "heading", "w0", "node", "g0", "(LYb/u;)I", "v0", "(Ljava/lang/CharSequence;)Z", "Landroid/view/View;", "view", "link", "o0", "(Landroid/view/View;Ljava/lang/String;)Z", "q0", "(Landroid/view/View;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "fallbackLanguage", "getFallbackLanguage", "()Ljava/lang/String;", "setFallbackLanguage", "(Ljava/lang/String;)V", "getFallbackLanguage$annotations", "codeBlockHeaderBackground", "I", "()I", "setCodeBlockHeaderBackground", "getCodeBlockHeaderBackground$annotations", "codeBlockHeaderHeightDp", "K", "setCodeBlockHeaderHeightDp", "getCodeBlockHeaderHeightDp$annotations", "codeBlockHeaderPaddingDp", "L", "setCodeBlockHeaderPaddingDp", "getCodeBlockHeaderPaddingDp$annotations", "codeBlockHeaderDivider", "getCodeBlockHeaderDivider", "setCodeBlockHeaderDivider", "getCodeBlockHeaderDivider$annotations", "codeBlockLangLabelColor", "M", "setCodeBlockLangLabelColor", "getCodeBlockLangLabelColor$annotations", "codeBlockLangLabelSizeSp", "O", "setCodeBlockLangLabelSizeSp", "getCodeBlockLangLabelSizeSp$annotations", "codeBlockBackground", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setCodeBlockBackground", "getCodeBlockBackground$annotations", "codeBlockTextColor", ExifInterface.LATITUDE_SOUTH, "setCodeBlockTextColor", "getCodeBlockTextColor$annotations", "codeBlockRadiusDp", "R", "setCodeBlockRadiusDp", "getCodeBlockRadiusDp$annotations", "codeBlockBorderColor", "D", "setCodeBlockBorderColor", "getCodeBlockBorderColor$annotations", "codeBlockBorderWidthDp", "F", ExifInterface.LONGITUDE_EAST, "()F", "setCodeBlockBorderWidthDp", "(F)V", "getCodeBlockBorderWidthDp$annotations", "codeBlockBodyVPaddingDp", "C", "setCodeBlockBodyVPaddingDp", "getCodeBlockBodyVPaddingDp$annotations", "codeBlockCodeTopMarginDp", "setCodeBlockCodeTopMarginDp", "getCodeBlockCodeTopMarginDp$annotations", "codeBlockLineNumberColor", "P", "setCodeBlockLineNumberColor", "getCodeBlockLineNumberColor$annotations", "codeBlockLineNumberColorNight", "getCodeBlockLineNumberColorNight", "setCodeBlockLineNumberColorNight", "getCodeBlockLineNumberColorNight$annotations", "codeBlockLineNumberSizeSp", "Q", "setCodeBlockLineNumberSizeSp", "getCodeBlockLineNumberSizeSp$annotations", "codeBlockGutterWidthDp", "H", "setCodeBlockGutterWidthDp", "getCodeBlockGutterWidthDp$annotations", "codeBlockGutterPaddingDp", "G", "setCodeBlockGutterPaddingDp", "getCodeBlockGutterPaddingDp$annotations", "plainCodeGutterWidthDp", "getPlainCodeGutterWidthDp", "setPlainCodeGutterWidthDp", "getPlainCodeGutterWidthDp$annotations", "plainCodeGutterPaddingDp", "getPlainCodeGutterPaddingDp", "setPlainCodeGutterPaddingDp", "getPlainCodeGutterPaddingDp$annotations", "bodyTextColor", "getBodyTextColor", "setBodyTextColor", "getBodyTextColor$annotations", "listBulletColor", "Y", "setListBulletColor", "getListBulletColor$annotations", "bulletDotColorLevel1", "w", "setBulletDotColorLevel1", "getBulletDotColorLevel1$annotations", "bulletDotColorLevel2", "x", "setBulletDotColorLevel2", "getBulletDotColorLevel2$annotations", "bulletDotSizeDp", "z", "setBulletDotSizeDp", "getBulletDotSizeDp$annotations", "bulletDotHollowInnerDp", "y", "setBulletDotHollowInnerDp", "getBulletDotHollowInnerDp$annotations", "BULLET_NESTED_DOT_ALPHA", "taskListCheckboxColor", "getTaskListCheckboxColor", "setTaskListCheckboxColor", "getTaskListCheckboxColor$annotations", "blockQuoteColor", "t", "setBlockQuoteColor", "getBlockQuoteColor$annotations", "linkColor", "X", "t0", "getLinkColor$annotations", "Lkotlin/Function3;", "", "imagePreviewLauncher", "Lp9/q;", ExifInterface.LONGITUDE_WEST, "()Lp9/q;", "s0", "(Lp9/q;)V", "getImagePreviewLauncher$annotations", "DEFAULT_THEMATIC_BREAK_COLOR", "thematicBreakColor", "d0", "u0", "getThematicBreakColor$annotations", "blockSpacingContentDp", "getBlockSpacingContentDp", "setBlockSpacingContentDp", "getBlockSpacingContentDp$annotations", "blockSpacingListItemDp", "u", "setBlockSpacingListItemDp", "getBlockSpacingListItemDp$annotations", "blockSpacingSectionDp", "v", "setBlockSpacingSectionDp", "getBlockSpacingSectionDp$annotations", "codeBlockHeaderBackgroundNight", "J", "setCodeBlockHeaderBackgroundNight", "getCodeBlockHeaderBackgroundNight$annotations", "codeBlockBackgroundNight", "B", "setCodeBlockBackgroundNight", "getCodeBlockBackgroundNight$annotations", "codeBlockLangLabelColorNight", "N", "setCodeBlockLangLabelColorNight", "getCodeBlockLangLabelColorNight$annotations", "codeBlockTextColorNight", ExifInterface.GPS_DIRECTION_TRUE, "setCodeBlockTextColorNight", "getCodeBlockTextColorNight$annotations", "codeInlineTextColorNight", "U", "setCodeInlineTextColorNight", "getCodeInlineTextColorNight$annotations", "codeInlineBackgroundColor", "getCodeInlineBackgroundColor", "setCodeInlineBackgroundColor", "getCodeInlineBackgroundColor$annotations", "codeInlineBackgroundColorNight", "getCodeInlineBackgroundColorNight", "setCodeInlineBackgroundColorNight", "getCodeInlineBackgroundColorNight$annotations", "Lcom/stepos/agentframework/uikit/z;", "glideAsyncDrawableLoader", "Lcom/stepos/agentframework/uikit/z;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Lcom/stepos/agentframework/uikit/z;", "r0", "(Lcom/stepos/agentframework/uikit/z;)V", "themeConfigurator", "Lcom/stepos/agentframework/uikit/MarkwonHelper$q;", "", "PLAIN_TEXT_CODE_LANGS", "Ljava/util/Set;", "LINKIFY_MAX_CHARS", "Ljava/util/regex/Pattern;", "urlLinkPattern", "Ljava/util/regex/Pattern;", "e0", "()Ljava/util/regex/Pattern;", "getUrlLinkPattern$annotations", Const.INTENT_KEY_PKGNAME, "q", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "m", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, "e", "BareUrlLinkSpan", "k", "l", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MarkwonHelper {
    private static final int BULLET_NESTED_DOT_ALPHA = 115;
    public static final int LINKIFY_MAX_CHARS = 32768;
    public static final String TAG = "MarkwonHelper";
    private static int codeBlockBodyVPaddingDp;
    private static int codeBlockHeaderDivider;
    private static C2151z glideAsyncDrawableLoader;
    private static p9.q<? super View, ? super List<String>, ? super Integer, Y8.t> imagePreviewLauncher;
    private static volatile q themeConfigurator;
    private static final Pattern urlLinkPattern;
    public static final MarkwonHelper INSTANCE = new MarkwonHelper();
    private static String fallbackLanguage = "javascript";
    private static int codeBlockHeaderBackground = 1308622847;
    private static int codeBlockHeaderHeightDp = 40;
    private static int codeBlockHeaderPaddingDp = 16;
    private static int codeBlockLangLabelColor = -16777216;
    private static int codeBlockLangLabelSizeSp = 16;
    private static int codeBlockBackground = 654311423;
    private static int codeBlockTextColor = -14407378;
    private static int codeBlockRadiusDp = 12;
    private static int codeBlockBorderColor = 335544320;
    private static float codeBlockBorderWidthDp = 0.5f;
    private static int codeBlockCodeTopMarginDp = 16;
    private static int codeBlockLineNumberColor = -5196358;
    private static int codeBlockLineNumberColorNight = 1944841205;
    private static int codeBlockLineNumberSizeSp = 12;
    private static int codeBlockGutterWidthDp = 24;
    private static int codeBlockGutterPaddingDp = 12;
    private static int plainCodeGutterWidthDp = 32;
    private static int plainCodeGutterPaddingDp = 16;
    private static int bodyTextColor = -1118482;
    private static int listBulletColor = -1118482;
    private static int bulletDotColorLevel1 = -1118482;
    private static int bulletDotColorLevel2 = 1945038574;
    private static int bulletDotSizeDp = 4;
    private static int bulletDotHollowInnerDp = 2;
    private static int taskListCheckboxColor = -1;
    private static int blockQuoteColor = 872415231;
    private static int linkColor = -1118482;
    public static final int DEFAULT_THEMATIC_BREAK_COLOR = 870770406;
    private static int thematicBreakColor = DEFAULT_THEMATIC_BREAK_COLOR;
    private static int blockSpacingContentDp = 12;
    private static int blockSpacingListItemDp = 4;
    private static int blockSpacingSectionDp = 24;
    private static int codeBlockHeaderBackgroundNight = 527725696;
    private static int codeBlockBackgroundNight = 352321535;
    private static int codeBlockLangLabelColorNight = -1;
    private static int codeBlockTextColorNight = -1118482;
    private static int codeInlineTextColorNight = -1118482;
    private static int codeInlineBackgroundColor = M8.SCRIM_COLOR;
    private static int codeInlineBackgroundColorNight = 863270016;
    private static final Set<String> PLAIN_TEXT_CODE_LANGS = Z8.Y.j("text", "txt", "plain", "plaintext", "none");

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$A", "Lu8/a;", "Lu8/k$a;", "builder", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lu8/k$a;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class A extends AbstractC5589a {
        /* JADX INFO: Access modifiers changed from: private */
        public static final Object m(u8.g configuration, u8.r props) {
            kotlin.jvm.internal.p.i(configuration, "configuration");
            kotlin.jvm.internal.p.i(props, "props");
            String strD = io.noties.markwon.image.g.f34287a.d(props);
            kotlin.jvm.internal.p.h(strD, "require(...)");
            C5671a c5671aG = configuration.g();
            u8.c cVarD = configuration.d();
            kotlin.jvm.internal.p.h(cVarD, "linkResolver(...)");
            return new LinkSpan(c5671aG, strD, new k(cVarD));
        }

        @Override // u8.AbstractC5589a, u8.i
        public void a(k.a builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            builder.b(Yb.o.class, new u8.u() { // from class: com.stepos.agentframework.uikit.f0
                @Override // u8.u
                public final Object a(u8.g gVar, u8.r rVar) {
                    return MarkwonHelper.A.m(gVar, rVar);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$BareUrlLinkSpan;", "Lio/noties/markwon/core/spans/LinkSpan;", "Lv8/a;", "theme", "", "link", "Lu8/c;", "resolver", "<init>", "(Lv8/a;Ljava/lang/String;Lu8/c;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "LY8/t;", "updateDrawState", "(Landroid/text/TextPaint;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BareUrlLinkSpan extends LinkSpan {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BareUrlLinkSpan(C5671a theme, String link, u8.c resolver) {
            super(theme, link, resolver);
            kotlin.jvm.internal.p.i(theme, "theme");
            kotlin.jvm.internal.p.i(link, "link");
            kotlin.jvm.internal.p.i(resolver, "resolver");
        }

        @Override // io.noties.markwon.core.spans.LinkSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
            super.updateDrawState(ds);
            ds.setUnderlineText(true);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$a;", "Lu8/a;", "Lkotlin/Function0;", "", "applyFirstH1TopGap", "Lkotlin/Function1;", "LYb/u;", "isSupplementaryParagraph", "<init>", "(Lp9/a;Lp9/l;)V", "Lu8/m$b;", "builder", "LY8/t;", "c", "(Lu8/m$b;)V", "Lp9/a;", "Lp9/l;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.uikit.MarkwonHelper$a, reason: case insensitive filesystem */
    public static final class C2126a extends AbstractC5589a {
        private final InterfaceC5063a<Boolean> applyFirstH1TopGap;
        private final InterfaceC5074l<Yb.u, Boolean> isSupplementaryParagraph;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.uikit.MarkwonHelper$a$a, reason: collision with other inner class name */
        public static final class C0256a<N extends Yb.u> implements m.c {
            public static final C0256a<N> INSTANCE = new C0256a<>();

            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void a(u8.m visitor, Yb.t listItem) {
                kotlin.jvm.internal.p.i(visitor, "visitor");
                kotlin.jvm.internal.p.i(listItem, "listItem");
                int length = visitor.length();
                visitor.g(listItem);
                AbstractC1128b abstractC1128bF = listItem.f();
                if (abstractC1128bF instanceof Yb.v) {
                    CoreProps.f34200a.e(visitor.r(), CoreProps.ListItemType.ORDERED);
                    Yb.v vVar = (Yb.v) abstractC1128bF;
                    CoreProps.f34202c.e(visitor.r(), Integer.valueOf(vVar.q()));
                    vVar.s(vVar.q() + 1);
                } else {
                    CoreProps.f34200a.e(visitor.r(), CoreProps.ListItemType.BULLET);
                    CoreProps.f34201b.e(visitor.r(), Integer.valueOf(MarkwonHelper.INSTANCE.g0(listItem)));
                }
                visitor.F(listItem, length);
                if (visitor.h(listItem)) {
                    visitor.C();
                    u8.v vVarBuilder = visitor.builder();
                    kotlin.jvm.internal.p.h(vVarBuilder, "builder(...)");
                    int length2 = vVarBuilder.length();
                    vVarBuilder.append('\n');
                    vVarBuilder.j(new i(MarkwonHelper.INSTANCE.r(MarkdownBlockSpacing.INSTANCE.g(listItem))), length2, vVarBuilder.length(), 17);
                }
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.uikit.MarkwonHelper$a$b */
        public static final class b<N extends Yb.u> implements m.c {
            public static final b<N> INSTANCE = new b<>();

            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void a(u8.m visitor, B8.b taskListItem) {
                kotlin.jvm.internal.p.i(visitor, "visitor");
                kotlin.jvm.internal.p.i(taskListItem, "taskListItem");
                int length = visitor.length();
                visitor.g(taskListItem);
                B8.e.f1472a.e(visitor.r(), Boolean.valueOf(taskListItem.n()));
                visitor.b(taskListItem, length);
                if (visitor.h(taskListItem)) {
                    visitor.C();
                    u8.v vVarBuilder = visitor.builder();
                    kotlin.jvm.internal.p.h(vVarBuilder, "builder(...)");
                    int length2 = vVarBuilder.length();
                    vVarBuilder.append('\n');
                    vVarBuilder.j(new i(MarkwonHelper.INSTANCE.r(MarkdownBlockSpacing.INSTANCE.g(taskListItem))), length2, vVarBuilder.length(), 17);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C2126a(InterfaceC5063a<Boolean> applyFirstH1TopGap, InterfaceC5074l<? super Yb.u, Boolean> isSupplementaryParagraph) {
            kotlin.jvm.internal.p.i(applyFirstH1TopGap, "applyFirstH1TopGap");
            kotlin.jvm.internal.p.i(isSupplementaryParagraph, "isSupplementaryParagraph");
            this.applyFirstH1TopGap = applyFirstH1TopGap;
            this.isSupplementaryParagraph = isSupplementaryParagraph;
        }

        @Override // u8.AbstractC5589a, u8.i
        public void c(m.b builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            builder.b(new o(this.applyFirstH1TopGap, this.isSupplementaryParagraph));
            builder.a(Yb.t.class, C0256a.INSTANCE);
            builder.a(B8.b.class, b.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\u00020\u00102\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$b;", "LI8/a$b;", "Landroid/content/Context;", "context", "", "showImage", "<init>", "(Landroid/content/Context;Z)V", "Lio/noties/markwon/image/a;", "drawable", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_PKGNAME, "(Lio/noties/markwon/image/a;)Lcom/bumptech/glide/RequestBuilder;", "Lcom/bumptech/glide/request/target/Target;", "target", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/bumptech/glide/request/target/Target;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Z", "getShowImage", "()Z", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements a.b {
        private Context context;
        private final boolean showImage;

        public b(Context context, boolean z10) {
            kotlin.jvm.internal.p.i(context, "context");
            this.context = context;
            this.showImage = z10;
        }

        @Override // I8.a.b
        public void a(Target<?> target) {
            kotlin.jvm.internal.p.i(target, "target");
            Glide.with(this.context).clear(target);
        }

        @Override // I8.a.b
        public RequestBuilder<Drawable> b(io.noties.markwon.image.a drawable) {
            kotlin.jvm.internal.p.i(drawable, "drawable");
            C4148a.k(MarkwonHelper.TAG, "load: " + drawable.b(), false, 4, null);
            if (!this.showImage) {
                Cloneable cloneablePlaceholder = Glide.with(this.context).load("").placeholder(R$drawable.agent_image_erro_placeholder);
                kotlin.jvm.internal.p.f(cloneablePlaceholder);
                return (RequestBuilder) cloneablePlaceholder;
            }
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with(this.context).load(O6.j.a(drawable.b()));
            int i10 = R$drawable.agent_image_erro_placeholder;
            Cloneable cloneableError = requestBuilderLoad.placeholder(i10).error(i10);
            kotlin.jvm.internal.p.f(cloneableError);
            return (RequestBuilder) cloneableError;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012Jg\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u0014\u0010\"\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$c;", "Landroid/text/style/LineHeightSpan;", "Landroid/text/style/LineBackgroundSpan;", "Lv8/a;", "theme", "<init>", "(Lv8/a;)V", "", "text", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "spanstartv", "lineHeight", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "LY8/t;", "chooseHeight", "(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/Paint;", "p", "left", "right", "top", "baseline", "bottom", "lineNumber", "drawBackground", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;III)V", Const.INTENT_KEY_APIKEY, "()I", "Lv8/a;", "paint", "Landroid/graphics/Paint;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements LineHeightSpan, LineBackgroundSpan {
        private final Paint paint;
        private final C5671a theme;

        public c(C5671a theme) {
            kotlin.jvm.internal.p.i(theme, "theme");
            this.theme = theme;
            this.paint = new Paint();
        }

        public final int a() {
            this.paint.reset();
            this.theme.i(this.paint);
            return C5685n.f((int) (this.paint.getStrokeWidth() + 0.5f), 1);
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(fm, "fm");
            int i10 = -a();
            fm.ascent = i10;
            fm.top = i10;
            fm.descent = 0;
            fm.bottom = 0;
        }

        @Override // android.text.style.LineBackgroundSpan
        public void drawBackground(Canvas canvas, Paint p10, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lineNumber) {
            kotlin.jvm.internal.p.i(canvas, "canvas");
            kotlin.jvm.internal.p.i(p10, "p");
            kotlin.jvm.internal.p.i(text, "text");
            this.paint.set(p10);
            this.theme.i(this.paint);
            float f10 = C5685n.f((int) (this.paint.getStrokeWidth() + 0.5f), 1) / 2.0f;
            float f11 = (top + bottom) / 2.0f;
            canvas.drawRect(left, f11 - f10, right, f11 + f10, this.paint);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$d;", "Landroid/text/style/ClickableSpan;", "Ljava/util/function/Consumer;", "", "copyCodeCallback", "<init>", "(Ljava/util/function/Consumer;)V", "Landroid/view/View;", AppUI.TYPE_WIDGET, "LY8/t;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", Const.SP_KEY_DEVICE_SENSORS, "updateDrawState", "(Landroid/text/TextPaint;)V", "Ljava/util/function/Consumer;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ClickableSpan {
        private final Consumer<String> copyCodeCallback;

        public d(Consumer<String> copyCodeCallback) {
            kotlin.jvm.internal.p.i(copyCodeCallback, "copyCodeCallback");
            this.copyCodeCallback = copyCodeCallback;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.p.i(widget, "widget");
            TextView textView = widget instanceof TextView ? (TextView) widget : null;
            Object text = textView != null ? textView.getText() : null;
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            if (spanned == null) {
                return;
            }
            this.copyCodeCallback.accept(La.H.D1(spanned.subSequence(spanned.getSpanStart(this), spanned.getSpanEnd(this)).toString()).toString());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            kotlin.jvm.internal.p.i(ds, "ds");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$e;", "Lu8/a;", "<init>", "()V", "Lu8/i$b;", "registry", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lu8/i$b;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends AbstractC5589a {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a<P extends u8.i> implements i.a {
            public static final a<P> INSTANCE = new a<>();

            public static final void d(u8.m visitor, String text, int i10) {
                kotlin.jvm.internal.p.i(visitor, "visitor");
                kotlin.jvm.internal.p.i(text, "text");
                if (MarkwonHelper.v0(text)) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
                    if (A0.b.b(spannableStringBuilder, MarkwonHelper.e0(), null)) {
                        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
                        if (uRLSpanArr == null || uRLSpanArr.length == 0) {
                            return;
                        }
                        u8.g gVarZ = visitor.z();
                        kotlin.jvm.internal.p.h(gVarZ, "configuration(...)");
                        u8.v vVarBuilder = visitor.builder();
                        kotlin.jvm.internal.p.h(vVarBuilder, "builder(...)");
                        for (URLSpan uRLSpan : uRLSpanArr) {
                            C5671a c5671aG = gVarZ.g();
                            kotlin.jvm.internal.p.h(c5671aG, "theme(...)");
                            String url = uRLSpan.getURL();
                            kotlin.jvm.internal.p.h(url, "getURL(...)");
                            u8.c cVarD = gVarZ.d();
                            kotlin.jvm.internal.p.h(cVarD, "linkResolver(...)");
                            u8.v.k(vVarBuilder, new BareUrlLinkSpan(c5671aG, url, cVarD), spannableStringBuilder.getSpanStart(uRLSpan) + i10, spannableStringBuilder.getSpanEnd(uRLSpan) + i10);
                        }
                    }
                }
            }

            @Override // u8.i.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final void a(io.noties.markwon.core.a corePlugin) {
                kotlin.jvm.internal.p.i(corePlugin, "corePlugin");
                corePlugin.o(new a.p() { // from class: com.stepos.agentframework.uikit.Z
                    @Override // io.noties.markwon.core.a.p
                    public final void a(u8.m mVar, String str, int i10) {
                        MarkwonHelper.e.a.d(mVar, str, i10);
                    }
                });
            }
        }

        @Override // u8.AbstractC5589a, u8.i
        public void i(i.b registry) {
            kotlin.jvm.internal.p.i(registry, "registry");
            registry.b(io.noties.markwon.core.a.class, a.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$f;", "Lu8/a;", "", "isNight", "<init>", "(Z)V", "Lv8/a$a;", "builder", "LY8/t;", "k", "(Lv8/a$a;)V", "Z", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends AbstractC5589a {
        private final boolean isNight;

        public f(boolean z10) {
            this.isNight = z10;
        }

        @Override // u8.AbstractC5589a, u8.i
        public void k(C5671a.C0540a builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            C5671a.C0540a c0540aE = builder.Q(MarkwonHelper.X()).P(true).I(this.isNight ? MarkwonHelper.U() : MarkwonHelper.S()).C(1).F(this.isNight ? MarkwonHelper.T() : MarkwonHelper.S()).D(1).E(0);
            Typeface typeface = Typeface.MONOSPACE;
            C5671a.C0540a c0540aH = c0540aE.K(typeface).H(typeface);
            MarkwonHelper markwonHelper = MarkwonHelper.INSTANCE;
            c0540aH.J((int) markwonHelper.x0(13)).G((int) markwonHelper.x0(12)).x(markwonHelper.r(16)).y(MarkwonHelper.t()).z(markwonHelper.r(3)).R(MarkwonHelper.Y()).L(0).M(0).O(MarkwonHelper.z0(C2145t.b())).N(new float[]{1.25f, 1.125f, 1.0625f, 1.0f, 1.0f, 1.0f}).S(MarkwonHelper.d0()).T(markwonHelper.r(1));
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJo\u0010 \u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010#R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010%R\u0014\u0010&\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$g;", "Landroid/text/style/LeadingMarginSpan;", "Lv8/a;", "theme", "", "fallbackColor", "sizePx", "", "hollow", "", "strokePx", "<init>", "(Lv8/a;IIZF)V", AMapLocationStaticsEntity.FIRST_LOCATE, "getLeadingMargin", "(Z)I", "Landroid/graphics/Canvas;", "c", "Landroid/graphics/Paint;", "p", "x", Const.JSON_KEY_DIR, "top", "baseline", "bottom", "", "text", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "Landroid/text/Layout;", "layout", "LY8/t;", "drawLeadingMargin", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V", "Lv8/a;", "I", "Z", "F", "paint", "Landroid/graphics/Paint;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements LeadingMarginSpan {
        private final boolean hollow;
        private final Paint paint;
        private final int sizePx;
        private final float strokePx;
        private final C5671a theme;

        public g(C5671a theme, int i10, int i11, boolean z10, float f10) {
            kotlin.jvm.internal.p.i(theme, "theme");
            this.theme = theme;
            this.sizePx = i11;
            this.hollow = z10;
            this.strokePx = f10;
            Paint paint = new Paint(1);
            paint.setColor(i10);
            if (z10) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(f10);
            } else {
                paint.setStyle(Paint.Style.FILL);
            }
            this.paint = paint;
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas c10, Paint p10, int x10, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
            kotlin.jvm.internal.p.i(c10, "c");
            kotlin.jvm.internal.p.i(p10, "p");
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(layout, "layout");
            if (((Spanned) text).getSpanStart(this) != start) {
                return;
            }
            this.paint.setColor(MarkwonHelper.INSTANCE.i0(p10.getColor(), this.hollow));
            c10.drawCircle(x10 + ((dir * this.theme.k()) / 2.0f), baseline + ((p10.ascent() + p10.descent()) / 2.0f), (this.hollow ? this.sizePx - this.strokePx : this.sizePx) / 2.0f, this.paint);
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean first) {
            return this.theme.k();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$h;", "Lu8/a;", "", "headerBackground", "bodyBackground", "langLabelColor", "", "renderHeader", "isNight", "<init>", "(IIIZZ)V", "Lu8/m$b;", "builder", "LY8/t;", "c", "(Lu8/m$b;)V", "I", "Z", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h extends AbstractC5589a {
        private final int bodyBackground;
        private final int headerBackground;
        private final boolean isNight;
        private final int langLabelColor;
        private final boolean renderHeader;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a<N extends Yb.u> implements m.c {
            public a() {
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00e6  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0149  */
            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(u8.m r19, Yb.j r20) {
                /*
                    Method dump skipped, instructions count: 488
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.uikit.MarkwonHelper.h.a.a(u8.m, Yb.j):void");
            }
        }

        public h(int i10, int i11, int i12, boolean z10, boolean z11) {
            this.headerBackground = i10;
            this.bodyBackground = i11;
            this.langLabelColor = i12;
            this.renderHeader = z10;
            this.isNight = z11;
        }

        @Override // u8.AbstractC5589a, u8.i
        public void c(m.b builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            builder.a(Yb.j.class, new a());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$i;", "Landroid/text/style/LineHeightSpan;", "", "heightPx", "<init>", "(I)V", "", "text", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "spanstartv", "lineHeight", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "LY8/t;", "chooseHeight", "(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V", "I", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i implements LineHeightSpan {
        private final int heightPx;

        public i(int i10) {
            this.heightPx = i10;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
            kotlin.jvm.internal.p.i(text, "text");
            kotlin.jvm.internal.p.i(fm, "fm");
            int i10 = this.heightPx;
            fm.ascent = -i10;
            fm.top = -i10;
            fm.descent = 0;
            fm.bottom = 0;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$j;", "LB8/f;", "Lv8/a;", "theme", "Landroid/graphics/drawable/Drawable;", "drawable", "", "isDone", "<init>", "(Lv8/a;Landroid/graphics/drawable/Drawable;Z)V", AMapLocationStaticsEntity.FIRST_LOCATE, "", "getLeadingMargin", "(Z)I", "extendedLeadingMargin", "I", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class j extends B8.f {
        private final int extendedLeadingMargin;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(C5671a theme, Drawable drawable, boolean z10) {
            super(theme, drawable, z10);
            kotlin.jvm.internal.p.i(theme, "theme");
            kotlin.jvm.internal.p.i(drawable, "drawable");
            int iK = theme.k();
            int i10 = (int) ((iK * 0.75f) + 0.5f);
            this.extendedLeadingMargin = ((iK - i10) / 2) + i10 + ((iK / 2) - (MarkwonHelper.INSTANCE.r(MarkwonHelper.z()) / 2));
        }

        @Override // B8.f, android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean first) {
            return this.extendedLeadingMargin;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$k;", "Lu8/c;", "original", "<init>", "(Lu8/c;)V", "Landroid/view/View;", "view", "", "link", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Ljava/lang/String;)V", "Lcom/stepos/agentframework/uikit/AIMDTextView;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)Lcom/stepos/agentframework/uikit/AIMDTextView;", "Lu8/c;", "getOriginal", "()Lu8/c;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class k implements u8.c {
        private final u8.c original;

        public k(u8.c original) {
            kotlin.jvm.internal.p.i(original, "original");
            this.original = original;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
        @Override // u8.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(android.view.View r4, java.lang.String r5) {
            /*
                r3 = this;
                java.lang.String r0 = "view"
                kotlin.jvm.internal.p.i(r4, r0)
                java.lang.String r0 = "link"
                kotlin.jvm.internal.p.i(r5, r0)
                com.stepos.agentframework.uikit.j0 r0 = com.stepos.agentframework.uikit.j0.INSTANCE
                boolean r1 = r0.e(r5)
                if (r1 == 0) goto L1c
                u8.c r3 = r3.original
                java.lang.String r5 = r0.b(r5)
                r3.a(r4, r5)
                return
            L1c:
                p9.q r0 = com.stepos.agentframework.uikit.MarkwonHelper.W()
                if (r0 != 0) goto L23
                return
            L23:
                com.stepos.agentframework.uikit.AIMDTextView r3 = r3.b(r4)
                r1 = 0
                if (r3 == 0) goto L3e
                java.util.List r3 = r3.Y()
                if (r3 == 0) goto L3e
                r2 = r3
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L3a
                goto L3b
            L3a:
                r3 = r1
            L3b:
                if (r3 == 0) goto L3e
                goto L42
            L3e:
                java.util.List r3 = Z8.C1172u.e(r5)
            L42:
                int r5 = r3.indexOf(r5)
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                int r2 = r5.intValue()
                if (r2 < 0) goto L51
                r1 = r5
            L51:
                if (r1 == 0) goto L58
                int r5 = r1.intValue()
                goto L59
            L58:
                r5 = 0
            L59:
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.invoke(r4, r3, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.uikit.MarkwonHelper.k.a(android.view.View, java.lang.String):void");
        }

        public final AIMDTextView b(View view) {
            while (view != null && !(view instanceof AIMDTextView)) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view instanceof AIMDTextView) {
                return (AIMDTextView) view;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$l;", "Lio/noties/markwon/image/j;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lio/noties/markwon/image/h$a;", "dimension", "", "original", "", "textSize", Const.INTENT_KEY_PKGNAME, "(Lio/noties/markwon/image/h$a;IF)I", "Lio/noties/markwon/image/h;", "imageSize", "Landroid/graphics/Rect;", "imageBounds", "canvasWidth", "c", "(Lio/noties/markwon/image/h;Landroid/graphics/Rect;IF)Landroid/graphics/Rect;", "Landroid/content/Context;", Const.INTENT_KEY_UMID, "()Landroid/content/Context;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class l extends io.noties.markwon.image.j {
        private final Context context;

        public l(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            this.context = context;
        }

        @Override // io.noties.markwon.image.j
        public int b(h.a dimension, int original, float textSize) {
            kotlin.jvm.internal.p.i(dimension, "dimension");
            return kotlin.jvm.internal.p.d("dp", dimension.f34293b) ? (int) TypedValue.applyDimension(1, dimension.f34292a, this.context.getResources().getDisplayMetrics()) : super.b(dimension, original, textSize);
        }

        @Override // io.noties.markwon.image.j
        public Rect c(io.noties.markwon.image.h imageSize, Rect imageBounds, int canvasWidth, float textSize) {
            kotlin.jvm.internal.p.i(imageBounds, "imageBounds");
            Rect rectC = super.c(imageSize, imageBounds, canvasWidth, textSize);
            kotlin.jvm.internal.p.h(rectC, "resolveImageSize(...)");
            return rectC;
        }

        /* renamed from: d, reason: from getter */
        public final Context getContext() {
            return this.context;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$m;", "Landroid/text/style/MetricAffectingSpan;", "Lv8/a;", "theme", "<init>", "(Lv8/a;)V", "Landroid/text/TextPaint;", "textPaint", "LY8/t;", "updateMeasureState", "(Landroid/text/TextPaint;)V", "updateDrawState", "paint", Const.INTENT_KEY_APIKEY, "Lv8/a;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class m extends MetricAffectingSpan {
        private final C5671a theme;

        public m(C5671a theme) {
            kotlin.jvm.internal.p.i(theme, "theme");
            this.theme = theme;
        }

        public final void a(TextPaint paint) {
            this.theme.c(paint);
            paint.bgColor = 0;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            kotlin.jvm.internal.p.i(textPaint, "textPaint");
            a(textPaint);
        }

        @Override // android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            kotlin.jvm.internal.p.i(textPaint, "textPaint");
            a(textPaint);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$n;", "Lu8/a;", "<init>", "()V", "Lu8/m$b;", "builder", "LY8/t;", "c", "(Lu8/m$b;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class n extends AbstractC5589a {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a<N extends Yb.u> implements m.c {
            public static final a<N> INSTANCE = new a<>();

            @Override // u8.m.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void a(u8.m visitor, Yb.e code) {
                kotlin.jvm.internal.p.i(visitor, "visitor");
                kotlin.jvm.internal.p.i(code, "code");
                String strM = code.m();
                if (strM == null) {
                    strM = "";
                }
                String strO = MarkwonHelper.INSTANCE.o(strM);
                int length = visitor.length();
                if (strO == null) {
                    visitor.builder().d(strM);
                    visitor.F(code, length);
                    return;
                }
                visitor.builder().d(strO);
                u8.g gVarZ = visitor.z();
                kotlin.jvm.internal.p.h(gVarZ, "configuration(...)");
                C5671a c5671aG = gVarZ.g();
                kotlin.jvm.internal.p.h(c5671aG, "theme(...)");
                u8.c cVarD = gVarZ.d();
                kotlin.jvm.internal.p.h(cVarD, "linkResolver(...)");
                visitor.d(length, new BareUrlLinkSpan(c5671aG, strO, cVarD));
            }
        }

        @Override // u8.AbstractC5589a, u8.i
        public void c(m.b builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            builder.a(Yb.e.class, a.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$o;", "Lu8/m$a;", "Lkotlin/Function0;", "", "applyFirstH1TopGap", "Lkotlin/Function1;", "LYb/u;", "isSupplementaryParagraph", "<init>", "(Lp9/a;Lp9/l;)V", "Lu8/m;", "visitor", "node", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lu8/m;LYb/u;)V", Const.INTENT_KEY_APIKEY, "Lp9/a;", "Lp9/l;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class o implements m.a {
        private final InterfaceC5063a<Boolean> applyFirstH1TopGap;
        private final InterfaceC5074l<Yb.u, Boolean> isSupplementaryParagraph;

        /* JADX WARN: Multi-variable type inference failed */
        public o(InterfaceC5063a<Boolean> applyFirstH1TopGap, InterfaceC5074l<? super Yb.u, Boolean> isSupplementaryParagraph) {
            kotlin.jvm.internal.p.i(applyFirstH1TopGap, "applyFirstH1TopGap");
            kotlin.jvm.internal.p.i(isSupplementaryParagraph, "isSupplementaryParagraph");
            this.applyFirstH1TopGap = applyFirstH1TopGap;
            this.isSupplementaryParagraph = isSupplementaryParagraph;
        }

        @Override // u8.m.a
        public void a(u8.m visitor, Yb.u node) {
            MarkdownBlockSpacing markdownBlockSpacing;
            Yb.u uVarH;
            kotlin.jvm.internal.p.i(visitor, "visitor");
            kotlin.jvm.internal.p.i(node, "node");
            if (visitor.h(node) && (uVarH = (markdownBlockSpacing = MarkdownBlockSpacing.INSTANCE).h(node)) != null) {
                visitor.C();
                int iR = MarkwonHelper.INSTANCE.r(markdownBlockSpacing.b(node, uVarH, this.isSupplementaryParagraph.invoke(uVarH).booleanValue()));
                u8.v vVarBuilder = visitor.builder();
                kotlin.jvm.internal.p.h(vVarBuilder, "builder(...)");
                int length = vVarBuilder.length();
                vVarBuilder.append('\n');
                vVarBuilder.j(new i(iR), length, vVarBuilder.length(), 17);
            }
        }

        @Override // u8.m.a
        public void b(u8.m visitor, Yb.u node) {
            kotlin.jvm.internal.p.i(visitor, "visitor");
            kotlin.jvm.internal.p.i(node, "node");
            if (this.applyFirstH1TopGap.invoke().booleanValue() && (node instanceof Yb.l) && ((Yb.l) node).n() == 1 && visitor.length() == 0) {
                u8.v vVarBuilder = visitor.builder();
                kotlin.jvm.internal.p.h(vVarBuilder, "builder(...)");
                int length = vVarBuilder.length();
                vVarBuilder.append('\n');
                vVarBuilder.j(new i(MarkwonHelper.INSTANCE.r(MarkwonHelper.v())), length, vVarBuilder.length(), 17);
            }
            visitor.C();
            if (node instanceof Yb.s) {
                Yb.s sVar = (Yb.s) node;
                if ((sVar.f() instanceof Yb.t) && (sVar.g() instanceof Yb.w)) {
                    AbstractC1128b abstractC1128bF = sVar.f().f();
                    Yb.s sVar2 = abstractC1128bF instanceof Yb.s ? (Yb.s) abstractC1128bF : null;
                    if (sVar2 == null || !sVar2.n()) {
                        return;
                    }
                    u8.v vVarBuilder2 = visitor.builder();
                    kotlin.jvm.internal.p.h(vVarBuilder2, "builder(...)");
                    int length2 = vVarBuilder2.length();
                    vVarBuilder2.append('\n');
                    vVarBuilder2.j(new i(MarkwonHelper.INSTANCE.r(MarkwonHelper.u())), length2, vVarBuilder2.length(), 17);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$p;", "Lu8/c;", "<init>", "()V", "Landroid/view/View;", "view", "", "link", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Ljava/lang/String;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class p implements u8.c {
        @Override // u8.c
        public void a(View view, String link) {
            InterfaceC5074l<String, Boolean> onLinkClick;
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(link, "link");
            if (La.D.X(link, Const.STR_MART_WELL, false, 2, null)) {
                MarkwonHelper.q0(view, link);
                return;
            }
            View view2 = view;
            while (view2 != null && !(view2 instanceof AIMDTextView)) {
                Object parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : null;
            }
            AIMDTextView aIMDTextView = view2 instanceof AIMDTextView ? (AIMDTextView) view2 : null;
            if (aIMDTextView == null || (onLinkClick = aIMDTextView.getOnLinkClick()) == null || !onLinkClick.invoke(link).booleanValue()) {
                MarkwonHelper.o0(view, link);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/uikit/MarkwonHelper$q;", "", "Lv8/a$a;", "builder", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lv8/a$a;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface q {
        void a(C5671a.C0540a builder);
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$r", "LG8/h;", "Lu8/g;", "configuration", "Lu8/r;", "renderProps", "LC8/f;", "tag", "", Const.INTENT_KEY_UMID, "(Lu8/g;Lu8/r;LC8/f;)Ljava/lang/Object;", "", "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Collection;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class r extends G8.h {
        @Override // C8.m
        public Collection<String> b() {
            return C1172u.e("code");
        }

        @Override // G8.h
        public Object d(u8.g configuration, u8.r renderProps, C8.f tag) {
            kotlin.jvm.internal.p.i(configuration, "configuration");
            kotlin.jvm.internal.p.i(renderProps, "renderProps");
            kotlin.jvm.internal.p.i(tag, "tag");
            C5671a c5671aG = configuration.g();
            kotlin.jvm.internal.p.h(c5671aG, "theme(...)");
            return new m(c5671aG);
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$s", "LG8/h;", "Lu8/g;", "configuration", "Lu8/r;", "renderProps", "LC8/f;", "tag", "", Const.INTENT_KEY_UMID, "(Lu8/g;Lu8/r;LC8/f;)Ljava/lang/Object;", "", "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Collection;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class s extends G8.h {
        @Override // C8.m
        public Collection<String> b() {
            return C1172u.e("mark");
        }

        @Override // G8.h
        public Object d(u8.g configuration, u8.r renderProps, C8.f tag) {
            kotlin.jvm.internal.p.i(configuration, "configuration");
            kotlin.jvm.internal.p.i(renderProps, "renderProps");
            kotlin.jvm.internal.p.i(tag, "tag");
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$t", "Lu8/a;", "Lu8/g$b;", "builder", "LY8/t;", "f", "(Lu8/g$b;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class t extends AbstractC5589a {
        final /* synthetic */ Context $context;

        public t(Context context) {
            this.$context = context;
        }

        @Override // u8.AbstractC5589a, u8.i
        public void f(g.b builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            Context context = this.$context;
            kotlin.jvm.internal.p.f(context);
            builder.k(new l(context));
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$u", "Lu8/a;", "", "markdown", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class u extends AbstractC5589a {
        @Override // u8.AbstractC5589a, u8.i
        public String g(String markdown) {
            kotlin.jvm.internal.p.i(markdown, "markdown");
            return MarkwonHelper.j0(markdown);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$v", "Lu8/a;", "", "markdown", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class v extends AbstractC5589a {
        @Override // u8.AbstractC5589a, u8.i
        public String g(String markdown) {
            kotlin.jvm.internal.p.i(markdown, "markdown");
            return j0.h(markdown);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$w", "Lu8/a;", "Lu8/k$a;", "builder", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lu8/k$a;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class w extends AbstractC5589a {
        final /* synthetic */ B8.a $taskListDrawable;

        public w(B8.a aVar) {
            this.$taskListDrawable = aVar;
        }

        public static final Object m(B8.a aVar, u8.g configuration, u8.r props) {
            kotlin.jvm.internal.p.i(configuration, "configuration");
            kotlin.jvm.internal.p.i(props, "props");
            C5671a c5671aG = configuration.g();
            kotlin.jvm.internal.p.h(c5671aG, "theme(...)");
            Boolean boolB = B8.e.f1472a.b(props, Boolean.FALSE);
            kotlin.jvm.internal.p.h(boolB, "get(...)");
            return new j(c5671aG, aVar, boolB.booleanValue());
        }

        @Override // u8.AbstractC5589a, u8.i
        public void a(k.a builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            final B8.a aVar = this.$taskListDrawable;
            builder.a(B8.b.class, new u8.u() { // from class: com.stepos.agentframework.uikit.a0
                @Override // u8.u
                public final Object a(u8.g gVar, u8.r rVar) {
                    return MarkwonHelper.w.m(aVar, gVar, rVar);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$x", "Lu8/a;", "Lu8/k$a;", "builder", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lu8/k$a;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class x extends AbstractC5589a {
        final /* synthetic */ Consumer<String> $copyCodeCallback;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$x$a", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/TextPaint;", "textPaint", "LY8/t;", "updateMeasureState", "(Landroid/text/TextPaint;)V", "updateDrawState", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a extends MetricAffectingSpan {
            final /* synthetic */ u8.g $configuration;

            public a(u8.g gVar) {
                this.$configuration = gVar;
            }

            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                kotlin.jvm.internal.p.i(textPaint, "textPaint");
                this.$configuration.g().b(textPaint);
            }

            @Override // android.text.style.MetricAffectingSpan
            public void updateMeasureState(TextPaint textPaint) {
                kotlin.jvm.internal.p.i(textPaint, "textPaint");
                this.$configuration.g().b(textPaint);
            }
        }

        public x(Consumer<String> consumer) {
            this.$copyCodeCallback = consumer;
        }

        public static final Object p(u8.g configuration, u8.r rVar) {
            kotlin.jvm.internal.p.i(configuration, "configuration");
            kotlin.jvm.internal.p.i(rVar, "<unused var>");
            C5671a c5671aG = configuration.g();
            kotlin.jvm.internal.p.h(c5671aG, "theme(...)");
            return new c[]{new c(c5671aG)};
        }

        public static final Object q(Consumer consumer, u8.g configuration, u8.r rVar) {
            kotlin.jvm.internal.p.i(configuration, "configuration");
            kotlin.jvm.internal.p.i(rVar, "<unused var>");
            return new Object[]{new a(configuration), new d(consumer)};
        }

        public static final Object r(u8.g configuration, u8.r props) {
            kotlin.jvm.internal.p.i(configuration, "configuration");
            kotlin.jvm.internal.p.i(props, "props");
            if (CoreProps.ListItemType.BULLET != CoreProps.f34200a.d(props)) {
                return new x8.h(configuration.g(), CoreProps.f34202c.d(props) + ". ");
            }
            Integer numD = CoreProps.f34201b.d(props);
            kotlin.jvm.internal.p.h(numD, "require(...)");
            int iIntValue = numD.intValue();
            int iR = MarkwonHelper.INSTANCE.r(MarkwonHelper.z());
            C5671a c5671aG = configuration.g();
            kotlin.jvm.internal.p.h(c5671aG, "theme(...)");
            return new g(c5671aG, iIntValue == 0 ? MarkwonHelper.w() : MarkwonHelper.x(), iR, iIntValue > 0, (iR - r0.r(MarkwonHelper.y())) / 2.0f);
        }

        public static final Object s(u8.g configuration, u8.r rVar) {
            kotlin.jvm.internal.p.i(configuration, "configuration");
            kotlin.jvm.internal.p.i(rVar, "<unused var>");
            C5671a c5671aG = configuration.g();
            kotlin.jvm.internal.p.h(c5671aG, "theme(...)");
            return new m(c5671aG);
        }

        @Override // u8.AbstractC5589a, u8.i
        public void a(k.a builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            builder.a(Yb.A.class, new u8.u() { // from class: com.stepos.agentframework.uikit.b0
                @Override // u8.u
                public final Object a(u8.g gVar, u8.r rVar) {
                    return MarkwonHelper.x.p(gVar, rVar);
                }
            });
            final Consumer<String> consumer = this.$copyCodeCallback;
            builder.a(Yb.j.class, new u8.u() { // from class: com.stepos.agentframework.uikit.c0
                @Override // u8.u
                public final Object a(u8.g gVar, u8.r rVar) {
                    return MarkwonHelper.x.q(consumer, gVar, rVar);
                }
            });
            builder.a(Yb.t.class, new u8.u() { // from class: com.stepos.agentframework.uikit.d0
                @Override // u8.u
                public final Object a(u8.g gVar, u8.r rVar) {
                    return MarkwonHelper.x.r(gVar, rVar);
                }
            });
            builder.a(Yb.e.class, new u8.u() { // from class: com.stepos.agentframework.uikit.e0
                @Override // u8.u
                public final Object a(u8.g gVar, u8.r rVar) {
                    return MarkwonHelper.x.s(gVar, rVar);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$y", "Lu8/a;", "Lv8/a$a;", "builder", "LY8/t;", "k", "(Lv8/a$a;)V", "Lu8/k$a;", Const.INTENT_KEY_APIKEY, "(Lu8/k$a;)V", "Lu8/g$b;", "f", "(Lu8/g$b;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class y extends AbstractC5589a {
        final /* synthetic */ b $store;

        public y(b bVar) {
            this.$store = bVar;
        }

        @Override // u8.AbstractC5589a, u8.i
        public void a(k.a builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            builder.a(Yb.o.class, new I());
        }

        @Override // u8.AbstractC5589a, u8.i
        public void f(g.b builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            MarkwonHelper markwonHelper = MarkwonHelper.INSTANCE;
            markwonHelper.r0(new C2151z(this.$store));
            C2151z c2151zV = markwonHelper.V();
            kotlin.jvm.internal.p.f(c2151zV);
            builder.h(c2151zV);
            builder.l(new p());
        }

        @Override // u8.AbstractC5589a, u8.i
        public void k(C5671a.C0540a builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            q qVar = MarkwonHelper.themeConfigurator;
            if (qVar != null) {
                qVar.a(builder);
            }
            super.k(builder);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/uikit/MarkwonHelper$z", "Lu8/a;", "Lu8/g$b;", "builder", "LY8/t;", "f", "(Lu8/g$b;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class z extends AbstractC5589a {
        @Override // u8.AbstractC5589a, u8.i
        public void f(g.b builder) {
            kotlin.jvm.internal.p.i(builder, "builder");
            builder.j(H8.a.a());
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.\\-]{0,64}://[^\\s<>\"'）)】」』，。；！？]{1,4096}");
        kotlin.jvm.internal.p.h(patternCompile, "compile(...)");
        urlLinkPattern = patternCompile;
    }

    public static final int A() {
        return codeBlockBackground;
    }

    public static final Spanned A0(Context context, CharSequence body, int gutterWidthDp, int gutterPaddingDp) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(body, "body");
        if (body.length() == 0) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(body);
        boolean z10 = (context.getResources().getConfiguration().uiMode & 48) == 32;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        spannableStringBuilder.setSpan(new D((int) TypedValue.applyDimension(1, gutterWidthDp, displayMetrics), (int) TypedValue.applyDimension(1, gutterPaddingDp, displayMetrics), z10 ? codeBlockLineNumberColorNight : codeBlockLineNumberColor, TypedValue.applyDimension(2, codeBlockLineNumberSizeSp, displayMetrics)), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static final int B() {
        return codeBlockBackgroundNight;
    }

    public static /* synthetic */ Spanned B0(Context context, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = plainCodeGutterWidthDp;
        }
        if ((i12 & 8) != 0) {
            i11 = plainCodeGutterPaddingDp;
        }
        return A0(context, charSequence, i10, i11);
    }

    public static final int C() {
        return codeBlockBodyVPaddingDp;
    }

    public static final int D() {
        return codeBlockBorderColor;
    }

    public static final float E() {
        return codeBlockBorderWidthDp;
    }

    public static final int F() {
        return codeBlockCodeTopMarginDp;
    }

    public static final int G() {
        return codeBlockGutterPaddingDp;
    }

    public static final int H() {
        return codeBlockGutterWidthDp;
    }

    public static final int I() {
        return codeBlockHeaderBackground;
    }

    public static final int J() {
        return codeBlockHeaderBackgroundNight;
    }

    public static final int K() {
        return codeBlockHeaderHeightDp;
    }

    public static final int L() {
        return codeBlockHeaderPaddingDp;
    }

    public static final int M() {
        return codeBlockLangLabelColor;
    }

    public static final int N() {
        return codeBlockLangLabelColorNight;
    }

    public static final int O() {
        return codeBlockLangLabelSizeSp;
    }

    public static final int P() {
        return codeBlockLineNumberColor;
    }

    public static final int Q() {
        return codeBlockLineNumberSizeSp;
    }

    public static final int R() {
        return codeBlockRadiusDp;
    }

    public static final int S() {
        return codeBlockTextColor;
    }

    public static final int T() {
        return codeBlockTextColorNight;
    }

    public static final int U() {
        return codeInlineTextColorNight;
    }

    public static final p9.q<View, List<String>, Integer, Y8.t> W() {
        return imagePreviewLauncher;
    }

    public static final int X() {
        return linkColor;
    }

    public static final int Y() {
        return listBulletColor;
    }

    public static final void a0(C5961i.c latexBuilder) {
        kotlin.jvm.internal.p.i(latexBuilder, "latexBuilder");
        latexBuilder.g(true);
        latexBuilder.h(false);
        latexBuilder.k(true);
        latexBuilder.j(new C5961i.f() { // from class: com.stepos.agentframework.uikit.U
            @Override // y8.C5961i.f
            public final Drawable a(String str, Throwable th) {
                return MarkwonHelper.b0(str, th);
            }
        });
        latexBuilder.l().q(bodyTextColor);
        latexBuilder.l().p(bodyTextColor);
    }

    public static final Drawable b0(String str, Throwable th) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(th, "<unused var>");
        return null;
    }

    public static final boolean c0(boolean z10, InterfaceC5063a interfaceC5063a) {
        return !z10 && ((Boolean) interfaceC5063a.invoke()).booleanValue();
    }

    public static final int d0() {
        return thematicBreakColor;
    }

    public static final Pattern e0() {
        return urlLinkPattern;
    }

    public static final CharSequence f0(Context context, u8.e markwon, String language, String source) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(markwon, "markwon");
        kotlin.jvm.internal.p.i(language, "language");
        kotlin.jvm.internal.p.i(source, "source");
        if (source.length() == 0) {
            return source;
        }
        boolean z10 = (context.getResources().getConfiguration().uiMode & 48) == 32;
        String string = La.H.D1(language).toString();
        if (string.length() == 0) {
            return source;
        }
        Set<String> set = PLAIN_TEXT_CODE_LANGS;
        String lowerCase = string.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        if (set.contains(lowerCase)) {
            return source;
        }
        K4.b bVar = K4.b.INSTANCE;
        if (kotlin.jvm.internal.p.d(bVar.g(string), bVar.b())) {
            K4.d dVar = K4.d.INSTANCE;
            return dVar.b(string, source, dVar.a(z10), 20000);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(markwon.b().f().a(string, source));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            K4.d dVar2 = K4.d.INSTANCE;
            objB = dVar2.b(string, source, dVar2.a(z10), 20000);
        }
        return (CharSequence) objB;
    }

    public static final int h0(int textColor) {
        return C5502d.k(textColor, 115);
    }

    public static final String j0(String markdown) {
        kotlin.jvm.internal.p.i(markdown, "markdown");
        if (markdown.length() == 0) {
            return markdown;
        }
        Regex regex = new Regex("(?m)^[ \\t]*(`{3,}|~{3,}).*?\\n[\\s\\S]*?^[ \\t]*\\1[ \\t]*$");
        StringBuilder sb2 = new StringBuilder(markdown.length() + 16);
        int last = 0;
        for (La.m mVar : Regex.f(regex, markdown, 0, 2, null)) {
            MarkwonHelper markwonHelper = INSTANCE;
            String strSubstring = markdown.substring(last, mVar.a().getFirst());
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            sb2.append(markwonHelper.k0(strSubstring));
            sb2.append(mVar.getValue());
            last = mVar.a().getLast() + 1;
        }
        MarkwonHelper markwonHelper2 = INSTANCE;
        String strSubstring2 = markdown.substring(last);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        sb2.append(markwonHelper2.k0(strSubstring2));
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public static final CharSequence l0(La.m mr) {
        kotlin.jvm.internal.p.i(mr, "mr");
        return "\n$$\n" + La.H.D1(mr.c().get(1)).toString() + "\n$$\n";
    }

    public static final CharSequence m0(La.m mr) {
        kotlin.jvm.internal.p.i(mr, "mr");
        return "$$" + La.H.D1(mr.c().get(1)).toString() + "$$";
    }

    public static final void n(int textColor) {
        listBulletColor = textColor;
        bulletDotColorLevel1 = textColor;
        bulletDotColorLevel2 = h0(textColor);
    }

    public static final CharSequence n0(La.m mr) {
        kotlin.jvm.internal.p.i(mr, "mr");
        return "$$" + ((Object) mr.c().get(1)) + "$$";
    }

    public static final boolean o0(View view, String link) {
        Object objB;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(link, "link");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Uri.parse(link));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Uri uri = (Uri) objB;
        if (uri == null) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(view.getContext() instanceof Activity)) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            view.getContext().startActivity(intent);
            return true;
        } catch (Exception e10) {
            C4148a.t(TAG, "resolve link failed: " + link, e10, false, 8, null);
            return false;
        }
    }

    public static final void q(C8.e html) {
        kotlin.jvm.internal.p.i(html, "html");
        html.m(new r());
        html.m(new s());
    }

    public static final void q0(View view, String link) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(link, "link");
        while (true) {
            if (view == null || (view instanceof AIMDTextView)) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        AIMDTextView aIMDTextView = view instanceof AIMDTextView ? (AIMDTextView) view : null;
        if (aIMDTextView != null) {
            aIMDTextView.M0(link);
        }
    }

    public static final void s0(p9.q<? super View, ? super List<String>, ? super Integer, Y8.t> qVar) {
        imagePreviewLauncher = qVar;
    }

    public static final int t() {
        return blockQuoteColor;
    }

    public static final void t0(int i10) {
        linkColor = i10;
    }

    public static final int u() {
        return blockSpacingListItemDp;
    }

    public static final void u0(int i10) {
        thematicBreakColor = i10;
    }

    public static final int v() {
        return blockSpacingSectionDp;
    }

    public static final boolean v0(CharSequence text) {
        kotlin.jvm.internal.p.i(text, "text");
        return text.length() != 0 && text.length() <= 32768 && La.H.u0(text, "://", 0, false, 6, null) >= 0;
    }

    public static final int w() {
        return bulletDotColorLevel1;
    }

    public static final String w0(String heading) {
        kotlin.jvm.internal.p.i(heading, "heading");
        String lowerCase = La.H.D1(heading).toString().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return La.D.S(new Regex("[^\\p{L}\\p{N} \\-]").l(lowerCase, ""), ' ', '-', false, 4, null);
    }

    public static final int x() {
        return bulletDotColorLevel2;
    }

    public static final int y() {
        return bulletDotHollowInnerDp;
    }

    public static final void y0(q configurator) {
        themeConfigurator = configurator;
    }

    public static final int z() {
        return bulletDotSizeDp;
    }

    public static final Typeface z0(String family) {
        kotlin.jvm.internal.p.i(family, "family");
        Typeface typefaceCreate = Typeface.create(family, 0);
        kotlin.jvm.internal.p.h(typefaceCreate, "create(...)");
        return typefaceCreate;
    }

    public final C2151z V() {
        return glideAsyncDrawableLoader;
    }

    public final u8.e Z(Context ctx, TextView textView, boolean showImage, final boolean useRecyclerTablePlugin, final InterfaceC5063a<Boolean> includeFirstHeadingTopGap, InterfaceC5074l<? super Yb.u, Boolean> isSupplementaryParagraph, Consumer<String> copyCodeCallback) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(ctx, "ctx");
        kotlin.jvm.internal.p.i(textView, "textView");
        kotlin.jvm.internal.p.i(includeFirstHeadingTopGap, "includeFirstHeadingTopGap");
        kotlin.jvm.internal.p.i(isSupplementaryParagraph, "isSupplementaryParagraph");
        kotlin.jvm.internal.p.i(copyCodeCallback, "copyCodeCallback");
        Context applicationContext = ctx.getApplicationContext();
        boolean z10 = (textView.getResources().getConfiguration().uiMode & 48) == 32;
        kotlin.jvm.internal.p.f(applicationContext);
        b bVar = new b(applicationContext, showImage);
        O8.h hVar = new O8.h(new com.stepos.agentframework.uikit.A());
        M8.c cVarG = z10 ? io.noties.markwon.syntax.a.g() : io.noties.markwon.syntax.b.g();
        int i10 = z10 ? codeBlockHeaderBackgroundNight : codeBlockHeaderBackground;
        int i11 = z10 ? codeBlockBackgroundNight : codeBlockBackground;
        int i12 = z10 ? codeBlockLangLabelColorNight : codeBlockLangLabelColor;
        int iP0 = p0(applicationContext, R.attr.colorBackground);
        int i13 = taskListCheckboxColor;
        B8.a aVar = new B8.a(i13, i13, iP0);
        e.a aVarA = u8.e.a(applicationContext).a(J8.l.l()).a(u8.t.l()).a(new u()).a(new v()).a(C5961i.r(textView.getTextSize(), new C5961i.d() { // from class: com.stepos.agentframework.uikit.S
            @Override // y8.C5961i.d
            public final void a(C5961i.c cVar) {
                MarkwonHelper.a0(cVar);
            }
        })).a(B8.c.l(aVar)).a(new w(aVar)).a(C6377a.l()).a(new e()).a(new n()).a(M8.f.l(hVar, cVarG, fallbackLanguage)).a(new f(z10)).a(new C2126a(new InterfaceC5063a() { // from class: com.stepos.agentframework.uikit.T
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(MarkwonHelper.c0(useRecyclerTablePlugin, includeFirstHeadingTopGap));
            }
        }, isSupplementaryParagraph)).a(new h(i10, i11, i12, !useRecyclerTablePlugin, z10)).a(new x(copyCodeCallback)).a(I8.a.l(bVar)).a(new y(bVar)).a(p()).a(new z()).a(new A()).a(new t(applicationContext));
        kotlin.jvm.internal.p.h(aVarA, "usePlugin(...)");
        if (useRecyclerTablePlugin) {
            aVarA.a(L8.c.l(A8.e.f(applicationContext).j(0).g()));
        } else {
            aVarA.a(A8.a.l(applicationContext));
        }
        u8.e eVarBuild = aVarA.build();
        kotlin.jvm.internal.p.h(eVarBuild, "build(...)");
        return eVarBuild;
    }

    public final int g0(Yb.u node) {
        int i10 = 0;
        for (Yb.u uVarF = node.f(); uVarF != null; uVarF = uVarF.f()) {
            if (uVarF instanceof Yb.t) {
                i10++;
            }
        }
        return i10;
    }

    public final int i0(int textColor, boolean hollow) {
        return hollow ? h0(textColor) : textColor;
    }

    public final String k0(String text) {
        if (text.length() == 0) {
            return text;
        }
        return new Regex("(?<![\\\\$])\\$(?!\\$)([^$\\n]+?)\\$(?!\\$)").m(new Regex("\\\\\\(([\\s\\S]+?)\\\\\\)").m(new Regex("\\\\\\[([\\s\\S]+?)\\\\]").m(text, new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.V
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MarkwonHelper.l0((La.m) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.W
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MarkwonHelper.m0((La.m) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.X
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MarkwonHelper.n0((La.m) obj);
            }
        });
    }

    public final String o(String literal) {
        kotlin.jvm.internal.p.i(literal, "literal");
        String string = La.H.D1(literal).toString();
        if (string.length() <= 0 || !urlLinkPattern.matcher(string).matches()) {
            return null;
        }
        return string;
    }

    public final C8.e p() {
        C8.e eVarO = C8.e.o(new e.c() { // from class: com.stepos.agentframework.uikit.Y
            @Override // C8.e.c
            public final void a(C8.e eVar) {
                MarkwonHelper.q(eVar);
            }
        });
        kotlin.jvm.internal.p.h(eVarO, "create(...)");
        return eVarO;
    }

    public final int p0(Context context, int attr) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{attr});
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final int r(int value) {
        return (int) TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics());
    }

    public final void r0(C2151z c2151z) {
        glideAsyncDrawableLoader = c2151z;
    }

    public final float s(int value) {
        return TypedValue.applyDimension(1, value, Resources.getSystem().getDisplayMetrics());
    }

    public final float x0(int value) {
        return TypedValue.applyDimension(2, value, Resources.getSystem().getDisplayMetrics());
    }
}
