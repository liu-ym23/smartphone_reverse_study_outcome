package M5;

import La.D;
import La.H;
import Y8.j;
import Y8.t;
import Z8.F;
import Z8.Q;
import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import h8.C4148a;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import u6.C5578a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010$\n\u0002\bF\n\u0002\u0010\"\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJa\u0010\u0013\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014JU\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ=\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001f\u0010 J?\u0010#\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b#\u0010$J'\u0010'\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J'\u0010*\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020\u0010¢\u0006\u0004\b*\u0010+J'\u0010-\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020\u0004¢\u0006\u0004\b-\u0010.J+\u00100\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b2\u00103J1\u00106\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u00020\u00042\b\b\u0002\u00105\u001a\u00020\u0004¢\u0006\u0004\b6\u00107J=\u00109\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00105\u001a\u00020\u0004¢\u0006\u0004\b9\u0010 J/\u0010<\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004¢\u0006\u0004\b<\u00107J/\u0010>\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004¢\u0006\u0004\b>\u00107J'\u0010@\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010?\u001a\u00020\u0004¢\u0006\u0004\b@\u0010.J3\u0010C\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010A\u001a\u0004\u0018\u00010\u00042\b\u0010B\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bC\u00107J)\u0010F\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020\u00042\b\u0010E\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bF\u0010GJ?\u0010J\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bJ\u0010KJ3\u0010N\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010L\u001a\u0004\u0018\u00010\u00042\u0006\u0010M\u001a\u00020\u0004¢\u0006\u0004\bN\u0010OJ\u0015\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0010¢\u0006\u0004\bQ\u0010RJ!\u0010S\u001a\u00020%2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bS\u0010TJ!\u0010U\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bU\u0010\bJ/\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010V2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bW\u0010XJ\u001b\u0010Y\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\bY\u0010ZJ7\u0010]\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u00042\b\u0010E\u001a\u0004\u0018\u00010\u00042\u0014\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010VH\u0002¢\u0006\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010`R\u0014\u0010b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010`R\u0014\u0010c\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bc\u0010`R\u0014\u0010d\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bd\u0010`R\u0014\u0010e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\be\u0010`R\u0014\u0010f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bf\u0010`R\u0014\u0010g\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bg\u0010`R\u0014\u0010h\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bh\u0010`R\u0014\u0010i\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bi\u0010`R\u0014\u0010j\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bj\u0010`R\u0014\u0010k\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bk\u0010`R\u0014\u0010l\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bl\u0010`R\u0014\u0010m\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bm\u0010`R\u0014\u0010n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bn\u0010`R\u0014\u0010o\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bo\u0010`R\u0014\u0010p\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bp\u0010`R\u0014\u0010q\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bq\u0010`R\u0014\u0010r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\br\u0010`R\u0014\u0010s\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bs\u0010`R\u0014\u0010t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bt\u0010`R\u0014\u0010u\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bu\u0010`R\u0014\u0010v\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bv\u0010`R\u0014\u0010w\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bw\u0010`R\u0014\u0010x\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bx\u0010`R\u0014\u0010y\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\by\u0010`R\u0014\u0010z\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bz\u0010`R\u0014\u0010{\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b{\u0010`R\u0014\u0010|\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b|\u0010`R\u0014\u0010}\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b}\u0010`R\u0014\u0010~\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b~\u0010`R\u0014\u0010\u007f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u007f\u0010`R\u0016\u0010\u0080\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010`R\u0016\u0010\u0081\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010`R\u0016\u0010\u0082\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010`R\u0016\u0010\u0083\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010`R\u0016\u0010\u0084\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010`R\u0016\u0010\u0085\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010`R\u0016\u0010\u0086\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010`R\u0016\u0010\u0087\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010`R\u0016\u0010\u0088\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010`R\u0016\u0010\u0089\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010`R\u0016\u0010\u008a\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010`R\u0016\u0010\u008b\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010`R\u0016\u0010\u008c\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010`R\u0016\u0010\u008d\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010`R\u0016\u0010\u008e\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010`R\u0016\u0010\u008f\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010`R\u0016\u0010\u0090\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010`R\u0016\u0010\u0091\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010`R\u0016\u0010\u0092\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010`R\u0016\u0010\u0093\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010`R\u0016\u0010\u0094\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010`R\u0016\u0010\u0095\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010`R\u0016\u0010\u0096\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010`R\u0016\u0010\u0097\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010`R\u0016\u0010\u0098\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010`R\u0016\u0010\u0099\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010`R\u0016\u0010\u009a\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010`R\u0016\u0010\u009b\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010`R\u0016\u0010\u009c\u0001\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010`R\u001e\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001e\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010\u009f\u0001R\u001e\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010\u009f\u0001R\u001e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010\u009f\u0001R\u001e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010\u009f\u0001R\u001e\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010\u009f\u0001R\u001e\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010\u009f\u0001¨\u0006¦\u0001"}, d2 = {"LM5/c;", "", "<init>", "()V", "", "fileName", "mimeType", "e", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "taskId", "sessionId", "fileId", "result", "", "durationMs", "fileSource", "", "fileCount", "LY8/t;", "z", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;I)V", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", "exposeSource", "cardState", D6.a.KEY_TASK_STATUS, WeatherCardProvider.KEY_CARD_TYPE, "filePosition", "c", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "entrySource", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "productCount", "previewType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "", "enter", "r", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Z)V", "position", "q", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;I)V", "tab", "s", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Ljava/lang/String;)V", "codeLength", "f", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Ljava/lang/Integer;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;)V", "downloadSource", "downloadType", "l", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "failReason", "n", "failedReason", HomeGestureEligibilityContract.EXTRA_SCENE, "x", "clickTarget", "w", "reeditType", "B", "fromVersion", "toVersion", "D", "confirmType", "page", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "action", "responseLatencyMs", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "interruptStage", "interruptSource", "u", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "status", "v", "(I)Ljava/lang/String;", "y", "(Ljava/lang/String;Ljava/lang/String;)Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "t", "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;Ljava/lang/String;)Ljava/util/Map;", "p", "(Ljava/lang/String;)Ljava/lang/String;", "event", "attrs", "C", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "PAGE_PRODUCT_DETAIL", "Ljava/lang/String;", "PAGE_CHATVIEW", "EVENT_CARD_CREATE", "EVENT_CARD_EXPOSE", "EVENT_CARD_CLICK", "EVENT_DETAIL_VIEW", "EVENT_FULLSCREEN_CLICK", "EVENT_FOLDER_PRODUCT_CLICK", "EVENT_HTML_TAB_CLICK", "EVENT_CODE_VIEWALL_CLICK", "EVENT_CONTENT_COPY", "EVENT_DOWNLOAD_CLICK", "EVENT_DOWNLOAD_RESULT", "EVENT_INVALID_EXPOSE", "EVENT_INVALID_CLICK", "EVENT_REEDIT_CLICK", "EVENT_VERSION_CLICK", "EVENT_CONFIRM_EXPOSE", "EVENT_CONFIRM_CLICK", "EVENT_INTERRUPT_CLICK", "SOURCE_CHATVIEW", "SOURCE_ARTIFACT_SHEET", "SOURCE_FOLDER", "CARD_TYPE_PREVIEW", "CARD_TYPE_TITLE", "CARD_STATE_VALID", "PREVIEW_DOCUMENT", "PREVIEW_CODE", "PREVIEW_HTML", "PREVIEW_FOLDER", "FILE_SOURCE_GENERATE", "DOWNLOAD_SINGLE", "RESULT_SUCCESS", "RESULT_FAILED", "FAIL_NETWORK", "FAIL_EXPIRED", "FAIL_NOT_FOUND", "TASK_RUNNING", "TASK_COMPLETED", "TASK_FAILED", "TASK_CANCELED", "TAB_PREVIEW", "TAB_CODE", "REASON_FILE_NOT_FOUND", "REASON_LINK_EXPIRED", "REASON_FORMAT_UNSUPPORTED", "REASON_LOAD_FAILED", "REASON_CONTENT_BLOCKED", "SCENE_PREVIEW", "SCENE_OPEN", "CLICK_RETRY", "CLICK_REGENERATE", "REEDIT_INSTRUCTION", "REEDIT_REGENERATE", "REEDIT_EDIT", "CONFIRM_CARD", "ACTION_SELECT", "ACTION_SKIP", "ACTION_INPUT", "INTERRUPT_USER_CANCEL", "INTERRUPT_USER_NEW_INPUT", "", "IMAGE_EXT", "Ljava/util/Set;", "VIDEO_EXT", "CODE_EXT", "PREVIEW_CODE_EXTS", "PREVIEW_CODE_MIMES", "PPT_EXTS", "PPT_MIMES", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final String ACTION_INPUT = "input";
    public static final String ACTION_SELECT = "select";
    public static final String ACTION_SKIP = "skip";
    public static final String CARD_STATE_VALID = "valid";
    public static final String CARD_TYPE_PREVIEW = "preview_card";
    public static final String CARD_TYPE_TITLE = "title_card";
    public static final String CLICK_REGENERATE = "regenerate";
    public static final String CLICK_RETRY = "retry";
    public static final String CONFIRM_CARD = "card_confirm";
    public static final String DOWNLOAD_SINGLE = "single";
    private static final String EVENT_CARD_CLICK = "task_productcard_click";
    private static final String EVENT_CARD_CREATE = "task_productcard_create";
    private static final String EVENT_CARD_EXPOSE = "task_productcard_expose";
    private static final String EVENT_CODE_VIEWALL_CLICK = "task_code_viewall_click";
    private static final String EVENT_CONFIRM_CLICK = "task_confirm_click";
    private static final String EVENT_CONFIRM_EXPOSE = "task_confirm_expose";
    private static final String EVENT_CONTENT_COPY = "task_content_copy";
    private static final String EVENT_DETAIL_VIEW = "task_productdetail_view";
    private static final String EVENT_DOWNLOAD_CLICK = "task_download_click";
    private static final String EVENT_DOWNLOAD_RESULT = "task_download_result";
    private static final String EVENT_FOLDER_PRODUCT_CLICK = "task_folder_product_click";
    private static final String EVENT_FULLSCREEN_CLICK = "task_fullscreen_click";
    private static final String EVENT_HTML_TAB_CLICK = "task_htmltab_click";
    private static final String EVENT_INTERRUPT_CLICK = "task_interrupt_click";
    private static final String EVENT_INVALID_CLICK = "task_invalid_click";
    private static final String EVENT_INVALID_EXPOSE = "task_invalid_expose";
    private static final String EVENT_REEDIT_CLICK = "task_reedit_click";
    private static final String EVENT_VERSION_CLICK = "task_version_click";
    public static final String FAIL_EXPIRED = "file_expired";
    public static final String FAIL_NETWORK = "network_error";
    public static final String FAIL_NOT_FOUND = "file_not_found";
    public static final String FILE_SOURCE_GENERATE = "agent_generate";
    public static final String INTERRUPT_USER_CANCEL = "user_cancel";
    public static final String INTERRUPT_USER_NEW_INPUT = "user_new_input";
    public static final String PAGE_CHATVIEW = "chatview";
    public static final String PAGE_PRODUCT_DETAIL = "productdetail";
    public static final String PREVIEW_CODE = "code";
    public static final String PREVIEW_DOCUMENT = "document";
    public static final String PREVIEW_FOLDER = "folder";
    public static final String PREVIEW_HTML = "html";
    public static final String REASON_CONTENT_BLOCKED = "content_blocked";
    public static final String REASON_FILE_NOT_FOUND = "file_not_found";
    public static final String REASON_FORMAT_UNSUPPORTED = "format_unsupported";
    public static final String REASON_LINK_EXPIRED = "link_expired";
    public static final String REASON_LOAD_FAILED = "load_failed";
    public static final String REEDIT_EDIT = "edit";
    public static final String REEDIT_INSTRUCTION = "instruction";
    public static final String REEDIT_REGENERATE = "regenerate";
    public static final String RESULT_FAILED = "failed";
    public static final String RESULT_SUCCESS = "success";
    public static final String SCENE_OPEN = "open";
    public static final String SCENE_PREVIEW = "preview";
    public static final String SOURCE_ARTIFACT_SHEET = "chatview_artifact";
    public static final String SOURCE_CHATVIEW = "chatview";
    public static final String SOURCE_FOLDER = "folder";
    public static final String TAB_CODE = "code";
    public static final String TAB_PREVIEW = "preview";
    public static final String TASK_CANCELED = "canceled";
    public static final String TASK_COMPLETED = "completed";
    public static final String TASK_FAILED = "failed";
    public static final String TASK_RUNNING = "running";
    public static final c INSTANCE = new c();
    private static final Set<String> IMAGE_EXT = Y.j("png", C5578a.DST_JPG, "jpeg", "gif", "webp", "bmp", "svg", "heic");
    private static final Set<String> VIDEO_EXT = Y.j("mp4", "mov", "avi", "mkv", "webm");
    private static final Set<String> CODE_EXT = Y.j("py", "js", "ts", "tsx", "java", "kt", "c", "cpp", "cs", "go", "rs", "rb", "php", "swift", "sh", "sql", "json", "xml", "yaml", "yml", "css");
    private static final Set<String> PREVIEW_CODE_EXTS = Y.j("js", "ts", "py", "java", "go", "css", "json");
    private static final Set<String> PREVIEW_CODE_MIMES = Y.j("text/css", "text/javascript", "application/javascript", "text/x-python", "text/x-java", "text/x-go", "application/json");
    private static final Set<String> PPT_EXTS = Y.j(ChatTracker.CONTENT_PPT, "pptx");
    private static final Set<String> PPT_MIMES = Y.j("application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation");

    public static /* synthetic */ void b(c cVar, SessionArtifact sessionArtifact, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = CARD_STATE_VALID;
        }
        String str5 = str3;
        if ((i10 & 16) != 0) {
            str4 = null;
        }
        cVar.a(sessionArtifact, str, str2, str5, str4);
    }

    public static /* synthetic */ void d(c cVar, SessionArtifact sessionArtifact, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        String str7;
        c cVar2;
        SessionArtifact sessionArtifact2;
        String str8;
        String str9;
        if ((i10 & 8) != 0) {
            str3 = CARD_STATE_VALID;
        }
        String str10 = str3;
        String str11 = (i10 & 16) != 0 ? null : str4;
        String str12 = (i10 & 32) != 0 ? null : str5;
        if ((i10 & 64) != 0) {
            str7 = null;
            sessionArtifact2 = sessionArtifact;
            str8 = str;
            str9 = str2;
            cVar2 = cVar;
        } else {
            str7 = str6;
            cVar2 = cVar;
            sessionArtifact2 = sessionArtifact;
            str8 = str;
            str9 = str2;
        }
        cVar2.c(sessionArtifact2, str8, str9, str10, str11, str12, str7);
    }

    public static /* synthetic */ void k(c cVar, SessionArtifact sessionArtifact, String str, String str2, Integer num, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            num = null;
        }
        if ((i10 & 16) != 0) {
            str3 = null;
        }
        cVar.j(sessionArtifact, str, str2, num, str3);
    }

    public static /* synthetic */ void m(c cVar, SessionArtifact sessionArtifact, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = DOWNLOAD_SINGLE;
        }
        cVar.l(sessionArtifact, str, str2, str3);
    }

    public static /* synthetic */ void o(c cVar, SessionArtifact sessionArtifact, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        String str5 = str3;
        if ((i10 & 16) != 0) {
            str4 = DOWNLOAD_SINGLE;
        }
        cVar.n(sessionArtifact, str, str2, str5, str4);
    }

    public final String A(String fileName, String mimeType) {
        String lowerCase;
        String strP = p(fileName);
        if (mimeType != null) {
            lowerCase = mimeType.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        return y(fileName, mimeType) ? "folder" : (p.d(strP, ChatTracker.CONTENT_PPT) || p.d(strP, "pptx")) ? ChatTracker.CONTENT_PPT : p.d(strP, "pdf") ? "pdf" : p.d(strP, ChatTracker.CONTENT_DOC) ? ChatTracker.CONTENT_DOC : p.d(strP, "docx") ? "docx" : F.f0(Y.j("xls", "xlsx", "csv"), strP) ? "xlsx" : F.f0(Y.j("html", "htm"), strP) ? "html" : F.f0(Y.j("md", "markdown"), strP) ? "md" : F.f0(Y.j("txt", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f), strP) ? "txt" : F.f0(IMAGE_EXT, strP) ? "image" : F.f0(VIDEO_EXT, strP) ? "video" : F.f0(Y.j("zip", "rar", "7z", "tar", "gz"), strP) ? "zip" : F.f0(CODE_EXT, strP) ? "code" : D.X(lowerCase, "image/", false, 2, null) ? "image" : D.X(lowerCase, "video/", false, 2, null) ? "video" : H.g0(lowerCase, "html", false, 2, null) ? "html" : H.g0(lowerCase, "pdf", false, 2, null) ? "pdf" : (H.g0(lowerCase, "spreadsheet", false, 2, null) || H.g0(lowerCase, "excel", false, 2, null)) ? "xlsx" : (H.g0(lowerCase, "presentation", false, 2, null) || H.g0(lowerCase, "powerpoint", false, 2, null)) ? ChatTracker.CONTENT_PPT : H.g0(lowerCase, "word", false, 2, null) ? "docx" : H.g0(lowerCase, "markdown", false, 2, null) ? "md" : p.d(lowerCase, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30839B) ? "txt" : (H.g0(lowerCase, "zip", false, 2, null) || H.g0(lowerCase, "compressed", false, 2, null) || H.g0(lowerCase, "tar", false, 2, null)) ? "zip" : "unknown";
    }

    public final void B(SessionArtifact artifact, String sessionId, String reeditType) {
        p.i(artifact, "artifact");
        p.i(reeditType, "reeditType");
        C(EVENT_REEDIT_CLICK, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), Q.f(j.a("reedit_type", reeditType))));
    }

    public final void C(String event, String page, Map<String, ? extends Object> attrs) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : attrs.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(Q.e(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), String.valueOf(entry2.getValue()));
        }
        C4148a.d("Track", event + " page=" + page + " " + linkedHashMap2, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            if (page == null) {
                page = "";
            }
            N.a(event, page, linkedHashMap2);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final void D(SessionArtifact artifact, String sessionId, String fromVersion, String toVersion) {
        p.i(artifact, "artifact");
        C(EVENT_VERSION_CLICK, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), kotlin.collections.a.m(j.a("from_version", fromVersion), j.a("to_version", toVersion))));
    }

    public final void a(SessionArtifact artifact, String sessionId, String entrySource, String cardState, String cardType) {
        p.i(artifact, "artifact");
        p.i(entrySource, "entrySource");
        p.i(cardState, "cardState");
        C(EVENT_CARD_CLICK, "chatview", kotlin.collections.a.r(t(artifact, sessionId), kotlin.collections.a.m(j.a("card_state", cardState), j.a("entry_source", entrySource), j.a("card_type", cardType))));
    }

    public final void c(SessionArtifact artifact, String sessionId, String exposeSource, String cardState, String taskStatus, String cardType, String filePosition) {
        p.i(artifact, "artifact");
        p.i(exposeSource, "exposeSource");
        p.i(cardState, "cardState");
        C(EVENT_CARD_EXPOSE, "chatview", kotlin.collections.a.r(t(artifact, sessionId), kotlin.collections.a.m(j.a("card_state", cardState), j.a("task_status", taskStatus), j.a("expose_source", exposeSource), j.a("card_type", cardType), j.a("file_position", filePosition))));
    }

    public final String e(String fileName, String mimeType) {
        String lowerCase;
        String strP = p(fileName);
        if (F.f0(PPT_EXTS, strP) || F.f0(PREVIEW_CODE_EXTS, strP)) {
            return CARD_TYPE_PREVIEW;
        }
        if (mimeType != null) {
            lowerCase = mimeType.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        return (PREVIEW_CODE_MIMES.contains(lowerCase) || PPT_MIMES.contains(lowerCase)) ? CARD_TYPE_PREVIEW : CARD_TYPE_TITLE;
    }

    public final void f(SessionArtifact artifact, String sessionId, Integer codeLength) {
        p.i(artifact, "artifact");
        C(EVENT_CODE_VIEWALL_CLICK, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), Q.f(j.a("code_length", codeLength))));
    }

    public final void g(String sessionId, String confirmType, String action, Long responseLatencyMs, String page) {
        p.i(confirmType, "confirmType");
        p.i(action, "action");
        C(EVENT_CONFIRM_CLICK, page, kotlin.collections.a.m(j.a("session_id", sessionId), j.a("confirm_type", confirmType), j.a("action", action), j.a("response_latency_ms", responseLatencyMs)));
    }

    public final void h(String sessionId, String confirmType, String page) {
        p.i(confirmType, "confirmType");
        C(EVENT_CONFIRM_EXPOSE, page, kotlin.collections.a.m(j.a("session_id", sessionId), j.a("confirm_type", confirmType)));
    }

    public final void i(SessionArtifact artifact, String sessionId) {
        p.i(artifact, "artifact");
        C(EVENT_CONTENT_COPY, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), Q.f(j.a("file_type", A(artifact.getFileName(), artifact.getMimeType())))));
    }

    public final void j(SessionArtifact artifact, String sessionId, String exposeSource, Integer productCount, String previewType) {
        p.i(artifact, "artifact");
        p.i(exposeSource, "exposeSource");
        C(EVENT_DETAIL_VIEW, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), kotlin.collections.a.m(j.a("expose_source", exposeSource), j.a("product_count", productCount), j.a("preview_type", previewType))));
    }

    public final void l(SessionArtifact artifact, String sessionId, String downloadSource, String downloadType) {
        p.i(artifact, "artifact");
        p.i(downloadSource, "downloadSource");
        p.i(downloadType, "downloadType");
        C(EVENT_DOWNLOAD_CLICK, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), kotlin.collections.a.m(j.a("download_source", downloadSource), j.a("download_type", downloadType))));
    }

    public final void n(SessionArtifact artifact, String sessionId, String result, String failReason, String downloadType) {
        p.i(artifact, "artifact");
        p.i(result, "result");
        p.i(downloadType, "downloadType");
        C(EVENT_DOWNLOAD_RESULT, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), kotlin.collections.a.m(j.a("file_type", A(artifact.getFileName(), artifact.getMimeType())), j.a("download_type", downloadType), j.a("result", result), j.a("fail_reason", failReason))));
    }

    public final String p(String fileName) {
        String strQ1;
        if (fileName != null && (strQ1 = H.q1(fileName, '.', "")) != null) {
            String lowerCase = strQ1.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            if (lowerCase != null && lowerCase.length() > 0 && lowerCase.length() <= 8 && !H.f0(lowerCase, JsonPointer.SEPARATOR, false, 2, null) && !H.f0(lowerCase, '\\', false, 2, null)) {
                return lowerCase;
            }
        }
        return null;
    }

    public final void q(SessionArtifact artifact, String sessionId, int position) {
        p.i(artifact, "artifact");
        C(EVENT_FOLDER_PRODUCT_CLICK, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), Q.f(j.a("position", Integer.valueOf(position)))));
    }

    public final void r(SessionArtifact artifact, String sessionId, boolean enter) {
        p.i(artifact, "artifact");
        C(EVENT_FULLSCREEN_CLICK, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), Q.f(j.a("view_stage", enter ? "enter" : "exit"))));
    }

    public final void s(SessionArtifact artifact, String sessionId, String tab) {
        p.i(artifact, "artifact");
        p.i(tab, "tab");
        C(EVENT_HTML_TAB_CLICK, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), Q.f(j.a("tab", tab))));
    }

    public final Map<String, Object> t(SessionArtifact artifact, String sessionId) {
        return kotlin.collections.a.m(j.a("task_id", artifact.getTaskId()), j.a("session_id", sessionId), j.a("product_id", artifact.getFileId()), j.a("product_type", A(artifact.getFileName(), artifact.getMimeType())), j.a("file_ext", p(artifact.getFileName())));
    }

    public final void u(String taskId, String sessionId, String interruptStage, String interruptSource) {
        p.i(interruptSource, "interruptSource");
        C(EVENT_INTERRUPT_CLICK, "chatview", kotlin.collections.a.m(j.a("task_id", taskId), j.a("session_id", sessionId), j.a("interrupt_stage", interruptStage), j.a("interrupt_source", interruptSource)));
    }

    public final String v(int status) {
        return status != 4 ? status != 5 ? status != 6 ? "running" : "canceled" : "failed" : "completed";
    }

    public final void w(SessionArtifact artifact, String sessionId, String clickTarget, String failedReason) {
        p.i(artifact, "artifact");
        p.i(clickTarget, "clickTarget");
        p.i(failedReason, "failedReason");
        C(EVENT_INVALID_CLICK, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), kotlin.collections.a.m(j.a("click_target", clickTarget), j.a("failed_reason", failedReason))));
    }

    public final void x(SessionArtifact artifact, String sessionId, String failedReason, String scene) {
        p.i(artifact, "artifact");
        p.i(failedReason, "failedReason");
        p.i(scene, "scene");
        C(EVENT_INVALID_EXPOSE, PAGE_PRODUCT_DETAIL, kotlin.collections.a.r(t(artifact, sessionId), kotlin.collections.a.m(j.a("failed_reason", failedReason), j.a(HomeGestureEligibilityContract.EXTRA_SCENE, scene))));
    }

    public final boolean y(String fileName, String mimeType) {
        String lowerCase = null;
        if (fileName != null && !H.x0(fileName) && (H.j0(fileName, JsonPointer.SEPARATOR, false, 2, null) || H.j0(fileName, '\\', false, 2, null))) {
            return true;
        }
        if (mimeType != null) {
            lowerCase = mimeType.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        return p.d(lowerCase, "inode/directory") || p.d(lowerCase, "application/x-directory") || p.d(lowerCase, "vnd.android.document/directory");
    }

    public final void z(String taskId, String sessionId, String fileId, String fileName, String mimeType, String result, Long durationMs, String fileSource, int fileCount) {
        p.i(result, "result");
        p.i(fileSource, "fileSource");
        Pair pairA = j.a("task_id", taskId);
        Pair pairA2 = j.a("session_id", sessionId);
        Pair pairA3 = j.a("product_id", fileId);
        Pair pairA4 = j.a("result", result);
        Pair pairA5 = j.a("duration_ms", durationMs);
        String strA = A(fileName, mimeType);
        if (p.d(strA, "xlsx")) {
            strA = "excel";
        }
        C(EVENT_CARD_CREATE, "chatview", kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, pairA5, j.a("file_type", strA), j.a("file_ext", p(fileName)), j.a("file_source", fileSource), j.a("file_count", Integer.valueOf(fileCount))));
    }
}
