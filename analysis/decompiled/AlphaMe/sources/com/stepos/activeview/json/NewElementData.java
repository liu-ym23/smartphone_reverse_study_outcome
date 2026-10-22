package com.stepos.activeview.json;

import java.util.List;

/* loaded from: classes.dex */
public class NewElementData {
    private Data data;
    private List<Event> events;
    private String id;
    private String type;

    public Data getData() {
        return this.data;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setEvents(List<Event> list) {
        this.events = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
