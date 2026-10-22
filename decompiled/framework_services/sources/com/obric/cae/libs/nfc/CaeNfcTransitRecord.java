package com.obric.cae.libs.nfc;

import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class CaeNfcTransitRecord {
    public static final String EVENT_TYPE_ENTRY = "entry";
    public static final String EVENT_TYPE_EXIT = "exit";
    public static final String EXTRA_RECORD = "com.obric.cae.extra.TRANSIT_RECORD";
    public static final String PAYMENT_METHOD_NFC_TRANSIT_CARD = "nfc_transit_card";
    public static final int SCHEMA_VERSION_1 = 1;
    public static final String TRANSPORT_MODE_BUS = "bus";
    public static final String TRANSPORT_MODE_SUBWAY = "subway";
    public final Bundle a;

    public CaeNfcTransitRecord(Bundle r2) {
        this.a = new Bundle(r2);
    }

    public static CaeNfcTransitRecord fromEventBundle(Bundle r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Bundle r4 = r3.getBundle(EXTRA_RECORD);
        if (r4 != null) goto L8;
        return null;
    L8:
        if (r4.getInt("schema_version", 0) > 0) goto L11;
        return null;
    L11:
        return new CaeNfcTransitRecord(r4);
    }

    public long getAmountFen() {
        return this.a.getLong("amount_fen", -1);
    }

    public long getBalanceFen() {
        return this.a.getLong("balance_fen", -1);
    }

    public String getCardType() {
        return this.a.getString("card_type");
    }

    public String getCityCode() {
        return this.a.getString("city_code");
    }

    public String getCityName() {
        return this.a.getString("city_name");
    }

    public String getCurrency() {
        return this.a.getString("currency");
    }

    public String getEntryGateId() {
        return this.a.getString("entry_gate_id");
    }

    public String getEntryStationCode() {
        return this.a.getString("entry_station_code");
    }

    public String getEntryStationName() {
        return this.a.getString("entry_station_name");
    }

    public long getEntryTimeMs() {
        return this.a.getLong("entry_time_ms", -1);
    }

    public long getEventTimeMs() {
        return this.a.getLong("event_time_ms", -1);
    }

    public String getEventType() {
        return this.a.getString("event_type");
    }

    public String getExitGateId() {
        return this.a.getString("exit_gate_id");
    }

    public String getExitStationCode() {
        return this.a.getString("exit_station_code");
    }

    public String getExitStationName() {
        return this.a.getString("exit_station_name");
    }

    public long getExitTimeMs() {
        return this.a.getLong("exit_time_ms", -1);
    }

    public String getGateId() {
        return this.a.getString("gate_id");
    }

    public String getLineCode() {
        return this.a.getString("line_code");
    }

    public String getLineName() {
        return this.a.getString("line_name");
    }

    public String getParserId() {
        return this.a.getString("parser_id");
    }

    public String getPaymentMethod() {
        return this.a.getString("payment_method");
    }

    public int getSchemaVersion() {
        return this.a.getInt("schema_version", 0);
    }

    public String getStationCode() {
        return this.a.getString("station_code");
    }

    public String getStationName() {
        return this.a.getString("station_name");
    }

    public int getTransactionType() {
        return this.a.getInt("transaction_type", -1);
    }

    public String getTransportMode() {
        return this.a.getString("transport_mode");
    }

    public String getVehicleId() {
        return this.a.getString("vehicle_id");
    }

    public Bundle toBundle() {
        return new Bundle(this.a);
    }
}
