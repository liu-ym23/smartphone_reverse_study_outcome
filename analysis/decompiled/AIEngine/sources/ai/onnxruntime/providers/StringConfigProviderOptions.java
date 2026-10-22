package ai.onnxruntime.providers;

import ai.onnxruntime.OrtProviderOptions;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
abstract class StringConfigProviderOptions extends OrtProviderOptions {
    protected final Map<String, String> options;

    public StringConfigProviderOptions(long j10) {
        super(j10);
        this.options = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getOptionsString$0(Map.Entry entry) {
        return ((String) entry.getKey()) + "=" + ((String) entry.getValue());
    }

    public abstract void add(long j10, long j11, String str, String str2);

    public void add(String str, String str2) {
        checkClosed();
        Objects.requireNonNull(str, "Key must not be null");
        Objects.requireNonNull(str2, "Value must not be null");
        this.options.put(str, str2);
        add(OrtProviderOptions.getApiHandle(), this.nativeHandle, str, str2);
    }

    public String getOptionsString() {
        return (String) this.options.entrySet().stream().map(new b()).collect(Collectors.joining(";", "", ";"));
    }

    public void parseOptionsString(String str) {
        for (String str2 : str.split(";")) {
            if (!str2.isEmpty() && str2.contains("=")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length != 2 || strArrSplit[0].isEmpty() || strArrSplit[1].isEmpty()) {
                    throw new IllegalArgumentException(a0.a.k("Failed to parse option from string '", str2, "'"));
                }
                add(strArrSplit[0], strArrSplit[1]);
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("(");
        return ai.onnxruntime.a.o(sb2, getOptionsString(), ")");
    }
}
