package com.baidu.naviapi.open;

import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class MsgBean {
    private int code;
    private int currentToOrigin;
    private int mmDirection;
    private MmLocation mmLocation;
    private String msg;
    private List<Routes> routes;
    private String sessionId;

    public static class MmLocation {
        private Double lat;
        private Double lng;

        public String toString() {
            return "MmLocationDTO{lng=" + this.lng + ", lat=" + this.lat + '}';
        }

        public MmLocation() {
        }

        public Double getLat() {
            return this.lat;
        }

        public Double getLng() {
            return this.lng;
        }

        public void setLat(Double r100) {
            this.lat = r100;
        }

        public void setLng(Double r100) {
            this.lng = r100;
        }
    }

    public static class Routes {
        private int distance;
        private int duration;
        private String routeId;
        private List<VerbalInstructions> verbalInstructions;
        private List<VisualInstructions> visualInstructions;

        public static class VerbalInstructions {
            private List<Details> details;
            private int distanceToOrigin;
            private String roadName;

            public static class Details {
                private int distanceToGdpt;
                private int distanceToSpeakpt;
                private boolean isSent;
                private String speakText;
                private int voiceLevel;

                public String toString() {
                    return "DetailsDTO{speakText='" + this.speakText + "', distanceToSpeakpt=" + this.distanceToSpeakpt + ", distanceToGdpt=" + this.distanceToGdpt + ", voiceLevel=" + this.voiceLevel + ", isSent='" + this.isSent + "'}";
                }

                public Details() {
                }

                public int getDistanceToGdpt() {
                    return this.distanceToGdpt;
                }

                public int getDistanceToSpeakpt() {
                    return this.distanceToSpeakpt;
                }

                public String getSpeakText() {
                    return this.speakText;
                }

                public int getVoiceLevel() {
                    return this.voiceLevel;
                }

                public boolean isSent() {
                    return this.isSent;
                }

                public void setDistanceToGdpt(int r100) {
                    this.distanceToGdpt = r100;
                }

                public void setDistanceToSpeakpt(int r100) {
                    this.distanceToSpeakpt = r100;
                }

                public void setSent(boolean r100) {
                    this.isSent = r100;
                }

                public void setSpeakText(String r100) {
                    this.speakText = r100;
                }

                public void setVoiceLevel(int r100) {
                    this.voiceLevel = r100;
                }
            }

            public String toString() {
                return "VerbalInstructionsDTO{distanceToOrigin=" + this.distanceToOrigin + ", roadName='" + this.roadName + "', details=" + this.details + '}';
            }

            public VerbalInstructions() {
            }

            public List<Details> getDetails() {
                return this.details;
            }

            public int getDistanceToOrigin() {
                return this.distanceToOrigin;
            }

            public String getRoadName() {
                return this.roadName;
            }

            public void setDetails(List<Details> r100) {
                this.details = r100;
            }

            public void setDistanceToOrigin(int r100) {
                this.distanceToOrigin = r100;
            }

            public void setRoadName(String r100) {
                this.roadName = r100;
            }
        }

        public static class VisualInstructions {
            private int distanceToCurrent;
            private int distanceToOrigin;
            private LocInfo.Point position;
            private TurnDescription turnDescription;

            public static class TurnDescription {
                private int turnKind;
                private String turnRoadName;

                public String toString() {
                    return "TurnDescriptionDTO{turnKind=" + this.turnKind + ", turnRoadName='" + this.turnRoadName + "'}";
                }

                public TurnDescription() {
                }

                public int getTurnKind() {
                    return this.turnKind;
                }

                public String getTurnRoadName() {
                    return this.turnRoadName;
                }

                public void setTurnKind(int r100) {
                    this.turnKind = r100;
                }

                public void setTurnRoadName(String r100) {
                    this.turnRoadName = r100;
                }
            }

            public String toString() {
                return "VisualInstructionsDTO{distanceToOrigin=" + this.distanceToOrigin + ", position='" + this.position + "', turnDescription=" + this.turnDescription + '}';
            }

            public VisualInstructions() {
            }

            public int getDistanceToCurrent() {
                return this.distanceToCurrent;
            }

            public int getDistanceToOrigin() {
                return this.distanceToOrigin;
            }

            public LocInfo.Point getPosition() {
                return this.position;
            }

            public TurnDescription getTurnDescription() {
                return this.turnDescription;
            }

            public void setDistanceToCurrent(int r100) {
                this.distanceToCurrent = r100;
            }

            public void setDistanceToOrigin(int r100) {
                this.distanceToOrigin = r100;
            }

            public void setPosition(LocInfo.Point r100) {
                this.position = r100;
            }

            public void setTurnDescription(TurnDescription r100) {
                this.turnDescription = r100;
            }
        }

        public String toString() {
            return "RoutesDTO{routeId='" + this.routeId + "', distance=" + this.distance + ", duration=" + this.duration + ", visualInstructions=" + this.visualInstructions + ", verbalInstructions=" + this.verbalInstructions + '}';
        }

        public Routes() {
        }

        public int getDistance() {
            return this.distance;
        }

        public int getDuration() {
            return this.duration;
        }

        public String getRouteId() {
            return this.routeId;
        }

        public List<VerbalInstructions> getVerbalInstructions() {
            return this.verbalInstructions;
        }

        public List<VisualInstructions> getVisualInstructions() {
            return this.visualInstructions;
        }

        public void setDistance(int r100) {
            this.distance = r100;
        }

        public void setDuration(int r100) {
            this.duration = r100;
        }

        public void setRouteId(String r100) {
            this.routeId = r100;
        }

        public void setVerbalInstructions(List<VerbalInstructions> r100) {
            this.verbalInstructions = r100;
        }

        public void setVisualInstructions(List<VisualInstructions> r100) {
            this.visualInstructions = r100;
        }
    }

    public String toString() {
        return "ResultDTO{sessionId='" + this.sessionId + "'msg='" + this.msg + "'code='" + this.code + "', mmLocation=" + this.mmLocation + ", currentToOrigin=" + this.currentToOrigin + ", mmDirection=" + this.mmDirection + ", routes=" + this.routes + '}';
    }

    public MsgBean() {
    }

    public int getCode() {
        return this.code;
    }

    public int getCurrentToOrigin() {
        return this.currentToOrigin;
    }

    public int getMmDirection() {
        return this.mmDirection;
    }

    public MmLocation getMmLocation() {
        return this.mmLocation;
    }

    public String getMsg() {
        return this.msg;
    }

    public List<Routes> getRoutes() {
        return this.routes;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setCurrentToOrigin(int r100) {
        this.currentToOrigin = r100;
    }

    public void setMmDirection(int r100) {
        this.mmDirection = r100;
    }

    public void setMmLocation(MmLocation r100) {
        this.mmLocation = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }

    public void setRoutes(List<Routes> r100) {
        this.routes = r100;
    }

    public void setSessionId(String r100) {
        this.sessionId = r100;
    }
}
