package androidx.compose.ui.util;

import androidx.collection.MutableScatterSet;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a8\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a>\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a8\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a8\u0010\r\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a?\u0010\u000e\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000f\u001a8\u0010\u0010\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aD\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aO\u0010\u0015\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000f\u001a]\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013\"\u0010\b\u0002\u0010\u0018*\n\u0012\u0006\b\u0000\u0012\u0002H\u00130\u0019*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u0002H\u00182\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000f\u001a>\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a`\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\u0010\n\u0006\b\u0001\u0012\u0002\u0010\u0001\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001a`\u0010\u001f\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010 \u001a\u0002H\u00132'\u0010!\u001a#\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010%\u001aY\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032'\u0010\u0014\u001a#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b('\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a[\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032)\u0010\u0014\u001a%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b('\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00130\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aO\u0010)\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*\u001aU\u0010+\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010,\u001a\u0002H\u00132\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-\u001aJ\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a\\\u0010/\u001a\u0002H0\"\u0004\b\u0000\u00100\"\b\b\u0001\u0010\u0002*\u0002H0*\b\u0012\u0004\u0012\u0002H\u00020\u00032'\u0010!\u001a#\u0012\u0013\u0012\u0011H0¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H00\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00101\u001a|\u00102\u001a\b\u0012\u0004\u0012\u0002H30\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u00103*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H\u00130\u000326\u0010\u0014\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002H30\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001aF\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a`\u00108\u001a\u000209\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020\t2\b\b\u0002\u0010?\u001a\u00020;2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020;\u0018\u00010\u0005\u001aD\u0010@\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010A*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002HA0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aO\u0010B\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000f\u001aJ\u0010C\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130D0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a\"\u0010E\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020F*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0003\u001a=\u0010G\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000f\u001a}\u0010H\u001a\u0002HI\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010I*\u00060Jj\u0002`K*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010L\u001a\u0002HI2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020\t2\b\b\u0002\u0010?\u001a\u00020;2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020;\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010M\u001a9\u0010N\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060Jj\u0002`K2\u0006\u0010O\u001a\u0002H\u00022\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020;\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010P\u001a\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u000209H\u0001\u001a\u0010\u0010T\u001a\u00020\u00012\u0006\u0010S\u001a\u000209H\u0001¨\u0006U"}, d2 = {"fastForEach", "", ExifInterface.GPS_DIRECTION_TRUE, "", "action", "Lkotlin/Function1;", "fastForEachReversed", "fastForEachIndexed", "Lkotlin/Function2;", "", "fastAll", "", "predicate", "fastAny", "fastFirstOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastSumBy", "selector", "fastMap", "R", "transform", "fastMaxBy", "", "fastMapTo", "C", "", a.KEY_DESTINATION, "(Ljava/util/List;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fastLastOrNull", "fastFilter", "fastFilteredMap", "fastFold", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastMapIndexed", "index", "fastMapIndexedNotNull", "fastMaxOfOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "fastMaxOfOrDefault", "defaultValue", "(Ljava/util/List;Ljava/lang/Comparable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "fastZipWithNext", "fastReduce", ExifInterface.LATITUDE_SOUTH, "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastZip", "V", "other", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "fastMapNotNull", "fastJoinToString", "", "separator", "", "prefix", "postfix", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "truncated", "fastDistinctBy", "K", "fastMinByOrNull", "fastFlatMap", "", "fastFilterNotNull", "", "fastFirst", "fastJoinTo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "appendElement", "element", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "throwNoSuchElementException", "", "message", "throwUnsupportedOperationException", "ui-util"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ListUtilsKt {
    public static final <T> List<T> fastFilterNotNull(List<? extends T> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Object r104 = ListProtector.get(r100, r103);
        if (r104 == null) goto L7;
        r101.add(r104);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r101;
    }

    public static final Void throwNoSuchElementException(String r100) {
        throw new NoSuchElementException(r100);
    }

    public static final void throwUnsupportedOperationException(String r100) {
        throw new UnsupportedOperationException(r100);
    }

    public static final <T> boolean fastAll(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r101.invoke((Object) ListProtector.get(r100, r103)).booleanValue() == false) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final <T> boolean fastAny(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101.invoke((Object) ListProtector.get(r100, r103)).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final <T, K> List<T> fastDistinctBy(List<? extends T> r100, Function1<? super T, ? extends K> r101) {
        MutableScatterSet r102 = new MutableScatterSet(r100.size());
        ArrayList r103 = new ArrayList(r100.size());
        int r104 = r100.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r106 = (Object) ListProtector.get(r100, r105);
        if (r102.add(r101.invoke(r106)) == false) goto L7;
        r103.add(r106);
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        return r103;
    }

    public static final <T> List<T> fastFilter(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r105 = (Object) ListProtector.get(r100, r104);
        if (r101.invoke(r105).booleanValue() == false) goto L7;
        r102.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r102;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    public static final <T> T fastFirst(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ?? r104 = (Object) ListProtector.get(r100, r103);
        if (r101.invoke(r104).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    public static final <T> T fastFirstOrNull(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ?? r104 = (Object) ListProtector.get(r100, r103);
        if (r101.invoke(r104).booleanValue() == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static final <T, R> List<R> fastFlatMap(List<? extends T> r100, Function1<? super T, ? extends Iterable<? extends R>> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        CollectionsKt.addAll(r102, r101.invoke((Object) ListProtector.get(r100, r104)));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public static final <T> void fastForEach(List<? extends T> r100, Function1<? super T, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke((Object) ListProtector.get(r100, r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final <T> void fastForEachIndexed(List<? extends T> r100, Function2<? super Integer, ? super T, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r104 = (Object) ListProtector.get(r100, r103);
        r101.invoke(Integer.valueOf(r103), r104);
        r103 = r103 + 1;
        goto L3
    }

    public static final <T> void fastForEachReversed(List<? extends T> r100, Function1<? super T, Unit> r101) {
        int r102 = r100.size() - 1;
        if (r102 < 0) goto L8;
    L4:
        int r103 = r102 - 1;
        r101.invoke((Object) ListProtector.get(r100, r102));
        if (r103 < 0) goto L10;
        r102 = r103;
        goto L4
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    public static final <T> T fastLastOrNull(List<? extends T> r100, Function1<? super T, Boolean> r101) {
        int r102 = r100.size() - 1;
        if (r102 < 0) goto L10;
    L4:
        int r103 = r102 - 1;
        ?? r104 = (Object) ListProtector.get(r100, r102);
        if (r101.invoke(r104).booleanValue() == true) goto L6;
        if (r103 < 0) goto L14;
        r102 = r103;
        goto L4
    L14:
        return null;
    L6:
        return r104;
    L10:
        return null;
    }

    public static final <T, R> List<R> fastMap(List<? extends T> r100, Function1<? super T, ? extends R> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(r101.invoke((Object) ListProtector.get(r100, r104)));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public static final <T, R> List<R> fastMapIndexed(List<? extends T> r100, Function2<? super Integer, ? super T, ? extends R> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r105 = (Object) ListProtector.get(r100, r104);
        r102.add(r101.invoke(Integer.valueOf(r104), r105));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public static final <T, R> List<R> fastMapIndexedNotNull(List<? extends T> r100, Function2<? super Integer, ? super T, ? extends R> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r105 = (Object) ListProtector.get(r100, r104);
        R r106 = r101.invoke(Integer.valueOf(r104), r105);
        if (r106 == null) goto L7;
        r102.add(r106);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r102;
    }

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> r100, Function1<? super T, ? extends R> r101) {
        ArrayList r102 = new ArrayList(r100.size());
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        R r105 = r101.invoke((Object) ListProtector.get(r100, r104));
        if (r105 == null) goto L7;
        r102.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r102;
    }

    public static final <T, R extends Comparable<? super R>> T fastMaxBy(List<? extends T> r100, Function1<? super T, ? extends R> r101) {
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        Object r102 = (Object) ListProtector.get(r100, 0);
        R r103 = r101.invoke(r102);
        int r104 = CollectionsKt.getLastIndex(r100);
        int r105 = 1;
        if (1 > r104) goto L13;
    L8:
        Object r106 = (Object) ListProtector.get(r100, r105);
        R r107 = r101.invoke(r106);
        if (r103.compareTo(r107) >= 0) goto L11;
        r102 = (T) r106;
        r103 = r107;
    L11:
        if (r105 == r104) goto L13;
        r105 = r105 + 1;
    L13:
        return (T) r102;
    }

    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrNull(List<? extends T> r100, Function1<? super T, ? extends R> r101) {
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        R r102 = r101.invoke((Object) ListProtector.get(r100, 0));
        int r103 = CollectionsKt.getLastIndex(r100);
        int r104 = 1;
        if (1 > r103) goto L13;
    L8:
        R r105 = r101.invoke((Object) ListProtector.get(r100, r104));
        if (r105.compareTo(r102) <= 0) goto L11;
        r102 = r105;
    L11:
        if (r104 == r103) goto L13;
        r104 = r104 + 1;
    L13:
        return r102;
    }

    public static final <T, R extends Comparable<? super R>> T fastMinByOrNull(List<? extends T> r100, Function1<? super T, ? extends R> r101) {
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        Object r102 = (Object) ListProtector.get(r100, 0);
        R r103 = r101.invoke(r102);
        int r104 = CollectionsKt.getLastIndex(r100);
        int r105 = 1;
        if (1 > r104) goto L13;
    L8:
        Object r106 = (Object) ListProtector.get(r100, r105);
        R r107 = r101.invoke(r106);
        if (r103.compareTo(r107) <= 0) goto L11;
        r102 = (T) r106;
        r103 = r107;
    L11:
        if (r105 == r104) goto L13;
        r105 = r105 + 1;
    L13:
        return (T) r102;
    }

    public static final <S, T extends S> S fastReduce(List<? extends T> r100, Function2<? super S, ? super T, ? extends S> r101) {
        if (r100.isEmpty() == false) goto L5;
        throwUnsupportedOperationException("Empty collection can't be reduced.");
    L5:
        S r102 = (Object) CollectionsKt.first(r100);
        int r103 = CollectionsKt.getLastIndex(r100);
        int r104 = 1;
        if (1 > r103) goto L10;
    L7:
        S r105 = r102;
        r102 = r101.invoke(r105, (Object) ListProtector.get(r100, r104));
        if (r104 == r103) goto L10;
        r104 = r104 + 1;
    L10:
        return r102;
    }

    public static final <T> int fastSumBy(List<? extends T> r100, Function1<? super T, Integer> r101) {
        int r102 = r100.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r104 = r104 + r101.invoke((Object) ListProtector.get(r100, r103)).intValue();
        r103 = r103 + 1;
        goto L3
    L5:
        return r104;
    }

    public static final <T, R> List<R> fastZipWithNext(List<? extends T> r100, Function2<? super T, ? super T, ? extends R> r101) {
        if (r100.size() <= 1) goto L5;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r104 = (Object) ListProtector.get(r100, 0);
        int r105 = CollectionsKt.getLastIndex(r100);
    L7:
        if (r103 >= r105) goto L9;
        r103 = r103 + 1;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r106 = (Object) ListProtector.get(r100, r103);
        r102.add(r101.invoke(r104, r106));
        r104 = r106;
        goto L7
    L9:
        return r102;
    L5:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void appendElement(Appendable r100, T r101, Function1<? super T, ? extends CharSequence> r102) {
        if (r102 == null) goto L4;
        r100.append(r102.invoke(r101));
        return;
    L4:
        if (r101 != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        r100.append((CharSequence) r101);
        return;
    L10:
        if ((r101 instanceof Character) == false) goto L12;
        r100.append(((Character) r101).charValue());
        return;
    L12:
        r100.append(r101.toString());
        return;
    L6:
        r103 = r101 instanceof CharSequence;
        goto L7
    }

    public static final <T, R> List<R> fastFilteredMap(List<? extends T> r100, Function1<? super T, Boolean> r101, Function1<? super T, ? extends R> r102) {
        ArrayList r103 = new ArrayList(r100.size());
        int r104 = r100.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r106 = (Object) ListProtector.get(r100, r105);
        if (r101.invoke(r106).booleanValue() == false) goto L7;
        r103.add(r102.invoke(r106));
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        return r103;
    }

    public static final <T, R> R fastFold(List<? extends T> r100, R r101, Function2<? super R, ? super T, ? extends R> r102) {
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        R r105 = r101;
        r101 = r102.invoke(r105, (Object) ListProtector.get(r100, r104));
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> r100, C r101, Function1<? super T, ? extends R> r102) {
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.add(r102.invoke((Object) ListProtector.get(r100, r104)));
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrDefault(List<? extends T> r100, R r101, Function1<? super T, ? extends R> r102) {
        if (r100.isEmpty() == false) goto L5;
        return r101;
    L5:
        R r103 = r102.invoke((Object) ListProtector.get(r100, 0));
        int r104 = CollectionsKt.getLastIndex(r100);
        int r105 = 1;
        if (1 > r104) goto L12;
    L7:
        R r106 = r102.invoke((Object) ListProtector.get(r100, r105));
        if (r106.compareTo(r103) <= 0) goto L10;
        r103 = r106;
    L10:
        if (r105 == r104) goto L12;
        r105 = r105 + 1;
    L12:
        return r103;
    }

    public static final <T, R, V> List<V> fastZip(List<? extends T> r100, List<? extends R> r101, Function2<? super T, ? super R, ? extends V> r102) {
        int r103 = Math.min(r100.size(), r101.size());
        ArrayList r104 = new ArrayList(r103);
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r104.add(r102.invoke((Object) ListProtector.get(r100, r105), (Object) ListProtector.get(r101, r105)));
        r105 = r105 + 1;
        goto L3
    L5:
        return r104;
    }

    public static final <T> String fastJoinToString(List<? extends T> r100, CharSequence r101, CharSequence r110, CharSequence r111, int r112, CharSequence r113, Function1<? super T, ? extends CharSequence> r114) {
        return ((StringBuilder) fastJoinTo(r100, new StringBuilder(), r101, r110, r111, r112, r113, r114)).toString();
    }

    private static final <T, A extends Appendable> A fastJoinTo(List<? extends T> r100, A r101, CharSequence r102, CharSequence r103, CharSequence r104, int r105, CharSequence r110, Function1<? super T, ? extends CharSequence> r111) {
        r101.append(r103);
        int r106 = r100.size();
        int r107 = 0;
        int r108 = 0;
    L3:
        if (r107 >= r106) goto L10;
        Object r109 = ListProtector.get(r100, r107);
        r108 = r108 + 1;
        if (r108 <= 1) goto L7;
        r101.append(r102);
    L7:
        if (r105 < 0) goto L9;
        if (r108 > r105) goto L10;
    L9:
        appendElement(r101, r109, r111);
        r107 = r107 + 1;
    L10:
        if (r105 < 0) goto L13;
        if (r108 <= r105) goto L13;
        r101.append(r110);
    L13:
        r101.append(r104);
        return r101;
    }

    public static /* synthetic */ String fastJoinToString$default(List r100, CharSequence r101, CharSequence r102, CharSequence r103, int r104, CharSequence r105, Function1 r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = ", ";
    L5:
        CharSequence r106 = "";
        if ((r111 & 2) == 0) goto L8;
        CharSequence r113 = "";
    L10:
        if ((r111 & 4) != 0) goto L14;
        r106 = r103;
    L14:
        if ((r111 & 8) == 0) goto L16;
        int r107 = -1;
    L18:
        if ((r111 & 16) == 0) goto L20;
        r105 = "...";
    L20:
        CharSequence r108 = r105;
        if ((r111 & 32) == 0) goto L23;
        r110 = null;
    L23:
        Function1 r109 = r110;
        return fastJoinToString(r100, r101, r113, r106, r107, r108, r109);
    L16:
        r107 = r104;
        goto L18
    L8:
        r113 = r102;
        goto L10
    }

    public static /* synthetic */ Appendable fastJoinTo$default(List r100, Appendable r101, CharSequence r102, CharSequence r103, CharSequence r110, int r111, CharSequence r112, Function1 r113, int r114, Object r115) {
        if ((r114 & 2) == 0) goto L5;
        CharSequence r104 = ", ";
    L6:
        CharSequence r105 = "";
        if ((r114 & 4) == 0) goto L9;
        CharSequence r106 = "";
    L11:
        if ((r114 & 8) != 0) goto L15;
        r105 = r110;
    L15:
        if ((r114 & 16) == 0) goto L17;
        int r107 = -1;
    L19:
        if ((r114 & 32) == 0) goto L21;
        CharSequence r108 = "...";
    L23:
        if ((r114 & 64) == 0) goto L25;
        Function1 r109 = null;
    L27:
        return fastJoinTo(r100, r101, r104, r106, r105, r107, r108, r109);
    L25:
        r109 = r113;
        goto L27
    L21:
        r108 = r112;
        goto L23
    L17:
        r107 = r111;
        goto L19
    L9:
        r106 = r103;
        goto L11
    L5:
        r104 = r102;
        goto L6
    }
}
