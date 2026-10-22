package androidx.room.util;

import androidx.annotation.IntRange;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0015\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0018\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0017H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001b\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010 \u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u001fH\u0096\u0001¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0096\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u000f2\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010(\u001a\u00020\u00142\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010*\u001a\u00020\u00172\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010,\u001a\u00020\u001a2\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010.\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00100\u001a\u00020\u001f2\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b2\u00103J\u001a\u00104\u001a\u00020\u001f2\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b4\u00101J\u0010\u00105\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b5\u00106J\u001a\u00107\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b7\u00103J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u000408H\u0096\u0001¢\u0006\u0004\b9\u0010:J\u001a\u0010;\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b;\u0010/J\u0010\u0010<\u001a\u00020\u001fH\u0096\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b@\u0010?J\u0010\u0010A\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\bA\u0010?R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010BR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010CR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010DR \u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006H"}, d2 = {"Landroidx/room/util/MappedColumnsSQLiteStatementWrapper;", "Landroidx/sqlite/SQLiteStatement;", "delegate", "", "", "columnNames", "", "mapping", AppAgent.CONSTRUCT, "(Landroidx/sqlite/SQLiteStatement;[Ljava/lang/String;[I)V", HintConstants.AUTOFILL_HINT_NAME, "", "getColumnIndex", "(Ljava/lang/String;)I", "index", "", "value", "LC7/r;", "bindBlob", "(I[B)V", "", "bindDouble", "(ID)V", "", "bindFloat", "(IF)V", "", "bindLong", "(IJ)V", "bindInt", "(II)V", "", "bindBoolean", "(IZ)V", "bindText", "(ILjava/lang/String;)V", "bindNull", "(I)V", "getBlob", "(I)[B", "getDouble", "(I)D", "getFloat", "(I)F", "getLong", "(I)J", "getInt", "(I)I", "getBoolean", "(I)Z", "getText", "(I)Ljava/lang/String;", "isNull", "getColumnCount", "()I", "getColumnName", "", "getColumnNames", "()Ljava/util/List;", "getColumnType", "step", "()Z", "reset", "()V", "clearBindings", "close", "Landroidx/sqlite/SQLiteStatement;", "[Ljava/lang/String;", "[I", "", "columnNameToIndexMap", "Ljava/util/Map;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MappedColumnsSQLiteStatementWrapper implements SQLiteStatement {
    private final Map<String, Integer> columnNameToIndexMap;
    private final String[] columnNames;
    private final SQLiteStatement delegate;
    private final int[] mapping;

    public MappedColumnsSQLiteStatementWrapper(SQLiteStatement delegate, String[] columnNames, int[] mapping) {
        k.f(delegate, "delegate");
        k.f(columnNames, "columnNames");
        k.f(mapping, "mapping");
        this.delegate = delegate;
        this.columnNames = columnNames;
        this.mapping = mapping;
        if (columnNames.length != mapping.length) {
            throw new IllegalArgumentException("Expected columnNames.size == mapping.size");
        }
        MapBuilder mapBuilder = new MapBuilder();
        int length = columnNames.length;
        int i = 0;
        int i6 = 0;
        while (i < length) {
            mapBuilder.put(columnNames[i], Integer.valueOf(this.mapping[i6]));
            i++;
            i6++;
        }
        int columnCount = getColumnCount();
        for (int i10 = 0; i10 < columnCount; i10++) {
            if (!mapBuilder.containsKey(getColumnName(i10))) {
                mapBuilder.put(getColumnName(i10), Integer.valueOf(i10));
            }
        }
        this.columnNameToIndexMap = mapBuilder.b();
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob */
    public void mo7168bindBlob(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, byte[] value) {
        k.f(value, "value");
        this.delegate.mo7168bindBlob(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindBoolean(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, boolean value) {
        this.delegate.bindBoolean(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble */
    public void mo7169bindDouble(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, double value) {
        this.delegate.mo7169bindDouble(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindFloat(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, float value) {
        this.delegate.bindFloat(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void bindInt(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, int value) {
        this.delegate.bindInt(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong */
    public void mo7170bindLong(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, long value) {
        this.delegate.mo7170bindLong(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull */
    public void mo7171bindNull(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index) {
        this.delegate.mo7171bindNull(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText */
    public void mo7172bindText(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID) int index, String value) {
        k.f(value, "value");
        this.delegate.mo7172bindText(index, value);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings */
    public void mo7173clearBindings() {
        this.delegate.mo7173clearBindings();
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public byte[] getBlob(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getBlob(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean getBoolean(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getBoolean(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.delegate.getColumnCount();
    }

    public final int getColumnIndex(String name) {
        k.f(name, "name");
        Integer num = this.columnNameToIndexMap.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getColumnName(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public List<String> getColumnNames() {
        return this.delegate.getColumnNames();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getColumnType(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getDouble(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public float getFloat(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getFloat(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getInt(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getInt(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getLong(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getText(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.getText(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int index) {
        return this.delegate.isNull(index);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.delegate.reset();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        return this.delegate.step();
    }
}
