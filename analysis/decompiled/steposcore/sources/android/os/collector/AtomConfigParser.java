package android.os.collector;

import android.os.collector.CollectdConfigProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AtomConfigParser {
    private static final boolean DEBUG = false;
    private static final String FIELD_ATOM_CONFIGS = "atom_configs";
    private static final String FIELD_ATOM_ID = "atom_id";
    private static final String FIELD_BASE_SAMPLING_RATE = "baseSamplingRate";
    private static final String FIELD_COLLECTION_INTERVAL = "collectionInterval";
    private static final String FIELD_DATA_FRESHNESS_THRESHOLD = "dataFreshnessThreshold";
    private static final String FIELD_DATA_RETENTION_DAYS = "dataRetentionDays";
    private static final String FIELD_DOMAIN = "domain";
    private static final String FIELD_DOMAIN_CONFIGS = "domain_configs";
    private static final String FIELD_ENABLED = "enabled";
    private static final String FIELD_PRIVACY_LEVEL = "privacyLevel";
    private static final String TAG = "AtomConfigParser";

    public static CollectdConfigProto.CollectorConfig parseFromString(String jsonString) throws JSONException {
        JSONObject json = new JSONObject(jsonString);
        return parseCollectorConfig(json);
    }

    public static CollectdConfigProto.CollectorConfig parseFromStream(InputStream inputStream) throws JSONException, IOException {
        String jsonString = readStream(inputStream);
        return parseFromString(jsonString);
    }

    private static CollectdConfigProto.CollectorConfig parseCollectorConfig(JSONObject json) throws JSONException {
        CollectdConfigProto.CollectorConfig.Builder builder = CollectdConfigProto.CollectorConfig.newBuilder();
        builder.setId(0L);
        if (json.has(FIELD_DOMAIN_CONFIGS) && !json.isNull(FIELD_DOMAIN_CONFIGS)) {
            parseDomainConfigs(builder, json);
        }
        return builder.build();
    }

    private static void parseDomainConfigs(CollectdConfigProto.CollectorConfig.Builder builder, JSONObject json) throws JSONException {
        if (!json.has(FIELD_DOMAIN_CONFIGS) || json.isNull(FIELD_DOMAIN_CONFIGS)) {
            return;
        }
        JSONArray array = json.getJSONArray(FIELD_DOMAIN_CONFIGS);
        for (int i = 0; i < array.length(); i++) {
            JSONObject domainConfigJson = array.getJSONObject(i);
            CollectdConfigProto.DomainConfig domainConfig = parseDomainConfig(domainConfigJson);
            builder.addDomainConfigs(domainConfig);
        }
    }

    private static CollectdConfigProto.DomainConfig parseDomainConfig(JSONObject json) throws JSONException {
        CollectdConfigProto.DomainConfig.Builder builder = CollectdConfigProto.DomainConfig.newBuilder();
        if (!json.has(FIELD_DOMAIN) || json.isNull(FIELD_DOMAIN)) {
            throw new JSONException("Missing required field: domain");
        }
        String domainStr = json.getString(FIELD_DOMAIN);
        builder.setDomain(parseStepOSDomain(domainStr));
        if (!json.has(FIELD_ENABLED)) {
            throw new JSONException("Missing required field: enabled");
        }
        builder.setEnabled(json.getBoolean(FIELD_ENABLED));
        if (!json.has(FIELD_DATA_RETENTION_DAYS)) {
            throw new JSONException("Missing required field: dataRetentionDays");
        }
        builder.setDataRetentionDays(json.getInt(FIELD_DATA_RETENTION_DAYS));
        if (!json.has(FIELD_PRIVACY_LEVEL)) {
            throw new JSONException("Missing required field: privacyLevel");
        }
        String privacyLevelStr = json.getString(FIELD_PRIVACY_LEVEL);
        CollectdConfigProto.PrivacyLevel privacyLevel = parsePrivacyLevel(privacyLevelStr);
        builder.setPrivacyLevel(privacyLevel);
        if (json.has(FIELD_DATA_FRESHNESS_THRESHOLD) && !json.isNull(FIELD_DATA_FRESHNESS_THRESHOLD)) {
            builder.setDataFreshnessThresholdMs(json.getLong(FIELD_DATA_FRESHNESS_THRESHOLD));
        }
        if (json.has(FIELD_ATOM_CONFIGS) && !json.isNull(FIELD_ATOM_CONFIGS)) {
            parseAtomConfigs(builder, json);
        }
        return builder.build();
    }

    private static void parseAtomConfigs(CollectdConfigProto.DomainConfig.Builder builder, JSONObject json) throws JSONException {
        if (!json.has(FIELD_ATOM_CONFIGS) || json.isNull(FIELD_ATOM_CONFIGS)) {
            return;
        }
        JSONArray array = json.getJSONArray(FIELD_ATOM_CONFIGS);
        for (int i = 0; i < array.length(); i++) {
            JSONObject atomConfigJson = array.getJSONObject(i);
            CollectdConfigProto.AtomConfig atomConfig = parseAtomConfig(atomConfigJson);
            builder.addAtomConfigs(atomConfig);
        }
    }

    private static CollectdConfigProto.AtomConfig parseAtomConfig(JSONObject json) throws JSONException {
        CollectdConfigProto.AtomConfig.Builder builder = CollectdConfigProto.AtomConfig.newBuilder();
        if (!json.has(FIELD_ATOM_ID)) {
            throw new JSONException("Missing required field: atom_id");
        }
        int atomId = parseAtomId(json.get(FIELD_ATOM_ID));
        builder.setAtomId(atomId);
        if (json.has(FIELD_ENABLED) && !json.isNull(FIELD_ENABLED)) {
            builder.setEnabled(json.getBoolean(FIELD_ENABLED));
        }
        if (json.has(FIELD_BASE_SAMPLING_RATE) && !json.isNull(FIELD_BASE_SAMPLING_RATE)) {
            builder.setBaseSamplingRate(json.getDouble(FIELD_BASE_SAMPLING_RATE));
        }
        if (json.has(FIELD_COLLECTION_INTERVAL) && !json.isNull(FIELD_COLLECTION_INTERVAL)) {
            builder.setCollectionIntervalMs(json.getLong(FIELD_COLLECTION_INTERVAL));
        }
        if (json.has(FIELD_DATA_FRESHNESS_THRESHOLD) && !json.isNull(FIELD_DATA_FRESHNESS_THRESHOLD)) {
            builder.setDataFreshnessThresholdMs(json.getLong(FIELD_DATA_FRESHNESS_THRESHOLD));
        }
        if (json.has(FIELD_DATA_RETENTION_DAYS) && !json.isNull(FIELD_DATA_RETENTION_DAYS)) {
            builder.setDataRetentionDays(json.getInt(FIELD_DATA_RETENTION_DAYS));
        }
        if (json.has(FIELD_PRIVACY_LEVEL) && !json.isNull(FIELD_PRIVACY_LEVEL)) {
            String privacyLevelStr = json.getString(FIELD_PRIVACY_LEVEL);
            CollectdConfigProto.PrivacyLevel privacyLevel = parsePrivacyLevel(privacyLevelStr);
            builder.setPrivacyLevel(privacyLevel);
        }
        return builder.build();
    }

    private static CollectdConfigProto.StepOSDomain parseStepOSDomain(String value) throws JSONException {
        if (value == null || value.isEmpty()) {
            throw new JSONException("Missing StepOSDomain value");
        }
        try {
            return CollectdConfigProto.StepOSDomain.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new JSONException("Unknown StepOSDomain value: " + value + " (valid: DEVICE/SYSTEM/USER/INTENTION/SENSOR/SCENE)");
        }
    }

    private static CollectdConfigProto.PrivacyLevel parsePrivacyLevel(String value) {
        if (value == null || value.isEmpty()) {
            return CollectdConfigProto.PrivacyLevel.PRIVACY_LEVEL_UNSPECIFIED;
        }
        try {
            return CollectdConfigProto.PrivacyLevel.valueOf(value);
        } catch (IllegalArgumentException e) {
            return CollectdConfigProto.PrivacyLevel.PRIVACY_LEVEL_UNSPECIFIED;
        }
    }

    private static int parseAtomId(Object raw) throws JSONException {
        if (raw instanceof Number) {
            return ((Number) raw).intValue();
        }
        try {
            return Integer.decode(raw.toString().trim()).intValue();
        } catch (NumberFormatException e) {
            throw new JSONException("Invalid atom_id value: '" + raw + "'. Expected decimal integer or hex string (e.g. \"0x40000002\").");
        }
    }

    private static String readStream(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[8192];
        while (true) {
            int bytesRead = inputStream.read(buffer);
            if (bytesRead != -1) {
                sb.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
            } else {
                return sb.toString();
            }
        }
    }
}
