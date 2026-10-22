package com.stepos.minor.state;

/* loaded from: classes.dex */
public class MinorStateEntity {
    public static final String COLUMN_SETUP_STATE = "state";
    public static final String TABLE_NAME = "minor_state_entity";
    public long id = 1;
    public int state;

    public MinorStateEntity(int i5) {
        this.state = i5;
    }
}
