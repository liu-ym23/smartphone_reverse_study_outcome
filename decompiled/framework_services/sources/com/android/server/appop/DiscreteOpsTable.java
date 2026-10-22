package com.android.server.appop;

/* JADX INFO: loaded from: classes.dex */
final class DiscreteOpsTable {
    static final int ACCESS_DURATION_INDEX = 7;
    static final int ACCESS_TIME_INDEX = 6;
    static final int ATTRIBUTION_FLAGS_INDEX = 10;
    static final int ATTRIBUTION_TAG_INDEX = 5;
    static final int CHAIN_ID_INDEX = 11;
    static final String CREATE_INDEX_SQL = "CREATE INDEX IF NOT EXISTS app_op_access_index ON app_op_accesses (access_time, uid, op_code)";
    static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS app_op_accesses(id INTEGER PRIMARY KEY,uid INTEGER,package_name TEXT,device_id TEXT NOT NULL,op_code INTEGER,attribution_tag TEXT,access_time INTEGER,access_duration INTEGER,uid_state INTEGER,op_flags INTEGER,attribution_flags INTEGER,chain_id INTEGER)";
    static final String DELETE_DATA_FOR_UID_PACKAGE = "DELETE FROM app_op_accesses WHERE uid = ? AND package_name = ?";
    static final String DELETE_TABLE_DATA = "DELETE FROM app_op_accesses";
    static final String DELETE_TABLE_DATA_BEFORE_ACCESS_TIME = "DELETE FROM app_op_accesses WHERE access_time < ?";
    static final int DEVICE_ID_INDEX = 3;
    private static final String INDEX_APP_OP = "app_op_access_index";
    static final String INSERT_TABLE_SQL = "INSERT INTO app_op_accesses(uid, package_name, device_id, op_code, attribution_tag, access_time, access_duration, uid_state, op_flags, attribution_flags, chain_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    static final String OFFSET_ACCESS_TIME = "UPDATE app_op_accesses SET access_time = ACCESS_TIME - ?";
    static final int OP_CODE_INDEX = 4;
    static final int OP_FLAGS_INDEX = 9;
    static final int PACKAGE_NAME_INDEX = 2;
    static final String SELECT_MAX_ATTRIBUTION_CHAIN_ID = "SELECT MAX(chain_id) FROM app_op_accesses";
    static final String SELECT_TABLE_DATA = "SELECT DISTINCT uid,package_name,device_id,op_code,attribution_tag,access_time,access_duration,uid_state,op_flags,attribution_flags,chain_id FROM app_op_accesses";
    private static final String TABLE_NAME = "app_op_accesses";
    static final int UID_INDEX = 1;
    static final int UID_STATE_INDEX = 8;

    static final class Columns {
        static final String ACCESS_DURATION = "access_duration";
        static final String ACCESS_TIME = "access_time";
        static final String ATTRIBUTION_FLAGS = "attribution_flags";
        static final String ATTRIBUTION_TAG = "attribution_tag";
        static final String CHAIN_ID = "chain_id";
        static final String DEVICE_ID = "device_id";
        static final String ID = "id";
        static final String OP_CODE = "op_code";
        static final String OP_FLAGS = "op_flags";
        static final String PACKAGE_NAME = "package_name";
        static final String UID = "uid";
        static final String UID_STATE = "uid_state";

        Columns() {
        }
    }

    DiscreteOpsTable() {
    }
}
