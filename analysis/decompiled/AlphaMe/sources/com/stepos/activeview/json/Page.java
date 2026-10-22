package com.stepos.activeview.json;

import java.util.List;

/* loaded from: classes.dex */
public class Page {
    private boolean autoPlay;
    private List<CustomEvent> customEvents;
    private int duration;
    private List<Element> elements;
    private List<Event> events;
    private String playMode;
    private Style style;

    public List<CustomEvent> getCustomEvents() {
        return this.customEvents;
    }

    public int getDuration() {
        return this.duration;
    }

    public List<Element> getElements() {
        return this.elements;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public String getPlayMode() {
        return this.playMode;
    }

    public Style getStyle() {
        return this.style;
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public void setAutoPlay(boolean z4) {
        this.autoPlay = z4;
    }

    public void setCustomEvents(List<CustomEvent> list) {
        this.customEvents = list;
    }

    public void setDuration(int i4) {
        this.duration = i4;
    }

    public void setElements(List<Element> list) {
        this.elements = list;
    }

    public void setEvents(List<Event> list) {
        this.events = list;
    }

    public void setPlayMode(String str) {
        this.playMode = str;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
