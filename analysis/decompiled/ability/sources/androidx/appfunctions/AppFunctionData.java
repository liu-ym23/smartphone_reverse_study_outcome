package androidx.appfunctions;

import D7.q;
import D7.r;
import D7.v;
import D7.w;
import H4.o;
import android.app.appsearch.GenericDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ext.SdkExtensions;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.appfunctions.internal.AppFunctionSerializableFactory;
import androidx.appfunctions.internal.Constants;
import androidx.appfunctions.metadata.AppFunctionAllOfTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.appfunctions.metadata.AppFunctionObjectTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionResponseMetadata;
import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@RequiresApi(33)
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u0000 \u0083\u00012\u00020\u0001:\u0004\u0084\u0001\u0083\u0001B#\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020!2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010#J\u001d\u0010\"\u001a\u00020!2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020!¢\u0006\u0004\b\"\u0010$J\u0019\u0010%\u001a\u0004\u0018\u00010!2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020'2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\u001d\u0010(\u001a\u00020'2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020'¢\u0006\u0004\b(\u0010*J\u0019\u0010+\u001a\u0004\u0018\u00010'2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b/\u0010.J\u0017\u00100\u001a\u0004\u0018\u00010\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b0\u00101J/\u00106\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u00103*\u0002022\u0006\u0010\f\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000004¢\u0006\u0004\b6\u00107J&\u00106\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u00103\u0018\u0001*\u0002022\u0006\u0010\f\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\b6\u00108J1\u00109\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u00103*\u0002022\u0006\u0010\f\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0007¢\u0006\u0004\b9\u00107J\u0017\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bG\u0010HJ\u0017\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bJ\u0010KJ\u0019\u0010L\u001a\u0004\u0018\u00010I2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\bL\u0010KJ\u001d\u0010N\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010M2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bN\u0010OJ\u001d\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010M2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bP\u0010OJ5\u0010Q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010M\"\b\b\u0000\u00103*\u0002022\u0006\u0010\f\u001a\u00020\u000b2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000004¢\u0006\u0004\bQ\u0010RJ,\u0010Q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010M\"\n\b\u0000\u00103\u0018\u0001*\u0002022\u0006\u0010\f\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\bQ\u0010OJ\u000f\u0010S\u001a\u00020\u000bH\u0016¢\u0006\u0004\bS\u0010TJ%\u0010V\u001a\u00028\u0000\"\b\b\u0000\u00103*\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00028\u000004¢\u0006\u0004\bV\u0010WJ!\u0010V\u001a\u00028\u0000\"\b\b\u0000\u00103*\u00020\u00012\u0006\u0010X\u001a\u00020\u000bH\u0007¢\u0006\u0004\bV\u0010YJ\u001f\u0010`\u001a\u00020\u00002\u0006\u0010[\u001a\u00020Z2\u0006\u0010]\u001a\u00020\\H\u0000¢\u0006\u0004\b^\u0010_J\u001f\u0010`\u001a\u00020\u00002\u0006\u0010b\u001a\u00020a2\u0006\u0010]\u001a\u00020\\H\u0000¢\u0006\u0004\b^\u0010cJ%\u0010`\u001a\u00020\u00002\f\u0010e\u001a\b\u0012\u0004\u0012\u00020d0M2\u0006\u0010]\u001a\u00020\\H\u0000¢\u0006\u0004\b^\u0010fJ#\u0010k\u001a\u00020i2\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020i0gH\u0007¢\u0006\u0004\bk\u0010lJ\u0017\u0010n\u001a\u00020\r2\u0006\u0010m\u001a\u00020\u001bH\u0002¢\u0006\u0004\bn\u0010oJ\u0017\u0010q\u001a\u00020\r2\u0006\u0010p\u001a\u00020'H\u0002¢\u0006\u0004\bq\u0010rJ1\u0010t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u00103*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0002¢\u0006\u0004\bt\u0010uR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010v\u001a\u0004\bw\u0010xR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010y\u001a\u0004\bz\u0010{R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010|\u001a\u0004\b}\u0010~R\u0019\u0010\u007f\u001a\u00020\u000b8\u0007¢\u0006\u000e\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010TR\u0012\u0010X\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010T¨\u0006\u0085\u0001"}, d2 = {"Landroidx/appfunctions/AppFunctionData;", "", "Landroidx/appfunctions/AppFunctionDataSpec;", "spec", "Landroid/app/appsearch/GenericDocument;", "genericDocument", "Landroid/os/Bundle;", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, AppAgent.CONSTRUCT, "(Landroidx/appfunctions/AppFunctionDataSpec;Landroid/app/appsearch/GenericDocument;Landroid/os/Bundle;)V", "(Landroid/app/appsearch/GenericDocument;Landroid/os/Bundle;)V", "", "key", "", "containsKey", "(Ljava/lang/String;)Z", "getBoolean", "defaultValue", "(Ljava/lang/String;Z)Z", "getBooleanOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "", "getFloat", "(Ljava/lang/String;)F", "(Ljava/lang/String;F)F", "getFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "", "getDouble", "(Ljava/lang/String;)D", "(Ljava/lang/String;D)D", "getDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "", "getInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "getIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "getLong", "(Ljava/lang/String;)J", "(Ljava/lang/String;J)J", "getLongOrNull", "(Ljava/lang/String;)Ljava/lang/Long;", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "getStringOrNull", "getAppFunctionData", "(Ljava/lang/String;)Landroidx/appfunctions/AppFunctionData;", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "getParcelable", "(Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "(Ljava/lang/String;)Landroid/os/Parcelable;", "getParcelableOrNull", "", "getBooleanArray", "(Ljava/lang/String;)[Z", "", "getFloatArray", "(Ljava/lang/String;)[F", "", "getDoubleArray", "(Ljava/lang/String;)[D", "", "getIntArray", "(Ljava/lang/String;)[I", "", "getLongArray", "(Ljava/lang/String;)[J", "", "getByteArray", "(Ljava/lang/String;)[B", "getByteArrayOrNull", "", "getStringList", "(Ljava/lang/String;)Ljava/util/List;", "getAppFunctionDataList", "getParcelableList", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/util/List;", "toString", "()Ljava/lang/String;", "serializableClass", "deserialize", "(Ljava/lang/Class;)Ljava/lang/Object;", "qualifiedName", "(Ljava/lang/String;)Ljava/lang/Object;", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "responseMetadata", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "componentMetadata", "replaceSpecWith$appfunctions", "(Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Landroidx/appfunctions/AppFunctionData;", "replaceSpecWith", "Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", "objectTypeMetadata", "(Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Landroidx/appfunctions/AppFunctionData;", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "parameterMetadata", "(Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)Landroidx/appfunctions/AppFunctionData;", "Lkotlin/Function1;", "Landroidx/appfunctions/AppFunctionUriGrant;", "LC7/r;", "visitor", "visitAppFunctionUriGrants", "(LS7/k;)V", "doubleValue", "isDoubleWithinFloatRange", "(D)Z", "longValue", "isLongWithinLongRange", "(J)Z", "arrayClass", "unsafeGetProperty", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Landroidx/appfunctions/AppFunctionDataSpec;", "getSpec$appfunctions", "()Landroidx/appfunctions/AppFunctionDataSpec;", "Landroid/app/appsearch/GenericDocument;", "getGenericDocument$appfunctions", "()Landroid/app/appsearch/GenericDocument;", "Landroid/os/Bundle;", "getExtras$appfunctions", "()Landroid/os/Bundle;", AppFunctionData.LEGACY_ID_FIELD_KEY, "Ljava/lang/String;", "getId", "getQualifiedName", "Companion", "Builder", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean DEFAULT_BOOLEAN = false;
    private static final double DEFAULT_DOUBLE = 0.0d;
    private static final float DEFAULT_FLOAT = 0.0f;
    private static final int DEFAULT_INT = 0;
    private static final long DEFAULT_LONG = 0;
    public static final AppFunctionData EMPTY;
    private static final String LEGACY_ID_FIELD_KEY = "id";
    private final Bundle extras;
    private final GenericDocument genericDocument;
    private final String id;
    private final AppFunctionDataSpec spec;

    @Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u001f\b\u0016\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u0015B\u0011\b\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0005\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#J\u001f\u0010%\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020*H\u0007¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0007¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020/H\u0007¢\u0006\u0004\b0\u00101J)\u00104\u001a\u00020\u0000\"\b\b\u0000\u00103*\u0002022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00028\u0000H\u0007¢\u0006\u0004\b4\u00105J\u001f\u00107\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u000206H\u0007¢\u0006\u0004\b7\u00108J\u001f\u0010:\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u000209H\u0007¢\u0006\u0004\b:\u0010;J\u001f\u0010=\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020<H\u0007¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020?H\u0007¢\u0006\u0004\b@\u0010AJ\u001f\u0010C\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020BH\u0007¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020EH\u0007¢\u0006\u0004\bF\u0010GJ%\u0010H\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0007¢\u0006\u0004\bH\u0010IJ%\u0010J\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020/0\u0007H\u0007¢\u0006\u0004\bJ\u0010IJ2\u0010K\u001a\u00020\u0000\"\n\b\u0000\u00103\u0018\u0001*\u0002022\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\b¢\u0006\u0004\bK\u0010IJ=\u0010K\u001a\u00020\u0000\"\b\b\u0000\u00103*\u0002022\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000LH\u0007¢\u0006\u0004\bK\u0010NJ\r\u0010O\u001a\u00020/¢\u0006\u0004\bO\u0010PR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010QR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010RR\u001a\u0010T\u001a\u0006\u0012\u0002\b\u00030S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006Y"}, d2 = {"Landroidx/appfunctions/AppFunctionData$Builder;", "", "", "qualifiedName", AppFunctionData.LEGACY_ID_FIELD_KEY, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "parameterMetadataList", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "componentMetadata", "(Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", "objectTypeMetadata", "(Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "Landroidx/appfunctions/metadata/AppFunctionAllOfTypeMetadata;", "allOfTypeMetadata", "(Landroidx/appfunctions/metadata/AppFunctionAllOfTypeMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "responseMetadata", "(Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "Landroidx/appfunctions/AppFunctionDataSpec;", "spec", "(Landroidx/appfunctions/AppFunctionDataSpec;)V", "LC7/r;", "setLegacyId", "(Ljava/lang/String;)V", "key", "", "value", "setBoolean", "(Ljava/lang/String;Z)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setFloat", "(Ljava/lang/String;F)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setDouble", "(Ljava/lang/String;D)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setInt", "(Ljava/lang/String;I)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setLong", "(Ljava/lang/String;J)Landroidx/appfunctions/AppFunctionData$Builder;", "setString", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/appfunctions/AppFunctionData$Builder;", "Landroidx/appfunctions/AppFunctionData;", "setAppFunctionData", "(Ljava/lang/String;Landroidx/appfunctions/AppFunctionData;)Landroidx/appfunctions/AppFunctionData$Builder;", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "setParcelable", "(Ljava/lang/String;Landroid/os/Parcelable;)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setBooleanArray", "(Ljava/lang/String;[Z)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setFloatArray", "(Ljava/lang/String;[F)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setDoubleArray", "(Ljava/lang/String;[D)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setIntArray", "(Ljava/lang/String;[I)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setLongArray", "(Ljava/lang/String;[J)Landroidx/appfunctions/AppFunctionData$Builder;", "", "setByteArray", "(Ljava/lang/String;[B)Landroidx/appfunctions/AppFunctionData$Builder;", "setStringList", "(Ljava/lang/String;Ljava/util/List;)Landroidx/appfunctions/AppFunctionData$Builder;", "setAppFunctionDataList", "setParcelableList", "Ljava/lang/Class;", "clazz", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Class;)Landroidx/appfunctions/AppFunctionData$Builder;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Landroidx/appfunctions/AppFunctionData;", "Ljava/lang/String;", "Landroidx/appfunctions/AppFunctionDataSpec;", "Landroid/app/appsearch/GenericDocument$Builder;", "genericDocumentBuilder", "Landroid/app/appsearch/GenericDocument$Builder;", "Landroid/os/Bundle;", "extrasBuilder", "Landroid/os/Bundle;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private final Bundle extrasBuilder;
        private GenericDocument.Builder<?> genericDocumentBuilder;
        private final String qualifiedName;
        private final AppFunctionDataSpec spec;

        public Builder(String qualifiedName, String id) {
            k.f(qualifiedName, "qualifiedName");
            k.f(id, "id");
            this.extrasBuilder = new Bundle();
            this.qualifiedName = qualifiedName;
            this.spec = null;
            this.genericDocumentBuilder = new GenericDocument.Builder<>("", id, qualifiedName);
        }

        private final void setLegacyId(String id) {
            if (SdkExtensions.getExtensionVersion(33) >= 13) {
                this.genericDocumentBuilder.setId(id);
            } else {
                Log.wtf(Constants.APP_FUNCTIONS_TAG, "setId method in GenericDocument isn't supported on the current device.");
            }
        }

        public final AppFunctionData build() {
            Set<String> allPropertyKeys$appfunctions;
            GenericDocument genericDocumentBuild = this.genericDocumentBuilder.build();
            k.e(genericDocumentBuild, "build(...)");
            AppFunctionData appFunctionData = new AppFunctionData(this.spec, genericDocumentBuild, this.extrasBuilder);
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null && (allPropertyKeys$appfunctions = appFunctionDataSpec.getAllPropertyKeys$appfunctions()) != null) {
                for (String str : allPropertyKeys$appfunctions) {
                    if (this.spec.isRequired$appfunctions(str) && !appFunctionData.containsKey(str)) {
                        throw new IllegalArgumentException(B7.a.g('\'', this.qualifiedName, B7.a.v("Missing required property: '", str, "' for object '")));
                    }
                }
            }
            return appFunctionData;
        }

        public final Builder setAppFunctionData(String key, AppFunctionData value) {
            AppFunctionDataSpec propertyObjectSpec;
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, AppFunctionData.class, false, value);
            }
            AppFunctionDataSpec appFunctionDataSpec2 = this.spec;
            if (appFunctionDataSpec2 != null && (propertyObjectSpec = appFunctionDataSpec2.getPropertyObjectSpec(key, value.getQualifiedName())) != null) {
                propertyObjectSpec.validateDataSpecMatches(value);
            }
            this.genericDocumentBuilder.setPropertyDocument(key, value.getGenericDocument());
            if (!value.getExtras().isEmpty()) {
                this.extrasBuilder.putBundle(AppFunctionData.INSTANCE.extrasKey(key), value.getExtras());
            }
            return this;
        }

        public final Builder setAppFunctionDataList(String key, List<AppFunctionData> value) {
            AppFunctionDataSpec propertyObjectSpec;
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, AppFunctionData.class, true, value);
            }
            GenericDocument.Builder<?> builder = this.genericDocumentBuilder;
            List<AppFunctionData> list = value;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((AppFunctionData) it.next()).getGenericDocument());
            }
            int i = 0;
            GenericDocument[] genericDocumentArr = (GenericDocument[]) arrayList.toArray(new GenericDocument[0]);
            builder.setPropertyDocument(key, (GenericDocument[]) Arrays.copyOf(genericDocumentArr, genericDocumentArr.length));
            for (Object obj : list) {
                int i6 = i + 1;
                if (i < 0) {
                    o.X();
                    throw null;
                }
                AppFunctionData appFunctionData = (AppFunctionData) obj;
                AppFunctionDataSpec appFunctionDataSpec2 = this.spec;
                if (appFunctionDataSpec2 != null && (propertyObjectSpec = appFunctionDataSpec2.getPropertyObjectSpec(key, appFunctionData.getQualifiedName())) != null) {
                    propertyObjectSpec.validateDataSpecMatches(appFunctionData);
                }
                if (!appFunctionData.getExtras().isEmpty()) {
                    this.extrasBuilder.putBundle(AppFunctionData.INSTANCE.extrasKey(key, i), appFunctionData.getExtras());
                }
                i = i6;
            }
            return this;
        }

        public final Builder setBoolean(String key, boolean value) {
            k.f(key, "key");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Boolean.TYPE, false, Boolean.valueOf(value));
            }
            this.genericDocumentBuilder.setPropertyBoolean(key, value);
            return this;
        }

        public final Builder setBooleanArray(String key, boolean[] value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Boolean.TYPE, true, value);
            }
            this.genericDocumentBuilder.setPropertyBoolean(key, Arrays.copyOf(value, value.length));
            return this;
        }

        public final Builder setByteArray(String key, byte[] value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Byte.TYPE, true, value);
            }
            this.genericDocumentBuilder.setPropertyBytes(key, value);
            return this;
        }

        public final Builder setDouble(String key, double value) {
            k.f(key, "key");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Double.TYPE, false, Double.valueOf(value));
            }
            this.genericDocumentBuilder.setPropertyDouble(key, value);
            return this;
        }

        public final Builder setDoubleArray(String key, double[] value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Double.TYPE, true, value);
            }
            this.genericDocumentBuilder.setPropertyDouble(key, Arrays.copyOf(value, value.length));
            return this;
        }

        public final Builder setFloat(String key, float value) {
            k.f(key, "key");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Float.TYPE, false, Float.valueOf(value));
            }
            this.genericDocumentBuilder.setPropertyDouble(key, value);
            return this;
        }

        public final Builder setFloatArray(String key, float[] value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Float.TYPE, true, value);
            }
            GenericDocument.Builder<?> builder = this.genericDocumentBuilder;
            r rVar = new r(value, 1);
            ArrayList arrayList = new ArrayList(w.c0(rVar, 10));
            Iterator<E> it = rVar.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(((Number) it.next()).floatValue()));
            }
            int size = arrayList.size();
            double[] dArr = new double[size];
            Iterator it2 = arrayList.iterator();
            int i = 0;
            while (it2.hasNext()) {
                dArr[i] = ((Number) it2.next()).doubleValue();
                i++;
            }
            builder.setPropertyDouble(key, Arrays.copyOf(dArr, size));
            return this;
        }

        public final Builder setInt(String key, int value) {
            k.f(key, "key");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Integer.TYPE, false, Integer.valueOf(value));
            }
            this.genericDocumentBuilder.setPropertyLong(key, value);
            return this;
        }

        public final Builder setIntArray(String key, int[] value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Integer.TYPE, true, value);
            }
            GenericDocument.Builder<?> builder = this.genericDocumentBuilder;
            r rVar = new r(value, 0);
            ArrayList arrayList = new ArrayList(w.c0(rVar, 10));
            Iterator<E> it = rVar.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it.next()).intValue()));
            }
            int size = arrayList.size();
            long[] jArr = new long[size];
            Iterator it2 = arrayList.iterator();
            int i = 0;
            while (it2.hasNext()) {
                jArr[i] = ((Number) it2.next()).longValue();
                i++;
            }
            builder.setPropertyLong(key, Arrays.copyOf(jArr, size));
            return this;
        }

        public final Builder setLong(String key, long value) {
            k.f(key, "key");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Long.TYPE, false, Long.valueOf(value));
            }
            this.genericDocumentBuilder.setPropertyLong(key, value);
            return this;
        }

        public final Builder setLongArray(String key, long[] value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, Long.TYPE, true, value);
            }
            this.genericDocumentBuilder.setPropertyLong(key, Arrays.copyOf(value, value.length));
            return this;
        }

        public final <T extends Parcelable> Builder setParcelable(String key, T value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, value.getClass(), false, value);
            }
            this.extrasBuilder.putParcelable(AppFunctionData.INSTANCE.extrasKey(key), value);
            return this;
        }

        public final <T extends Parcelable> Builder setParcelableList(String key, List<? extends T> value) {
            k.f(key, "key");
            k.f(value, "value");
            k.m();
            throw null;
        }

        public final Builder setString(String key, String value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, String.class, false, value);
            }
            this.genericDocumentBuilder.setPropertyString(key, value);
            if (key.equals(AppFunctionData.LEGACY_ID_FIELD_KEY)) {
                setLegacyId(value);
            }
            return this;
        }

        public final Builder setStringList(String key, List<String> value) {
            k.f(key, "key");
            k.f(value, "value");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, new String().getClass(), true, value);
            }
            GenericDocument.Builder<?> builder = this.genericDocumentBuilder;
            String[] strArr = (String[]) value.toArray(new String[0]);
            builder.setPropertyString(key, (String[]) Arrays.copyOf(strArr, strArr.length));
            return this;
        }

        public final <T extends Parcelable> Builder setParcelableList(String key, List<? extends T> value, Class<T> clazz) {
            k.f(key, "key");
            k.f(value, "value");
            k.f(clazz, "clazz");
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                appFunctionDataSpec.validateWriteRequest(key, clazz, true, value);
            }
            this.extrasBuilder.putParcelableArrayList(AppFunctionData.INSTANCE.extrasKey(key), new ArrayList<>(value));
            return this;
        }

        public /* synthetic */ Builder(String str, String str2, int i, e eVar) {
            this(str, (i & 2) != 0 ? "" : str2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(List<AppFunctionParameterMetadata> parameterMetadataList, AppFunctionComponentsMetadata componentMetadata) {
            this(AppFunctionDataSpec.INSTANCE.create(parameterMetadataList, componentMetadata));
            k.f(parameterMetadataList, "parameterMetadataList");
            k.f(componentMetadata, "componentMetadata");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AppFunctionObjectTypeMetadata objectTypeMetadata, AppFunctionComponentsMetadata componentMetadata) {
            this(AppFunctionDataSpec.INSTANCE.create(objectTypeMetadata, componentMetadata));
            k.f(objectTypeMetadata, "objectTypeMetadata");
            k.f(componentMetadata, "componentMetadata");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AppFunctionAllOfTypeMetadata allOfTypeMetadata, AppFunctionComponentsMetadata componentMetadata) {
            this(AppFunctionDataSpec.INSTANCE.create(allOfTypeMetadata.getPseudoObjectTypeMetadata$appfunctions(componentMetadata), componentMetadata));
            k.f(allOfTypeMetadata, "allOfTypeMetadata");
            k.f(componentMetadata, "componentMetadata");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AppFunctionResponseMetadata responseMetadata, AppFunctionComponentsMetadata componentMetadata) {
            this(AppFunctionDataSpec.INSTANCE.create(responseMetadata, componentMetadata));
            k.f(responseMetadata, "responseMetadata");
            k.f(componentMetadata, "componentMetadata");
        }

        private Builder(AppFunctionDataSpec appFunctionDataSpec) {
            this.extrasBuilder = new Bundle();
            this.spec = appFunctionDataSpec;
            this.qualifiedName = appFunctionDataSpec.getObjectQualifiedName();
            this.genericDocumentBuilder = new GenericDocument.Builder<>("", "", appFunctionDataSpec.getObjectQualifiedName());
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J \u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0018\"\b\b\u0000\u0010\u0015*\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014H\u0002J\u0014\u0010\u001a\u001a\u00020\u000f2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0002J-\u0010\u001b\u001a\u00020\u001c\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0006\u0010\u001d\u001a\u0002H\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014H\u0007¢\u0006\u0002\u0010\u001eJ'\u0010\u001b\u001a\u00020\u001c\"\b\b\u0000\u0010\u0015*\u00020\u00012\u0006\u0010\u001d\u001a\u0002H\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/appfunctions/AppFunctionData$Companion;", "", AppAgent.CONSTRUCT, "()V", "DEFAULT_BOOLEAN", "", "DEFAULT_FLOAT", "", "DEFAULT_DOUBLE", "", "DEFAULT_INT", "", "DEFAULT_LONG", "", "LEGACY_ID_FIELD_KEY", "", "extrasKey", "key", "index", "getSerializableClass", "Ljava/lang/Class;", ExifInterface.GPS_DIRECTION_TRUE, "qualifiedName", "getSerializableFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "serializableClass", "getPackageName", "serialize", "Landroidx/appfunctions/AppFunctionData;", "serializable", "(Ljava/lang/Object;Ljava/lang/Class;)Landroidx/appfunctions/AppFunctionData;", "(Ljava/lang/Object;Ljava/lang/String;)Landroidx/appfunctions/AppFunctionData;", "EMPTY", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String extrasKey(String key) {
            return B7.a.k("property/", key);
        }

        private final String getPackageName(Class<?> serializableClass) {
            n nVar = m.f4928a;
            if (q.K0(new String[]{nVar.b(LocalDateTime.class).m(), nVar.b(Uri.class).m()}).contains(serializableClass.getSimpleName())) {
                return "androidx.appfunctions.internal.serializableproxies";
            }
            String packageName = serializableClass.getPackageName();
            k.e(packageName, "getPackageName(...)");
            return packageName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> Class<T> getSerializableClass(String qualifiedName) {
            try {
                return (Class<T>) Class.forName(qualifiedName);
            } catch (Exception e) {
                Log.d(Constants.APP_FUNCTIONS_TAG, "Unable to find serializable class " + qualifiedName, e);
                throw new IllegalArgumentException(B7.a.k("Unable to find serializable class ", qualifiedName));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> AppFunctionSerializableFactory<T> getSerializableFactory(Class<T> serializableClass) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            String packageName = getPackageName(serializableClass);
            String name = serializableClass.getName();
            try {
                Object objNewInstance = Class.forName(packageName + '.' + B7.a.m("$", j9.m.I0('.', name, name), "Factory")).getDeclaredConstructor(null).newInstance(null);
                k.d(objNewInstance, "null cannot be cast to non-null type androidx.appfunctions.internal.AppFunctionSerializableFactory<T of androidx.appfunctions.AppFunctionData.Companion.getSerializableFactory>");
                return (AppFunctionSerializableFactory) objNewInstance;
            } catch (Exception e) {
                Log.d(Constants.APP_FUNCTIONS_TAG, "Unable to create AppFunctionSerializableFactory for " + serializableClass, e);
                throw new IllegalArgumentException(B7.a.i(serializableClass, "Unable to create AppFunctionSerializableFactory for "));
            }
        }

        public final <T> AppFunctionData serialize(T serializable, Class<T> serializableClass) {
            k.f(serializable, "serializable");
            k.f(serializableClass, "serializableClass");
            try {
                return getSerializableFactory(serializableClass).toAppFunctionData(serializable);
            } catch (Exception e) {
                Log.d(Constants.APP_FUNCTIONS_TAG, "Something went wrong while serialize " + serializable + " of class " + serializableClass, e);
                throw new IllegalArgumentException("Unable to serialize " + serializableClass + ". Is the class annotated with @AppFunctionSerializable?");
            }
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String extrasKey(String key, int index) {
            return "property/" + key + '[' + index + ']';
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final <T> AppFunctionData serialize(T serializable, String qualifiedName) {
            k.f(serializable, "serializable");
            k.f(qualifiedName, "qualifiedName");
            return serialize((Companion) serializable, (Class<Companion>) getSerializableClass(qualifiedName));
        }
    }

    static {
        GenericDocument genericDocumentBuild = new GenericDocument.Builder("", "", "").build();
        k.e(genericDocumentBuild, "build(...)");
        Bundle EMPTY2 = Bundle.EMPTY;
        k.e(EMPTY2, "EMPTY");
        EMPTY = new AppFunctionData(genericDocumentBuild, EMPTY2);
    }

    public AppFunctionData(AppFunctionDataSpec appFunctionDataSpec, GenericDocument genericDocument, Bundle extras) {
        k.f(genericDocument, "genericDocument");
        k.f(extras, "extras");
        this.spec = appFunctionDataSpec;
        this.genericDocument = genericDocument;
        this.extras = extras;
        extras.setClassLoader(AppFunctionData.class.getClassLoader());
        String id = genericDocument.getId();
        k.e(id, "getId(...)");
        this.id = id;
    }

    private final boolean isDoubleWithinFloatRange(double doubleValue) {
        if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
            return true;
        }
        return doubleValue <= 3.4028234663852886E38d && doubleValue >= -3.4028234663852886E38d;
    }

    private final boolean isLongWithinLongRange(long longValue) {
        return longValue >= SieveCacheKt.NodeMetaAndPreviousMask && longValue <= SieveCacheKt.NodeLinkMask;
    }

    public static final <T> AppFunctionData serialize(T t9, Class<T> cls) {
        return INSTANCE.serialize((Companion) t9, (Class<Companion>) cls);
    }

    private final <T> T unsafeGetProperty(String key, Class<T> arrayClass) {
        try {
            Object property = this.genericDocument.getProperty(key);
            if (property != null) {
                return arrayClass.cast(property);
            }
            return null;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(B7.a.m("Found the property under [", key, "] but data type does not match with the request."), e);
        }
    }

    public final boolean containsKey(String key) {
        k.f(key, "key");
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec == null || appFunctionDataSpec.containsMetadata(key)) {
            return key.equals(LEGACY_ID_FIELD_KEY) || this.genericDocument.getProperty(key) != null || this.extras.containsKey(key) || this.extras.containsKey(INSTANCE.extrasKey(key));
        }
        throw new IllegalArgumentException("There is no metadata associated with ".concat(key));
    }

    public final <T> T deserialize(Class<T> serializableClass) {
        k.f(serializableClass, "serializableClass");
        try {
            return (T) INSTANCE.getSerializableFactory(serializableClass).fromAppFunctionData(this);
        } catch (Exception e) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Something went wrong while deserialize " + this + " to " + serializableClass, e);
            throw new IllegalArgumentException("Unable to deserialize " + serializableClass + ". Is the class annotated with @AppFunctionSerializable?");
        }
    }

    public final AppFunctionData getAppFunctionData(String key) {
        k.f(key, "key");
        GenericDocument[] genericDocumentArr = (GenericDocument[]) unsafeGetProperty(key, GenericDocument[].class);
        AppFunctionData appFunctionData = null;
        AppFunctionDataSpec propertyObjectSpec = null;
        appFunctionData = null;
        if (genericDocumentArr != null && genericDocumentArr.length != 0) {
            AppFunctionDataSpec appFunctionDataSpec = this.spec;
            if (appFunctionDataSpec != null) {
                String schemaType = genericDocumentArr[0].getSchemaType();
                k.e(schemaType, "getSchemaType(...)");
                propertyObjectSpec = appFunctionDataSpec.getPropertyObjectSpec(key, schemaType);
            }
            GenericDocument genericDocument = genericDocumentArr[0];
            Bundle bundle = this.extras.getBundle(INSTANCE.extrasKey(key));
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            k.c(bundle);
            appFunctionData = new AppFunctionData(propertyObjectSpec, genericDocument, bundle);
        }
        AppFunctionDataSpec appFunctionDataSpec2 = this.spec;
        if (appFunctionDataSpec2 != null) {
            appFunctionDataSpec2.validateReadRequest(key, AppFunctionData.class, false, appFunctionData);
        }
        return appFunctionData;
    }

    public final List<AppFunctionData> getAppFunctionDataList(String key) {
        AppFunctionDataSpec propertyObjectSpec;
        k.f(key, "key");
        GenericDocument[] genericDocumentArr = (GenericDocument[]) unsafeGetProperty(key, GenericDocument[].class);
        ArrayList arrayList = null;
        if (genericDocumentArr != null) {
            ArrayList arrayList2 = new ArrayList(genericDocumentArr.length);
            int length = genericDocumentArr.length;
            int i = 0;
            int i6 = 0;
            while (i < length) {
                GenericDocument genericDocument = genericDocumentArr[i];
                int i10 = i6 + 1;
                AppFunctionDataSpec appFunctionDataSpec = this.spec;
                if (appFunctionDataSpec != null) {
                    String schemaType = genericDocument.getSchemaType();
                    k.e(schemaType, "getSchemaType(...)");
                    propertyObjectSpec = appFunctionDataSpec.getPropertyObjectSpec(key, schemaType);
                } else {
                    propertyObjectSpec = null;
                }
                Bundle bundle = this.extras.getBundle(INSTANCE.extrasKey(key, i6));
                if (bundle == null) {
                    bundle = Bundle.EMPTY;
                }
                k.c(bundle);
                arrayList2.add(new AppFunctionData(propertyObjectSpec, genericDocument, bundle));
                i++;
                i6 = i10;
            }
            arrayList = arrayList2;
        }
        AppFunctionDataSpec appFunctionDataSpec2 = this.spec;
        if (appFunctionDataSpec2 != null) {
            appFunctionDataSpec2.validateReadRequest(key, AppFunctionData.class, true, arrayList);
        }
        return arrayList;
    }

    public final boolean getBoolean(String key) {
        k.f(key, "key");
        return getBoolean(key, false);
    }

    public final boolean[] getBooleanArray(String key) {
        k.f(key, "key");
        boolean[] zArr = (boolean[]) unsafeGetProperty(key, boolean[].class);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Boolean.TYPE, true, zArr);
        }
        return zArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Boolean getBooleanOrNull(String key) {
        k.f(key, "key");
        boolean[] zArr = (boolean[]) unsafeGetProperty(key, boolean[].class);
        Boolean boolValueOf = (zArr == null || zArr.length == 0) ? null : Boolean.valueOf(zArr[0]);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Boolean.TYPE, false, boolValueOf);
        }
        return boolValueOf;
    }

    public final byte[] getByteArray(String key) {
        k.f(key, "key");
        return getByteArrayOrNull(key);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final byte[] getByteArrayOrNull(String key) {
        k.f(key, "key");
        byte[][] bArr = (byte[][]) unsafeGetProperty(key, byte[][].class);
        byte[] bArr2 = (bArr == null || bArr.length == 0) ? null : bArr[0];
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Byte.TYPE, true, bArr2);
        }
        return bArr2;
    }

    public final double getDouble(String key) {
        k.f(key, "key");
        return getDouble(key, DEFAULT_DOUBLE);
    }

    public final double[] getDoubleArray(String key) {
        k.f(key, "key");
        double[] dArr = (double[]) unsafeGetProperty(key, double[].class);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Double.TYPE, true, dArr);
        }
        return dArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Double getDoubleOrNull(String key) {
        k.f(key, "key");
        double[] dArr = (double[]) unsafeGetProperty(key, double[].class);
        Double dValueOf = (dArr == null || dArr.length == 0) ? null : Double.valueOf(dArr[0]);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Double.TYPE, false, dValueOf);
        }
        return dValueOf;
    }

    /* renamed from: getExtras$appfunctions, reason: from getter */
    public final Bundle getExtras() {
        return this.extras;
    }

    public final float getFloat(String key) {
        k.f(key, "key");
        return getFloat(key, 0.0f);
    }

    public final float[] getFloatArray(String key) {
        float[] fArrD1;
        k.f(key, "key");
        double[] dArr = (double[]) unsafeGetProperty(key, double[].class);
        if (dArr != null) {
            ArrayList arrayList = new ArrayList(dArr.length);
            for (double d : dArr) {
                if (!isDoubleWithinFloatRange(d)) {
                    throw new IllegalStateException(B7.a.m("One of the value associated with ", key, " is not within the range of Float"));
                }
                arrayList.add(Float.valueOf((float) d));
            }
            fArrD1 = v.d1(arrayList);
        } else {
            fArrD1 = null;
        }
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Float.TYPE, true, fArrD1);
        }
        return fArrD1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Float getFloatOrNull(String key) {
        k.f(key, "key");
        double[] dArr = (double[]) unsafeGetProperty(key, double[].class);
        Double dValueOf = (dArr == null || dArr.length == 0) ? null : Double.valueOf(dArr[0]);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Float.TYPE, false, dValueOf);
        }
        if (dValueOf != null && !isDoubleWithinFloatRange(dValueOf.doubleValue())) {
            throw new IllegalStateException(B7.a.m("The value associated with ", key, " is not within the range of Float"));
        }
        if (dValueOf != null) {
            return Float.valueOf((float) dValueOf.doubleValue());
        }
        return null;
    }

    /* renamed from: getGenericDocument$appfunctions, reason: from getter */
    public final GenericDocument getGenericDocument() {
        return this.genericDocument;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getId() {
        return this.id;
    }

    public final int getInt(String key) {
        k.f(key, "key");
        return getInt(key, 0);
    }

    public final int[] getIntArray(String key) {
        int[] iArrE1;
        k.f(key, "key");
        long[] jArr = (long[]) unsafeGetProperty(key, long[].class);
        if (jArr != null) {
            ArrayList arrayList = new ArrayList(jArr.length);
            for (long j5 : jArr) {
                if (!isLongWithinLongRange(j5)) {
                    throw new IllegalStateException(B7.a.m("One of the value associated with ", key, " is not within the range of Int"));
                }
                arrayList.add(Integer.valueOf((int) j5));
            }
            iArrE1 = v.e1(arrayList);
        } else {
            iArrE1 = null;
        }
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Integer.TYPE, true, iArrE1);
        }
        return iArrE1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Integer getIntOrNull(String key) {
        k.f(key, "key");
        long[] jArr = (long[]) unsafeGetProperty(key, long[].class);
        Long lValueOf = (jArr == null || jArr.length == 0) ? null : Long.valueOf(jArr[0]);
        if (lValueOf != null && !isLongWithinLongRange(lValueOf.longValue())) {
            throw new IllegalStateException(B7.a.m("The value associated with ", key, " is not within the range of Int"));
        }
        Integer numValueOf = lValueOf != null ? Integer.valueOf((int) lValueOf.longValue()) : null;
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Integer.TYPE, false, numValueOf);
        }
        return numValueOf;
    }

    public final long getLong(String key) {
        k.f(key, "key");
        return getLong(key, 0L);
    }

    public final long[] getLongArray(String key) {
        k.f(key, "key");
        long[] jArr = (long[]) unsafeGetProperty(key, long[].class);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Long.TYPE, true, jArr);
        }
        return jArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Long getLongOrNull(String key) {
        k.f(key, "key");
        long[] jArr = (long[]) unsafeGetProperty(key, long[].class);
        Long lValueOf = (jArr == null || jArr.length == 0) ? null : Long.valueOf(jArr[0]);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, Long.TYPE, false, lValueOf);
        }
        return lValueOf;
    }

    public final <T extends Parcelable> T getParcelable(String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    public final <T extends Parcelable> List<T> getParcelableList(String key) {
        k.f(key, "key");
        k.m();
        throw null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T extends Parcelable> T getParcelableOrNull(String key, Class<T> clazz) {
        k.f(key, "key");
        k.f(clazz, "clazz");
        T t9 = (T) this.extras.getParcelable(INSTANCE.extrasKey(key), clazz);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, clazz, false, t9);
        }
        return t9;
    }

    public final String getQualifiedName() {
        String schemaType = this.genericDocument.getSchemaType();
        k.e(schemaType, "getSchemaType(...)");
        return schemaType;
    }

    /* renamed from: getSpec$appfunctions, reason: from getter */
    public final AppFunctionDataSpec getSpec() {
        return this.spec;
    }

    public final String getString(String key) {
        k.f(key, "key");
        return getStringOrNull(key);
    }

    public final List<String> getStringList(String key) {
        k.f(key, "key");
        String[] strArr = (String[]) unsafeGetProperty(key, String[].class);
        List<String> listL = strArr != null ? q.L(strArr) : null;
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, String.class, true, listL);
        }
        return listL;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStringOrNull(String key) {
        k.f(key, "key");
        String[] strArr = (String[]) unsafeGetProperty(key, String[].class);
        String str = null;
        if (key.equals(LEGACY_ID_FIELD_KEY)) {
            String str2 = this.id;
            if (str2.length() != 0) {
                str = str2;
            } else if (strArr != null) {
                if (strArr.length == 0) {
                    strArr = null;
                }
                if (strArr != null) {
                    str = strArr[0];
                }
            }
        } else if (strArr != null && strArr.length != 0) {
            str = strArr[0];
        }
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, String.class, false, str);
        }
        return str;
    }

    public final AppFunctionData replaceSpecWith$appfunctions(AppFunctionResponseMetadata responseMetadata, AppFunctionComponentsMetadata componentMetadata) {
        k.f(responseMetadata, "responseMetadata");
        k.f(componentMetadata, "componentMetadata");
        return new AppFunctionData(AppFunctionDataSpec.INSTANCE.create(responseMetadata, componentMetadata), this.genericDocument, this.extras);
    }

    public String toString() {
        return "AppFunctionData(genericDocument=" + this.genericDocument + ", extras=" + this.extras + ')';
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    public final void visitAppFunctionUriGrants(S7.k visitor) {
        AppFunctionUriGrant appFunctionUriGrant;
        k.f(visitor, "visitor");
        if (k.b(getQualifiedName(), AppFunctionUriGrant.class.getCanonicalName())) {
            try {
                appFunctionUriGrant = (AppFunctionUriGrant) deserialize(AppFunctionUriGrant.class);
            } catch (Exception e) {
                Log.d(Constants.APP_FUNCTIONS_TAG, "Unexpected error while visiting AppFunctionUriGrant", e);
                appFunctionUriGrant = null;
            }
            if (appFunctionUriGrant != null) {
                visitor.invoke(appFunctionUriGrant);
            }
        }
        for (String str : this.genericDocument.getPropertyNames()) {
            try {
                k.c(str);
                AppFunctionData appFunctionData = getAppFunctionData(str);
                if (appFunctionData != null) {
                    appFunctionData.visitAppFunctionUriGrants(visitor);
                }
            } catch (Exception unused) {
            }
            try {
                k.c(str);
                List<AppFunctionData> appFunctionDataList = getAppFunctionDataList(str);
                if (appFunctionDataList == null) {
                    appFunctionDataList = EmptyList.f4893a;
                }
                Iterator<AppFunctionData> it = appFunctionDataList.iterator();
                while (it.hasNext()) {
                    it.next().visitAppFunctionUriGrants(visitor);
                }
            } catch (Exception unused2) {
            }
        }
    }

    public final boolean getBoolean(String key, boolean defaultValue) {
        k.f(key, "key");
        Boolean booleanOrNull = getBooleanOrNull(key);
        return booleanOrNull != null ? booleanOrNull.booleanValue() : defaultValue;
    }

    public final double getDouble(String key, double defaultValue) {
        k.f(key, "key");
        Double doubleOrNull = getDoubleOrNull(key);
        return doubleOrNull != null ? doubleOrNull.doubleValue() : defaultValue;
    }

    public final float getFloat(String key, float defaultValue) {
        k.f(key, "key");
        Float floatOrNull = getFloatOrNull(key);
        return floatOrNull != null ? floatOrNull.floatValue() : defaultValue;
    }

    public final int getInt(String key, int defaultValue) {
        k.f(key, "key");
        Integer intOrNull = getIntOrNull(key);
        return intOrNull != null ? intOrNull.intValue() : defaultValue;
    }

    public final long getLong(String key, long defaultValue) {
        k.f(key, "key");
        Long longOrNull = getLongOrNull(key);
        return longOrNull != null ? longOrNull.longValue() : defaultValue;
    }

    public final <T extends Parcelable> T getParcelable(String key, Class<T> clazz) {
        k.f(key, "key");
        k.f(clazz, "clazz");
        return (T) getParcelableOrNull(key, clazz);
    }

    public final <T extends Parcelable> List<T> getParcelableList(String key, Class<T> clazz) {
        k.f(key, "key");
        k.f(clazz, "clazz");
        this.extras.setClassLoader(clazz.getClassLoader());
        ArrayList parcelableArrayList = this.extras.getParcelableArrayList(INSTANCE.extrasKey(key), clazz);
        AppFunctionDataSpec appFunctionDataSpec = this.spec;
        if (appFunctionDataSpec != null) {
            appFunctionDataSpec.validateReadRequest(key, clazz, true, parcelableArrayList);
        }
        if (parcelableArrayList == null) {
            return null;
        }
        if (!parcelableArrayList.isEmpty()) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                if (!clazz.isInstance((Parcelable) it.next())) {
                    return null;
                }
            }
        }
        return parcelableArrayList;
    }

    public final AppFunctionData replaceSpecWith$appfunctions(AppFunctionObjectTypeMetadata objectTypeMetadata, AppFunctionComponentsMetadata componentMetadata) {
        k.f(objectTypeMetadata, "objectTypeMetadata");
        k.f(componentMetadata, "componentMetadata");
        return new AppFunctionData(AppFunctionDataSpec.INSTANCE.create(objectTypeMetadata, componentMetadata), this.genericDocument, this.extras);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionData(GenericDocument genericDocument, Bundle extras) {
        this(null, genericDocument, extras);
        k.f(genericDocument, "genericDocument");
        k.f(extras, "extras");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final <T> T deserialize(String qualifiedName) {
        k.f(qualifiedName, "qualifiedName");
        return (T) deserialize(INSTANCE.getSerializableClass(qualifiedName));
    }

    public final AppFunctionData replaceSpecWith$appfunctions(List<AppFunctionParameterMetadata> parameterMetadata, AppFunctionComponentsMetadata componentMetadata) {
        k.f(parameterMetadata, "parameterMetadata");
        k.f(componentMetadata, "componentMetadata");
        return new AppFunctionData(AppFunctionDataSpec.INSTANCE.create(parameterMetadata, componentMetadata), this.genericDocument, this.extras);
    }
}
