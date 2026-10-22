package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import N5.CardEnvelope;
import N5.CardLinks;
import Z8.C1173v;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appstore.AppDetailRepository;
import com.stepos.ailauncher.foundation.appstore.DownloadTaskRepository;
import com.stepos.ailauncher.foundation.appstore.api.AppDetail;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.C3314k;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import v9.C5680i;

@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0002î\u0001\b\u0000\u0018\u0000 ù\u00012\u00020\u00012\u00020\u0002:\u0005\u001fú\u0001û\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0012H\u0014¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0012H\u0014¢\u0006\u0004\b&\u0010%J\u0017\u0010(\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0007H\u0014¢\u0006\u0004\b(\u0010)J'\u0010-\u001a\u00020\u00122\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b-\u0010.J/\u00100\u001a\u00020\r2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b0\u00101J'\u00102\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b4\u0010#J\u001f\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b6\u0010#J\u001f\u00107\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\b7\u0010#J3\u00109\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u00108\u001a\u00020\rH\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010<\u001a\u0004\u0018\u00010\u00072\b\u0010;\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u0019H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\rH\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0012H\u0002¢\u0006\u0004\bC\u0010%J\u0017\u0010E\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0004\bE\u0010FJ1\u0010M\u001a\u00020\u00122\u0006\u0010H\u001a\u00020G2\u0006\u0010J\u001a\u00020I2\b\u0010L\u001a\u0004\u0018\u00010K2\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0012H\u0002¢\u0006\u0004\bO\u0010%J\u0013\u0010P\u001a\u00020\r*\u00020DH\u0002¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0004\bR\u0010QJ\u0017\u0010S\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0004\bS\u0010QJ\u0017\u0010T\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0004\bT\u0010FJ\u0017\u0010U\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0004\bU\u0010FJ\u000f\u0010V\u001a\u00020\u0012H\u0002¢\u0006\u0004\bV\u0010%J\u000f\u0010W\u001a\u00020\rH\u0002¢\u0006\u0004\bW\u0010BJ'\u0010Z\u001a\u00020\u00122\u0006\u0010X\u001a\u00020D2\u0006\u0010Y\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bZ\u0010[J\u001d\u0010_\u001a\u00020\u00122\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0002¢\u0006\u0004\b_\u0010`J7\u0010g\u001a\u00020\u00122\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010d\u001a\u0004\u0018\u00010c2\b\b\u0002\u0010e\u001a\u00020\r2\b\b\u0002\u0010f\u001a\u00020\rH\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\rH\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\rH\u0002¢\u0006\u0004\bk\u0010jJ\u0019\u0010m\u001a\u00020\u00122\b\u0010l\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\bm\u0010\u001cJ\u0017\u0010o\u001a\u00020n2\u0006\u0010l\u001a\u00020\u0019H\u0002¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0004\bq\u0010FJ!\u0010s\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020D2\b\b\u0002\u0010r\u001a\u00020\rH\u0002¢\u0006\u0004\bs\u0010tJ\u0017\u0010u\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0004\bu\u0010FJ\u000f\u0010v\u001a\u00020\u0012H\u0002¢\u0006\u0004\bv\u0010%J\u001f\u0010x\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020D2\u0006\u0010w\u001a\u00020\rH\u0002¢\u0006\u0004\bx\u0010tJ\u0017\u0010z\u001a\u00020\u00122\u0006\u0010y\u001a\u00020\u0007H\u0002¢\u0006\u0004\bz\u0010)J9\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010|\u001a\u00020{2\b\u0010}\u001a\u0004\u0018\u00010\u00192\b\u0010\u007f\u001a\u0004\u0018\u00010~2\t\b\u0001\u0010\u0080\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0019\u0010\u0083\u0001\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0005\b\u0083\u0001\u0010FJ=\u0010\u0089\u0001\u001a\u00020\u00122\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00192\t\b\u0001\u0010\u0086\u0001\u001a\u00020\u00072\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J,\u0010\u008d\u0001\u001a\u00020\u00122\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020c0\\2\t\b\u0002\u0010\u008c\u0001\u001a\u00020\rH\u0002¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J%\u0010\u0092\u0001\u001a\u00020\u00122\b\u0010\u0090\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0095\u0001\u001a\u00020\u00072\u0007\u0010\u0094\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u001c\u0010\u0098\u0001\u001a\u00020\u00072\b\u0010\u0097\u0001\u001a\u00030\u0087\u0001H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J)\u0010\u009b\u0001\u001a\u00020\u00122\u0007\u0010\u0011\u001a\u00030\u009a\u00012\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J(\u0010\u009f\u0001\u001a\u00020\u00122\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010a2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0019\u0010¡\u0001\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0005\b¡\u0001\u0010FJ\u0019\u0010¢\u0001\u001a\u00020\u00122\u0006\u0010y\u001a\u00020\u0007H\u0002¢\u0006\u0005\b¢\u0001\u0010)J\u0014\u0010£\u0001\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u0015\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0002¢\u0006\u0006\b¦\u0001\u0010§\u0001J<\u0010\u00ad\u0001\u001a\u0004\u0018\u00018\u0000\"\u0005\b\u0000\u0010¨\u00012\b\u0010ª\u0001\u001a\u00030©\u00012\u0015\u0010¬\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0004\u0012\u00028\u00000«\u0001H\u0002¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u0019\u0010¯\u0001\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0005\b¯\u0001\u0010\u001cJ\u001d\u0010±\u0001\u001a\u0005\u0018\u00010°\u00012\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0006\b±\u0001\u0010²\u0001J\u001d\u0010´\u0001\u001a\u0005\u0018\u00010³\u00012\u0006\u0010\u0016\u001a\u00020DH\u0002¢\u0006\u0006\b´\u0001\u0010µ\u0001J\"\u0010¶\u0001\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u0019\u0010¸\u0001\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0005\b¸\u0001\u0010\u001cJ\u0011\u0010¹\u0001\u001a\u00020\rH\u0002¢\u0006\u0005\b¹\u0001\u0010BJ\u0019\u0010º\u0001\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0005\bº\u0001\u0010\u001cJ\u0011\u0010»\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b»\u0001\u0010%J\u0011\u0010¼\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b¼\u0001\u0010%J\u0011\u0010½\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b½\u0001\u0010%J\u0011\u0010¾\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b¾\u0001\u0010%J\u0011\u0010¿\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b¿\u0001\u0010%J\u0011\u0010À\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\bÀ\u0001\u0010%J%\u0010Â\u0001\u001a\u00020\u00122\u0007\u0010Á\u0001\u001a\u00020{2\b\u0010b\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u001c\u0010Ä\u0001\u001a\u00020\u00122\b\u0010b\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J$\u0010Ç\u0001\u001a\u00020\u00122\b\u0010Æ\u0001\u001a\u00030\u008f\u00012\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u001a\u0010É\u0001\u001a\u00020\r2\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u0014\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0006\bË\u0001\u0010Ì\u0001J\u0019\u0010Í\u0001\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u0019H\u0002¢\u0006\u0005\bÍ\u0001\u0010@J)\u0010Ï\u0001\u001a\u00020\u00122\u0007\u0010Î\u0001\u001a\u00020\u00192\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0002¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001JF\u0010Ö\u0001\u001a\u00020\u00122\b\u0010Æ\u0001\u001a\u00030Ñ\u00012\t\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00192\t\b\u0001\u0010Ó\u0001\u001a\u00020\u00072\u0007\u0010Ô\u0001\u001a\u00020\u00072\t\b\u0002\u0010Õ\u0001\u001a\u00020\rH\u0002¢\u0006\u0006\bÖ\u0001\u0010×\u0001R\u001a\u0010Ù\u0001\u001a\u00030Ø\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u001b\u0010Û\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u001c\u0010Ý\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u001e\u0010à\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190ß\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u001b\u0010â\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001b\u0010ä\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u0019\u0010æ\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u001b\u0010è\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R\u001b\u0010ê\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010é\u0001R\u001b\u0010ë\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ã\u0001R\u001b\u0010ì\u0001\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010é\u0001R\u001b\u0010í\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010ã\u0001R\u0018\u0010ï\u0001\u001a\u00030î\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u0019\u0010ñ\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010ç\u0001R\u0018\u0010ó\u0001\u001a\u00030ò\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R\u0019\u0010õ\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010ç\u0001R\u001b\u0010ö\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010ã\u0001R\u001e\u0010÷\u0001\u001a\u00020\r8\u0014X\u0094D¢\u0006\u000f\n\u0006\b÷\u0001\u0010ç\u0001\u001a\u0005\bø\u0001\u0010B¨\u0006ü\u0001"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView;", "LN5/d;", "Lcom/stepos/ailauncher/foundation/appui/card/state/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LN5/i;", "envelope", "", "Q", "(LN5/i;)Z", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "", "reason", "V0", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/foundation/appui/card/state/j;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/appui/card/state/j;)V", "orderNo", "U0", "(Ljava/lang/String;Ljava/lang/String;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "visibility", "onWindowVisibilityChanged", "(I)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "dto", "thirdUid", "h0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;Ljava/lang/String;Ljava/lang/String;)V", "expectedCardId", "o0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "p0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "q0", "accountKey", "i0", "j0", "terminalReplacement", "m0", "(LN5/i;Ljava/lang/String;Ljava/lang/String;Z)V", "data", "o1", "(Ljava/lang/String;)Ljava/lang/Integer;", "pkg", "j1", "(Ljava/lang/String;)Z", "t1", "()Z", "d1", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "u0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)V", "LT5/k;", "block", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$b;", "app", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;", "detail", "g0", "(LT5/k;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$b;Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)V", SdCardDbCreator.FIELD_LASTLOC_ID, "f1", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Z", "i1", "h1", "P0", "v0", "k0", "g1", "previous", "incoming", "c1", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Ljava/lang/String;)V", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$c;", "types", "p1", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;", "action", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;", "ctaRow", "showsDriverAvatar", "showDivider", "I0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$d;ZZ)V", "z0", "(Z)V", "A0", UxipConstants.f30680s, "y0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$a;", "y1", "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$a;", "H0", "compactTitle", "O0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Z)V", "C0", "u1", "compact", "M0", "status", "N0", "Landroid/widget/TextView;", "tv", "text", "Lv9/i;", "range", "highlightColorRes", "E0", "(Landroid/widget/TextView;Ljava/lang/String;Lv9/i;I)V", "Q0", "title", "subtitle", "fallbackIconRes", "", "iconSizeDp", "D0", "(Ljava/lang/String;Ljava/lang/String;IF)V", "rows", "showDividers", "F0", "(Ljava/util/List;Z)V", "Landroid/view/View;", "view", "marginDp", "w1", "(Landroid/view/View;I)V", "valueDp", "Z0", "(I)I", "valueSp", "x1", "(F)I", "Landroid/widget/LinearLayout;", "w0", "(Landroid/widget/LinearLayout;Ljava/util/List;)V", "secondary", "primary", "B0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;)V", "K0", "L0", "e0", "()LT5/k;", "LT5/m;", "T0", "()LT5/m;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/ViewStub;", "stub", "Lkotlin/Function1;", "bind", "e1", "(Landroid/view/ViewStub;Lp9/l;)Ljava/lang/Object;", "F1", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/k$a;", "r0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/k$a;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$b;", "R0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$b;", "I1", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Ljava/lang/String;)V", "z1", "n1", "E1", "r1", "G1", "C1", "s1", "H1", "q1", "button", "f0", "(Landroid/widget/TextView;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;)V", "l0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;)V", "target", "s0", "(Landroid/view/View;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;)V", "v1", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$a;)Z", "S0", "()Ljava/lang/String;", "k1", "cardId", "A1", "(Ljava/lang/String;Ljava/util/List;)V", "Landroid/widget/ImageView;", "url", "fallback", "corner", "centerCrop", "l1", "(Landroid/widget/ImageView;Ljava/lang/String;IIZ)V", "LT5/l;", q0.DIDI, "LT5/l;", "appStore", "LT5/k;", "carTypeBlock", "LT5/m;", "", "carSelection", "Ljava/util/Set;", "carSelectionKey", "Ljava/lang/String;", "dimmedStatus", "Ljava/lang/Integer;", "persistentDimmed", "Z", "lastModel", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", "authorizationSourceModel", "authorizationValidationKey", "gatedAuthModel", "boundVendorPkg", "com/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$d", "packageReceiver", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$d;", "receiverRegistered", "Lcom/stepos/appcenter/appcentersdk/AppCenterSdk$Listener;", "downloadListener", "Lcom/stepos/appcenter/appcentersdk/AppCenterSdk$Listener;", "downloadListenerRegistered", "listenerPkg", "hidesCommonChrome", "getHidesCommonChrome", "Companion", Const.INTENT_KEY_PKGNAME, "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiCardView extends N5.d implements com.stepos.ailauncher.foundation.appui.card.state.d {

    @Deprecated
    public static final float AUTHORIZED_ICON_DP = 56.0f;

    @Deprecated
    public static final float AUTH_ICON_DP = 44.0f;

    @Deprecated
    public static final float CTA_ROW_LABEL_TEXT_SP = 13.0f;

    @Deprecated
    public static final int DOWNLOAD_LISTENER_VERSION = 0;

    @Deprecated
    public static final int DRIVER_CTA_TOP_DP = 12;

    @Deprecated
    public static final int DRIVER_NAME_FONT_WEIGHT = 500;

    @Deprecated
    public static final float DRIVER_NAME_LINE_HEIGHT_SP = 20.0f;

    @Deprecated
    public static final int DRIVER_NAME_TEXT_HEIGHT_DP = 20;

    @Deprecated
    public static final float DRIVER_NAME_TEXT_SP = 13.0f;

    @Deprecated
    public static final int FINISHED_SUMMARY_WIDTH_DP = 165;

    @Deprecated
    public static final int FINISHED_TITLE_TRAILING_MARQUEE_GAP_DP = 36;

    @Deprecated
    public static final int FINISHED_TITLE_TRAILING_WIDTH_DP = 172;

    @Deprecated
    public static final int INSTALLING_PROGRESS_UNKNOWN = 1;

    @Deprecated
    public static final float MATCHING_TITLE_SP = 12.0f;

    @Deprecated
    public static final int PLATE_SUBTITLE_FONT_WEIGHT = 260;

    @Deprecated
    public static final float PLATE_SUBTITLE_LINE_HEIGHT_SP = 20.0f;

    @Deprecated
    public static final float PLATE_SUBTITLE_TEXT_SP = 13.0f;

    @Deprecated
    public static final float TITLE_SP = 16.0f;

    @Deprecated
    public static final float TITLE_SP_COMPACT = 14.0f;

    @Deprecated
    public static final int TRIP_SKELETON_CTA_TOP_DP = 20;

    @Deprecated
    public static final int TRIP_SKELETON_PLATE_TOP_DP = 20;
    private T5.k appStore;
    private DidiCardModel authorizationSourceModel;
    private String authorizationValidationKey;
    private String boundVendorPkg;
    private final Set<String> carSelection;
    private String carSelectionKey;
    private T5.m carTypeBlock;
    private T5.l didi;
    private Integer dimmedStatus;
    private final AppCenterSdk.Listener downloadListener;
    private boolean downloadListenerRegistered;
    private DidiCardModel gatedAuthModel;
    private final boolean hidesCommonChrome;
    private DidiCardModel lastModel;
    private String listenerPkg;
    private final d packageReceiver;
    private boolean persistentDimmed;
    private boolean receiverRegistered;
    private static final c Companion = new c(null);
    private static final Set<Integer> CAR_IMAGE_STATUSES = Z8.Y.j(2, 3, 4, 5, 6);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$a;", "", "", "symbol", Const.JSON_KEY_NUMBER, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView$a, reason: from toString */
    public static final /* data */ class AmountTextParts {
        private final String number;
        private final String symbol;

        public AmountTextParts(String str, String number) {
            kotlin.jvm.internal.p.i(number, "number");
            this.symbol = str;
            this.number = number;
        }

        /* renamed from: a, reason: from getter */
        public final String getNumber() {
            return this.number;
        }

        /* renamed from: b, reason: from getter */
        public final String getSymbol() {
            return this.symbol;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AmountTextParts)) {
                return false;
            }
            AmountTextParts amountTextParts = (AmountTextParts) other;
            return kotlin.jvm.internal.p.d(this.symbol, amountTextParts.symbol) && kotlin.jvm.internal.p.d(this.number, amountTextParts.number);
        }

        public int hashCode() {
            String str = this.symbol;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.number.hashCode();
        }

        public String toString() {
            return "AmountTextParts(symbol=" + this.symbol + ", number=" + this.number + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\tR\u0011\u0010\u0016\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$b;", "", "", "accountKey", "vendorId", "integrationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", "pollKey", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView$b, reason: from toString */
    public static final /* data */ class CaocaoAuthConfig {
        private final String accountKey;
        private final String integrationId;
        private final String vendorId;

        public CaocaoAuthConfig(String accountKey, String vendorId, String integrationId) {
            kotlin.jvm.internal.p.i(accountKey, "accountKey");
            kotlin.jvm.internal.p.i(vendorId, "vendorId");
            kotlin.jvm.internal.p.i(integrationId, "integrationId");
            this.accountKey = accountKey;
            this.vendorId = vendorId;
            this.integrationId = integrationId;
        }

        /* renamed from: a, reason: from getter */
        public final String getAccountKey() {
            return this.accountKey;
        }

        /* renamed from: b, reason: from getter */
        public final String getIntegrationId() {
            return this.integrationId;
        }

        public final String c() {
            return this.accountKey + "|" + this.vendorId + "|" + this.integrationId;
        }

        /* renamed from: d, reason: from getter */
        public final String getVendorId() {
            return this.vendorId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CaocaoAuthConfig)) {
                return false;
            }
            CaocaoAuthConfig caocaoAuthConfig = (CaocaoAuthConfig) other;
            return kotlin.jvm.internal.p.d(this.accountKey, caocaoAuthConfig.accountKey) && kotlin.jvm.internal.p.d(this.vendorId, caocaoAuthConfig.vendorId) && kotlin.jvm.internal.p.d(this.integrationId, caocaoAuthConfig.integrationId);
        }

        public int hashCode() {
            return (((this.accountKey.hashCode() * 31) + this.vendorId.hashCode()) * 31) + this.integrationId.hashCode();
        }

        public String toString() {
            return "CaocaoAuthConfig(accountKey=" + this.accountKey + ", vendorId=" + this.vendorId + ", integrationId=" + this.integrationId + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\nR\u0014\u0010\u001c\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$c;", "", "<init>", "()V", "", "DOWNLOAD_LISTENER_VERSION", "I", "INSTALLING_PROGRESS_UNKNOWN", "", "TITLE_SP", "F", "TITLE_SP_COMPACT", "MATCHING_TITLE_SP", "TRIP_SKELETON_PLATE_TOP_DP", "TRIP_SKELETON_CTA_TOP_DP", "DRIVER_CTA_TOP_DP", "CTA_ROW_LABEL_TEXT_SP", "DRIVER_NAME_TEXT_SP", "DRIVER_NAME_LINE_HEIGHT_SP", "DRIVER_NAME_TEXT_HEIGHT_DP", "DRIVER_NAME_FONT_WEIGHT", "PLATE_SUBTITLE_TEXT_SP", "PLATE_SUBTITLE_LINE_HEIGHT_SP", "PLATE_SUBTITLE_FONT_WEIGHT", "FINISHED_TITLE_TRAILING_WIDTH_DP", "FINISHED_TITLE_TRAILING_MARQUEE_GAP_DP", "FINISHED_SUMMARY_WIDTH_DP", "AUTH_ICON_DP", "AUTHORIZED_ICON_DP", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {
        public /* synthetic */ c(kotlin.jvm.internal.i iVar) {
            this();
        }

        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/didi/DidiCardView$d", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri data;
            String schemeSpecificPart;
            if (intent == null || (data = intent.getData()) == null || (schemeSpecificPart = data.getSchemeSpecificPart()) == null || !kotlin.jvm.internal.p.d(schemeSpecificPart, DidiCardView.this.boundVendorPkg)) {
                return;
            }
            R5.b.INSTANCE.c("didi.install.event", Y8.j.a("action", intent.getAction()), Y8.j.a("pkg", schemeSpecificPart));
            if (DidiCardView.this.t1()) {
                return;
            }
            DidiCardView.this.q1();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DidiCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.carSelection = new LinkedHashSet();
        this.packageReceiver = new d();
        this.downloadListener = new AppCenterSdk.Listener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.H
            @Override // com.stepos.appcenter.appcentersdk.AppCenterSdk.Listener
            public final void onCallback(int i11, String str) {
                DidiCardView.W0(this.f27372a, i11, str);
            }
        };
        this.hidesCommonChrome = true;
    }

    public static final CharSequence B1(DidiCardModel.CarTypeItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getId();
    }

    public static final Y8.t D1(DidiCardView didiCardView, String str, boolean z10) {
        DidiCardModel didiCardModel;
        if (z10 && didiCardView.isAttachedToWindow() && (didiCardModel = didiCardView.lastModel) != null && kotlin.jvm.internal.p.d(didiCardModel.getVendorPkg(), str) && didiCardModel.getStatus() == 90 && !didiCardView.j1(str)) {
            K.INSTANCE.c(1);
            didiCardView.q1();
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void G0(DidiCardView didiCardView, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        didiCardView.F0(list, z10);
    }

    private final void H1() {
        if (this.receiverRegistered) {
            this.receiverRegistered = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                getContext().getApplicationContext().unregisterReceiver(this.packageReceiver);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public static /* synthetic */ void J0(DidiCardView didiCardView, DidiCardModel.ActionItem actionItem, DidiCardModel.InfoRow infoRow, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            z11 = infoRow != null;
        }
        didiCardView.I0(actionItem, infoRow, z10, z11);
    }

    public static final void W0(final DidiCardView didiCardView, int i10, String str) {
        R5.b.INSTANCE.c("didi.download.callback", Y8.j.a("code", Integer.valueOf(i10)), Y8.j.a("data", str != null ? La.K.R1(str, 120) : null));
        if (i10 != 11) {
            if (i10 != 21) {
                return;
            }
            K.INSTANCE.a();
            didiCardView.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.E
                @Override // java.lang.Runnable
                public final void run() {
                    DidiCardView.Y0(this.f27367a);
                }
            });
            return;
        }
        Integer numO1 = didiCardView.o1(str);
        if (numO1 != null) {
            K.INSTANCE.c(numO1.intValue());
            didiCardView.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.D
                @Override // java.lang.Runnable
                public final void run() {
                    DidiCardView.X0(this.f27366a);
                }
            });
        }
    }

    public static final void X0(DidiCardView didiCardView) {
        didiCardView.q1();
    }

    public static final void Y0(DidiCardView didiCardView) {
        if (didiCardView.t1()) {
            return;
        }
        didiCardView.q1();
    }

    private final void a1() {
        final String str;
        DidiCardModel didiCardModel = this.lastModel;
        if (didiCardModel == null || didiCardModel.getStatus() != 90 || (str = this.boundVendorPkg) == null) {
            return;
        }
        AppDetailRepository.INSTANCE.i(str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DidiCardView.b1(this.f27364a, str, (AppDetail) obj);
            }
        });
    }

    public static final Y8.t b1(DidiCardView didiCardView, String str, AppDetail appDetail) {
        DidiCardModel didiCardModel;
        if (appDetail != null && (didiCardModel = didiCardView.lastModel) != null && kotlin.jvm.internal.p.d(didiCardModel.getVendorPkg(), str) && didiCardModel.getStatus() == 90) {
            DidiCardModel.AppItem app = didiCardModel.getApp();
            T5.k kVar = didiCardView.appStore;
            if (app != null && kVar != null) {
                didiCardView.g0(kVar, app, appDetail, didiCardModel);
            }
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    private final void d1() {
        LinearLayout linearLayoutB;
        LinearLayout linearLayoutB2;
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        setVisibility(0);
        lVar.llDidiShell.setVisibility(0);
        lVar.llDidiStoreHeader.setVisibility(8);
        lVar.llDidiAuthHeader.setVisibility(8);
        lVar.tvDidiAuthSubtitle.setVisibility(8);
        lVar.tvDidiAuthSuccess.setVisibility(8);
        lVar.tvDidiTitle.setVisibility(8);
        lVar.tvDidiRoute.setVisibility(8);
        lVar.llDidiPlate.setVisibility(8);
        lVar.tvDidiSummary.setVisibility(8);
        lVar.tvDidiNote.setVisibility(8);
        T5.k kVar = this.appStore;
        if (kVar != null && (linearLayoutB2 = kVar.b()) != null) {
            linearLayoutB2.setVisibility(8);
        }
        T5.m mVar = this.carTypeBlock;
        if (mVar != null && (linearLayoutB = mVar.b()) != null) {
            linearLayoutB.setVisibility(8);
        }
        lVar.llDidiInfoRows.removeAllViews();
        lVar.llDidiInfoRows.setVisibility(8);
        lVar.llDidiButtons.setVisibility(8);
        lVar.llDidiPillCta.setVisibility(8);
        lVar.vDidiPillDivider.setVisibility(8);
    }

    private final <T> T e1(ViewStub stub, InterfaceC5074l<? super View, ? extends T> bind) {
        T t10;
        try {
            Result.Companion companion = Result.INSTANCE;
            View viewInflate = stub.inflate();
            kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
            t10 = (T) Result.b(bind.invoke(viewInflate));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            t10 = (T) Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(t10);
        if (thE != null) {
            R5.b.INSTANCE.h("didi.stub.inflate.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        if (Result.g(t10)) {
            return null;
        }
        return t10;
    }

    private final boolean k1(String pkg) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage(pkg);
            boolean z10 = false;
            if (launchIntentForPackage == null) {
                R5.b.INSTANCE.h("didi.launch.noIntent", Y8.j.a("pkg", pkg));
            } else {
                N5.d.A(this, pkg, false, 2, null);
                if (!(getContext() instanceof Activity)) {
                    launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                getContext().startActivity(launchIntentForPackage);
                R5.b.INSTANCE.c("didi.launch.ok", Y8.j.a("pkg", pkg));
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("didi.launch.fail", Y8.j.a("pkg", pkg), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public static /* synthetic */ void m1(DidiCardView didiCardView, ImageView imageView, String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z10 = false;
        }
        didiCardView.l1(imageView, str, i10, i11, z10);
    }

    public static /* synthetic */ void n0(DidiCardView didiCardView, CardEnvelope cardEnvelope, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "poll";
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        didiCardView.m0(cardEnvelope, str, str2, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
        DidiCardModel.ActionItem primaryAction;
        DidiCardModel didiCardModel = this.lastModel;
        if (didiCardModel == null || didiCardModel.getStatus() != 90 || (primaryAction = didiCardModel.getPrimaryAction()) == null || this.appStore == null) {
            return;
        }
        K k10 = K.INSTANCE;
        String strD = k10.d(getContext(), didiCardModel.getBackendInstallState(), didiCardModel.getVendorPkg());
        DidiCardModel.ActionItem actionItemA = primaryAction.a((15358 & 1) != 0 ? primaryAction.label : a0.INSTANCE.m(strD), (15358 & 2) != 0 ? primaryAction.backgroundRes : 0, (15358 & 4) != 0 ? primaryAction.textColorRes : 0, (15358 & 8) != 0 ? primaryAction.appLink : null, (15358 & 16) != 0 ? primaryAction.webLink : null, (15358 & 32) != 0 ? primaryAction.intentPackage : null, (15358 & 64) != 0 ? primaryAction.sendsChatReply : false, (15358 & 128) != 0 ? primaryAction.chatReplyText : null, (15358 & 256) != 0 ? primaryAction.localDismiss : false, (15358 & 512) != 0 ? primaryAction.localDim : false, (15358 & 1024) != 0 ? primaryAction.launchPackage : k10.b(strD, didiCardModel.getVendorPkg()), (15358 & 2048) != 0 ? primaryAction.fallbackLaunchPackage : null, (15358 & 4096) != 0 ? primaryAction.storeLink : null, (15358 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? primaryAction.storeLinkPackage : null, (15358 & 16384) != 0 ? primaryAction.showLoading : kotlin.jvm.internal.p.d(strD, "installing"));
        this.lastModel = DidiCardModel.c(didiCardModel, null, 0, false, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, actionItemA, null, null, -1, 13, null);
        l0(actionItemA);
    }

    private final void s1() {
        Object objB;
        if (this.receiverRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getContext().getApplicationContext().registerReceiver(this.packageReceiver, intentFilter, 4));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("didi.install.register.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        this.receiverRegistered = Result.h(objB);
    }

    public static final void t0(DidiCardModel.ActionItem actionItem, DidiCardView didiCardView, View view) {
        C3314k.AuthIds aVarR0;
        String strB;
        R5.b.INSTANCE.c("didi.action.click", Y8.j.a(DidiCardProvider.ACTION_DISMISS, Boolean.valueOf(actionItem.getLocalDismiss())), Y8.j.a("launchPackage", actionItem.getLaunchPackage()));
        String launchPackage = actionItem.getLaunchPackage();
        if (actionItem.getLocalDismiss()) {
            didiCardView.setVisibility(8);
            return;
        }
        if (actionItem.getLocalDim()) {
            DidiCardModel didiCardModel = didiCardView.lastModel;
            didiCardView.dimmedStatus = didiCardModel != null ? Integer.valueOf(didiCardModel.getStatus()) : null;
            didiCardView.k0();
            return;
        }
        if (actionItem.getSendsChatReply() && didiCardView.v1(actionItem)) {
            DidiCardModel didiCardModel2 = didiCardView.lastModel;
            if (didiCardModel2 != null) {
                DidiCardModel didiCardModel3 = didiCardModel2.getStatus() == 1 ? didiCardModel2 : null;
                if (didiCardModel3 != null) {
                    M5.d dVar = M5.d.INSTANCE;
                    List<DidiCardModel.CarTypeItem> listK = didiCardModel3.k();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listK) {
                        if (didiCardView.carSelection.contains(((DidiCardModel.CarTypeItem) obj).getId())) {
                            arrayList.add(obj);
                        }
                    }
                    dVar.e(didiCardModel3, arrayList);
                    e0.INSTANCE.g(didiCardView, didiCardModel3);
                    return;
                }
                return;
            }
            return;
        }
        if (launchPackage == null || !didiCardView.k1(launchPackage)) {
            DidiCardModel didiCardModel4 = didiCardView.lastModel;
            if (didiCardModel4 != null && didiCardModel4.getStatus() == 91) {
                M5.d.INSTANCE.l(didiCardModel4);
            }
            String fallbackLaunchPackage = actionItem.getFallbackLaunchPackage();
            boolean z10 = false;
            if (fallbackLaunchPackage != null && didiCardView.k1(fallbackLaunchPackage)) {
                z10 = true;
            }
            if ((N5.d.G(didiCardView, actionItem.getAppLink(), actionItem.getWebLink(), actionItem.getIntentPackage(), false, false, false, 56, null) || z10 || N5.d.G(didiCardView, actionItem.getStoreLink(), null, actionItem.getStoreLinkPackage(), false, false, false, 56, null)) && didiCardModel4 != null && didiCardModel4.getStatus() == 91) {
                if (didiCardModel4 != null && didiCardView.i1(didiCardModel4) && (aVarR0 = didiCardView.r0(didiCardModel4)) != null && (strB = aVarR0.getThirdUid()) != null) {
                    X.INSTANCE.o(strB, didiCardModel4.getCardId());
                }
                if (La.D.L(didiCardModel4.getBizChannel(), q0.CAOCAO, true)) {
                    C3309f.INSTANCE.i(didiCardModel4);
                    didiCardView.dimmedStatus = 91;
                    didiCardView.k0();
                }
                C3316m.INSTANCE.a(didiCardModel4.getBizChannel());
            }
        }
    }

    public static final void x0(DidiCardView didiCardView, DidiCardModel.CarTypeItem carTypeItem, T5.n nVar, List list, View view) {
        boolean zContains = didiCardView.carSelection.contains(carTypeItem.getId());
        boolean z10 = !zContains;
        if (zContains) {
            didiCardView.carSelection.remove(carTypeItem.getId());
        } else {
            didiCardView.carSelection.add(carTypeItem.getId());
        }
        nVar.cbDidiCarType.setChecked(z10);
        didiCardView.p1(list);
    }

    public final void A0(boolean showsDriverAvatar) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        lVar.ivDidiDriverAvatar.setVisibility(showsDriverAvatar ? 0 : 8);
        lVar.tvDidiCtaRowLabel.setCompoundDrawablesRelative(null, null, null, null);
    }

    public final void A1(String cardId, List<DidiCardModel.CarTypeItem> types) {
        List<DidiCardModel.CarTypeItem> list = types;
        String str = cardId + "|" + Z8.F.A0(list, "|", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DidiCardView.B1((DidiCardModel.CarTypeItem) obj);
            }
        }, 30, null);
        if (kotlin.jvm.internal.p.d(str, this.carSelectionKey)) {
            return;
        }
        this.carSelectionKey = str;
        this.carSelection.clear();
        for (DidiCardModel.CarTypeItem carTypeItem : list) {
            if (carTypeItem.getSelectedByDefault()) {
                this.carSelection.add(carTypeItem.getId());
            }
        }
        this.dimmedStatus = null;
        this.persistentDimmed = false;
    }

    public final void B0(DidiCardModel.ActionItem secondary, DidiCardModel.ActionItem primary) {
        T5.l lVar = this.didi;
        T5.l lVar2 = null;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        TextView btnDidiSecondary = lVar.btnDidiSecondary;
        kotlin.jvm.internal.p.h(btnDidiSecondary, "btnDidiSecondary");
        f0(btnDidiSecondary, secondary);
        T5.l lVar3 = this.didi;
        if (lVar3 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar3 = null;
        }
        TextView btnDidiPrimary = lVar3.btnDidiPrimary;
        kotlin.jvm.internal.p.h(btnDidiPrimary, "btnDidiPrimary");
        f0(btnDidiPrimary, primary);
        T5.l lVar4 = this.didi;
        if (lVar4 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
        } else {
            lVar2 = lVar4;
        }
        lVar2.llDidiButtons.setVisibility((secondary == null && primary == null) ? 8 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0249 A[PHI: r4
      0x0249: PHI (r4v14 int) = (r4v13 int), (r4v31 int), (r4v31 int), (r4v31 int), (r4v31 int), (r4v31 int), (r4v31 int), (r4v31 int) binds: [B:96:0x0248, B:99:0x0250, B:109:0x0278, B:110:0x027a, B:112:0x0280, B:114:0x0294, B:104:0x025d, B:106:0x0269] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // N5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(N5.n r17) {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView.C(N5.n):void");
    }

    public final void C0(DidiCardModel model) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        DidiLoopMarqueeTextView tvDidiSummary = lVar.tvDidiSummary;
        kotlin.jvm.internal.p.h(tvDidiSummary, "tvDidiSummary");
        n(tvDidiSummary, model.getSummaryText());
        boolean z10 = model.getStatus() == 6;
        ViewGroup.LayoutParams layoutParams = tvDidiSummary.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        int iZ0 = z10 ? Z0(FINISHED_SUMMARY_WIDTH_DP) : -1;
        if (layoutParams2.width != iZ0) {
            layoutParams2.width = iZ0;
            tvDidiSummary.setLayoutParams(layoutParams2);
        }
        tvDidiSummary.e(z10, Z0(36));
    }

    public final void C1() {
        final String str = this.listenerPkg;
        if (str == null && (str = this.boundVendorPkg) == null) {
            return;
        }
        DownloadTaskRepository.INSTANCE.g(str, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DidiCardView.D1(this.f27368a, str, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final void D0(String title, String subtitle, int fallbackIconRes, float iconSizeDp) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        lVar.llDidiAuthHeader.setVisibility(0);
        int iApplyDimension = (int) TypedValue.applyDimension(1, iconSizeDp, getResources().getDisplayMetrics());
        ImageView imageView = lVar.ivDidiAuthIcon;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = iApplyDimension;
        layoutParams.height = iApplyDimension;
        imageView.setLayoutParams(layoutParams);
        try {
            Result.Companion companion = Result.INSTANCE;
            com.stepos.ailauncher.common.imageloader.g gVar = com.stepos.ailauncher.common.imageloader.g.INSTANCE;
            ImageView ivDidiAuthIcon = lVar.ivDidiAuthIcon;
            kotlin.jvm.internal.p.h(ivDidiAuthIcon, "ivDidiAuthIcon");
            gVar.l(ivDidiAuthIcon);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        if (fallbackIconRes != 0) {
            lVar.ivDidiAuthIcon.setImageResource(fallbackIconRes);
        } else {
            lVar.ivDidiAuthIcon.setImageDrawable(null);
        }
        TextView tvDidiAuthTitle = lVar.tvDidiAuthTitle;
        kotlin.jvm.internal.p.h(tvDidiAuthTitle, "tvDidiAuthTitle");
        n(tvDidiAuthTitle, title);
        TextView tvDidiAuthSubtitle = lVar.tvDidiAuthSubtitle;
        kotlin.jvm.internal.p.h(tvDidiAuthSubtitle, "tvDidiAuthSubtitle");
        n(tvDidiAuthSubtitle, subtitle);
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        T5.l lVarC = T5.l.c(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(lVarC, "inflate(...)");
        this.didi = lVarC;
    }

    public final void E0(TextView tv, String text, C5680i range, int highlightColorRes) {
        if (text == null || range == null) {
            n(tv, text);
            return;
        }
        if (range.getFirst() < 0 || range.getLast() >= text.length() || range.isEmpty()) {
            n(tv, text);
            return;
        }
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.a.c(getContext(), highlightColorRes)), range.getFirst(), range.getLast() + 1, 33);
        tv.setText(spannableString);
        tv.setVisibility(0);
    }

    public final void E1(String reason) {
        String cardId;
        DidiCardModel didiCardModel = this.lastModel;
        if (n1()) {
            if (isAttachedToWindow()) {
                s1();
                r1();
                return;
            }
            return;
        }
        H1();
        G1();
        if (La.D.L(didiCardModel != null ? didiCardModel.getBizChannel() : null, q0.CAOCAO, true)) {
            R5.b bVar = R5.b.INSTANCE;
            String str = "didi.install.tracking.skip.caocao:" + (didiCardModel != null ? didiCardModel.getCardId() : null) + ServerSentEventKt.COLON + reason;
            if (didiCardModel == null || (cardId = didiCardModel.getCardId()) == null) {
                cardId = "null";
            }
            bVar.e(str, "didi.install.tracking.skip", Y8.j.a("taskId", cardId), Y8.j.a("status", didiCardModel != null ? Integer.valueOf(didiCardModel.getStatus()) : null), Y8.j.a("bizChannel", didiCardModel != null ? didiCardModel.getBizChannel() : null), Y8.j.a("reason", reason));
        }
    }

    public final void F0(List<DidiCardModel.InfoRow> rows, boolean showDividers) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        LinearLayout llDidiInfoRows = lVar.llDidiInfoRows;
        kotlin.jvm.internal.p.h(llDidiInfoRows, "llDidiInfoRows");
        llDidiInfoRows.removeAllViews();
        if (rows.isEmpty()) {
            llDidiInfoRows.setVisibility(8);
            return;
        }
        llDidiInfoRows.setVisibility(0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        for (DidiCardModel.InfoRow infoRow : rows) {
            T5.o oVarC = T5.o.c(layoutInflaterFrom, llDidiInfoRows, false);
            kotlin.jvm.internal.p.h(oVarC, "inflate(...)");
            View childAt = oVarC.b().getChildAt(0);
            if (childAt != null) {
                childAt.setVisibility(showDividers ? 0 : 8);
            }
            oVarC.tvDidiRowLabel.setText(infoRow.getLabel());
            oVarC.tvDidiRowValue.setText(infoRow.getValue());
            llDidiInfoRows.addView(oVarC.b());
        }
    }

    public final void F1(String reason) {
        String orderNo;
        DidiCardView didiCardView;
        DidiCardModel didiCardModel = this.lastModel;
        if (didiCardModel == null || (orderNo = didiCardModel.getOrderNo()) == null) {
            return;
        }
        String str = orderNo.length() > 0 ? orderNo : null;
        if (str != null && getWindowVisibility() == 0 && isAttachedToWindow() && !g1()) {
            TaxiVendorSpec taxiVendorSpecB = q0.INSTANCE.b(didiCardModel.getBizChannel());
            if (!taxiVendorSpecB.getPollsOrderStatus()) {
                R5.b.INSTANCE.e("poller.skip.vendor:" + str, "poller.skip.vendor", Y8.j.a("orderNo", str), Y8.j.a("bizChannel", didiCardModel.getBizChannel()), Y8.j.a("reason", reason));
                return;
            }
            TaxiOrderPoller taxiOrderPoller = TaxiOrderPoller.INSTANCE;
            CardEnvelope cardEnvelopeF = taxiOrderPoller.f(str);
            if (cardEnvelopeF != null) {
                didiCardView = this;
                n0(didiCardView, cardEnvelopeF, str, reason, false, 8, null);
            } else {
                didiCardView = this;
            }
            if (didiCardView.g1()) {
                return;
            }
            String platformOrderId = didiCardModel.getPlatformOrderId();
            String cardId = didiCardModel.getCardId();
            DidiCardModel didiCardModel2 = didiCardView.lastModel;
            taxiOrderPoller.u(didiCardView, taxiVendorSpecB, str, platformOrderId, cardId, didiCardModel2 != null ? Integer.valueOf(didiCardModel2.getStatus()) : null, didiCardView.getBoundEnvelope());
        }
    }

    public final void G1() {
        if (this.downloadListenerRegistered) {
            this.downloadListenerRegistered = false;
            String str = this.listenerPkg;
            if (str == null) {
                return;
            }
            this.listenerPkg = null;
            try {
                Result.Companion companion = Result.INSTANCE;
                AppCenterSdk.getInstance().unRegisterListener(str, 0, this.downloadListener);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void H0(DidiCardModel model) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        M0(model, false);
        TextView tvDidiRoute = lVar.tvDidiRoute;
        kotlin.jvm.internal.p.h(tvDidiRoute, "tvDidiRoute");
        n(tvDidiRoute, model.getRouteText());
        boolean z10 = model.getStatus() == 2;
        if (z10) {
            lVar.tvDidiTitle.setTextSize(2, 12.0f);
            lVar.tvDidiTitle.setTypeface(null, 0);
        }
        lVar.tvDidiNote.setTextColor(androidx.core.content.a.c(getContext(), z10 ? R$color.card_text_primary : R$color.card_text_secondary));
        lVar.tvDidiNote.setTextSize(2, z10 ? 14.0f : 13.0f);
        TextView tvDidiNote = lVar.tvDidiNote;
        kotlin.jvm.internal.p.h(tvDidiNote, "tvDidiNote");
        w1(tvDidiNote, z10 ? 24 : 8);
        TextView tvDidiNote2 = lVar.tvDidiNote;
        kotlin.jvm.internal.p.h(tvDidiNote2, "tvDidiNote");
        n(tvDidiNote2, model.getNoteText());
        K0(model);
        DidiLoopMarqueeTextView tvDidiSummary = lVar.tvDidiSummary;
        kotlin.jvm.internal.p.h(tvDidiSummary, "tvDidiSummary");
        n(tvDidiSummary, model.getSummaryText());
        LinearLayout llDidiInfoRows = lVar.llDidiInfoRows;
        kotlin.jvm.internal.p.h(llDidiInfoRows, "llDidiInfoRows");
        w1(llDidiInfoRows, z10 ? 24 : 8);
        F0(model.o(), false);
        LinearLayout llDidiPillCta = lVar.llDidiPillCta;
        kotlin.jvm.internal.p.h(llDidiPillCta, "llDidiPillCta");
        w1(llDidiPillCta, 20);
        J0(this, model.getPrimaryAction(), model.getCtaRow(), false, z10, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I0(com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel.ActionItem r6, com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel.InfoRow r7, boolean r8, boolean r9) {
        /*
            r5 = this;
            T5.l r0 = r5.didi
            r1 = 0
            if (r0 != 0) goto Lb
            java.lang.String r0 = "didi"
            kotlin.jvm.internal.p.A(r0)
            r0 = r1
        Lb:
            android.widget.TextView r2 = r0.tvDidiCtaRowLabel
            java.lang.String r3 = "tvDidiCtaRowLabel"
            kotlin.jvm.internal.p.h(r2, r3)
            if (r7 == 0) goto L1a
            java.lang.String r3 = r7.getLabel()
            goto L1b
        L1a:
            r3 = r1
        L1b:
            r5.n(r2, r3)
            if (r7 == 0) goto L25
            java.lang.String r2 = r7.getValue()
            goto L26
        L25:
            r2 = r1
        L26:
            r5.y0(r2)
            r2 = 1
            r3 = 0
            if (r8 == 0) goto L37
            if (r7 == 0) goto L33
            java.lang.String r1 = r7.getLabel()
        L33:
            if (r1 == 0) goto L37
            r8 = r2
            goto L38
        L37:
            r8 = r3
        L38:
            r5.z0(r8)
            if (r6 != 0) goto L41
            if (r7 == 0) goto L40
            goto L41
        L40:
            r2 = r3
        L41:
            android.view.View r1 = r0.vDidiPillDivider
            r4 = 8
            if (r9 == 0) goto L4b
            if (r2 == 0) goto L4b
            r9 = r3
            goto L4c
        L4b:
            r9 = r4
        L4c:
            r1.setVisibility(r9)
            r5.A0(r8)
            if (r6 != 0) goto L63
            android.widget.LinearLayout r5 = r0.btnDidiPillCta
            r5.setVisibility(r4)
            android.widget.LinearLayout r5 = r0.llDidiPillCta
            if (r7 == 0) goto L5e
            goto L5f
        L5e:
            r3 = r4
        L5f:
            r5.setVisibility(r3)
            return
        L63:
            android.widget.LinearLayout r7 = r0.llDidiPillCta
            r7.setVisibility(r3)
            android.widget.LinearLayout r7 = r0.btnDidiPillCta
            r7.setVisibility(r3)
            android.widget.LinearLayout r7 = r0.btnDidiPillCta
            int r8 = r6.getBackgroundRes()
            r7.setBackgroundResource(r8)
            android.widget.TextView r7 = r0.tvDidiPillLabel
            java.lang.String r8 = r6.getLabel()
            r7.setText(r8)
            android.widget.TextView r7 = r0.tvDidiPillLabel
            android.content.Context r8 = r5.getContext()
            int r9 = r6.getTextColorRes()
            int r8 = androidx.core.content.a.c(r8, r9)
            r7.setTextColor(r8)
            android.widget.LinearLayout r7 = r0.btnDidiPillCta
            java.lang.String r8 = r6.getLabel()
            r7.setContentDescription(r8)
            android.widget.LinearLayout r7 = r0.btnDidiPillCta
            java.lang.String r8 = "btnDidiPillCta"
            kotlin.jvm.internal.p.h(r7, r8)
            r5.s0(r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView.I0(com.stepos.ailauncher.foundation.appui.card.provider.didi.y$a, com.stepos.ailauncher.foundation.appui.card.provider.didi.y$d, boolean, boolean):void");
    }

    public final void I1(DidiCardModel model, String reason) {
        TaxiVendorSpec taxiVendorSpecB = q0.INSTANCE.b(model.getBizChannel());
        if (taxiVendorSpecB.getChecksAuthStatus()) {
            DidiAuthStatusPoller didiAuthStatusPoller = DidiAuthStatusPoller.INSTANCE;
            C3314k.AuthIds aVarR0 = r0(model);
            didiAuthStatusPoller.r(this, aVarR0 != null ? aVarR0.getThirdUid() : null, reason);
        } else if (taxiVendorSpecB.getChecksCredentialStatus()) {
            CaocaoAuthStatusPoller caocaoAuthStatusPoller = CaocaoAuthStatusPoller.INSTANCE;
            CaocaoAuthConfig caocaoAuthConfigR0 = R0(model);
            caocaoAuthStatusPoller.j(this, caocaoAuthConfigR0 != null ? caocaoAuthConfigR0.c() : null, reason);
        }
    }

    public final void K0(DidiCardModel model) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        DidiLoopMarqueeTextView tvDidiPlateTitle = lVar.tvDidiPlateTitle;
        kotlin.jvm.internal.p.h(tvDidiPlateTitle, "tvDidiPlateTitle");
        E0(tvDidiPlateTitle, model.getPlateTitle(), model.getPlateTitleHighlight(), model.getVendorHighlightColorRes());
        boolean z10 = true;
        lVar.tvDidiPlateTitle.e(model.getStatus() == 6 && La.D.L(model.getBizChannel(), q0.CAOCAO, true), Z0(36));
        TextView tvDidiPlateSubtitle = lVar.tvDidiPlateSubtitle;
        kotlin.jvm.internal.p.h(tvDidiPlateSubtitle, "tvDidiPlateSubtitle");
        n(tvDidiPlateSubtitle, model.getPlateSubtitle());
        L0(model.getStatus());
        if (lVar.tvDidiPlateTitle.getVisibility() != 0 && lVar.tvDidiPlateSubtitle.getVisibility() != 0) {
            z10 = false;
        }
        boolean zContains = CAR_IMAGE_STATUSES.contains(Integer.valueOf(model.getStatus()));
        lVar.llDidiPlate.setVisibility((z10 || zContains) ? 0 : 8);
        lVar.ivDidiPlateCar.setVisibility(zContains ? 0 : 8);
        if (zContains) {
            ImageView ivDidiPlateCar = lVar.ivDidiPlateCar;
            kotlin.jvm.internal.p.h(ivDidiPlateCar, "ivDidiPlateCar");
            l1(ivDidiPlateCar, model.getCarImageUrl(), R$drawable.ic_card_didi_car_model, 0, true);
        }
    }

    public final void L0(int status) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        TextView textView = lVar.tvDidiPlateSubtitle;
        boolean z10 = status == 3 || status == 4 || status == 5;
        textView.setIncludeFontPadding(true);
        textView.setLetterSpacing(0.0f);
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(androidx.core.content.a.c(textView.getContext(), status == 2 ? R$color.card_didi_matching_hint : R$color.card_text_secondary));
        if (z10) {
            textView.setTypeface(Typeface.create(Typeface.DEFAULT, 260, false));
            textView.setLineHeight(x1(20.0f));
        } else {
            textView.setTypeface(null, 0);
            textView.setLineSpacing(0.0f, 1.0f);
        }
    }

    public final void M0(DidiCardModel model, boolean compact) {
        T5.l lVar = this.didi;
        T5.l lVar2 = null;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        TextView tvDidiTitle = lVar.tvDidiTitle;
        kotlin.jvm.internal.p.h(tvDidiTitle, "tvDidiTitle");
        tvDidiTitle.setTextSize(2, compact ? 14.0f : 16.0f);
        tvDidiTitle.setTypeface(null, !compact ? 1 : 0);
        tvDidiTitle.setTextColor(androidx.core.content.a.c(getContext(), R$color.card_text_primary));
        E0(tvDidiTitle, model.getTitle(), model.getTitleHighlight(), model.getVendorHighlightColorRes());
        T5.l lVar3 = this.didi;
        if (lVar3 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
        } else {
            lVar2 = lVar3;
        }
        DidiLoopMarqueeTextView tvDidiTitleTrailing = lVar2.tvDidiTitleTrailing;
        kotlin.jvm.internal.p.h(tvDidiTitleTrailing, "tvDidiTitleTrailing");
        n(tvDidiTitleTrailing, model.getTitleTrailing());
        N0(model.getStatus());
    }

    public final void N0(int status) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        DidiLoopMarqueeTextView didiLoopMarqueeTextView = lVar.tvDidiTitleTrailing;
        boolean z10 = status == 6;
        ViewGroup.LayoutParams layoutParams = didiLoopMarqueeTextView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        int iZ0 = z10 ? Z0(FINISHED_TITLE_TRAILING_WIDTH_DP) : -2;
        if (layoutParams2.width != iZ0) {
            layoutParams2.width = iZ0;
            didiLoopMarqueeTextView.setLayoutParams(layoutParams2);
        }
        didiLoopMarqueeTextView.e(z10, Z0(36));
    }

    public final void O0(DidiCardModel model, boolean compactTitle) {
        u1();
        M0(model, compactTitle);
        T5.l lVar = this.didi;
        T5.l lVar2 = null;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        TextView tvDidiRoute = lVar.tvDidiRoute;
        kotlin.jvm.internal.p.h(tvDidiRoute, "tvDidiRoute");
        n(tvDidiRoute, model.getRouteText());
        T5.l lVar3 = this.didi;
        if (lVar3 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar3 = null;
        }
        TextView tvDidiNote = lVar3.tvDidiNote;
        kotlin.jvm.internal.p.h(tvDidiNote, "tvDidiNote");
        n(tvDidiNote, model.getNoteText());
        K0(model);
        C0(model);
        G0(this, model.o(), false, 2, null);
        boolean z10 = model.getStatus() == 3 || model.getStatus() == 4;
        T5.l lVar4 = this.didi;
        if (lVar4 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
        } else {
            lVar2 = lVar4;
        }
        LinearLayout llDidiPillCta = lVar2.llDidiPillCta;
        kotlin.jvm.internal.p.h(llDidiPillCta, "llDidiPillCta");
        w1(llDidiPillCta, z10 ? 12 : 20);
        I0(model.getPrimaryAction(), model.getCtaRow(), z10, true);
    }

    public final void P0(DidiCardModel model) {
        D0(model.getAuthTitle(), model.getAuthSubtitle(), model.getVendorFallbackIconRes(), f1(model) ? 56.0f : 44.0f);
        B0(model.getSecondaryAction(), model.getPrimaryAction());
        T5.l lVar = this.didi;
        T5.l lVar2 = null;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        TextView tvDidiAuthSuccess = lVar.tvDidiAuthSuccess;
        kotlin.jvm.internal.p.h(tvDidiAuthSuccess, "tvDidiAuthSuccess");
        String noteText = model.getNoteText();
        if (!f1(model)) {
            noteText = null;
        }
        n(tvDidiAuthSuccess, noteText);
        T5.l lVar3 = this.didi;
        if (lVar3 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar3 = null;
        }
        lVar3.llDidiShell.requestLayout();
        T5.l lVar4 = this.didi;
        if (lVar4 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
        } else {
            lVar2 = lVar4;
        }
        lVar2.b().requestLayout();
        k0();
    }

    @Override // N5.d
    public boolean Q(CardEnvelope envelope) {
        kotlin.jvm.internal.p.i(envelope, "envelope");
        Integer taskStatus = envelope.getTaskStatus();
        return (taskStatus != null && taskStatus.intValue() == 91 && La.D.L(envelope.getBizChannel(), q0.CAOCAO, true)) ? false : true;
    }

    public final void Q0(DidiCardModel model) {
        T5.l lVar = this.didi;
        T5.l lVar2 = null;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        TextView tvDidiNote = lVar.tvDidiNote;
        kotlin.jvm.internal.p.h(tvDidiNote, "tvDidiNote");
        n(tvDidiNote, model.getNoteText());
        T5.l lVar3 = this.didi;
        if (lVar3 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar3 = null;
        }
        LinearLayout linearLayout = lVar3.llDidiShell;
        T5.l lVar4 = this.didi;
        if (lVar4 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
        } else {
            lVar2 = lVar4;
        }
        linearLayout.setVisibility(lVar2.tvDidiNote.getVisibility() == 0 ? 0 : 8);
    }

    public final CaocaoAuthConfig R0(DidiCardModel model) {
        Object objB;
        String credentialVendorId;
        String credentialIntegrationId;
        TaxiVendorSpec taxiVendorSpecB = q0.INSTANCE.b(model.getBizChannel());
        if (!taxiVendorSpecB.getChecksCredentialStatus()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(com.stepos.ailauncher.foundation.account.f.INSTANCE.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            return null;
        }
        if (La.H.x0(str)) {
            str = null;
        }
        if (str == null || (credentialVendorId = taxiVendorSpecB.getCredentialVendorId()) == null) {
            return null;
        }
        if (La.H.x0(credentialVendorId)) {
            credentialVendorId = null;
        }
        if (credentialVendorId == null || (credentialIntegrationId = taxiVendorSpecB.getCredentialIntegrationId()) == null) {
            return null;
        }
        if (La.H.x0(credentialIntegrationId)) {
            credentialIntegrationId = null;
        }
        if (credentialIntegrationId == null) {
            return null;
        }
        return new CaocaoAuthConfig(str, credentialVendorId, credentialIntegrationId);
    }

    public final String S0() {
        List<DidiCardModel.CarTypeItem> listK;
        DidiCardModel didiCardModel = this.lastModel;
        if (didiCardModel == null || (listK = didiCardModel.k()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK) {
            if (this.carSelection.contains(((DidiCardModel.CarTypeItem) obj).getId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String name = ((DidiCardModel.CarTypeItem) it.next()).getName();
            if (name != null) {
                arrayList2.add(name);
            }
        }
        return a0.INSTANCE.a(arrayList2);
    }

    public final T5.m T0() {
        T5.m mVar = this.carTypeBlock;
        if (mVar != null) {
            return mVar;
        }
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        ViewStub stubDidiCarType = lVar.stubDidiCarType;
        kotlin.jvm.internal.p.h(stubDidiCarType, "stubDidiCarType");
        T5.m mVar2 = (T5.m) e1(stubDidiCarType, DidiCardView$carTypeBlock$1.INSTANCE);
        if (mVar2 == null) {
            return null;
        }
        this.carTypeBlock = mVar2;
        return mVar2;
    }

    public final void U0(String orderNo, String reason) {
        kotlin.jvm.internal.p.i(orderNo, "orderNo");
        kotlin.jvm.internal.p.i(reason, "reason");
        DidiCardModel didiCardModel = this.lastModel;
        if (didiCardModel != null && kotlin.jvm.internal.p.d(didiCardModel.getOrderNo(), orderNo) && DidiCardProvider.INSTANCE.h(didiCardModel)) {
            TaxiOrderPoller taxiOrderPoller = TaxiOrderPoller.INSTANCE;
            if (taxiOrderPoller.n(orderNo)) {
                this.dimmedStatus = 7;
                k0();
                taxiOrderPoller.v(this, orderNo, "caocao_cancelled_history_" + reason);
                R5.b bVar = R5.b.INSTANCE;
                String cardId = didiCardModel.getCardId();
                if (cardId.length() == 0) {
                    cardId = "null";
                }
                bVar.c("didi.caocaoCancelled.dimHistory", Y8.j.a("taskId", cardId), Y8.j.a("orderNo", orderNo), Y8.j.a("status", Integer.valueOf(didiCardModel.getStatus())), Y8.j.a("reason", reason));
            }
        }
    }

    public final void V0(String reason) {
        String cardId;
        kotlin.jvm.internal.p.i(reason, "reason");
        DidiCardModel didiCardModel = this.lastModel;
        if (didiCardModel == null || didiCardModel.getStatus() != 1) {
            return;
        }
        this.dimmedStatus = 1;
        k0();
        R5.b bVar = R5.b.INSTANCE;
        DidiCardModel didiCardModel2 = this.lastModel;
        if (didiCardModel2 == null || (cardId = didiCardModel2.getCardId()) == null) {
            cardId = "null";
        }
        Pair pairA = Y8.j.a("taskId", cardId);
        DidiCardModel didiCardModel3 = this.lastModel;
        bVar.c("taxi.estimate.dimmed", pairA, Y8.j.a("bizChannel", didiCardModel3 != null ? didiCardModel3.getBizChannel() : null), Y8.j.a("reason", reason));
    }

    public final int Z0(int valueDp) {
        return (int) TypedValue.applyDimension(1, valueDp, getResources().getDisplayMetrics());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    @Override // com.stepos.ailauncher.foundation.appui.card.state.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.stepos.ailauncher.foundation.appui.card.state.CardUiStateRecord r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L8
            java.lang.String r4 = r4.getStateType()
            goto L9
        L8:
            r4 = r0
        L9:
            java.lang.String r1 = "DIMMED"
            boolean r4 = kotlin.jvm.internal.p.d(r4, r1)
            if (r4 == 0) goto L1d
            com.stepos.ailauncher.foundation.appui.card.provider.didi.y r4 = r3.lastModel
            if (r4 == 0) goto L1d
            int r4 = r4.getStatus()
            r1 = 1
            if (r4 != r1) goto L1d
            goto L1e
        L1d:
            r1 = 0
        L1e:
            r3.persistentDimmed = r1
            r3.k0()
            boolean r4 = r3.persistentDimmed
            if (r4 == 0) goto L5e
            R5.b r4 = R5.b.INSTANCE
            com.stepos.ailauncher.foundation.appui.card.provider.didi.y r1 = r3.lastModel
            if (r1 == 0) goto L33
            java.lang.String r1 = r1.getCardId()
            if (r1 != 0) goto L35
        L33:
            java.lang.String r1 = "null"
        L35:
            java.lang.String r2 = "taskId"
            kotlin.Pair r1 = Y8.j.a(r2, r1)
            com.stepos.ailauncher.foundation.appui.card.provider.didi.y r3 = r3.lastModel
            if (r3 == 0) goto L44
            java.lang.String r0 = r3.getBizChannel()
        L44:
            java.lang.String r3 = "bizChannel"
            kotlin.Pair r3 = Y8.j.a(r3, r0)
            java.lang.String r0 = "reason"
            java.lang.String r2 = "restore_persisted"
            kotlin.Pair r0 = Y8.j.a(r0, r2)
            kotlin.Pair[] r3 = new kotlin.Pair[]{r1, r3, r0}
            java.lang.String r0 = "taxi.estimate.dimmed"
            r4.c(r0, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView.a(com.stepos.ailauncher.foundation.appui.card.state.j):void");
    }

    public final void c1(DidiCardModel previous, DidiCardModel incoming, String reason) {
        TaxiOrderPoller taxiOrderPoller = TaxiOrderPoller.INSTANCE;
        String orderNo = incoming.getOrderNo();
        if (orderNo == null) {
            orderNo = previous.getOrderNo();
        }
        taxiOrderPoller.p(orderNo);
        this.lastModel = previous;
        this.gatedAuthModel = null;
        this.authorizationSourceModel = null;
        this.authorizationValidationKey = null;
        this.dimmedStatus = 7;
        k0();
        String orderNo2 = previous.getOrderNo();
        if (orderNo2 == null) {
            orderNo2 = incoming.getOrderNo();
        }
        taxiOrderPoller.v(this, orderNo2, reason);
        R5.b bVar = R5.b.INSTANCE;
        String cardId = previous.getCardId();
        if (cardId.length() == 0) {
            cardId = "null";
        }
        Pair pairA = Y8.j.a("taskId", cardId);
        String cardId2 = incoming.getCardId();
        if (cardId2.length() == 0) {
            cardId2 = "null";
        }
        Pair pairA2 = Y8.j.a("incomingTaskId", cardId2);
        String orderNo3 = previous.getOrderNo();
        bVar.c("didi.caocaoCancelled.freezeContent", pairA, pairA2, Y8.j.a("orderNo", (orderNo3 == null && (orderNo3 = incoming.getOrderNo()) == null) ? "null" : orderNo3), Y8.j.a("fromStatus", Integer.valueOf(previous.getStatus())), Y8.j.a("status", Integer.valueOf(incoming.getStatus())), Y8.j.a("reason", reason));
    }

    public final T5.k e0() {
        T5.k kVar = this.appStore;
        if (kVar != null) {
            return kVar;
        }
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        ViewStub stubDidiAppStore = lVar.stubDidiAppStore;
        kotlin.jvm.internal.p.h(stubDidiAppStore, "stubDidiAppStore");
        T5.k kVar2 = (T5.k) e1(stubDidiAppStore, DidiCardView$appStoreBlock$1.INSTANCE);
        if (kVar2 == null) {
            return null;
        }
        this.appStore = kVar2;
        return kVar2;
    }

    public final void f0(TextView button, DidiCardModel.ActionItem action) {
        if (action == null) {
            button.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        button.setText(action.getLabel());
        button.setBackgroundResource(action.getBackgroundRes());
        button.setTextColor(androidx.core.content.a.c(getContext(), action.getTextColorRes()));
        s0(button, action);
    }

    public final boolean f1(DidiCardModel didiCardModel) {
        return didiCardModel.getStatus() == 91 && didiCardModel.getPrimaryAction() == null && didiCardModel.getSecondaryAction() == null;
    }

    public final void g0(T5.k block, DidiCardModel.AppItem app, AppDetail detail, DidiCardModel model) {
        String iconUrl;
        String name;
        String sizeText;
        String extraText;
        ImageView ivDidiAppIcon = block.ivDidiAppIcon;
        kotlin.jvm.internal.p.h(ivDidiAppIcon, "ivDidiAppIcon");
        if (detail == null || (iconUrl = detail.getIconUrl()) == null) {
            iconUrl = app.getIconUrl();
        }
        m1(this, ivDidiAppIcon, iconUrl, model.getVendorFallbackIconRes(), 0, false, 16, null);
        TextView tvDidiAppName = block.tvDidiAppName;
        kotlin.jvm.internal.p.h(tvDidiAppName, "tvDidiAppName");
        if (detail == null || (name = detail.getName()) == null) {
            name = app.getName();
        }
        n(tvDidiAppName, name);
        TextView tvDidiAppSize = block.tvDidiAppSize;
        kotlin.jvm.internal.p.h(tvDidiAppSize, "tvDidiAppSize");
        if (detail == null || (sizeText = detail.getSizeText()) == null) {
            sizeText = app.getSizeText();
        }
        n(tvDidiAppSize, sizeText);
        TextView tvDidiAppExtra = block.tvDidiAppExtra;
        kotlin.jvm.internal.p.h(tvDidiAppExtra, "tvDidiAppExtra");
        if (detail == null || (extraText = detail.getDescription()) == null) {
            extraText = app.getExtraText();
        }
        n(tvDidiAppExtra, extraText);
    }

    public final boolean g1() {
        Integer num = this.dimmedStatus;
        if (num == null || num.intValue() != 7) {
            return false;
        }
        DidiCardModel didiCardModel = this.lastModel;
        return La.D.L(didiCardModel != null ? didiCardModel.getBizChannel() : null, q0.CAOCAO, true);
    }

    @Override // N5.d
    public boolean getHidesCommonChrome() {
        return this.hidesCommonChrome;
    }

    public final void h0(DidiAuthStatusDto dto, String thirdUid, String reason) {
        DidiCardModel didiCardModel;
        kotlin.jvm.internal.p.i(dto, "dto");
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (isAttachedToWindow() && (didiCardModel = this.lastModel) != null && didiCardModel.getStatus() == 91 && !f1(didiCardModel)) {
            C3314k.AuthIds aVarR0 = r0(didiCardModel);
            if (kotlin.jvm.internal.p.d(aVarR0 != null ? aVarR0.getThirdUid() : null, thirdUid)) {
                R5.b bVar = R5.b.INSTANCE;
                String cardId = didiCardModel.getCardId();
                if (cardId.length() == 0) {
                    cardId = "null";
                }
                bVar.c("didi.auth.applied", Y8.j.a("taskId", cardId), Y8.j.a("accountScope", C3324v.INSTANCE.c(thirdUid)), Y8.j.a("reason", reason));
                C(DidiCardProvider.Companion.b(DidiCardProvider.INSTANCE, didiCardModel, null, null, 6, null));
            }
        }
    }

    public final boolean h1(DidiCardModel model) {
        return model.getStatus() == 91 && q0.INSTANCE.b(model.getBizChannel()).getChecksAuthStatus() && kotlin.jvm.internal.p.d(model.getClientRenderSource(), "realtime");
    }

    public final void i0(String accountKey, String reason) {
        DidiCardModel didiCardModel;
        kotlin.jvm.internal.p.i(accountKey, "accountKey");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (isAttachedToWindow() && (didiCardModel = this.lastModel) != null && didiCardModel.getStatus() == 91 && La.D.L(didiCardModel.getBizChannel(), q0.CAOCAO, true)) {
            CaocaoAuthConfig caocaoAuthConfigR0 = R0(didiCardModel);
            if (kotlin.jvm.internal.p.d(caocaoAuthConfigR0 != null ? caocaoAuthConfigR0.getAccountKey() : null, accountKey)) {
                if (C3309f.INSTANCE.h(didiCardModel)) {
                    R5.b bVar = R5.b.INSTANCE;
                    String cardId = didiCardModel.getCardId();
                    bVar.c("caocao.auth.applied.skip", Y8.j.a("taskId", cardId.length() != 0 ? cardId : "null"), Y8.j.a("accountKey", accountKey), Y8.j.a("reason", "payment_auth_pending"));
                } else {
                    R5.b bVar2 = R5.b.INSTANCE;
                    String cardId2 = didiCardModel.getCardId();
                    bVar2.c("caocao.auth.applied", Y8.j.a("taskId", cardId2.length() != 0 ? cardId2 : "null"), Y8.j.a("accountKey", accountKey), Y8.j.a("reason", reason));
                    this.dimmedStatus = null;
                    C(DidiCardProvider.INSTANCE.a(didiCardModel, DidiCardProvider.LABEL_CAOCAO_AUTHORIZED_TITLE, DidiCardProvider.LABEL_CAOCAO_AUTHORIZED_SUBTITLE));
                }
            }
        }
    }

    public final boolean i1(DidiCardModel model) {
        return h1(model) && !f1(model);
    }

    public final void j0(String accountKey, String reason) {
        DidiCardModel didiCardModel;
        DidiCardModel didiCardModel2;
        kotlin.jvm.internal.p.i(accountKey, "accountKey");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (isAttachedToWindow() && (didiCardModel = this.lastModel) != null && didiCardModel.getStatus() == 91 && f1(didiCardModel) && La.D.L(didiCardModel.getBizChannel(), q0.CAOCAO, true)) {
            CaocaoAuthConfig caocaoAuthConfigR0 = R0(didiCardModel);
            if (kotlin.jvm.internal.p.d(caocaoAuthConfigR0 != null ? caocaoAuthConfigR0.getAccountKey() : null, accountKey) && (didiCardModel2 = this.authorizationSourceModel) != null) {
                R5.b bVar = R5.b.INSTANCE;
                String cardId = didiCardModel.getCardId();
                if (cardId.length() == 0) {
                    cardId = "null";
                }
                bVar.c("caocao.auth.revoked", Y8.j.a("taskId", cardId), Y8.j.a("accountKey", accountKey), Y8.j.a("reason", reason));
                C(didiCardModel2);
            }
        }
    }

    public final boolean j1(String pkg) {
        if (pkg.length() <= 0) {
            return false;
        }
        C3312i c3312i = C3312i.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return c3312i.a(context, pkg);
    }

    public final void k0() {
        boolean z10 = this.dimmedStatus != null || this.persistentDimmed;
        T5.l lVar = this.didi;
        T5.l lVar2 = null;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        lVar.llDidiShell.setForeground(z10 ? androidx.core.content.a.e(getContext(), R$drawable.bg_card_didi_dimmed_scrim) : null);
        T5.l lVar3 = this.didi;
        if (lVar3 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar3 = null;
        }
        TextView textView = lVar3.btnDidiSecondary;
        T5.l lVar4 = this.didi;
        if (lVar4 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar4 = null;
        }
        for (TextView textView2 : C1173v.p(textView, lVar4.btnDidiPrimary)) {
            textView2.setEnabled(!z10);
            textView2.setClickable(!z10);
        }
        T5.l lVar5 = this.didi;
        if (lVar5 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar5 = null;
        }
        lVar5.btnDidiPillCta.setEnabled(!z10);
        T5.l lVar6 = this.didi;
        if (lVar6 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
        } else {
            lVar2 = lVar6;
        }
        lVar2.btnDidiPillCta.setClickable(!z10);
        T5.m mVar = this.carTypeBlock;
        if (mVar == null) {
            return;
        }
        mVar.btnDidiCarSelectCta.setEnabled(!z10);
        mVar.btnDidiCarSelectCta.setClickable(!z10);
        LinearLayout llDidiCarTypeRows = mVar.llDidiCarTypeRows;
        kotlin.jvm.internal.p.h(llDidiCarTypeRows, "llDidiCarTypeRows");
        int childCount = llDidiCarTypeRows.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            llDidiCarTypeRows.getChildAt(i10).setClickable(!z10);
        }
    }

    public final void l0(DidiCardModel.ActionItem action) {
        T5.k kVar = this.appStore;
        if (kVar == null) {
            return;
        }
        if (action == null) {
            kVar.flDidiInstall.setVisibility(8);
            return;
        }
        kVar.flDidiInstall.setVisibility(0);
        kVar.flDidiInstall.setBackgroundResource(action.getBackgroundRes());
        kVar.flDidiInstall.setContentDescription(action.getLabel());
        kVar.tvDidiInstall.setText(action.getLabel());
        kVar.tvDidiInstall.setTextColor(androidx.core.content.a.c(getContext(), action.getTextColorRes()));
        kVar.tvDidiInstall.setVisibility(action.getShowLoading() ? 8 : 0);
        kVar.ivDidiInstallLoading.setVisibility(action.getShowLoading() ? 0 : 8);
        FrameLayout flDidiInstall = kVar.flDidiInstall;
        kotlin.jvm.internal.p.h(flDidiInstall, "flDidiInstall");
        s0(flDidiInstall, action);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Integer, java.lang.Number] */
    public final void l1(ImageView target, String url, int fallback, int corner, boolean centerCrop) {
        String str;
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            com.stepos.ailauncher.common.imageloader.g.INSTANCE.l(target);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        target.setImageDrawable(null);
        if (url == null) {
            ?? ValueOf = Integer.valueOf(fallback);
            str = ValueOf.intValue() != 0 ? ValueOf : null;
        } else {
            str = url;
        }
        if (str == null) {
            try {
                com.stepos.ailauncher.common.imageloader.g.INSTANCE.l(target);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
            if (fallback != 0) {
                target.setImageResource(fallback);
                return;
            } else {
                target.setImageDrawable(null);
                return;
            }
        }
        int i10 = str == url ? fallback : 0;
        try {
            com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, target, new ImageRequest(str, i10, i10, null, null, corner, 0, 0, 0, centerCrop, null, false, false, false, false, null, 0.0f, false, 261592, null), null, null, getContext().getApplicationContext(), 12, null);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th3));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            if (fallback != 0) {
                try {
                    target.setImageResource(fallback);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th4) {
                    Result.Companion companion5 = Result.INSTANCE;
                    Result.b(C4849c.a(th4));
                }
            }
            R5.b.INSTANCE.h("didi.image.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
    }

    public final void m0(CardEnvelope envelope, String orderNo, String reason, boolean terminalReplacement) {
        String cardId;
        Object objB;
        DidiCardModel didiCardModel;
        kotlin.jvm.internal.p.i(envelope, "envelope");
        kotlin.jvm.internal.p.i(orderNo, "orderNo");
        kotlin.jvm.internal.p.i(reason, "reason");
        DidiCardModel didiCardModel2 = this.lastModel;
        if (didiCardModel2 != null && isAttachedToWindow() && kotlin.jvm.internal.p.d(didiCardModel2.getOrderNo(), orderNo)) {
            if (envelope.getBizChannel() == null || didiCardModel2.getBizChannel() == null || kotlin.jvm.internal.p.d(envelope.getBizChannel(), didiCardModel2.getBizChannel())) {
                if (DidiCardProvider.INSTANCE.h(didiCardModel2)) {
                    TaxiOrderPoller taxiOrderPoller = TaxiOrderPoller.INSTANCE;
                    if (taxiOrderPoller.n(orderNo)) {
                        this.dimmedStatus = 7;
                        k0();
                        taxiOrderPoller.v(this, orderNo, "caocao_cancelled_history_polled");
                        R5.b bVar = R5.b.INSTANCE;
                        String cardId2 = didiCardModel2.getCardId();
                        if (cardId2.length() == 0) {
                            cardId2 = "null";
                        }
                        bVar.c("didi.caocaoCancelled.skipPolled", Y8.j.a("taskId", cardId2), Y8.j.a("orderNo", orderNo), Y8.j.a("status", Integer.valueOf(didiCardModel2.getStatus())), Y8.j.a("reason", reason));
                        return;
                    }
                }
                N5.v vVarB = N5.g.INSTANCE.b(O5.c.DIDI);
                if (vVarB == null) {
                    return;
                }
                CardEnvelope boundEnvelope = getBoundEnvelope();
                if (boundEnvelope == null || (cardId = boundEnvelope.getTaskId()) == null) {
                    cardId = didiCardModel2.getCardId();
                }
                CardEnvelope cardEnvelopeB = CardEnvelope.b(envelope, null, cardId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131069, null);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(vVarB.b(cardEnvelopeB));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                boolean zG = Result.g(objB);
                Object obj = objB;
                if (zG) {
                    obj = null;
                }
                DidiCardModel didiCardModel3 = obj instanceof DidiCardModel ? (DidiCardModel) obj : null;
                if (didiCardModel3 == null) {
                    return;
                }
                if (terminalReplacement && Z8.Y.j(7, 27).contains(Integer.valueOf(didiCardModel3.getStatus())) && !o0.INSTANCE.f(Integer.valueOf(didiCardModel2.getStatus()))) {
                    R5.b bVar2 = R5.b.INSTANCE;
                    String cardId3 = didiCardModel2.getCardId();
                    if (cardId3.length() == 0) {
                        cardId3 = "null";
                    }
                    bVar2.c("didi.cancel.skip_terminal_replace", Y8.j.a("taskId", cardId3), Y8.j.a("orderNo", orderNo), Y8.j.a("currentStatus", Integer.valueOf(didiCardModel2.getStatus())), Y8.j.a("incomingStatus", Integer.valueOf(didiCardModel3.getStatus())), Y8.j.a("reason", "source_status_not_replaceable"));
                    return;
                }
                if (!o0.INSTANCE.h(Integer.valueOf(didiCardModel2.getStatus()), Integer.valueOf(didiCardModel3.getStatus()))) {
                    R5.b.INSTANCE.c("didi.poll.skip.stale", Y8.j.a("orderNo", orderNo), Y8.j.a("fromStatus", Integer.valueOf(didiCardModel2.getStatus())), Y8.j.a("status", Integer.valueOf(didiCardModel3.getStatus())), Y8.j.a("reason", reason));
                    return;
                }
                if (g1()) {
                    didiCardModel = didiCardModel2;
                    if (DidiCardProvider.INSTANCE.k(didiCardModel, didiCardModel3)) {
                        c1(didiCardModel, didiCardModel3, "caocao_cancelled_frozen_poll");
                        return;
                    }
                } else {
                    didiCardModel = didiCardModel2;
                }
                if (DidiCardProvider.INSTANCE.i(didiCardModel, didiCardModel3)) {
                    c1(didiCardModel, didiCardModel3, "caocao_cancelled_poll");
                    return;
                }
                if (kotlin.jvm.internal.p.d(didiCardModel3, didiCardModel)) {
                    R5.b.INSTANCE.c("didi.poll.unchanged", Y8.j.a("orderNo", orderNo), Y8.j.a("status", Integer.valueOf(didiCardModel.getStatus())), Y8.j.a("reason", reason));
                    return;
                }
                R5.b bVar3 = R5.b.INSTANCE;
                String taskId = cardEnvelopeB.getTaskId();
                if (taskId.length() == 0) {
                    taskId = "null";
                }
                bVar3.c("didi.poll.applied", Y8.j.a("taskId", taskId), Y8.j.a("orderNo", orderNo), Y8.j.a("fromStatus", Integer.valueOf(didiCardModel.getStatus())), Y8.j.a("status", Integer.valueOf(didiCardModel3.getStatus())), Y8.j.a("reason", reason));
                h(cardEnvelopeB, didiCardModel3);
            }
        }
    }

    public final boolean n1() {
        DidiCardModel didiCardModel = this.lastModel;
        if (didiCardModel == null) {
            return false;
        }
        return didiCardModel.getStatus() == 90 || !La.D.L(didiCardModel.getBizChannel(), q0.CAOCAO, true);
    }

    public final boolean o0(DidiAuthStatusDto dto, String thirdUid, String expectedCardId, String reason) {
        DidiCardModel didiCardModel;
        kotlin.jvm.internal.p.i(dto, "dto");
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(expectedCardId, "expectedCardId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (!isAttachedToWindow() || (didiCardModel = this.lastModel) == null || !i1(didiCardModel) || !kotlin.jvm.internal.p.d(didiCardModel.getCardId(), expectedCardId)) {
            return false;
        }
        C3314k.AuthIds aVarR0 = r0(didiCardModel);
        if (!kotlin.jvm.internal.p.d(aVarR0 != null ? aVarR0.getThirdUid() : null, thirdUid)) {
            return false;
        }
        R5.b bVar = R5.b.INSTANCE;
        String cardId = didiCardModel.getCardId();
        if (cardId.length() == 0) {
            cardId = "null";
        }
        bVar.c("didi.auth.realtime.applied", Y8.j.a("taskId", cardId), Y8.j.a("accountScope", C3324v.INSTANCE.c(thirdUid)), Y8.j.a("reason", reason));
        X.INSTANCE.n(thirdUid, didiCardModel.getCardId());
        C(DidiCardProvider.Companion.b(DidiCardProvider.INSTANCE, didiCardModel, null, null, 6, null));
        return true;
    }

    public final Integer o1(String data) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (data == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(data);
        String strOptString = jSONObject.optString("packageName");
        kotlin.jvm.internal.p.f(strOptString);
        if (strOptString.length() > 0 && !kotlin.jvm.internal.p.d(strOptString, this.boundVendorPkg)) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(jSONObject.optInt("progress", -1));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        objB = Result.b(numValueOf);
        return (Integer) (Result.g(objB) ? null : objB);
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C3316m c3316m = C3316m.INSTANCE;
        DidiCardModel didiCardModel = this.lastModel;
        c3316m.c(didiCardModel != null ? didiCardModel.getBizChannel() : null, "card_reattached");
        E1("attached");
        if (!t1()) {
            q1();
        }
        F1("attached");
        z1("attached");
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        H1();
        G1();
        e0.INSTANCE.h(this, this.lastModel);
        TaxiOrderPoller taxiOrderPoller = TaxiOrderPoller.INSTANCE;
        DidiCardModel didiCardModel = this.lastModel;
        taxiOrderPoller.v(this, didiCardModel != null ? didiCardModel.getOrderNo() : null, "detached");
        DidiCardModel didiCardModel2 = this.lastModel;
        if (didiCardModel2 != null) {
            I1(didiCardModel2, "detached");
        }
        super.onDetachedFromWindow();
    }

    @Override // N5.d, android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            F1("window_visible");
            z1("window_visible");
            return;
        }
        TaxiOrderPoller taxiOrderPoller = TaxiOrderPoller.INSTANCE;
        DidiCardModel didiCardModel = this.lastModel;
        taxiOrderPoller.v(this, didiCardModel != null ? didiCardModel.getOrderNo() : null, "window_invisible");
        DidiCardModel didiCardModel2 = this.lastModel;
        if (didiCardModel2 != null) {
            I1(didiCardModel2, "window_invisible");
        }
    }

    public final boolean p0(String thirdUid, String expectedCardId, String reason) {
        DidiCardModel didiCardModel;
        DidiCardModel didiCardModel2;
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(expectedCardId, "expectedCardId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (!isAttachedToWindow() || (didiCardModel = this.lastModel) == null || !h1(didiCardModel) || !f1(didiCardModel) || !kotlin.jvm.internal.p.d(didiCardModel.getCardId(), expectedCardId)) {
            return false;
        }
        C3314k.AuthIds aVarR0 = r0(didiCardModel);
        if (!kotlin.jvm.internal.p.d(aVarR0 != null ? aVarR0.getThirdUid() : null, thirdUid) || (didiCardModel2 = this.authorizationSourceModel) == null) {
            return false;
        }
        R5.b bVar = R5.b.INSTANCE;
        String cardId = didiCardModel.getCardId();
        if (cardId.length() == 0) {
            cardId = "null";
        }
        bVar.c("didi.auth.realtime.revoked", Y8.j.a("taskId", cardId), Y8.j.a("accountScope", C3324v.INSTANCE.c(thirdUid)), Y8.j.a("reason", reason));
        C(didiCardModel2);
        return true;
    }

    public final void p1(List<DidiCardModel.CarTypeItem> types) {
        T5.m mVar = this.carTypeBlock;
        if (mVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : types) {
            if (this.carSelection.contains(((DidiCardModel.CarTypeItem) obj).getId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Double priceValue = ((DidiCardModel.CarTypeItem) it.next()).getPriceValue();
            if (priceValue != null) {
                arrayList2.add(priceValue);
            }
        }
        a0 a0Var = a0.INSTANCE;
        String strC = a0Var.c(arrayList2);
        TextView tvDidiEstimateValue = mVar.tvDidiEstimateValue;
        kotlin.jvm.internal.p.h(tvDidiEstimateValue, "tvDidiEstimateValue");
        n(tvDidiEstimateValue, strC);
        mVar.llDidiEstimate.setVisibility(strC != null ? 0 : 8);
        mVar.tvDidiSelectedCount.setText(a0Var.i(arrayList.size()));
    }

    public final void q0(String thirdUid, String reason) {
        DidiCardModel didiCardModel;
        DidiCardModel didiCardModel2;
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (isAttachedToWindow() && (didiCardModel = this.lastModel) != null && didiCardModel.getStatus() == 91 && f1(didiCardModel)) {
            C3314k.AuthIds aVarR0 = r0(didiCardModel);
            if (kotlin.jvm.internal.p.d(aVarR0 != null ? aVarR0.getThirdUid() : null, thirdUid) && (didiCardModel2 = this.authorizationSourceModel) != null) {
                R5.b bVar = R5.b.INSTANCE;
                String cardId = didiCardModel.getCardId();
                if (cardId.length() == 0) {
                    cardId = "null";
                }
                bVar.c("didi.auth.revoked", Y8.j.a("taskId", cardId), Y8.j.a("accountScope", C3324v.INSTANCE.c(thirdUid)), Y8.j.a("reason", reason));
                C(didiCardModel2);
            }
        }
    }

    public final C3314k.AuthIds r0(DidiCardModel model) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(com.stepos.ailauncher.foundation.account.f.INSTANCE.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        if (str.length() > 0) {
            return new C3314k.AuthIds(str, str);
        }
        CardEnvelope boundEnvelope = getBoundEnvelope();
        CardLinks links = boundEnvelope != null ? boundEnvelope.getLinks() : null;
        return C3314k.INSTANCE.c(links != null ? links.getApp() : null, links != null ? links.getWeb() : null);
    }

    public final void r1() {
        String str;
        Object objB;
        if (this.downloadListenerRegistered || (str = this.boundVendorPkg) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            AppCenterSdk.getInstance().registerListener(str, 0, this.downloadListener);
            this.listenerPkg = str;
            C1();
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("didi.download.register.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()), Y8.j.a("pkg", str));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        this.downloadListenerRegistered = ((Boolean) objB).booleanValue();
    }

    public final void s0(View target, final DidiCardModel.ActionItem action) {
        target.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.G
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DidiCardView.t0(action, this, view);
            }
        });
    }

    public final boolean t1() {
        DidiCardModel didiCardModel = this.gatedAuthModel;
        if (didiCardModel == null || !j1(didiCardModel.getVendorPkg())) {
            return false;
        }
        R5.b bVar = R5.b.INSTANCE;
        String cardId = didiCardModel.getCardId();
        if (cardId.length() == 0) {
            cardId = "null";
        }
        bVar.c("didi.installGate.release", Y8.j.a("taskId", cardId));
        C(didiCardModel);
        return true;
    }

    public final void u0(DidiCardModel model) {
        DidiCardModel.AppItem app = model.getApp();
        if (app == null) {
            return;
        }
        T5.l lVar = this.didi;
        T5.l lVar2 = null;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        lVar.llDidiStoreHeader.setVisibility(0);
        T5.l lVar3 = this.didi;
        if (lVar3 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
        } else {
            lVar2 = lVar3;
        }
        TextView tvDidiStoreName = lVar2.tvDidiStoreName;
        kotlin.jvm.internal.p.h(tvDidiStoreName, "tvDidiStoreName");
        n(tvDidiStoreName, model.getStoreName());
        T5.k kVarE0 = e0();
        if (kVarE0 == null) {
            return;
        }
        kVarE0.b().setVisibility(0);
        g0(kVarE0, app, AppDetailRepository.INSTANCE.p(model.getVendorPkg()), model);
        l0(model.getPrimaryAction());
    }

    public final void u1() {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        lVar.tvDidiNote.setTextColor(androidx.core.content.a.c(getContext(), R$color.card_text_secondary));
        lVar.tvDidiNote.setTextSize(2, 13.0f);
        LinearLayout llDidiPlate = lVar.llDidiPlate;
        kotlin.jvm.internal.p.h(llDidiPlate, "llDidiPlate");
        w1(llDidiPlate, 20);
        TextView tvDidiNote = lVar.tvDidiNote;
        kotlin.jvm.internal.p.h(tvDidiNote, "tvDidiNote");
        w1(tvDidiNote, 10);
        LinearLayout llDidiInfoRows = lVar.llDidiInfoRows;
        kotlin.jvm.internal.p.h(llDidiInfoRows, "llDidiInfoRows");
        w1(llDidiInfoRows, 8);
        LinearLayout llDidiPillCta = lVar.llDidiPillCta;
        kotlin.jvm.internal.p.h(llDidiPillCta, "llDidiPillCta");
        w1(llDidiPillCta, 20);
    }

    public final void v0(DidiCardModel model) {
        T5.m mVarT0;
        M0(model, false);
        T5.l lVar = this.didi;
        T5.l lVar2 = null;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        TextView tvDidiRoute = lVar.tvDidiRoute;
        kotlin.jvm.internal.p.h(tvDidiRoute, "tvDidiRoute");
        n(tvDidiRoute, model.getRouteText());
        T5.l lVar3 = this.didi;
        if (lVar3 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar3 = null;
        }
        TextView tvDidiNote = lVar3.tvDidiNote;
        kotlin.jvm.internal.p.h(tvDidiNote, "tvDidiNote");
        n(tvDidiNote, model.getNoteText());
        T5.l lVar4 = this.didi;
        if (lVar4 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar4 = null;
        }
        TextView tvDidiAuthSuccess = lVar4.tvDidiAuthSuccess;
        kotlin.jvm.internal.p.h(tvDidiAuthSuccess, "tvDidiAuthSuccess");
        String disclaimer = model.getDisclaimer();
        if (model.k().isEmpty()) {
            disclaimer = null;
        }
        n(tvDidiAuthSuccess, disclaimer);
        if (!model.k().isEmpty() && (mVarT0 = T0()) != null) {
            mVarT0.b().setVisibility(0);
            A1(model.getCardId(), model.k());
            LinearLayout llDidiCarTypeRows = mVarT0.llDidiCarTypeRows;
            kotlin.jvm.internal.p.h(llDidiCarTypeRows, "llDidiCarTypeRows");
            w0(llDidiCarTypeRows, model.k());
            TextView tvDidiDisclaimer = mVarT0.tvDidiDisclaimer;
            kotlin.jvm.internal.p.h(tvDidiDisclaimer, "tvDidiDisclaimer");
            n(tvDidiDisclaimer, null);
            TextView btnDidiCarSelectCta = mVarT0.btnDidiCarSelectCta;
            kotlin.jvm.internal.p.h(btnDidiCarSelectCta, "btnDidiCarSelectCta");
            f0(btnDidiCarSelectCta, model.getPrimaryAction());
            p1(model.k());
        }
        T5.l lVar5 = this.didi;
        if (lVar5 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar5 = null;
        }
        lVar5.llDidiShell.requestLayout();
        T5.l lVar6 = this.didi;
        if (lVar6 == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
        } else {
            lVar2 = lVar6;
        }
        lVar2.b().requestLayout();
        k0();
    }

    public final boolean v1(DidiCardModel.ActionItem action) {
        String chatReplyText = action.getChatReplyText();
        if (chatReplyText == null && (chatReplyText = S0()) == null) {
            return false;
        }
        return P(chatReplyText);
    }

    public final void w0(LinearLayout container, final List<DidiCardModel.CarTypeItem> types) {
        container.removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        for (final DidiCardModel.CarTypeItem carTypeItem : types) {
            final T5.n nVarC = T5.n.c(layoutInflaterFrom, container, false);
            kotlin.jvm.internal.p.h(nVarC, "inflate(...)");
            TextView tvDidiCarTypeName = nVarC.tvDidiCarTypeName;
            kotlin.jvm.internal.p.h(tvDidiCarTypeName, "tvDidiCarTypeName");
            n(tvDidiCarTypeName, carTypeItem.getName());
            TextView tvDidiCarTypePrice = nVarC.tvDidiCarTypePrice;
            kotlin.jvm.internal.p.h(tvDidiCarTypePrice, "tvDidiCarTypePrice");
            n(tvDidiCarTypePrice, carTypeItem.getPriceText());
            TextView tvDidiCarTypeOriginPrice = nVarC.tvDidiCarTypeOriginPrice;
            kotlin.jvm.internal.p.h(tvDidiCarTypeOriginPrice, "tvDidiCarTypeOriginPrice");
            n(tvDidiCarTypeOriginPrice, carTypeItem.getOriginPriceText());
            ImageView ivDidiCarTypeImage = nVarC.ivDidiCarTypeImage;
            kotlin.jvm.internal.p.h(ivDidiCarTypeImage, "ivDidiCarTypeImage");
            m1(this, ivDidiCarTypeImage, carTypeItem.getImageUrl(), R$drawable.ic_card_didi_car_model, 0, false, 16, null);
            nVarC.cbDidiCarType.setChecked(this.carSelection.contains(carTypeItem.getId()));
            nVarC.b().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DidiCardView.x0(this.f27360a, carTypeItem, nVarC, types, view);
                }
            });
            container.addView(nVarC.b());
        }
    }

    public final void w1(View view, int marginDp) {
        int iZ0;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || layoutParams2.topMargin == (iZ0 = Z0(marginDp))) {
            return;
        }
        layoutParams2.topMargin = iZ0;
        view.setLayoutParams(layoutParams2);
    }

    public final int x1(float valueSp) {
        return (int) TypedValue.applyDimension(2, valueSp, getResources().getDisplayMetrics());
    }

    public final void y0(String value) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        String string = value != null ? La.H.D1(value).toString() : null;
        if (string == null) {
            string = "";
        }
        int i10 = 8;
        if (string.length() == 0) {
            lVar.llDidiCtaRowValue.setVisibility(8);
            lVar.tvDidiCtaAmountSymbol.setText((CharSequence) null);
            lVar.tvDidiCtaAmountNumber.setText((CharSequence) null);
            return;
        }
        AmountTextParts amountTextPartsY1 = y1(string);
        lVar.llDidiCtaRowValue.setVisibility(0);
        TextView textView = lVar.tvDidiCtaAmountSymbol;
        String symbol = amountTextPartsY1.getSymbol();
        if (symbol != null && symbol.length() != 0) {
            i10 = 0;
        }
        textView.setVisibility(i10);
        lVar.tvDidiCtaAmountSymbol.setText(amountTextPartsY1.getSymbol());
        lVar.tvDidiCtaAmountNumber.setText(amountTextPartsY1.getNumber());
    }

    public final AmountTextParts y1(String value) {
        int length = value.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (Character.isDigit(value.charAt(i10))) {
                break;
            }
            i10++;
        }
        if (i10 <= 0) {
            return new AmountTextParts(null, value);
        }
        String strSubstring = value.substring(0, i10);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        String strSubstring2 = value.substring(i10);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        return new AmountTextParts(strSubstring, strSubstring2);
    }

    public final void z0(boolean showsDriverAvatar) {
        T5.l lVar = this.didi;
        if (lVar == null) {
            kotlin.jvm.internal.p.A(q0.DIDI);
            lVar = null;
        }
        TextView textView = lVar.tvDidiCtaRowLabel;
        textView.setGravity(16);
        textView.setIncludeFontPadding(true);
        textView.setLetterSpacing(0.0f);
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(androidx.core.content.a.c(textView.getContext(), showsDriverAvatar ? R$color.card_didi_driver_name : R$color.card_text_secondary));
        if (showsDriverAvatar) {
            textView.setTypeface(Typeface.create(Typeface.DEFAULT, 500, false));
            textView.setLineHeight(x1(20.0f));
        } else {
            textView.setTypeface(null, 0);
            textView.setLineSpacing(0.0f, 1.0f);
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        int iZ0 = showsDriverAvatar ? Z0(20) : -2;
        if (layoutParams2.height != iZ0) {
            layoutParams2.height = iZ0;
            textView.setLayoutParams(layoutParams2);
        }
    }

    public final void z1(String reason) {
        Object objB;
        DidiCardModel didiCardModel = this.lastModel;
        if (didiCardModel == null) {
            return;
        }
        C3314k.AuthIds aVarR0 = r0(didiCardModel);
        if (didiCardModel.getStatus() != 91) {
            I1(didiCardModel, "not_unauthorized");
            return;
        }
        if (f1(didiCardModel)) {
            I1(didiCardModel, "authorized_variant");
            return;
        }
        if (getWindowVisibility() == 0 && isAttachedToWindow()) {
            TaxiVendorSpec taxiVendorSpecB = q0.INSTANCE.b(didiCardModel.getBizChannel());
            if (!taxiVendorSpecB.getChecksAuthStatus()) {
                if (!taxiVendorSpecB.getChecksCredentialStatus()) {
                    R5.b.INSTANCE.e("taxi.auth.skip.vendor:" + didiCardModel.getBizChannel(), "taxi.auth.skip.vendor", Y8.j.a("bizChannel", didiCardModel.getBizChannel()), Y8.j.a("reason", reason));
                    return;
                }
                if (C3309f.INSTANCE.h(didiCardModel)) {
                    I1(didiCardModel, "caocao_payment_auth_pending");
                    return;
                }
                CaocaoAuthConfig caocaoAuthConfigR0 = R0(didiCardModel);
                if (caocaoAuthConfigR0 == null) {
                    R5.b.INSTANCE.h("caocao.auth.skip.noConfig", Y8.j.a("reason", reason));
                    return;
                } else {
                    CaocaoAuthStatusPoller.INSTANCE.i(this, caocaoAuthConfigR0.getAccountKey(), caocaoAuthConfigR0.getVendorId(), caocaoAuthConfigR0.getIntegrationId());
                    return;
                }
            }
            if (aVarR0 == null) {
                R5.b.INSTANCE.h("didi.auth.skip.noIds", Y8.j.a("reason", reason));
                return;
            }
            CardEnvelope boundEnvelope = getBoundEnvelope();
            CardLinks links = boundEnvelope != null ? boundEnvelope.getLinks() : null;
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(com.stepos.ailauncher.foundation.account.f.INSTANCE.k());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            String str = (String) objB;
            if (str == null) {
                str = "";
            }
            C3314k.AuthIds aVarC = C3314k.INSTANCE.c(links != null ? links.getApp() : null, links != null ? links.getWeb() : null);
            String strB = aVarC != null ? aVarC.getThirdUid() : null;
            String strC = C3324v.INSTANCE.c(aVarR0.getThirdUid());
            R5.b bVar = R5.b.INSTANCE;
            String str2 = "didi.auth.ids:" + strC;
            Pair pairA = Y8.j.a("accountScope", strC);
            boolean z10 = false;
            Pair pairA2 = Y8.j.a("matchesAccount", Boolean.valueOf(str.length() > 0 && kotlin.jvm.internal.p.d(str, aVarR0.getThirdUid())));
            if (strB != null && kotlin.jvm.internal.p.d(strB, aVarR0.getThirdUid())) {
                z10 = true;
            }
            bVar.e(str2, "didi.auth.ids", pairA, pairA2, Y8.j.a("matchesLink", Boolean.valueOf(z10)), Y8.j.a("reason", reason));
            if (!i1(didiCardModel)) {
                DidiAuthStatusPoller.INSTANCE.p(this, aVarR0.getThirdUid(), aVarR0.getDeviceId(), reason);
                return;
            }
            DidiAuthStatusPoller didiAuthStatusPoller = DidiAuthStatusPoller.INSTANCE;
            didiAuthStatusPoller.r(this, aVarR0.getThirdUid(), "realtime_isolated");
            if ((kotlin.jvm.internal.p.d(reason, "attached") || kotlin.jvm.internal.p.d(reason, "window_visible")) && X.INSTANCE.k(aVarR0.getThirdUid(), didiCardModel.getCardId())) {
                didiAuthStatusPoller.s(this, aVarR0.getThirdUid(), aVarR0.getDeviceId(), didiCardModel.getCardId(), reason);
            }
        }
    }

    public /* synthetic */ DidiCardView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
