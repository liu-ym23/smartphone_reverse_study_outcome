package io.requery.android.database.sqlite;

/* loaded from: classes4.dex */
class SQLiteStatementType {
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_OTHER = 99;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_UPDATE = 2;

    private SQLiteStatementType() {
    }

    public static int getSqlStatementType(String str) {
        String strTrim = str.trim();
        if (strTrim.length() < 3) {
            return 99;
        }
        String strSubstring = strTrim.substring(0, 3);
        if (strSubstring.equalsIgnoreCase("SEL") || strSubstring.equalsIgnoreCase("WIT")) {
            return 1;
        }
        if (strSubstring.equalsIgnoreCase("INS") || strSubstring.equalsIgnoreCase("UPD") || strSubstring.equalsIgnoreCase("REP") || strSubstring.equalsIgnoreCase("DEL")) {
            return 2;
        }
        if (strSubstring.equalsIgnoreCase("ATT")) {
            return 3;
        }
        if (strSubstring.equalsIgnoreCase("COM") || strSubstring.equalsIgnoreCase("END")) {
            return 5;
        }
        if (strSubstring.equalsIgnoreCase("ROL")) {
            return 6;
        }
        if (strSubstring.equalsIgnoreCase("BEG")) {
            return 4;
        }
        if (strSubstring.equalsIgnoreCase("PRA")) {
            return 7;
        }
        if (strSubstring.equalsIgnoreCase("CRE") || strSubstring.equalsIgnoreCase("DRO") || strSubstring.equalsIgnoreCase("ALT")) {
            return 8;
        }
        return (strSubstring.equalsIgnoreCase("ANA") || strSubstring.equalsIgnoreCase("DET")) ? 9 : 99;
    }
}
